
package it.ethica.esf.portlet;

import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFMatchType
 */
public class ESFDescriptionPortlet extends MVCPortlet {

	public void editESFdescription(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMatchTypePortlet.class.getName(), request);

		long esfDescriptionId = ParamUtil.getLong(request, "esfDescriptionId");
		String name = ParamUtil.getString(request, "name");
		boolean isNational = ParamUtil.getBoolean(request, "isNational");

		if (esfDescriptionId > 0) {
			ESFDescriptionLocalServiceUtil.updateEsfDescription(
				esfDescriptionId, name, isNational, serviceContext);
		}
		else {
			ESFDescriptionLocalServiceUtil.addEsfDescription(
				name, isNational, serviceContext);
		}
	}

	public void deleteESFDescrition(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfDescriptionId = ParamUtil.getLong(request, "esfDescriptionId");

		ESFDescriptionLocalServiceUtil.deleteESFDescription(esfDescriptionId);

	}

}
