package it.ethica.esf.portlet;


import it.ethica.esf.model.ESFEventType;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFEventTypeLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.util.ManageDate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class NewPortlet
 */
public class ESFEventTypePortlet extends MVCPortlet {
 
	public void editESFeventType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, ParseException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFEventTypePortlet.class.getName(), request);

			long esfEventTypeId = ParamUtil.getLong(request, "esfEventTypeId");
			
			String macrocategory = ParamUtil.getString(request, "macrocategory");

			String eventType = ParamUtil.getString(request, "eventType");

			Long esfUserId = ParamUtil.getLong(request, "userId");

			User user = UserLocalServiceUtil.fetchUser(esfUserId);

			long groupId = user.getGroupId();

			long companyId = user.getCompanyId();

			String userName = user.getFullName();

			if (esfEventTypeId > 0) {

				Date modifiedDate = new Date();
			ESFEventTypeLocalServiceUtil.updateEsfEventType(esfEventTypeId,
					groupId, companyId, userName, esfUserId, modifiedDate,
					macrocategory, eventType, serviceContext);

				SessionMessages.add(request, "esfEventTypeUpdated");

				response.setRenderParameter(
					"esfEventTypeId", Long.toString(esfEventTypeId));

			}
			else {

				Date createDate = new Date();
				
			ESFEventTypeLocalServiceUtil.addEsfEventType(groupId, companyId,
					userName, esfUserId, createDate, macrocategory, eventType,
					serviceContext);

					SessionMessages.add(request, "EventTypeUpdated");

					response.setRenderParameter(
						"esfEventTypeId", Long.toString(esfEventTypeId));
				
			}
		}
	
	public void deleteESFEventType(
			ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			long esfEventtypeId = ParamUtil.getLong(request, "esfEventTypeId");
			String eventType = ParamUtil.getString(request, "eventType");

			if (esfEventtypeId > 0) {
				List<ESFMatch> matches =
						ESFMatchLocalServiceUtil.findbyeventType(eventType);
				if (matches == null || matches.size()==0) {
					ESFEventTypeLocalServiceUtil.deleteESFEventType(esfEventtypeId);
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
	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);
}
