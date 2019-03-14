package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Contact;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFNationalAdminPortlet
 */
public class ESFNationalAdminPortlet extends MVCPortlet {

	public void addNational(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(ESFNational.class.getName(), request);

		long[] nationalIds = ParamUtil.getLongValues(request,
				"checkNationalCheckbox");
		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");


		Calendar now = CalendarFactoryUtil.getCalendar();

		Date startDate = now.getTime();
		now.set(Calendar.YEAR, now.get(Calendar.YEAR) + 1);
		Date endDate = now.getTime();

		for (long nationalId : nationalIds) {

			ESFNationalLocalServiceUtil.addESFNational(
					serviceContext.getUserId(), nationalId, esfSportTypeId,
					startDate, endDate, startDate, serviceContext);
		}
	}

	public void deleteNational(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(ESFNational.class.getName(), request);

		long esfNationalId = ParamUtil.getLong(request, "esfNationalId");

		Calendar now = CalendarFactoryUtil.getCalendar();

		Date endDate = now.getTime();

		ESFNationalLocalServiceUtil
				.deleteESFNational(serviceContext.getUserId(), esfNationalId,
						endDate, serviceContext);
	}

}
