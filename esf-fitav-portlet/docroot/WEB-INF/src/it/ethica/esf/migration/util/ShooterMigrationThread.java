
package it.ethica.esf.migration.util;

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
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.NoSuchCardException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

public class ShooterMigrationThread implements Runnable {

	private static Log _log = LogFactoryUtil.getLog(ShooterMigrationThread.class);
	private String jdbc = "";
	private String dbUrl = "";
	private String user = "";
	private String pass = "";
	private String selectShooter = "";
	private String selectCard = "";
	private String selectOlderCard="";
	private String findLastCard = "";
	private int annoRif = 2017;
	private int countDue = 0;

	private ServiceContext serviceContext;

	public void run() {
		
		List<String> errorList = new ArrayList<String>();
		long totMailNull = 1;
		long totElement = 1;
		int totShooterImp=0;
		int totCardImp=0;
		Statement stat = null;
		Connection connection = null;
		Date dataInizioImport = new Date();
		
		try {
			// stabilisce la connessione
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrl, user, pass);
			if(Validator.isNotNull(selectShooter) && selectShooter.trim().equals("ImportCard2")){
				
				assignCard2(10198,connection,serviceContext);
				return;
				
			}
			// interrogazone del db
			stat = connection.createStatement();
			_log.debug("Start shooter import");
			long startTime = System.nanoTime();
			ResultSet res = stat.executeQuery(selectShooter);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime); 
			_log.debug("Query completata in: "+(duration/1000000)+"ms");
			int count = 0;
			long esfStateId = ESFKeys.ESFStateType.ENABLE;
			int rowcount = 0;
			if (res.last()) {
				rowcount = res.getRow();
				res.beforeFirst();
			}
			_log.debug("Numero di risultati: " + rowcount);
			while (res.next()) {
				count++;
				
				String code = res.getString("Codice").trim();
				_log.debug("Inserimento tiratore con codice: "+code);
//				if (count % 100 == 0) {
				/*	_log.debug("Processing " + count + " of " + rowcount + " with code " + code);*/
//				}

				long codeUs = new Long(code);
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
				if(province!=null)
					if (province.equals("PS"))
						province ="PU";
				String genderString = res.getString("Sesso") != null ? res.getString("Sesso").trim() 
					: StringPool.BLANK; ;
				String jobTitle = res.getString("Professione") != null ? res.getString("Professione").trim()
						: StringPool.BLANK;
				String birth_date = res.getString("Data_Nascita") != null ? res.getString("Data_Nascita").trim()
					: "1900-01-01";
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
				String fiscalCode = res.getString("Codice_Fiscale") != null
						? res.getString("Codice_Fiscale").trim() : StringPool.BLANK;
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

//				if (Validator.isNull(userEmail) || userEmail.trim().equals(StringPool.BLANK)
//						|| !userEmail.contains("@")){
//					
//					userEmail = "testim-" + (code) + "@fitav.it";
//				}
//				else {
//					userEmail = sanitizeMail(userEmail);
//				}
				userEmail = "testim-" + (code) + "@fitav.it"; 
				List<ESFPhone> phones = getListPhone(tel1, tel2, tel3, fax);

				List<ESFAddress> addresses = new ArrayList<ESFAddress>();
				ESFAddress esfAddress = ESFAddressLocalServiceUtil.createESFAddress(0);
				esfAddress.setWrapper(true);
				esfAddress.setEsfAddressId(0);
				esfAddress.setLongitude(0);
				esfAddress.setLatitude(0);
				esfAddress.setEsfCountryId("IT");
				esfAddress.setEsfRegionId(ManageAddress.getRegionIdFromProvince(connection, province));
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

				try {
					//List<ESFCard> esfCards = assignCard(0, code, 10198, connection, serviceContext);
					//totCardImp=totCardImp+esfCards.size();
//					if (esfCards.size() > 0) {
						ESFUser userResult = ESFUserLocalServiceUtil.addESFShooter(serviceContext.getUserId(),
								code, firstName, StringPool.BLANK, lastName, userEmail,
								fiscalCode, birthDay, birthMonth, birthYear, birthcity, nationality, gender,
								"", "", "", 0, false, "", jobTitle, "", null, null, addresses,
								phones, true, false, false, new Date(), null, null, false, 0L, serviceContext);

						if (Validator.isNotNull(userResult) && userResult.getEsfUserId() > 0) {
							ESFEntityStateLocalServiceUtil.addEntityState(
								serviceContext.getUserId(),
								ESFUser.class.getName(),
								userResult.getEsfUserId(), esfStateId,
								serviceContext);
							//assignOtherCard(esfCards, userResult.getEsfUserId());
							
							long codeUser = Long.parseLong(code);
							userResult.setCodeUser(codeUser);
							userResult.setFiscalCode(fiscalCode);
							ESFUserLocalServiceUtil.updateESFUser(userResult);
							totShooterImp++;
						}
//					}
//					else {
//						_log.debug("User with code " + code + " has not cards");
//					}
				}
				catch (Exception e) {
					e.printStackTrace();
					_log.debug("Problem retrieving cards for user " + code);
				}
			}
			_log.debug("Tiratori importati: "+totShooterImp);
			_log.debug("Card create: "+totCardImp);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} catch (ClassNotFoundException classN) {
			classN.printStackTrace();
		} catch (Exception classN) {
			classN.printStackTrace();
		} finally { // chiude Statement e Connection
			try {
				if (stat != null)
					stat.close();
				if (connection != null)
					connection.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private List<ESFPhone> getListPhone(String phoneNumber1, String phoneNumber2, String phoneNumber3,
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
	// procedura per assegnare card a tiratori già presenti, data una query con l'esfuserid già specificato
	private void  assignCard2(long userId, Connection connection, ServiceContext serviceContext)
					throws NumberFormatException, PortalException, SystemException, SQLException, Exception {
		Statement stat = connection.createStatement();
		String selectCards="SELECT a.*,b.esfuserid FROM anagrate.tessere_imp a, fitav.esfuser b where  a.numero_tiratore = b.codeuser";
		ResultSet res = stat.executeQuery(selectCards);
		int rowcount=0;
		int cardCount=0;
		String annoRif="2018";
		if (res.last()) {
			rowcount = res.getRow();
			res.beforeFirst();
		}
		while (res.next()) {
			long esfuserid=Long.parseLong(res.getString("esfuserid").trim());
			String year = res.getString("Anno").trim();
			String cardCode = res.getString("Tessera").trim();
			String organization = res.getString("Societa").trim();
			String provinceCode = res.getString("Provincia").trim();
			String data_Creazione = res.getString("Data_Pagamento").trim();
			String oldCode= res.getString("Indice").trim();
			Date dateCreazione = new Date();
			if (Validator.isNotNull(data_Creazione)) {
				String[] data = data_Creazione.split(" ")[0].split("-");
				dateCreazione.setDate(Integer.parseInt(data[2]));
				dateCreazione.setMonth(Integer.parseInt(data[1]));
				int a = Integer.parseInt(data[0]) - 1900;
				dateCreazione.setYear(a);
				//_log.debug("data creazione: "+dateCreazione);
			}
			
			ESFOrganization org =
				ESFOrganizationLocalServiceUtil.findByCode(organization);
			if (org != null) {

				ESFEntityState esfEntityState =
					ESFEntityStateLocalServiceUtil.createESFEntityState(0);
				if (!year.equals("" + annoRif)) {
					String dataFine = res.getString("Anno").trim();
					Date datefine = new Date();
					datefine.setDate(31);
					datefine.setMonth(11);
					int a = Integer.parseInt(dataFine) - 1900;
					datefine.setYear(a);
					datefine.setHours(23);
					datefine.setMinutes(59);
					datefine.setSeconds(59);
					esfEntityState.setEndDate(datefine);
					esfEntityState.setEsfStateId(2);
				}
				else {
					esfEntityState.setEsfStateId(1);
				}

				esfEntityState.setStartDate(dateCreazione);
				ESFCard card =
					ESFCardLocalServiceUtil.addESFCardOldCode(
						oldCode, userId, cardCode, provinceCode,
						Long.parseLong(cardCode.substring(2)), esfEntityState,
						esfuserid, org.getEsfOrganizationId(), serviceContext);
				
				ESFUserLocalServiceUtil.addESFUserToESFShooter(esfuserid, card.getEsfCardId());
				cardCount++;
			}
			else{
				_log.debug("Card "+oldCode+ " non importata per associazione "+organization+" non trovata ");
			}
		}
		_log.debug("Card importate ed assegnate: "+cardCount);
		
		
	}

	private List<ESFCard> assignCard(long esfUserId,String code, long userId, Connection connection, ServiceContext serviceContext)
			throws NumberFormatException, PortalException, SystemException, SQLException, Exception {

		List<ESFCard> cards = new ArrayList<ESFCard>();
		Statement stat = connection.createStatement();
		String selectCard1 = selectCard.replace("id", code);
		
		ResultSet res = stat.executeQuery(selectCard1);
		
		int rowcount = 0;
		if (res.last()) {
			rowcount = res.getRow();
			res.beforeFirst();
		}
//		_log.debug("L'utente " + code + " ha " + rowcount + " cards");
		while (res.next()) {

			String year = res.getString("Anno").trim();
			String cardCode = res.getString("Tessera").trim();
			String organization = res.getString("Societa").trim();
			String provinceCode = res.getString("Provincia").trim();
			String data_Creazione = res.getString("Data_Pagamento").trim();
			String oldCode= res.getString("Indice").trim();
			Date dateCreazione = new Date();
			if (Validator.isNotNull(data_Creazione)) {
				String[] data = data_Creazione.split(" ")[0].split("-");
				dateCreazione.setDate(Integer.parseInt(data[2]));
				dateCreazione.setMonth(Integer.parseInt(data[1]));
				int a = Integer.parseInt(data[0]) - 1900;
				dateCreazione.setYear(a);
				//_log.debug("data creazione: "+dateCreazione);
			}
			
			ESFOrganization org =
				ESFOrganizationLocalServiceUtil.findByCode(organization);
			if (org != null) {

				ESFEntityState esfEntityState =
					ESFEntityStateLocalServiceUtil.createESFEntityState(0);
				if (!year.equals("" + annoRif)) {
					String dataFine = res.getString("Anno").trim();
					Date datefine = new Date();
					datefine.setDate(31);
					datefine.setMonth(11);
					int a = Integer.parseInt(dataFine) - 1900;
					datefine.setYear(a);
					datefine.setHours(23);
					datefine.setMinutes(59);
					datefine.setSeconds(59);
					esfEntityState.setEndDate(datefine);
					esfEntityState.setEsfStateId(2);
				}
				else {
					esfEntityState.setEsfStateId(1);
				}

				esfEntityState.setStartDate(dateCreazione);
				ESFCard card =
					ESFCardLocalServiceUtil.addESFCardOldCode(
						oldCode, userId, cardCode, provinceCode,
						Long.parseLong(cardCode.substring(2)), esfEntityState,
						esfUserId, org.getEsfOrganizationId(), serviceContext);

				cards.add(card);
			}
			else{
				_log.debug("Card "+oldCode+ " non importata per associazione "+organization+" non trovata ");
			}
		}

		return cards;
	}
	
	private List<ESFCard> assignOlderCards(String code, long userId, Connection connection, ServiceContext serviceContext)
					throws NumberFormatException, PortalException, SystemException, SQLException, Exception {

				List<ESFCard> cards = new ArrayList<ESFCard>();
				Statement stat = connection.createStatement();
				String selectCard1 = selectOlderCard.replace("id", code);
				_log.debug("Assegno le vecchie tessere per utente: "+userId);
				ResultSet res = stat.executeQuery(selectCard1);
				_log.debug("Tessere :");
				while (res.next()) {
					
					String year = res.getString("Anno").trim();
					String cardCode = res.getString("Tessera").trim();
					String organization = res.getString("Societa").trim();
					String provinceCode = res.getString("Provincia").trim();
					String data_Creazione = res.getString("Data_Pagamento").trim();
					String oldCode= res.getString("Indice").trim();
					_log.debug(oldCode);
					Date dateCreazione = new Date();
					if (Validator.isNotNull(data_Creazione)) {
						String[] data = data_Creazione.split(" ")[0].split("-");
						dateCreazione.setDate(Integer.parseInt(data[2]));
						dateCreazione.setMonth(Integer.parseInt(data[1]));
						int a = Integer.parseInt(data[0]) - 1900;
						dateCreazione.setYear(a);
					}

					ESFOrganization org = ESFOrganizationLocalServiceUtil.findByCode(organization);
					if (org==null){
						try{
							String orgName=res.getString("denominazione_societa").trim();
							long orgId=OrganizationLocalServiceUtil.fetchOrganization(10154, orgName.trim()).getOrganizationId();
							org=ESFOrganizationLocalServiceUtil.fetchESFOrganization(orgId);
						}catch(Exception ex)
						{
							_log.debug("Organization: "+organization+" anno: "+year+" non trovata per nome");
						}
					}
					if (org == null) {
						
						_log.debug("No Organization: "+organization+" anno: "+year);
					} else {

						ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil.createESFEntityState(0);//
						_log.debug("Anno tessera: "+year);
						if (!year.equals("" + annoRif)) {
							String dataFine = res.getString("Anno").trim();
							Date datefine = new Date();
							datefine.setDate(31);
							datefine.setMonth(11);
							int a = Integer.parseInt(dataFine) - 1900;
							datefine.setYear(a);
							datefine.setHours(23);
							datefine.setMinutes(59);
							datefine.setSeconds(59);
							esfEntityState.setEndDate(datefine);
							
						}
						esfEntityState.setEsfStateId(1);
						esfEntityState.setStartDate(dateCreazione);

						ESFCard card = ESFCardLocalServiceUtil.addESFCardOldCode(oldCode,userId, cardCode, provinceCode,
								Long.parseLong(cardCode.substring(2)), esfEntityState, 0, org.getEsfOrganizationId(),
								serviceContext);

						cards.add(card);

					}
				}

				return cards;
			}
	
	private void assignLastCard(long userId, long userCode,Connection connection)
			throws NumberFormatException, PortalException, SystemException, SQLException, Exception {

		Statement stat = connection.createStatement();
		String findLastCardQuery = findLastCard.replace("id", "" + userCode);
		_log.debug("findLastCardQuery " + findLastCardQuery);

		ResultSet res = stat.executeQuery(findLastCardQuery);
		if (res.next()) {
			String year = res.getString("Anno").trim();
			_log.debug("Year " + year + " " + userId + " " + annoRif + " " + (year.equals("" + annoRif)));
			if (year.equals("" + annoRif)) {
				countDue++;
				String organization = res.getString("Societa").trim();
				ESFOrganization org = ESFOrganizationLocalServiceUtil.findByCode(organization);
				if (org == null) {
					try{
						String orgName=res.getString("denominazione_societa").trim();
						long orgId=OrganizationLocalServiceUtil.fetchOrganization(10154, orgName.trim()).getOrganizationId();
						org=ESFOrganizationLocalServiceUtil.fetchESFOrganization(orgId);
					}catch(Exception ex)
					{
						_log.debug("Organization: "+organization+" anno: "+year+" non trovata per nome");
					}
				}
				if (org == null) {
					_log.debug("No Organization");
				} else {
					String cardCode = res.getString("Tessera").trim();
					String provinceCode = res.getString("Provincia").trim();
					String data_Creazione = res.getString("Data_Pagamento").trim();
					String oldCode= res.getString("Indice").trim();
					Date dateCreazione = new Date();
					if (Validator.isNotNull(data_Creazione)) {
						String[] data = data_Creazione.split(" ")[0].split("-");
						dateCreazione.setDate(Integer.parseInt(data[2]));
						dateCreazione.setMonth(Integer.parseInt(data[1]));
						int a = Integer.parseInt(data[0]) - 1900;
						dateCreazione.setYear(a);
					}
					ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil.createESFEntityState(0);//

					esfEntityState.setEsfStateId(1);
					esfEntityState.setStartDate(dateCreazione);

					ESFCardLocalServiceUtil.addESFCardOldCode(oldCode,userId, cardCode, provinceCode,
							Long.parseLong(cardCode.substring(2)), esfEntityState, userId, org.getEsfOrganizationId(),
							serviceContext);

					_log.debug("Card old user: " + dateCreazione + " " + userId + " " + cardCode + " " + provinceCode
							+ " " + Long.parseLong(cardCode.substring(2)) + " " + userId);
				}
			}
		}
	}

	private void assignOtherCard(List<ESFCard> esfCards, long esfUserId) throws NoSuchCardException, SystemException {

		for (int i = 0; i < esfCards.size(); i++) {
			ESFCard card = esfCards.get(i);
			ESFUserLocalServiceUtil.addESFUserToESFShooter(esfUserId, card.getEsfCardId());
		}
	}
	private void updateCards(List<ESFCard> esfCards, long esfUserId) throws NoSuchCardException, SystemException {
		for (int i = 1; i < esfCards.size(); i++) {
			ESFCard card = esfCards.get(i);
			card.setEsfUserId(esfUserId);
			ESFCardLocalServiceUtil.updateESFCard(card);
			
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

	public void deleteAllUserCards(long userId) throws PortalException, SystemException
	{
		//CANCELLO TUTTE LE TESSERE ASSEGNATE AL TIRATORE già presente
				List <ESFCard> cardsPresent=ESFCardLocalServiceUtil.getAllESFCardsByEsfUserId(userId);
				if(cardsPresent!=null){
					if(cardsPresent.size()>0){
						for(ESFCard findCard: cardsPresent){
							long cardId=findCard.getEsfCardId();
							
							ESFEntityState entityState= ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(ESFCard.class.getName(), cardId);
							if(Validator.isNotNull(entityState))
								ESFEntityStateLocalServiceUtil.deleteESFEntityState(entityState.getEsfEntityStateId());
							ESFCardLocalServiceUtil.deleteESFCard(cardId);
							
						}
					}
				}
	}
	
	private String sanitizeMail(String userEmail) {

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
	public String getSelectOlderCards(){
		return selectOlderCard;
	}
	
	public String getSelectCard() {

		return selectCard;
	}
	
	public void setSelectOlderCard(String selectOlderCard) {

		this.selectOlderCard = selectOlderCard;
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
