package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFFederalRole;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFFederalRole;
import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.ESFFederalRoleServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFFederalRolePortlet
 */
public class ESFFederalRolePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		List<ESFFederalRole> federalRoles = new ArrayList<ESFFederalRole>();
		long federalRoleId = ParamUtil.getLong(renderRequest, "esfFederalRoleId", -1);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType");
		String sortingOrder = orderByType;

		if (orderByType.equals("desc")) {
			orderByType = "asc";
		} else {
			orderByType = "desc";
		}

		if (Validator.isNull(orderByType)) {
			orderByType = "desc";
		}
		ESFFederalRole federalRole = null;
		int start = -1;
		int end = -1;
		int total = 0;
		try {
			federalRoles = ESFFederalRoleLocalServiceUtil.getESFFederalRoles(start, end);
			total = ESFFederalRoleLocalServiceUtil.getESFFederalRolesCount();
			if(federalRoleId > 0){
				federalRole = ESFFederalRoleLocalServiceUtil.fetchESFFederalRole(federalRoleId);
			}
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		}
		if(federalRole != null){
			renderRequest.setAttribute("esfFederalRole", federalRole);
		}
		renderRequest.setAttribute("results", federalRoles);
		renderRequest.setAttribute("total", total);
		renderRequest.setAttribute("orderByCol", orderByCol);
		renderRequest.setAttribute("orderByType", orderByType);
		super.doView(renderRequest, renderResponse);
	}
 

	public void updateEsfFederalRole(ActionRequest request, ActionResponse response){
		_log.info("Inside updateEsfFederalRole action");
		long esfFederalRoleId = ParamUtil.getLong(request, "esfFederalRoleId", -1);
		String code = ParamUtil.getString(request, "code", null);
		String description = ParamUtil.getString(request, "description", null);
		boolean regional = ParamUtil.getBoolean(request, "regional", Boolean.FALSE);
		boolean provincial = ParamUtil.getBoolean(request, "provincial", Boolean.FALSE);
		ESFFederalRole federalRole = null;
		String errorKey = null;
		if(Validator.isNotNull(code) && Validator.isNotNull(description)){
			try {
				federalRole = ESFFederalRoleServiceUtil.updateEsfFederalRole(esfFederalRoleId, code, description, regional, provincial);
			} catch (SystemException e) {
				errorKey = "update-esf-federal-role-failure";
				_log.fatal(e.getMessage());
			} catch (PrincipalException e) {
				errorKey = "update-esf-federal-role-permission-error";
				_log.error(e.getMessage());
			}
		}
		if(federalRole !=null){
			SessionMessages.add(request, "update-esf-federal-role-success");
		}else{
			SessionErrors.add(request, errorKey);
		}
	}
	
	public void deleteEsfFederalRole(ActionRequest request, ActionResponse response){
		_log.info("Inside deleteEsfFederalRole action");
		long esfFederalRoleId = ParamUtil.getLong(request, "esfFederalRoleId", -1);
		ESFFederalRole federalRole = null;
		String errorKey = null;
		if(esfFederalRoleId > 0){
			List<ESFUser> associations = new ArrayList<ESFUser>();
			try {
				associations = ESFFederalRoleLocalServiceUtil.findByESFFederalRole(esfFederalRoleId);
				if(associations.size() == 0 ){
					try {
						federalRole = ESFFederalRoleLocalServiceUtil.deleteESFFederalRole(esfFederalRoleId);
						SessionMessages.add(request, "delete-esf-federal-role-success");
					} catch (SystemException e) {
						errorKey = "delete-esf-federal-role-failure";
						SessionErrors.add(request, errorKey);
						_log.fatal(e.getMessage());
					} catch (PrincipalException e) {
						errorKey = "delete-esf-federal-role-permission-error";
						SessionErrors.add(request, errorKey);
						_log.error(e.getMessage());
					} catch (PortalException e) {
						errorKey = "delete-esf-federal-role-failure";
						SessionErrors.add(request, errorKey);
						_log.error(e.getMessage());
					}
				}
			} catch (PortalException e1) {
				_log.warn(e1.getMessage());
			} catch (SystemException e1) {
				_log.warn(e1.getMessage());
			}
		}
	}

	Log _log = LogFactoryUtil.getLog(ESFFederalRolePortlet.class.getName());
}
