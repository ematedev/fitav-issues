
package it.ethica.eventlisting.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

public class ConfigurationActionImpl extends DefaultConfigurationAction {
	
	@Override
	public void processAction(
		PortletConfig portletConfig, ActionRequest actionRequest,
		ActionResponse actionResponse)
		throws Exception {
	
		super.processAction(portletConfig, actionRequest, actionResponse);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		String firstRegistrationTabAbilitation =
			prefs.getValue("firstRegistrationTabAbilitation", "true");
		
		String buyOneCardTabAbilitation =
						prefs.getValue("buyOneCardTabAbilitation", "true");
		
		String buyManyCardsTabAbilitation =
						prefs.getValue("buyManyCardsTabAbilitation", "true");
		
		String annualMembershipDueTabAbilitation =
						prefs.getValue("annualMembershipDueTabAbilitation", "true");
		
		String integrationTabAbilitation =
				prefs.getValue("integrationTabAbilitation", "true");
		
		String olimpicMatch = 
				prefs.getValue("olimpicMatch", "true");
		
		String nationalMatch = 
				prefs.getValue("nationalMatch", "true");
		
		String event = 
				prefs.getValue("event", "true");
		
	}
}
