
package it.ethica.esf.portlet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

/**
 * Portlet implementation class BDOAdminPortlet
 */
public class BDOAdminPortlet extends MVCPortlet {

	public void updateAddESFUserESFRole(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException, PortalException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(actionRequest);

		boolean[] chooses = ParamUtil.getBooleanValues(actionRequest, "choose");
		long[] esfUserIds =
			ParamUtil.getLongValues(actionRequest, "esfUserIds");
		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		String type = ParamUtil.getString(actionRequest, "type");
		Date date = new Date();

		ESFUserRole esfUserRole =
			ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
		int maxUser = esfUserRole.getMaxUser();

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
				esfOrganizationId, esfUserRoleId);

		int checkMax = 0;
		if (type.equals("NA")) {
			
			for (int j = 0; j < chooses.length; j++) {
				if (chooses[j])
					checkMax++;
			}
		}
		
		// check del max
		if (maxUser == 0 || esfUserESFUserRoles.size() + checkMax <= maxUser ||
			type.equals("A")) {
			
			for (int i = 0; i < esfUserIds.length; i++) {
				
				if (type.equals("NA") && chooses[i]) {
					
					ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
						esfUserIds[i], esfUserRoleId, esfOrganizationId, date);
				}
				else if (type.equals("A") && chooses[i]) {
					
					ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(
						esfUserIds[i], esfUserRoleId, esfOrganizationId, date,
						serviceContext);
				}
			}
		}else {
			SessionErrors.add(actionRequest, "userrole-maxuser-error");
		}
	}
	
	public void yearsEarlier(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, PortalException {
		
		String lastBdo = "lastBdo";
		String yearString = ParamUtil.getString(actionRequest, "year");
		Long organization = ParamUtil.getLong(actionRequest, "currentOrganizationId");
		int year = Integer.valueOf(yearString);
		SimpleDateFormat sdf = 	new SimpleDateFormat("dd/MM/yyyy");

		List<ESFUserESFUserRole> userBDOAdmins = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> userBDOAdminsAll =  ESFUserESFUserRoleLocalServiceUtil.findbyBDORole(organization);
		
		for(ESFUserESFUserRole u : userBDOAdminsAll){
			String endDate = sdf.format(u.getEndDate());
			String[] splitEnddate =  endDate.split("/");
			
			if(Integer.valueOf(splitEnddate[2])== year){
				userBDOAdmins.add(u);
			}
		}
		
		actionResponse.setRenderParameter("mvcPath", templatePath +"view.jsp");
		actionResponse.setRenderParameter("lastBdo", lastBdo);
		actionResponse.setRenderParameter("yearSelected", yearString);
		actionRequest.setAttribute("userBDOAdminsAll", userBDOAdminsAll);
		actionRequest.setAttribute("userBDOAdmins", userBDOAdmins);
		
	}
	
	
	public void updateShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException, PortalException {
		
		String lastnameB = ParamUtil.getString(actionRequest, "lastnameB");
		String firstnameB = ParamUtil.getString(actionRequest, "firstnameB");
		String backPage = ParamUtil.getString(actionRequest, "backPage");
		String tabs1 = ParamUtil.getString(actionRequest, "tabs1");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");

		long esfUserIds = ParamUtil.getLong(actionRequest, "esfUserIds");
		long esfOrganizationId = ParamUtil.getLong(actionRequest, "esfOrganizationId");
		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfRoleId");
		
		ESFUser esfUser = new ESFUserImpl();
		User user = null;
		
		try {
			if(Validator.isNotNull(esfUserIds) && esfUserIds > 0){
				esfUser = ESFUserLocalServiceUtil.fetchESFUser(esfUserIds);
				user = UserLocalServiceUtil.fetchUser(esfUserIds);
				
				user.setLastName(lastName);
				user.setFirstName(firstName);
				esfUser.setFiscalCode(fiscalCode.toUpperCase());
				
				UserLocalServiceUtil.updateUser(user);
				ESFUserLocalServiceUtil.updateESFUser(esfUser);
				
			}
		}
		catch (Exception e) {
			
			SessionErrors.add(actionRequest, "BDO-Change-reference-error");
			// TODO: handle exception
		}
		
		actionResponse.setRenderParameter("mvcPath", backPage);
		actionResponse.setRenderParameter("tabs1", tabs1);
		actionResponse.setRenderParameter("lastname", lastnameB);
		actionResponse.setRenderParameter("firstname", firstnameB);
		actionResponse.setRenderParameter("esfOrganizationId", String.valueOf(esfOrganizationId));
		actionResponse.setRenderParameter("esfUserRoleId", String.valueOf(esfUserRoleId) );
		
	}

	private static Log _log = LogFactoryUtil.getLog(BDOAdminPortlet.class);
}
