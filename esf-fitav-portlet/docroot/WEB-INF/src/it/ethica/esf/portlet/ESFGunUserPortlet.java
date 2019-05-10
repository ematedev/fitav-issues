
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFGunImpl;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFGunUserPortlet
 */
public class ESFGunUserPortlet extends MVCPortlet {

	public void editESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException { 

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		String code = ParamUtil.getString(request, "code");
		//long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		//long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
	//	long esfOrganizationId =
		//	ParamUtil.getLong(request, "esfOrganizationId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		//String registrationNumber =
		//	ParamUtil.getString(request, "registrationNumber");
		//String canesExtra = ParamUtil.getString(request, "canesExtra");
		//String catridgeName = ParamUtil.getString(request, "catridgeName");
		//String catridgeModel = ParamUtil.getString(request, "catridgeModel");
		//long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		String note=ParamUtil.getString(request, "note");
	//	int typology=ParamUtil.getInteger(request, "typology");
		//String measures=ParamUtil.getString(request, "measures");
		//String name = ParamUtil.getString(request, "name");
		long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
		//List<ESFGun> guns = new ArrayList<ESFGun>();
		//guns = ESFGunLocalServiceUtil.getESFGunByLikeC_K(code, esfGunKindId);
		
		ESFgunUser gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
		List<ESFgunUser> gunCodes = ESFgunUserLocalServiceUtil.findbyCode(code);
		
		if(Validator.isNotNull(gunCodes) && gunCodes.size()>0 && gunUser.getEsfGunId()!=esfGunId ){
			SessionErrors.add(request, "duplicate_code");
		}else{
			
			int type = gunUser.getType();
			gunUser.setCode(code);
			gunUser.setNote(note);
			gunUser.setIsFavorite(isFavoriteGun);
			
			if(esfGunId!=gunUser.getEsfGunId()){
				gunUser.setEsfGunId(esfGunId);
			}
			
			ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
			
		}

		
		response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
						"/view.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
	}

