package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFOrganizationAdmin
 */
public class ESFOrganizationAdminPortlet extends MVCPortlet {
	
	public void saveAll(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException  {
		editESFOrganization(actionRequest, actionResponse);
	}
	
	public void editESFOrganization(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException  {
		ServiceContext esc = ServiceContextFactory.getInstance(ESFOrganization.class.getName(), actionRequest);
		ServiceContext psc = ServiceContextFactory.getInstance(Organization.class.getName(), actionRequest);
		long esfOrganizationId = ParamUtil.getLong(actionRequest, "esfOrganizationId");
		String name = ParamUtil.getString(actionRequest, "name");
		long[] types = ParamUtil.getLongValues(actionRequest, "types");
		
		if(esfOrganizationId > 0) {			
			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
			long portalOrganizationId = esfOrganization.getPortalOrganizationId();
			ESFOrganizationLocalServiceUtil.updateESFOrganization(esc.getUserId(), esfOrganizationId, name, esc);			
		} else {			
			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.addESFOrganization(esc.getUserId(), name, esc, psc);		
			esfOrganizationId = esfOrganization.getEsfOrganizationId();
		}
		for(long type : types) {
			ESFOrganizationTypeLocalServiceUtil.addESFOrganizationType(esc.getUserId(), type, esfOrganizationId, esc);
		}
	}
	
	public void deleteESFOrganization(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException  {
		ServiceContext esc = ServiceContextFactory.getInstance(ESFOrganization.class.getName(), actionRequest);
		long esfOrganizationId = ParamUtil.getLong(actionRequest, "esfOrganizationId");
		ESFOrganizationLocalServiceUtil.deleteESFOrganization(esfOrganizationId, esc);
	}
 

}
