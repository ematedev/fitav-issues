
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFTool;
import it.ethica.esf.service.ESFToolLocalServiceUtil;
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
 * Portlet implementation class ESFToolPortlet
 */
public class ESFToolPortlet extends MVCPortlet {

	public void addESFTool(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFTool.class.getName(), actionRequest);

		String code = ParamUtil.getString(actionRequest, "code");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String type = "1";

		try {
			ESFToolLocalServiceUtil.addESFTool(
				serviceContext.getUserId(), code, name, description, type,
				serviceContext);
			SessionMessages.add(actionRequest, "addESFToolMess", "message-add-tool");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
			actionResponse.setRenderParameter("mvcPath", "");
			e.printStackTrace();
		}
	}

	public void updateESFTool(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFTool.class.getName(), actionRequest);

		long esfToolId = ParamUtil.getLong(actionRequest, "esfToolId");
		String code = ParamUtil.getString(actionRequest, "code");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String type = "1";

		try {
			ESFToolLocalServiceUtil.updateESFTool(
				serviceContext.getUserId(), esfToolId, code, name, description,
				type, serviceContext);
			SessionMessages.add(actionRequest, "updateESFToolMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

	public void deleteESFTool(
		ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFTool.class.getName(), actionRequest);

		long esfToolId = ParamUtil.getLong(actionRequest, "esfToolId");

		try {
			ESFToolLocalServiceUtil.deleteESFTool(esfToolId, serviceContext);
			SessionMessages.add(actionRequest, "deleteESFToolMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}
}
