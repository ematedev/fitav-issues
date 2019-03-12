
package it.ethica.esf.portlet;

import java.io.IOException;
import java.util.List;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ManageOperationsField;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFFieldPortlet
 */
public class ESFFieldPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {
	
		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		
		try {
			
			List<ESFFieldESFElectronic> esfFieldESFElectronics = ESFFieldESFElectronicLocalServiceUtil.findByFieldId(esfFieldId);

			if(esfFieldESFElectronics.size() < ESFKeys.MinElemIncludePage.MINMACHINE){

				request.setAttribute("numberOfMachines", ESFKeys.MinElemIncludePage.MINMACHINE);

			}
			else{

				request.setAttribute("numberOfMachines", esfFieldESFElectronics.size());

			}
		}
		catch (SystemException e) {
		}
		
		super.render(request, response);
	}
	
	public void editESFField(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFField.class.getName(), request);

		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		String name = ParamUtil.getString(request, "name");

		long esfStateId = ParamUtil.getLong(request, "esfStateId");

		long ownerOrganizationId =
			ParamUtil.getLong(request, "ownerOrganizationId");
		long esfSportTypeId[] =
			ParamUtil.getLongValues(request, "esfSportTypeId");
		long billboard = ParamUtil.getLong(request, "billboard");
		boolean billboardStations =
			ParamUtil.getBoolean(request, "billboardStations");
		boolean backgroundRampart =
			ParamUtil.getBoolean(request, "backgroundRampart");
		boolean backgroundNet = ParamUtil.getBoolean(request, "backgroundNet");
		boolean backgroundLeadRecovery =
			ParamUtil.getBoolean(request, "backgroundLeadRecovery");
		boolean disabledaccess =
			ParamUtil.getBoolean(request, "disabledAccess");
		String note = ParamUtil.getString(request, "note");

		List<ESFFieldESFElectronic> esfFieldESFElectronics= ManageOperationsField.getEsfFieldESFElectronics(
			request, response);
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(esfStateId);

		if (esfFieldId > 0) {

			ESFFieldLocalServiceUtil.updateESFField(
				serviceContext.getUserId(), esfFieldId, name,
				ownerOrganizationId, 0, esfSportTypeId,
				esfEntityState, note, billboard, billboardStations,
				backgroundRampart, backgroundNet, backgroundLeadRecovery,
				disabledaccess, esfFieldESFElectronics, serviceContext);

		}
		else {

			ESFFieldLocalServiceUtil.addESFField(
				serviceContext.getUserId(), name, ownerOrganizationId, 0,
				esfSportTypeId, esfEntityState, note, billboard,
				billboardStations, backgroundRampart, backgroundNet,
				backgroundLeadRecovery, disabledaccess, esfFieldESFElectronics,
				serviceContext);
		}
	}

	public void deleteESFField(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");

		if (esfFieldId > 0) {

			ESFFieldLocalServiceUtil.deleteESFField(esfFieldId);
		}
	}
	
	public void giveWayESFField(ActionRequest request, ActionResponse response) 
					throws PortalException, SystemException{
		
		ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFField.class.getName(), request);
		
		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");

		ESFFieldLocalServiceUtil.giveWayESFField(esfFieldId, esfOrganizationId, serviceContext);
	}
	
	public void returnESFField(ActionRequest request, ActionResponse response) 
					throws PortalException, SystemException{
		
		ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFField.class.getName(), request);
		
		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
		
		ESFFieldLocalServiceUtil.returnESFField(esfFieldId, esfOrganizationId, serviceContext);
	}
	
}
