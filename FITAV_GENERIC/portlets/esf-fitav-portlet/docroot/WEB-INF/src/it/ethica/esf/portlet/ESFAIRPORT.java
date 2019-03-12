package it.ethica.esf.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.service.ESFAirportLocalServiceUtil;

/**
 * Portlet implementation class ESFAIRPORT
 */
public class ESFAIRPORT extends MVCPortlet {
		
		public  void addESFAirport(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException
		{
			String name = actionRequest.getParameter("name");
			String city = actionRequest.getParameter("city");
			String country = actionRequest.getParameter("country");
			
			ESFAirportLocalServiceUtil.adESFAirport(name, city, country);
			
		}
		
		public void cancURL(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException
		{
			Long id = Long.parseLong(actionRequest.getParameter("esfAirportId"));
			ESFAirportLocalServiceUtil.deleteESFAirport(id);
		}
}
