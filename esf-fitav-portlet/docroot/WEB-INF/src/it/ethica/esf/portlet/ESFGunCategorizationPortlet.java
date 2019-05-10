
package it.ethica.esf.portlet;


import java.util.ArrayList;
import java.util.List;

import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.model.impl.ESFCatridgeImpl;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFGunCategorizationPortlet
 */
public class ESFGunCategorizationPortlet extends MVCPortlet {

	public void editESFGunType(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		boolean found = false;
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

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
	}

	public void editESFGunKind(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		boolean found = false;
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeSelect");
		boolean flagSearch	= ParamUtil.getBoolean(request,"flagSearch");
		
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String mvc = request.getParameter("mvcPath");
			
			if (esfGunKindId > 0) {
				ESFGunKind esfGunKind =
					ESFGunKindLocalServiceUtil.getESFGunKind(esfGunKindId);
	
				if (ESFGunKindLocalServiceUtil.checkNome(name, serviceContext) != null &&
					!esfGunKind.getName().equals(name)) {
					SessionErrors.add(request, "esfGunKind-reference-error");
				}
				else {
					ESFGunKindLocalServiceUtil.updateESFGunKind(
						serviceContext.getUserId(), esfGunKindId, name,
						description, esfGunTypeId, serviceContext);
				}
			}
			else {
				if (ESFGunKindLocalServiceUtil.checkNome(name, serviceContext) != null) {
					SessionErrors.add(request, "esfGunKind-reference-error");
				}
				else {
					if(esfGunTypeId>0){
					ESFGunKindLocalServiceUtil.addESFGunKind(
						serviceContext.getUserId(), name, description, esfGunTypeId, serviceContext);
					}
					else{
						SessionErrors.add(request, "esfGunKind-reference-error");
					}
				}
			}
		
		response.setRenderParameter("mvcPath", templatePath +
				"view_esfGunKind.jsp");

		response.setRenderParameter("esfGunTypeId", String.valueOf(esfGunTypeId));
		
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

		//	if (referencedESFGun == 0) {

				ESFGunKindLocalServiceUtil.deleteESFGunKind(
					esfGunKindId, serviceContext);
	/*		}
			else {
				SessionErrors.add(request, "esfGunKind-reference-error");
			}*/
		}
		response.setRenderParameter("mvcPath", templatePath +
				"view_esfGunKind.jsp");
		response.setRenderParameter("esfGunTypeId", String.valueOf(esfGunTypeId));
	}
	
	public void editESFGunCatridge(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGunCategorizationPortlet.class.getName(), request);
		
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeSelect");
		long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
		String name = ParamUtil.getString(request, "name");
		long caliber = ParamUtil.getLong(request, "caliber");
		String description = ParamUtil.getString(request, "description");
		
		if (esfCatridgeId > 0) {
			ESFCatridge esfCatridge = ESFCatridgeLocalServiceUtil.getESFCatridge(esfCatridgeId);

			
				ESFCatridgeLocalServiceUtil.updateESFCatridge(
					serviceContext.getUserId(), esfCatridgeId, esfGunTypeId,
					serviceContext.getUserId(),  name, caliber,description, serviceContext);

		}
		else {
				try{
				ESFCatridgeLocalServiceUtil.addESFCatridge(
					serviceContext.getUserId(), esfGunTypeId,
					serviceContext.getUserId(), name, caliber,description, serviceContext);
				} catch (Exception e){
					System.out.println(e.toString());
				}
		}
		response.setRenderParameter("mvcPath", templatePath +
				"view_esfGunCatridge.jsp");
		response.setRenderParameter("esfGunTypeId", String.valueOf(esfGunTypeId));
	}
	
	public void deleteESFGunCatridge(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		
		ESFCatridge catridge = new ESFCatridgeImpl();
		catridge = ESFCatridgeLocalServiceUtil.fetchESFCatridge(esfCatridgeId);
		
		if(Validator.isNotNull(catridge)){
			ESFCatridgeLocalServiceUtil.deleteESFCatridge(catridge);
		}
		
		response.setRenderParameter("mvcPath", templatePath +
				"view_esfGunCatridge.jsp");
		response.setRenderParameter("esfGunTypeId", String.valueOf(esfGunTypeId));
		
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(ESFGunCategorizationPortlet.class);
}
