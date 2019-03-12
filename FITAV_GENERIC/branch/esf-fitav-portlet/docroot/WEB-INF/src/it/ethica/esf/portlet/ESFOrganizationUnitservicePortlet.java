
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFOrganizationUnitservice;
import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;

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
 * Portlet implementation class ESFOrganizationUnitservicePortlet
 */
public class ESFOrganizationUnitservicePortlet extends MVCPortlet {

	public void editESFOrganizationUnitservice(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUnitservice.class.getName(), request);
		long esfOrganizationUnitServiceId =
			ParamUtil.getLong(request, "esfOrganizationUnitserviceId");
		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
		long esfUnitserviceId = ParamUtil.getLong(request, "esfUnitserviceId");
		long numberUnitservices =
			ParamUtil.getLong(request, "numberUnitservices");
		String description = ParamUtil.getString(request, "description");

		if (numberUnitservices < 0) {
			SessionErrors.add(
				request, "esfOrganizationUnitservice-reference-error");
		}
		else {
			if (esfOrganizationUnitServiceId > 0) {
				ESFOrganizationUnitserviceLocalServiceUtil.updateESFOrganizationUnitservice(
					serviceContext.getUserId(), esfOrganizationUnitServiceId,
					esfOrganizationId, esfUnitserviceId, numberUnitservices,description,
					serviceContext);
			}
			else {
				ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(
					serviceContext.getUserId(), esfOrganizationId,
					esfUnitserviceId, numberUnitservices, description,serviceContext);
			}
		}
	}

	public void deleteESFOrganizationUnitservice(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFOrganizationUnitservice.class.getName(), request);
		long esfOrganizationUnitserviceId =
			ParamUtil.getLong(request, "esfOrganizationUnitserviceId");

		if (esfOrganizationUnitserviceId > 0) {
			ESFOrganizationUnitserviceLocalServiceUtil.deleteESFOrganizationUnitservice(
				esfOrganizationUnitserviceId, serviceContext);
		}
		else {
			SessionErrors.add(
				request, "esfOrganizationUnitservice-reference-error");
		}
	}
}
