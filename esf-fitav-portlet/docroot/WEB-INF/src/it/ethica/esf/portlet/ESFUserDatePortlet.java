
package it.ethica.esf.portlet;

import it.ethica.esf.util.PropertiesServiceFactory;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFUserDatePortlet
 */
public class ESFUserDatePortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws PortletException, IOException {

		super.render(request, response);
	}

	public void editDate(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, IOException {

		String startDate = ParamUtil.getString(actionRequest, "startDate");
		String endDate = ParamUtil.getString(actionRequest, "endDate");
		PropertiesServiceFactory.getInstance(
			"userDate.properties", "startDate", startDate);
		PropertiesServiceFactory.getInstance(
			"userDate.properties", "endDate", endDate);
	}
}
