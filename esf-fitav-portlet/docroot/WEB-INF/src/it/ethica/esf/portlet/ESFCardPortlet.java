
package it.ethica.esf.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mysql.jdbc.Connection;

import it.ethica.esf.model.ESFAnnualFreeCard;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.impl.ESFAnnualFreeCardImpl;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFConfigurationImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.service.ESFAnnualFreeCardLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;

public class ESFCardPortlet extends MVCPortlet {

	private String templatePath = new String();

	@Override
	public void init(PortletConfig config)
		throws PortletException {

		templatePath = config.getInitParameter("template-path");
		super.init(config);
	}
	
	public void serveResource(ResourceRequest request, ResourceResponse response)
					throws IOException, PortletException {
		
		HttpServletRequest httpReq =
						PortalUtil.getHttpServletRequest(request);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
				
		HttpServletResponse httpResp = PortalUtil.getHttpServletResponse(response);
			
		String resourceID = request.getResourceID();
		
		boolean genrateFreeCard = ParamUtil.getBoolean(request, "genrateFreeCard");
		
		if(genrateFreeCard){
			long assId = ParamUtil.getLong(request, "esfOrganizationId");
			long numCard = ParamUtil.getLong(request, "numCard");
			String orgCode = "";
			String orgName= "";
			
			ESFOrganization org = new ESFOrganizationImpl();
			
			try {
				org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(assId);
				orgCode = org.getCode();
				orgName = org.getName();
			}
			catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String code = "";
			HashMap map = new HashMap();
			try {
				code = associateCard(assId, numCard, request);
			}
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				_log.info("PortalException="+e.getMessage());
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.info("SystemException="+e.getMessage());
			}
			
			if(!"error".equals(code)){
				String connectionURL = PropsUtil.get("jdbc.default.url");
				String userName = PropsUtil.get("jdbc.default.username");
				String password = PropsUtil.get("jdbc.default.password");
				map.put("code", code);
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
					String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
									"report"+ File.separator +"Bollettini_Vuoti.jasper";
					InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
					
					JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
					
					JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
					
					byte[] bytes = null;
					bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
					response.reset();
					response.resetBuffer();
					response.setContentType("application/pdf");
					response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Bollettini vuoti società "+orgName+".pdf;");
					response.setContentLength(bytes.length);
					OutputStream ouputStream =  response.getPortletOutputStream();
					ouputStream.write(bytes, 0, bytes.length);
					ouputStream.flush();
					ouputStream.close();
					
					SessionMessages.add(request, "created-Card");
				}
				catch (ClassNotFoundException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				SessionErrors.add(request, "error-create-card");
			}
			
		}
	}
	
	public String associateCard(long assId, long numCard, ResourceRequest request)
			throws PortalException, SystemException {
		
		HttpServletRequest httpReq =
						PortalUtil.getHttpServletRequest(request);
				httpReq = PortalUtil.getOriginalServletRequest(httpReq);
				
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFCard.class.getName(), request);
		
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		long userId = themeDisplay.getUserId();
		String userName = themeDisplay.getUser().getScreenName();
		long groupId = user.getGroupId();
		long companyId = user.getCompanyId();
		
		Date now = new Date();
		
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		
		String treePath = StringPool.BLANK;
		String regionCode = StringPool.BLANK;
		String oldMaxCard = StringPool.BLANK;
		String cardCode = StringPool.BLANK;
		String code = StringPool.BLANK;
		String orgCode = StringPool.BLANK;
		String orgName = StringPool.BLANK;
		String codeAlfa = StringPool.BLANK;
		
		long esfOrganizationId = assId;
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long regionId = 0;
		
		int cardNum = 0;
		
		ESFOrganization org = new ESFOrganizationImpl();
		ESFOrganization reg = new ESFOrganizationImpl();
		ESFConfiguration conf = new ESFConfigurationImpl();
		ESFAnnualFreeCard freeCard = new ESFAnnualFreeCardImpl();
		ESFCard card = new ESFCardImpl();
		ESFEntityState state = new ESFEntityStateImpl();
		
		HashMap map = new HashMap();
		
		if(0 < esfOrganizationId){
			try {
				org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationId);
				orgCode = org.getCode();
				orgName = org.getName();
				
				treePath = org.getTreePath();
				regionId = Long.valueOf(treePath.substring(7, 12));
				
				reg = ESFOrganizationLocalServiceUtil.fetchESFOrganization(regionId);
				regionCode = reg.getCode();
				
			}
			catch (Exception e) {
				// TODO: handle exception
				_log.info("errore ricerca società e regione");
				//SessionErrors.add(request, "error-find-ass");
			}
		}
		
	/*	if("ABR".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_ABR");
		}else if("BAS".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_BAS");
		}else if("CAL".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAL");
		}else if("CAM".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAM");
		}else if("EMR".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_EMR");
		}else if("FVG".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_FVG");
		}else if("LAZ".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LAZ");
		}else if("LIG".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LIG");
		}else if("LOM".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LOM");
		}else if("MAR".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MAR");
		}else if("MOL".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MOL");
		}else if("PIE".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PIE");
		}else if("PUG".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PUG");
		}else if("SAR".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SAR");
		}else if("SIC".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SIC");
		}else if("TOS".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TOS");
		}else if("TAA".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TAA");
		}else if("UMB".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_UMB");
		}else if("AOS".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_AOS");
		}else if("VEN".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_VEN");
		}else{
			_log.info("errore ricerca società e regione");
			SessionErrors.add(request, "error-find-ass");
			return "error";
		}*/
		
		if("AB".equals(regionCode.toUpperCase()) || "ABR".equals(regionCode) ){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_ABR");
		}else if("BS".equals(regionCode.toUpperCase()) || "BAS".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_BAS");
		}else if("CL".equals(regionCode.toUpperCase()) || "CAL".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAL");
		}else if("CP".equals(regionCode.toUpperCase()) || "CAM".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAM");
		}else if("ER".equals(regionCode.toUpperCase()) || "EMR".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_EMR");
		}else if("FG".equals(regionCode.toUpperCase()) || "FVG".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_FVG");
		}else if("LZ".equals(regionCode.toUpperCase()) || "LAZ".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LAZ");
		}else if("LG".equals(regionCode.toUpperCase()) || "LIG".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LIG");
		}else if("LM".equals(regionCode.toUpperCase()) || "LOM".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LOM");
		}else if("MR".equals(regionCode.toUpperCase()) || "MAR".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MAR");
		}else if("ML".equals(regionCode.toUpperCase()) || "MOL".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MOL");
		}else if("PV".equals(regionCode.toUpperCase()) || "PIE".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PIE");
		}else if("PG".equals(regionCode.toUpperCase()) || "PUG".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PUG");
		}else if("SD".equals(regionCode.toUpperCase()) || "SAR".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SAR");
		}else if("SC".equals(regionCode.toUpperCase()) || "SIC".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SIC");
		}else if("TS".equals(regionCode.toUpperCase()) || "TOS".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TOS");
		}else if("TA".equals(regionCode.toUpperCase()) || "TAA".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TAA");
		}else if("UB".equals(regionCode.toUpperCase()) || "UMB".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_UMB");
		}else if("Pv".equals(regionCode.toUpperCase()) || "AOS".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_AOS");
		}else if("VN".equals(regionCode.toUpperCase()) || "VEN".equals(regionCode)){
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_VEN");
		}else{
			_log.info("errore ricerca società e regione");
			SessionErrors.add(request, "error-find-ass");
			return "error";
		}
		
		oldMaxCard = conf.getValue();
		
		try {
			codeAlfa = oldMaxCard.substring(0, 2);
			cardNum = Integer.valueOf(oldMaxCard.substring(2, oldMaxCard.length()));
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.info("errore codice regione o formato numero dell' ultima tessera");
			return "error";
		}
		code = String.valueOf(esfOrganizationId+String.valueOf(year)+String.valueOf(month)+String.valueOf(day));

		try {
			for (int i = 0; i < numCard ; i++){
				
				cardNum = cardNum +1;
				cardCode = codeAlfa + String.valueOf(cardNum);
				
				long esfAFCId = CounterLocalServiceUtil.increment(ESFAnnualFreeCard.class.getName());
				
				freeCard.setAnnualFreeCardId(esfAFCId);
				freeCard.setCompanyId(companyId);
				freeCard.setUserName(userName);
				freeCard.setUserId(userId);
				freeCard.setCreateDate(now);
				freeCard.setAssId(esfOrganizationId);
				freeCard.setCode(code);
				freeCard.setCardCode(cardCode);
				freeCard.setAssCode(orgCode);
				freeCard.setAssName(orgName);
				
				ESFAnnualFreeCardLocalServiceUtil.addESFAnnualFreeCard(freeCard);
				
				long esfCardId = CounterLocalServiceUtil.increment(ESFCard.class.getName());
				
				card.setUuid(serviceContext.getUuid());
				card.setEsfCardId(esfCardId);
				card.setCompanyId(companyId);
				card.setGroupId(groupId);
				card.setUserName(userName);
				card.setUserId(userId);
				card.setCreateDate(now);
				card.setCodeAlfa(codeAlfa);
				card.setCodeNum(cardNum);
				card.setCode(cardCode);
				card.setEsfOrganizationId(esfOrganizationId);
				
				ESFCardLocalServiceUtil.addESFCard(card);
				
				long esfentityId = CounterLocalServiceUtil.increment(ESFEntityState.class.getName());
				
				state.setEsfEntityStateId(esfentityId);
				state.setCompanyId(companyId);
				state.setGroupId(groupId);
				state.setUserName(userName);
				state.setUserId(userId);
				state.setCreateDate(now);
				state.setClassName("it.ethica.esf.model.ESFCard");
				state.setClassPK(esfCardId);
				state.setStartDate(now);
				state.setEndDate(null);
				state.setEsfStateId(ESFKeys.ESFStateType.ENABLE);
				
				ESFEntityStateLocalServiceUtil.addESFEntityState(state);
				
				conf.setValue(cardCode);
				ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.info("errore nella creazione delle entità");
			return "error";
		}
		
		return code;
	}
	
	public void updateRegionCard(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		
		String maxCardABR = ParamUtil.getString(request, "maxCardABR");
		String maxCardCAL = ParamUtil.getString(request, "maxCardCAL");
		String maxCardBAS = ParamUtil.getString(request, "maxCardBAS");
		
		String maxCardCAM = ParamUtil.getString(request, "maxCardCAM");
		String maxCardEMR = ParamUtil.getString(request, "maxCardEMR");
		String maxCardFVG = ParamUtil.getString(request, "maxCardFVG");
		
		String maxCardLAZ = ParamUtil.getString(request, "maxCardLAZ");
		String maxCardLIG = ParamUtil.getString(request, "maxCardLIG");
		String maxCardLOM = ParamUtil.getString(request, "maxCardLOM");
		
		String maxCardMAR = ParamUtil.getString(request, "maxCardMAR");
		String maxCardMOL = ParamUtil.getString(request, "maxCardMOL");
		String maxCardPIE = ParamUtil.getString(request, "maxCardPIE");
		
		String maxCardPUG = ParamUtil.getString(request, "maxCardPUG");
		String maxCardSAR = ParamUtil.getString(request, "maxCardSAR");
		String maxCardSIC = ParamUtil.getString(request, "maxCardSIC");
		
		String maxCardTOS = ParamUtil.getString(request, "maxCardTOS");
		String maxCardTAA = ParamUtil.getString(request, "maxCardTAA");
		String maxCardUMB = ParamUtil.getString(request, "maxCardUMB");
		
		String maxCardAOS = ParamUtil.getString(request, "maxCardAOS");
		String maxCardVEN = ParamUtil.getString(request, "maxCardVEN");
		
		ESFConfiguration conf = new ESFConfigurationImpl();
		
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_ABR");
		conf.setValue(maxCardABR); 
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_BAS");
		conf.setValue(maxCardBAS); 
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAL");
		conf.setValue(maxCardCAL); 
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAM");
		conf.setValue(maxCardCAM);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_EMR");
		conf.setValue(maxCardEMR);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_FVG");
		conf.setValue(maxCardFVG);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LAZ");
		conf.setValue(maxCardLAZ);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LIG");
		conf.setValue(maxCardLIG);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LOM");
		conf.setValue(maxCardLOM);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MAR");
		conf.setValue(maxCardMAR);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MOL");
		conf.setValue(maxCardMOL);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PIE");
		conf.setValue(maxCardPIE);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PUG");
		conf.setValue(maxCardPUG);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SAR");
		conf.setValue(maxCardSAR);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SIC");
		conf.setValue(maxCardSIC);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TOS");
		conf.setValue(maxCardTOS);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TAA");
		conf.setValue(maxCardTAA);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_UMB");
		conf.setValue(maxCardUMB);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_AOS");
		conf.setValue(maxCardAOS);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_VEN");
		conf.setValue(maxCardVEN);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		response.setRenderParameter("mvcPath", templatePath +
				"selectcard.jsp");
	}

	public void assignCard(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		int numTotCards = ParamUtil.getInteger(request, "numTotCards");
		int numCards = ParamUtil.getInteger(request, "numberOfCard");
		long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
		List<ESFCard> cards =  ESFCardLocalServiceUtil.getAllFreeCard();
		
		if(numCards > numTotCards){
			SessionErrors.add(request, "numberCard-reference-error");
			
		}else{
			for(int i = 0 ; i < numCards ; i++){
				cards.get(i).setEsfOrganizationId(esfOrganizationId);
				ESFCardLocalServiceUtil.updateESFCard(cards.get(i));
			}
		}
		response.setRenderParameter("mvcPath", "/html/esfcard/view.jsp");
		
	}

	public void createCard(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFCard.class.getName(), request);
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			int numCards = ParamUtil.getInteger(request, "numCards");
			int create = ESFCardLocalServiceUtil.createMultiESFCard( esfUserId, numCards, serviceContext);
			if(create == numCards){
				SessionMessages.add(request, "esfcard-add-success");
			}else{
				SessionMessages.add(request, "esfcard-partialadd-success");
			}
			
			response.setRenderParameter("mvcPath", templatePath +
					"view.jsp");
			
		}
	private static Log _log = LogFactoryUtil.getLog(ESFCardPortlet.class);
}
