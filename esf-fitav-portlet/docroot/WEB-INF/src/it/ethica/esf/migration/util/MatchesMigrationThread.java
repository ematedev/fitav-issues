package it.ethica.esf.migration.util;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;
import it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFResultLocalServiceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

public class MatchesMigrationThread implements Runnable {

	private static Log _log = LogFactoryUtil.getLog(MatchesMigrationThread.class);
	private String jdbc = "";
	private String dbUrl = "";
	private String user = "";
	private String pass = "";
	private String selectMatch = "";
	List<String> errorList = new ArrayList<String>();
	private boolean insertMatches=false;
	private boolean insertResults= false;
	StringBuilder totalResultErrors= new StringBuilder();
	private String schemaDotTableNameResult = "";
	private String schemaDotTableNameNewResult = "";
	
	private static final Map<Long, Long[]> matchTypeMap;
	static {
		matchTypeMap = new HashMap<Long, Long[]>();
		matchTypeMap.put(
			new Long(1),
			ArrayUtil.toArray(new long[]{160L}));
		matchTypeMap.put(
			new Long(2),
			ArrayUtil.toArray(new long[]{10L, 11L, 14L, 20L, 21L, 22L, 23L, 24L, 50L}));
		matchTypeMap.put(
			new Long(3),
			ArrayUtil.toArray(new long[]{100L, 105L, 110L, 120L, 130L, 140L, 145L}));
		matchTypeMap.put(
			new Long(5),
			ArrayUtil.toArray(new long[]{700L, 800L, 840L}));
		matchTypeMap.put(
			new Long(7),
			ArrayUtil.toArray(new long[]{150L}));
		matchTypeMap.put(
			new Long(8),
			ArrayUtil.toArray(new long[]{180L}));
		matchTypeMap.put(
			new Long(9),
			ArrayUtil.toArray(new long[]{530L}));
		matchTypeMap.put(
			new Long(10),
			ArrayUtil.toArray(new long[]{13L}));
		matchTypeMap.put(
			new Long(11),
			ArrayUtil.toArray(new long[]{155L}));
		matchTypeMap.put(
			new Long(12),
			ArrayUtil.toArray(new long[]{12L}));
		matchTypeMap.put(
			new Long(13),
			ArrayUtil.toArray(new long[]{30L, 40L}));
		matchTypeMap.put(
			new Long(14),
			ArrayUtil.toArray(new long[]{600L}));
		matchTypeMap.put(
			new Long(15),
			ArrayUtil.toArray(new long[]{500L}));
		matchTypeMap.put(
			new Long(16),
			ArrayUtil.toArray(new long[]{550L, 551L}));
		matchTypeMap.put(
			new Long(17),
			ArrayUtil.toArray(new long[]{520L}));
		matchTypeMap.put(
			new Long(19),
			ArrayUtil.toArray(new long[]{510L}));
		matchTypeMap.put(
			new Long(20),
			ArrayUtil.toArray(new long[]{590L}));
		matchTypeMap.put(
			new Long(21),
			ArrayUtil.toArray(new long[]{540L}));
	}
	
	private ServiceContext serviceContext;
	
