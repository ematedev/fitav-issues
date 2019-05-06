
package it.ethica.esf.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;

/**
 * Portlet implementation class ESFMatchType
 */
public class ESFMatchTypePortlet extends MVCPortlet {
	
	Log logger = LogFactoryUtil.getLog(ESFMatchTypePortlet.class);
	
	public void editESFMatchType(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		String messageCode = "MSG-gara-GestioneTipi-Gestione-ERROR";
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMatchTypePortlet.class.getName(), request);

		long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");
		String name = ParamUtil.getString(request, "name");
	//	long esfDescriptionId = ParamUtil.getLong(request, "description");
		boolean isCategoryQualification =
			ParamUtil.getBoolean(request, "isCategoryQualification");
		boolean isNational = ParamUtil.getBoolean(request, "isNational");
		
		try {
		
			if (esfMatchTypeId > 0) {
	
				ESFMatchTypeLocalServiceUtil.updateEsfMatchType(
					esfMatchTypeId, name, isCategoryQualification, isNational,
					 serviceContext);
				
				messageCode = "MSG-gara-GestioneTipi-Modificato-OK";
	
			} else {
	
				ESFMatchTypeLocalServiceUtil.addEsfMatchType(
					name, isCategoryQualification, isNational,
					serviceContext);
				messageCode = "MSG-gara-GestioneTipi-Aggiunto-OK";
			}
		} catch ( Exception e ) {
			logger.error("Impossibile gestire il Tipo Gara[" + name + "] di Tipo ID[" + esfMatchTypeId + "]");
			messageCode = "MSG-gara-GestioneTipi-Gestione-ERROR";
		} 
		SessionMessages.add(request, messageCode);
	}

	public void deleteESFMatchType(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");

		if (esfMatchTypeId > 0) {
			List<ESFMatch> matches =
				ESFMatchLocalServiceUtil.findbyMatchType(esfMatchTypeId);
			if (matches == null || matches.size()==0) {
				ESFMatchTypeLocalServiceUtil.deleteEsfMatchType(esfMatchTypeId);
			}
			else {
				SessionErrors.add(request, "error");
			}
		}
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws PortletException, IOException {

		// TODO Auto-generated method stub
		super.render(request, response);
	}

}
