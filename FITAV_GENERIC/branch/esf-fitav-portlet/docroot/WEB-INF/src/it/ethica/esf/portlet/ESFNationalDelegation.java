
package it.ethica.esf.portlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFCaneImpl;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.model.impl.ESFNationalImpl;
import it.ethica.esf.model.impl.ESFUserRoleImpl;
import it.ethica.esf.portlet.utility.ShooterUtility;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;

/**
 * Portlet implementation class ESFNationalDelegation
 */
public class ESFNationalDelegation extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {
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
		HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		boolean isCatridge = ParamUtil.getBoolean(httpReq, "isCatridge", false);
		long esfGunTypeId = ParamUtil.getLong(httpReq, "esfGunTypeId", 0);
		
		String resourceID = resourceRequest.getResourceID();
		
		
		if(isCatridge && esfGunTypeId > 0){
			List<ESFCatridge> catridges = new ArrayList<ESFCatridge>();
			List<ESFCatridge> catridgesTypes = new ArrayList<ESFCatridge>();
			try {
				catridges = ESFCatridgeLocalServiceUtil.getESFCatridges();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
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
		else if (resourceID.equals("liv1") || resourceID.equals("liv2") ||
					resourceID.equals("liv3")) {
				try {
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
				catch (IOException ioe) {
					throw ioe;
				}
				catch (PortletException pe) {
					throw pe;
				}
				catch (Exception e) {
					throw new PortletException(e);
				}
			}else if(!isCatridge){
				ShooterUtility su = new ShooterUtility();
				su.init(this.getPortletConfig());
				su.serveResource(resourceRequest, resourceResponse);
			}else if (resourceID.equals("fiscalCode")) {
				try{
					JSONObject fiscalcode = serveFiscalCode(resourceRequest,resourceResponse);
					resourceResponse.getWriter().print(fiscalcode);
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
				
			}

	}

	public void editESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFGun(request, response, "esfnationaldelegation");

	}
	


	public void deleteESFGun(ActionRequest request, ActionResponse response)
				throws PortalException, SystemException {

				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
				String esfUserId=ParamUtil.getString(request, "esfUserId");

				//String mvc=ParamUtil.getString(request, "mvcPath");
				long esfGunId = ParamUtil.getLong(request, "esfGunId");
				long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
				if (esfgunUserId > 0) {
					ESFgunUser esFgunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
					ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
				}
				response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			
	}
	
	
	public void removeRole(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, ParseException {
		
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			
			String mvcPath = ParamUtil.getString(request, "mvcPath");
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
			long esforgId = ParamUtil.getLong(request, "esforgId");
			String esfstartDate = ParamUtil.getString(request,  "esfstartDate");
			
			//esfstartDate = esfstartDate.substring(0, (esfstartDate.length()-2));
			
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
			response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
						
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		
	}
	
	
	public void editESFGunType(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					boolean found = false;
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
	
	public void editESFGunKind(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
		String esfUserId=ParamUtil.getString(request, "esfUserId");
		String mvc=ParamUtil.getString(request, "mvcPath");
		boolean found = false;
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		long esfGunTypeId = ParamUtil.getLong(request, "gunTypeId");
		String description = ParamUtil.getString(request, "description");
		String model = ParamUtil.getString(request, "model");
		long caliber = ParamUtil.getLong(request, "caliber");
		String esfGunId=ParamUtil.getString(request, "esfGunId");
		String modifyMode=ParamUtil.getString(request, "modifyMode");
		String measures = ParamUtil.getString(request, "measures");
		long typologyId = ParamUtil.getLong(request, "typology");
		
		String name = ParamUtil.getString(request, "name");
		String from =ParamUtil.getString(request, "from");
		String esfCaneId=ParamUtil.getString(request, "esfCaneId");
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
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
	long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	long catridgeModel = ParamUtil.getLong(request, "catridgeModel");
	long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
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
		"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
	response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

	response.setRenderParameter("op", "updAddr");
	
}

	public void editESFCane(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {

		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			// long organizationId = ParamUtil.getLong(request, "organizationId");
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
			long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
			long esfOrganizationId =
				ParamUtil.getLong(request, "esfOrganizationId");
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long caneCaliber =  ParamUtil.getLong(request, "caliber");
			int typeId= ParamUtil.getInteger(request, "typology") ;
			String measures=ParamUtil.getString(request, "measures");
			boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
			String code=ParamUtil.getString(request, "code");
			long shooterId = ParamUtil.getLong(request, "userId");
			String noteShooter=ParamUtil.getString(request, "noteShooter");
			long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
			long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
			

			int type = ESFKeys.ESFGunType.CANE;
			String shooter_note = ParamUtil.getString(request, "shooter_note");
			
			ESFGunKind kind = new ESFGunKindImpl();
			List<ESFgunUser> codeGuns = new ArrayList<ESFgunUser>();
			
			
		
			codeGuns = ESFgunUserLocalServiceUtil.findbyCode(code);
			
			if(codeGuns.size() > 0){
				SessionErrors.add(request, "duplicate_code");
				response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
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
				"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

			response.setRenderParameter("op", "updAddr");
	}	

	
	public void deleteESFCatridge(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
					if (esfCatridgeId > 0) {

						ESFCatridgeLocalServiceUtil.deleteESFCatridge(esfCatridgeId, serviceContext);
					}
					response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
					
				
	}
	
	public void deleteESFCane(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
					
					if (esfCaneId > 0) {

						ESFCaneLocalServiceUtil.deleteESFCane(esfCaneId, serviceContext);
					}
					response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
					
				
	}
	
	public void editESFdocument(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException,
		PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFdocument(request, response, "esfnationaldelegation");

	}

	public void updateESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException,
		PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.updateESFShooter(
			actionRequest, actionResponse, "esfnationaldelegation");

	}

	public void deleteESFNational(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		String userID = ParamUtil.getString(request, "esfNationalId");

		Calendar now = CalendarFactoryUtil.getCalendar();

		ESFNational user =
			ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));

		user.setEndDate(now.getTime());

		ESFNationalLocalServiceUtil.updateESFNational(user);

	}

	public void actionModifyNational2(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {
		String userID = ParamUtil.getString(request, "esfNationalID");
		String esfSportTypeId = ParamUtil.getString(request, "sportType");
		//boolean isNational = ParamUtil.getBoolean(request, "isNational");
		String isNational = request.getParameter("isNational");
		String isUniversity = ParamUtil.getString(request, "isUniversity");
		ESFNational user = ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));
		user.setEsfSportTypeId(Long.parseLong(esfSportTypeId));
		
		if(isNational.equals("isNational"))
		{
		user.setIsNational(true);
		}
		else
		{
			user.setIsNational(false);
		}
		
		user.setIsUniversity(Boolean.parseBoolean(isUniversity));
		ESFNationalLocalServiceUtil.updateESFNational(user);

	}

	public void actionModifyNational(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		String userID = ParamUtil.getString(request, "esfNationalID");
		// String esfSportTypeId=ParamUtil.getString(request, "sportType");
		String dateEnd = ParamUtil.getString(request, "endDate");
		String dateStart = ParamUtil.getString(request, "startDate");
		ESFNational user =
			ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));
		Calendar now = CalendarFactoryUtil.getCalendar();
		Calendar nowStart = CalendarFactoryUtil.getCalendar();
		String[] dateArray = dateEnd.split("/");
		String[] dateArrayStart = dateStart.split("/");
		now.set(
			Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1,
			Integer.parseInt(dateArray[0]));
		nowStart.set(Integer.parseInt(dateArrayStart[2]), Integer.parseInt(dateArrayStart[1]) - 1,
				Integer.parseInt(dateArrayStart[0]));
		if (user.getStartDate().after(now.getTime())) {
			SessionErrors.add(request, "insert-date-error-message"); 
			return;
		}
		else {
			// user.setEsfSportTypeId(Long.parseLong(esfSportTypeId));
			user.setEndDate(now.getTime());
			user.setStartDate(nowStart.getTime());
			ESFNationalLocalServiceUtil.updateESFNational(user);
		}
		
	}

