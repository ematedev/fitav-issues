
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFConfigurationPortlet
 */
public class ESFConfigurationPortlet extends MVCPortlet {

	public void editESFConfiguration(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFConfiguration.class.getName(), request);
		long esfConfigurationId =
			ParamUtil.getLong(request, "esfConfigurationId");
		String key = ParamUtil.getString(request, "key");
		String value = ParamUtil.getString(request, "value");

		if (esfConfigurationId > 0) {

			ESFConfigurationLocalServiceUtil.updateESFConfiguration(
				serviceContext.getUserId(), esfConfigurationId, value,
				serviceContext);
		}
		else {
			ESFConfigurationLocalServiceUtil.addESFConfiguration(
				serviceContext.getUserId(), key, value, serviceContext);
		}
	}

	public void deleteESFConfiguration(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFConfiguration.class.getName(), request);
		long esfConfigurationId =
			ParamUtil.getLong(request, "esfConfigurationId");

		if (esfConfigurationId > 0) {
			ESFConfigurationLocalServiceUtil.deleteESFConfiguration(
				esfConfigurationId, serviceContext);
		}
		else {
			SessionErrors.add(request, "esfConfiguration-reference-error");
		}
	}

}