	public void editESFNewGun(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		String note = ParamUtil.getString(request, "note");
		String noteShooter = ParamUtil.getString(request, "noteShooter");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		int typology=ParamUtil.getInteger(request, "typology");
		String name = ParamUtil.getString(request, "name");
		String code = ParamUtil.getString(request, "code");
		String codeGun = "";
		long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		String measures=ParamUtil.getString(request, "measures");
		int esfOrganizationId = 0;
		String registrationNumber = "";
		boolean find = false;
		int totGun = 0;
		totGun = ESFGunLocalServiceUtil.getESFGunsCount();
		_log.debug("esfGunKindId="+esfGunKindId);
		List<ESFGun> guns = new ArrayList<ESFGun>();
		guns = ESFGunLocalServiceUtil.getESFGuns(0, totGun);
		
		if(Validator.isNotNull(guns) && guns.size()>0){
			for(ESFGun gun : guns){
				if(gun.getEsfGunKindId() == esfGunKindId && gun.getTypeId() == typology && 
						gun.getName().toUpperCase().equals(name.toUpperCase())){
					find = true;
				}
			}
		}
		
		if(!find){
			ESFGunLocalServiceUtil.addESFGun(
					serviceContext.getUserId(), codeGun, esfGunKindId,
					esfOrganizationId, esfUserId, registrationNumber,
					 catridgeCaliber, typology,measures,
					false,note, name, serviceContext);
			int newtotGun = 0;
			newtotGun = ESFGunLocalServiceUtil.getESFGunsCount();
			List<ESFGun> newguns = new ArrayList<ESFGun>();
			newguns = ESFGunLocalServiceUtil.getESFGuns(0, totGun);
			Long newGunId = 0L;
			if(Validator.isNotNull(newguns) && newguns.size()>0){
				for(ESFGun gun : newguns){
					
					if(gun.getEsfGunKindId() == esfGunKindId && gun.getTypeId() == typology && 
							gun.getName().toUpperCase().equals(name.toUpperCase())){
						newGunId = gun.getEsfGunId();
					}
				}
			}
			
			if(newGunId > 0){
			ESFgunUser gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
			List<ESFgunUser> gunCodes = ESFgunUserLocalServiceUtil.findbyCode(code);
			
				if(Validator.isNotNull(gunCodes) && gunCodes.size()>0  ){
					SessionErrors.add(request, "duplicate_code");
				}else{
					int type = gunUser.getType();
					gunUser.setCode(code);
					gunUser.setNote(noteShooter);
					gunUser.setIsFavorite(isFavoriteGun);
					gunUser.setEsfGunId(newGunId);
	
					
					ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
					
				}
			}else{
				SessionErrors.add(request, "error_rifles");
			}
			
		}else{
			SessionErrors.add(request, "duplicate_rifles");
		}
		
		response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
				"/view.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		
		
		
		
	}
	
	
	public void deleteESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {
		

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		String mvcPath=ParamUtil.getString(request, "mvcPath");

		if (esfGunId > 0) {

			ESFgunUserLocalServiceUtil.deleteESFgunUser(esfGunId);
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
		
		boolean isCatridge = ParamUtil.getBoolean(httpReq, "isCatridge", false);
		
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
			
		}else if (esfGunTypeId > 0) {

			List<ESFGunKind> esfGunKinds = new ArrayList<ESFGunKind>();

			try {
				esfGunKinds =
					ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(esfGunTypeId);
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

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
		long caliber = ParamUtil.getLong(request, "caliber");
		String esfGunId=ParamUtil.getString(request, "esfGunId");
		String from =ParamUtil.getString(request, "from");
		String modifyMode=ParamUtil.getString(request, "modifyMode");
		String esfCaneId=ParamUtil.getString(request, "esfCaneId");
		String measures = ParamUtil.getString(request, "measures");
		long typologyId = ParamUtil.getLong(request, "typology");
		if (esfGunKindId > 0) {
		/*	ESFGunKind esfGunKind =
				ESFGunKindLocalServiceUtil.getESFGunKind(esfGunKindId);

			if (ESFGunKindLocalServiceUtil.checkNome(model, serviceContext) != null &&
				!esfGunKind.getName().equals(model)) {
				SessionErrors.add(request, "esfGunKind-reference-error");
			}
			else {*/
			/*	ESFGunKindLocalServiceUtil.updateESFGunKind(
					serviceContext.getUserId(), esfGunKindId, name,
					description, model, caliber, esfGunTypeId, measures,
					typologyId, serviceContext);*/
			//}
		}
		else {
			/*if (ESFGunKindLocalServiceUtil.checkNome(model, serviceContext) != null) {
				SessionErrors.add(request, "esfGunKind-reference-error");
			}
			else {*/
			/*	ESFGunKindLocalServiceUtil.addESFGunKind(
					serviceContext.getUserId(), name, description, model,
					caliber, esfGunTypeId, measures,
					typologyId, serviceContext);*/
			//}
		}
		response.setRenderParameter("esfGunTypeId",String.valueOf(esfGunTypeId) );
		response.setRenderParameter("pathBack",mvc);
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
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
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String catridgeModel = ParamUtil.getString(request, "catridgeModel");
		long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		String note=ParamUtil.getString(request, "note");
		
		long shooteId = ParamUtil.getLong(request, "shooterId");
		long gunId = ParamUtil.getLong(request, "catridgeModel");
		int type = ESFKeys.ESFGunType.CATRIDGE;
		String code = "";
		boolean isFavoriteGun = false;
		
		if(gunId > 0 && shooteId > 0){
		/*	ESFgunUserLocalServiceUtil.addESFGunUser(gunId, shooteId,
					code, isFavoriteGun, type, note, serviceContext);*/
		}else{
			SessionErrors.add(request, "Catridge-reference-error");
		}

		
		response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
						"/view.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		

	}
	
	public void editESFCane(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {

		
		ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
					// long organizationId = ParamUtil.getLong(request, "organizationId");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
					long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
					long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
					long esfUserId = ParamUtil.getLong(request, "esfUserId");
					long caneCaliber = 0;
					long typology= 0;
					String measures= "";
					boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
					String code=ParamUtil.getString(request, "code");
					long shooterId = ParamUtil.getLong(request, "shooterId");
					long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
					String shooter_note = ParamUtil.getString(request, "shooter_note");
					int type = ESFKeys.ESFGunType.CANE;
					
					ESFGunKind kind = new ESFGunKindImpl();
					List<ESFgunUser> codeGuns = new ArrayList<ESFgunUser>();
					
					
					if(esfGunKindId > 0 && 
							Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGunKindId))){
						kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGunKindId);
						
					}else{
						SessionErrors.add(request, "esfGunKindId-reference-error");
						response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
								"/view.jsp");
						return;
					}
					
					
				/*	if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getEsfMeasures()) && Validator.isNotNull(kind.getEsfTypeId())
							 && Validator.isNotNull(kind.getCaliber())){
						caneCaliber = kind.getCaliber();
						typology = kind.getEsfTypeId();
						measures = kind.getEsfMeasures();
						
					}*/
					
					
					codeGuns = ESFgunUserLocalServiceUtil.findbyCode(code);
					
