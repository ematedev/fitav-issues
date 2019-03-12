
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFDescription;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFMatchType
 */
public class ESFMatchTypePortlet extends MVCPortlet {

	public void editESFMatchType(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMatchTypePortlet.class.getName(), request);

		long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");
		String name = ParamUtil.getString(request, "name");
	//	long esfDescriptionId = ParamUtil.getLong(request, "description");
		boolean isCategoryQualification =
			ParamUtil.getBoolean(request, "isCategoryQualification");
		boolean isNational = ParamUtil.getBoolean(request, "isNational");
		
		if (esfMatchTypeId > 0) {

			ESFMatchTypeLocalServiceUtil.updateEsfMatchType(
				esfMatchTypeId, name, isCategoryQualification, isNational,
				 serviceContext);

		}
		else {

			ESFMatchTypeLocalServiceUtil.addEsfMatchType(
				name, isCategoryQualification, isNational,
				serviceContext);
		}

	}

	public void deleteESFMatchType(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");

		if (esfMatchTypeId > 0) {
			List<ESFMatch> matches =
				ESFMatchLocalServiceUtil.findbyMatchType(esfMatchTypeId);
			if (matches == null || matches.size()==0) {
				ESFMatchTypeLocalServiceUtil.deleteEsfMatchType(esfMatchTypeId);
			}
			else {
				SessionErrors.add(request, "error");
			}
		}
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws PortletException, IOException {

		// TODO Auto-generated method stub
		super.render(request, response);
	}

}
