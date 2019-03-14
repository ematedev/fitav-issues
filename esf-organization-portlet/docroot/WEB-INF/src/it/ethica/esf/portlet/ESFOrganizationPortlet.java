
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.util.ESFOrganizationUtil;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ESFOrganizationPortlet extends MVCPortlet {

	public void editESFField(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFField.class.getName(), request);

		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		String name = ParamUtil.getString(request, "name");
		String street1 = ParamUtil.getString(request, "street1");
		String street2 = ParamUtil.getString(request, "street2");
		String street3 = ParamUtil.getString(request, "street3");
		String zip = ParamUtil.getString(request, "zip");
		double latitude = ParamUtil.getDouble(request, "latitude");
		double longitude = ParamUtil.getDouble(request, "longitude");

		long ownerOrganizationId =
			ParamUtil.getLong(request, "ownerOrganizationId");
		long esfSportTypeId[] =
			ParamUtil.getLongValues(request, "esfSportTypeId");

		ESFField esfField = null;

		if (esfFieldId > 0) {

			esfField =
				ESFFieldLocalServiceUtil.updateESFField(
					serviceContext.getUserId(), esfFieldId, name,
					ownerOrganizationId, 0, esfSportTypeId, serviceContext);
		}
		else {

			esfField =
				ESFFieldLocalServiceUtil.addESFField(
					serviceContext.getUserId(), name, ownerOrganizationId, 0,
					esfSportTypeId, serviceContext);
		}

		if (Validator.isNotNull(esfField)) {
			ESFAddressLocalServiceUtil.addESFAddress(
				serviceContext.getUserId(), longitude, "", "", "", "",
				latitude, ESFField.class.getName(), esfField.getEsfFieldId(),
				street1, street2, street3, zip, 12000, true, true,
				serviceContext);

		}
	}

	public void editESFOrganization(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFOrganizationPortlet.class.getName(), request);

		String name = ParamUtil.getString(request, "name");
		String code = ParamUtil.getString(request, "code");
		String vat = ParamUtil.getString(request, "vat");
		String fiscalCode = ParamUtil.getString(request, "fiscalCode");
		Date establishmentDate =
			ParamUtil.getDate(
				request, "establishmentDate",
				DateFormatFactoryUtil.getSimpleDateFormat("yyyy.MM.dd"), null);
		Date closureDate =
			ParamUtil.getDate(
				request, "closureDate",
				DateFormatFactoryUtil.getSimpleDateFormat("yyyy.MM.dd"), null);
		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");

		List<ESFAddress> esfAddresses =
			ESFOrganizationUtil.getESFAddresses(request);

		if (esfOrganizationId > 0) {
			_log.info("Updating Organization " + esfOrganizationId);

			ESFOrganizationLocalServiceUtil.updateESFOrganization(
				serviceContext.getUserId(), esfOrganizationId, name, code, vat,
				fiscalCode, establishmentDate, closureDate, esfAddresses,
				serviceContext);

			SessionMessages.add(request, "esfOrganizationUpdated");

			response.setRenderParameter(
				"esfOrganizationId", Long.toString(esfOrganizationId));
		}
		else {
			_log.info("Adding Organization");

			ESFOrganizationLocalServiceUtil.addESFOrganization(
				serviceContext.getUserId(), name, code, vat, fiscalCode,
				establishmentDate, closureDate, esfAddresses, serviceContext);

			SessionMessages.add(request, "esfOrganizationAdded");

			response.setRenderParameter(
				"esfOrganizationId", Long.toString(esfOrganizationId));
		}

	}

	public void deleteESFField(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");

		if (esfFieldId > 0) {

			ESFFieldLocalServiceUtil.deleteESFField(esfFieldId);
		}
	}

	public void deleteESFOrganization(
		ActionRequest request, ActionResponse response) {

		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");

		try {
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFOrganization.class.getName(), request);

			response.setRenderParameter(
				"esfOrganizationId", Long.toString(esfOrganizationId));

			ESFOrganizationLocalServiceUtil.deleteESFOrganization(
				esfOrganizationId, serviceContext);

			SessionMessages.add(request, "esf_organization_deleted");
		}
		catch (Exception e) {

			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private static Log _log =
		LogFactoryUtil.getLog(ESFOrganizationPortlet.class);
}
