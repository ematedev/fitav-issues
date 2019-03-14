
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFFornitureType;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil;
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
 * Portlet implementation class ESFFornitureTypeAdminPortlet
 */
public class ESFFornitureTypePortlet extends MVCPortlet {

	public void editESFFornitureType(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFFornitureType.class.getName(), request);
		long esfFornitureTypeId =
			ParamUtil.getLong(request, "esfFornitureTypeId");
		String description = ParamUtil.getString(request, "description");

		if (esfFornitureTypeId > 0) {

			ESFFornitureTypeLocalServiceUtil.updateESFFornitureType(
				serviceContext.getUserId(), esfFornitureTypeId, description,
				serviceContext);
		}
		else {
			ESFFornitureTypeLocalServiceUtil.addESFForntureType(
				serviceContext.getUserId(), description, serviceContext);
		}
	}

	public void deleteESFFornitureType(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFFornitureType.class.getName(), request);
		long esfFornitureTypeId =
			ParamUtil.getLong(request, "esfFornitureTypeId");

		if (ESFFornitureLocalServiceUtil.findAllESFFornituresByType(
			esfFornitureTypeId).size() > 0) {
			SessionErrors.add(request, "esfForniture-reference-error");
		}
		else {
			if (esfFornitureTypeId > 0) {
				ESFFornitureTypeLocalServiceUtil.deleteESFFornitureType(
					esfFornitureTypeId, serviceContext);
			}
			else {
				SessionErrors.add(request, "esfSportRype-reference-error");
			}
		}
	}
}