					if(codeGuns.size() > 0){
						SessionErrors.add(request, "duplicate_code");
						response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
								"/view.jsp");
						return ; 
					}else{
						
					/*	ESFCaneLocalServiceUtil.addESFCane(
							serviceContext.getUserId(), esfGunKindId,
							esfUserId, esfOrganizationId, code, caneCaliber,(int)  typology, 
							measures, isFavoriteGun, shooterId, shooter_note, serviceContext);*/
		
					
					}	
					response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
									"/view.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

				}
	
	public void assignESFGun (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFgunUser.class.getName(), request);
		
		long shooterId = ParamUtil.getLong(request, "shooterId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		
		int type =ESFKeys.ESFGunType.RIFLE;
		
		String mvcPath ="/html/esfgunuser/view.jsp";
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "code");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		
		List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		
		if(gunUsers.size() == 0){
		/*	ESFgunUserLocalServiceUtil.addESFGunUser(esfGunKindId, shooterId, freshman, isFavoriteGun,
					type, shooter_note,serviceContext);*/
		}else{
			SessionErrors.add(request, "duplicate_code");
		}
		response.setRenderParameter("mvcPath", mvcPath);
	}
	
	public void alterESFRifle (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		boolean favotire = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "esfGunType-reference-error");
		}
	
		if(Validator.isNotNull(gunUser)){
			
			gunUser.setCode(freshman);
			gunUser.setNote(shooter_note);
			gunUser.setIsFavorite(favotire);
			
			ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
			
		}else{
			response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
					"/view.jsp");
			return;
		}
		
		
		
	}
	
	public void alterESFCane (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");

		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		boolean favotire = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "esfGunType-reference-error");
		}
	
		if(Validator.isNotNull(gunUser)){
			
			gunUser.setCode(freshman);
			gunUser.setNote(shooter_note);
			gunUser.setIsFavorite(favotire);
			
			ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
			
		}else{
			response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
					"/view.jsp");
			return;
		}
		
		response.setRenderParameter("mvcPath", "/html/" + "esfgunuser/" +
				"/view.jsp");
		
	}
	
	public void deleteESFCatridge(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
					long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
					String mvcPath=ParamUtil.getString(request, "mvcPath");
					if (esfgunUserId > 0) {

						ESFgunUserLocalServiceUtil.deleteESFgunUser(esfgunUserId);
					}
					
					response.setRenderParameter("mvcPath", mvcPath);
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				
	}
	
	public void deleteESFCane(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvcPath=ParamUtil.getString(request, "mvcPath");
					long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
					long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
					
					if ((esfCaneId > 0) && (esfgunUserId>0)) {

						ESFCaneLocalServiceUtil.deleteESFCane(esfCaneId, serviceContext);
						ESFgunUserLocalServiceUtil.deleteESFgunUser(esfgunUserId);
					}
					response.setRenderParameter("mvcPath", mvcPath);
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					
				
	}
	private static Log _log = LogFactoryUtil.getLog(ESFGunUserPortlet.class);
}
