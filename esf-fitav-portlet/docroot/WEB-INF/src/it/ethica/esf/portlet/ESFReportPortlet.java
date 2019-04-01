package it.ethica.esf.portlet;
import it.ethica.esf.model.ESFBrand;
import it.ethica.esf.model.ESFElectronic;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFState;
import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.service.ESFBrandLocalServiceUtil;
import it.ethica.esf.service.ESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFStateLocalServiceUtil;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.util.ConiReport;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFListType;
import it.ethica.esf.util.ESFServiceUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.persistence.OrganizationUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mysql.jdbc.Connection;

/**
 * Portlet implementation class ESFReportPortlet
 */
public class ESFReportPortlet extends MVCPortlet {

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {

		String resourceID = request.getResourceID();
		boolean genrateStandAndServiceReport = ParamUtil.getBoolean(request, "genrateStandAndServiceReport");
		boolean genrateBDOReport = ParamUtil.getBoolean(request, "genrateBDOReport");
		boolean genrateBDORoleReport = ParamUtil.getBoolean(request, "genrateBDORoleReport");
		boolean genrateCompanyCategoryReport = ParamUtil.getBoolean(request, "genrateCompanyCategoryReport");
		boolean genrateVariationReport = ParamUtil.getBoolean(request, "genrateVariationReport");
		boolean genrateShooterReport = ParamUtil.getBoolean(request, "genrateShooterReport");
		boolean generateNationalReport = ParamUtil.getBoolean(request, "generateNationalReport");
		boolean genrateNormalMatchReport = ParamUtil.getBoolean(request, "genrateNormalMatchReport");
		boolean genrateNationalMatchReport = ParamUtil.getBoolean(request, "genrateNationalMatchReport");
		boolean genrateNatonalAssemblyReport = ParamUtil.getBoolean(request, "genrateNatonalAssemblyReport");
		boolean generateShootersAndCategoryReport = ParamUtil.getBoolean(request, "generateShootersAndCategoryReport");
		boolean genrateShooterNoRenewalReportReport = ParamUtil.getBoolean(request, "genrateShooterNoRenewalReportReport");
		boolean generateSummaryShooterReport = ParamUtil.getBoolean(request, "generateSummaryShooterReport");
		boolean generateSummaryShooterYearReportReport = ParamUtil.getBoolean(request, "generateSummaryShooterYearReportReport");
		boolean generateSummaryShooterSocReport = ParamUtil.getBoolean(request, "generateSummaryShooterSocReport");
		boolean genrateConiReport = ParamUtil.getBoolean(request, "genrateConiReport");
		
		HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(request);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		
		HttpServletResponse httpResp = PortalUtil.getHttpServletResponse(response);
	
		
		if(Validator.isNotNull(resourceID)){
			if (resourceID.equals("getProvinceReportBDO") || resourceID.equals("getProvinceReportStand") ||
					resourceID.equals("getProvinceReportAss") || resourceID.equals("getProvinceReportSH")
					|| resourceID.equals("getProvinceReportMatch")) {
			
				try {
					ESFServiceUtil esfServiceUtil =
							new ESFServiceUtil(ESFUser.class.getName(), request);
					String param =
							PortalUtil.getOriginalServletRequest(httpReq).getParameter(
								"param");
					String idEsfOrganization =
							PortalUtil.getOriginalServletRequest(httpReq).getParameter(
								"regionId");
					esfServiceUtil.serveOrganization(
							request, response, param, idEsfOrganization);
						
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (resourceID.equals("getOrganizationBDO") || resourceID.equals("getOrganizationStand") ||
					resourceID.equals("getOrganizationAss") || resourceID.equals("getOrganizationSH")
					|| resourceID.equals("getOrganizationMatch")) {
				
				try {
					ESFServiceUtil esfServiceUtil =
							new ESFServiceUtil(ESFUser.class.getName(), request);
					String param =
							PortalUtil.getOriginalServletRequest(httpReq).getParameter(
								"param");
					String idEsfOrganization =
							PortalUtil.getOriginalServletRequest(httpReq).getParameter(
								"regionId");
					esfServiceUtil.serveOrganization(
							request, response, param, idEsfOrganization);
						
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		String connectionURL = PropsUtil.get("jdbc.default.url");
		String userName = PropsUtil.get("jdbc.default.username");
		String password = PropsUtil.get("jdbc.default.password");
		
		if(genrateStandAndServiceReport){
			
			ESFOrganization org = new ESFOrganizationImpl();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;

			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				long stateStandId = ParamUtil.getLong(request, "stateIdValue");
				int numField = ParamUtil.getInteger(request, "nFieldsValue");
				long selBillboard = ParamUtil.getLong(request, "selBillboard");
				long electronic = ParamUtil.getLong(request, "electronic");
				long brand = ParamUtil.getLong(request, "brand");
				boolean backgroundRampartIdB = ParamUtil.getBoolean(request, "backgroundRampart");
				boolean billboardStationsIdB = ParamUtil.getBoolean(request, "billboardStations");
				boolean backgroundNetIdB = ParamUtil.getBoolean(request, "backgroundNet");
				boolean backgroundLeadRecoveryIdB = ParamUtil.getBoolean(request, "backgroundLeadRecovery");
				boolean disabledAccessIdB = ParamUtil.getBoolean(request, "disabledAccess");
				String[] valuesSportType = ParamUtil.getParameterValues(request, "valuesSportType", new String[0]);
				String[] valuesServices = ParamUtil.getParameterValues(request, "valuesServices", new String[0]);

				String backgroundRampartId = "";
				String billboardStationsId = "";
				String backgroundNetId = "";
				String backgroundLeadRecoveryId = "";
				String disabledAccessId = "";
				String sportTypeId = "(";
				String unitserviceId = "(";
				String billboardId = "(";
				String electronicId = "(";
				String brandId = "(";
				
				String orgName = "";
				String stateName = "Stato campo:";
				String sportTypeName = "Specialità:";
				String unitserviceName = "Servizi:";
				String nemberFieldName = "numero minimo di campi:" ;
				String bilboardName = "tabellone:";
				String backgroundRampartName = "";
				String billboardStationsName = "";
				String backgroundNetName = "";
				String backgroundLeadRecoveryName = "";
				String disabledAccessName = "";
				String electronicName = "elettronica:";
				String brandName = "marca:";

				List<ESFElectronic> esfElectronics = ESFElectronicLocalServiceUtil.findAll();
			
				List<ESFBrand> esfBrands = ESFBrandLocalServiceUtil.findAll();

				if(0 == electronic){
					electronicId = "";
				}else{
					electronicId = "and ffe.electronicId in ("+ String.valueOf(electronic) + ")";
					electronicName = electronicName+ESFElectronicLocalServiceUtil.fetchESFElectronic(electronic).getName();
				}
				
				if(0 == brand){
					brandId = "";
				}else{
					brandId = "and ffe.brandId in("+ String.valueOf(brand) + ")";
					brandName = brandName + ESFBrandLocalServiceUtil.fetchESFBrand(brand).getName();
				}
				
				if(backgroundRampartIdB){
					backgroundRampartName = "Presente terrapieno";
					backgroundRampartId = "(true)";
				}else{
					backgroundRampartId = "(false , true)";
				}
				
				if(billboardStationsIdB){
					billboardStationsName = "Presenti tabelloni per le postazioni di tiro";
					billboardStationsId = "(true)";
				}else{
					billboardStationsId = "(false , true)";
				}
				
				if(backgroundNetIdB){
					backgroundNetName = "Presente rete";
					backgroundNetId = "(true)";
				}else{
					backgroundNetId = "(false , true)";
				}
				
				if(backgroundLeadRecoveryIdB){
					backgroundLeadRecoveryName = "Presente recuper piombo";
					backgroundLeadRecoveryId = "(true)";
				}else{
					backgroundLeadRecoveryId = "(false , true)";
				}
				
				if(disabledAccessIdB){
					disabledAccessName = "Presente accesso disabili";
					disabledAccessId =  "(true)";
				}else{
					disabledAccessId = "(false , true)";
				}
				
				Date d = new Date();
				String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				if(0 != associationId){

					org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(associationId);
					orgName = org.getName();

				}else if( 0 == associationId && 0 != provinceId){

					org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(provinceId);
					orgName = org.getName(); 

				}else if(0 == provinceId &&  0 != regionId){

					org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(regionId);
					orgName = org.getName();

				}else{

					Organization organization = OrganizationUtil.fetchByPrimaryKey(currentOrganizationId);
					orgName = organization.getName();
				}
				

				List<ESFSportType> sportTpyes = new ArrayList<ESFSportType>();
				List<ESFUnitservice> unitServices = new ArrayList<ESFUnitservice>();
				sportTpyes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
				unitServices = ESFUnitserviceLocalServiceUtil.getAllESFUnitservices();
				
				for(ESFSportType s : sportTpyes){
					sportTypeId = sportTypeId +s.getEsfSportTypeId() + ",";
				}
				
				sportTypeId = sportTypeId+")";
				sportTypeId = sportTypeId.replace(",)", ")");
				
				for( ESFUnitservice u : unitServices){
					unitserviceId = unitserviceId + u.getEsfUnitserviceId() + ",";
				}
				
				unitserviceId = unitserviceId + ")";
				unitserviceId = unitserviceId.replace(",)", ")");
				
				List<ListType> billboards =  ListTypeServiceUtil.
						getListTypes(ESFField.class.getName() + ESFListType.BILLBOARD);
				
				for(ListType b : billboards){
					billboardId = billboardId + b.getListTypeId() + ",";
				}
				
				billboardId = billboardId +")";
				billboardId = billboardId.replace(",)", ")");
				
				List<ESFState> standStates = new ArrayList<ESFState>();
				standStates = ESFStateLocalServiceUtil.findAllESFStates();
				String assId = "";
				String state = "";
				String standState = "";
				int numberMinFields = 0;

				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				//String connectionURL = "jdbc:mysql://127.0.0.1:3306/fitav";
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				// selezione id delle società da controllare figlie di quella selezionata
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}

				// controllo stato dei campi interessati
				state = "(";
				if(0 == stateStandId){
					
					for(ESFState s : standStates){
						state = state +" " +s.getEsfStateId() +" , ";
					}
					state = state + ")";
					state = state.replace(", )", ")");
					stateName = stateName + "tutti";
					
				}else{
					
					state = state  + String.valueOf(stateStandId) + ")";
					stateName = stateName + ESFStateLocalServiceUtil.fetchESFState(stateStandId).getName();
				}
				
				// numero minimo di campi 
				
				if(numField > 0){
					numberMinFields = numField;
					nemberFieldName = nemberFieldName +String.valueOf(numField);
				}else{
					nemberFieldName = nemberFieldName + "0";
				}

				// setto id delle specialità da ricercare
				
				if(valuesSportType.length > 0){
					sportTypeId  ="(";
					for(String vdp : valuesSportType){
						sportTypeId = sportTypeId + vdp + ",";
						sportTypeName = sportTypeName + " " + ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(vdp)).getName();
					}
					sportTypeId = sportTypeId +")";
					sportTypeId = sportTypeId.replace(",)", ")");
				}
				
				unitserviceId = "";
				
				if(valuesServices.length > 0){
					unitserviceId = "and ous.esfUnitserviceId in (";
					for(String us : valuesServices){
						unitserviceId = unitserviceId + us + ",";
						unitserviceName = unitserviceName + " " + ESFUnitserviceLocalServiceUtil.fetchESFUnitservice(Long.valueOf(us)).getDescription();
					}
					unitserviceId = unitserviceId +")";
					unitserviceId = unitserviceId.replace(",)", ")");
				}
				
				int spotTypecount = 0;
				int serviceCount = 0;
				spotTypecount = ESFSportTypeLocalServiceUtil.getAllESFSportTypes().size();
				serviceCount = ESFUnitserviceLocalServiceUtil.getAllESFUnitservices().size();
				
				if(valuesSportType.length == spotTypecount || 0 == valuesSportType.length){
					sportTypeName = "tutte le specialità";
				}
				if(serviceCount == valuesServices.length || 0 == valuesServices.length ){
					unitserviceName = "tutti i servizi";
				}
				
				// setto il tipo di tabellone 
				
				if( selBillboard > 0){
					
					billboardId = "("+ selBillboard+ ")";
					bilboardName = bilboardName +  ListTypeServiceUtil.getListType((int) selBillboard).getName();
				}else{
					bilboardName = bilboardName + "tutti";
				}

				map.put("orgName", orgName);
				map.put("_year", year);
				map.put("stateId", state);
				map.put("numberMinFields", numberMinFields);
				map.put("sportTypeId", sportTypeId);
				map.put("billboardId", billboardId);
				map.put("backgroundRampartId", backgroundRampartId);
				map.put("billboardStationsId", billboardStationsId);
				map.put("backgroundNetId", backgroundNetId);
				map.put("backgroundLeadRecoveryId", backgroundLeadRecoveryId);
				map.put("disabledAccessId", disabledAccessId);
				map.put("electronicId", electronicId);
				map.put("brandId", brandId);
				map.put("unitserviceId", unitserviceId);
				
				map.put("stateName", stateName);
				map.put("sportTypeName", sportTypeName);
				map.put("nemberFieldName", nemberFieldName);
				map.put("bilboardName", bilboardName);
				map.put("billboardStationsName", billboardStationsName);
				map.put("backgroundRampartName", backgroundRampartName);
				map.put("backgroundNetName", backgroundNetName);
				map.put("backgroundLeadRecoveryName", backgroundLeadRecoveryName);
				map.put("disabledAccessName", disabledAccessName);
				map.put("electronicName", electronicName);
				map.put("brandName", brandName);
				map.put("unitserviceName", unitserviceName);

				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Stand Report.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);

				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Report Stand.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(genrateBDOReport){
			
			ESFOrganization org = new ESFOrganizationImpl();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				long stateAssociationId = ParamUtil.getLong(request, "stateIdValue");
				String stateOrg = "(";
				
				Date d = new Date();
				String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				// selezione id delle società da controllare figlie di quella selezionata
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}
				
				List<ESFState> states = new ArrayList<ESFState>();
				states = ESFStateLocalServiceUtil.findAllESFStates();
				
				if(stateAssociationId > 0){
					stateOrg = stateOrg + stateAssociationId + ")";
				}else{
					for(ESFState s : states){
						stateOrg = stateOrg +" " +s.getEsfStateId() +" , ";
					}
					stateOrg = stateOrg + ")";
					stateOrg = stateOrg.replace(", )", ")");
				}
				
				map.put("stateId", stateOrg);
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Consiglio Report.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Consiglio Direttivo Report.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(genrateBDORoleReport){

			ESFOrganization org = new ESFOrganizationImpl();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				long rolesIdBDO = ParamUtil.getLong(request, "rolesIdBDO");
				String roleBDO = "(";
				String roleName = "tutti i ruoli";

				Date d = new Date();
				String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				// selezione id delle società da controllare figlie di quella selezionata
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}
				
				List<ESFState> states = new ArrayList<ESFState>();
				states = ESFStateLocalServiceUtil.findAllESFStates();
				
				if(rolesIdBDO > 0){
					roleBDO = roleBDO + rolesIdBDO + ")";
					if(Validator.isNotNull(ESFUserRoleLocalServiceUtil.fetchESFUserRole(rolesIdBDO).getName())){
						roleName = ESFUserRoleLocalServiceUtil.fetchESFUserRole(rolesIdBDO).getName();
					}
				}else{
					List<ESFUserRole> bdoRoles = new ArrayList<ESFUserRole>();
					bdoRoles= ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(3, 1, true);
					Role role = null; 
					for(ESFUserRole r : bdoRoles){
						roleBDO = roleBDO + r.getEsfUserRoleId() + ",";
					}
					roleBDO = roleBDO + ")";
					roleBDO = roleBDO.replace(",)", ")");
				}

				map.put("roleId", roleBDO);
				map.put("roleName", roleName);
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Report BDO Ruoli.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Consiglio Direttivo Ruoli Report.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(genrateCompanyCategoryReport){
			
			ESFOrganization org = new ESFOrganizationImpl();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				long rolesIdBDO = ParamUtil.getLong(request, "rolesIdBDO");
				
				Date d = new Date();
				String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				// selezione id delle società da controllare figlie di quella selezionata
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}
				
				List<ESFState> states = new ArrayList<ESFState>();
				states = ESFStateLocalServiceUtil.findAllESFStates();
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Report Categoria Società.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Categoria Società Report.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
				
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(genrateVariationReport){
			
			ESFOrganization org = new ESFOrganizationImpl();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				long variationId = ParamUtil.getLong(request, "variationId");
				String variationOrg = "(";
				String variationName = "Tutti i tipi di variazionie";
				
				List<ListType> variations = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFOrganization.variation");
				
				Date d = new Date();
				String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				// selezione id delle società da controllare figlie di quella selezionata
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}
				
				if(variationId > 0){
					variationOrg = variationOrg + variationId + ")";
					
					if(Validator.isNotNull(ListTypeServiceUtil.getListType((int) variationId))){
						variationName = ListTypeServiceUtil.getListType((int) variationId).getName();
					}
				}else{
					for(ListType v : variations){
						variationOrg = variationOrg +" " +v.getListTypeId() +" , ";
					}
					variationOrg = variationOrg + ")";
					variationOrg = variationOrg.replace(", )", ")");
				}
				
				map.put("variationId", variationOrg);
				map.put("variationName", variationName);
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Variation Report.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Variazioni Società Report.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(genrateShooterReport){
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Tiratori Report.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Report Tiratori.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(generateNationalReport){
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				
				boolean isNational = ParamUtil.getBoolean(request, "isNational");
				boolean isUniversity = ParamUtil.getBoolean(request, "isUniversity");
				long esfSprtTypeId = ParamUtil.getLong(request, "esfSprtTypeId");
				
				String stId = "(";
				
				List<ESFSportType> nationalSports = new ArrayList<ESFSportType>();
				nationalSports = ESFSportTypeLocalServiceUtil.getisOlimpic(true);
				
				if(esfSprtTypeId > 0 ){
					stId = stId + esfSprtTypeId +")";
				}else{
					for(ESFSportType ost : nationalSports){
						stId = stId + ost.getEsfSportTypeId() + ",";
					}
					stId = stId +")";
					stId = stId.replace(",)", ")");
				}
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				map.put("isUniversity", isUniversity); 
				map.put("isNational", isNational); 
				map.put("sportTypeId", stId); 
				
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"National Report.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Report Nazionali.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(genrateNormalMatchReport){
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				
				long esfSprtTypeId = ParamUtil.getLong(request, "sportTypeId");
				long matchTypeId = ParamUtil.getLong(request, "matchTypeId");
				long yearNormalMatch = ParamUtil.getLong(request, "yearNormalMatch");
				
				String esfSprtTypeS = "st.esfSportTypeId in(";
				String matchTypeS = "m.esfMatchTypeId in(";
				
				List<ESFSportType> normalSportTypes = new ArrayList<ESFSportType>();
				List<ESFMatchType> normalMatchTypes = new ArrayList<ESFMatchType>();
				normalSportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
				normalMatchTypes = ESFMatchTypeLocalServiceUtil.findAllByNational(false);
				
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				String findAss = "o.treePath LIKE '%/";
				
				if(0 != associationId){
					findAss = findAss + associationId + "/%'";
					
					map.put("assId", findAss); 
				}else if( 0 == associationId && 0 != provinceId){
					findAss = findAss + provinceId + "/%'";
					map.put("assId", findAss); 
				}else if(0 == provinceId &&  0 != regionId){
					findAss = findAss + regionId + "/%'";
					map.put("assId", regionId);
				}else{
					findAss ="( " + findAss + currentOrganizationId + "/%' or m.esfAssociationId = 0)";
					map.put("assId", findAss);
				}
				
				if(0!=esfSprtTypeId){
					esfSprtTypeS = esfSprtTypeS +esfSprtTypeId +")";
				}else{
					esfSprtTypeS ="(" + esfSprtTypeS ;
					for(ESFSportType s : normalSportTypes){
						esfSprtTypeS = esfSprtTypeS + s.getEsfSportTypeId() +",";
					}
					esfSprtTypeS = esfSprtTypeS + ")";
					esfSprtTypeS = esfSprtTypeS.replace(",)", ")");
					esfSprtTypeS = esfSprtTypeS + " or m.esfSportTypeId = 0 )";
				}
				//////
				if(0!=matchTypeId){
					matchTypeS = matchTypeS +matchTypeId +")";
				}else{
					matchTypeS ="(" + matchTypeS ;
					for(ESFMatchType m : normalMatchTypes){
						matchTypeS = matchTypeS + m.getEsfMatchTypeId() +",";
					}
					
					matchTypeS = matchTypeS + ")";
					matchTypeS = matchTypeS.replace(",)", ")");
					
					
					matchTypeS = matchTypeS + " or m.esfMatchTypeId = 0)";
					
				}
				////
				
				map.put("esfMatchTypeId", matchTypeS);
				map.put("startDate", yearNormalMatch);
				map.put("esfSportTypeId", esfSprtTypeS);
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Match Normali.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Match Report.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(genrateNationalMatchReport){
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				
				long esfSprtTypeId = ParamUtil.getLong(request, "sportTypeId");
				long matchTypeId = ParamUtil.getLong(request, "matchTypeId");
				long yearOlimpicMatch = ParamUtil.getLong(request, "yearOlimpicMatch");
				long countryId = ParamUtil.getLong(request, "countryId");
				
				String olimpicSprtTypeS = "%";
				String olimpicMatchTypeS = "(";
				String countryIdS = "";
				String sportTypeS = "specialità:";
				
				List<ESFSportType> olimpicSportTypes = new ArrayList<ESFSportType>();
				List<ESFMatchType> olimpicMatchTypes = new ArrayList<ESFMatchType>();
				olimpicSportTypes = ESFSportTypeLocalServiceUtil.getisOlimpic(true);
				olimpicMatchTypes = ESFMatchTypeLocalServiceUtil.findAllByNational(true);
				
				group = themeDisplay.getLayout().getGroup();
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				if(0!=esfSprtTypeId){
					if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(esfSprtTypeId)) &&
							Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(esfSprtTypeId).getName())){
					
					sportTypeS = sportTypeS + ESFSportTypeLocalServiceUtil.fetchESFSportType(esfSprtTypeId).getName();
					}
					olimpicSprtTypeS = olimpicSprtTypeS + esfSprtTypeId +"%";
					
				}else{
					olimpicSprtTypeS = olimpicSprtTypeS + "%";
					sportTypeS = sportTypeS + "tutte";
				}
				
				if(0 != matchTypeId){
					olimpicMatchTypeS = olimpicMatchTypeS + matchTypeId + ")";
					
				}else{
					for(ESFMatchType mt : olimpicMatchTypes){
						olimpicMatchTypeS = olimpicMatchTypeS +mt.getEsfMatchTypeId()+ ",";
					}
					olimpicMatchTypeS = olimpicMatchTypeS + ")";
					olimpicMatchTypeS = olimpicMatchTypeS.replace(",)", ")");
				}
				
				
				if(0 != countryId){
					countryIdS = String.valueOf(countryId) ;
				}else{
					countryIdS = "%%";
				}
				
				map.put("Speciality", sportTypeS);
				map.put("sportTypeId", olimpicSprtTypeS);
				map.put("matchTypeId", olimpicMatchTypeS);
				map.put("year", yearOlimpicMatch);
				map.put("countryId", countryIdS);
				
				
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Gare Azzurre.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Match Report.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(genrateNatonalAssemblyReport){

			ESFOrganization org = new ESFOrganizationImpl();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				long rolesIdBDO = ParamUtil.getLong(request, "rolesIdBDO");
				String roleBDO = "(";
				String roleName = "tutti i ruoli";

				Date d = new Date();
				String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				// selezione id delle società da controllare figlie di quella selezionata
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}
				
				List<ESFUserRole> bdoRoles = new ArrayList<ESFUserRole>();
				bdoRoles= ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(3, 1, true);

				for(ESFUserRole r : bdoRoles){
					roleBDO = roleBDO + r.getEsfUserRoleId() + ",";
				}
				roleBDO = roleBDO + ")";
				roleBDO = roleBDO.replace(",)", ")");

				map.put("roleId", roleBDO);
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Assemblea Nazionale.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Assemblea Nazionale.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(generateShootersAndCategoryReport){
			
			ESFOrganization org = new ESFOrganizationImpl();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				
				Date d = new Date();
				String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				// selezione id delle società da controllare figlie di quella selezionata
				
				if(0 != associationId){
					map.put("assId", associationId); 
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
				}else{
					map.put("assId", currentOrganizationId);
				}
				
				map.put("startDate", year);
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
								"report"+ File.separator +"Report tiratori e categoria.jasper";
						//"report"+ File.separator +"Tiratori senza rinnovo.jasper";Tiratori Report
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Report Tiratori e categoria società.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
				
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(genrateShooterNoRenewalReportReport){

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			
			try {
				group = themeDisplay.getLayout().getGroup();
				long currentOrganizationId = group.getOrganizationId();

				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				
				Date d = new Date();
				String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
				
				String endDate = "";
				String startDate = "";
				String addressType = "";
				String orgCode= "";

				HashMap map = new HashMap();
				
				// apro la connessione con il db
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				ESFOrganization org = new ESFOrganizationImpl();
				map.put("socCode", orgCode); 
				
				if(0 != associationId){
					map.put("assId", associationId); 
					
					org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(associationId);
					if(Validator.isNotNull(org) && Validator.isNotNull(org.getCode())){
						orgCode = org.getName();
						map.put("orgCode", orgCode); 
					}
				}else if( 0 == associationId && 0 != provinceId){
					map.put("assId", provinceId); 
					
					org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(provinceId);
					if(Validator.isNotNull(org) && Validator.isNotNull(org.getCode())){
						orgCode = org.getName();
						map.put("orgCode", orgCode); 
					}
				}else if(0 == provinceId &&  0 != regionId){
					map.put("assId", regionId);
					
					org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(regionId);
					if(Validator.isNotNull(org) && Validator.isNotNull(org.getCode())){
						orgCode = org.getName();
						map.put("orgCode", orgCode); 
					}
				}else{
					map.put("assId", currentOrganizationId);
					
					org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
					if(Validator.isNotNull(org) && Validator.isNotNull(org.getCode())){
						orgCode = org.getName();
						map.put("orgCode", "FITAV"); 
					}
				}
				
				List<ListType> list = new ArrayList<ListType>();
				list = ListTypeServiceUtil.getListTypes("com.liferay.portal.model.Organization.address");
				
				for(ListType l : list){
					if("billing".equals(l.getName())){
						addressType = String.valueOf(l.getListTypeId());
						
					}
				}
				
				endDate = year+"-01-01";
				startDate = (Integer.valueOf(year)-1)+"-01-01";
				
				
				map.put("endDate", endDate);
				map.put("startDate", startDate);
				map.put("addressType", addressType);

				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"Tiratori senza rinnovo.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Report Tiratori senza rinnovo.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(generateSummaryShooterReport){

			int renewalCards = 0;
			int newCards = 0;
			
			Date d = new Date();
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			
			String thisYear = String.valueOf(year)+"-01-01";
			String lastYear = String.valueOf(year-1)+"-01-01";
			

			HashMap map = new HashMap();
			
			map.put("year", String.valueOf(year));
			
			// apro la connessione con il db
			
			try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
			
			int totRin = 0, totNew = 0, totTes = 0;
			
			long abrId = 0 ,basId = 0,calId = 0,camId = 0, emiId = 0,friId = 0,ligId = 0,lomId = 0,lazId = 0,molId = 0,marId = 0,pugId = 0,pieId = 0,sicId = 0,sarId = 0,treId = 0, tosId = 0,umbId = 0,aosId = 0,venId = 0;
			
			//String rinnoviAbr ="",rinnoviBas ="",rinnoviCal ="",rinnoviCam ="",rinnoviEmi ="",rinnoviFri ="",rinnoviLig ="",rinnoviLom ="",rinnoviLaz ="",rinnoviMol ="",rinnoviMar ="",
			//rinnoviPug ="",rinnoviPie ="",rinnoviSic ="",rinnoviSar ="",rinnoviTre ="",rinnoviTos ="",rinnoviUmb ="",rinnoviAos ="",rinnoviVen ="";
			
			int abrRin = 0 ,basRin = 0,calRin = 0,camRin = 0, emiRin = 0,friRin = 0,ligRin = 0,lomRin = 0,lazRin = 0,molRin = 0,marRin = 0,pugRin = 0,pieRin = 0,sicRin = 0,sarRin = 0,treRin = 0, tosRin = 0,
					umbRin = 0,aosRin = 0,venRin = 0;
			
			int abrNew = 0 ,basNew = 0,calNew = 0,camNew = 0, emiNew = 0,friNew = 0,ligNew = 0,lomNew = 0,lazNew = 0,molNew = 0,marNew = 0,pugNew = 0,pieNew = 0,sicNew = 0,sarNew = 0,treNew = 0, tosNew = 0,
					umbNew = 0,aosNew = 0,venNew = 0;
			
			int abrTot = 0 ,basTot = 0,calTot = 0,camTot = 0, emiTot = 0,friTot = 0,ligTot = 0,lomTot = 0,lazTot = 0,molTot= 0,marTot = 0,pugTot = 0,pieTot = 0,sicTot = 0,sarTot = 0,treTot = 0, tosTot = 0,
					umbTot = 0,aosTot = 0,venTot = 0;
			
			try {
				
			List<ESFOrganization> org = new ArrayList<ESFOrganization>();
			
			org = ESFOrganizationLocalServiceUtil.findAllESFOrganizations(1,ESFKeys.ESFStateType.ENABLE);
			
			for(ESFOrganization o : org){
				
				if("Abruzzo".equalsIgnoreCase(o.getName())){
					
					abrId = o.getEsfOrganizationId();
					
					abrRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, abrId);

					abrNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , abrId);
					
					abrTot = abrRin + abrNew;
					
					totRin = totRin + abrRin;
					totNew = totNew + abrNew;
					
					totTes = totTes + abrTot;
					
					map.put("RinnoviAbruzzo", String.valueOf(abrRin) );
					map.put("NuoviAbruzzo", String.valueOf(abrNew));
					map.put("TotaleAbruzzo",String.valueOf( abrTot));
					map.put("TotaleRinnovi", String.valueOf( totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Basilicata".equalsIgnoreCase(o.getName())){
					
					basId = o.getEsfOrganizationId();
					
					basRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, basId);

					basNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , basId);
					
					basTot = basRin + basNew;
					
					totRin = totRin + basRin;
					totNew = totNew + basNew;
					
					totTes = totTes + basTot;
					
					map.put("RinnoviBasilicata", String.valueOf(basRin));
					map.put("NuoviBasilicata", String.valueOf(basNew));
					map.put("TotaleBasilicata", String.valueOf(basTot));
					map.put("TotaleRinnovi", String.valueOf( totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Calabria".equalsIgnoreCase(o.getName())){
					
					calId = o.getEsfOrganizationId();
					
					calRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, calId);

					calNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , calId);
					
					calTot = calRin + calNew;
					
					totRin = totRin + calRin;
					totNew = totNew + calNew;
					
					totTes = totTes + calTot;
					
					map.put("RinnoviCalabria",String.valueOf( calRin));
					map.put("NuoviCalabria", String.valueOf(calNew));
					map.put("TotaleCalabria", String.valueOf(calTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi",String.valueOf( totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Campania".equalsIgnoreCase(o.getName())){
					
					camId = o.getEsfOrganizationId();
					
					camRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, camId);

					camNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , camId);
					
					camTot = camRin + camNew;
					
					totRin = totRin + camRin;
					totNew = totNew + camNew;
					
					totTes = totTes + camTot;
					
					map.put("RinnoviCampania", String.valueOf(camRin));
					map.put("NuoviCampania", String.valueOf(camNew));
					map.put("TotaleCampania", String.valueOf(camTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Emilia-Romagna".equalsIgnoreCase(o.getName())){
					
					emiId = o.getEsfOrganizationId();
					
					emiRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, emiId);

					emiNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , emiId);
					
					emiTot = emiRin + emiNew;
					
					totRin = totRin + emiRin;
					totNew = totNew + emiNew;
					
					totTes = totTes + emiTot;
					
					map.put("RinnoviEmilia", String.valueOf(emiRin));
					map.put("NuoviEmilia",String.valueOf( emiNew));
					map.put("TotaleEmilia",String.valueOf( emiTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Friuli-Venezia Giulia".equalsIgnoreCase(o.getName())){
					
					friId = o.getEsfOrganizationId();
					
					friRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, friId);

					friNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , friId);
					
					friTot =friRin + friNew;
					
					totRin = totRin + friRin;
					totNew = totNew + friNew;
					
					totTes = totTes + friTot;
					
					map.put("RinnoviFriuli", String.valueOf(friRin));
					map.put("NuoviFriuli", String.valueOf(friNew));
					map.put("TotaleFriuli", String.valueOf(friTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Lazio".equalsIgnoreCase(o.getName())){
					
					lazId = o.getEsfOrganizationId();
					
					lazRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, lazId);

					lazNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , lazId);
					
					lazTot = lazRin + lazNew;
					
					totRin = totRin + lazRin;
					totNew = totNew + lazNew;
					
					totTes = totTes + lazTot;
					
					map.put("RinnoviLazio", String.valueOf(lazRin));
					map.put("NuoviLazio", String.valueOf(lazNew));
					map.put("TotaleLazio", String.valueOf(lazTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Liguria".equalsIgnoreCase(o.getName())){
					
					ligId = o.getEsfOrganizationId();
					
					ligRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, ligId);

					ligNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , ligId);
					
					ligTot = ligRin + ligNew;
					
					totRin = totRin + ligRin;
					totNew = totNew + ligNew;
					
					totTes = totTes + ligTot;
					
					map.put("RinnoviLiguria", String.valueOf(ligRin));
					map.put("NuoviLiguria", String.valueOf(ligNew));
					map.put("TotaleLiguria", String.valueOf(ligTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Liguria".equalsIgnoreCase(o.getName())){
					
					ligId = o.getEsfOrganizationId();
					
					ligRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, ligId);

					ligNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , ligId);
					
					ligTot = ligRin + ligNew;
					
					totRin = totRin + ligRin;
					totNew = totNew + ligNew;
					
					totTes = totTes + ligTot;
					
					map.put("RinnoviLiguria", String.valueOf(ligRin));
					map.put("NuoviLiguria", String.valueOf(ligNew));
					map.put("TotaleLiguria", String.valueOf(ligTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Molise".equalsIgnoreCase(o.getName())){
					
					molId = o.getEsfOrganizationId();
					
					molRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, molId);

					molNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , molId);
					
					molTot = molRin + molNew;
					
					totRin = totRin + molRin;
					totNew = totNew + molNew;
					
					totTes = totTes + molTot;
					
					map.put("RinnoviMolise", String.valueOf(molRin));
					map.put("NuoviMolise", String.valueOf(molNew));
					map.put("TotaleMolise",String.valueOf( molTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Lombardia".equalsIgnoreCase(o.getName())){
					
					lomId = o.getEsfOrganizationId();
					
					lomRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, lomId);

					lomNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , lomId);
					
					lomTot = lomRin +lomNew;
					
					totRin = totRin + lomRin;
					totNew = totNew + lomNew;
					
					totTes = totTes + lomTot;
					
					map.put("RinnoviLombardia", String.valueOf(lomRin));
					map.put("NuoviLombardia", String.valueOf(lomNew));
					map.put("TotaleLombardia", String.valueOf(lomTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Puglia".equalsIgnoreCase(o.getName())){
					
					pugId = o.getEsfOrganizationId();
					
					pugRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, pugId);

					pugNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , pugId);
					
					pugTot = pugRin + pugNew;
					
					totRin = totRin + pugRin;
					totNew = totNew + pugNew;
					
					totTes = totTes + pugTot;
					
					map.put("RinnoviPuglia", String.valueOf(pugRin));
					map.put("NuoviPuglia", String.valueOf(pugNew));
					map.put("TotalePuglia", String.valueOf(pugTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Piemonte".equalsIgnoreCase(o.getName())){
					
					pieId = o.getEsfOrganizationId();
					
					pieRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, pieId);

					pieNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , pieId);
					
					pieTot = pieRin + pieNew;
					
					totRin = totRin + pieRin;
					totNew = totNew + pieNew;
					
					totTes = totTes + pieTot;
					
					map.put("RinnoviPiemonte", String.valueOf(pieRin));
					map.put("NuoviPiemonte", String.valueOf(pieNew));
					map.put("TotalePiemonte", String.valueOf(pieTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
					
				}
				if("Sicilia".equalsIgnoreCase(o.getName())){
					
					sicId = o.getEsfOrganizationId();
					
					sicRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, sicId);

					sicNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , sicId);
					
					sicTot = sicRin + sicNew;
					
					totRin = totRin + sicRin;
					totNew = totNew + sicNew;
					
					totTes = totTes + sicTot;
					
					map.put("RinnoviSicilia", String.valueOf(sicRin));
					map.put("NuoviSicilia",String.valueOf( sicNew));
					map.put("TotaleSicilia", String.valueOf(sicTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale",String.valueOf(totTes));
					
				}
				if("Sardegna".equalsIgnoreCase(o.getName())){
					
					sarId = o.getEsfOrganizationId();
					
					sarRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, sarId);

					sarNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , sarId);
					
					sarTot = sarRin + sarNew;
					
					totRin = totRin + sarRin;
					totNew = totNew + sarNew;
					
					totTes = totTes + sarTot;
					
					map.put("RinnoviSardegna", String.valueOf(sarRin));
					map.put("NuoviSardegna", String.valueOf(sarNew));
					map.put("TotaleSardegna", String.valueOf(sarTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
	
				}
				if("Trentino-Alto Adige".equalsIgnoreCase(o.getName())){
					
					treId = o.getEsfOrganizationId();
					
					treRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, treId);

					treNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , treId);
					
					treTot = treRin + treNew;
					
					totRin = totRin + treRin;
					totNew = totNew + treNew;
					
					totTes = totTes + treTot;
					
					map.put("RinnoviTrentino", String.valueOf(treRin));
					map.put("NuoviTrentino", String.valueOf(treNew));
					map.put("TotaleTrentino", String.valueOf(treTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi",String.valueOf( totNew));
					map.put("Totale", String.valueOf(totTes));
	
				}
				if("Toscana".equalsIgnoreCase(o.getName())){
					
					tosId = o.getEsfOrganizationId();
					
					tosRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, tosId);

					tosNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , tosId);
					
					tosTot = tosRin + tosNew;
					
					totRin = totRin + tosRin;
					totNew = totNew + tosNew;
					
					totTes = totTes + tosTot;
					
					map.put("RinnoviToscana", String.valueOf(tosRin));
					map.put("NuoviToscana", String.valueOf(tosNew));
					map.put("TotaleToscana", String.valueOf(tosTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
	
	
				}
				if("Umbria".equalsIgnoreCase(o.getName())){
					
					umbId = o.getEsfOrganizationId();
					
					umbRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, umbId);

					umbNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , umbId);
					
					umbTot = umbRin + umbNew;
					
					totRin = totRin + umbRin;
					totNew = totNew + umbNew;
					
					totTes = totTes + umbTot;
					
					map.put("RinnoviUmbria", String.valueOf(umbRin));
					map.put("NuoviUmbria", String.valueOf(umbNew));
					map.put("TotaleUmbria",String.valueOf( umbTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
	
	
				}
				if("Valle d'Aosta".equalsIgnoreCase(o.getName())){
					
					aosId = o.getEsfOrganizationId();
					
					aosRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, aosId);

					aosNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , aosId);
					
					aosTot = aosRin + aosNew;
					
					totRin = totRin + aosRin;
					totNew = totNew + aosNew;
					
					totTes = totTes + aosTot;
					
					map.put("RinnoviAosta", String.valueOf(aosRin));
					map.put("NuoviAosta", String.valueOf(aosNew));
					map.put("TotaleAosta", String.valueOf(aosTot));
					map.put("TotaleRinnovi",String.valueOf( totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
	
					
				}
				if("Veneto".equalsIgnoreCase(o.getName())){
					
					venId = o.getEsfOrganizationId();
					
					venRin = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, venId);

					treNew = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , venId);
					
					venTot = venRin + venNew;
					
					totRin = totRin + venRin;
					totNew = totNew + venNew;
					
					totTes = totTes + venTot;
					
					map.put("RinnoviVeneto", String.valueOf(venRin));
					map.put("NuoviVeneto", String.valueOf(venNew));
					map.put("TotaleVeneto", String.valueOf(venTot));
					map.put("TotaleRinnovi", String.valueOf(totRin));
					map.put("TotaleNuovi", String.valueOf(totNew));
					map.put("Totale", String.valueOf(totTes));
	
					
				}
			}
			
			String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
					"report"+ File.separator +"Riepilogo Nuovi Tesserati.jasper";
			
			InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
			
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
			
			JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
			
			byte[] bytes = null;
			bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
			response.reset();
			response.resetBuffer();
			response.setContentType("application/pdf");
			response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Riepilogo Nuovi Tesserati.pdf;");
			response.setContentLength(bytes.length);
			OutputStream ouputStream =  response.getPortletOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
				
				
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			
		}
		if(generateSummaryShooterYearReportReport){
			
			Date d = new Date();
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			
			String thisYearStart = String.valueOf(year)+"-01-01";
			String Year_1Start = String.valueOf(year-1)+"-01-01";
			String Year_2Start = String.valueOf(year-2)+"-01-01";
			String Year_3Start = String.valueOf(year-3)+"-01-01";
			
			String thisYearEnd = String.valueOf(year)+"-12-31";
			String Year_1End = String.valueOf(year-1)+"-12-31";
			String Year_2End = String.valueOf(year-2)+"-12-31";
			String Year_3End = String.valueOf(year-3)+"-12-31";
			
	
			HashMap map = new HashMap();
			
			map.put("year", String.valueOf(year));
			map.put("year-1", String.valueOf(year-1));
			map.put("year-2", String.valueOf(year-2));
			map.put("year-3", String.valueOf(year-3));
			
			// apro la connessione con il db
			
			try {
			
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);	
			
				String abrId = "AB",
						basId = "BS", 
						calId = "CL", 
						camId = "CP", 
						emiId = "ER",
						friId = "FG",
						ligId = "LG",
						lomId = "LM",
						lazId = "LZ",
						molId = "ML",
						marId = "MR",
						pugId = "PG",
						pieId = "PV",
						sicId = "SC",
						sarId = "SD",
						treId = "TN", 
						tosId = "TS",
						umbId = "UB",
						aosId = "VA",
						venId = "VN";
				
				int abrTot = 0 ,basTot = 0,calTot = 0,camTot = 0, emiTot = 0,friTot = 0,ligTot = 0,lomTot = 0,lazTot = 0,molTot= 0,marTot = 0,pugTot = 0,pieTot = 0,sicTot = 0,sarTot = 0,treTot = 0, tosTot = 0,
						umbTot = 0,aosTot = 0,venTot = 0;
				
				int abrTot_1 = 0 ,basTot_1 = 0,calTot_1 = 0,camTot_1 = 0, emiTot_1 = 0,friTot_1 = 0,ligTot_1 = 0,lomTot_1 = 0,lazTot_1 = 0,molTot_1= 0,marTot_1 = 0,pugTot_1 = 0,pieTot_1 = 0,sicTot_1 = 0,sarTot_1 = 0,
						treTot_1 = 0, tosTot_1 = 0,umbTot_1 = 0,aosTot_1 = 0,venTot_1 = 0;
				
				int abrTot_2 = 0 ,basTot_2 = 0,calTot_2 = 0,camTot_2 = 0, emiTot_2 = 0,friTot_2 = 0,ligTot_2 = 0,lomTot_2 = 0,lazTot_2 = 0,molTot_2 = 0,marTot_2 = 0,pugTot_2 = 0,pieTot_2 = 0,sicTot_2 = 0,sarTot_2 = 0,
						treTot_2 = 0, tosTot_2 = 0,umbTot_2 = 0,aosTot_2 = 0,venTot_2 = 0;
				
				int abrTot_3 = 0 ,basTot_3 = 0,calTot_3 = 0,camTot_3 = 0, emiTot_3 = 0,friTot_3 = 0,ligTot_3 = 0,lomTot_3 = 0,lazTot_3 = 0,molTot_3 = 0,marTot_3 = 0,pugTot_3 = 0,pieTot_3 = 0,sicTot_3 = 0,sarTot_3 = 0,
						treTot_3 = 0, tosTot_3 = 0,umbTot_3 = 0,aosTot_3 = 0,venTot_3 = 0;
				
				int abrTotDiff = 0 ,basTotDiff = 0,calTotDiff = 0,camTotDiff = 0, emiTotDiff = 0,friTotDiff = 0,ligTotDiff = 0,lomTotDiff = 0,lazTotDiff = 0,molTotDiff = 0,marTotDiff = 0,pugTotDiff = 0,pieTotDiff = 0,
						sicTotDiff = 0,sarTotDiff = 0,treTotDiff = 0, tosTotDiff = 0,umbTotDiff = 0,aosTotDiff = 0,venTotDiff = 0;
				
				int totale = 0, totale_1 = 0, totale_2 = 0, totale_3 = 0, totaleDiff = 0;
				
				List<ESFOrganization> org = new ArrayList<ESFOrganization>();
				
				org = ESFOrganizationLocalServiceUtil.findAllESFOrganizations(1,ESFKeys.ESFStateType.ENABLE);
				
				for(ESFOrganization o : org){
					
					if("Abruzzo".equalsIgnoreCase(o.getName())){
						
						abrId = o.getCode();
						
						abrTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, abrId);
						abrTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, abrId);
						abrTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, abrId);
						abrTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, abrId);
						
						abrTotDiff = abrTot - abrTot_1;
						totale = totale + abrTot;
						totale_1 = totale_1 +abrTot_1;
						totale_2 = totale_2 +totale_2;
						totale_3 = totale_3 +totale_3 ;
						totaleDiff = totaleDiff + abrTotDiff;
						
						map.put("TotaleAbruzzo-3", String.valueOf(abrTot_3) );
						map.put("TotaleAbruzzo-2", String.valueOf(abrTot_2));
						map.put("TotaleAbruzzo-1",String.valueOf( abrTot_1));
						map.put("TotaleAbruzzo", String.valueOf( abrTot));
						map.put("TotaleAbruzzoDiff", String.valueOf(abrTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						
						
						continue;
						
						
					}
					if("Basilicata".equalsIgnoreCase(o.getName())){
						
						basId = o.getCode();
						
						basTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart,  basId);
						basTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, basId);
						basTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, basId);
						basTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, basId);
						
						basTotDiff = basTot - basTot_1;
						totale = totale + basTot;
						totaleDiff = totaleDiff + basTotDiff;
						totale_1 = totale_1 +basTot_1;
						totale_2 = totale_2 +basTot_2;
						totale_3 = totale_3 +basTot_3;
						
						map.put("TotaleBasilicata-3", String.valueOf(basTot_3) );
						map.put("TotaleBasilicata-2", String.valueOf(basTot_2));
						map.put("TotaleBasilicata-1",String.valueOf( basTot_1));
						map.put("TotaleBasilicata", String.valueOf( basTot));
						map.put("TotaleBasilicataDiff", String.valueOf(basTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Calabria".equalsIgnoreCase(o.getName())){
						
						calId = o.getCode();
						
						calTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, calId);
						calTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, calId);
						calTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, calId);
						calTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, calId);
						
