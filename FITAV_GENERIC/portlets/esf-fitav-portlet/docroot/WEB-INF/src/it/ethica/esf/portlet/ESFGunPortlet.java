
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.model.impl.ESFgunUserImpl;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFGunLocalServiceImpl;
import it.ethica.esf.util.ESFKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFGunPortlet
 */
public class ESFGunPortlet extends MVCPortlet {
	
	


	public void editESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
		ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
		String code = ParamUtil.getString(request, "code");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String registrationNumber =
			ParamUtil.getString(request, "registrationNumber");
		long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		String note=ParamUtil.getString(request, "note");
		String description=ParamUtil.getString(request, "description");
		long caliber=ParamUtil.getLong(request, "caliber");
		int typologyId=ParamUtil.getInteger(request, "typology");
		String measures=ParamUtil.getString(request, "measures");
		String name=ParamUtil.getString(request, "name");
		String model=ParamUtil.getString(request, "model");
		
	/*	if (esfGunId > 0) {
			ESFGun esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

			if (ESFGunLocalServiceUtil.checkCode(code, serviceContext) != null &&
				!esfGun.getCode().equals(code)) {
				SessionErrors.add(request, "esfGun-reference-error");
			}
			else {
			
				ESFGunLocalServiceUtil.updateESFGun(
					serviceContext.getUserId(), esfGunId, code, esfGunKindId,
					esfOrganizationId, esfUserId, registrationNumber,
				 catridgeCaliber,typology,measures,
					isFavoriteGun,note, name, serviceContext);
			
			}
		}
		else {
			if (ESFGunLocalServiceUtil.checkCode(code, serviceContext) != null) {
				SessionErrors.add(request, "esfGun-reference-error");
			}
			else {
				ESFGunLocalServiceUtil.addESFGun(
					serviceContext.getUserId(), code, esfGunKindId,
					esfOrganizationId, esfUserId, registrationNumber,
					 catridgeCaliber, typology,measures,
					isFavoriteGun,note, name, serviceContext);
			}
		}*/
		
		if(esfGunId > 0){
			
			ESFGunKindLocalServiceUtil.updateESFGunKind(serviceContext.getUserId(), esfGunId, 
					name, description, esfGunTypeId, serviceContext);
			
		}else{
			ESFGunKindLocalServiceUtil.addESFGunKind(
				serviceContext.getUserId(), name, description,
				esfGunTypeId, serviceContext);
		}
		
		
		
		
		
		
		
