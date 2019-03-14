package it.ethica.esf.admin.portlet;

import it.ethica.esf.service.ESFCategoryLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ESFCategoryAdminPortlet extends MVCPortlet {

	public void deleteESFCategory(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long esfCategoryId = ParamUtil.getLong(actionRequest, "esfCategoryId");

		ESFCategoryLocalServiceUtil.deleteESFCategory(esfCategoryId);
	}
	
	public void updateESFCategory(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long esfCategoryId = ParamUtil.getLong(actionRequest, "esfCategoryId");

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		if (Validator.isNull(esfCategoryId) || esfCategoryId < 0) {
			ESFCategoryLocalServiceUtil.addESFCategory(name, description);
		}
		else {
			ESFCategoryLocalServiceUtil.updateESFCategory(
				esfCategoryId, name, description);
		}
	}
}
