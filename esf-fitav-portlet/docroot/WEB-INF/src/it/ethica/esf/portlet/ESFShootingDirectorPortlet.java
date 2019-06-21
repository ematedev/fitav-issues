package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.ESFShootingDirectorQualification;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFSuspensiveShootingDirector;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.VM_TiratoriTesserati;
import it.ethica.esf.model.VW_DatiDrettoreTiro;
import it.ethica.esf.model.VW_NomineDirettoriTiro;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFNationalDelegationImpl;
import it.ethica.esf.model.impl.ESFShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.model.impl.VW_DatiDrettoreTiroImpl;
import it.ethica.esf.model.impl.VW_NomineDirettoriTiroImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFRegionLocalServiceUtil;
import it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.VM_TiratoriTesseratiLocalServiceUtil;
import it.ethica.esf.service.VW_DatiDrettoreTiroLocalServiceUtil;
import it.ethica.esf.service.VW_NomineDirettoriTiroLocalServiceUtil;
import it.ethica.esf.service.persistence.VW_NomineDirettoriTiroPK;
import it.ethica.esf.util.DateUtilFormatter;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.MissingDateException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.rolling.SizeBasedTriggeringPolicy;

import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.BeanParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.lowagie.toolbox.arguments.StringArgument;
import com.microsoft.schemas.office.office.PreferrelativeAttribute;


public class ESFShootingDirectorPortlet extends MVCPortlet{
	
	public void updateShooterDirector(ActionRequest actionRequest, ActionResponse actionResponse) {
		long esfShootingDirectorId = ParamUtil.getLong(actionRequest, "esfShootingDirectorId");
		Date startDate = null;
		ESFShootingDirector director = null;
		String backPage = null;
		String sStartDate = ParamUtil.getString(actionRequest, "startDate");
		try {
			startDate = DateUtilFormatter.parseDate(sStartDate);
			director = ESFShootingDirectorLocalServiceUtil.fetchESFShootingDirector(esfShootingDirectorId);
			director.setEsfStartData(startDate);
			ESFShootingDirectorLocalServiceUtil.updateESFShootingDirector(director);
		} catch (SystemException e) {
			_log.error("Errore durante l'aggiornamento del direttore di tiro ["+esfShootingDirectorId+"]", e);
			SessionErrors.add(actionRequest, "error-shooting-director-update");
			backPage = ParamUtil.getString(actionRequest, "mvcPathErr");
			actionResponse.setRenderParameter("mvcPath", backPage);
		} catch (MissingDateException e) {
			_log.error("Errore durante l'aggiornamento del direttore di tiro ["+esfShootingDirectorId+"]", e);
			SessionErrors.add(actionRequest, "error-shooting-director-update");
			backPage = ParamUtil.getString(actionRequest, "mvcPathErr");
			actionResponse.setRenderParameter("mvcPath", backPage);
		} catch (ParseException e) {
			_log.error("Errore durante l'aggiornamento del direttore di tiro ["+esfShootingDirectorId+"]", e);
			SessionErrors.add(actionRequest, "error-shooting-director-update");
			backPage = ParamUtil.getString(actionRequest, "mvcPathErr");
			actionResponse.setRenderParameter("mvcPath", backPage);
		}
	}
	
