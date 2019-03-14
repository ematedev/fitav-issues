package it.ethica.esf.portlet;

import java.util.Date;

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFDocumentsPortlet
 */
public class ESFDocumentsPortlet extends MVCPortlet {
	public void addESFDocument(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFDocument.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name");
		String type = ParamUtil.getString(request, "type");
		int number = ParamUtil.getInteger(request, "number");
		String issuer = ParamUtil.getString(request, "issuer");
		String locationReference = ParamUtil.getString(request, "locationReference");
		long esfDocumentId = ParamUtil.getInteger(request, "esfDocumentId");
		long ownerId = ParamUtil.getLong(request, "userId");
		
		if(esfDocumentId > 0) {
			try {
				System.out.println("Try to update document " + number);
				ESFDocumentLocalServiceUtil.updateESFDocument(serviceContext.getUserId(), esfDocumentId, ownerId, "", type, name, number, new Date(), new Date(), issuer, "", locationReference, serviceContext);
			
				SessionMessages.add(request, "esfDocumentAdded");
			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				
				PortalUtil.copyRequestParameters(request, response);
				response.setRenderParameter("mvcPath",
						"/html/esfdocuments/edit_esfdocument.jsp");
			}
		} else {
			try {
				System.out.println("Try to add document " + number);
				ESFDocumentLocalServiceUtil.addESFDocument(serviceContext.getUserId(), ownerId, "", type, name, number, new Date(), new Date(), issuer, "", locationReference, serviceContext);
	
				SessionMessages.add(request, "esfDocumentAdded");
			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				System.out.println(e);
	
				response.setRenderParameter("mvcPath",
						"/html/esfdocuments/edit_esfdocument.jsp");
			}
		}
	}
	
	public void deleteEntry(ActionRequest request, ActionResponse response) {
		long esfDocumentId = ParamUtil.getLong(request, "esfDocumentId");
		
		try{
			ServiceContext serviceContext = ServiceContextFactory.getInstance(ESFDocument.class.getName(), request);
			
			ESFDocumentLocalServiceUtil.deleteESFDocument(esfDocumentId);
		} catch(Exception e) {
			SessionErrors.add(request, e.getClass().getName());
		}
	}
}
