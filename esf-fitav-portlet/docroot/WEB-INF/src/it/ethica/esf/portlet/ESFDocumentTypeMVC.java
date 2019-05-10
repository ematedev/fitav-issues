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
import it.ethica.esf.model.ESFDocumentType;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil;

/**
 * Portlet implementation class ESFDocumentType
 */
public class ESFDocumentTypeMVC extends MVCPortlet {
	private static Log logger = LogFactoryUtil.getLog(ESFDocumentTypeMVC.class);

	public void editESFDocumentType(ActionRequest request, ActionResponse response) throws SystemException {
		long esfDocumentTypeId = ParamUtil.getLong(request, "esfDocumentTypeId");
		String descrizione = ParamUtil.getString(request, "description");
		int expirationMonthsNotice = ParamUtil.getInteger(request, "expirationMonthsNotice");
		ESFDocumentType docType = null;
		
		docType = ESFDocumentTypeLocalServiceUtil.createESFDocumentType(esfDocumentTypeId);
		docType.setDescription(descrizione);
		docType.setExpirationMonthsNotice(expirationMonthsNotice);
		try {
			ESFDocumentTypeLocalServiceUtil.saveUpdateESFDocumentType(docType);
			SessionMessages.add(request, "success-document-type-persist");
		} catch (SystemException e) {
			logger.error("Errore durante la scrittura del DocumentType", e);
			SessionErrors.add(request, "error-document-type-persist");
			response.setRenderParameter("mvcPath", "/html/esfdocumenttype/edit_esfDocumentType.jsp");
		}
	}
	
	public void deleteESFDocumentType(ActionRequest request, ActionResponse response) throws SystemException {
		long esfDocumentTypeId = ParamUtil.getLong(request, "esfDocumentTypeId");
		boolean hasRelations = false;
		List<ESFDocument> relatedDocuments = null;
		try {
			logger.debug("Documento da cancellare: "+esfDocumentTypeId);
			relatedDocuments = ESFDocumentLocalServiceUtil.findByEsfDocumentTypeId(esfDocumentTypeId);
			
			hasRelations = relatedDocuments!=null && relatedDocuments.size()>0;
			logger.debug("Documento hasRelations: "+hasRelations);
			if(!hasRelations){
				logger.debug("Cancellazione del documento: "+hasRelations);
				ESFDocumentTypeLocalServiceUtil.deleteESFDocumentType(esfDocumentTypeId);
				logger.debug("Cancellazione del documento terminata");
				SessionMessages.add(request, "success-document-type-delete");
			}else{
				logger.warn("Il documento non può essere cancellato");
				SessionErrors.add(request, "error-document-type-delete-impossible");
			}			
		} catch (PortalException e) {
			logger.error("Errore durante la canellazione del DocumentType", e);
			SessionErrors.add(request, "error-document-type-persist");
		}
	}
}