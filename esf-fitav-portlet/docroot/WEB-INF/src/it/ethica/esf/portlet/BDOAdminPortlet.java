
package it.ethica.esf.portlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.VW_ESFListaIncarichi;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.VW_ESFListaIncarichiLocalServiceUtil;

/**
 * Portlet implementation class BDOAdminPortlet
 */
public class BDOAdminPortlet extends MVCPortlet {
	

	Log logger =  LogFactoryUtil.getLog(BDOAdminPortlet.class);
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {
		
		logger.debug("Effettuato Render della BDOAdminPortlet");
		logger.debug("Effettuato Render della BDOAdminPortlet");


		super.render(request, response);
	}
	

	public void updateAddESFUserESFRole(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException, PortalException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(actionRequest);

		boolean[] chooses = ParamUtil.getBooleanValues(actionRequest, "choose");
		long[] esfUserIds =
			ParamUtil.getLongValues(actionRequest, "esfUserIds");
		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		String type = ParamUtil.getString(actionRequest, "type");
		Date date = new Date();

		ESFUserRole esfUserRole =
			ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
		int maxUser = esfUserRole.getMaxUser();

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
				esfOrganizationId, esfUserRoleId);

		int checkMax = 0;
		if (type.equals("NA")) {
			
			for (int j = 0; j < chooses.length; j++) {
				if (chooses[j])
					checkMax++;
			}
		}
		
		// check del max
		if (maxUser == 0 || esfUserESFUserRoles.size() + checkMax <= maxUser ||
			type.equals("A")) {
			
			for (int i = 0; i < esfUserIds.length; i++) {
				
				if (type.equals("NA") && chooses[i]) {
					
					ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
						esfUserIds[i], esfUserRoleId, esfOrganizationId, date);
				}
				else if (type.equals("A") && chooses[i]) {
					
					ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(
						esfUserIds[i], esfUserRoleId, esfOrganizationId, date,
						serviceContext);
				}
			}
		} else {
			SessionErrors.add(actionRequest, "userrole-maxuser-error");
		}
	}
	
	
	/**
	 * Visualizza la lista dei consiglieri per l'anno selezionato
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void yearsEarlier(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, PortalException {
		
		
		String lastBdo = "lastBdo";
		String yearString = ParamUtil.getString(actionRequest, "year");
		long esfOrganizationId = ParamUtil.getLong(actionRequest, "currentOrganizationId");
		int annoSelezionato = Integer.valueOf(yearString);

		try {

			Map<Long, VW_ESFListaIncarichi> listaConsiglieriInCarica = new HashMap<Long, VW_ESFListaIncarichi>();
			List<VW_ESFListaIncarichi> listaStoricaIncarichiConsiglieri = 
					VW_ESFListaIncarichiLocalServiceUtil.findByorganizzazione(esfOrganizationId);
			
			///// TODO REENGINEERING 2019 - ID 40 GRINALDI
			/*
			 * E' in carica ANCHE se la Data fine e' null e (contemporaneamente) la data inizio e' uguale o precedente all'anno selezionato
			 */
	
			logger.debug("Lista Consiglieri per l'anno[" + annoSelezionato + "] dimensione[" + listaStoricaIncarichiConsiglieri.size() + "]");


			Calendar inizioAnnoSelezionato = Calendar.getInstance();
			inizioAnnoSelezionato.set(annoSelezionato, Calendar.JANUARY, 1);

			Calendar fineAnnoSelezionato = Calendar.getInstance();
			fineAnnoSelezionato.set(annoSelezionato, Calendar.DECEMBER, 31);
			
			
			
			// Filtra quelli che sono in carica nell'anno selezionato
			for (VW_ESFListaIncarichi incaricoCorrente : listaStoricaIncarichiConsiglieri) {
	
				boolean inCarica = true;
				
	
				if ( incaricoCorrente.getEndDate() != null ) {
	
					Calendar fineMandato = Calendar.getInstance();
					fineMandato.setTime( incaricoCorrente.getEndDate() );
					
					inCarica = fineMandato.after(inizioAnnoSelezionato);
				}
								
				logger.debug("Data Inizio[" + incaricoCorrente.getStartDate() + "] annoSelezionato[" + annoSelezionato + "]");
				
				Calendar inizioMandato = Calendar.getInstance();
				inizioMandato.setTime(incaricoCorrente.getStartDate());
				
				inCarica = inCarica && inizioMandato.before(fineAnnoSelezionato);
	
					
				if ( inCarica && ! listaConsiglieriInCarica.containsKey( incaricoCorrente.getEsfUserId() ) ) {
					listaConsiglieriInCarica.put(incaricoCorrente.getEsfUserId(), incaricoCorrente);
					logger.debug("Aggiunto incarico per consigliereID[" + incaricoCorrente.getEsfUserId() + "] nell'anno[" + yearString + "]");
				}			
			}
			
			actionResponse.setRenderParameter("mvcPath", templatePath +"view.jsp");
			actionResponse.setRenderParameter("lastBdo", lastBdo);
			actionResponse.setRenderParameter("yearSelected", yearString);
			actionRequest.setAttribute("userBDOAdminsAll", listaStoricaIncarichiConsiglieri);
			actionRequest.setAttribute("userBDOAdmins", listaConsiglieriInCarica.values());
		} catch ( Exception e ) {
			logger.error("Impossibile valorizzare la lista degli incarichi per l'anno[" + yearString + "]", e );
		}
		
		
	}
	
	
	public void updateShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException, PortalException {
		
		String lastnameB = ParamUtil.getString(actionRequest, "lastnameB");
		String firstnameB = ParamUtil.getString(actionRequest, "firstnameB");
		String backPage = ParamUtil.getString(actionRequest, "backPage");
		String tabs1 = ParamUtil.getString(actionRequest, "tabs1");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");

		long esfUserIds = ParamUtil.getLong(actionRequest, "esfUserIds");
		long esfOrganizationId = ParamUtil.getLong(actionRequest, "esfOrganizationId");
		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfRoleId");
		
		ESFUser esfUser = new ESFUserImpl();
		User user = null;
		
		try {
			if(Validator.isNotNull(esfUserIds) && esfUserIds > 0){
				esfUser = ESFUserLocalServiceUtil.fetchESFUser(esfUserIds);
				user = UserLocalServiceUtil.fetchUser(esfUserIds);
				
				user.setLastName(lastName);
				user.setFirstName(firstName);
				esfUser.setFiscalCode(fiscalCode.toUpperCase());
				
				UserLocalServiceUtil.updateUser(user);
				ESFUserLocalServiceUtil.updateESFUser(esfUser);
				
			}
		}
		catch (Exception e) {
			
			SessionErrors.add(actionRequest, "BDO-Change-reference-error");
			// TODO: handle exception
		}
		
		actionResponse.setRenderParameter("mvcPath", backPage);
		actionResponse.setRenderParameter("tabs1", tabs1);
		actionResponse.setRenderParameter("lastname", lastnameB);
		actionResponse.setRenderParameter("firstname", firstnameB);
		actionResponse.setRenderParameter("esfOrganizationId", String.valueOf(esfOrganizationId));
		actionResponse.setRenderParameter("esfUserRoleId", String.valueOf(esfUserRoleId) );
		
	}

	private static Log _log = LogFactoryUtil.getLog(BDOAdminPortlet.class);
}