	public void run() {

		Statement stat = null;
		Connection connection = null;

		try {
			// stabilisce la connessione
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrl, user, pass);

			// interrogazione del db
			stat = connection.createStatement();
			_log.debug("Start migration import");
			ResultSet res = stat.executeQuery(selectMatch);

			int count = 0;
			long esfMatchId = 0;
			boolean isDraft = false;
			boolean isTeamMatch = false;
			long esfMatchTypeId = 0;
			long tipoGara;
			long esfSportTypeId = 0;
			boolean isIndividualMatch = false;
			boolean isJuniorMatch = false;
			int numDisk = 0;
			int numDiskTeam = 0;
			long esfAssociationId = 0;
			String note = "";
			long esfCountryId = 0;
			long description;
			String startHour = "";
			Date endDate;
			int numFields = 0;
			String site = "";
			String codiceSocieta = StringPool.BLANK;
			boolean isNational = false;
			boolean isChangeCategoryMatch = true;

			Date startDate;
			String oldCode;
			int countCatQual;
			res.first();
			String categName;
			String qualifName;
			long categoryId;
			long qualificationId;
			long esfStateId = ESFKeys.ESFStateType.ENABLE;
			int rowcount = 0;
			if (res.last()) {
				rowcount = res.getRow();
				res.beforeFirst();
			}
			int counter = 1;
			while (res.next()) {
				_log.debug("Processing " + counter + " of " + rowcount);
				counter++;
				boolean noQualifs = true;
				count++;
				note = res.getString("Descr_Prima_Riga");
				startDate = res.getDate("Data_Inizio");
				String sportTypeCode = res.getString("Specialita").trim();
				if (Validator.isNotNull(sportTypeCode)) {

					esfSportTypeId =
						ESFSportTypeLocalServiceUtil.findIDSportByCode(sportTypeCode);
				}
				if (Validator.isNotNull(res.getString("Tipo_Gara"))) {
					tipoGara = Long.parseLong(res.getString("Tipo_Gara"));
				}
				else {
					tipoGara = 160;
				}
				
				for (long key : matchTypeMap.keySet()) {
					if (ArrayUtil.contains(matchTypeMap.get(key), tipoGara)) {
						esfMatchTypeId = key;
					}
				}
				
/*				ESFMatchType esfMatchType = ESFMatchTypeLocalServiceUtil.festchEsfMatchTypeByCode( Long.toString(esfMatchTypeId));
				boolean esfMatchTypeIsNational = isNational;
				if (Validator.isNotNull(esfMatchType) && Validator.isNotNull(esfMatchType.getIsNational())) {
					esfMatchTypeIsNational = esfMatchType.getIsNational();
				}*/

				String garaSquadra = (res.getString("Gara_A_Squadra") != null)?res.getString("Gara_A_Squadra").trim():StringPool.BLANK;
				String garaIndividuale = (res.getString("Gara_Individuale") != null)?res.getString("Gara_Individuale").trim():StringPool.BLANK;
				String garaSettGiov = (res.getString("Gara_Sett_Giov") != null)?res.getString("Gara_Sett_Giov").trim():StringPool.BLANK;

				if (Validator.isNotNull(garaSquadra) &&
					garaSquadra.equalsIgnoreCase("S")) {
					isTeamMatch = true;
				}
				if (Validator.isNotNull(garaIndividuale) &&
					garaIndividuale.equalsIgnoreCase("S")) {
					isIndividualMatch = true;
				}
				if (Validator.isNotNull(garaSettGiov) &&
					garaSettGiov.equalsIgnoreCase("S")) {
					isJuniorMatch = true;
				}
				numDisk = res.getInt("Numero_Piattelli");
				numDiskTeam = res.getInt("Numero_Piattelli_Sq");
				esfAssociationId = 0;

				codiceSocieta = res.getString("Codice_Societa");
				ESFOrganization esfOrg;
				long tempCodSoc = 0;

				esfOrg = ESFOrganizationLocalServiceUtil.findByCode(codiceSocieta);

				if (Validator.isNotNull(esfOrg)) {
					tempCodSoc = esfOrg.getEsfOrganizationId();
					esfAssociationId = tempCodSoc;
				}

				description = 0;
				endDate = res.getDate("Data_Fine");
				oldCode = res.getString("Codice");

				ArrayList<Long> categIds = new ArrayList<Long>();
				ArrayList<Long> qualifIds = new ArrayList<Long>();
				for (int i = 0; i < 9; i++) {
					countCatQual = i + 1;

					if (Validator.isNotNull(res.getString("Categorie" +
						countCatQual))) {

						categName =
							res.getString("Categorie" + countCatQual).trim();
						categoryId =
							ESFShooterCategoryLocalServiceUtil.findIDCategoryByCode(categName);
						if (categoryId != 0) {
							categIds.add(categoryId);
						}
					}

				}
				countCatQual = 0;
				for (int i = 0; i < 12; i++) {
					countCatQual = i + 1;

					if (Validator.isNotNull(res.getString("Qualifiche" +
						countCatQual))) {

						noQualifs = false;
						qualifName = res.getString("Qualifiche" + countCatQual);
						qualificationId =
							ESFShooterQualificationLocalServiceUtil.findIDQualificationByCode(qualifName);
						if (qualificationId != 0) {
							qualifIds.add(qualificationId);
						}
					}

				}

				qualifIds = removeDuplicates(qualifIds);
				categIds = removeDuplicates(categIds);
				long[] esfShooterQualificationIds = new long[qualifIds.size()];
				long[] esfShooterCategoryIds = new long[categIds.size()];
				for (int i = 0; i < categIds.size(); i++) {
					esfShooterCategoryIds[i] = Long.valueOf(categIds.get(i));
				}
				for (int i = 0; i < qualifIds.size(); i++) {
					esfShooterQualificationIds[i] =
						Long.valueOf(qualifIds.get(i));
				}
/*				ESFMatch esfMatch = ESFMatchLocalServiceUtil.fetchEsfMatchByCode(oldCode);*/
				
/*				if (Validator.isNull(esfMatch)) {
					esfMatch = ESFMatchLocalServiceUtil.addOrUpdateOldESFMatch(
						serviceContext.getUserId(), esfMatchId,
						esfAssociationId, oldCode, startDate, endDate,
						startHour, description, note, isDraft, numFields,
						esfSportTypeId, numDisk, numDiskTeam,
						isIndividualMatch, isTeamMatch, isJuniorMatch,
						esfMatchTypeId, isChangeCategoryMatch,
						esfShooterCategoryIds, esfShooterQualificationIds,
						esfCountryId, site, esfMatchTypeIsNational, esfStateId,
						serviceContext, oldCode);
				}
				else {
					esfMatch.setIsNational(esfMatchTypeIsNational);
					ESFMatchTypeLocalServiceUtil.updateESFMatchType(esfMatchType);
				}*/
				
//				if (insertMatches) {
//					
//					ESFMatch newMatch = ESFMatchLocalServiceUtil.addOrUpdateOldESFMatch(
//						serviceContext.getUserId(), esfMatchId,
//						esfAssociationId, oldCode, startDate, endDate,
//						startHour, description, note, isDraft, numFields,
//						esfSportTypeId, numDisk, numDiskTeam,
//						isIndividualMatch, isTeamMatch, isJuniorMatch,
//						esfMatchTypeId, isChangeCategoryMatch,
//						esfShooterCategoryIds, esfShooterQualificationIds,
//						esfCountryId, site, isNational, esfStateId,
//						serviceContext, oldCode);
//					insertResult(newMatch, oldCode);

//				}
//				else {
//					ESFMatch dummyMatch =
//						ESFMatchLocalServiceUtil.createESFMatch(count);
//					insertResult(dummyMatch, oldCode);
//
//				}
			}
			_log.debug("End match import");
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
	public String getSelectMatch() {

		return selectMatch;
	}
	
	public void setSelectMatch(String selectMatch) {

		this.selectMatch = selectMatch;
	}
	public String getSchemaDotTableNameResult() {
		return schemaDotTableNameResult;
	}
	public void setSchemaDotTableNameResult(String schemaDotTableNameResult) {
		this.schemaDotTableNameResult = schemaDotTableNameResult;
	}
	public String getSchemaDotTableNameNewResult() {
		return schemaDotTableNameResult;
	}
	public void setSchemaDotTableNameNewResult(String schemaDotTableNameResult) {
		this.schemaDotTableNameResult = schemaDotTableNameResult;
	}
	
	public void setInsertMatches(boolean insertMatches) {
		this.insertMatches = insertMatches;
	}

	public boolean isInsertResults() {
		return insertResults;
	}
	public void setInsertResults(boolean insertResults) {
		this.insertResults = insertResults;
	}
	
	public ArrayList<Long> removeDuplicates(ArrayList withDuplicates) {
	    
		HashSet hash1= new HashSet(withDuplicates);
	    ArrayList<Long> listWithoutDuplicates = new ArrayList<Long>(hash1);
	 
	    return listWithoutDuplicates;
	}
	

	public ESFResult insertResult(ESFMatch newMatch, String oldCode) {

		// ESFMatchResult result = null;
		ESFResult result = null;
		Connection connection = null;
		Statement stat = null;
		Statement statNew = null;
		Connection connectionN = null;
		int count = 0;
		// risultati da db storico
		String selectResults =
			"Select * from " + schemaDotTableNameResult +
				" where numero_gara=\"" + oldCode + "\";";
		// risultati dal nuovo db 2000
		String selectResultsNew =
			"Select * from " + schemaDotTableNameNewResult +
				" where concat(anno,LPAD(codice,4,\"0\")) =\"" + oldCode +
				"\";";
		try {

			// stabilisce la connessione
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrl, user, pass);

			// interrogazione del db
			stat = connection.createStatement();
			statNew = connection.createStatement();

			ResultSet res = stat.executeQuery(selectResults); // risultati da db
																// storico
			ResultSet resNew = statNew.executeQuery(selectResultsNew); // risultati
																		// dal
																		// nuovo
																		// db
																		// 2000

			if (!resNew.isBeforeFirst()) {
				System.out.println("No results from new DB");

				if (!res.isBeforeFirst()) {
					System.out.println("No data from old DB; results not found, skipping");
				}
				else { // IMPORT RISULTATO DA VECCHIO DB
					while (res.next()) {

						StringBuilder currentResultErrors = new StringBuilder();

						// currentResultErrors.append("Tiratore_Gara "+res.getString("Tiratore_Gara"));
						long esfResultId;
						if (insertResults)
							esfResultId =
								CounterLocalServiceUtil.increment(ESFResultLocalServiceImpl.class.getName());
						else
							esfResultId = count;
						currentResultErrors.append("Risultato " + oldCode + ":");
						ESFResult esfResult =
							ESFResultLocalServiceUtil.createESFResult(esfResultId);
						esfResult.setMatchYear(Integer.parseInt(oldCode.substring(
							0, 4)));
						esfResult.setNumberMatch(Integer.parseInt(oldCode));
						esfResult.setEsfMatchId(newMatch.getEsfMatchId());
						esfResult.setName(newMatch.getNotes());
						esfResult.setName2("");
						esfResult.setEsfAssociationId(newMatch.getEsfAssociationId());
						esfResult.setSportTypeCode(res.getString("Specialita"));
						// esfResult.setStartdDate(startdDate);
						esfResult.setEndDate(res.getDate("Data_A"));
						esfResult.setPosition(res.getInt("Posizione"));
						esfResult.setCardNumber(res.getString("Tessera"));
						String shooterName = "";
						long esfUserId = 0;
						if (Validator.isNotNull(res.getString("Tiratore"))) {
							ESFUser tiratore = ESFUserLocalServiceUtil.getESFUserByUserCode(
								Long.parseLong(res.getString("Tiratore")));
							if (Validator.isNotNull(tiratore)) {
								shooterName = tiratore.getLastName() + StringPool.SPACE + tiratore.getFirstName();
								esfUserId = tiratore.getEsfUserId();
							}
						}
						else {
							currentResultErrors.append("Tiratore non trovato: " +
								res.getString("Tiratore"));
							System.out.println(currentResultErrors);
							continue;
						}
						esfResult.setEsfUserId(esfUserId);
						esfResult.setShooterName(shooterName);
						esfResult.setNationCode("");
						esfResult.setCategory(res.getString("Categoria"));
						esfResult.setQualificationCode(res.getString("Qualifica"));
						esfResult.setTotalS(res.getInt("Risultato"));
						esfResult.setBarrage(res.getInt("Barrage"));
						esfResult.setFinalS(res.getInt("Finale"));
						esfResult.setRifle(res.getString("Marca_Fucile"));
						esfResult.setCatridge(res.getString("Marca_Cartuccia"));
						esfResult.setFinalType(res.getString("Tipo_Finale"));
						esfResult.setSemifinalResult(res.getInt("BuoniS"));
						esfResult.setShootOff1s(res.getInt("S_OffS1"));
						esfResult.setShootOff2s(res.getInt("S_OffS2"));
						esfResult.setShootOff3s(res.getInt("S_OffS3"));
						esfResult.setBronzeResult(res.getInt("BuoniBro"));
						esfResult.setShootOffBronze(res.getInt("S_OffBro"));
						esfResult.setGoldResult(res.getInt("BuoniOro"));
						esfResult.setShootOffGold(res.getInt("S_OffOro"));
						esfResult.setTeamName(res.getString("Des_Squadra"));
						esfResult.setNaz_int(newMatch.getIsNational()
							? "I" : "N");
						esfResult.setVariationDate(res.getDate("Data_Variazione"));
						// esfResult.setEsfMatchTypeId(Long.parseLong(res.getString("Tipo_Gara")));
						esfResult.setEsfMatchTypeId(newMatch.getEsfMatchTypeId());
						esfResult.setResultClassTeam(res.getInt("Risult_Class_Squadra"));
						esfResult.setSpare1(res.getInt("Spareggio1"));
						esfResult.setSpare2(res.getInt("Spareggio2"));
						esfResult.setShooterCode(Long.parseLong(res.getString("Tiratore")));
						esfResult.setYouthQualification(res.getString("QualificaSg"));
						if (currentResultErrors.length() > 19) {
							if (insertResults) {
								ESFResultLocalServiceUtil.addESFResult(esfResult);
							}
							else {
								System.out.println(currentResultErrors);
							}
						}
						else
							System.out.println(currentResultErrors);

					}
				}
			}
			else { // IMPORT DA NUOVO DB
				while (resNew.next()) {
					StringBuilder currentResultErrors = new StringBuilder();
					// currentResultErrors.append("Tiratore_Gara "+res.getString("Tiratore_Gara"));
					long esfResultId;
					if (insertResults)
						esfResultId =
							CounterLocalServiceUtil.increment(ESFResultLocalServiceImpl.class.getName());
					else
						esfResultId = count;
					currentResultErrors.append("Risultato " + oldCode + ":");
					ESFResult esfResult =
						ESFResultLocalServiceUtil.createESFResult(esfResultId);
					esfResult.setMatchYear(Integer.parseInt(oldCode.substring(
						0, 4)));
					esfResult.setNumberMatch(Integer.parseInt(oldCode));
					esfResult.setEsfMatchId(newMatch.getEsfMatchId());
					esfResult.setName(res.getString("Denominazione1"));
					esfResult.setName2(res.getString("Denominazione2"));
					esfResult.setEsfAssociationId(newMatch.getEsfAssociationId());
					esfResult.setSportTypeCode(res.getString("Specialita"));
					// esfResult.setStartdDate(startdDate);
					esfResult.setStartdDate(res.getDate("Data_Da"));
					esfResult.setEndDate(res.getDate("Data_A"));
					esfResult.setGroupRanking(res.getString("Gruppo_Classifica"));
					esfResult.setPosition(res.getInt("Posizione"));
					esfResult.setCardNumber(res.getString("Tessera"));
					String shooterName = "";
					if (Validator.isNotNull(ESFCardLocalServiceUtil.fetchESFCard(Long.parseLong(res.getString("Tessera"))))) {
						esfResult.setCardNumber(res.getString("Tessera"));
					}
					else {
						currentResultErrors.append("card  non trovata: " +
							res.getString("Tessera"));

					}
					esfResult.setShooterName(res.getString("Nominativo"));
					esfResult.setNationCode("Nazione");
					esfResult.setCategory(res.getString("Categoria"));
					esfResult.setQualificationCode(res.getString("Qualifica"));
					esfResult.setTotalS(res.getInt("Risultato"));
					esfResult.setBarrage(res.getInt("Barrage"));
					esfResult.setFinalS(res.getInt("Finale"));
					esfResult.setAmerican1(res.getInt("ShootOff1"));
					esfResult.setAmerican2(res.getInt("ShootOff2"));
					esfResult.setAmerican3(res.getInt("ShootOff3"));
					esfResult.setRifle(res.getString("Marca_Fucile"));
					esfResult.setCaliber(res.getString("Calibro"));
					esfResult.setCatridge(res.getString("Marca_Cartuccia"));
					esfResult.setFinalType(res.getString("Tipo_Finale"));
					esfResult.setSemifinalResult(res.getInt("BuoniS"));
					esfResult.setShootOff1s(res.getInt("S_OffS1"));
					esfResult.setShootOff2s(res.getInt("S_OffS2"));
					esfResult.setShootOff3s(res.getInt("S_OffS3"));
					esfResult.setBronzeResult(res.getInt("BuoniBro"));
					esfResult.setShootOffBronze(res.getInt("S_OffBro"));
					esfResult.setGoldResult(res.getInt("BuoniOro"));
					esfResult.setShootOffGold(res.getInt("S_OffOro"));
					esfResult.setTeamCategory(res.getString("Categoria_Squadra"));
					esfResult.setTeamName(res.getString("Squadra"));
					esfResult.setNaz_int(res.getString("Naz_Int"));
					esfResult.setShowTypeCode(res.getInt("Codice_Tipo_Manifestazione"));
					esfResult.setShowType(res.getString("Tipo_Manifestazione"));
					if (Validator.isNotNull(ESFUserLocalServiceUtil.getESFUserByUserCode(Long.parseLong(res.getString("Tiratore"))))) {
						esfResult.setEsfUserId(ESFUserLocalServiceUtil.getESFUserByUserCode(
							Long.parseLong(res.getString("Tiratore"))).getEsfUserId());
					}
					else {
						currentResultErrors.append("Tiratore non trovato: " +
							res.getString("Tiratore"));
						System.out.println(currentResultErrors);
						continue;
					}

					esfResult.setVariationDate(res.getDate("Data_Variazione"));
					esfResult.setSent(res.getInt("Trasmesso"));
					esfResult.setEsfMatchTypeId(newMatch.getEsfMatchTypeId());
					esfResult.setResultClassTeam(res.getInt("Risult_Class_Squadra"));
					esfResult.setSpare1(res.getInt("Spareggio1"));
					esfResult.setSpare2(res.getInt("Spareggio2"));
					esfResult.setShooterCode(Long.parseLong(res.getString("Tiratore")));
					if (currentResultErrors.length() > 19) {
						if (insertResults) {
							ESFResultLocalServiceUtil.addESFResult(esfResult);
						}
						else
							System.out.println(currentResultErrors);
					}
					else
						System.out.println(currentResultErrors);
				}
			}

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
		return result;
	}
}

