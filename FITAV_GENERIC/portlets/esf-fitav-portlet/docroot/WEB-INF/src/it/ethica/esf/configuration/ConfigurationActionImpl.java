
package it.ethica.esf.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

public class ConfigurationActionImpl extends DefaultConfigurationAction {
	
	@Override
	public void processAction(
		PortletConfig portletConfig, ActionRequest actionRequest,
		ActionResponse actionResponse)
			throws Exception {
			
		super.processAction(portletConfig, actionRequest, actionResponse);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		String updateFirstName = prefs.getValue("updateFirstName", "false");
		String updateLastName = prefs.getValue("updateLastName", "false");
		String updateGender = prefs.getValue("updateGender", "false");
		String updateYearBirth = prefs.getValue("updateYearBirth", "false");
		String updatePlaceBirth = prefs.getValue("updatePlaceBirth", "false");
		String updateResidence = prefs.getValue("updateResidence", "false");
		String updateHeight = prefs.getValue("updateHeight", "false");
		String updateWeight = prefs.getValue("updateWeight", "false");
		String updateMaritalStatus =
			prefs.getValue("updateMaritalStatus", "false");
		String updateChildren = prefs.getValue("updateChildren", "false");
		String updateHigherEducation =
			prefs.getValue("updateHigherEducation", "false");
		String updateProfession = prefs.getValue("updateProfession", "false");
		String updateLanguages = prefs.getValue("updateLanguages", "false");
		String updateHobbies = prefs.getValue("updateHobbies", "false");
		String updateHandedness = prefs.getValue("updateHandedness", "false");
		String updateMasterEye = prefs.getValue("updateMasterEye", "false");
		String updateOther = prefs.getValue("updateOther", "false");
		String updateComments = prefs.getValue("updateComments", "false");
		String enableSubmit = prefs.getValue("enableSubmit", "false");
		
		// System.out.println("updateFirstName= " + updateFirstName);
		// System.out.println("updateLastName= " + updateLastName);
		// System.out.println("updateGender= " + updateGender);
		// System.out.println("updateYearBirth= " + updateYearBirth);
		// System.out.println("updatePlaceBirth= " + updatePlaceBirth);
		// System.out.println("updateResidence= " + updateResidence);
		// System.out.println("updateHeight= " + updateHeight);
		// System.out.println("updateWeight= " + updateWeight);
		// System.out.println("updateMaritalStatus= " + updateMaritalStatus);
		// System.out.println("updateChildren= " + updateChildren);
		// System.out.println("updateHigherEducation= " +
		// updateHigherEducation);
		// System.out.println("updateProfession= " + updateProfession);
		// System.out.println("updateLanguages= " + updateLanguages);
		// System.out.println("updateHobbies= " + updateHobbies);
		// System.out.println("updateHandedness= " + updateHandedness);
		// System.out.println("updateMasterEye= " + updateMasterEye);
		// System.out.println("updateOther= " + updateOther);
		// System.out.println("updateComments= " + updateComments);
		
	}
}
