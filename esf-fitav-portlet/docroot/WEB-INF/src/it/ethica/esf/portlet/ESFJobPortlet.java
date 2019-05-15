
package it.ethica.esf.portlet;

import it.ethica.esf.service.ESFJobLocalServiceUtil;

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
public class ESFJobPortlet extends MVCPortlet {

	public void editESFjob(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMatchTypePortlet.class.getName(), request);

		long esfJobId = ParamUtil.getLong(request, "esfJobId");
		String name = ParamUtil.getString(request, "job");

		if (esfJobId > 0) {
			ESFJobLocalServiceUtil.updateEsfJob(
					serviceContext, esfJobId, name);
		}
		else {
			ESFJobLocalServiceUtil.addEsfJob(
					serviceContext, name );
		}
	}

	public void deleteESFJob(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfJobId = ParamUtil.getLong(request, "esfJobId");

		ESFJobLocalServiceUtil.deleteESFJob(esfJobId);

	}

}