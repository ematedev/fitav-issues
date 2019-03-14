
package com.ethica.esf.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.service.ESFArticleTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ESFArticleTypeManagerPortlet extends MVCPortlet {

	public void editESFArticleType(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");
		String area = ParamUtil.getString(request, "area");
		String description = ParamUtil.getString(request, "description");
		String department = ParamUtil.getString(request, "department");

		if (esfArticleTypeId > 0) {
			ESFArticleTypeLocalServiceUtil.updateESFArticleType(
				esfArticleTypeId, description, area, department);
		}
		else {
			ESFArticleTypeLocalServiceUtil.addESFArticleType(
				description, area, department);
		}
	}

	public void deleteESFArticleType(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");

		if (esfArticleTypeId > 0) {
			ESFArticleType esfArticleType =
				ESFArticleTypeLocalServiceUtil.getESFArticleType(esfArticleTypeId);

			if (Validator.isNull(esfArticleType)) {
				SessionErrors.add(request, "esfArticleReferenceError");
			}
			else {
				ESFArticleTypeLocalServiceUtil.deleteESFArticleType(esfArticleTypeId);
			}
		}
	}
}