						calTotDiff = calTot - calTot_1;
						totale = totale + calTot;
						totaleDiff = totaleDiff + calTotDiff;
						totale_1 = totale_1 +calTot_1;
						totale_2 = totale_2 +calTot_2;
						totale_3 = totale_3 +calTot_3;
						
						map.put("TotaleCalabria-3", String.valueOf(calTot_3) );
						map.put("TotaleCalabria-2", String.valueOf(calTot_2));
						map.put("TotaleCalabria-1",String.valueOf( calTot_1));
						map.put("TotaleCalabria", String.valueOf( calTot));
						map.put("TotaleCalabriaDiff", String.valueOf(calTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Campania".equalsIgnoreCase(o.getName())){
						
						camId = o.getCode();
						
						camTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, camId);
						camTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, camId);
						camTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, camId);
						camTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, camId);
						
						camTotDiff = camTot - camTot_1;
						totale = totale + camTot;
						totaleDiff = totaleDiff + camTotDiff;
						totale_1 = totale_1 +camTot_1;
						totale_2 = totale_2 +camTot_2;
						totale_3 = totale_3 +camTot_3;
						
						map.put("TotaleCampania-3", String.valueOf(camTot_3) );
						map.put("TotaleCampania-2", String.valueOf(camTot_2));
						map.put("TotaleCampania-1",String.valueOf( camTot_1));
						map.put("TotaleCampania", String.valueOf( camTot));
						map.put("TotaleCampaniaDiff", String.valueOf(camTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Emilia-Romagna".equalsIgnoreCase(o.getName())){
						
						emiId = o.getCode();
						
						emiTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, emiId);
						emiTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, emiId);
						emiTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, emiId);
						emiTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, emiId);
						
						emiTotDiff = emiTot - emiTot_1;
						totale = totale + emiTot;
						totaleDiff = totaleDiff + emiTotDiff;
						totale_1 = totale_1 +emiTot_1;
						totale_2 = totale_2 +emiTot_2;
						totale_3 = totale_3 +emiTot_3;
						
						map.put("TotaleEmilia-3", String.valueOf(emiTot_3) );
						map.put("TotaleEmilia-2", String.valueOf(emiTot_2));
						map.put("TotaleEmilia-1",String.valueOf( emiTot_1));
						map.put("TotaleEmilia", String.valueOf( emiTot));
						map.put("TotaleEmiliaDiff", String.valueOf(emiTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Friuli-Venezia Giulia".equalsIgnoreCase(o.getName())){
						
						friId = o.getCode();
						
						friTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, friId);
						friTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, friId);
						friTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, friId);
						friTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, friId);
						
						friTotDiff = friTot - friTot_1;
						totale = totale + friTot;
						totaleDiff = totaleDiff + friTotDiff;
						totale_1 = totale_1 +friTot_1;
						totale_2 = totale_2 +friTot_2;
						totale_3 = totale_3 +friTot_3 ;
						
						map.put("TotaleFriuli-3", String.valueOf(friTot_3) );
						map.put("TotaleFriuli-2", String.valueOf(friTot_2));
						map.put("TotaleFriuli-1",String.valueOf( friTot_1));
						map.put("TotaleFriuli", String.valueOf( friTot));
						map.put("TotaleFriuliDiff", String.valueOf(friTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Lazio".equalsIgnoreCase(o.getName())){
						
						lazId = o.getCode();
						
						lazTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, lazId);
						lazTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, lazId);
						lazTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, lazId);
						lazTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, lazId);
						
						lazTotDiff = lazTot - lazTot_1;
						totale = totale + lazTot;
						totaleDiff = totaleDiff + lazTotDiff;
						totale_1 = totale_1 +lazTot_1;
						totale_2 = totale_2 +lazTot_2;
						totale_3 = totale_3 +lazTot_3;
						
						map.put("TotaleLazio-3", String.valueOf(lazTot_3) );
						map.put("TotaleLazio-2", String.valueOf(lazTot_2));
						map.put("TotaleLazio-1",String.valueOf( lazTot_1));
						map.put("TotaleLazio", String.valueOf( lazTot));
						map.put("TotaleLazioDiff", String.valueOf(lazTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Liguria".equalsIgnoreCase(o.getName())){
						
						ligId = o.getCode();
						
						ligTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, ligId);
						ligTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, ligId);
						ligTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, ligId);
						ligTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, ligId);
						
						ligTotDiff = ligTot - ligTot_1;
						totale = totale + ligTot;
						totaleDiff = totaleDiff + ligTotDiff;
						totale_1 = totale_1 +ligTot_1;
						totale_2 = totale_2 +ligTot_2;
						totale_3 = totale_3 +ligTot_3;
						
						map.put("TotaleLiguria-3", String.valueOf(ligTot_3) );
						map.put("TotaleLiguria-2", String.valueOf(ligTot_2));
						map.put("TotaleLiguria-1",String.valueOf( ligTot_1));
						map.put("TotaleLiguria", String.valueOf( ligTot));
						map.put("TotaleLiguriaDiff", String.valueOf(ligTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Molise".equalsIgnoreCase(o.getName())){
						
						molId = o.getCode();
						
						molTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, molId);
						molTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, molId);
						molTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, molId);
						molTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, molId);
						
						molTotDiff = molTot - molTot_1;
						totale = totale +molTot;
						totaleDiff = totaleDiff + molTotDiff;
						totale_1 = totale_1 +molTot_1;
						totale_2 = totale_2 +molTot_2;
						totale_3 = totale_3 +molTot_3;
						
						map.put("TotaleMolise-3", String.valueOf(molTot_3) );
						map.put("TotaleMolise-2", String.valueOf(molTot_2));
						map.put("TotaleMolise-1",String.valueOf( molTot_1));
						map.put("TotaleMolise", String.valueOf( molTot));
						map.put("TotaleMoliseDiff", String.valueOf(molTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Marche".equalsIgnoreCase(o.getName())){
						
						marId = o.getCode();
						
						marTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, marId);
						marTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, marId);
						marTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, marId);
						marTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, marId);
						
						marTotDiff = marTot - marTot_1;
						totale = totale + marTot;
						totaleDiff = totaleDiff + marTotDiff;
						totale_1 = totale_1 +marTot_1;
						totale_2 = totale_2 +marTot_2;
						totale_3 = totale_3 +marTot_3;
						
						map.put("TotaleMarche-3", String.valueOf(marTot_3) );
						map.put("TotaleMarche-2", String.valueOf(marTot_2));
						map.put("TotaleMarche-1",String.valueOf( marTot_1));
						map.put("TotaleMarche", String.valueOf( marTot));
						map.put("TotaleMarcheDiff", String.valueOf(marTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Puglia".equalsIgnoreCase(o.getName())){
						
						pugId = o.getCode();
						
						pugTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, pugId);
						pugTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, pugId);
						pugTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, pugId);
						pugTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, pugId);
						
						pugTotDiff = pugTot - pugTot_1;
						totale = totale + pugTot;
						totaleDiff = totaleDiff + pugTotDiff;
						totale_1 = totale_1 +pugTot_1 ;
						totale_2 = totale_2 +pugTot_2;
						totale_3 = totale_3 +pugTot_3 ;
						
						map.put("TotalePuglia-3", String.valueOf(pugTot_3) );
						map.put("TotalePuglia-2", String.valueOf(pugTot_2));
						map.put("TotalePuglia-1",String.valueOf( pugTot_1));
						map.put("TotalePuglia", String.valueOf( pugTot));
						map.put("TotalePugliaDiff", String.valueOf(pugTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Piemonte".equalsIgnoreCase(o.getName())){
						
						pieId = o.getCode();
						
						pieTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, pieId);
						pieTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, pieId);
						pieTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, pieId);
						pieTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, pieId);
						
						pieTotDiff = pieTot - pieTot_1;
						totale = totale + pieTot;
						totaleDiff = totaleDiff + pieTotDiff;
						totale_1 = totale_1 +pieTot_1 ;
						totale_2 = totale_2 +pieTot_2;
						totale_3 = totale_3 +pieTot_3 ;
						
						map.put("TotalePiemonte-3", String.valueOf(pieTot_3) );
						map.put("TotalePiemonte-2", String.valueOf(pieTot_2));
						map.put("TotalePiemonte-1",String.valueOf( pieTot_1));
						map.put("TotalePiemonte", String.valueOf( pieTot));
						map.put("TotalePiemonteDiff", String.valueOf(pieTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Sicilia".equalsIgnoreCase(o.getName())){
						
						sicId = o.getCode();
						
						sicTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, sicId);
						sicTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, sicId);
						sicTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, sicId);
						sicTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, sicId);
						
						sicTotDiff = sicTot - sicTot_1;
						totale = totale + sicTot;
						totaleDiff = totaleDiff + sicTotDiff;
						totale_1 = totale_1 +sicTot_1 ;
						totale_2 = totale_2 +sicTot_2;
						totale_3 = totale_3 +sicTot_3;
						
						map.put("TotaleSicilia-3", String.valueOf(sicTot_3) );
						map.put("TotaleSicilia-2", String.valueOf(sicTot_2));
						map.put("TotaleSicilia-1",String.valueOf( sicTot_1));
						map.put("TotaleSicilia", String.valueOf( sicTot));
						map.put("TotaleSiciliaDiff", String.valueOf(sicTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Sardegna".equalsIgnoreCase(o.getName())){
						
						sarId = o.getCode();
						
						sarTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, sarId);
						sarTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, sarId);
						sarTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, sarId);
						sarTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, sarId);
						
						sarTotDiff = sarTot - sarTot_1;
						totale = totale + sarTot;
						totaleDiff = totaleDiff + sarTotDiff;
						totale_1 = totale_1 +sarTot_1;
						totale_2 = totale_2 +sarTot_2;
						totale_3 = totale_3 +sarTot_3;
						
						map.put("TotaleSardegna-3", String.valueOf(sarTot_3) );
						map.put("TotaleSardegna-2", String.valueOf(sarTot_2));
						map.put("TotaleSardegna-1",String.valueOf( sarTot_1));
						map.put("TotaleSardegna", String.valueOf( sarTot));
						map.put("TotaleSardegnaDiff", String.valueOf(sarTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
		
					}
					if("Trentino-Alto Adige".equalsIgnoreCase(o.getName())){
						
						treId = o.getCode();
						
						treTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, treId);
						treTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, treId);
						treTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, treId);
						treTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, treId);
						
						treTotDiff = treTot - treTot_1;
						totale = totale + treTot;
						totaleDiff = totaleDiff + treTotDiff;
						totale_1 = totale_1 +treTot_1 ;
						totale_2 = totale_2 +treTot_2;
						totale_3 = totale_3 +treTot_3;
						
						map.put("TotaleTrentino-3", String.valueOf(treTot_3) );
						map.put("TotaleTrentino-2", String.valueOf(treTot_2));
						map.put("TotaleTrentino-1",String.valueOf( treTot_1));
						map.put("TotaleTrentino", String.valueOf( treTot));
						map.put("TotaleTrentinoDiff", String.valueOf(treTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
		
					}
					if("Toscana".equalsIgnoreCase(o.getName())){
						
						tosId = o.getCode();
						
						tosTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, tosId);
						tosTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, tosId);
						tosTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, tosId);
						tosTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, tosId);
						
						tosTotDiff = tosTot - tosTot_1;
						totale = totale + tosTot;
						totaleDiff = totaleDiff + tosTotDiff;
						totale_1 = totale_1 +umbTot_1;
						totale_2 = totale_2 +umbTot_2;
						totale_3 = totale_3 +umbTot_3;
						
						map.put("TotaleToscana-3", String.valueOf(tosTot_3) );
						map.put("TotaleToscana-2", String.valueOf(tosTot_2));
						map.put("TotaleToscana-1",String.valueOf( tosTot_1));
						map.put("TotaleToscana", String.valueOf( tosTot));
						map.put("TotaleToscanaDiff", String.valueOf(tosTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
		
		
					}
					if("Umbria".equalsIgnoreCase(o.getName())){
						
						umbId = o.getCode();
						
						umbTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, umbId);
						umbTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, umbId);
						umbTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, umbId);
						umbTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, umbId);
						
						umbTotDiff = umbTot - umbTot_1;
						totale = totale + umbTot;
						totaleDiff = totaleDiff + umbTotDiff;
						totale_1 = totale_1 +umbTot_1;
						totale_2 = totale_2 +umbTot_2;
						totale_3 = totale_3 +umbTot_3;
						
						map.put("TotaleUmbria-3", String.valueOf(umbTot_3) );
						map.put("TotaleUmbria-2", String.valueOf(umbTot_2));
						map.put("TotaleUmbria-1",String.valueOf( umbTot_1));
						map.put("TotaleUmbria", String.valueOf( umbTot));
						map.put("TotaleUmbriaDiff", String.valueOf(umbTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
		
					}
					if("Valle d'Aosta".equalsIgnoreCase(o.getName())){
						
						aosId = o.getCode();
						
						aosTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, aosId);
						aosTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, aosId);
						aosTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, aosId);
						aosTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, aosId);
						
						aosTotDiff = aosTot - aosTot_1;
						totale = totale + aosTot;
						totaleDiff = totaleDiff + aosTotDiff;
						totale_1 = totale_1 +aosTot_1;
						totale_2 = totale_2 +aosTot_2;
						totale_3 = totale_3 +aosTot_3;
						
						map.put("TotaleAosta-3", String.valueOf(aosTot_3) );
						map.put("TotaleAosta-2", String.valueOf(aosTot_2));
						map.put("TotaleAosta-1",String.valueOf( aosTot_1));
						map.put("TotaleAosta", String.valueOf( aosTot));
						map.put("TotaleAostaDiff", String.valueOf(aosTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
		
						
					}
					if("Veneto".equalsIgnoreCase(o.getName())){
						
						venId = o.getCode();
						
						venTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, venId);
						venTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, venId);
						venTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, venId);
						venTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, venId);
						
						venTotDiff = venTot - venTot_1;
						totale = totale + venTot;
						totaleDiff = totaleDiff + venTotDiff;
						totale_1 = totale_1 +venTot_1;
						totale_2 = totale_2 +venTot_2;
						totale_3 = totale_3 +venTot_3;
						
						map.put("TotaleVeneto-3", String.valueOf(venTot_3) );
						map.put("TotaleVeneto-2", String.valueOf(venTot_2));
						map.put("TotaleVeneto-1",String.valueOf( venTot_1));
						map.put("TotaleVeneto", String.valueOf( venTot));
						map.put("TotaleVenetoDiff", String.valueOf(venTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
					if("Lombardia".equalsIgnoreCase(o.getName())){
						
						lomId = o.getCode();
						
						lomTot = ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear(thisYearStart, lomId);
						lomTot_1 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_1Start, lomId);
						lomTot_2 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_2Start, lomId);
						lomTot_3 = ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear(Year_3Start, lomId);
						
						lomTotDiff = lomTot - lomTot_1;
						totale = totale + lomTot;
						totaleDiff = totaleDiff + lomTotDiff;
						totale_1 = totale_1 + lomTot_1;
						totale_2 = totale_2 + lomTot_2;
						totale_3 = totale_3 +lomTot_3;
						
						map.put("TotaleLombardia-3", String.valueOf(lomTot_3) );
						map.put("TotaleLombardia-2", String.valueOf(lomTot_2));
						map.put("TotaleLombardia-1",String.valueOf( lomTot_1));
						map.put("TotaleLombardia", String.valueOf( lomTot));
						map.put("TotaleLombardiaDiff", String.valueOf(lomTotDiff));
						map.put("Totale", String.valueOf(totale));
						map.put("TotaleDiff", String.valueOf(totaleDiff));
						map.put("Totale-1", String.valueOf(totale_1 ));
						map.put("Totale-2", String.valueOf(totale_2));
						map.put("Totale-3", String.valueOf(totale_3));
						continue;
						
					}
				}

				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
						"report"+ File.separator +"riepilogo tesserati annuali.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Riepilogo Tesserati Annuali.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(generateSummaryShooterSocReport){
			try {

				
				List<ESFOrganization> org = new ArrayList<ESFOrganization>();
				
				org = ESFOrganizationLocalServiceUtil.findAllESFOrganizations(1,ESFKeys.ESFStateType.ENABLE);
				
				com.itextpdf.text.Document document = new com.itextpdf.text.Document(); 
				ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
				PdfWriter writer = PdfWriter.getInstance(document, baos);
				document.open();
				
			//	ThemeDisplay themeDisplay = (ThemeDisplay)httpReq.getAttribute(WebKeys.THEME_DISPLAY);
				
			//	JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Soc_Shooter");
				
			//	String socShooter = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );
			
				SimpleDateFormat sdf = new SimpleDateFormat(); 
				sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dataStr = sdf.format(new Date());
				int year = Calendar.getInstance().get(Calendar.YEAR);
				document.add(new Paragraph("UFFICIO TESSERAMENTO                                                    "+String.valueOf(dataStr)));
				document.add(new Paragraph("SITUAZIONE TESSERATI ANNO"+year));
				document.add(new Paragraph(" "));
				
				PdfPCell c1 = new PdfPCell(new Phrase(""));
				PdfPTable table1 = new PdfPTable(4);
				//table1.addCell(c1);
				
				//int[] cellWidths = {50, 10};
				//table1.setWidths(cellWidths);
				
				table1.addCell("Società");
				table1.addCell("Rinnovi");
				table1.addCell("Nuove Tessere");
				table1.addCell("Totale");
				document.add(table1);
				
				//document.add(new Paragraph("Società                 Rinnovi           Nuove Tessere        Totale"));
				
				
				for(ESFOrganization o : org){
					List<ESFOrganization> soc = new ArrayList<ESFOrganization>();
					soc = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(o.getEsfOrganizationId());
					int regTot = 0;
					
					for(ESFOrganization s : soc){
						int socNewS = 0;
						int socOldS = 0 ;
						int socTot = 0;
						
						
						
						String thisYear = String.valueOf(year)+"-01-01";
						String lastYear = String.valueOf(year-1)+"-01-01";
						
						socOldS = ESFUserLocalServiceUtil.countRenwalUser(thisYear, lastYear, s.getEsfOrganizationId());
						socNewS = ESFUserLocalServiceUtil.countNewUser(thisYear,lastYear , s.getEsfOrganizationId());
						socTot = socOldS + socNewS;
						regTot = regTot + socTot;
						
						PdfPTable table2 = new PdfPTable(4);
						//document.add(new Paragraph("-----------------------------------------------------------------------------"));
						
						//table2.setWidths(cellWidths);
						// Section section = Chapter.addSection(sectionParagraph);
						
						
						
						PdfPCell c2 = new PdfPCell(new Phrase(""));
						table2.addCell(c2);
						
						c2 = new PdfPCell(new Phrase(""));
						table2.addCell(c1);
						
						c2 = new PdfPCell(new Phrase(""));
						table2.addCell(c1);
						
						c2 = new PdfPCell(new Phrase(""));
						table2.addCell(c1);
						table2.setHeaderRows(1);
						
						table2.addCell(s.getName());
						table2.addCell(String.valueOf(socOldS) );
						table2.addCell(String.valueOf(socNewS));
						table2.addCell(String.valueOf(socTot));
						
						document.add(table2);
						
						//document.add(new Paragraph("-----------------------------------------------------------------------------"));
						//document.add(new Paragraph(s.getName()+"     "+ socOldS +"              "+socNewS+ "            "+socTot));
						
					}
					document.add(new Paragraph("totale regione "+o.getName()+ " = "+regTot));
					document.add(new Paragraph(" "));
					
				}
				
				XMLWorkerHelper worker = XMLWorkerHelper.getInstance();	
//				InputStream is = new ByteArrayInputStream(socShooter.getBytes(StandardCharsets.UTF_8));
//				worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
				document.newPage();
				document.close();
				
				
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Situazione Tesseramento.pdf;");
				OutputStream out = response.getPortletOutputStream();
				baos.writeTo(out);
				out.flush();
				out.close();
			
				
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		if(genrateConiReport){
			boolean error = false;
			boolean notNewAssociation = ParamUtil.getBoolean(request, "notNewAssociation");
			
			_log.debug("notnewAssociation="+notNewAssociation);
			
			ConiReport coni = new ConiReport();
			coni.init(this.getPortletConfig());
			try {
				error = coni.generateConiReport(notNewAssociation,request, response);
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			_log.debug("--0  error ="+error);
			if(error){
				_log.debug("--1  error ="+error);
				SessionErrors.add(request, "error-Coni-Report");
			}
			
		}
		
	}

	private static Log _log = LogFactoryUtil.getLog(ESFReportPortlet.class);
}