	public void actionShooterToNational(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		int yearJsp = Integer.parseInt(ParamUtil.getString(request, "yearDelegation"));
		Calendar now = CalendarFactoryUtil.getCalendar();
		int year = now.get(Calendar.YEAR);
		Date startDate = null;
		Date endDate = null;
		
		if (year == yearJsp) {
			startDate = now.getTime();
			now.set(now.get(Calendar.YEAR), 11, 31);
			endDate = now.getTime();
		}
		else {
			now.set(yearJsp, 0, 1);
			startDate = now.getTime();
			now.set(yearJsp, 11, 31);
			endDate = now.getTime();

		}

		String sportType = ParamUtil.getString(request, "sportType");
		String isNational = ParamUtil.getString(request, "isNational");
		String isUniversity = ParamUtil.getString(request, "isUniversity");
		String userId = ParamUtil.getString(request, "esfUserID");

		ESFUser user = ESFUserLocalServiceUtil.getESFUser(Long.parseLong(userId));
		long count = CounterLocalServiceUtil.increment(ESFNational.class.toString());
		
		List<ESFNational> esfListNational =
			ESFNationalLocalServiceUtil.getESFNationals(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		now = CalendarFactoryUtil.getCalendar();
		
		boolean flag = true;
		
		for (ESFNational nat : esfListNational) {
			if (nat.getEsfUserId() == user.getEsfUserId() && nat.getEndDate().after(now.getTime()) &&
					nat.getEsfSportTypeId() == Long.parseLong(sportType)) {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			ESFNational esfNational =
				ESFNationalLocalServiceUtil.createESFNational(count);
			esfNational.setEsfUserId(user.getEsfUserId());
			esfNational.setUserId(user.getEsfUserId());
			esfNational.setCompanyId(user.getCompanyId());
			esfNational.setEsfSportTypeId(Long.parseLong(sportType));
			esfNational.setGroupId(user.getGroupId());
			esfNational.setUserName(user.getLastName() + " " +
				user.getFirstName());
			esfNational.setStartDate(startDate);
			esfNational.setEndDate(endDate);
			esfNational.setIsNational(Boolean.parseBoolean(isNational));
			esfNational.setIsUniversity(Boolean.parseBoolean(isUniversity));
			ESFNationalLocalServiceUtil.addESFNational(esfNational);
		}
		else {

			ESFNational userNational = new ESFNationalImpl();
			List<ESFNational> userNationalSportType =
					ESFNationalLocalServiceUtil.getActiveESFNationals(Long.parseLong(sportType),
							com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
							com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			
			for(ESFNational nat : userNationalSportType){
				if(nat.getUserId() == user.getEsfUserId()){
					userNational = nat;
					break;
				}
			}
			
			userNational.setEsfSportTypeId(Long.parseLong(sportType));
			userNational.setEndDate(endDate);
			userNational.setIsNational(Boolean.parseBoolean(isNational));
			userNational.setIsUniversity(Boolean.parseBoolean(isUniversity));
			ESFNationalLocalServiceUtil.updateESFNational(userNational);

		}

	}
	
	public void changeCard(ActionRequest request, ActionResponse response) throws SystemException,
	PortletException, PortalException, ParseException
	{
		
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFCard(request, response,"esfnationaldelegation");
	}
	
	public void updateExNational(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, ParseException
	{
		 ServiceContext serviceContext =
				   ServiceContextFactory .getInstance(ESFNational.class.getName(), actionRequest);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar start = Calendar.getInstance();
		int actualYear = start.get(Calendar.YEAR);
		String end = "31/12/"+actualYear;
		
		Date startD = start.getTime();
		Date endD = sdf.parse(end);
		
	
		long typeSportId = ParamUtil.getLong(actionRequest, "typeSportId");
		boolean[] chooses = ParamUtil.getBooleanValues(actionRequest, "choose");
		long[] esfUserIds =
			ParamUtil.getLongValues(actionRequest, "esfUserIds");
		for(int i = 0; i<chooses.length;i++)
		{
			if(chooses[i])
			{
				
				ESFNationalLocalServiceUtil.addESFNational
				(esfUserIds[i], esfUserIds[i], typeSportId, startD, endD, null,serviceContext);
			}
		}
	}
	
	public void actionModifyNationalDelibeDelibDate(ActionRequest request, ActionResponse response) 
			throws NumberFormatException, PortalException, SystemException
	{
		String userID = ParamUtil.getString(request, "esfNationalID");
		// String esfSportTypeId=ParamUtil.getString(request, "sportType");
		String deliberate = ParamUtil.getString(request, "deliberate");
		String delibDate = ParamUtil.getString(request, "delibDate");
		ESFNational user =
			ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));
		Calendar now = CalendarFactoryUtil.getCalendar();
		String[] dateArray = delibDate.split("/");
		
		now.set(
			Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1,
			Integer.parseInt(dateArray[0]));
		
			// user.setEsfSportTypeId(Long.parseLong(esfSportTypeId));
			user.setDeliberateDate(now.getTime());
			user.setDeliberate(deliberate);
			ESFNationalLocalServiceUtil.updateESFNational(user);
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
			
		response.setRenderParameter("esfUserId", String.valueOf(shooterId));
		
		response.setRenderParameter(
				"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
		
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
			// TODO: handle exception
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
				response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				return;
			}
		}
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			
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
			// TODO: handle exception
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
				response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				return;
			}
			
		}
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(userId));
		
	}
	
	public void assignMember (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		ESFUserRole userRole = new ESFUserRoleImpl();
		userRole = ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
		int maxUser = userRole.getMaxUser();
		
		long esfLiv0Id = ParamUtil.getLong(request, "esfLiv0Id");
		long esfLiv1Id = ParamUtil.getLong(request, "esfLiv1Id");
		long esfLiv2Id = ParamUtil.getLong(request, "esfLiv2Id");
		long esfLiv3Id = ParamUtil.getLong(request, "esfLiv3Id");

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
				
				response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
				
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				return;
			}else{
				
				List<ESFUserESFUserRole> userRoleBDO =  ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(esfUserRoleId, esfLiv3Id);
				if ( userRoleBDO.size() >= maxUser){
					SessionErrors.add(request, "esfRole-MAx-User-reference-error");
					
					response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					return;
				}
			}
			
		}
		
		ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
				esfUserId, esfUserRoleId, esfOrganizationId, date);
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		
	}
	
	public void deleteESFDelegation (ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, PortletException {

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfNationalId = ParamUtil.getLong(request, "esfNationalId");
		
		List<ESFMatch> matchs = ESFMatchLocalServiceUtil.findUnfinishedMatch_UserId(esfUserId);

		if(matchs.size() > 0){
			SessionErrors.add(request, "esfDelgation-reference-error");
			response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
		}else{
			ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(esfNationalId);
		}
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/view.jsp");

	}
	
	public JSONObject serveFiscalCode(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		
		JSONObject jsonFiscalCode = JSONFactoryUtil.createJSONObject();
		
		String result = "ko";
		String fiscalCode = "01";
		
		String lastName =
				ParamUtil.getString(resourceRequest,"lastName");
		String firstName =
				ParamUtil.getString(resourceRequest,"firstName");
		String birthcity =
				ParamUtil.getString(resourceRequest,"birthcity");
		Boolean male =
				ParamUtil.getBoolean(resourceRequest,"male");
		String birthday =
				ParamUtil.getString(resourceRequest,"birthday");
		String sex = "f";
		if (male){
			
			sex = "m";
			
		}
		
		String url = "http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?Nome="+firstName+"&Cognome="+lastName+"&ComuneNascita="
					+birthcity+"&DataNascita="+birthday+"&Sesso="+sex;
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		URLConnection connection = new URL(url).openConnection();
		
		con.setRequestMethod("GET");
		
		try {
			int responseCode = con.getResponseCode();
		} catch (Exception e) {
			fiscalCode = "02";
			jsonFiscalCode.put("result", result);
			jsonFiscalCode.put("fiscalCode", fiscalCode);
			
			return jsonFiscalCode;
		}
		
		int responseCode = con.getResponseCode();
		
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
	}

	private Log _log = LogFactoryUtil.getLog(ESFNationalDelegation.class);
}