	/**
	 * Action che ritorna alla jsp la lista delle nomine dei direttori di tiro 
	 * @param request
	 * @param response
	 */
	@ProcessAction(name="cercaNomineDirettoriTiro")
	public void cercaNomineDirettoriTiro(ActionRequest request, ActionResponse response) {
		
		//Prendo quello che mi serve dalla jsp
		String cognome = ParamUtil.getString(request, "lastname", "");
		String nome = ParamUtil.getString(request, "firstname", "");
		String tessera = ParamUtil.getString(request, "card", "");
		String regione = ParamUtil.getString(request, "regionId");
		Long idQualifica = ParamUtil.getLong(request, "qualifica", 0);
		Long idSpecialita = ParamUtil.getLong(request, "specialita", 0);
		int delta = ParamUtil.getInteger(request, "delta", 0);
		int paginaRicercaCorrente = ParamUtil.getInteger(request, "cur", 0); 
		
		
		//DA CANCELLARE
		_log.debug(String.format("Cognome: [%s]\n", cognome)); 
		_log.debug(String.format("Nome: [%s]\n", nome));
		_log.debug(String.format("Tessera: [%s]\n", tessera));
		_log.debug(String.format("Regione: [%s]\n", regione));
		_log.debug(String.format("IdQualifica: [%s]\n", idQualifica));
		_log.debug(String.format("IdSpecialista: [%s]\n", idSpecialita));
		_log.debug(String.format("Delta: [%s]\n", delta));
		_log.debug(String.format("Pagina corrente: [%s]\n", paginaRicercaCorrente));
		
		try {
			
			//Inizializzo la lista
			List<VW_NomineDirettoriTiro> listaNomine = new ArrayList<>();
		
			//Creo la DynamicQuery e effettuo i controlli sulle variabili
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(VW_NomineDirettoriTiro.class, "Direttori", PortletClassLoaderUtil.getClassLoader());
			
			//Restringo la ricerca se vengono valorizzati i campi
			if(!cognome.isEmpty()) { 
				dq.add(RestrictionsFactoryUtil.eq("Direttori.primaryKey.Cognome", cognome)); 
				_log.debug("Entrato in cognome");
			}
			if(!nome.isEmpty()) { 
				dq.add(RestrictionsFactoryUtil.eq("Direttori.primaryKey.Nome", nome)); 
				_log.debug("Entrato in nome");
			} 
			if(!tessera.isEmpty()) { 
				dq.add(RestrictionsFactoryUtil.eq("Direttori.primaryKey.CodiceTessera", tessera)); 
				_log.debug("Entrato in tessera");
			} 
			if(!regione.equals("0")) { 
				dq.add(RestrictionsFactoryUtil.eq("Direttori.primaryKey.Regione", regione)); 
				_log.debug("Entrato in regione");
			}
			if(idQualifica != 0) { 
				ESFShootingDirectorQualification qualificaDirettore = 
						ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualification(idQualifica);
				String qualifica = qualificaDirettore.getEsfShootingDirectorQualificationDesc();
				dq.add(RestrictionsFactoryUtil.eq("Direttori.primaryKey.Qualifica", qualifica)); 
			
				//DA LEVARE
				_log.debug(String.format("Qualifica nome: [%s]\n", qualifica));
			}
			if(idSpecialita != 0) { 
				ESFSportType tipoSport = ESFSportTypeLocalServiceUtil.getESFSportType(idSpecialita);
				String specialita = tipoSport.getName();
				dq.add(RestrictionsFactoryUtil.eq("Direttori.primaryKey.Specialita", specialita)); 
				
				//DA LEVARE
				_log.debug(String.format("Specialita nome: [%s]\n", specialita));
			}
		
			//Eseguo la query
			listaNomine = VW_DatiDrettoreTiroLocalServiceUtil.dynamicQuery(dq); 
			
			//Ordino la lista
			List<VW_NomineDirettoriTiro> listaModificabile = new ArrayList<>(listaNomine);
			Collections.sort(listaModificabile, new CompareByData());
			int elementiTrovati = listaNomine.size();
			
			//Valorizzo i campi e ritorno alla pagina 
			request.setAttribute("listaNomine", listaModificabile);
			String messaggio = String.format("La ricerca ha prodotto %s risultati", elementiTrovati);
			_log.debug(messaggio);
			SessionMessages.add(request, "success-message"); 
			request.setAttribute("successMessage", messaggio);
			
			//DA CANCELLARE
			_log.debug(String.format("Elementi nella lista: [%s]\n", elementiTrovati));
			_log.debug(String.format("Elementi nella lista modificabile: [%s]\n", listaModificabile.size()));
			
			//Se c'è bisogno valorizzare i campi del search container
			if(delta != 0) { response.setRenderParameter("delta", String.valueOf(delta)); }
			if(paginaRicercaCorrente != 0) { response.setRenderParameter("cur", String.valueOf(paginaRicercaCorrente)); }
			
		} catch (Exception e) {
			
			//Mando un messaggio di errore alla jsp
			SessionErrors.add(request, "error-ricerca");
			
		} finally {
			
			//Qualunque cosa succeda ritorna alla pagina chiamante con questi campi valorizzati
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			response.setRenderParameter("jspPage", "/html/esfshootingdirector/view.jsp");
			response.setRenderParameter("lastname", cognome);
			response.setRenderParameter("firstname", nome);
			response.setRenderParameter("card", tessera);
			response.setRenderParameter("regionId", regione);
			response.setRenderParameter("qualifica", String.valueOf(idQualifica));
			response.setRenderParameter("specialita", String.valueOf(idSpecialita)); 
			
		}
	}
	
	
	/**
	 * Action che ritorna alla jsp la lista dei tiratori tesserati 
	 * @param request
	 * @param response
	 * @return una lista alla jsp di oggetti VM_TiratoriTesserati 
	 */
	@ProcessAction(name="cercaTiratoriTesserati")
	public void cercaTiratoriTesserati(ActionRequest request, ActionResponse response) {
		
		//Prendo quello che mi serve dalla jsp
		String cognome = ParamUtil.getString(request, "lastname");
		String nome = ParamUtil.getString(request, "firstname");
		String tessera = ParamUtil.getString(request, "card");
		int delta = ParamUtil.getInteger(request, "delta", 0);
		int paginaRicercaCorrente = ParamUtil.getInteger(request, "cur", 0); 
		
		try { 
  			
 			//Inizializzo la lista
			List<VM_TiratoriTesserati> listaTiratori = new ArrayList<>();
		
			//Creo la DynamicQuery e effettuo i controlli sulle variabili
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(VM_TiratoriTesserati.class, "Tiratori", PortletClassLoaderUtil.getClassLoader());
			
			//Restringo la ricerca se vengono valorizzati i campi
			if(!cognome.isEmpty()) { dq.add(RestrictionsFactoryUtil.eq("Tiratori.primaryKey.Cognome", cognome)); }
			if(!nome.isEmpty()) { dq.add(RestrictionsFactoryUtil.eq("Tiratori.primaryKey.Nome", nome)); } 
			if(!tessera.isEmpty()) { dq.add(RestrictionsFactoryUtil.eq("Tiratori.primaryKey.CodiceTessera", tessera)); }
		
			//Eseguo la query
			listaTiratori = VM_TiratoriTesseratiLocalServiceUtil.dynamicQuery(dq);
			
			//Ordino la lista
			List<VM_TiratoriTesserati> listaModificabile = new ArrayList<>(listaTiratori);
			Collections.sort(listaModificabile, new CompareByNomeCognome());
			
			//Valorizzo i campi e ritorno alla pagina 
			request.setAttribute("listaTiratori", listaModificabile);
			
			//Se c'è bisogno valorizzare i campi del search container
			if(delta != 0) { response.setRenderParameter("delta", String.valueOf(delta)); }
			if(paginaRicercaCorrente != 0) { response.setRenderParameter("cur", String.valueOf(paginaRicercaCorrente)); }
			
			
		} catch (SystemException e) {  
			
			//Mando un messaggio di errore alla jsp
			SessionErrors.add(request, "error-ricerca");
			
		} finally {
			
			//Qualunque cosa succeda ritorna alla pagina chiamante con questi campi valorizzati
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			response.setRenderParameter("jspPage", "/html/esfshootingdirector/newShootingDirector.jsp");
			response.setRenderParameter("lastname", cognome);
			response.setRenderParameter("firstname", nome);
			response.setRenderParameter("card", tessera);
			
		}  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Funzione che aggiunge un nuovo direttore di tiro (viene chiamata da shootingDirectorInfo.jsp)
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void addShooterDirector (ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException {
		
		//Prendi l'oggetto ThemeDisplay
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//Definisci il formato della data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Prendi l'oggetto calendario
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		
		//Inizializzazione variabili
		ESFUser user = new ESFUserImpl(); 
		List<ESFAddress> esfAddresses = new ArrayList<ESFAddress>();
		ESFShootingDirector shDts = new ESFShootingDirectorImpl();
		ESFShootingDirector newShDts = new ESFShootingDirectorImpl();
		
		//Prendi l'id utente
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		//Prendi l'id del direttore di tiro
		long shDtId = ParamUtil.getLong(actionRequest, "shDtId");
		//Prendi l'id della specialità
		long stId = ParamUtil.getLong(actionRequest, "stId");
		
		//Prendi la data di inizio 
		String startDateS = ParamUtil.getString(actionRequest, "startDate");
		
		//Inizializza id regione e id province
		String regionId = "";
		String provinceId = "";
		
		//Prendi la url dell'mvcPath
		String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		
		//Inizializza data
		Date startDate = null;
		
		try {
			//Prova a fare il parsing della data
			startDate = ManageDate.StringToDate(startDateS);
		}
		catch (ParseException e1) {
			//Se viene generata un'eccezione per il parse allora rilancia una PortalException
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		
		//Trova il direttore di tiro attraverso l'id dell'utente selezionato, l'id del Direttore di tiro e l'id delle specialità
		shDts = ESFShootingDirectorLocalServiceUtil.findedShDr(esfUserId, shDtId, stId);
		

		//Se non esiste un direttore di tiro con queste credenziali
		if(Validator.isNotNull(shDts)){
			//Esci dalla funzione e ritorna alla pagina corrente generando un messaggio di errore
			actionResponse.setRenderParameter("mvcPath", mvcPath); 
			actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId)); 
			SessionErrors.add(actionRequest, "findingOld"); 
			return ;
		}
		//Altrimenti non esiste un direttore di tiro con quelle credenziali...quindi
		
		//Trova l'utente selezionato
		user = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);
		
		//Trova l'indirizzo collegato all'utente selezionato
		esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), ESFUser.class.getName(), esfUserId);
		
		//Se la lista non è vuota...
		if(!esfAddresses.isEmpty()){
			//Se l'id della regione del primo elemento nella lista non è null
			if(Validator.isNotNull(esfAddresses.get(0).getEsfRegionId())){
				//Prendi l'id della regione
				regionId = esfAddresses.get(0).getEsfRegionId();
			}
			//Se l'id della provincia del primo elemento nella lista non è null
			if(Validator.isNotNull(esfAddresses.get(0).getEsfProvinceId())){
				//Prendi l'id della provincia
				provinceId = esfAddresses.get(0).getEsfProvinceId();
			}
		}
		
		//Incrementa il contatore della chiave dell'entità dei Direttori di Tiro
		long esfshDtId = CounterLocalServiceUtil.increment(ESFShootingDirector.class.getName());
		
		//Imposta i campi del nuovo Direttore di Tiro con quelli dell'utente selezionato
		newShDts.setEsfShootingDirectorId(esfshDtId);
		newShDts.setEsfStartData(startDate);
		newShDts.setEsfUserId(esfUserId);
		newShDts.setProvinceId(provinceId);
		newShDts.setRegionId(regionId);
		newShDts.setSportTypeId(stId);
		newShDts.setShootingDirectorQualificationId(shDtId);
		
		//Aggiungi il nuovo Direttore di Tiro
		ESFShootingDirectorLocalServiceUtil.updateESFShootingDirector(newShDts);
		
		//Torna alla pagina principale
		actionResponse.setRenderParameter("mvcPath", "/html/esfshootingdirector/view.jsp");
		actionRequest.setAttribute("IdDirettoreAssegnato", String.valueOf(esfshDtId));
		
		//Messaggio di successo
		String messaggio = "La nomina è stata aggiunta con successo";
		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(actionRequest, "success-message");
		actionRequest.setAttribute("successMessage", messaggio);
		
	}
	
	/**
	 * Elimina un Direttore di Tiro (viene chiamata dalla pagina shootingDirectorInfo.jsp)
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void deleteESFShdr (ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {
		
		//Inizializza l'oggetto shooting director
		ESFShootingDirector shDt = new ESFShootingDirectorImpl();
		//Prendi id del direttore di tiro
		long shDrId = ParamUtil.getLong(actionRequest, "shDrId");
		//Prendi l'id dell'utente
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		//Prendi l'mvcPath
		String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		
		//Se l'url è vuota
		if(StringPool.BLANK.equals(mvcPath)){
			//Imposta l'url con la pagina principale + namespace
			mvcPath = "/html/esfshootingdirector/view.jsp";
		}
		
		//Se l'id del direttore di tiro è minore di 0
		if(0 < shDrId){
			//Trova il direttore di tiro attraverso l'id
			shDt = ESFShootingDirectorLocalServiceUtil.fetchESFShootingDirector(shDrId);
			//Elimina il direttore di tiro
			ESFShootingDirectorLocalServiceUtil.deleteESFShootingDirector(shDt);
		}else {
			//Altrimenti manda un messaggio di errore
			SessionErrors.add(actionRequest, "error-delete-shDr");
		}
		
		actionResponse.setRenderParameter("esfUserId",String.valueOf(esfUserId) );
		
		//Va alla pagina principale
		actionResponse.setRenderParameter("mvcPath", mvcPath);
	}
	
	public void updateSuspensive (ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException {
		
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfSuspensionId = ParamUtil.getLong(request, "esfSuspensionId");
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		
		ESFSuspensiveShootingDirector suspensive = new ESFSuspensiveShootingDirectorImpl();
		
		String sd = ParamUtil.getString(request, "startDate");
		String ed = ParamUtil.getString(request, "endDate");
		String note = ParamUtil.getString(request, "note");
		
		long suspensiveCode =  ParamUtil.getLong(request, "suspensiveCode");
		
		String[] valuesInstructsSospensions = ParamUtil.getParameterValues(request, "valuesInstructsSospensions", new String[0]);
		String[] valuesMatchSospensions = ParamUtil.getParameterValues(request, "valuesMatchSospensions", new String[0]);
		
		try {
			if(0 < esfSuspensionId){
				suspensive = ESFSuspensiveShootingDirectorLocalServiceUtil.fetchESFSuspensiveShootingDirector(esfSuspensionId);
				
				suspensive.setQualif1_Utiliz(0);
				suspensive.setQualif2_Utiliz(0);
				suspensive.setQualif3_Utiliz(0);
				
				suspensive.setTipo_Gara1_noUtil(0);
				suspensive.setTipo_Gara2_noUtil(0);
				suspensive.setTipo_Gara3_noUtil(0);
				suspensive.setTipo_Gara4_noUtil(0);
				suspensive.setTipo_Gara5_noUtil(0);
				suspensive.setTipo_Gara6_noUtil(0);
				suspensive.setTipo_Gara7_noUtil(0);
				suspensive.setTipo_Gara8_noUtil(0);
				suspensive.setTipo_Gara9_noUtil(0);
				suspensive.setTipo_Gara10_noUtil(0);
				
				if( 1 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
				}else if(2 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
				}else if(3 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
					suspensive.setQualif3_Utiliz(Long.valueOf(valuesInstructsSospensions[2]));
				}
				
				
				if( 1 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
				}else if(2 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					
				}else if(3 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					
				}else if(4 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					
				}else if(5 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					
				}else if(6 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					
				}else if(7 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					
				}else if(8 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					
				}else if(9 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
				}else if(10 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
					suspensive.setTipo_Gara10_noUtil(Long.valueOf(valuesMatchSospensions[9]));
				}
				
				suspensive.setNote(note);
				suspensive.setCodice_Sosp(suspensiveCode);
				suspensive.setEsfUserId(esfUserId);
				suspensive.setEsfStartData(ManageDate.StringToDate(sd));
				suspensive.setEsfEndData(ManageDate.StringToDate(ed));
				
				ESFSuspensiveShootingDirectorLocalServiceUtil.updateESFSuspensiveShootingDirector(suspensive);
			}else{
				long esfsuspId = CounterLocalServiceUtil.increment(ESFSuspensiveShootingDirector.class.getName());
				
				if( 1 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
				}else if(2 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
				}else if(3 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
					suspensive.setQualif3_Utiliz(Long.valueOf(valuesInstructsSospensions[2]));
				}
				
				
				if( 1 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
				}else if(2 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					
				}else if(3 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					
				}else if(4 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					
				}else if(5 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					
				}else if(6 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					
				}else if(7 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					
				}else if(8 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					
				}else if(9 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
				}else if(10 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
					suspensive.setTipo_Gara10_noUtil(Long.valueOf(valuesMatchSospensions[9]));
				}
				
				suspensive.setNote(note);
				suspensive.setCodice_Sosp(suspensiveCode);
				suspensive.setEsfUserId(esfUserId);
				suspensive.setEsfStartData(ManageDate.StringToDate(sd));
				suspensive.setEsfEndData(ManageDate.StringToDate(ed));
				suspensive.setEsfSuspensiveShooingDirectorId(esfsuspId);
				ESFSuspensiveShootingDirectorLocalServiceUtil.addESFSuspensiveShootingDirector(suspensive);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "error-updateSuspensive");
		}
		
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId) );
		response.setRenderParameter("mvcPath", mvcPath);
		
	}
	
	/**
	 * Elimina la sospensione selezionata del tiratore scelto
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void deleteSospensive (ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException {
		
		//Prendi l'id del tiratore selezionato
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		
		//Prendi l'id della sospensione selezionata
		long esfSuspensionId = ParamUtil.getLong(request, "esfSuspensionId");
		
		//Prendi l'mvcPath
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		
		ESFSuspensiveShootingDirector suspensive = new ESFSuspensiveShootingDirectorImpl();
		
		try {
			//Prova a prendere l'istanza che rappresenta la sospensione desiderata
			suspensive = ESFSuspensiveShootingDirectorLocalServiceUtil.fetchESFSuspensiveShootingDirector(esfSuspensionId);
			
			//Elimina la sospensione
			ESFSuspensiveShootingDirectorLocalServiceUtil.deleteESFSuspensiveShootingDirector(suspensive);
		}
		catch (Exception e) {
			//Se va male manda un errore alla jsp
			SessionErrors.add(request, "error-deleteSospensive");
		}
		
		//Da ricontrollare
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId) );
		
		//Vai a shootingDirectorInfo.jsp
		response.setRenderParameter("mvcPath", mvcPath);
		
	}
	
	public void addShootingDirectorToMatch (ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException {
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ESFPartecipant.class.getName(), request);
			
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		long userId = themeDisplay.getUserId();
		String userName = themeDisplay.getUser().getScreenName();
		long groupId = user.getGroupId();
		long companyId = user.getCompanyId();
		

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfTeamId = ParamUtil.getLong(request, "esfTeamId");
		long ct = ParamUtil.getLong(request, "ct");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		Date now = new Date();
		Date matchDate = null;
		int suspensiveNum = 0;
		
		ESFMatch match = new ESFMatchImpl();
		
		try {
			match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
			matchDate = match.getStartDate();
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.error("errore nel match");
		}
		
		ESFNationalDelegation del = new ESFNationalDelegationImpl();
		long delId = CounterLocalServiceUtil.increment(ESFNationalDelegation.class.getName());
		
		try {
			
			suspensiveNum = ESFSuspensiveShootingDirectorLocalServiceUtil.findSuspensive(matchDate, esfUserId);

			if(0 < suspensiveNum){
				
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				response.setRenderParameter("mvcPath", "/html/esfshootingdirector/convocations.jsp");
				SessionErrors.add(request, "find-Suspensive");
				return;
			}
			
			del.setEsfNationalDelgationId(delId);
			
			del.setCompanyId(companyId);
			del.setGroupId(groupId);
			del.setUserName(userName);
			del.setUserId(userId);
			del.setCreateDate(now);
			
			del.setEsfUserId(esfUserId);
			del.setEsfMatchId(esfMatchId);
			del.setEsfPartecipantTypeId(esfPartecipantTypeId);
			del.setNominationDate(now);
			
			ESFNationalDelegationLocalServiceUtil.addESFNationalDelegation(del);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "error-assign-director");
		}

		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("mvcPath", "/html/esfshootingdirector/convocations.jsp");
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFShootingDirectorPortlet.class);
}
