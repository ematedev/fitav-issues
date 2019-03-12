package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFElectronic;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.service.ESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil;

import java.util.List;

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
 * Portlet implementation class ESFElectronicPortlet
 */
public class ESFElectronicPortlet extends MVCPortlet {
 

	public void editEsfElectronic(ActionRequest request, ActionResponse response) 
					throws PortalException, SystemException{
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ESFElectronic.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name");
		
		String description = ParamUtil.getString(request, "description");
		
		long esfElectronicId = ParamUtil.getLong(request, "esfElectronicId");
		
		if(esfElectronicId > 0 ){
			
			ESFElectronicLocalServiceUtil.updateEsfElectronic(
				esfElectronicId, name, description, serviceContext);
			
		}
		else{
			
			ESFElectronicLocalServiceUtil.addEsfElectronic(name, description, serviceContext);
		}
		
	}
	
	public void deleteEsfElectronic(ActionRequest request, ActionResponse response) 
					throws PortalException, SystemException{
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ESFElectronic.class.getName(), request);
		
		long esfElectronicId = ParamUtil.getLong(request, "esfElectronicId");
		
		List<ESFFieldESFElectronic> esfFieldESFElectronicsFromDb =
						ESFFieldESFElectronicLocalServiceUtil.findByElectronicId(esfElectronicId);
		
		if(esfFieldESFElectronicsFromDb.size() == 0 ){
			
			ESFElectronicLocalServiceUtil.deleteEsfElectronic(esfElectronicId, serviceContext);
			
		}
		else{
			
			SessionErrors.add(request, "esfElectronic-reference-error");
		}
		
	}
}
