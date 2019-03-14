package it.ethica.esf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFUserAdminPortlet
 */
public class ESFUserAdminPortlet extends MVCPortlet {
	
	public void editESFUser(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException  {
		ServiceContext esc = ServiceContextFactory.getInstance(ESFUser.class.getName(), actionRequest);
		ServiceContext psc = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
		
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");		
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");	
		String emailAddress = ParamUtil.getString(actionRequest, "userEmail");
		String screenName = ParamUtil.getString(actionRequest, "screenName");
				
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		
		Date birthday = ParamUtil.getDate(actionRequest, "birthday", format);
			
		Calendar c = Calendar.getInstance();
		c.setTime(birthday);
		
		if(esfUserId > 0) {		
			ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
			ESFUserLocalServiceUtil.updateESFUser(esc.getUserId(), esfUserId, emailAddress, firstName, lastName, true, c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR), esc);
		} else {
			User user = UserLocalServiceUtil.getUser(esc.getUserId());
			ESFUserLocalServiceUtil.addESFUser(user.getUserId(), screenName, emailAddress, ((long)0), esc.getLocale(), firstName, "", lastName, 0, 0, true, c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR), "", psc, esc);
		}
	}

	public void deleteUser(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException  {
		ServiceContext esc = ServiceContextFactory.getInstance(ESFUser.class.getName(), actionRequest);
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
		long portalUserId = esfUser.getPortalUserId();
		ESFUserLocalServiceUtil.deleteESFUser(esfUserId, portalUserId, esc);
	}

}