		response.setRenderParameter("mvcPath", "/html/" + "esfgun/" +
						"/view.jsp");
	}

	public void deleteESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		String mvcPath=ParamUtil.getString(request, "mvcPath");
		boolean checked = false; 
		
		/*
		List<ESFCane> canes = new ArrayList<ESFCane>();
		List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
		
		canes = ESFCaneLocalServiceUtil.getESFCanes();
		for(ESFCane cane : canes){
			if(esfGunId == cane.getEsfGunKindId()){
				checked = true;
				break;
			}
		}
		gunUser = ESFgunUserLocalServiceUtil.findbyESFGunId(esfGunId);
		
		if ((esfGunId > 0) && gunUser.size()==0 && !checked) {

			ESFGunLocalServiceUtil.deleteESFGun(esfGunId, serviceContext);
		}else{
			SessionErrors.add(request, "gun-assigned");
		}*/
		
		List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
		List<ESFCane> canes = new ArrayList<ESFCane>();
		
		gunUser = ESFgunUserLocalServiceUtil.findbyESFGunId(esfGunId);
		canes = ESFCaneLocalServiceUtil.getCanebyK(esfGunId);
		
		
		
		if ((esfGunId > 0) && gunUser.size() == 0 && canes.size() == 0) {

			ESFGunKindLocalServiceUtil.deleteESFGunKind(esfGunId, serviceContext);
		}else{
			SessionErrors.add(request, "gun-assigned");
		}
		
		
		response.setRenderParameter("mvcPath", mvcPath);
	}

	
	public void deleteESFGunUser(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		String mvcPath=ParamUtil.getString(request, "mvcPath");
		long esfGunId = ParamUtil.getLong(request, "esfGunId");

		ESFgunUser esFgunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);

		if(Validator.isNotNull(esFgunUser)){
		ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
		}else{
			SessionErrors.add(request, "esfGun-reference-error");
		}
		response.setRenderParameter("esfGunId", String.valueOf(esfGunId));
		response.setRenderParameter("mvcPath", mvcPath);
	}
	
	public void deleteESFGunUserCane(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		String mvcPath=ParamUtil.getString(request, "mvcPath");
		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
		
		int type = ESFKeys.ESFGunType.CANE;
		
		ESFCane cane = ESFCaneLocalServiceUtil.fetchESFCane(esfCaneId);
		List<ESFgunUser> esFgunUsers = new ArrayList<ESFgunUser>();
		ESFgunUser esFgunUser = new ESFgunUserImpl();
		
		esFgunUsers = ESFgunUserLocalServiceUtil.findbyESFGunId_Type(esfCaneId, type);
		
		if(Validator.isNotNull(esFgunUsers) && esFgunUsers.size()==1){
			esFgunUser = esFgunUsers.get(0);
		}
		
		if(Validator.isNotNull(cane) && Validator.isNotNull(esFgunUser)){
		ESFCaneLocalServiceUtil.deleteESFCane(cane)	;
		ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
		}else{
			SessionErrors.add(request, "esfGun-reference-error");
		}
		response.setRenderParameter("esfGunId", String.valueOf(esfGunId));
		response.setRenderParameter("mvcPath", mvcPath);
	}
	
	public void assigUser(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
			
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFgunUser.class.getName(), request);
			long esfGunId = ParamUtil.getLong(request, "esfGunId");
			String mvcPath=ParamUtil.getString(request, "mvcPath");
			int type = ParamUtil.getInteger(request, "type");
			long shooterId = ParamUtil.getLong(request, "shooterId");
			String code =ParamUtil.getString(request, "freshman");
			String note =ParamUtil.getString(request, "note");
			boolean isFavorite = ParamUtil.getBoolean(request, "isfavoritegun");
			List<String>codes = new ArrayList<String>();
			long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
			String measures =ParamUtil.getString(request, "measures");
			long caliber = ParamUtil.getLong(request, "caliber");
			int typeId = ParamUtil.getInteger(request, "typology");

			int gunUserCount = ESFgunUserLocalServiceUtil.getESFgunUsersCount();
			List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil.getESFgunUsers(0, gunUserCount);
			
			for(ESFgunUser gunUser :gunUsers){
				codes.add(gunUser.getCode().toUpperCase());
			}
			
			if((Validator.isNotNull(codes) && codes.size()==0) || ESFKeys.ESFGunType.CATRIDGE == type ){
				ESFgunUserLocalServiceUtil.addESFGunUser(esfGunId, shooterId, code, isFavorite,
						type, note, esfGunTypeId, esfGunId, typeId, measures, caliber,serviceContext);
				mvcPath = mvcPath+"/view.jsp";
			}
			else if(Validator.isNotNull(codes) && codes.size()>0 && !codes.contains(code.toUpperCase())){
				ESFgunUserLocalServiceUtil.addESFGunUser(esfGunId, shooterId, code, isFavorite,
						type, note, esfGunTypeId, esfGunId, typeId, measures, caliber, serviceContext);
				mvcPath = mvcPath+"/view.jsp";
				
			}else{
				mvcPath = mvcPath+"/assignUser.jsp";
				SessionErrors.add(request, "duplicate_code");
				response.setRenderParameter("esfGunId", String.valueOf(esfGunId));
				response.setRenderParameter("type", String.valueOf(type));
			}
		
			response.setRenderParameter("mvcPath", mvcPath);
		}
	
	
	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		HttpServletRequest httpReq =
			PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);

		long esfGunTypeId = ParamUtil.getLong(httpReq, "esfGunTypeId", 0);
		int type = ParamUtil.getInteger(httpReq, "type",0);
		long esfGunKindId = ParamUtil.getLong(httpReq, "esfGunKindId", 0);
		
		JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		if(1 == type){
			if (esfGunTypeId > 0) {
	
				List<ESFGunKind> esfGunKinds = new ArrayList<ESFGunKind>();
	
				try {
					esfGunKinds =
						ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(esfGunTypeId);
				}
				catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				

				for (ESFGunKind esfGunKind : esfGunKinds) {
					
					JSONObject esfGunKindIdName =
							JSONFactoryUtil.createJSONObject();
					esfGunKindIdName.put(
						"esfGunKindId", esfGunKind.getEsfGunKindId());
					esfGunKindIdName.put("name", esfGunKind.getName());
	
					resultJSONArr.put(esfGunKindIdName);
				}
	
				resultJSONObj.put("esfGunKinds", resultJSONArr);
	
				resourceResponse.getWriter().write(resultJSONObj.toString());
			}
		} else if(2 == type){
			if (esfGunKindId > 0) {
				
				List<ESFGun> esfGuns = new ArrayList<ESFGun>();
	
				try {
					esfGuns =
						ESFGunLocalServiceUtil.getESFGuns();
				}
				catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				
				for (ESFGun esfGun : esfGuns) {
					if(esfGun.getEsfGunKindId() == esfGunKindId){
	
						JSONObject esfGunIdName =
							JSONFactoryUtil.createJSONObject();
		
						esfGunIdName.put(
							"esfGunId", esfGun.getEsfGunId());
						esfGunIdName.put("name", esfGun.getName());
		
						resultJSONArr.put(esfGunIdName);
					}
				}
	
				resultJSONObj.put("esfGuns", resultJSONArr);
	
				resourceResponse.getWriter().write(resultJSONObj.toString());
			}
			
		}
	}


	public void editESFGunType(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					boolean found = false;
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
					String modifyMode=ParamUtil.getString(request, "modifyMode");
					long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
					String name = ParamUtil.getString(request, "name");
					String description = ParamUtil.getString(request, "description");
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
					
					response.setRenderParameter("esfUserId", esfUserId);
					response.setRenderParameter("pathBack",mvc);
					response.setRenderParameter("mvcPath",mvc);
					response.setRenderParameter("modifyMode",modifyMode);
				}
	
	public void editESFGunKind(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, Exception {
		
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					boolean found = false;
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

					long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
					long esfGunTypeId = ParamUtil.getLong(request, "gunTypeId");
					String description = ParamUtil.getString(request, "description");
					String model = ParamUtil.getString(request, "model");
					String name = ParamUtil.getString(request, "name");
					String esfGunId=ParamUtil.getString(request, "esfGunId");
					String from =ParamUtil.getString(request, "from");
					String modifyMode=ParamUtil.getString(request, "modifyMode");
					String esfCaneId=ParamUtil.getString(request, "esfCaneId");
					
					if (esfGunKindId > 0) {
					/*	ESFGunKind esfGunKind =
							ESFGunKindLocalServiceUtil.getESFGunKind(esfGunKindId);

						if (ESFGunKindLocalServiceUtil.checkNome(model, serviceContext) != null &&
							!esfGunKind.getName().equals(model)) {
							SessionErrors.add(request, "esfGunKind-reference-error");
						}
						else {*/
							ESFGunKindLocalServiceUtil.updateESFGunKind(
								serviceContext.getUserId(), esfGunKindId, name,
								description, esfGunTypeId,serviceContext);
						//}
					}
					else {
						/*if (ESFGunKindLocalServiceUtil.checkNome(model, serviceContext) != null) {
							SessionErrors.add(request, "esfGunKind-reference-error");
						}
						else {*/
							ESFGunKindLocalServiceUtil.addESFGunKind(
								serviceContext.getUserId(), name, description,
								esfGunTypeId, serviceContext);
						//}
					}
					
					response.setRenderParameter("pathBack",mvc);
					response.setRenderParameter("esfUserId", esfUserId);
					response.setRenderParameter("mvcPath",mvc);
					
				/*	if (from.equals("cane")){
						response.setRenderParameter("esfCaneId", esfCaneId);
					}else {
						response.setRenderParameter("esfGunId", esfGunId);
					}
					response.setRenderParameter("modifyMode", modifyMode);*/
	}


	public void editESFCatridge(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

		// long organizationId = ParamUtil.getLong(request, "organizationId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String catridgeModel = ParamUtil.getString(request, "catridgeModel");
		long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		String note=ParamUtil.getString(request, "note");
		if (esfCatridgeId > 0) {
			ESFCatridge esfCatridge = ESFCatridgeLocalServiceUtil.getESFCatridge(esfCatridgeId);

			
				ESFCatridgeLocalServiceUtil.updateESFCatridge(
					serviceContext.getUserId(), esfCatridgeId, esfGunTypeId,
					 esfUserId,  catridgeModel, catridgeCaliber,note, serviceContext);

		}
		else {
				try{
				ESFCatridgeLocalServiceUtil.addESFCatridge(
					serviceContext.getUserId(), esfGunTypeId,
					 esfUserId, catridgeModel, catridgeCaliber,note, serviceContext);
				} catch (Exception e){
					System.out.println(e.toString());
				}
		}

		
		response.setRenderParameter("mvcPath", "/html/" + "esfgun/" +
						"/view.jsp");
		

	}
	
	public void editESFCane(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
					// long organizationId = ParamUtil.getLong(request, "organizationId");
					String mvcPath=ParamUtil.getString(request, "mvcPath");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
					long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
					long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
					long esfUserId = ParamUtil.getLong(request, "esfUserId");
					long caneCaliber = ParamUtil.getLong(request, "caneCaliber");
					int typology =ParamUtil.getInteger(request, "typology");
					String measures =ParamUtil.getString(request, "measures");
					boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
					String code =ParamUtil.getString(request, "code");
					long shooterId = ParamUtil.getLong(request, "shooterId");
					List<String>codes = new ArrayList<String>();
					int type = ParamUtil.getInteger(request, "type");
					String shooter_note = ParamUtil.getString(request, "shooter_note");
					long esfGunId = ParamUtil.getLong(request, "esfGunId");
					long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
					long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
					
					int gunUserCount = ESFgunUserLocalServiceUtil.getESFgunUsersCount();
					List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil.getESFgunUsers(0, gunUserCount);
					
					if (esfCaneId > 0) {
						ESFCane esfCane = ESFCaneLocalServiceUtil.getESFCane(esfCaneId);
						
							ESFCaneLocalServiceUtil.updateESFCane(
								serviceContext.getUserId(), esfCaneId, esfGunKindId, esfGunTypeId,
							    esfUserId,code, caneCaliber, typology, 
								measures,isFavoriteGun, shooterId, shooter_note, esfGunUserId, serviceContext);
							
							mvcPath = mvcPath+"/view.jsp";
					}
					else {
						for(ESFgunUser gunUser :gunUsers){
							codes.add(gunUser.getCode().toUpperCase());
						}
						
						if(Validator.isNotNull(codes) && codes.size()==0){
							ESFCaneLocalServiceUtil.addESFCane(
									serviceContext.getUserId(), esfGunKindId, esfGunTypeId,
								    esfUserId, esfOrganizationId, code, caneCaliber, typology, 
									measures, isFavoriteGun, shooterId, shooter_note, serviceContext);
							
							mvcPath = mvcPath+"/view.jsp";
						}
						else if(Validator.isNotNull(codes) && codes.size()>0 && !codes.contains(code.toUpperCase())){
							ESFCaneLocalServiceUtil.addESFCane(
									serviceContext.getUserId(), esfGunKindId, esfGunTypeId,
								    esfUserId, esfOrganizationId, code, caneCaliber, typology, 
									measures, isFavoriteGun, shooterId, shooter_note, serviceContext);
							
							mvcPath = mvcPath+"/view.jsp";
							
						}else{
							mvcPath = mvcPath+"/edit_esfCane.jsp";
							SessionErrors.add(request, "duplicate_code");
							response.setRenderParameter("esfGunKindId", String.valueOf(esfGunKindId));
							response.setRenderParameter("type", String.valueOf(type));
						}
						
					}
					
					response.setRenderParameter("mvcPath", mvcPath);
				}
	
	public void deleteESFCatridge(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
				
					long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
					String mvcPath=ParamUtil.getString(request, "mvcPath");
					if (esfCatridgeId > 0) {

						ESFCatridgeLocalServiceUtil.deleteESFCatridge(esfCatridgeId, serviceContext);
					}
					
					response.setRenderParameter("mvcPath", mvcPath);
				
	}
	
	public void deleteESFCane(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					
					long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
					
					if (esfCaneId > 0) {

						ESFCaneLocalServiceUtil.deleteESFCane(esfCaneId, serviceContext);
					}
					String mvcPath=ParamUtil.getString(request, "mvcPath");
					
				
	}
	
	public void deleteESFGunType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

			long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");

			int referencedESFGunKind =
				ESFGunKindLocalServiceUtil.getESFGunKindCountByESFGunType(esfGunTypeId);

			if (esfGunTypeId > 0) {

				if (referencedESFGunKind == 0) {

					ESFGunTypeLocalServiceUtil.deleteESFGunType(
						esfGunTypeId, serviceContext);
				}
				else {
					SessionErrors.add(request, "esfGunType-reference-error");
				}
			}
			response.setRenderParameter("mvcPath", "/html/esfgun/esfguncategorization/view.jsp");
			
		}
	
	public void deleteESFGunKind(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

			long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
			long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
			int referencedESFGun =
				ESFGunLocalServiceUtil.getESFGunsByESFGunKindCount(esfGunKindId);

			if (esfGunKindId > 0) {

				if (referencedESFGun == 0) {

					ESFGunKindLocalServiceUtil.deleteESFGunKind(
						esfGunKindId, serviceContext);
				}
				else {
					SessionErrors.add(request, "esfGunKind-reference-error");
				}
			}
			response.setRenderParameter("mvcPath", "/html/esfgun/esfguncategorization/view_esfGunKind.jsp");
			response.setRenderParameter("esfGunTypeId", String.valueOf(esfGunTypeId));
		}
	
	private static Log _log = LogFactoryUtil.getLog(ESFGunPortlet.class);
	
}
