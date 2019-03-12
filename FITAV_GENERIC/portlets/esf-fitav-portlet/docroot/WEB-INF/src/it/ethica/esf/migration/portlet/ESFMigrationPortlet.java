
package it.ethica.esf.migration.portlet;

import it.ethica.esf.ESFOrganizationTypeException;
import it.ethica.esf.migration.util.ESFKeys;
import it.ethica.esf.migration.util.ESFKeys.ESFBillboardType;
import it.ethica.esf.migration.util.ManageAddress;
import it.ethica.esf.migration.util.MatchesMigrationThread;
import it.ethica.esf.migration.util.ShooterMigrationThread;
import it.ethica.esf.migration.util.ShooterMigrationThreadTemp;
import it.ethica.esf.migration.util.UpdateUserSiteThread;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFOrganizationUnitservice;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFProvinceLocalServiceUtil;
import it.ethica.esf.service.ESFRegionLocalServiceUtil;
import it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFOrganizationLocalServiceImpl;
import it.ethica.esf.service.persistence.ESFMatchTypeUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EsfMigration
 */
public class ESFMigrationPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(ESFMigrationPortlet.class);
	private String jdbc = "com.mysql.jdbc.Driver";
	/*
	 * COnnessione produzione
	private String dbUrlL = "jdbc:mysql://192.168.10.46:3306/societa";
	
	private String user = "fitav";
	private String pass =  "F1I2t3v4";
	 */
	
	/*
	 * Connessione locale
	 */
	private String dbUrlL = "jdbc:mysql://192.168.10.46:3306/fitav";
	
	private String user = "fitav";
	private String pass =  "F1I2t3v4";
	
	private String annoOrgMigration =  "2017";
	/*private String selectOrg ="SELECT a1.anno,a2.*,b.* FROM societa.affilia a1,societa.anagra a2,societa.Stand b where a2.CodiSo= b.CodiSo  and a1.codiSo = a2.codiSo and a1.anno>=annoOrgMigration and a1.data_versamento is not null "
						+"and STR_TO_DATE(b.data, '%Y-%m-%d') in (select MAX(STR_TO_DATE(data, '%Y-%m-%d')) from societa.Stand where CodiSo like a2.CodiSo) ";
						*/
	/*private String selectOrg ="SELECT a1.anno,a2.*,b.*"+
					 "FROM societa.affilia a1, societa.anagra a2, societa.Stand b"+
					 "where a2.CodiSo= b.CodiSo  and a1.codiSo = a2.codiSo  and"+
					 "STR_TO_DATE(b.data, '%Y-%m-%d') in (select MAX(STR_TO_DATE(data, '%Y-%m-%d'))"+
					" from societa.Stand where CodiSo like a2.CodiSo)  and a1.anno in (select MAX(anno) " +
					"from societa.affilia c where c.CodiSo = a1.Codiso)";*/
	//private String selectOrg="SELECT a1.anno, a2.*, b.* FROM   societa.affilia a1, societa.anagra a2, societa.stand b WHERE  a2.codiso = b.codiso AND a1.codiso = a2.codiso AND Str_to_date(b.data, '%Y-%m-%d') IN (SELECT Max(Str_to_date(data, '%Y-%m-%d')) FROM   societa.stand WHERE  codiso LIKE a2.codiso) AND a1.anno IN (SELECT Max(anno) FROM   societa.affilia c WHERE  c.codiso = a1.codiso) UNION SELECT a1.anno, a2.*, NULL AS 'Indice', NULL AS 'CodiSo', NULL AS 'Data', NULL AS 'Denominazione', NULL AS 'Indirizzo', NULL AS 'CAP', NULL AS 'Localita', NULL AS 'Provincia', NULL AS 'Pref1', NULL AS 'Tel1', NULL AS 'Pref2', NULL AS 'Tel2', NULL AS 'PreF', NULL AS 'FAX', NULL AS 'Tabelloni_Video', NULL AS 'Tabelloni_Manuali', NULL AS 'Segreteria', NULL AS 'Armeria', NULL AS 'Sala_Riposo', NULL AS 'Sala_Riunione', NULL AS 'Guardaroba', NULL AS 'WC_uomini', NULL AS 'WC_donne', NULL AS 'BAR', NULL AS 'Ristorante', NULL AS 'Telefoni', NULL AS 'Altro1_Spec', NULL AS 'Altro1', NULL AS 'Altro2_Spec', NULL AS 'Altro2', NULL AS 'AccDisab' FROM   societa.affilia a1, societa.anagra a2, societa.stand b WHERE  a1.codiso = a2.codiso AND a1.codiso NOT IN(SELECT * FROM   societa.distinct_stand) AND a1.anno IN (SELECT Max(anno) FROM   societa.affilia c WHERE  c.codiso = a1.codiso) order by  denominazione_societa, data_prima_affiliazione desc;";
	
	
	//da usare solo per import nuove associazioni
	//private String selectOrg="SELECT a1.anno, a2.*, b.* FROM   societa.affilia_imp a1, societa.anagra_2018 a2, societa.stand_2018 b WHERE  a2.codiso = b.codiso AND a1.codiso = a2.codiso order by  denominazione_societa, data_prima_affiliazione desc";
	private String selectOrg="SELECT 2018, a2.*, b.* FROM  societa.anagra_2018 a2, societa.stand_2018 b WHERE  a2.codiso = b.codiso AND A2.CODISO IN ('AL09','BR15','FR13') order by  denominazione_societa, data_prima_affiliazione desc";
	/*
	 * Modifiche del giorno 11.12.2018
	 * Sostituzione della select selectOtherOrg
	 */
	//private String selectOtherOrg="SELECT  a1.codiso,a1.anno,a2.*,b.* FROM societa.affilia a1,societa.anagra a2,societa.Stand b where a2.CodiSo= b.CodiSo  and a1.codiSo = a2.codiSo and  STR_TO_DATE(b.data, '%Y-%m-%d') in (select MAX(STR_TO_DATE(data, '%Y-%m-%d')) from societa.Stand where CodiSo like a2.CodiSo) and a1.codiso in('BR13','CA06','OT01','PD07','PI06','SV05','VI50') and a1.anno>=2017";
	private String selectOtherOrg="SELECT  a1.codiso,a1.anno,a2.*,b.* FROM societa.affilia_2018 a1,societa.anagra_2018_new a2,societa.stand_2018 b where a2.CodiSo= b.CodiSo  and a1.codiSo = a2.codiSo and  STR_TO_DATE(b.data, '%Y-%m-%d') in (select MAX(STR_TO_DATE(data, '%Y-%m-%d')) from societa.Stand_2018 where CodiSo like a2.CodiSo) ";
	/*	
	private String selectStand =
		"SELECT *, greatest(Campi_FO,Campi_SK,Campi_FU,Campi_DT, Campi_PC,Campi_EL) AS 'massimo' "
			+ "FROM anagrate.societa where Codice like "
			+ "'asscId' ";
	
	private String selectBDO =
			 "SELECT * FROM societa.affilia "
			 + "where CodiSo in (select codice from anagrate.societa) "
			 + "and anno >= 2010 ";*/
	private String selectStand =
					"SELECT *, greatest(Campi_FO,Campi_SK,Campi_FU,Campi_DT, Campi_PC,Campi_EL) AS 'massimo' "
						+ "FROM anagrate.societa where Codice like "
						+ "'asscId' ";
				
				private String selectBDO =
						 "SELECT * FROM societa.affilia "
						 + "where anno = 2018 and CodiSo in (select code_ from fitav.esforganization) ";
						 
	private String selectShooterFromGhost = " select * from anagrate.anatiratori  a  where a.codice in (23842,36350,96084,124508,124509,37141,86065,124510);";
	/*
	private String selectCardFromGhost ="SELECT * FROM anagrate.Tessere "
					+ "where numero_tiratore = 'id' " 
					+"and Societa in ('CN06','AG05') and year(Data_Pagamento) >= 2010 order by anno desc;";*/
	private String selectCardFromGhost ="SELECT * FROM anagrate.Tessere "
					+ "where numero_tiratore = 'id' " 
					+"and Societa in ('CN06','AG05')  order by anno desc;";
	
	
	//private String selectShooter ="select distinct a.* from anagrate.anatiratori  a,anagrate.tessere  t where a.codice =t.numero_tiratore and t.anno >= 2017 and t.Societa IN (SELECT a2.codiSo FROM societa.affilia a1, societa.anagra a2  WHERE a1.codiSo = a2.codiSo  AND a1.anno >= 2017 AND a1.data_versamento IS NOT NULL) AND anno >= 2017;";
	
	//private String selectShooter ="select distinct a.* from anagrate.anatiratori  a,anagrate.tessere  t where a.codice =t.numero_tiratore and  t.Societa IN (SELECT a2.codiSo FROM societa.affilia a1, societa.anagra a2  WHERE a1.codiSo = a2.codiSo   AND a1.data_versamento IS NOT NULL);";
