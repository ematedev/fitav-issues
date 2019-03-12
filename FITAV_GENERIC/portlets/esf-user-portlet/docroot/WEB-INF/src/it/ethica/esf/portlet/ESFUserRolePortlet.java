package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFUserRolePortlet
 */
public class ESFUserRolePortlet extends MVCPortlet {

	public void editESFUserRole(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFUserRole.class.getName(), request);

		long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request,
				"description");
		boolean isBDO = ParamUtil.getBoolean(request, "isBDO");
		boolean isLEA = ParamUtil.getBoolean(request, "isLEA");

		if (esfUserRoleId > 0) {

			ESFUserRoleLocalServiceUtil.updateESFUserRole(
					serviceContext.getUserId(), esfUserRoleId, name,
					description, isBDO, isLEA, serviceContext);
		}
		else {

			ESFUserRoleLocalServiceUtil.addESFUserRole(
					serviceContext.getUserId(), name, description, isBDO, isLEA,
					serviceContext);
		}
	}
	
	public void deleteESFUserRole(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFUserRole.class.getName(), request);

		long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");

		int referencedESFUser = ESFUserLocalServiceUtil
				.getESFUserCountByESFUserRole(esfUserRoleId);

		if (esfUserRoleId > 0) {

			if (referencedESFUser == 0) {
				
				ESFUserRoleLocalServiceUtil.deleteESFUserRole(esfUserRoleId,
						serviceContext);
			}
			else {

				SessionErrors.add(request, "esfUserRole-reference-error");
			}
		}
	}
}
