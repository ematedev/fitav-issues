package it.ethica.esf.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.StringPool;

public class NormalMatchConfigurationActionImpl extends DefaultConfigurationAction {
	
	@Override
	public void processAction(
		PortletConfig portletConfig, ActionRequest actionRequest,
		ActionResponse actionResponse)
			throws Exception {
			
		super.processAction(portletConfig, actionRequest, actionResponse);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		
		String isViewMode = prefs.getValue("isViewMode", StringPool.TRUE);
		
		/*if(_log.isInfoEnabled()){
			_log.info("normal match view mode is set to : " + isViewMode);
		}*/
	}
	
	private static Log _log = LogFactoryUtil.getLog(NormalMatchConfigurationActionImpl.class);
}
