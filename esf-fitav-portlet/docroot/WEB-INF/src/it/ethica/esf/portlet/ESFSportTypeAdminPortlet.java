package it.ethica.esf.portlet;

import java.util.List;

import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFSportTypeAdminPortlet
 */
public class ESFSportTypeAdminPortlet extends MVCPortlet {
	
	public void editESFSportType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFSportType.class.getName(), request);

		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");
		String name = ParamUtil.getString(request, "name");
		String code = ParamUtil.getString(request, "code");
		String description = ParamUtil.getString(request,
				"description");
		boolean national = ParamUtil.getBoolean(request, "national");
		boolean isChangeCategory = ParamUtil.getBoolean(request, "isChangeCategory");
		boolean isOlimpic = ParamUtil.getBoolean(request, "isOlimpic");
		
		
		if (esfSportTypeId > 0) {
			ESFSportTypeLocalServiceUtil.updateESFSportType(serviceContext.getUserId(),
					esfSportTypeId, name, code, description, national, isChangeCategory, isOlimpic,
					serviceContext);
		}
		else {
			ESFSportTypeLocalServiceUtil.addESFSportType(serviceContext.getUserId(),
					name, code, description, national, isChangeCategory, isOlimpic, serviceContext);
		}
	}
	
	public void deleteESFSportType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFSportType.class.getName(), request);

		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");

		int referencedESFField = ESFFieldLocalServiceUtil
				.findByESFSportTypeId(esfSportTypeId).size();

		if (esfSportTypeId > 0) {

			if (referencedESFField == 0) {

				ESFSportTypeLocalServiceUtil.deleteESFSportType(esfSportTypeId,
						serviceContext);
			}
			else {
				SessionErrors.add(request, "esfSportRype-reference-error");
			}
		}
	}
	private static Log _log = LogFactoryUtil.getLog(ESFSportTypeAdminPortlet.class);
}