//	private String selectShooter ="select distinct a.* from anagrate.anatiratori a";
	//private String selectShooter ="select distinct a.* FROM anagrate.anatiratori_2018 a where Data_Creazione > '2018-01-10';";
	private String selectShooter ="select distinct a.* FROM anagrate.anatiratori_imp a";

	
	//inserimento delle tessere per i tiratori tesserati prima del 2018 che hanno semplicemnte cambiato tessera
	//private String selectShooter ="select distinct b.esfuserid, a.codice  from anagrate.anatiratori a, fitav_import.esfuser b where a.codice = b.codeuser and "+ 
								//"a.codice in (SELECT numero_tiratore from anagrate.tessere_2018 where tessera not in (select code_ from fitav_import.esfcard));";
	/*
	private String selectCard =
			"SELECT * FROM anagrate.Tessere "
					+"where numero_tiratore = 'id' " 
					 +"and Societa in (SELECT a2.codiSo FROM societa.affilia a1,societa.anagra a2 where a1.codiSo = a2.codiSo and a1.anno>=annoOrgMigration and a1.data_versamento is not null) "
					 +"and anno>= annoOrgMigration " 
					+"order by anno desc;";*/
	
	/*private String selectCard =
					"SELECT t.*,s.denominazione_societa FROM anagrate.Tessere_2018 t,societa.anagra s " +
					"where numero_tiratore = 'id' and" +
					" Societa in (SELECT a2.codiSo FROM societa.affilia a1,societa.anagra a2 " +
					"where a1.codiSo = a2.codiSo) and t.societa = s.codiso order by anno desc";*/
	
	
	//per importare le tessere del 2018 dei tiratori tesserati prima del 2018 che hanno semplicemnte cambiato tessera
	private String selectCard = "SELECT * from anagrate.tessere_imp";
	
	private String findLastCard ="select * FROM anagrate.Tessere where numero_tiratore = 'id' and anno in (select max(anno) FROM anagrate.Tessere where numero_tiratore = 'id'  group by Numero_Tiratore);";
	
	private String selectOlderCard = "SELECT t.*,s.denominazione_societa FROM anagrate.Tessere t,societa.anagra s " +
					"where numero_tiratore = 'id' and" +
					" Societa in (SELECT a2.codiSo FROM societa.affilia a1,societa.anagra a2 " +
					"where a1.codiSo = a2.codiSo) and t.societa = s.codiso and anno < 2010 order by anno desc";
	private String modificaSintassiMail(String original) {
		String modified = StringUtil.replace(original.trim(), StringPool.SPACE, StringPool.MINUS);
		modified = StringUtil.replace(modified, 'ì', 'i');
		modified = StringUtil.replace(modified, 'à', 'a');
		modified = StringUtil.replace(modified, 'è', 'e');
		modified = StringUtil.replace(modified, 'é', 'e');
		modified = StringUtil.replace(modified, 'ò', 'o');
		modified = StringUtil.replace(modified, 'ù', 'u');

		return modified;
	}

	public void createProvincesAndRegions(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext orgServiceContext =
			ServiceContextFactory.getInstance(
				Organization.class.getName(), request);
		ServiceContext esfOrgServiceContext =
			ServiceContextFactory.getInstance(
				Organization.class.getName(), request);

		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(
				com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		List<ESFRegion> esfRegions =
			ESFRegionLocalServiceUtil.getESFRegions(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		Organization fitav = OrganizationLocalServiceUtil.fetchOrganization(themeDisplay.getCompanyId(), "Fitav");
		
		for (ESFRegion esfRegion : esfRegions) {
			ESFOrganization esfOrganizationRegion = ESFOrganizationLocalServiceUtil.findByCode(esfRegion.getIdRegion());
			
			if (Validator.isNull(esfOrganizationRegion)) {
//				esfOrganizationRegion = ESFOrganizationLocalServiceUtil.addESFOrganization(
//					esfOrgServiceContext.getUserId(), fitav.getOrganizationId(),
//					esfRegion.getName(), modificaSintassiMail(esfRegion.getName()) + "@regione.rg",
//					esfRegion.getIdRegion(), StringPool.BLANK, StringPool.BLANK,
//					StringPool.BLANK, null, null, new Date(), null,
//					StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, null,
//					null, true, true, false, StringPool.BLANK, false, null, null,
//					11045, 0, false, false, false, false, false,
//					esfOrgServiceContext);

					_log.info("Created region: " + esfRegion.getIdRegion());
			}
			else {
				_log.info("Region " + esfRegion.getIdRegion() + " already exists");
			}
			

			List<ESFProvince> esfProvinces =
				ESFProvinceLocalServiceUtil.getByRegionCode(esfRegion.getIdRegion());
			
			_log.info("Number of provinces for region " + esfRegion.getName() + ": " + esfProvinces.size());

			for (ESFProvince esfProvince : esfProvinces) {
				ESFOrganization esfOrganizationProvince = ESFOrganizationLocalServiceUtil.findByCode(esfProvince.getIdProvince());
				
				if (Validator.isNotNull(esfOrganizationProvince)) {
					_log.info("Province " + esfProvince.getIdProvince() + " already exists");
					continue;
				}
				
				_log.info("Create province: " + esfProvince.getIdProvince());
				
//				esfOrganizationProvince = ESFOrganizationLocalServiceUtil.addESFOrganization(
//					esfOrgServiceContext.getUserId(), (long) esfOrganizationRegion.getEsfOrganizationId(),
//					esfProvince.getName(), modificaSintassiMail(esfProvince.getName()) + "@provincia.pr",
//					esfProvince.getIdProvince(), StringPool.BLANK, StringPool.BLANK,
//					StringPool.BLANK, null, null, new Date(), null,
//					StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, null,
//					null, true, true, false, StringPool.BLANK, false, null, null,
//					11045, 0, false, false, false, false, false,
//					esfOrgServiceContext);
				
				_log.info("Created province: " + esfProvince.getIdProvince());
			}
		}
	}
	
	private ESFOrganization addESFOrganization(ResultSet res, long companyId, ServiceContext serviceContext) throws SQLException, PortalException, SystemException {
		String name = res.getString("Denominazione_Societa").trim();
		String vat =
			res.getString("Partita_IVA") != null ? res.getString(
				"Partita_IVA").trim() : StringPool.BLANK;
		String fiscalCode =
			res.getString("Codice_Fiscale") != null ? res.getString(
				"Codice_Fiscale").trim() : StringPool.BLANK;
		String code = res.getString("CodiSo").trim();
		String ibanCode = StringPool.BLANK;

		boolean isMultiSport = false;
		String legalForm = "12021";
		String category = "12026";
		String coniCode = StringPool.BLANK;
		Date insertDate = new Date();
		String annotaz =
			res.getString("Annotaz") != null
				? res.getString("Annotaz").trim() : StringPool.BLANK;
		String annotaz250 =
			res.getString("Annotaz250") != null
				? res.getString("Annotaz250") : StringPool.BLANK;
		String description = annotaz + " | " + annotaz250;
		boolean isYouthActive = false;
		String es =
			res.getString("Data_Costituzione") != null ? res.getString(
				"Data_Costituzione").trim() : StringPool.BLANK;
		String fad =
			res.getString("Data_Prima_Affiliazione") != null
				? res.getString("Data_Prima_Affiliazione").trim()
				: StringPool.BLANK;
		Date establishmentDate = null;
		Date firstAffiliationDate = null;
		SimpleDateFormat format =
			new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		if (Validator.isNotNull(fad) && Validator.isNotNull(es)) {
			try {
				establishmentDate = format.parse(es);
				firstAffiliationDate = format.parse(fad);
			}
			catch (ParseException e1) {
				throw new PortalException(e1);
			}
		}
		_log.info("Adding Organization " + name + " codice " + code);
		String provincia = "";
		try {
			provincia = res.getString("Provincia_Societa").trim();
			if (provincia.equals("PS")) {
				provincia = "PU";
			}
		}
		catch (NullPointerException ex) {
			_log.info("Provincia_Societa errata o assente /errore regione " + res.getString("CodiSo"));
		}

		// A partire dalla provincia associo un organizzazione padre
		long parentOrganizationId = ESFOrganizationLocalServiceUtil.findByCode(provincia).getEsfOrganizationId();

		Organization organization = OrganizationLocalServiceUtil.fetchOrganization(companyId, name);
		
		if (Validator.isNull(organization)) {
			organization =
				OrganizationLocalServiceUtil.addOrganization(
					serviceContext.getUserId(), parentOrganizationId, name,
					"regular-organization", 0, 0, 12017, StringPool.BLANK,
					true, serviceContext);
			_log.info("Added organization " + organization.getName());
		}
		else {
			_log.info("Retrieve organization " + organization.getName());
		}

		
		/* ----------------------------------------------------------------------------------------------- */
		/* ---------------------------------------------ENTITY STATE-------------------------------------- */
		/* ----------------------------------------------------------------------------------------------- */

		Group organizationGroup = organization.getGroup();
		ESFOrganization parentESFOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(parentOrganizationId);
		long portalOrganizationId = organization.getOrganizationId();
		int esfOrganizationtype = 0;
		if (Validator.isNull(parentESFOrganization)){
			esfOrganizationtype = 1;
		}
		else {
			esfOrganizationtype = parentESFOrganization.getType() + 1;
		}
		validateType(esfOrganizationtype);
		
		String statoSocieta = res.getString("Stato_Societa") != null ? res.getString("Stato_Societa").trim() : StringPool.BLANK;
		long esfStateId = ESFKeys.ESFStateType.DISABLE;
		if (statoSocieta.equalsIgnoreCase("SC")) {
			esfStateId = ESFKeys.ESFStateType.LOOSE;
		}
		else if (statoSocieta.equalsIgnoreCase("SO")) {
			esfStateId = ESFKeys.ESFStateType.SUSPENDED;
		}
		else if (statoSocieta.equalsIgnoreCase("SP")) {
			esfStateId = ESFKeys.ESFStateType.SUSPENSION;
		}
		else if (statoSocieta.equalsIgnoreCase("SA")) {
			esfStateId = ESFKeys.ESFStateType.SUSPENSION_ASSEMBLY;
		}
		ESFEntityStateLocalServiceUtil.addEntityState(
			serviceContext.getUserId(),
			ESFOrganization.class.getName(), portalOrganizationId,
			esfStateId, serviceContext);

		/* ----------------------------------------------------------------------------------------------- */
		/* -----------------------------------------ESF ORGANIZATION-------------------------------------- */
		/* ----------------------------------------------------------------------------------------------- */

		ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(portalOrganizationId);
		
		if (Validator.isNull(esfOrganization)) {
			esfOrganization = ESFOrganizationLocalServiceUtil.createESFOrganization(portalOrganizationId);
			esfOrganization.setUuid(serviceContext.getUuid());
			esfOrganization.setCode(code);
			esfOrganization.setVat(vat);
			esfOrganization.setFiscalCode(fiscalCode);
			esfOrganization.setIbanCode(ibanCode);
			if(establishmentDate!=null) {
				esfOrganization.setEstablishmentDate(establishmentDate);
			}
			esfOrganization.setClosureDate(null);
			esfOrganization.setInsertDate(insertDate);
			esfOrganization.setConiDate(null);
			esfOrganization.setConiCode(coniCode);
			esfOrganization.setLegalForm(legalForm);
			esfOrganization.setCategory(category);
			esfOrganization.setGroupId(organizationGroup.getGroupId());
			// esfOrganization.setExpandoBridgeAttributes(serviceContext);
			esfOrganization.setType(esfOrganizationtype);
			esfOrganization.setIsMultiSport(isMultiSport);
			esfOrganization.setIsYouthActive(isYouthActive);
			if (firstAffiliationDate!= null) {
				esfOrganization.setFirstAffiliationDate(firstAffiliationDate);
			}
			esfOrganization.setDescription(description);
			ESFOrganizationLocalServiceUtil.updateESFOrganization(esfOrganization);
			
			ResourceLocalServiceUtil.addResources(
				serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(),
				serviceContext.getUserId(),
				ESFOrganization.class.getName(), esfOrganization.getEsfOrganizationId(),
				false, true, true);
		}

		return esfOrganization;
	}
	
	private void addPhones(ResultSet res, long esfOrganizationId, ServiceContext serviceContext) throws SQLException, PortalException, SystemException {
		List<ESFPhone> phones = new ArrayList<ESFPhone>();

		ESFPhone phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
		String prefisso_Tel1 = res.getString("Prefisso_Tel1") != null ? res.getString("Prefisso_Tel1").trim() : StringPool.BLANK;
		String telefono1 = res.getString("Telefono1") != null ? res.getString("Telefono1").trim() : StringPool.BLANK;
		String phoneNumber = prefisso_Tel1 + StringPool.SPACE + telefono1;
		phone.setNumber(phoneNumber);
		phone.setListTypeId(ESFKeys.ESFPhoneListType.BUSINESS);
		phone.setTypeId(12008);
		if (Validator.isNotNull(phoneNumber)) {
			phones.add(phone);
		}

		phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
		String prefisso_Tel2 = res.getString("Prefisso_Tel2") != null ? res.getString("Prefisso_Tel2").trim() : StringPool.BLANK;
		String telefono2 = res.getString("Telefono2") != null ? res.getString("Telefono2").trim() : StringPool.BLANK;
		phoneNumber = prefisso_Tel2 + StringPool.SPACE + telefono2;
		phone.setNumber(phoneNumber);
		phone.setListTypeId(ESFKeys.ESFPhoneListType.MOBILE);
		phone.setTypeId(12008);
		if (Validator.isNotNull(phoneNumber)) {
			phones.add(phone);
		}

		phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
		String prefisso_Tel3 = res.getString("Prefisso_Tel3") != null ? res.getString("Prefisso_Tel3").trim() : StringPool.BLANK;
		String telefono3 = res.getString("Telefono3") != null ? res.getString("Telefono3").trim() : StringPool.BLANK;
		phoneNumber = prefisso_Tel3 + StringPool.SPACE + telefono3;
		phone.setNumber(phoneNumber);
		phone.setListTypeId(ESFKeys.ESFPhoneListType.PERSONAL);
		phone.setTypeId(12008);
		if (Validator.isNotNull(phoneNumber)) {
			phones.add(phone);
		}

		phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
		String pref1 = res.getString("Pref1") != null ? res.getString("Pref1").trim() : StringPool.BLANK;
		String tel1 = res.getString("Tel1") != null ? res.getString("Tel1").trim() : StringPool.BLANK;
		phoneNumber = pref1 + StringPool.SPACE + tel1;
		phone.setNumber(phoneNumber);
		phone.setListTypeId(ESFKeys.ESFPhoneListType.OTHER);
		phone.setTypeId(12008);
		if (Validator.isNotNull(phoneNumber)) {
			phones.add(phone);
		}

		phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
		String pref2 = res.getString("Pref2") != null ? res.getString("Pref2").trim() : StringPool.BLANK;
		String tel2 = res.getString("Tel2") != null ? res.getString("Tel2").trim() : StringPool.BLANK;
		phoneNumber = pref2 + StringPool.SPACE + tel2;
		phone.setNumber(phoneNumber);
		phone.setListTypeId(ESFKeys.ESFPhoneListType.BUSINESSFAX);
		phone.setTypeId(12008);
		if (Validator.isNotNull(phoneNumber)) {
			phones.add(phone);
		}

		phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
		String preF = res.getString("PreF") != null ? res.getString("PreF").trim() : StringPool.BLANK;
		String fax = res.getString("FAX") != null ? res.getString("FAX").trim() : StringPool.BLANK;
		phoneNumber = preF + StringPool.SPACE + fax;
		phone.setNumber(phoneNumber);
		phone.setListTypeId(ESFKeys.ESFPhoneListType.PERSONALFAX);
		phone.setTypeId(12008);
		if (Validator.isNotNull(phoneNumber)) {
			phones.add(phone);
		}

		boolean first = true;
		
		for (ESFPhone phone1 : phones) {

			ESFPhoneLocalServiceUtil.addESFPhone(
				serviceContext.getUserId(),
				Organization.class.getName(),
				esfOrganizationId,
				phone1.getNumber(), StringPool.BLANK,
				phone1.getListTypeId(), phone1.getTypeId(), first,
				serviceContext);

			first = false;
		}
	}
	
	public void migrationOrganization(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {
		_log.info("Inizio import organizzazioni");
		long companyId = PortalUtil.getCompanyId(request);
		
		annoOrgMigration=ParamUtil.getString(request, "annoMigOrg","2017");
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMigrationPortlet.class.getName(), request);

		Statement stat = null;
		Connection connection = null;
		try {
			// stabilisce la connessione
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrlL, user, pass);

			// interrogazone del db
			stat = connection.createStatement();
			
			String selectOrgAdd = "SELECT a1.anno, a2.*, b.*, c.esfOrganizationId FROM   societa.affilia_imp a1,societa.anagra_2018 a2, societa.stand_2018 b , fitav_import.esforganization c " 
							+ "WHERE  a2.codiso = b.codiso AND a1.codiso = a2.codiso " 
							+ "and a2.codiso = c.code_ AND Str_to_date(b.data, '%Y-%m-%d') IN (SELECT " 
							+ "Max(Str_to_date(data, " 
							+ "'%Y-%m-%d')) FROM   societa.stand_2018 WHERE  codiso LIKE a2.codiso) AND a1.anno " 
							+ "IN (SELECT Max(anno) " 
							+ "FROM   societa.affilia_imp c WHERE  c.codiso = " 
							+ "a1.codiso) UNION SELECT a1.anno, a2.*, NULL AS 'Indice', NULL AS 'CodiSo', " 
							+ "NULL AS 'Data', NULL AS 'Denominazione'," 
							+ " NULL AS 'Indirizzo', NULL AS 'CAP', NULL AS 'Localita', NULL AS " 
							+ "'Provincia', NULL AS 'Pref1', NULL AS 'Tel1', NULL AS 'Pref2'," 
							+ " NULL AS 'Tel2', NULL AS 'PreF', NULL AS 'FAX', NULL AS 'Tabelloni_Video', " 
							+ "NULL AS 'Tabelloni_Manuali', NULL AS 'Segreteria', " 
							+ " NULL AS 'Armeria', NULL AS 'Sala_Riposo', NULL AS 'Sala_Riunione', NULL AS " 
							+ "'Guardaroba', NULL AS 'WC_uomini', NULL AS 'WC_donne', " 
							+ " NULL AS 'BAR', NULL AS 'Ristorante', NULL AS 'Telefoni', NULL AS " 
							+ "'Altro1_Spec', NULL AS 'Altro1', NULL AS 'Altro2_Spec', " 
							+ " NULL AS 'Altro2', NULL AS 'AccDisab', c.esfOrganizationId FROM " 
							+ "societa.affilia_imp a1, societa.anagra_2018_new a2, societa.stand_2018 b, " 
							+ " fitav_import.esforganization c  wHERE  a1.codiso = a2.codiso and a2.codiso " 
							+ "= c.code_ " 
							+ " AND a1.codiso NOT IN(SELECT * FROM   societa.distinct_stand) AND a1.anno IN " 
							+ "(SELECT " 
							+ "Max(anno) FROM   societa.affilia_imp c WHERE  c.codiso = a1.codiso) order by " 
							+ "denominazione_societa, data_prima_affiliazione desc; " ;
							
			/*
			 * Modifiche del giorno 11.12.2018
			 * Sostituzione del resultset che richiama la select della modifica precedente
			 */
			//ResultSet res = stat.executeQuery(selectOrg); sostituita con riga sottostante per inserimento indirizzi
			//ResultSet res = stat.executeQuery(selectOrg);
			//ResultSet res = stat.executeQuery(selectOrgAdd);
			//ResultSet res = stat.executeQuery(selectOrg); sostituita con riga sottostante per inserimento indirizzi

			ResultSet res = stat.executeQuery(selectOtherOrg);

			//ResultSet res = stat.executeQuery(selectOrgAdd);
			
			int rowcount = 0;
			if (res.last()) {
				rowcount = res.getRow();
				res.beforeFirst();
			}
			int counter = 1;
			while (res.next()) {
				
				if (counter % 100 == 0) {
					_log.info("Processing " + counter + " of " + rowcount);
				}
				
				ESFOrganization esfOrganization = addESFOrganization(res, companyId, serviceContext);
				
				//ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.findByCode(res.getString("CodIso"));
				//long esfOrganizationId = res.getShort("esfOrganizationId");
				long esfOrganizationId=esfOrganization.getEsfOrganizationId();
				_log.info("Id società="+esfOrganizationId);
				
				
				/* ----------------------------------------------------------------------------------------------- */
				/* -----------------------------------------SET LAYOUT TEMPLATE, RESOURCE--------------------------*/
				/* ----------------------------------------------------------------------------------------------- */
				
//				try {
//					_log.info("Start layout template");
//					String uuid = "1d970b3a-2fef-463d-b291-e419799746e2";		
//					Group organizationSite = GroupLocalServiceUtil.getOrganizationGroup(esfOrganization.getCompanyId(), esfOrganization.getEsfOrganizationId()) ;
//					LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(organizationSite.getGroupId(), true, true,uuid );
//					LayoutLocalServiceUtil.updatePriorities(organizationSite.getGroupId(), true);
//					LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(organizationSite.getGroupId(), true);
//					SitesUtil.mergeLayoutSetPrototypeLayouts(organizationSite, layoutSet);
//				}
//				catch (Exception e) {
//					_log.info("Errore layout template--->orgId"+esfOrganization.getEsfOrganizationId());
//					e.printStackTrace();
//				}
				
				String provincia = "";
				try {
					provincia = res.getString("Provincia_Societa").trim();
					if (provincia.equals("PS")) {
						provincia = "PU";
					}
				}
				catch (NullPointerException ex) {
					_log.info("Provincia_Societa errata o assente /errore regione " + res.getString("CodiSo"));
				}

				ESFAddress esfAddress = ESFAddressLocalServiceUtil.createESFAddress(0);
				esfAddress.setEsfRegionId(ManageAddress.getRegionId(res.getString("Regione_Societa").trim()));
				esfAddress.setEsfProvinceId(provincia);
				esfAddress.setWrapper(true);
				esfAddress.setEsfAddressId(0);
				esfAddress.setLongitude(0);
				esfAddress.setLatitude(0);
				esfAddress.setEsfCountryId("IT");
				try {
					esfAddress.setEsfCityId(ManageAddress.getCityId(res.getString(
						"Localita_Societa").trim()));
				}
				catch (NullPointerException ex) {
					_log.info("Città da località non trovata");
				}
				String indirizzo_societa = res.getString("Indirizzo_Societa") != null ? res.getString("Indirizzo_Societa").trim() : StringPool.BLANK;
				esfAddress.setStreet1(indirizzo_societa);
				esfAddress.setStreet2(null);
				esfAddress.setStreet3(null);
				esfAddress.setZip(res.getString("Cap_Societa").trim());
				esfAddress.setTypeId(12000);
				esfAddress.setMailing(false);
				esfAddress.setPrimary_(false);
				esfAddress.setListTypeId(ESFKeys.ESFAddressType.LEGAL);

				ESFAddressLocalServiceUtil.addESFAddress(
					serviceContext.getUserId(), esfAddress.getLongitude(),
					esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
					esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
					esfAddress.getLatitude(), esfAddress.getType(),
					esfAddress.getListTypeId(),
					"com.liferay.portal.model.Organization",//organization.getClass().getName(),
					//esfOrganization.getEsfOrganizationId(),ho sostituito id della società nella riga sottostante prendendolo dalla select
					esfOrganizationId,
					esfAddress.getStreet1(), esfAddress.getStreet2(),
					esfAddress.getStreet3(), esfAddress.getZip(), 12000,
					esfAddress.getMailing(), esfAddress.getPrimary_(),false,
					serviceContext);

				esfAddress = ESFAddressLocalServiceUtil.createESFAddress(0);
				esfAddress.setWrapper(true);
				esfAddress.setEsfAddressId(0);
				esfAddress.setLongitude(0);
				esfAddress.setLatitude(0);
				esfAddress.setEsfCountryId("IT");
				if(res.getString("Localita_Postale")!= null){
					esfAddress.setEsfRegionId(ManageAddress.getRegionIdFromProvince(
						connection, res.getString("Provincia_Postale").trim()));
					
					
						
					esfAddress.setEsfProvinceId(res.getString("Provincia_Postale").trim());
					if(res.getString("Provincia_Postale").trim().equals("PS"))
						esfAddress.setEsfProvinceId("PU");
					
						esfAddress.setEsfCityId(ManageAddress.getCityId(res.getString(
							"Localita_Postale").trim()));
				}
				String indirizzo_postale = res.getString("Indirizzo_Postale") != null ?
						res.getString("Indirizzo_Postale").trim() : StringPool.BLANK;
				esfAddress.setStreet1(indirizzo_postale);
				esfAddress.setStreet2(null);
				esfAddress.setStreet3(null);
				esfAddress.setZip(res.getString("Cap_Postale").trim());
				esfAddress.setTypeId(12000);
				esfAddress.setMailing(false);
				esfAddress.setPrimary_(false);
				esfAddress.setListTypeId(ESFKeys.ESFAddressType.CORRISPONDENCE);
               
				ESFAddressLocalServiceUtil.addESFAddress(
					serviceContext.getUserId(), esfAddress.getLongitude(),
					esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
					esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
					esfAddress.getLatitude(), esfAddress.getType(),
					esfAddress.getListTypeId(),
					"com.liferay.portal.model.Organization",//organization.getClass().getName(),
					//esfOrganization.getEsfOrganizationId(),ho sostituito id della società nella riga sottostante prendendolo dalla select
					esfOrganizationId,
					esfAddress.getStreet1(), esfAddress.getStreet2(),
					esfAddress.getStreet3(), esfAddress.getZip(), 12000,
					esfAddress.getMailing(), esfAddress.getPrimary_(),
					false,serviceContext);

				// addresses.add(esfAddress);

				esfAddress = ESFAddressLocalServiceUtil.createESFAddress(0);
				esfAddress.setWrapper(true);
				esfAddress.setEsfAddressId(0);
				esfAddress.setLongitude(0);
				esfAddress.setLatitude(0);
				esfAddress.setEsfCountryId("IT");
				
				//addPhones(res, esfOrganization.getEsfOrganizationId(), serviceContext);
			    
				String provinciaStand;
				
				provinciaStand=(res.getString("Provincia")!= null ?
					res.getString("Provincia").trim() : StringPool.BLANK);
				if(provinciaStand.equals("PS"))
					provinciaStand="PU";
				esfAddress.setEsfRegionId(provinciaStand.isEmpty() ? null :
					ManageAddress.getRegionIdFromProvince(						
					connection, res.getString("Provincia").trim() ));
				
				
				try{
					esfAddress.setEsfCityId(res.getString("Localita")== null ? null : 
										ManageAddress.getCityId(res.getString("Localita").trim()));
				}catch(NullPointerException ex){
					_log.info("Località non trovata: "+res.getString("Localita")+ " associazione "+res.getString("CodiSo").trim());
					esfAddress.setEsfCityId(0);
				}
				esfAddress.setStreet1(res.getString("Indirizzo")== null ? null : res.getString("Indirizzo").trim());
				
				esfAddress.setStreet2(null);
				esfAddress.setStreet3(null);
				
					esfAddress.setZip(res.getString("CAP")== null ? StringPool.BLANK : res.getString("CAP").trim());
				
				esfAddress.setTypeId(12000);
				esfAddress.setMailing(false);
				esfAddress.setPrimary_(false);
				esfAddress.setListTypeId(ESFKeys.ESFAddressType.STAND);
				
				ESFAddressLocalServiceUtil.addESFAddress(
					serviceContext.getUserId(), esfAddress.getLongitude(),
					esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
					esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
					esfAddress.getLatitude(), esfAddress.getType(),
					esfAddress.getListTypeId(),
					"com.liferay.portal.model.Organization",//organization.getClass().getName(),
					//esfOrganization.getEsfOrganizationId(),ho sostituito id della società nella riga sottostante prendendolo dalla select
					esfOrganizationId,
					esfAddress.getStreet1(), esfAddress.getStreet2(),
					esfAddress.getStreet3(), esfAddress.getZip(), 12000,
					esfAddress.getMailing(), esfAddress.getPrimary_(),
					false,serviceContext);

				_log.info("End Address ");

				/* parte tolta per inserimento dei solio indirizzi
				List<ListType> emailListType =
					ListTypeServiceUtil.getListTypes(Organization.class.getName() +
						ListTypeConstants.EMAIL_ADDRESS);

				int typeId = 0;
				if (emailListType.size() > 0) {
					typeId = emailListType.get(0).getListTypeId();
				}
				
				String emailAddress = res.getString("IndMail") != null
						? res.getString("IndMail").trim() : StringPool.BLANK;
				if (emailAddress.equals(StringPool.BLANK)|| !Validator.isEmailAddress(emailAddress)){
					emailAddress = esfOrganization.getCode() + "@fitavprova.it";
					_log.info("emailAddress-->"+emailAddress);
				}
				
				EmailAddressLocalServiceUtil.addEmailAddress(
					serviceContext.getUserId(), Organization.class.getName(),
					esfOrganization.getEsfOrganizationId(), emailAddress,
					typeId, true, serviceContext);

				_log.info("Added Organization");

				int tabVideo = res.getInt("Tabelloni_Video");
				int tabMunuali = res.getInt("Tabelloni_Manuali");
				String accessoDis = res.getString("AccDisab") != null ?
						res.getString("AccDisab").trim() : StringPool.BLANK ;
				String date = res.getString("Data") != null ?res.getString("Data").trim() : StringPool.BLANK;
				int year=0;
				if(Validator.isNotNull(date))
				
				{
					SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
					Date dataYear =formatDate.parse(date);
					Calendar cal = Calendar.getInstance();
					cal.setTime(dataYear);
					 year = cal.get(Calendar.YEAR);
				}
				_log.info("Start addField ");
				addField(
					serviceContext, connection,
					esfOrganization.getEsfOrganizationId(), esfOrganization.getCode(), year,
					tabVideo, tabMunuali, accessoDis);

				_log.info("End addField ");

				int segreteria = res.getInt("Segreteria");
				int salaRiposo = res.getInt("Sala_Riposo");
				int salaRiunione = res.getInt("Sala_Riunione");
				int armeria = res.getInt("Armeria");
				int guardaroba = res.getInt("Guardaroba");
				int wcU = res.getInt("WC_uomini");
				int wcD = res.getInt("WC_donne");
				int bar = res.getInt("BAR");
				int ristorante = res.getInt("Ristorante");
				int altro1Qyt = res.getInt("Altro1");
				String altro1 = res.getString("Altro1_Spec") != null ?
						res.getString("Altro1_Spec").trim() : StringPool.BLANK;
				String altro2 = res.getString("Altro2_Spec") != null ?
						res.getString("Altro2_Spec").trim() : StringPool.BLANK;
				int altro2Qyt = res.getInt("Altro2");
				addService(
					serviceContext, esfOrganization.getEsfOrganizationId(),
					segreteria, salaRiposo, salaRiunione, armeria, guardaroba,
					wcU, wcD, bar, ristorante, altro1, altro1Qyt, altro2,
					altro2Qyt);
				*/
				counter++;
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

	}

	public void migrationShooter(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		annoOrgMigration = ParamUtil.getString(request, "annoMigShot","2017");
		selectShooter = ParamUtil.getString(request, "selectShooter");
		int annoRif = Integer.parseInt(annoOrgMigration);
		annoRif = 2017;
		
		_log.info("selectShooter "+selectShooter);
		_log.info("selectCard "+selectCard);
		_log.info("findLastCard "+findLastCard);
		
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMigrationPortlet.class.getName(), request);

		ShooterMigrationThread sht = new ShooterMigrationThread();
		sht.setServiceContext(serviceContext);
		sht.setJdbc(jdbc); 
		sht.setDbUrl(dbUrlL); 
		sht.setUser(user);
		sht.setPass(pass);
		sht.setSelectShooter(selectShooter);
		sht.setSelectCard(selectCard);
		sht.setSelectOlderCard(selectOlderCard);
		sht.setFindLastCard(findLastCard);
		sht.setAnnoRif(annoRif);
		Thread t=new Thread(sht);
		t.start();
	}
	
	
	public void populateMatchType(
		ActionRequest request, ActionResponse response)
		throws SystemException, PortalException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMigrationPortlet.class.getName(), request);

		Statement stat = null;
		Connection connection = null;
		user = "fitav";
		pass = "F1I2t3v4";

		String selectCategories = "SELECT * FROM tabelle.tabtgara";

		// stabilisce la connessione
		try {
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrlL, user, pass);

			// interrogazione del db
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery(selectCategories);

			String codice = StringPool.BLANK;
			String descrizione = StringPool.BLANK;
			String nazInt = StringPool.BLANK;
			int rowcount = 0;
			if (res.last()) {
				rowcount = res.getRow();
				res.beforeFirst();
			}
			int counter = 1;
			_log.info("Number of match types " + rowcount);
			while (res.next()) {
				_log.info("Adding match type " + counter + " of " + rowcount);

				codice = res.getString("Codice");
				descrizione = res.getString("Descrizione");
				nazInt = res.getString("Naz_Int");

/*				ESFMatchTypeLocalServiceUtil.addEsfMatchType(
					descrizione, false, ("n".equalsIgnoreCase(nazInt))
						? true : false, codice, serviceContext);*/
				counter++;
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void populateCategoryAndQualification(
		ActionRequest request, ActionResponse response)
		throws SystemException, PortalException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMigrationPortlet.class.getName(), request);
		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

		Statement stat = null;
		Connection connection = null;
		user = "fitav";
		pass = "F1I2t3v4";

		String selectCategories = "SELECT * FROM tabelle.tabcateg";
		String selectQualifications = "SELECT * FROM tabelle.tabqual union SELECT * FROM tabelle.tabqualsettgiov;";

		// stabilisce la connessione
		try {
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrlL, user, pass);

			// interrogazione del db
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery(selectCategories);

			String codice = StringPool.BLANK;
			String descrizione = StringPool.BLANK;
			int rowcount = 0;
			if (res.last()) {
				rowcount = res.getRow();
				res.beforeFirst();
			}
			int counter = 1;
			_log.info("Number of category " + rowcount);
			while (res.next()) {
				_log.info("Adding category " + counter + " of " + rowcount);

				codice = res.getString("Codice");
				descrizione = res.getString("Descrizione");

				ESFShooterCategoryLocalServiceUtil.addESFShooterCategory(
					themeDisplay.getUserId(), descrizione, descrizione, codice,
					serviceContext);
				counter++;
			}

			res = stat.executeQuery(selectQualifications);

			rowcount = 0;
			if (res.last()) {
				rowcount = res.getRow();
				res.beforeFirst();
			}
			counter = 1;
			_log.info("Number of qualification " + rowcount);
			while (res.next()) {
				_log.info("Adding qualification " + counter + " of " + rowcount);

				codice = res.getString("Codice");
				descrizione = res.getString("Descrizione");

				
				ESFShooterQualificationLocalServiceUtil.addESFShooterQualification(
					themeDisplay.getUserId(), descrizione, descrizione, codice,
					serviceContext);
				counter++;
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void migrationMatches(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		String schemaDotTableName = ParamUtil.getString(request, "schemaDotTableName", "storico.ggnugara");
		String schemaDotTableNameResult = ParamUtil.getString(request, "schemaDotTableNameResult");
		boolean insertMatches = ParamUtil.getBoolean(request, "insertMatches", false);
		boolean insertResults = ParamUtil.getBoolean(request, "insertResults", false);
		String selectMatch =
			"select * from " + schemaDotTableName + " ORDER BY Codice";
		_log.info("selectMatche " + selectMatch);

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMigrationPortlet.class.getName(), request);

		MatchesMigrationThread mat = new MatchesMigrationThread();
		dbUrlL = "jdbc:mysql://192.168.10.40:3306/storico";
		user = "fitav";
		pass = "F1I2t3v4";

		mat.setServiceContext(serviceContext);
		mat.setJdbc(jdbc);
		mat.setDbUrl(dbUrlL);
		mat.setUser(user);
		mat.setPass(pass);
		mat.setSelectMatch(selectMatch);
		mat.setInsertMatches(insertMatches);
		mat.setInsertResults(insertResults);
		mat.setSchemaDotTableNameResult(schemaDotTableNameResult);
		Thread t = new Thread(mat);
		t.start();
	}

	public void migrationShooterFromGhost(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			int annoRif=Integer.parseInt(annoOrgMigration);
		
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMigrationPortlet.class.getName(), request);

			ShooterMigrationThread sht=new ShooterMigrationThread();
			sht.setServiceContext(serviceContext);
			sht.setJdbc(jdbc); 
			sht.setDbUrl(dbUrlL); 
			sht.setUser(user);
			sht.setPass(pass);
			sht.setSelectShooter(selectShooterFromGhost);
			sht.setSelectCard(selectCardFromGhost);
			sht.setFindLastCard(findLastCard);
			sht.setAnnoRif(annoRif);
			Thread t=new Thread(sht);
			t.start();
		}
	
	public void migrationBDO (ActionRequest request, ActionResponse response) 
			throws PortalException, SystemException{
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMigrationPortlet.class.getName(), request);
		
		//id dei ruoli del consiglio direttivo
		Role president = null;
		Role vicePresident = null;
		Role secretary = null;
		Role counselor = null;
		try{
			president = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), ESFKeys.PRESIDENTE);
			vicePresident = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), ESFKeys.VICEPRESIDENTE);
			secretary = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), ESFKeys.SEGRETARIO);
			counselor = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), ESFKeys.CONSIGLIERE);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Statement stat = null;
		Connection connection = null;
		
		//lista di tutte le card
		//List<ESFCard> cards = ESFCardLocalServiceUtil.getESFCards(-1, -1);
			try {
				// stabilisce la connessione
				Class.forName(jdbc);
				connection = DriverManager.getConnection(dbUrlL, user, pass);
				// interrogazone del db
				stat = connection.createStatement();

				ResultSet res = stat.executeQuery(selectBDO);
				
				int rowcount = 0;
				if (res.last()) {
					rowcount = res.getRow();
					res.beforeFirst();
				}
				int counter = 1;
				_log.info("Number of item " + rowcount);
				
				while (res.next()) {
					
					_log.info("Processing item " + counter + " of " + rowcount);
					counter++;
					
					String organization = res.getString("codiSo");
					String anno = res.getString("Anno");
					_log.info("_start import ORG-->"+organization+" --Anno-->"+anno);
					ESFOrganization org = ESFOrganizationLocalServiceUtil.findByCode(organization);
					if (Validator.isNull(org)) {
						continue;
					}
					String tesseraPresidente = res.getString("Numero_Tessera_Pres");
					String tesseraVicPres1 = res.getString("Numero_Tessera_VPres1");
					String tesseraVicPres2 = res.getString("Numero_Tessera_VPres2");
					String tesseraSegretario = res.getString("Numero_Tessera_Segr");
					String tesseraCons1 = res.getString("Numero_Tessera1");
					String tesseraCons2 = res.getString("Numero_Tessera2");
					String tesseraCons3 = res.getString("Numero_Tessera3");
					String tesseraCons4 = res.getString("Numero_Tessera4");
					String tesseraCons5 = res.getString("Numero_Tessera5");
					String tesseraCons6 = res.getString("Numero_Tessera6");
					String tesseraCons7 = res.getString("Numero_Tessera7");
					String tesseraCons8 = res.getString("Numero_Tessera8");
					
					// recupero dal loro db fino alla tessera del consigliere n8  perch
					// da un controllo le associazioni hanno solo fino a 8 consiglieri valorizzati
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date startDate = null;
					Date endDate = null;
					String sDate = StringPool.BLANK;
					String eDate = StringPool.BLANK;
					String code = StringPool.BLANK;
					ESFCard card = null;
					
					
					
					//se il campo  valorizzato, cerco la tessera e da quella poi recupero l'utente associato
					if (Validator.isNotNull(tesseraPresidente)){
						code = tesseraPresidente.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;   
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
							//le due date servono per chiudere il consiglio direttivo
							ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), president.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						}
						 
					}
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraVicPres1)){
						code = tesseraVicPres1.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), vicePresident.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);


						}
						
					}
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraVicPres2)){
						code = tesseraVicPres2.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), vicePresident.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
						
					}
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraSegretario)){
						code = tesseraSegretario.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), secretary.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
					
					}
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					;
					if (Validator.isNotNull(tesseraCons1)){
						code = tesseraCons1.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
					
					}
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraCons2)){
						code = tesseraCons2.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
					
					}
					
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraCons3)){
						code = tesseraCons3.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
					
					}
					
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraCons4)){
						code = tesseraCons4.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
					
						}
					
					}
					
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
				
					if (Validator.isNotNull(tesseraCons5)){
						code = tesseraCons5.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
					
						}
						
					}
					
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					code = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraCons6)){
						code = tesseraCons6.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
					
					}
					
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraCons7)){
						code = tesseraCons7.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
					
					}
					
					startDate = null;
					endDate = null;
					sDate = StringPool.BLANK;
					eDate = StringPool.BLANK;
					card = null;
					
					if (Validator.isNotNull(tesseraCons8)){
						code = tesseraCons8.trim();
						List<ESFCard> cards=ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization(code, org.getEsfOrganizationId());
						for (ESFCard c : cards){
							if (c.getCode().equals(code)){
								card = c;
							}
							
						}
						if (Validator.isNotNull(card)){
							sDate = "01/01/"+anno;
							eDate = "31/12/"+anno;
							startDate = format.parse(sDate);
							endDate = format.parse(eDate);
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(
								card.getEsfUserId(), counselor.getRoleId(), 
								org.getEsfOrganizationId(), startDate, endDate);
						
						}
					}
					
					_log.info("_end import ORG-->"+organization+" --Anno-->"+anno);
				}
				_log.info("_END IMPORT");
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
	
	public void migrationShooterSetDate(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMigrationPortlet.class.getName(), request);

			ShooterMigrationThreadTemp sht=new ShooterMigrationThreadTemp();
			sht.setServiceContext(serviceContext);
			sht.setJdbc(jdbc); 
			sht.setDbUrl(dbUrlL); 
			sht.setUser(user);
			sht.setPass(pass);

			Thread t=new Thread(sht);
			t.start();
	}
	
	public void updateShooter(ActionRequest request, ActionResponse response){
		UpdateUserSiteThread uus =new UpdateUserSiteThread();
		Thread t=new Thread(uus);
		t.start();
	}

	private void addField(
		ServiceContext serviceContext, Connection connection, long orgId,
		String codice, int yearField, int tabVideo, int tabMunuali,
		String accessoDis)
		throws SQLException, SystemException, PortalException {

		Statement statement = connection.createStatement();
		String selectOldStand = selectStand.replace("asscId", codice);
		ResultSet res = statement.executeQuery(selectOldStand);
		Date insertDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(insertDate);
		int year = cal.get(Calendar.YEAR);
		int count = 1; 
		//
		while (res.next()) {
			int cont1 = 0;
            int countMaxField = res.getInt("massimo") ;
            int contEL = res.getInt("Campi_EL");
            int contFO = res.getInt("Campi_FO");
            int contFU = res.getInt("Campi_FU");
            int contSK = res.getInt("Campi_SK");
        	int contPC = res.getInt("Campi_PC");
            int contDT = res.getInt("Campi_DT");
			long idBilliboad =
				tabVideo > 0
					? ESFBillboardType.ELECTRINIC : ESFBillboardType.MANUAL;
			boolean accesso =
				(accessoDis != null && accessoDis.equalsIgnoreCase("s"));
			User user = serviceContext.getThemeDisplay().getUser();
			
			ArrayList<Long> esfSportTypeId = new ArrayList<Long>();
			while (cont1<countMaxField){
            
			if (contFO>0){
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.FOSSAOLIMPICA);
				contFO--;
			}
			
			;
			if (contFU>0){
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.FOSSAUNIVERSALE);
				contFU--;
			}
			
			
			if (contSK>0){
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.SKEET);
				contSK--;
			}
			
			
			if (contDT>0){
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.DOUBLETRAP);
				contDT--;
			}
			
		
			if (contPC>0){
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.PERCORSOCACCIA);
				contPC--;
			}
			
			
			if (contEL>0){
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.ELECTROCIBLES);
				contEL--;
			}
			/*
			if (res.getString("Campi_FU").trim().equalsIgnoreCase(
				"true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.FOSSAUNIVERSALE);

			if (res.getString("Fossa_Automatica").trim().equalsIgnoreCase(
				"true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.FOSSAAUTOMATICA);

			if (res.getString("Sporting").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.SPORTING);

			if (res.getString("Trap_Americano").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.TRAPAMERICANO);

			if (res.getString("Volatile").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.VOLATILE);

			if (res.getString("Percorso_Caccia").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.PERCORSOCACCIA);

			if (res.getString("Skeet").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.SKEET);

			if (res.getString("ElectroCibles").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.ELECTROCIBLES);

			if (res.getString("Double_Trap").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.DOUBLETRAP);

			if (res.getString("Fintello").trim().equalsIgnoreCase("true"))
				esfSportTypeId.add(ESFKeys.ESFSportTypeId.FINTELLO);
			*/
			long[] stId = new long[esfSportTypeId.size()];

			for (int i = 0; i < esfSportTypeId.size(); i++) {
				stId[i] = esfSportTypeId.get(i);
			}
			_log.info("ESFField start  ");

			long esfStateId = ESFKeys.ESFStateType.DISABLE;
			if (yearField == year)
				esfStateId = ESFKeys.ESFStateType.ENABLE;

			ESFFieldLocalServiceUtil.addESFField(
				user.getUserId(), "campo" + count, orgId,
				(new Long(0)).longValue(), esfStateId, stId, "", idBilliboad,
				false, false, false, false, accesso,
				new ArrayList<ESFFieldESFElectronic>(), serviceContext);
			count++;
			cont1++;
			
			_log.info("ESFField end  ");
			}
		}
	}

	private void addService(
		ServiceContext serviceContext, long orgId, int segreteria,
		int salaRiposo, int salaRiunione, int armeria,
		int guardaroba, int wcU, int wcD, int bar,
		int ristorante, String altro1, int altro1Qyt, String altro2,
		int altro2Qyt)
		throws SystemException, PortalException {

		User user = serviceContext.getThemeDisplay().getUser();
		Date insertDate = new Date();

		long esfOrganizationUnitserviceId = 0;
			

		int count = segreteria;
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.SEGRETERIA);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}
        /*
		count = Integer.parseInt(segreteria);
		if (count > 0) {
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.SEGRETERIA);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}
		*/
		count = salaRiposo;
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.SALA_RIPOSO);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}

		count = armeria;
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.ARMERIA);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}

		count = guardaroba;
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.GUARDAROBA);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}

		count = wcU;
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.WC_UOMINI);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}

		count = wcD;
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.WC_DONNE);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}

		count = (bar);
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.BAR);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}

		count = (ristorante);
		if (count > 0) {
			esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
			ESFOrganizationUnitservice esfOrganizationUnitservice =
				ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
			esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
			esfOrganizationUnitservice.setGroupId(user.getGroupId());
			esfOrganizationUnitservice.setUserId(user.getUserId());
			esfOrganizationUnitservice.setUserName(user.getFullName());
			esfOrganizationUnitservice.setCreateDate(insertDate);
			esfOrganizationUnitservice.setModifiedDate(insertDate);
			esfOrganizationUnitservice.setEsfOrganizationId(orgId);
			esfOrganizationUnitservice.setEsfUnitserviceId(ESFKeys.ESFServiceTypeId.RISTORANTE);
			esfOrganizationUnitservice.setNumberUnitservices(count);

			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
		}

		if (Validator.isNotNull(altro1)) {

			long typeId = 0;
			if (altro1.toLowerCase().contains("parcheggi")) {
				typeId = ESFKeys.ESFServiceTypeId.PARCHEGGIO;
			}
			else if (altro1.toLowerCase().contains("riscaldam")) {
				typeId = ESFKeys.ESFServiceTypeId.IMPIANTI_RISCALDAMENTE_STAND;
			}
			else if (altro1.toLowerCase().contains("service")) {
				typeId = ESFKeys.ESFServiceTypeId.SELF_SERVICE;
			}
			else if (altro1.toLowerCase().contains("notturna")) {
				typeId = ESFKeys.ESFServiceTypeId.ILLUMINAZIONE_NOTTURNA;
			}
			else if (altro1.toLowerCase().contains("luci")) {
				typeId = ESFKeys.ESFServiceTypeId.ILLUMINAZIONE_NOTTURNA;
			}
			else if (altro1.toLowerCase().contains("campo")) {
				typeId = ESFKeys.ESFServiceTypeId.CAMPO_MULTIDIREZIONALE;
			}
			if (typeId > 0) {
				esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
				ESFOrganizationUnitservice esfOrganizationUnitservice =
					ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
				esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
				esfOrganizationUnitservice.setGroupId(user.getGroupId());
				esfOrganizationUnitservice.setUserId(user.getUserId());
				esfOrganizationUnitservice.setUserName(user.getFullName());
				esfOrganizationUnitservice.setCreateDate(insertDate);
				esfOrganizationUnitservice.setModifiedDate(insertDate);
				esfOrganizationUnitservice.setEsfOrganizationId(orgId);
				esfOrganizationUnitservice.setEsfUnitserviceId(typeId);
				esfOrganizationUnitservice.setDescription(altro1);

				if (Validator.isNotNull(altro1Qyt)) {
					count = altro1Qyt;
					if (count > 0)
						esfOrganizationUnitservice.setNumberUnitservices(count);
				}

				ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
			}
		}

		if (Validator.isNotNull(altro2)) {

			long typeId = 0;
			if (altro2.toLowerCase().contains("ricreativa")) {
				typeId = ESFKeys.ESFServiceTypeId.ZONA_RICREATIVA_TIRATORI;
			}
			else if (altro2.toLowerCase().contains("computer")) {
				typeId = ESFKeys.ESFServiceTypeId.COMPUTER_STAMPANTI;
			}
			else if (altro2.toLowerCase().contains("parcheggi")) {
				typeId = ESFKeys.ESFServiceTypeId.PARCHEGGIO;
			}
			else if (altro2.toLowerCase().contains("segreteria")) {
				typeId = ESFKeys.ESFServiceTypeId.SEGRETERIA;
			}

			if (typeId > 0) {
				esfOrganizationUnitserviceId = CounterLocalServiceUtil.increment(ESFOrganizationUnitservice.class.getName());
				ESFOrganizationUnitservice esfOrganizationUnitservice =
					ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(esfOrganizationUnitserviceId);
				esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
				esfOrganizationUnitservice.setGroupId(user.getGroupId());
				esfOrganizationUnitservice.setUserId(user.getUserId());
				esfOrganizationUnitservice.setUserName(user.getFullName());
				esfOrganizationUnitservice.setCreateDate(insertDate);
				esfOrganizationUnitservice.setModifiedDate(insertDate);
				esfOrganizationUnitservice.setEsfOrganizationId(orgId);
				esfOrganizationUnitservice.setEsfUnitserviceId(typeId);
				esfOrganizationUnitservice.setDescription(altro2);

				if (Validator.isNotNull(altro2Qyt)) {
					count = altro2Qyt;
					if (count > 0)
						esfOrganizationUnitservice.setNumberUnitservices(count);
				}

				ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(esfOrganizationUnitservice);
			}
		}

	}

	protected void validateType(long organizationType)
		throws PortalException {

		if (Validator.isNull(organizationType)) {

			throw new ESFOrganizationTypeException(
				"No ESFOrganization type found or his value is incorrect");
		}

		if (organizationType + 1 > ESFKeys.ESFOrganizationTypeLabel.length) {

			throw new ESFOrganizationTypeException(
				"This value [" +
					organizationType +
					"] is too high to have a children. Update ESFKeys.ESFOrganizationType and ESFKeys.ESFOrganizationTypeLabel and try again.");
		}
	}
	
	public void addNewCardOldShooter(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
		
				_log.info("entro nella portlet");
		
		String queryCard = "SELECT Indice,Anno,Tessera,Numero_Tiratore,Societa,Codice_Regione,Provincia, STR_TO_DATE(data_creazione, '%Y-%m-%d') as Data_Creazione,STR_TO_DATE(data_variazione, '%Y-%m-%d') as Data_Variazione,"+
							"substr(tessera,3) as codeNum from anagrate.tessere a;";
		
		
		long companyId = PortalUtil.getCompanyId(request);
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMigrationPortlet.class.getName(), request);

		Statement stat = null;
		Connection connection = null;
		try {
			// stabilisce la connessione
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrlL, user, pass);
			// interrogazone del db
			stat = connection.createStatement();

			ResultSet res = stat.executeQuery(queryCard);
			
			int rowcount = 0;
			if (res.last()) {
				rowcount = res.getRow();
				res.beforeFirst();
			}
			int counter = 1;
			_log.info("Number of item " + rowcount);
			
			while (res.next()) {
				
				_log.info("Processing item " + counter + " of " + rowcount);
				counter++;
				
				String userCodeS = res.getString("Numero_Tiratore");
				String orgCode = res.getString("Societa");
				
				String tessera = res.getString("Tessera");
				String provincia = res.getString("Provincia");
				
				String anno = res.getString("Anno");
				String indice = res.getString("Indice");
				Date dataCreazione = res.getDate("Data_Creazione");
				Date dataVariazione = res.getDate("Data_Variazione");
				int codeNum = res.getInt("codeNum");
				
				long userCode = Long.parseLong(userCodeS);
				
				long userId = 0;
				long orgId = 0;
				
				ESFUser user = new ESFUserImpl();
				ESFOrganization org = new ESFOrganizationImpl();
				
				try {
					user = ESFUserLocalServiceUtil.getESFUserByUserCode(userCode);
					userId = user.getEsfUserId();
				}
				catch (Exception e) {
					// TODO: handle exception
					_log.info("errore ricerca tiratore");
					_log.info(e);
				}
				
				try {
					org = ESFOrganizationLocalServiceUtil.findByCode(orgCode);
					orgId = org.getEsfOrganizationId();
				}
				catch (Exception e) {
					// TODO: handle exception
					_log.info("errore ricerca società");
					_log.info(e);
				}
				
				org = ESFOrganizationLocalServiceUtil.findByCode(orgCode);
				orgId = org.getEsfOrganizationId();
				
				_log.info("user="+user);
				_log.info("org="+org);
				_log.info("userId="+userId);
				_log.info("orgId="+orgId);
				_log.info("tessera="+tessera);
				_log.info("dataCreazione="+dataCreazione);
				_log.info("dataVariazione="+dataVariazione);
				_log.info("codeNum="+codeNum);
				_log.info("indice="+indice);
				
				
				
				long cardId =  CounterLocalServiceUtil.increment(ESFCard.class.getName());
				long esId =  CounterLocalServiceUtil.increment(ESFEntityState.class.getName());
				
				ESFCard card = new ESFCardImpl();
				ESFEntityState est = new ESFEntityStateImpl();
				
				//Date now = new Date();
				
				card.setUuid(serviceContext.getUuid());
				card.setEsfCardId(cardId);
				card.setUserId(10198);
				card.setGroupId(10793);
				card.setCompanyId(10154);
				card.setUserName("Test Test");
				card.setCreateDate(serviceContext.getCreateDate(dataCreazione));
				card.setModifiedDate(serviceContext.getModifiedDate(dataVariazione));
				card.setExpandoBridgeAttributes(serviceContext);
				card.setCodeAlfa(provincia);
				card.setCodeNum(codeNum);
				card.setCode(tessera);
				card.setEsfUserId(userId);
				card.setEsfOrganizationId(orgId);
				card.setOldCode(indice);
				ESFCardLocalServiceUtil.addESFCard(card);
				
				_log.info("fine creazione tessera :"+card);
				
				Date now = new Date();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				String createDateES = anno+"-01-01 00:00:00";
				
				int stateId = 1;
				Date endDate = null;
				
				if(Integer.parseInt(anno)  < 2018){
					_log.info("entro in < 2018");
					stateId = 2;
					String endDateS = anno+"-12-31 00:00:00";
					endDate = sdf.parse(endDateS);
				}

				sdf.parse(createDateES);
				
				_log.info("createDateES="+createDateES);
				_log.info("endDate="+endDate);
				_log.info("stateId="+stateId);
				
				est.setEsfEntityStateId(esId);
				est.setUserId(10198);
				est.setGroupId(10793);
				est.setCompanyId(10154);
				est.setUserName("Test Test");
				est.setCreateDate(serviceContext.getCreateDate(now));
				est.setModifiedDate(serviceContext.getModifiedDate(now));
				est.setClassName(ESFCard.class.getName());
				est.setClassPK(cardId);
				est.setEsfStateId(stateId);
				est.setStartDate(sdf.parse(createDateES));
				est.setEndDate(endDate);
				ESFEntityStateLocalServiceUtil.addESFEntityState(est);
				
				_log.info("fine creazione entity :"+est);
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
		_log.info("FINE");
	}
	

}