
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFState;
import it.ethica.esf.service.ESFStateLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFConfigurationStatePortlet
 */
public class ESFConfigurationStatePortlet extends MVCPortlet {

	public void addESFState(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		try {
			if (ESFStateLocalServiceUtil.checkName(name) != null) {

				SessionErrors.add(actionRequest, "state-name-message");
			}
			else {

				ESFStateLocalServiceUtil.addState(name, description);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateESFState(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		try {
			ESFState esfState =
				ESFStateLocalServiceUtil.getESFState(esfStateId);

			if (ESFStateLocalServiceUtil.checkName(name) != null &&
				!esfState.getName().equals(name)) {

				SessionErrors.add(actionRequest, "state-name-message");
			}
			else {

				ESFStateLocalServiceUtil.updateState(
					esfStateId, name, description);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteESFState(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");

		try {
			if (ESFStateLocalServiceUtil.isStateAssEntity(esfStateId)) {

				SessionErrors.add(actionRequest, "state-assigned-message");
			}
			else {

				ESFStateLocalServiceUtil.deleteESFState(esfStateId);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateESFStateAssEntity(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		boolean[] chooses = ParamUtil.getBooleanValues(actionRequest, "choose");
		long[] classNameIds =
			ParamUtil.getLongValues(actionRequest, "classNameIds");

		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");
		String type = ParamUtil.getString(actionRequest, "type");
		try {
			for (int i = 0; i < classNameIds.length; i++) {

				if (type.equals("NA") && chooses[i]) {

					ESFStateLocalServiceUtil.addESFStateAssEntity(
						esfStateId, classNameIds[i]);
				}
				else if (type.equals("A") && chooses[i]) {

					ESFStateLocalServiceUtil.deleteESFStateAssEntity(
						esfStateId, classNameIds[i]);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
