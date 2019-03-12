
package it.ethica.esf.useradmin.portlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFUserLocalServiceImpl;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class UserAdminPortlet extends MVCPortlet {

	public void editESFUser(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext esc =
			ServiceContextFactory.getInstance(
				ESFUser.class.getName(), actionRequest);
		ServiceContext psc =
			ServiceContextFactory.getInstance(
				User.class.getName(), actionRequest);

		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String emailAddress = ParamUtil.getString(actionRequest, "userEmail");
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		String code = ParamUtil.getString(actionRequest, "code");

		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");

		Date birthday = ParamUtil.getDate(actionRequest, "birthday", format);

		Calendar c = Calendar.getInstance();
		c.setTime(birthday);

		if (esfUserId > 0) {
			ESFUserLocalServiceUtil.updateESFUser(
				psc.getUserId(), esfUserId, emailAddress, firstName, lastName,
				screenName, true, c.get(Calendar.MONTH), 
				c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR), jobTitle,
				esc);
		}
		else {
			ESFUserLocalServiceUtil.addESFUser(
				psc.getUserId(), code, screenName, emailAddress, ((long) 0),
				esc.getLocale(), firstName, "", lastName, 0, 0, true,
				c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),
				c.get(Calendar.YEAR), "", psc, esc);
		}
	}

	public void deleteUser(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext esc =
			ServiceContextFactory.getInstance(
				ESFUser.class.getName(), actionRequest);
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		ESFUserLocalServiceUtil.deleteESFUser(esfUserId, esc);
	}

	private static Log _log = LogFactoryUtil.getLog(UserAdminPortlet.class);
}
