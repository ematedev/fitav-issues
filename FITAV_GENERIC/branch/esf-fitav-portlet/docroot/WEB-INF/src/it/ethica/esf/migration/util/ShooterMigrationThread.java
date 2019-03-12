
package it.ethica.esf.migration.util;

import it.ethica.esf.NoSuchCardException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalService;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

public class ShooterMigrationThread implements Runnable {

	private static Log _log =
		LogFactoryUtil.getLog(ShooterMigrationThread.class);
	private String jdbc = "";
	private String dbUrl = "";
	private String user = "";
	private String pass = "";
	private String selectShooter = "";
	private String selectCard = "";
	private String findLastCard = "";
	private int annoRif=2017;
	private int countDue=0;
	
	private ServiceContext serviceContext;

	public void run() {

		List<String> errorList = new ArrayList<String>();
		long totMailNull = 1;
		long totElement = 1;
		Statement stat = null;
		Connection connection = null;
		
		try {
			// stabilisce la connessione
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrl, user, pass);

			// interrogazone del db
			stat = connection.createStatement();
			_log.info("Start shooter import");
			ResultSet res = stat.executeQuery(selectShooter);
			int count = 0;
			long esfStateId = ESFKeys.ESFStateType.ENABLE;
			
			while (res.next()) {
				count ++;
				_log.info ("COUNT-->"+count);
				if(count>1506)
					_log.info ("COUNT-->"+count);
					
				String code = res.getString("Codice").trim();
				long codeUs = new Long(code);
				
				ESFUser userTest=null;
				try{
					 userTest=ESFUserLocalServiceUtil.getESFUserByUserCode(codeUs);
				}catch (Exception ex) {
					_log.info ("Utente non presente "+codeUs);
				}
				if(Validator.isNull(userTest) || userTest.getEsfUserId()==0){
				
					String[] cognome_nome = res.getString("Cognome_Nome").trim().split(StringPool.SPACE);
					String[] cogn_nome = MigrationShooterUtil.getCognome_Nome(cognome_nome);
					String lastName = cogn_nome[0];
					String firstName = cogn_nome[1];
					String street = res.getString("Indirizzo") != null ? res.getString("Indirizzo").trim()
							: StringPool.BLANK;
					String zip = res.getString("Cap") != null ? res.getString("Cap").trim() : StringPool.BLANK;
					String city = res.getString("Localita") != null ? res.getString("Localita").trim()
							: StringPool.BLANK;
					String province = res.getString("Provincia") != null ? res.getString("Provincia").trim()
							: StringPool.BLANK;
					String genderString = res.getString("Sesso").trim();
					String jobTitle = res.getString("Professione") != null ? res.getString("Professione").trim()
							: StringPool.BLANK;
					String birth_date = res.getString("Data_Nascita").trim();
					String birthcity = res.getString("Luogo_Nascita") != null ? res.getString("Luogo_Nascita").trim()
							: StringPool.BLANK;
					// gestione numeri telefono
					String tel1_prefisso = res.getString("Tel1_Prefisso") != null
							? res.getString("Tel1_Prefisso").trim() : StringPool.BLANK;
					String tel1_numero = res.getString("Tel1_Numero") != null ? res.getString("Tel1_Numero").trim()
							: StringPool.BLANK;
					String tel1 = tel1_prefisso + tel1_numero;
					String tel2_prefisso = res.getString("Tel2_Prefisso") != null
							? res.getString("Tel2_Prefisso").trim() : StringPool.BLANK;
					String tel2_numero = res.getString("Tel2_Numero") != null ? res.getString("Tel2_Numero").trim()
							: StringPool.BLANK;
					String tel2 = tel2_prefisso + tel2_numero;
					String tel3_prefisso = res.getString("Tel3_Prefisso") != null
							? res.getString("Tel3_Prefisso").trim() : StringPool.BLANK;
					String tel3_numero = res.getString("Tel3_Numero") != null ? res.getString("Tel3_Numero").trim()
							: StringPool.BLANK;
					String tel3 = tel3_prefisso + tel3_numero;
					String fax_prefisso = res.getString("fax_Prefisso") != null ? res.getString("fax_Prefisso").trim()
							: StringPool.BLANK;
					String fax_numero = res.getString("fax_Numero") != null ? res.getString("fax_Numero").trim()
							: StringPool.BLANK;
					String fax = fax_prefisso + fax_numero;
					// end gestione numeri telefono
					String userEmail = res.getString("EMail") != null ? res.getString("EMail").trim()
							: StringPool.BLANK;

					String nationality = "IT";
				
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date date = format.parse(birth_date);
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					int birthYear = cal.get(Calendar.YEAR);
					int birthMonth = cal.get(Calendar.MONTH);
					int birthDay = cal.get(Calendar.DAY_OF_MONTH);
			
					boolean gender = true;
					if (genderString.equalsIgnoreCase("f"))
						gender = false;
	
					if (Validator.isNull(userEmail) ||
						userEmail.trim().equals(StringPool.BLANK)
						|| !userEmail.contains("@"))
						userEmail = "test-" + (totMailNull++) + "@fitav.it";
					else
						userEmail = sanitizeMail(userEmail);

					List<ESFPhone> phones = getListPhone(tel1, tel2, tel3, fax);
	
					List<ESFAddress> addresses = new ArrayList<ESFAddress>();
					ESFAddress esfAddress =
						ESFAddressLocalServiceUtil.createESFAddress(0);
					esfAddress.setWrapper(true);
					esfAddress.setEsfAddressId(0);
					esfAddress.setLongitude(0);
					esfAddress.setLatitude(0);
					esfAddress.setEsfCountryId("IT");
	
					esfAddress.setEsfRegionId(ManageAddress.getRegionIdFromProvince(
						connection, province));
					esfAddress.setEsfCityId(ManageAddress.getCityId(city));
					esfAddress.setEsfProvinceId(province);
					esfAddress.setStreet1(street);
					esfAddress.setStreet2(null);
					esfAddress.setStreet3(null);
					esfAddress.setZip(zip);
					esfAddress.setTypeId(12000);
					esfAddress.setMailing(false);
					esfAddress.setPrimary_(false);
					esfAddress.setListTypeId(ESFKeys.ESFAddressType.CORRISPONDENCE);
					addresses.add(esfAddress);

					ESFEntityState esfEntityState =
						ESFEntityStateLocalServiceUtil.addEntityState(
							serviceContext.getUserId(), ESFUser.class.getName(), 0,
							esfStateId, serviceContext);

					try {
						
						List<ESFCard> esfCards =
							assignCard(code, 10198, connection, serviceContext);
						if (esfCards.size()>0){
							ESFUser userResult =
								ESFUserLocalServiceUtil.addESFShooter(
									serviceContext.getUserId(), StringPool.BLANK,
									firstName, StringPool.BLANK, lastName, userEmail,
									StringPool.BLANK, birthDay,
									birthMonth,
									birthYear, birthcity,
									nationality, gender, "", "", "", 0,false, "",jobTitle,"",
									esfEntityState, esfCards.get(0), addresses, phones,
									serviceContext);
						
							if (Validator.isNotNull(userResult) &&
									userResult.getEsfUserId() > 0) {
								esfEntityState.setClassPK(userResult.getEsfUserId());
								ESFEntityStateLocalServiceUtil.updateESFEntityState(esfEntityState);
								assignOtherCard(esfCards, userResult.getEsfUserId());
								long codeUser = Long.parseLong(code);
								userResult.setCodeUser(codeUser);
								String fiscalCode = res.getString("Codice_Fiscale") != null ?
									res.getString("Codice_Fiscale").trim() : 
										StringPool.BLANK;
								userResult.setFiscalCode(fiscalCode);
								ESFUserLocalServiceUtil.updateESFUser(userResult);
							}
						}
						else {
	                	   errorList.add("&&&&&&&&&>>>>>>>> Errore Esfcards --->Dati " + code + " " +
	       						lastName + " " + firstName + " " + street + " " + zip +
	       						" " + city + " " + province + " " + genderString + " " +
	       						jobTitle + " " + birth_date + " " + birthcity + " " +
	       						tel1 + " " + tel2 + " " + tel3 + " " + fax + " " +
	       						userEmail +" ---" ) ;
	                   }
						_log.info("Processed element " + totElement++);
					   
					}catch (Exception e) {
						
						errorList.add("&&&&&&&&&>>>>>>>> Dati " + code + " " +
							lastName + " " + firstName + " " + street + " " + zip +
							" " + city + " " + province + " " + genderString + " " +
							jobTitle + " " + birth_date + " " + birthcity + " " +
							tel1 + " " + tel2 + " " + tel3 + " " + fax + " " +
							userEmail + " " + e.getMessage() + " " + e.toString());
						//e.printStackTrace();
					}
				_log.info("End shooter import --->end count:"+count);
				}
				else{
					boolean finded=false;
					int stateIntId=1;
					//_log.info("Start to find cards for "+userTest.getEsfUserId());
					List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByU_S(userTest.getEsfUserId(), stateIntId);
					//List<ESFEntityState> states= ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(ESFCard.class.getName(),esfStateId);
					//_log.info("Start set cars "+cards.size());
					for (ESFCard card : cards) {
						ESFEntityState esfEntityState=ESFEntityStateLocalServiceUtil.findAllESFEntityStateByClassName_ClassPK(ESFCard.class.getName(), card.getEsfCardId());
						if(Validator.isNull(esfEntityState.getEndDate())  && esfEntityState.getStartDate().getYear()< annoRif  ){
								Date datefine=new Date();
								datefine.setDate(31);
								datefine.setMonth(11);
								datefine.setYear(esfEntityState.getStartDate().getYear());
								esfEntityState.setEndDate(datefine);
								ESFEntityStateLocalServiceUtil.updateESFEntityState(esfEntityState);
						}else if(Validator.isNull(esfEntityState.getEndDate()) && esfEntityState.getStartDate().getYear()== annoRif ){
							finded=true;
						}
					}
					//_log.info("Start end for and setfind "+finded);
					if(!finded){
						//ESFEntityState esfEntityState =
						//		ESFEntityStateLocalServiceUtil.addEntityState(
						//			serviceContext.getUserId(), ESFUser.class.getName(), userTest.getEsfUserId(),
						//			esfStateId, serviceContext);
						//esfEntityState.setStartDate(new Date());
						//ESFEntityStateLocalServiceUtil.updateESFEntityState(esfEntityState);
						assignLastCard(userTest.getEsfUserId(),connection);
					}
										
				}
			}
            
		}
		catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		catch (ClassNotFoundException classN) {
			classN.printStackTrace();
		}
		catch (Exception classN) {
			classN.printStackTrace();
		}
		finally { // chiude Statement e Connection
			try {
				if (stat != null)
					stat.close();
				if (connection != null)
					connection.close();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		_log.info("countDue " + countDue);
		
		_log.info("Errori " + errorList.size());
		for (String error : errorList) {

			_log.info(error);
		}

	}

	private List<ESFPhone> getListPhone(
		String phoneNumber1, String phoneNumber2, String phoneNumber3,
		String faxNumber) {

		List<ESFPhone> phones = new ArrayList<ESFPhone>();

		ESFPhone phone = null;
		if (Validator.isNotNull(phoneNumber1)) {
			phoneNumber1 = convertPhone(phoneNumber1);
			phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
			phone.setNumber(phoneNumber1);
			phone.setListTypeId(ESFKeys.ESFPhoneListType.BUSINESS);
			phone.setTypeId(12008);
			phones.add(phone);
		}

		if (Validator.isNotNull(phoneNumber2)) {
			phoneNumber2 = convertPhone(phoneNumber2);
			phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
			phone.setNumber(phoneNumber2);
			phone.setListTypeId(ESFKeys.ESFPhoneListType.MOBILE);
			phone.setTypeId(12008);
			phones.add(phone);
		}

		if (Validator.isNotNull(phoneNumber3)) {
			phoneNumber3 = convertPhone(phoneNumber3);
			phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
			phone.setNumber(phoneNumber3);
			phone.setListTypeId(ESFKeys.ESFPhoneListType.PERSONAL);
			phone.setTypeId(12008);
			phones.add(phone);
		}

		if (Validator.isNotNull(faxNumber)) {
			faxNumber = convertPhone(faxNumber);
			phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
			phone.setNumber(faxNumber);
			phone.setListTypeId(ESFKeys.ESFPhoneListType.BUSINESSFAX);
			phone.setTypeId(12008);
			phones.add(phone);
		}
		return phones;
	}

	private List<ESFCard> assignCard(
		String code, long userId, Connection connection,
		ServiceContext serviceContext)
		throws NumberFormatException, PortalException, SystemException,
		SQLException, Exception {

		List<ESFCard> cards = new ArrayList<ESFCard>();
		Statement stat = connection.createStatement();
		String selectCard1 = selectCard.replace("id", code);
		
		ResultSet res = stat.executeQuery(selectCard1);
		while (res.next()) {
			String year = res.getString("Anno").trim();
			String cardCode = res.getString("Tessera").trim();
			String organization = res.getString("Societa").trim();
			String provinceCode = res.getString("Provincia").trim();
			String data_Creazione = res.getString("Data_Pagamento").trim();
			Date dateCreazione=new Date();
			if(Validator.isNotNull(data_Creazione)){
				String[] data=data_Creazione.split(" ")[0].split("-");
				dateCreazione.setDate(Integer.parseInt(data[2]));
				dateCreazione.setMonth(Integer.parseInt(data[1]));
				int a=Integer.parseInt(data[0])-1900;
				dateCreazione.setYear(a);
			}
			
			ESFOrganization org =
				ESFOrganizationLocalServiceUtil.findByCode(organization);
			if (org == null){
				_log.info("No Organization");
			}
			else {

				ESFEntityState esfEntityState =
						ESFEntityStateLocalServiceUtil.createESFEntityState(0);//

				if (!year.equals(""+annoRif)){
					String dataFine =res.getString("Anno").trim();
					Date datefine=new Date();
					datefine.setDate(31);
					datefine.setMonth(11);
					int a=Integer.parseInt(dataFine)-1900;
					datefine.setYear(a);
					esfEntityState.setEndDate(datefine);
				}
				esfEntityState.setEsfStateId(1);
				esfEntityState.setStartDate(dateCreazione);

				ESFCard card =
					ESFCardLocalServiceUtil.addESFCard(
						userId, cardCode, provinceCode,
						Long.parseLong(cardCode.substring(2)), esfEntityState, 0,
						org.getEsfOrganizationId(), serviceContext);
						
				cards.add(card);
				
			}
		}

		// _log.info("End card import");
		return cards;
	}
	
	
	private void assignLastCard(long userId, Connection connection)throws NumberFormatException, PortalException, SystemException,
			SQLException, Exception {

			Statement stat = connection.createStatement();
			String findLastCardQuery = findLastCard.replace("id", ""+userId);
			
			ResultSet res = stat.executeQuery(findLastCardQuery);
			if(res.next()) {
				String year = res.getString("Anno").trim();
				if (year.equals(""+annoRif)){
					countDue++;
					String organization = res.getString("Societa").trim();
					ESFOrganization org =
							ESFOrganizationLocalServiceUtil.findByCode(organization);
					if (org == null){
						_log.info("No Organization");
					}
					else {
						
						String cardCode = res.getString("Tessera").trim();
						String provinceCode = res.getString("Provincia").trim();
						String data_Creazione = res.getString("Data_Pagamento").trim();
						Date dateCreazione=new Date();
						if(Validator.isNotNull(data_Creazione)){
							String[] data=data_Creazione.split(" ")[0].split("-");
							dateCreazione.setDate(Integer.parseInt(data[2]));
							dateCreazione.setMonth(Integer.parseInt(data[1]));
							int a=Integer.parseInt(data[0])-1900;
							dateCreazione.setYear(a);
						}
				
						ESFEntityState esfEntityState =
							ESFEntityStateLocalServiceUtil.createESFEntityState(0);//
						
						esfEntityState.setEsfStateId(1);
						esfEntityState.setStartDate(dateCreazione);
						
						ESFCardLocalServiceUtil.addESFCard(
								userId, cardCode, provinceCode,
								Long.parseLong(cardCode.substring(2)), esfEntityState, userId,
								org.getEsfOrganizationId(), serviceContext);
					}
				}
			}
		}

	
	private void assignOtherCard(List<ESFCard> esfCards, long esfUserId)
		throws NoSuchCardException, SystemException {

		for (int i = 1; i < esfCards.size(); i++) {
			ESFCard card = esfCards.get(i);
			ESFUserLocalServiceUtil.addESFUserToESFShooter(
				esfUserId, card.getEsfCardId());
		}
	}

	private String convertPhone(String number) {

		String newNumber = "";
		for (int index = 0; index < number.length(); index++) {
			char c = number.charAt(index);
			if (Character.isDigit(c))
				newNumber += c;
		}
		return newNumber;
	}

	private String sanitizeMail(String userEmail) {

		// _log.info("sanitizeMail  " + userEmail);
		if (userEmail.split("@").length > 2) {
			int index = userEmail.indexOf(".", userEmail.indexOf("@"));
			if (index <= 0)
				index = 0;
			index = userEmail.indexOf(" ", index);
			if (index <= 0)
				index = userEmail.length();
			userEmail = userEmail.substring(0, index);
		}
		userEmail = userEmail.replaceAll("_", "");
		userEmail = userEmail.replaceAll("-", "");
		userEmail = userEmail.replaceAll(" ", "");
		return userEmail;
	}

	public String getJdbc() {

		return jdbc;
	}

	public void setJdbc(String jdbc) {

		this.jdbc = jdbc;
	}

	public String setDbUrl() {

		return dbUrl;
	}

	public void setDbUrl(String dbUrlL) {

		this.dbUrl = dbUrlL;
	}

	public String getUser() {

		return user;
	}

	public void setUser(String user) {

		this.user = user;
	}

	public String getPass() {

		return pass;
	}

	public void setPass(String pass) {

		this.pass = pass;
	}

	public ServiceContext getServiceContext() {

		return serviceContext;
	}

	public void setServiceContext(ServiceContext serviceContext) {

		this.serviceContext = serviceContext;
	}

	public String getSelectShooter() {

		return selectShooter;
	}

	public void setSelectShooter(String selectShooter) {

		this.selectShooter = selectShooter;
	}

	public String getSelectCard() {

		return selectCard;
	}

	public void setSelectCard(String selectCard) {

		this.selectCard = selectCard;
	}

	public String getFindLastCard() {
		return findLastCard;
	}

	public void setFindLastCard(String findLastCard) {
		this.findLastCard = findLastCard;
	}

	public int getAnnoRif() {
		return annoRif;
	}

	public void setAnnoRif(int annoRif) {
		this.annoRif = annoRif;
	}
	
	

	
}