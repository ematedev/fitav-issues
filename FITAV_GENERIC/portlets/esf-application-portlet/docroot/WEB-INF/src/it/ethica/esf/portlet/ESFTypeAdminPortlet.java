package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFType;
import it.ethica.esf.service.ESFTypeLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFTypeAdminPortlet
 */
public class ESFTypeAdminPortlet extends MVCPortlet {
 
	public void editESFType(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFType.class.getName(), request);
		
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String className = ParamUtil.getString(request, "className");
		String status = ParamUtil.getString(request, "status");
		long typeParentId = ParamUtil.getLong(request, "parent");
		
		long esfTypeId = ParamUtil.getLong(request, "esfTypeId");
		
		if(esfTypeId > 0) {
			ESFTypeLocalServiceUtil.updateESFType(serviceContext.getUserId(), esfTypeId, code, name, description, className, status, typeParentId, serviceContext);
		} else {
			ESFTypeLocalServiceUtil.addESFType(serviceContext.getUserId(), code, name, description, className, status, typeParentId, serviceContext);
		}
	}
	
	public void deleteESFType(ActionRequest request, ActionResponse response) {
		
		long esfTypeId = ParamUtil.getLong(request, "esfTypeId");
		
		try {
			ESFTypeLocalServiceUtil.deleteESFType(esfTypeId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
}
