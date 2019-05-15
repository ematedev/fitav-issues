
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;

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
 * Portlet implementation class ESFServicePortlet
 */
public class ESFUnitservicePortlet extends MVCPortlet {

	public void editESFUnitservice(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		boolean found = false;
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUnitservice.class.getName(), request);
		long esfUnitServiceId = ParamUtil.getLong(request, "esfUnitserviceId");
		String description = ParamUtil.getString(request, "description");

		for (ESFUnitservice esfUnitservice : ESFUnitserviceLocalServiceUtil.getAllESFUnitservices()) {
			if (esfUnitservice.getDescription().equals(description)) {
				SessionErrors.add(request, "esfUnitservice-reference-error");
				found = true;
				break;
			}
		}

		if (!found) {
			if (esfUnitServiceId > 0) {
				ESFUnitserviceLocalServiceUtil.updateESFUnitservice(
					serviceContext.getUserId(), esfUnitServiceId, description,
					serviceContext);
			}
			else {
				ESFUnitserviceLocalServiceUtil.addESFUnitservice(
					serviceContext.getUserId(), description, serviceContext);
			}
		}
	}

	public void deleteESFUnitservice(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUnitservice.class.getName(), request);
		long esfUnitserviceId = ParamUtil.getLong(request, "esfUnitserviceId");

		if (ESFOrganizationUnitserviceLocalServiceUtil.findByESFUnitserviceId(
			esfUnitserviceId).size() > 0) {
			SessionErrors.add(request, "esfUnitservice-reference-error");
		}
		else {
			if (esfUnitserviceId > 0) {
				ESFUnitserviceLocalServiceUtil.deleteESFUnitservice(
					esfUnitserviceId, serviceContext);
			}
			else {
				SessionErrors.add(request, "esfUnitservice-reference-error");
			}
		}
	}
}
