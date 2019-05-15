package it.ethica.esf.portlet;

import java.util.List;

import it.ethica.esf.model.ESFBrand;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.service.ESFBrandLocalServiceUtil;
import it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFBrandPortlet
 */
public class ESFBrandPortlet extends MVCPortlet {
 

	public void editEsfBrand(ActionRequest request, ActionResponse response) 
					throws PortalException, SystemException{
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ESFBrand.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name");
		
		String description = ParamUtil.getString(request, "description");
		
		long esfBrandId = ParamUtil.getLong(request, "esfBrandId");
		
		if(esfBrandId > 0 ){
			
			ESFBrandLocalServiceUtil.updateEsfBrand(
				esfBrandId, name, description, serviceContext);
			
		}
		else{
			
			ESFBrandLocalServiceUtil.addEsfBrand(name, description, serviceContext);
		}
		
	}
	
	public void deleteEsfBrand(ActionRequest request, ActionResponse response) 
					throws PortalException, SystemException{
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ESFBrand.class.getName(), request);
		
		long esfBrandId = ParamUtil.getLong(request, "esfBrandId");
		
		List<ESFFieldESFElectronic> esfFieldESFElectronicsFromDb =
						ESFFieldESFElectronicLocalServiceUtil.findByBrandId(esfBrandId);
		
		if(esfFieldESFElectronicsFromDb.size() == 0 ){
			
			ESFBrandLocalServiceUtil.deleteEsfBrand(esfBrandId, serviceContext);
			
		}
		else{
			
			SessionErrors.add(request, "esfBrand-reference-error");
		}
		
	}
}
