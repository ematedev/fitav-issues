package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFShooterCategory;
import it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil;

import java.text.ParseException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFShooterCategoryPortlet
 */
public class ESFShooterCategoryPortlet extends MVCPortlet {

	public void editESFShooterCategory(ActionRequest request,
			ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFShooterCategory.class.getName(), request);

		long esfShooterCategoryId = ParamUtil.getLong(request,
				"esfShooterCategoryId");
		String name = ParamUtil.getString(request, "name");
		String code = ParamUtil.getString(request, "code");
		String description = ParamUtil.getString(request, "description");
		if (esfShooterCategoryId > 0) {

			ESFShooterCategoryLocalServiceUtil.updateESFShooterCategory(
					esfShooterCategoryId, name, description, code, serviceContext);
		}
		else {

			ESFShooterCategoryLocalServiceUtil.addESFShooterCategory(
					serviceContext.getUserId(), name, description, code, serviceContext);
		}
	}

	public void deleteESFShooterCategory(ActionRequest request,
			ActionResponse response)
		throws PortalException, SystemException {

		long esfShooterCategoryId = ParamUtil.getLong(request,
				"esfShooterCategoryId");

		ESFShooterCategoryLocalServiceUtil
				.deleteESFShooterCategory(esfShooterCategoryId);
	}

}
