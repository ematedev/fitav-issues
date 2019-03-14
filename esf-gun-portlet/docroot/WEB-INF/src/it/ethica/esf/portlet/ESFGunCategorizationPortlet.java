package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFGun;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFGunCategorizationPortlet
 */
public class ESFGunCategorizationPortlet extends MVCPortlet {

	public void editESFGunType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFGun.class.getName(), request);

		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");

		if(esfGunTypeId > 0) {

			ESFGunTypeLocalServiceUtil.updateESFGunType(
					serviceContext.getUserId(), esfGunTypeId, name, description,
					serviceContext);
		}
		else {

			ESFGunTypeLocalServiceUtil.addESFGunType(serviceContext.getUserId(),
					name, description, serviceContext);
		}
	}
	
	public void deleteESFGunType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFGun.class.getName(), request);

		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		
		int referencedESFGunKind = ESFGunKindLocalServiceUtil
				.getESFGunKindCountByESFGunType(esfGunTypeId);

		if(esfGunTypeId > 0) {

			if (referencedESFGunKind == 0) {

				ESFGunTypeLocalServiceUtil.deleteESFGunType(esfGunTypeId,
						serviceContext);
			}
			else {
				SessionErrors.add(request, "esfGunType-reference-error");
			}
		}
	}
	
	public void editESFGunKind(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFGun.class.getName(), request);

		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");

		if(esfGunKindId > 0) {

			ESFGunKindLocalServiceUtil.updateESFGunKind(
					serviceContext.getUserId(), esfGunKindId, name, description,
					esfGunTypeId, serviceContext);
		}
		else {

			ESFGunKindLocalServiceUtil.addESFGunKind(serviceContext.getUserId(),
					name, description, esfGunTypeId, serviceContext);
		}
	}
	
	public void deleteESFGunKind(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFGun.class.getName(), request);

		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");

		int referencedESFGun = ESFGunLocalServiceUtil
				.getESFGunsByESFGunKindCount(esfGunKindId);

		if (esfGunKindId > 0) {

			if (referencedESFGun == 0) {

				ESFGunKindLocalServiceUtil.deleteESFGunKind(esfGunKindId,
						serviceContext);
			}
			else {
				SessionErrors.add(request, "esfGunKind-reference-error");
			}
		}
	}

}
