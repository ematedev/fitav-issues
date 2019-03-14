
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFState;
import it.ethica.esf.service.ESFStateLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFStatePortlet
 */
public class ESFStatePortlet extends MVCPortlet {

	public void addESFState(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFState.class.getName(), actionRequest);

		String name = ParamUtil.getString(actionRequest, "esfName");
		String description = ParamUtil.getString(actionRequest, "esfDescription");

		try {
			ESFStateLocalServiceUtil.addESFState(
				serviceContext.getUserId(), name, description, serviceContext);
			SessionMessages.add(
				actionRequest, "addESFStateMess", "message-add-state");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

	public void updateESFState(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFState.class.getName(), actionRequest);

		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");
		String name = ParamUtil.getString(actionRequest, "esfName");
		String description = ParamUtil.getString(actionRequest, "esfDescription");

		try {
			ESFStateLocalServiceUtil.updateESFState(
				serviceContext.getUserId(), esfStateId, name,
				description, serviceContext);
			SessionMessages.add(actionRequest, "updateESFStateMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

	public void deleteESFState(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFState.class.getName(), actionRequest);

		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");

		try {
			ESFStateLocalServiceUtil.deleteESFState(esfStateId, serviceContext);
			SessionMessages.add(actionRequest, "deleteESFStateMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

}
