package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFShooterQualification;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFShooterQualificationPortlet
 */
public class ESFShooterQualificationPortlet extends MVCPortlet {

	public void editESFShooterQualification(ActionRequest request,
			ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFShooterQualification.class.getName(), request);

		long esfShooterQualificationId = ParamUtil.getLong(request,
				"esfShooterQualificationId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String code = ParamUtil.getString(request, "code");
		if (esfShooterQualificationId > 0) {

			ESFShooterQualificationLocalServiceUtil.updateESFShooterQualification(
					esfShooterQualificationId, name, description, code,  serviceContext);
		}
		else {

			ESFShooterQualificationLocalServiceUtil.addESFShooterQualification(
					serviceContext.getUserId(), name, description, code, serviceContext);
		}
	}

	public void deleteESFShooterQualification(ActionRequest request,
			ActionResponse response)
		throws PortalException, SystemException {

		long esfShooterQualificationId = ParamUtil.getLong(request,
				"esfShooterQualificationId");

		ESFShooterQualificationLocalServiceUtil
				.deleteESFShooterQualification(esfShooterQualificationId);
	}

}
