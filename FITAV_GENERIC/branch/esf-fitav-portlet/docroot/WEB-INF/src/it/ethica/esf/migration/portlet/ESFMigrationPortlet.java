
package it.ethica.esf.migration.portlet;

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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.ESFOrganizationTypeException;
import it.ethica.esf.migration.util.ESFKeys;
import it.ethica.esf.migration.util.ESFKeys.ESFBillboardType;
import it.ethica.esf.migration.util.ManageAddress;
import it.ethica.esf.migration.util.ShooterMigrationThread;
import it.ethica.esf.migration.util.ShooterMigrationThreadTemp;
import it.ethica.esf.migration.util.UpdateUserSiteThread;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFOrganizationUnitservice;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;

/**
 * Portlet implementation class EsfMigration
 */
public class ESFMigrationPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(ESFMigrationPortlet.class);
	private String jdbc = "com.mysql.jdbc.Driver";
//	private String dbUrlL = "jdbc:mysql://192.168.5.160:3306/societa";
//	private String user = "fitav";
//	private String pass =  "F1I2t3v4";
	
	private String dbUrlL = "jdbc:mysql://localhost:3306/societa";
	
	private String user = "root";
	private String pass =  "root";
	
	private String annoOrgMigration =  "2017";
	private String selectOrg ="SELECT a1.anno,a2.*,b.* FROM societa.affilia a1,societa.anagra a2,societa.Stand b where a2.CodiSo= b.CodiSo  and a1.codiSo = a2.codiSo and a1.anno>=annoOrgMigration and a1.data_versamento is not null "
						+"and STR_TO_DATE(b.data, '%Y-%m-%d') in (select MAX(STR_TO_DATE(data, '%Y-%m-%d')) from societa.Stand where CodiSo like a2.CodiSo) ";
			/* OLD SELECT
			 * "SELECT * FROM Anagra a, Stand b WHERE a.CodiSo= b.CodiSo "
						+ "and STR_TO_DATE(b.data, '%Y-%m-%d') in ("
						+ "select MAX(STR_TO_DATE(data, '%Y-%m-%d')) from Stand "
						+ "where CodiSo like a.CodiSo) "
						+ "and a.CodiSo in "
						+ "(SELECT Codice FROM import_fitav.societa)";*/
			
			
	private String selectStand =
		"SELECT *, greatest(Campi_FO,Campi_SK,Campi_FU,Campi_DT, Campi_PC,Campi_EL) AS 'massimo' "
			+ "FROM anagrate.societa where Codice like "
			+ "'asscId' ";
	
	private String selectShooter =
			 "select a.* from anagrate.anatiratori  a ,anagrate.tessere  t where a.codice =t.numero_tiratore and t.anno >= annoOrgMigration ";
	private String selectCard =
			"SELECT * FROM anagrate.Tessere "
					+"where numero_tiratore = 'id' " 
					 +"and Societa in (SELECT a2.codiSo FROM societa.affilia a1,societa.anagra a2 where a1.codiSo = a2.codiSo and a1.anno>=annoOrgMigration and a1.data_versamento is not null) "
					 +"and anno>= annoOrgMigration " 
					+"order by anno desc;";
	
	private String findLastCard ="select * FROM anagrate.Tessere where numero_tiratore = 'id' and anno in (select max(anno) FROM anagrate.Tessere where numero_tiratore = 'id' and anno>=2010 group by Numero_Tiratore);";
	
	private String selectBDO =
			 "SELECT * FROM societa.affilia "
			 + "where CodiSo in (select codice from anagrate.societa) "
			 + "and anno >= 2010 ";
	
	private String selectShooterFromGhost = " select * from anagrate.anatiratori  a  where a.codice in (23842,36350,96084,124508,124509,37141,86065,124510);";
	private String selectCardFromGhost ="SELECT * FROM anagrate.Tessere "
					+ "where numero_tiratore = 'id' " 
					+"and Societa in ('CN06','AG05') and year(Data_Pagamento) >= 2010 order by anno desc;";
	
	public void migrationOrganization(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long companyId=PortalUtil.getCompanyId(request);
		
		annoOrgMigration=ParamUtil.getString(request, "anno","2017");
		selectOrg=selectOrg.replace("annoOrgMigration", annoOrgMigration);
		int annoRif=Integer.parseInt(annoOrgMigration);
		
		
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

			ResultSet res = stat.executeQuery(selectOrg);
			System.out.println("A1:"+selectOrg);
			while (res.next()) {
				
				String name = res.getString("Denominazione_Societa").trim();
				String emailAddress =  res.getString("IndMail")!=null ? res.getString("IndMail").trim() : StringPool.BLANK;
				
				Organization organizationIn=OrganizationLocalServiceUtil.fetchOrganization(companyId, name);
				if(Validator.isNull(organizationIn)){
				
					String vat = res.getString("Partita_IVA") != null ? res.getString("Partita_IVA").trim() : StringPool.BLANK;
					String fiscalCode = res.getString("Codice_Fiscale") != null ? res.getString("Codice_Fiscale").trim() : StringPool.BLANK;
					String code = res.getString("CodiSo").trim() ;
					String ibanCode = StringPool.BLANK;
					String tmp = res.getString("Stato_Societa").trim();
					long esfStateId = ESFKeys.ESFStateType.DISABLE;
					if (tmp.equalsIgnoreCase("SC")) {
						esfStateId = ESFKeys.ESFStateType.LOOSE;
					}
					else if (tmp.equalsIgnoreCase("SO")) {
						esfStateId = ESFKeys.ESFStateType.SUSPENDED;
					}
					else if (tmp.equalsIgnoreCase("SP")) {
						esfStateId = ESFKeys.ESFStateType.SUSPENSION;
					}
					else if (tmp.equalsIgnoreCase("SA")) {
						esfStateId = ESFKeys.ESFStateType.SUSPENSION_ASSEMBLY;
					}
					boolean isMultiSport = false;
					String legalForm = "12021";
					String category = "12026";
					String coniCode = StringPool.BLANK;
					Date insertDate = new Date();
					String annotaz = res.getString("Annotaz") !=null ? 
							res.getString("Annotaz").trim() 
							: StringPool.BLANK;
					String annotaz250 = res.getString("Annotaz250") !=null ? 
									res.getString("Annotaz250")
									: StringPool.BLANK;
					String description =
							annotaz + " | " +
									annotaz250;
					boolean isYouthActive = false;
					String es = res.getString("Data_Costituzione").trim();
					String fad = res.getString("Data_Prima_Affiliazione").trim();
					Date establishmentDate = null;
					Date firstAffiliationDate = null;
					SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
					
					try {
						//establishmentDate = ManageDate.StringToDate(es);
						establishmentDate =format.parse(es);
						//firstAffiliationDate = ManageDate.StringToDate(fad);
						firstAffiliationDate =format.parse(fad);
					}
					catch (ParseException e1) {
						e1.printStackTrace();
						throw new PortalException(e1);
					}
	
					_log.info("End Set Param ");
	
					_log.info("Adding Organization");
	
					ESFAddress esfAddress =
						ESFAddressLocalServiceUtil.createESFAddress(0);
					esfAddress.setWrapper(true);
					esfAddress.setEsfAddressId(0);
					esfAddress.setLongitude(0);
					esfAddress.setLatitude(0);
					esfAddress.setEsfCountryId("IT");
	
					esfAddress.setEsfRegionId(ManageAddress.getRegionId(res.getString(
						"Regione_Societa").trim()));
					String provincia = res.getString("Provincia_Societa").trim();
					esfAddress.setEsfProvinceId(provincia);
	
					esfAddress.setEsfCityId(ManageAddress.getCityId(res.getString(
						"Localita_Societa").trim()));
					String indirizzo_societa = res.getString("Indirizzo_Societa") != null ?
							res.getString("Indirizzo_Societa").trim() : StringPool.BLANK;
					esfAddress.setStreet1(indirizzo_societa);
					esfAddress.setStreet2(null);
					esfAddress.setStreet3(null);
					esfAddress.setZip(res.getString("Cap_Societa").trim());
					esfAddress.setTypeId(12000);
					esfAddress.setMailing(false);
					esfAddress.setPrimary_(false);
					esfAddress.setListTypeId(ESFKeys.ESFAddressType.LEGAL);
					_log.info("Provincia Societ�-->"+provincia);
					long parentOrganizationId = getParentOrganizationId(esfAddress);
	
					_log.info("Find parentOrganizationId " + parentOrganizationId);
					
					
					Organization organization  =
						OrganizationLocalServiceUtil.addOrganization(
							serviceContext.getUserId(), parentOrganizationId, name,
							"regular-organization", 0, 0, 12017, StringPool.BLANK, true,
							serviceContext);
					Group organizationGroup = organization.getGroup();
					ESFOrganization parentESFOrganization =
						ESFOrganizationLocalServiceUtil.fetchESFOrganization(parentOrganizationId);
					long portalOrganizationId = organization.getOrganizationId();
					int esfOrganizationtype = 0;
					if (Validator.isNull(parentESFOrganization)){
						esfOrganizationtype = 1;
						System.out.println("PARENT NULL-->parentId:"+parentOrganizationId);
					}
					else {
						esfOrganizationtype = parentESFOrganization.getType() + 1;
					}
					validateType(esfOrganizationtype);
					ESFEntityStateLocalServiceUtil.addEntityState(
						serviceContext.getUserId(),
						ESFOrganization.class.getName(), portalOrganizationId,
						esfStateId, serviceContext);
					ESFOrganization esfOrganization =
						ESFOrganizationLocalServiceUtil.createESFOrganization(portalOrganizationId);
					esfOrganization.setUuid(serviceContext.getUuid());
					esfOrganization.setCode(code);
					esfOrganization.setVat(vat);
					esfOrganization.setFiscalCode(fiscalCode);
					esfOrganization.setIbanCode(ibanCode);
					esfOrganization.setEstablishmentDate(establishmentDate);
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
					esfOrganization.setFirstAffiliationDate(firstAffiliationDate);
					esfOrganization.setDescription(description);
	
					ESFOrganizationLocalServiceUtil.updateESFOrganization(esfOrganization);
					
					// set layout template to associations
					try {
						_log.info("Start layout template");
						String uuid = "1d970b3a-2fef-463d-b291-e419799746e2";		
					Group organizationSite = GroupLocalServiceUtil.getOrganizationGroup(esfOrganization.getCompanyId(), esfOrganization.getEsfOrganizationId()) ;
					// getGroups(org.getEsfOrganizationId()).get(0);
					//LayoutSet layout = LayoutSetLocalServiceUtil.getLayoutSet(layoutSetId);
					LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(organizationSite.getGroupId(), true, true,uuid );
					LayoutLocalServiceUtil.updatePriorities(organizationSite.getGroupId(), true);
					LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(organizationSite.getGroupId(), true);
					SitesUtil.mergeLayoutSetPrototypeLayouts(organizationSite, layoutSet);
					/*	
				  	long publicLayoutSetPrototypeId = 0;
						long privateLayoutSetPrototypeId = 0;
	
						privateLayoutSetPrototypeId =
							esfOrganization.getDefaultLayoutSetPrototypeId(false);
	
						SitesUtil.updateLayoutSetPrototypesLinks(
							organizationGroup, publicLayoutSetPrototypeId,
							privateLayoutSetPrototypeId, false, true);
	
						LayoutSet layoutSet =
							LayoutSetLocalServiceUtil.getLayoutSet(
								organizationGroup.getGroupId(), true);
						SitesUtil.mergeLayoutSetPrototypeLayouts(
							organizationGroup, layoutSet);
							*/
					}
					catch (Exception e) {
						_log.info("Errore layout template--->orgId"+esfOrganization.getEsfOrganizationId());
						e.printStackTrace();
					}
					_log.info("End layout template");
					 // end layout template 
					
					ResourceLocalServiceUtil.addResources(
						serviceContext.getCompanyId(),
						serviceContext.getScopeGroupId(),
						serviceContext.getUserId(),
						ESFOrganization.class.getName(), portalOrganizationId,
						false, true, true);
	
					ESFAddressLocalServiceUtil.addESFAddress(
						serviceContext.getUserId(), esfAddress.getLongitude(),
						esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
						esfAddress.getLatitude(), esfAddress.getType(),
						esfAddress.getListTypeId(),
						"com.liferay.portal.model.Organization",//organization.getClass().getName(),
						esfOrganization.getEsfOrganizationId(),
						esfAddress.getStreet1(), esfAddress.getStreet2(),
						esfAddress.getStreet3(), esfAddress.getZip(), 12000,
						esfAddress.getMailing(), esfAddress.getPrimary_(),
						serviceContext);
	
					esfAddress = ESFAddressLocalServiceUtil.createESFAddress(0);
					esfAddress.setWrapper(true);
					esfAddress.setEsfAddressId(0);
					esfAddress.setLongitude(0);
					esfAddress.setLatitude(0);
					esfAddress.setEsfCountryId("IT");
	
					esfAddress.setEsfRegionId(ManageAddress.getRegionIdFromProvince(
						connection, res.getString("Provincia_Postale").trim()));
	
					esfAddress.setEsfProvinceId(res.getString("Provincia_Postale").trim());
	
					esfAddress.setEsfCityId(ManageAddress.getCityId(res.getString(
						"Localita_Postale").trim()));
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
						esfOrganization.getEsfOrganizationId(),
						esfAddress.getStreet1(), esfAddress.getStreet2(),
						esfAddress.getStreet3(), esfAddress.getZip(), 12000,
						esfAddress.getMailing(), esfAddress.getPrimary_(),
						serviceContext);
	
					// addresses.add(esfAddress);
	
					esfAddress = ESFAddressLocalServiceUtil.createESFAddress(0);
					esfAddress.setWrapper(true);
					esfAddress.setEsfAddressId(0);
					esfAddress.setLongitude(0);
					esfAddress.setLatitude(0);
					esfAddress.setEsfCountryId("IT");
	
					esfAddress.setEsfRegionId(ManageAddress.getRegionIdFromProvince(
						connection, res.getString("Provincia").trim()));
	
					esfAddress.setEsfProvinceId(res.getString("Provincia").trim());
	
					esfAddress.setEsfCityId(ManageAddress.getCityId(res.getString(
						"Localita").trim()));
	
					esfAddress.setStreet1(res.getString("Indirizzo").trim());
					esfAddress.setStreet2(null);
					esfAddress.setStreet3(null);
					esfAddress.setZip(res.getString("CAP").trim());
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
						esfOrganization.getEsfOrganizationId(),
						esfAddress.getStreet1(), esfAddress.getStreet2(),
						esfAddress.getStreet3(), esfAddress.getZip(), 12000,
						esfAddress.getMailing(), esfAddress.getPrimary_(),
						serviceContext);
		          
					// addresses.add(esfAddress);
	
					_log.info("End Address ");
	
					List<ESFPhone> phones = new ArrayList<ESFPhone>();
	
					ESFPhone phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
					String prefisso_Tel1 = res.getString("Prefisso_Tel1") != null ?
							res.getString("Prefisso_Tel1").trim() : StringPool.BLANK;
					String telefono1 = res.getString("Telefono1") != null ?
									res.getString("Telefono1").trim() : StringPool.BLANK;
					String phoneNumber = prefisso_Tel1
						 + " " +
						 telefono1;
					phone.setNumber(phoneNumber);
					phone.setListTypeId(ESFKeys.ESFPhoneListType.BUSINESS);
					phone.setTypeId(12008);
					if (Validator.isNotNull(phoneNumber)) {
						phones.add(phone);
					}
	
					phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
					String prefisso_Tel2 = res.getString("Prefisso_Tel2") != null ?
							res.getString("Prefisso_Tel2").trim() : StringPool.BLANK;
					String telefono2 = res.getString("Telefono2") != null ?
									res.getString("Telefono2").trim() : StringPool.BLANK;
					phoneNumber = prefisso_Tel2
											 + " " +
											 telefono2;
					phone.setNumber(phoneNumber);
					phone.setListTypeId(ESFKeys.ESFPhoneListType.MOBILE);
					phone.setTypeId(12008);
					if (Validator.isNotNull(phoneNumber)) {
						phones.add(phone);
					}
	
					phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
					String prefisso_Tel3 = res.getString("Prefisso_Tel3") != null ?
							res.getString("Prefisso_Tel3").trim() : StringPool.BLANK;
					String telefono3 = res.getString("Telefono3") != null ?
									res.getString("Telefono3").trim() : StringPool.BLANK;
					phoneNumber = prefisso_Tel3
											 + " " +
											 telefono3;
					phone.setNumber(phoneNumber);
					phone.setListTypeId(ESFKeys.ESFPhoneListType.PERSONAL);
					phone.setTypeId(12008);
					if (Validator.isNotNull(phoneNumber)) {
						phones.add(phone);
					}
	
					phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
					String pref1 = res.getString("Pref1") != null ?
							res.getString("Pref1").trim() : StringPool.BLANK;
					String tel1 = res.getString("Tel1") != null ?
									res.getString("Tel1").trim() : StringPool.BLANK;
					phoneNumber = pref1
											 + " " +
											 tel1;
					phone.setNumber(phoneNumber);
					phone.setListTypeId(ESFKeys.ESFPhoneListType.OTHER);
					phone.setTypeId(12008);
					if (Validator.isNotNull(phoneNumber)) {
						phones.add(phone);
					}
	
					phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
					String pref2 = res.getString("Pref2") != null ?
							res.getString("Pref2").trim() : StringPool.BLANK;
					String tel2 = res.getString("Tel2") != null ?
									res.getString("Tel2").trim() : StringPool.BLANK;
					phoneNumber = pref2  + " " +
											 tel2;
					phone.setNumber(phoneNumber);
					phone.setListTypeId(ESFKeys.ESFPhoneListType.BUSINESSFAX);
					phone.setTypeId(12008);
					if (Validator.isNotNull(phoneNumber)) {
						phones.add(phone);
					}
	
					phone = ESFPhoneLocalServiceUtil.createESFPhone(0);
					String preF = res.getString("PreF") != null ?
							res.getString("PreF").trim() : StringPool.BLANK;
					String fax = res.getString("FAX") != null ?
									res.getString("FAX").trim() : StringPool.BLANK;
					phoneNumber = preF + " " +
											 fax;
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
							esfOrganization.getEsfOrganizationId(),
							phone1.getNumber(), StringPool.BLANK,
							phone1.getListTypeId(), phone1.getTypeId(), first,
							serviceContext);
	
						first = false;
					}
	
					List<ListType> emailListType =
						ListTypeServiceUtil.getListTypes(Organization.class.getName() +
							ListTypeConstants.EMAIL_ADDRESS);
	
					int typeId = 0;
					if (emailListType.size() > 0) {
						typeId = emailListType.get(0).getListTypeId();
					}
					if (emailAddress.equals(StringPool.BLANK)|| !Validator.isEmailAddress(emailAddress)){
						emailAddress = code + "@fitavprova.it";
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
							res.getString("AccDisab").trim() : StringPool.BLANK;
					String date = res.getString("Data").trim();
					SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
					Date dataYear =formatDate.parse(date);
					Calendar cal = Calendar.getInstance();
					cal.setTime(dataYear);
					int year = cal.get(Calendar.YEAR);
					
					/*int year =
						Integer.parseInt(date.substring(date.lastIndexOf("/") + 1)); */
					_log.info("Start addField ");
					addField(
						serviceContext, connection,
						esfOrganization.getEsfOrganizationId(), code, year,
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
	
					_log.info("End addService ");
				}else{
					String tmp = res.getString("Stato_Societa").trim();
					long esfStateId = ESFKeys.ESFStateType.DISABLE;
					if (tmp.equalsIgnoreCase("SC")) {
						esfStateId = ESFKeys.ESFStateType.LOOSE;
					}
					else if (tmp.equalsIgnoreCase("SO")) {
						esfStateId = ESFKeys.ESFStateType.SUSPENDED;
					}
					else if (tmp.equalsIgnoreCase("SP")) {
						esfStateId = ESFKeys.ESFStateType.SUSPENSION;
					}
					else if (tmp.equalsIgnoreCase("SA")) {
						esfStateId = ESFKeys.ESFStateType.SUSPENSION_ASSEMBLY;
					}
					boolean finded=false;
					List<ESFEntityState> states= ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(ESFOrganization.class.getName(), organizationIn.getOrganizationId());
					for (ESFEntityState esfEntityState : states) {
						if(Validator.isNull(esfEntityState.getEndDate()) && esfEntityState.getStartDate().getYear()< annoRif ){
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
					
					
					if(!finded){
						ESFEntityState esfEntityState =
						ESFEntityStateLocalServiceUtil.addEntityState(
							serviceContext.getUserId(), ESFOrganization.class.getName(), organizationIn.getOrganizationId(),
							esfStateId, serviceContext);

						ESFEntityStateLocalServiceUtil.updateESFEntityState(esfEntityState);
					}
					
				}
			}//fine while
			
			_log.info("End MIGRATION ");
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

		annoOrgMigration=ParamUtil.getString(request, "anno","2017");
		selectShooter=selectShooter.replace("annoOrgMigration", annoOrgMigration);
		selectCard=selectCard.replace("annoOrgMigration", "2010");
		int annoRif=Integer.parseInt(annoOrgMigration);
		
		
		_log.info("selectShooter "+selectShooter);
		_log.info("selectCard "+selectCard);
		_log.info("findLastCard "+findLastCard);
		
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMigrationPortlet.class.getName(), request);

		ShooterMigrationThread sht=new ShooterMigrationThread();
		sht.setServiceContext(serviceContext);
		sht.setJdbc(jdbc); 
		sht.setDbUrl(dbUrlL); 
		sht.setUser(user);
		sht.setPass(pass);
		sht.setSelectShooter(selectShooter);
		sht.setSelectCard(selectCard);
		sht.setFindLastCard(findLastCard);
		sht.setAnnoRif(annoRif);
		Thread t=new Thread(sht);
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
		List<ESFCard> cards = ESFCardLocalServiceUtil.getESFCards(-1, -1);
			try {
				// stabilisce la connessione
				Class.forName(jdbc);
				connection = DriverManager.getConnection(dbUrlL, user, pass);
				// interrogazone del db
				stat = connection.createStatement();

				ResultSet res = stat.executeQuery(selectBDO);
				
				while (res.next()) {
					
					String organization = res.getString("codiSo");
					String anno = res.getString("Anno");
					_log.info("_start import ORG-->"+organization+" --Anno-->"+anno);
					ESFOrganization org = ESFOrganizationLocalServiceUtil.findByCode(organization);
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
					
					// recupero dal loro db fino alla tessera del consigliere n�8  perch�
					// da un controllo le associazioni hanno solo fino a 8 consiglieri valorizzati
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date startDate = null;
					Date endDate = null;
					String sDate = StringPool.BLANK;
					String eDate = StringPool.BLANK;
					String code = StringPool.BLANK;
					ESFCard card = null;
					
					
					//se il campo � valorizzato, cerco la tessera e da quella poi recupero l'utente associato
					if (Validator.isNotNull(tesseraPresidente)){
						code = tesseraPresidente.trim();
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
	
	private long getParentOrganizationId(ESFAddress esfAddress)
		throws SystemException {

		ESFOrganization esfOrganization =
			ESFOrganizationLocalServiceUtil.findByCode(esfAddress.getEsfProvinceId());
           
		return esfOrganization.getEsfOrganizationId();
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
	
	
	
	/*
		public void migrationLayoutOrganization(
			ActionRequest request, ActionResponse response)
		throws Exception {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMigrationPortlet.class.getName(), request);
			List<ESFOrganization> esfAssociazioni = ESFOrganizationLocalServiceUtil.findAllESFOrganizations(3, 2);
			
			System.out.println ("size:"+esfAssociazioni.size());
			
			for (ESFOrganization org : esfAssociazioni){
				
			
		   String uuid = "1d970b3a-2fef-463d-b291-e419799746e2";
			Group organizationSite = GroupLocalServiceUtil.getOrganizationGroup(org.getCompanyId(), org.getEsfOrganizationId()) ;
			// getGroups(org.getEsfOrganizationId()).get(0);
			  //LayoutSet layout = LayoutSetLocalServiceUtil.getLayoutSet(layoutSetId);
			  LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(organizationSite.getGroupId(), true, true,uuid );
			  LayoutLocalServiceUtil.updatePriorities(organizationSite.getGroupId(), true);
			  LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(organizationSite.getGroupId(), true);
			  SitesUtil.mergeLayoutSetPrototypeLayouts(organizationSite, layoutSet);
			}
			System.out.println ("fine");
		}

	*/
	
	

	

	

	

}