package com.ethica.esf.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.service.ESFArticleLocalServiceUtil;
import com.ethica.esf.service.ESFArticleTypeLocalServiceUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class ESFArticleTypeManagerPortlet
 */
public class ESFArticleTypeManagerPortlet extends MVCPortlet {

	public void editESFArticleType(ActionRequest request,
			ActionResponse response) throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFArticleType.class.getName(), request);
		long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");
		String area = ParamUtil.getString(request, "area");
		String description = ParamUtil.getString(request, "description");
		String department = ParamUtil.getString(request, "department");

		if (esfArticleTypeId > 0) {
			ESFArticleType esfArticleType = ESFArticleTypeLocalServiceUtil
					.getESFArticleType(esfArticleTypeId);

			if (ESFArticleTypeLocalServiceUtil.checkDescription(description,
					serviceContext) != null
					&& !esfArticleType.getDescription().equals(description)) {
				SessionErrors.add(request, "esfArticleTypeDescriptionError");
				response.setRenderParameter("mvcPath",
						"/html/esfarticletypemanager/"
								+ "edit_esfArticleType.jsp");
				response.setRenderParameter("esfArticleTypeId",
						String.valueOf(esfArticleTypeId));
			} else {
				ESFArticleTypeLocalServiceUtil.updateESFArticleType(
						esfArticleTypeId, description, area, department,
						serviceContext);
			}
		} else {
			if (ESFArticleTypeLocalServiceUtil.checkDescription(description,
					serviceContext) != null) {
				SessionErrors.add(request, "esfArticleTypeDescriptionError");
				response.setRenderParameter("mvcPath",
						"/html/esfarticletypemanager/"
								+ "edit_esfArticleType.jsp");
				response.setRenderParameter("area", area);
				response.setRenderParameter("department", department);
				response.setRenderParameter("description", description);
			} else {
				ESFArticleTypeLocalServiceUtil.addESFArticleType(description,
						area, department, serviceContext);
			}
		}
	}

	public void deleteESFArticleType(ActionRequest request,
			ActionResponse response) throws PortalException, SystemException {

		long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");

		if (esfArticleTypeId > 0) {
			List<ESFArticle> esfArticles = ESFArticleLocalServiceUtil
					.getESFArticleByArticleTypeId(esfArticleTypeId);

			if (esfArticles.size() > 0) {
				SessionErrors.add(request, "esfArticleReferenceError");
			} else {
				ESFArticleTypeLocalServiceUtil
						.deleteESFArticleType(esfArticleTypeId);
			}
		}
	}

}