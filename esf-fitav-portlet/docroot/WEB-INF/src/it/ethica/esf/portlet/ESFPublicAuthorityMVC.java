package it.ethica.esf.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFPublicAuthority;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFPublicAuthorityLocalServiceUtil;

/**
 * Portlet implementation class PublicAuthorityMVC
 */
public class ESFPublicAuthorityMVC extends MVCPortlet {
	
	private static Log logger = LogFactoryUtil.getLog(ESFPublicAuthorityMVC.class);

	public void editESFPublicAuthority(ActionRequest request, ActionResponse response) throws SystemException {
		long esfPublicAuthorityId = ParamUtil.getLong(request, "esfPublicAuthorityId");
		String descrizione = ParamUtil.getString(request, "description");
		ESFPublicAuthority authority = null;
		authority = ESFPublicAuthorityLocalServiceUtil.createESFPublicAuthority(esfPublicAuthorityId);
		authority.setDescription(descrizione);
		try {
			ESFPublicAuthorityLocalServiceUtil.saveUpdateESFPublicAuthority(authority);
			SessionMessages.add(request, "success-public-authority-persist");
		} catch (SystemException e) {
			logger.error("Errore durante la scrittura dell'Authority", e);
			SessionErrors.add(request, "error-public-authority-persist");
			response.setRenderParameter("mvcPath", "/html/esfdocumenttype/edit_esfPublicAuthority.jsp");
		}
	}
	
	public void deleteESFPublicAuthority(ActionRequest request, ActionResponse response) throws SystemException {
		long esfPublicAuthorityId = ParamUtil.getLong(request, "esfPublicAuthorityId");
		boolean hasRelations = false;
		List<ESFDocument> relatedDocuments = null;
		try {
			logger.debug("Authority da cancellare: "+esfPublicAuthorityId);
			relatedDocuments = ESFDocumentLocalServiceUtil.findByEsfPublicAuthorityId(esfPublicAuthorityId);			
			hasRelations = relatedDocuments!=null && relatedDocuments.size()>0;
			logger.debug("Authority  hasRelations: "+hasRelations);
			if(!hasRelations){
				logger.debug("Cancellazione dell'Authority : "+hasRelations);
				ESFPublicAuthorityLocalServiceUtil.deleteESFPublicAuthority(esfPublicAuthorityId);
				logger.debug("Cancellazione Authority terminata");
				SessionMessages.add(request, "success-public-authority-delete");
			}else{
				logger.warn("L'Authority non può essere cancellata");
				SessionErrors.add(request, "error-public-authority-delete-impossible");
			}			
		} catch (PortalException e) {
			logger.error("Errore durante la canellazione della PublicAuthority", e);
			SessionErrors.add(request, "error-public-authority-persist");
		}
	}
}