
package it.ethica.esf.portlet;

import java.text.ParseException;
import java.util.Date;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.util.ConvertDateCal;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFAddressPortlet
 */
public class ESFCardPortlet extends MVCPortlet {

	public void addESFCard(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFCard.class.getName(), actionRequest);

		String code = ParamUtil.getString(actionRequest, "code");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		String startDateString =
			ParamUtil.getString(actionRequest, "startDate");
		String endDateString = ParamUtil.getString(actionRequest, "endDate");
		Date startDate = new Date();
		Date endDate = new Date();
		try {
			startDate = ConvertDateCal.StringToDate(startDateString);
			endDate = ConvertDateCal.StringToDate(endDateString);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ESFCardLocalServiceUtil.addESFCard(
				serviceContext.getUserId(), code, startDate, endDate,
				esfUserId, esfOrganizationId, serviceContext);
			// ListTypeConstants.ACCOUNT_ADDRESS_DEFAULT;
			SessionMessages.add(actionRequest, "addESFCardMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

	public void updateESFCard(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFCard.class.getName(), actionRequest);

		long esfCardId = ParamUtil.getLong(actionRequest, "esfCardId");
		String code = ParamUtil.getString(actionRequest, "code");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		String startDateString =
			ParamUtil.getString(actionRequest, "startDate");
		String endDateString = ParamUtil.getString(actionRequest, "endDate");
		Date startDate = new Date();
		Date endDate = new Date();
		try {
			startDate = ConvertDateCal.StringToDate(startDateString);
			endDate = ConvertDateCal.StringToDate(endDateString);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ESFCardLocalServiceUtil.updateESFCard(
				serviceContext.getUserId(), esfCardId, code, startDate,
				endDate, esfUserId, esfOrganizationId, serviceContext);
			// ListTypeConstants.ACCOUNT_ADDRESS_DEFAULT;
			SessionMessages.add(actionRequest, "updateESFCardMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

	public void deleteESFCard(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFCard.class.getName(), actionRequest);

		long esfCardId = ParamUtil.getLong(actionRequest, "esfCardId");
		
		try {
			ESFCardLocalServiceUtil.deleteESFCard(esfCardId, serviceContext);

			SessionMessages.add(actionRequest, "deleteESFCardMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}
}
