package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFFieldPortlet
 */
public class ESFFieldPortlet extends MVCPortlet {

	public void editESFField(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFField.class.getName(), request);

		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		String name = ParamUtil.getString(request, "name");
		long ownerOrganizationId = ParamUtil.getLong(request,
				"ownerOrganizationId");
		long esfAddressId = ParamUtil.getLong(request, "ownerOrganizationId");
		long esfSportTypeId[] = ParamUtil.getLongValues(request, 
				"esfSportTypeId");

		if(esfFieldId > 0) {

			ESFFieldLocalServiceUtil.updateESFField(serviceContext.getUserId(),
					esfFieldId, name, ownerOrganizationId, esfAddressId, 
					esfSportTypeId, serviceContext);
		}
		else {

			ESFFieldLocalServiceUtil.addESFField(serviceContext.getUserId(),
					name, ownerOrganizationId, esfAddressId, 
					esfSportTypeId, serviceContext);
		}
	}
	
	public void deleteESFField(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFField.class.getName(), request);

		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");

		if(esfFieldId > 0) {

			ESFFieldLocalServiceUtil.deleteESFField(esfFieldId, serviceContext);
		}
	}

}
