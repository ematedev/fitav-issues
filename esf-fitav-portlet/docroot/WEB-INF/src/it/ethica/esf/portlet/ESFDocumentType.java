package it.ethica.esf.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFDocumentType
 */
public class ESFDocumentType extends MVCPortlet {
	

	public void editESFDocumentType(ActionRequest request, ActionResponse response){
		//TODO leggere i parametri dalla request e creare l'entity tramite i servizi del servicebuilder
		long esfDocumentTypeId = ParamUtil.getLong(request, "esfDocumentTypeId");
		//Nel caso non sia un Edit l'id sarà minore di zero
	}	
}
