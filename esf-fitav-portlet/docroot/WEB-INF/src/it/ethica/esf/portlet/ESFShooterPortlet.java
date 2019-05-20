
package it.ethica.esf.portlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ContactBirthdayException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.util.FiscalCodeCalculatorUtil;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFFederalRole;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFFederalRole;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFCaneImpl;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFUserRoleImpl;
import it.ethica.esf.portlet.utility.GenerateShooterCV;
import it.ethica.esf.portlet.utility.ShooterUtility;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

/**
 * Portlet implementation class ESFShooter
 */
public class ESFShooterPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		getEsfFederalRoles(request, response);
		getAssociatedEsfFederalRoles(request, response);
		String from = ParamUtil.getString(request, "from");
		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();

		try {
			String op = ParamUtil.getString(request, "op");
		
			if (op.equals("chooseorg")) {
				esfJsonUtil.prepareJSONOrganizations(request, response);
				from = "from";
			}
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		
		
		if (Validator.isNotNull(from)){
				super.render(request, response);
		}
		else {
			ShooterUtility su = new ShooterUtility();
			su.init(this.getPortletConfig());
			su.render(request, response);
		}
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		_log.debug("serveresource");
		HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		boolean isCatridge = ParamUtil.getBoolean(httpReq, "isCatridge", false);
		long esfGunTypeId = ParamUtil.getLong(httpReq, "esfGunTypeId", 0);
		long esfShooterId = ParamUtil.getLong(resourceRequest, "esfUserId");
		boolean generateCurriculum = ParamUtil.getBoolean(resourceRequest, "generateCurriculum");
		
		String resourceID = resourceRequest.getResourceID();
		
		if(isCatridge && esfGunTypeId > 0){
			List<ESFCatridge> catridges = new ArrayList<ESFCatridge>();
			try {
				catridges = ESFCatridgeLocalServiceUtil.getESFCatridges();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();
			
			for (ESFCatridge catridge : catridges) {
				if(catridge.getEsfGunTypeId() == esfGunTypeId){
					
					JSONObject esfcatridgeIdName = JSONFactoryUtil.createJSONObject();
					
					esfcatridgeIdName.put(
							"esfCatridgeId", catridge.getEsfCatridgeId());
					esfcatridgeIdName.put("name", catridge.getCatridgeModel());

						resultJSONArr.put(esfcatridgeIdName);
				}
				
			}
			resultJSONObj.put("esfCatridges", resultJSONArr);
			resourceResponse.getWriter().write(resultJSONObj.toString());
		}
		
		try {
			
			if (Validator.isNotNull(resourceID) &&  resourceID.equals("fiscalCode")) {
				_log.debug("nella serveresource fiscal code");
				JSONObject fiscalcode = serveFiscalCode(resourceRequest,resourceResponse);
				resourceResponse.getWriter().print(fiscalcode);
				
			}
		}
		catch (IOException ioe) {
			throw ioe;
		}/*
		catch (PortletException pe) {
			throw pe;
		}*/
		catch (Exception e) {
			throw new PortletException(e);
		}
		
		try {
			if (Validator.isNotNull(resourceID) && (resourceID.equals("liv1") || resourceID.equals("liv2") ||
					resourceID.equals("liv3"))) {
			ESFServiceUtil esfServiceUtil =
				new ESFServiceUtil(ESFUser.class.getName(), resourceRequest);
			
			String param =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"param");
			String idEsfOrganization =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"esfOrganizationId");
			
			esfServiceUtil.serveOrganization(
				resourceRequest, resourceResponse, param, idEsfOrganization);
			}

		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (PortletException pe) {
			throw pe;
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
		
		if(!isCatridge){
			ShooterUtility su = new ShooterUtility();
			su.init(this.getPortletConfig());
			su.serveResource(resourceRequest, resourceResponse);
			}
		
		if(generateCurriculum && 0 < esfShooterId){
			try {
				
				GenerateShooterCV sCV = new GenerateShooterCV();
				
				sCV.init(this.getPortletConfig());
				sCV.generateShooterCV(resourceRequest , resourceResponse, esfShooterId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public JSONObject serveFiscalCode(ResourceRequest resourceRequest,
		ResourceResponse resourceResponse) throws Exception {
	
	
	JSONObject jsonFiscalCode = JSONFactoryUtil.createJSONObject();
	
	String result = "ko";
	String fiscalCode = "01";
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	String lastName =
					ParamUtil.getString(resourceRequest,"lastName").replace(" ", "");
			String firstName =
					ParamUtil.getString(resourceRequest,"firstName").replace(" ","");
			String secondName =
					ParamUtil.getString(resourceRequest,"middleName").replace(" ","");
			String birthcity =
					ParamUtil.getString(resourceRequest,"birthcity").replace(" ","");
			Boolean male =
					ParamUtil.getBoolean(resourceRequest,"male");
			Date birthday =
					ParamUtil.getDate(resourceRequest,"birthday",sdf);
			String sex = "f";
			if (male){
				
				sex = "m";
				
			}
		
	fiscalCode=calculateFiscalCode(lastName, firstName, sex, birthday, birthcity);
	if(!fiscalCode.trim().equals("01") && !fiscalCode.trim().equals("02")){
		result="ok";
	}
	System.out.println("codice calcolato: "+fiscalCode);
	jsonFiscalCode.put("result", result);
	jsonFiscalCode.put("fiscalCode", fiscalCode);
	
	return jsonFiscalCode;
	}
	
	/*
	public JSONObject serveFiscalCode(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		
		
		JSONObject jsonFiscalCode = JSONFactoryUtil.createJSONObject();
		
		String result = "ko";
		String fiscalCode = "01";
		
		String lastName =
				ParamUtil.getString(resourceRequest,"lastName").replace(" ", "");
		String firstName =
				ParamUtil.getString(resourceRequest,"firstName").replace(" ","");
		String secondName =
				ParamUtil.getString(resourceRequest,"middleName").replace(" ","");
		String birthcity =
				ParamUtil.getString(resourceRequest,"birthcity").replace(" ","");
		Boolean male =
				ParamUtil.getBoolean(resourceRequest,"male");
		String birthday =
				ParamUtil.getString(resourceRequest,"birthday");
		String sex = "f";
		if (male){
			
			sex = "m";
			
		}
		String totalName = firstName.concat(secondName);
		String url = "http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?Nome="+totalName+"&Cognome="+lastName+"&ComuneNascita="
					+birthcity+"&DataNascita="+birthday+"&Sesso="+sex;
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		URLConnection connection = new URL(url).openConnection();
		
		con.setRequestMethod("GET");
		int responseCode =0;
		try {
			responseCode = con.getResponseCode();
		} catch (Exception e) {
			fiscalCode = "02";
			jsonFiscalCode.put("result", result);
			jsonFiscalCode.put("fiscalCode", fiscalCode);
			return jsonFiscalCode;
		}
		
		BufferedReader in = new BufferedReader(
			new InputStreamReader(con.getInputStream()));
		
		String inputLine;
		
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String responseString = response.toString();
		
		
				
		if(responseString.length()>117 && !responseString.substring(101,117).contains(" ") && (StringPool.BLANK != birthday )
				&& (StringPool.BLANK != lastName ) && (StringPool.BLANK != firstName ) && (StringPool.BLANK != birthcity)){
			result = "ok";
			fiscalCode = responseString.substring(101,117);
		}
		jsonFiscalCode.put("result", result);
		jsonFiscalCode.put("fiscalCode", fiscalCode);
		return jsonFiscalCode;
	}*/

	public void addESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUser.class.getName(), actionRequest);
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String userEmail = ParamUtil.getString(actionRequest, "userEmail");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		boolean validateCF = ParamUtil.getBoolean(actionRequest, "validateCF");
		long oldShooterCode = ParamUtil.getLong(actionRequest, "oldShooterCode");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		
		Date privacy1Date = calendar.getTime();
		Date privacy2Date = null;
		Date privacy3Date = null;
		
		boolean privacy1 = true;
		boolean privacy2 = ParamUtil.getBoolean(actionRequest, "privacy2");
		boolean privacy3 = ParamUtil.getBoolean(actionRequest, "privacy3");
		
		if(privacy2){
			privacy2Date = ManageDate.StringToDate(ParamUtil.getString(actionRequest, "privacy2Date"));
		}
		
		if(privacy3){
			privacy3Date = ManageDate.StringToDate(ParamUtil.getString(actionRequest, "privacy3Date"));
		}
		

		if (Validator.isNotNull(fiscalCode)) {

			if (!ManageOperationsField.validate(fiscalCode)){
				SessionErrors.add(actionRequest, "error");
			return;
			}
		}

		String es = ParamUtil.getString(actionRequest, "birthday");
		Date birthday = null;
		try {
			birthday = ManageDate.StringToDate(es);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		int year = ManageDate.getYear(birthday);
		int month = ManageDate.getMonth(birthday);
		int day = ManageDate.getDay(birthday);

		String birthcity = ParamUtil.getString(actionRequest, "birthcity");
		
		String nationality = ParamUtil.getString(actionRequest, "nationality");
		
		boolean male = ParamUtil.getBoolean(actionRequest, "male");
		
		long esfEntityStateId = ESFKeys.ESFStateType.ENABLE;
		List<ESFPhone> phones =
			ManageOperationsField.getPhones(actionRequest, actionResponse);

		long esfCardId = ParamUtil.getLong(actionRequest, "esfCardId");
		List<ESFAddress> addresses =
			ManageOperationsField.getAddresses(actionRequest, actionResponse);

		String skype = ParamUtil.getString(actionRequest, "skype");
		String facebook = ParamUtil.getString(actionRequest, "facebook");
		String twitter = ParamUtil.getString(actionRequest, "twitter");

		boolean ckisarmy = ParamUtil.getBoolean(actionRequest, "ckisarmy");
		boolean isSportsGroups = false;
		long typearmy = 0;
		if (ckisarmy) {
			typearmy = ParamUtil.getLong(actionRequest, "typearmy");
			isSportsGroups =
				ParamUtil.getBoolean(actionRequest, "isSportsGroups");
		}

		String job = ParamUtil.getString(actionRequest, "job");
		String jobTitle = ParamUtil.getString(actionRequest, "work");
		String issfIdNumber =
			ParamUtil.getString(actionRequest, "issfIdNumber");

		try {

			if (ESFUserLocalServiceUtil.checkEmailAddress(
				userEmail, serviceContext) != null) {
				SessionErrors.add(actionRequest, "user-email-message");
			}
			else if (ckisarmy && typearmy <= 0) {
				SessionErrors.add(actionRequest, "select-type-of-army");
			}
			else {
				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(esfEntityStateId);

				ESFCard esfCard = ESFCardLocalServiceUtil.getESFCard(esfCardId);
				ESFUser userResult =
					ESFUserLocalServiceUtil.addESFShooter(
						serviceContext.getUserId(), StringPool.BLANK,
						firstName, middleName, lastName, userEmail, fiscalCode,
						day, month, year, birthcity, nationality, male, skype,
						facebook, twitter, typearmy, isSportsGroups, job,
						jobTitle, issfIdNumber, esfEntityState, esfCard,
						addresses, phones, privacy1, privacy2, privacy3,
						privacy1Date, privacy2Date, privacy3Date, validateCF,
						oldShooterCode, serviceContext);
				if (Validator.isNotNull(userResult) &&
					userResult.getEsfUserId() > 0){
					SessionMessages.add(actionRequest, "shooter-success-insert");
				}
				else{
					SessionErrors.add(actionRequest, "shooter-error-insert");
				}
			}
		}
		catch (ContactBirthdayException cbe) {
			SessionErrors.add(actionRequest, "user-birthday-message");
			cbe.printStackTrace();
		}
		catch (Exception e) {
			_log.error("Error in addESFUser method: " + e.getMessage());
			SessionErrors.add(actionRequest, "shooter-error-insert");
			e.printStackTrace();
		}

	}

	public void updateESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException, PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.updateESFShooter(
		actionRequest, actionResponse, "esfshooter");
	}

	public void editESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig()); 
		su.editESFGun(request, response, "esfshooter");
	}

	public void editESFdocument(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException,
		PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFdocument(request, response, "esfshooter");

	}
	
	public void deleteESFdocument(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException,
					PortletException {

					ShooterUtility su = new ShooterUtility();
					su.init(this.getPortletConfig());
					su.deleteESFdocument(request, response, "esfshooter");

	}
	
	public void changeCard(ActionRequest request, ActionResponse response) throws SystemException,
	PortletException, PortalException, ParseException
	{
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFCard(request, response,"esfshooter");
	}
	
	public void newCard(ActionRequest request, ActionResponse response) throws SystemException,
	PortletException, PortalException, ParseException
	{
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.newCard(request, response,"esfshooter");
	}
	
	
	public void editESFGunType(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

					long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
					String name = ParamUtil.getString(request, "name");
					String description = ParamUtil.getString(request, "description");
					String modifyMode=ParamUtil.getString(request, "modifyMode");
					boolean isCatridgeProductor = ParamUtil.getBoolean(request, "isCatridgeProductor");

					if (esfGunTypeId > 0) {
						ESFGunType esfGunType =
							ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);

						if (ESFGunTypeLocalServiceUtil.checkNome(name, serviceContext) != null &&
							!esfGunType.getName().equals(name)) {
							SessionErrors.add(request, "esfGunType-reference-error");
						}
						else {
							ESFGunTypeLocalServiceUtil.updateESFGunType(
								serviceContext.getUserId(), esfGunTypeId, name,
								description, isCatridgeProductor, serviceContext);
						}
					}
					else {
						if (ESFGunTypeLocalServiceUtil.checkNome(name, serviceContext) != null) {
							SessionErrors.add(request, "esfGunType-reference-error");
						}
						else {
							ESFGunTypeLocalServiceUtil.addESFGunType(
								serviceContext.getUserId(), name, description, isCatridgeProductor,
								serviceContext);
							
							
						}
					}
					response.setRenderParameter("pathBack",mvc);
					response.setRenderParameter("esfUserId", esfUserId);
					response.setRenderParameter("mvcPath",mvc);
					response.setRenderParameter("modifyMode", modifyMode);
	}


	
	public void deleteESFGun(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {

					String esfUserId=ParamUtil.getString(request, "esfUserId");

					long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
					if (esfgunUserId > 0) {
						ESFgunUser esFgunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
						ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
					}
					response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
									"/edit_esfShooter.jsp");
								
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				
	}
	
	public void removeRole(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, ParseException {
			
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
			long esforgId = ParamUtil.getLong(request, "esforgId");
			String esfstartDate = ParamUtil.getString(request,  "esfstartDate");
			
			
			SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate  = dateParser.parse(esfstartDate);
			
			ESFUserESFUserRolePK esfUserESFUserRolePK = new ESFUserESFUserRolePK();
			esfUserESFUserRolePK.setEsfUserId(esfUserId);
			esfUserESFUserRolePK.setEsfUserRoleId(esfUserRoleId);
			esfUserESFUserRolePK.setEsfOrganizationId(esforgId);
			esfUserESFUserRolePK.setStartDate(startDate);
			ESFUserESFUserRole userRole = ESFUserESFUserRoleLocalServiceUtil.fetchESFUserESFUserRole(esfUserESFUserRolePK);
			if(Validator.isNotNull(userRole)){
				ESFUserESFUserRoleLocalServiceUtil.deleteESFUserESFUserRole(userRole);
			}
			response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
							"/edit_esfShooter.jsp");
						
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		
	}
	
	public void deleteESFCane(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

			String esfUserId=ParamUtil.getString(request, "esfUserId");

			long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
			if (esfgunUserId > 0) {
				ESFgunUser esFgunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
				ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
			}
			response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
							"/edit_esfShooter.jsp");
						
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					
					
				
	}
	
	public void editESFGunKind(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
					
					long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
					long esfGunTypeId = ParamUtil.getLong(request, "gunTypeId");
					String description = ParamUtil.getString(request, "description");
					String esfGunId=ParamUtil.getString(request, "esfGunId");
					String modifyMode=ParamUtil.getString(request, "modifyMode");
					
					String name = ParamUtil.getString(request, "name");
					
					if (esfGunKindId > 0) {
						
							ESFGunKindLocalServiceUtil.updateESFGunKind(
								serviceContext.getUserId(), esfGunKindId, name,
								description, esfGunTypeId, serviceContext);
					}
					else {
						
						ESFGunKindLocalServiceUtil.addESFGunKind(
								serviceContext.getUserId(), name, description, 
								esfGunTypeId, serviceContext);

					}
					response.setRenderParameter("pathBack",mvc);
					response.setRenderParameter("esfUserId", esfUserId);
					response.setRenderParameter("mvcPath",mvc);
					response.setRenderParameter("esfGunId", esfGunId);
					response.setRenderParameter("modifyMode", modifyMode);
	}

	public void editESFCatridge(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, PortletException {

		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
			String note=ParamUtil.getString(request, "note");
			long esfOrganizationId =
					ParamUtil.getLong(request, "esfOrganizationId");
			long shooteId = ParamUtil.getLong(request, "esfUserId");
			long catridgeModelId = ParamUtil.getLong(request, "catridgeModel");
			int type = ESFKeys.ESFGunType.CATRIDGE;
			String code = "";
			boolean isFavoriteGun = false;
			long gunId = 0;
			long caliber = 0;
			
			
			if(catridgeModelId > 0){
				gunId = catridgeModelId;
				ESFCatridge catridge = ESFCatridgeLocalServiceUtil.fetchESFCatridge(catridgeModelId);
				caliber = catridge.getCatridgeCaliber();
			
			}else{
				gunId = esfGunTypeId;
			}
			
			
			
			if( shooteId > 0){
				ESFgunUserLocalServiceUtil.addESFGunUser(gunId, shooteId,
						code, isFavoriteGun, type, note, esfGunTypeId,
						catridgeModelId, 0, "", caliber , serviceContext);
			}else{
				SessionErrors.add(request, "Catridge-reference-error");
			}
			
			
			
			request.setAttribute("esfUserId", esfUserId);
			request.setAttribute("op", "updAddr");
			request.setAttribute("organizationId", esfOrganizationId);
			response.setRenderParameter(
				"mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

			response.setRenderParameter("op", "updAddr");
			
	}
	
	public void editESFCane(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
						long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
					long esfOrganizationId =
						ParamUtil.getLong(request, "esfOrganizationId");
					long esfUserId = ParamUtil.getLong(request, "esfUserId");
					long caneCaliber =  ParamUtil.getLong(request, "caliber");
					int typeId= ParamUtil.getInteger(request, "typology") ;
					String measures=ParamUtil.getString(request, "measures");
					boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
					String code=ParamUtil.getString(request, "code");
					long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
					

					String shooter_note = ParamUtil.getString(request, "shooter_note");
					
					List<ESFgunUser> codeGuns = new ArrayList<ESFgunUser>();
					
					
				
					codeGuns = ESFgunUserLocalServiceUtil.findbyCode(code);
					
					if(codeGuns.size() > 0){
						SessionErrors.add(request, "duplicate_code");
						response.setRenderParameter(
								"mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
							response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

						return ; 
					}else{
						
						ESFCaneLocalServiceUtil.addESFCane(
							serviceContext.getUserId(), esfGunKindId,esfGunTypeId,
							esfUserId, esfOrganizationId, code, caneCaliber, typeId, 
							measures, isFavoriteGun, esfUserId, shooter_note, serviceContext);
		
					
					}	
					request.setAttribute("esfUserId", esfUserId);
					request.setAttribute("op", "updAddr");
					request.setAttribute("organizationId", esfOrganizationId);
					response.setRenderParameter(
						"mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

					response.setRenderParameter("op", "updAddr");

	}
	
	
	public void deleteESFCatridge(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {

			String esfUserId=ParamUtil.getString(request, "esfUserId");

			long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
			if (esfgunUserId > 0) {
				ESFgunUser esFgunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
				ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
			}
			response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
							"/edit_esfShooter.jsp");
						
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				
	}
	
	public void editESFRifle (ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFgunUser.class.getName(), request);
		
		long shooterId = ParamUtil.getLong(request, "esfUserId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		
		int type =ESFKeys.ESFGunType.RIFLE;
		
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "code");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		int typeId = ParamUtil.getInteger(request, "typology");
		String measures = ParamUtil.getString(request, "measures");
		long caliber = ParamUtil.getLong(request, "caliber");
		
		List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		
		if(gunUsers.size() == 0){
			ESFgunUserLocalServiceUtil.addESFGunUser(esfGunTypeId, shooterId, freshman, isFavoriteGun,
					type, shooter_note, esfGunTypeId, esfGunKindId,
					typeId, measures, caliber, serviceContext);
		}else{
			SessionErrors.add(request, "duplicate_code");
		}
		response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
				"/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(shooterId));
		
	}
	
	public void alterESFRifle (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		long userId = ParamUtil.getLong(request, "userId");
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		boolean favorite = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		int typeId = ParamUtil.getInteger(request, "typology");
		String measures = ParamUtil.getString(request, "measures");
		String caliber = ParamUtil.getString(request, "caliber");
		List<ESFgunUser> esfGunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		
		
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			SessionErrors.add(request, "esfGunType-reference-error");
		}
	
		if(esfGunUsers.size() > 0 &&
				esfGunUsers.get(0).getEsfGunUserId() != esfGunUserId){
			SessionErrors.add(request, "duplicate_code");
		}else{
		
			if(Validator.isNotNull(gunUser)){
				
				gunUser.setCode(freshman);
				gunUser.setNote(shooter_note);
				gunUser.setIsFavorite(favorite);
				gunUser.setEsfCaliber(caliber);
				gunUser.setEsfMeasures(measures);
				gunUser.setTypeId(typeId);
				
				ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
				
			}else{
				response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
						"/edit_esfShooter.jsp");
					
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				return;
			}
		}
		
		response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
				"/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(userId));
	}
	
	public void alterESFCane (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		long userId = ParamUtil.getLong(request, "userId");
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		String measures= ParamUtil.getString(request, "measures");
		long caliber= ParamUtil.getLong(request, "caliber");
		int typologyId = ParamUtil.getInteger(request, "typology");
		boolean favorite = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		List<ESFgunUser> esfGunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		ESFCane esfCane = new ESFCaneImpl();
		
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			SessionErrors.add(request, "esfGunType-reference-error");
		}
		esfCane = ESFCaneLocalServiceUtil.fetchESFCane(gunUser.getEsfGunId());
		
		if(esfGunUsers.size() > 0 &&
				esfGunUsers.get(0).getEsfGunUserId() != esfGunUserId){
			SessionErrors.add(request, "duplicate_code");
			
		}else{
			
			if(Validator.isNotNull(gunUser) && Validator.isNotNull(esfCane)){
				
				gunUser.setCode(freshman);
				gunUser.setNote(shooter_note);
				gunUser.setIsFavorite(favorite);
				gunUser.setEsfCaliber(String.valueOf(caliber));
				gunUser.setEsfMeasures(measures);
				gunUser.setTypeId(typologyId);
				
				ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
				
				esfCane.setCode(freshman);
				esfCane.setIsFavoriteGun(favorite);
				esfCane.setCaneCaliber(caliber);
				esfCane.setMeasures(measures);
				esfCane.setTypeId(typologyId);
				
				ESFCaneLocalServiceUtil.updateESFCane(esfCane);
				
			}else{
				response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
						"/edit_esfShooter.jsp");
					
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				return;
			}
			
		}
		
		response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
				"/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(userId));
		
	}
	
	
	
	public void assignMember (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		
		long esfLiv0Id = ParamUtil.getLong(request, "esfLiv0Id");
		long esfLiv1Id = ParamUtil.getLong(request, "esfLiv1Id");
		long esfLiv2Id = ParamUtil.getLong(request, "esfLiv2Id");
		long esfLiv3Id = ParamUtil.getLong(request, "esfLiv3Id");
		
		ESFUserRole userRole = new ESFUserRoleImpl();
		userRole = ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
		int maxUser = userRole.getMaxUser();

		long esfOrganizationId = 0;
		Date date = new Date();
		
		if (esfLiv3Id != 0) {
			esfOrganizationId = esfLiv3Id;
		}
		else if (esfLiv2Id != 0) {
			esfOrganizationId = esfLiv2Id;
		}
		else if (esfLiv1Id != 0) {
			esfOrganizationId = esfLiv1Id;
		}
		else {
			esfOrganizationId = esfLiv0Id;
		}
		
		if(userRole.isIsBDO()){
			
			if(esfLiv3Id == 0){
				SessionErrors.add(request, "esfRole-reference-error");
				
				response.setRenderParameter("mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
					
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				return;
			}else{
				
				List<ESFUserESFUserRole> userRoleBDO =  ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(esfUserRoleId, esfLiv3Id);
				if ( userRoleBDO.size() >= maxUser){
					SessionErrors.add(request, "esfRole-MAx-User-reference-error");
					
					response.setRenderParameter("mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
						
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					return;
				}
			}
			
		}
		
		ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
				esfUserId, esfUserRoleId, esfOrganizationId, date);
		
		response.setRenderParameter("mvcPath", "/html/" + "esfshooter/" +
				"/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		
	}
	
	public void assignCard(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException {
		
		long esfCardId = ParamUtil.getLong(actionRequest, "esfCardId");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date modifyData = ParamUtil.getDate(actionRequest, "startDate", sdf);
		
		ESFEntityState newCardEntityState = new ESFEntityStateImpl();
		ESFCard card = new ESFCardImpl();
		card = ESFCardLocalServiceUtil.fetchESFCard(esfCardId);
		card.setEsfUserId(esfUserId);
		card.setModifiedDate(modifyData);
		ESFCardLocalServiceUtil.updateESFCard(card);
		
		newCardEntityState.setEsfEntityStateId(CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFEntityState"));
		newCardEntityState.setClassName("it.ethica.esf.model.ESFCard");
		newCardEntityState.setClassPK(esfCardId);
		newCardEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);
		newCardEntityState.setStartDate(modifyData);
		newCardEntityState.setEndDate(null);
		newCardEntityState.setCreateDate(modifyData);
		ESFEntityStateLocalServiceUtil.updateESFEntityState(newCardEntityState);
		
		SessionMessages.add(actionRequest, "card_Assigned");
		actionResponse.setRenderParameter("esfCardId", String.valueOf(esfCardId));
		actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		actionResponse.setRenderParameter("mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
	}
	
	
	public void removeCard(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException {
		
		long esfCardId = ParamUtil.getLong(actionRequest, "cardUserId");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		ESFCard card = new ESFCardImpl();
		ESFCard newCard = new ESFCardImpl();
		ESFEntityState estate = new ESFEntityStateImpl();
		List<ESFUserESFUserRole> uroles = new ArrayList<ESFUserESFUserRole>();
		boolean nationals = false;
		String codeAlfa="";
		long codeNum = 0;
		long esfOrganizationId = 0;
		String code_ = "";
		long groupId = 0;
		long companyId = 0;
		long userId = 0;
		String userName = "";
		Date data = new Date();
		long newCardId = CounterLocalServiceUtil.increment(ESFCard.class.getName());
		
		_log.debug("remove card cardUserId="+esfCardId);
		_log.debug("remove card esfUserId="+esfUserId);
		
		if(esfUserId > 0){
			uroles = ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByESFUserId_ED(esfUserId);
			nationals = ESFNationalLocalServiceUtil.isActiveESFNationals(esfUserId);
			if(uroles.size() > 0){
				actionResponse.setRenderParameter("mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
				actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				SessionErrors.add(actionRequest, "assigned_role");
				return ;
			}
			if(nationals){
				actionResponse.setRenderParameter("mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
				actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				SessionErrors.add(actionRequest, "is_national");
				return ;
			}
			
		}

		if(Validator.isNotNull(esfCardId)){
			card = ESFCardLocalServiceUtil.fetchESFCard(esfCardId);
			
			if(Validator.isNotNull(card)){
				
				codeAlfa = card.getCodeAlfa();
				codeNum = card.getCodeNum();
				esfOrganizationId = card.getEsfOrganizationId();
				code_ = card.getCode();
				groupId = card.getGroupId();
				companyId = card.getCompanyId();
				userId = card.getUserId();
				userName = card.getUserName();
			}
			
			try {
				estate = ESFEntityStateLocalServiceUtil.findAllESFEntityStateByClassName_ClassPK("it.ethica.esf.model.ESFCard", esfCardId);
				estate.setEndDate(data);
				ESFEntityStateLocalServiceUtil.updateESFEntityState(estate);
			} catch (Exception e) {
			}
			
			newCard.setEsfCardId(newCardId);
			newCard.setCodeAlfa(codeAlfa);
			newCard.setCodeNum(codeNum);
			newCard.setEsfOrganizationId(esfOrganizationId);
			newCard.setCode(code_);
			newCard.setGroupId(groupId);
			newCard.setCompanyId(companyId);
			newCard.setUserId(userId);
			newCard.setUserName(userName);
			
			ESFCardLocalServiceUtil.addESFCard(newCard);
			_log.debug("newCard"+newCard);
		}
		SessionMessages.add(actionRequest, "card_Removed");
		actionResponse.setRenderParameter("mvcPath", "/html/esfshooter/edit_esfShooter.jsp");
		actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
	}

	
	
	/**
	 * Imposta la lista degli incarichi per cui non e' terminato il mandato
	 * 
	 * @param request
	 * @param response
	 */
	public void getAssociatedEsfFederalRoles(RenderRequest request, RenderResponse response){
		long esfUserId = ParamUtil.getLong(request, "esfUserId", -1);
		int total = 0;
		int start = -1;
		int end = -1;
		List<ESFUserESFFederalRole> associations = new ArrayList<ESFUserESFFederalRole>();
		associations = ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUserActive(esfUserId, Boolean.FALSE);
		total = associations.size();
		request.setAttribute("esfUserId", esfUserId);
		request.setAttribute("associations", associations);
		request.setAttribute("assTotal", total);
	}

	
	
	
	/**
	 * Imposta sulla response la lista degli incarichi possibili
	 * se ci sono
	 * 
	 * se non ci sono imposta la lista vuota
	 * 
	 * @param request
	 * @param response
	 */
	public void getEsfFederalRoles(RenderRequest request, RenderResponse response){
		long esfUserId = ParamUtil.getLong(request, "esfUserId", -1);
		int total = 0;
		int start = -1;
		int end = -1;
		List<ESFFederalRole> federalRoles = new ArrayList<ESFFederalRole>();
		try {
			// Restituisci la lista degli Incarichi Federali possibili
			federalRoles = ESFFederalRoleLocalServiceUtil.getESFFederalRoles(start, end);
			total = ESFFederalRoleLocalServiceUtil.getESFFederalRolesCount();
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		}
		request.setAttribute("esfUserId", esfUserId);
		request.setAttribute("results", federalRoles);
		request.setAttribute("total", total);
	}
	
	public void associateEsfFederalRole(ActionRequest request, ActionResponse response){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long esfUserId = ParamUtil.getLong(request, "esfUserId", -1);
		long esfFederalRoleId = ParamUtil.getLong(request, "esfFederalRoleId", -1);
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		long esfSpecificId = ParamUtil.getLong(request, "esfSpecificId");
		String notes = ParamUtil.getString(request, "notes");
		long startDate = Calendar.getInstance().getTimeInMillis();
		if(esfUserId > 0 && esfFederalRoleId > 0){
			try {
				ESFFederalRoleLocalServiceUtil.associateEsfUser(esfUserId, esfFederalRoleId, startDate, esfSpecificId, notes);
			} catch (SystemException e) {
				_log.fatal(e.getMessage());
			}
		}
		_log.debug("SPECIFIC ID: "+esfSpecificId);
		_log.debug("NOTES: "+notes);
		response.setRenderParameter("mvcCommand", "getEsfFederalRoles");
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("mvcPath", mvcPath);
	}

	public void deAssociateEsfFederalRole(ActionRequest request, ActionResponse response){
		long esfUserId = ParamUtil.getLong(request, "esfUserId", -1);
		long esfFederalRoleId = ParamUtil.getLong(request, "esfFederalRoleId", -1);
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		if(esfUserId > 0 && esfFederalRoleId > 0){
			try {
				ESFFederalRoleLocalServiceUtil.deAssociateEsfUser(esfUserId, esfFederalRoleId);
			} catch (SystemException e) {
				_log.fatal(e.getMessage());
			}
		}
		response.setRenderParameter("mvcCommand", "getEsfFederalRoles");
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("mvcPath", mvcPath);
	}

	private static String calculateFiscalCode(String cognome, String nome, String sesso,
	Date data, String comune){
		
		List <ESFCity>comuni = new ArrayList<ESFCity>();
		_log.debug("comune: "+comune);
		try {
			comuni=ESFCityLocalServiceUtil.getESFCity(comune);
			if(comuni.isEmpty()){
				return("02");
			}
			
			else{
				
				return FiscalCodeCalculatorUtil.calcolaCf(cognome,nome,sesso,data,
					comuni.get(0).getWebsite());
			}
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return("01");
		}
		
	}
	private static Log _log = LogFactoryUtil.getLog(ESFShooterPortlet.class);
	
}
