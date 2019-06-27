package it.ethica.esf.portlet.raduni;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.el.util.Validation;

import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

import it.ethica.esf.NoSuchRadunoAzzurriException;
import it.ethica.esf.NoSuchRadunoException;
import it.ethica.esf.NoSuchVW_AzzurriException;
import it.ethica.esf.NoSuchVW_ShootersException;
import it.ethica.esf.NoSuchVW_StaffException;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFRaduno;
import it.ethica.esf.model.ESFRadunoAzzurri;
import it.ethica.esf.model.ESFRadunoFiles;
import it.ethica.esf.model.ESFRadunoSottotipiRaduno;
import it.ethica.esf.model.ESFRadunoSottotipo;
import it.ethica.esf.model.ESFRadunoStaff;
import it.ethica.esf.model.ESFRadunoTipo;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.EsfRadunoShooters;
import it.ethica.esf.model.VW_Azzurri;
import it.ethica.esf.model.VW_Shooters;
import it.ethica.esf.model.VW_Staff;
import it.ethica.esf.model.impl.ESFRadunoAzzurriImpl;
import it.ethica.esf.model.impl.ESFRadunoFilesImpl;
import it.ethica.esf.model.impl.ESFRadunoImpl;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoFilesLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoSottotipiRadunoLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoStaffLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoTipoLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.EsfRadunoShootersLocalServiceUtil;
import it.ethica.esf.service.VW_AzzurriLocalService;
import it.ethica.esf.service.VW_AzzurriLocalServiceUtil;
import it.ethica.esf.service.VW_ShootersLocalServiceUtil;
import it.ethica.esf.service.VW_StaffLocalServiceUtil;
import it.ethica.esf.util.DateUtilFormatter;
import it.ethica.esf.util.MissingDateException;

/**
 * Portlet implementation class ESFRaduni
 */
public class ESFRaduni extends MVCPortlet {
	/**
	 * 
	 * Funzione che inizializza i Tipi di raduno
	 * carica i dati da DB
	 * @return
	 * @throws SystemException 
	 */
	private List<ESFRadunoTipo> trovaTipiRaduno() throws SystemException {
		try {
			return ESFRadunoTipoLocalServiceUtil.findAllTipi();
		} catch ( SystemException se ) {
		// se va male...
			System.out.println("ERRORE : Non è stato possibile terminare l'azione di ricerca di TUTTI i RADUNI");
			throw se;
		}
	}
	
	/**
	 * 
	 * Funzione che carica da DB tutti i sotto tipi Raduno
	 * @return
	 * @throws SystemException 
	 */
	public List<ESFRadunoSottotipo> trovaSottoTipiRaduno() throws SystemException{
		
		try{
			return ESFRadunoSottotipiRadunoLocalServiceUtil.findAllSottoTipi();
		} catch ( SystemException se ) {
		// se va male...
			System.out.println("ERRORE : Non è stato possibile terminare l'azione di ricerca di TUTTI i SOTTO TIPI RADUNO");
			throw se;
		}
			
	}	
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		//System.out.println("########################## RENDER ################################]");
		super.render(request, response);
	}


	/**
	 * Funzione di risposta al bottone "ricerca" nella View principale
	 * carica dalla Request i parametri del codice raduno, la data di inizio e la tipologia del raduno
	 * Restituisce una lista di oggetti ESFRaduno e la mette nella request
	 * @param request
	 * @param response
	 * @throws SystemException 
	 */
	@SuppressWarnings("unchecked")
	@ProcessAction(name="ricercaRaduni")
	public void ricercaRaduni(ActionRequest request, ActionResponse response) {
		
		try{
			request.setAttribute("listaTipiRaduno", trovaTipiRaduno());
			request.setAttribute("listaSottoTipiRaduno", trovaSottoTipiRaduno());
			
			String code = ParamUtil.getString(request, "code",null);
			Date startDate = ParamUtil.getDate(request, "startDate", DateUtilFormatter.getDefaultFormatter(), null);
			long esfTipoRaduno = ParamUtil.getLong(request, "esfTipoRaduno");
			
			List<ESFRaduno> listaRaduno = new ArrayList<ESFRaduno>();
			// TODO RIMUOVERE LE PRINTLN
			System.out.println("Codice: [" + code + "]");
			System.out.println("Data Inizio: [" + startDate + "]");
			System.out.println("Tipo Raduno id: [" + esfTipoRaduno + "]");
			//System.out.println("Nazione id: [" + esfCountryId + "]");
			
			
			// CREO la DynamicQuery aggiungendo condizioni a seconda se i campi sono vuoti o sono valorizzati
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(ESFRaduno.class, "Raduno", PortletClassLoaderUtil.getClassLoader());
			if (!code.isEmpty())
				dq.add(RestrictionsFactoryUtil.eq("Raduno.codice", code));
			
			if(startDate != null)
				dq.add(RestrictionsFactoryUtil.eq("Raduno.data_inizio", startDate));
				
			if(esfTipoRaduno!=0)
				dq.add(RestrictionsFactoryUtil.eq("Raduno.tipo_raduno", esfTipoRaduno));
			listaRaduno = ESFRadunoLocalServiceUtil.dynamicQuery(dq);
				
			request.setAttribute("listaRaduno", listaRaduno);
			String successMessage = "la ricerca ha prodotto " + listaRaduno.size() + " Risultati";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", successMessage);
			
			// TODO RIMUOVERE LE PRINTLN
//			for(ESFRaduno raduno : listaRaduno){
//				System.out.println("Codice: [" + raduno.getCodice() + "] - INIZIO: [" + raduno.getData_inizio()  + "]");
//			}

		} catch ( SystemException se ) {
			String errorInsertMessage = "";

		// se va male...
			System.out.println("!!!!!!!   ERRORE : Non è stato possibile terminare l'azione di ASSEGNAZIONE DI ATTRIBUTO ALLA REQUEST !!!!!!!!!!");
			SessionMessages.add(request, "errorInsert");
			request.setAttribute("errorInsertMessage", errorInsertMessage);
		}
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@ProcessAction(name="ricercaAzzurri")
	public void ricercaAzzurri(ActionRequest request, ActionResponse response) {
		System.out.println("################# RICERCA AZZURRI #####################");
		
		long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno");
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name","");
		Date startDate = ParamUtil.getDate(request, "startDate", DateUtilFormatter.getDefaultFormatter(), null);
		long esfSportType = ParamUtil.getLong(request, "esfSportType",0);
		long esfListaInvitati = ParamUtil.getLong(request, "esfListaInvitati",0);
		int delta = ParamUtil.getInteger(request, "delta",0);
		int cur = ParamUtil.getInteger(request, "cur",0);
		
//		System.out.println("[" + id_esf_raduno + "]");
//		System.out.println("[" + code + "]");
//		System.out.println("[" + name + "]");
//		System.out.println("[" + startDate + "]");
//		System.out.println("[" + esfSportType + "]");
//		System.out.println("[" + esfListaInvitati + "]");
//		System.out.println("delta : [" + delta + "]");
//		System.out.println("cur : [" + cur + "]");
		
	
		try {
			
			// PRENDO LA LISTA DEGLI INVITATI
			List<ESFRadunoAzzurri> listaInvitatiRaduno = ESFRadunoAzzurriLocalServiceUtil.findById(id_esf_raduno);
			List<Long> listaIdInvitati = new ArrayList<>(); 
			
			// TRASFERISCO I VALORI NELLA LISTA DI LONG
			for(ESFRadunoAzzurri ra : listaInvitatiRaduno){
				listaIdInvitati.add(ra.getEsfNationalId());
			}
			
			// CREO LA DYNAMIC QUERY E INSERISCO LE CONDIZIONI
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(VW_Azzurri.class, "Azzurri", PortletClassLoaderUtil.getClassLoader());
			if (!name.isEmpty())
				dq.add(RestrictionsFactoryUtil.like("Azzurri.userName", "%" + name + "%"));
			
			if(startDate != null)
				dq.add(RestrictionsFactoryUtil.ge("Azzurri.startDate", startDate));
				
			if(esfSportType!=0)
				dq.add(RestrictionsFactoryUtil.eq("Azzurri.primaryKey.esfSportTypeId", esfSportType));
			
			
			// VALORIZZO LA LISTA DEI NAZIONALI CON LE CONDIZIONI DELLA QUERY
			//List<VW_Azzurri> listaAzzurri = new ArrayList<>(VW_AzzurriLocalServiceUtil.dynamicQuery(dq));
			// CREO LA LISTA DEGLI AZZURRI
			List<VW_Azzurri> listaAzzurri = new ArrayList<>();
			// PRENDO IL RISULTATO DELLA QUERY
			List<VW_Azzurri> listaAzzurriCompleta = VW_AzzurriLocalServiceUtil.dynamicQuery(dq);
			
			// COPIO GLI ELEMENTI NELLA LISTA FINALE
			int contatore = 0;
			while(contatore < listaAzzurriCompleta.size()){
				VW_Azzurri current = listaAzzurriCompleta.get(contatore);
				
				// VEDO SE IL TIRATORE E' STATO INVITATO E SETTO LA VARIABILE A 1
				if(listaIdInvitati.contains(current.getEsfNationalId())){
					current.setInvitato(1);
					//System.out.println("[ID: " + listaAzzurri.get(contatore).getEsfNationalId() + " - NOME: " + listaAzzurri.get(contatore).getUserName() + " - invitato]" + listaAzzurri.get(contatore).getInvitato());
					//System.out.println("[INSERISCO 1: " + listaAzzurri.get(contatore).getEsfNationalId() + "]");
				}
				
				// CONTROLLO IL CAMPO DI RICERCA ---/INVITATI/NON INVITATI
				// INSERISCO TUTTI, INVITATI E NON INVITATI
				if(esfListaInvitati==0)
					listaAzzurri.add(current);
				// INSERISCO SOLO GLI INVITATI
				else if (esfListaInvitati==2){
					if(current.getInvitato()==1){
						listaAzzurri.add(current);
						}
				} 
				// INSERISCO SOLO I NON INVITATI
				else if(current.getInvitato()==0){
					listaAzzurri.add(current);					
				}
				contatore++;
			}
			
			// MESSAGGIO
			String msg = "La ricerca ha prodotto '" + listaAzzurri.size()  + "' risultati!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", msg);
			
			String goToURL = "/html/esfraduni/managementAzzurri.jsp";
			request.setAttribute("listaNazionali", listaAzzurri);
			response.setRenderParameter("id_esf_raduno", String.valueOf(id_esf_raduno));
			response.setRenderParameter("code", code);
			response.setRenderParameter("name", name);
			if(startDate != null)
				response.setRenderParameter("startDate",  DateUtilFormatter.formatDate(startDate));
			response.setRenderParameter("esfSportType", String.valueOf(esfSportType));
			response.setRenderParameter("esfListaInvitati", String.valueOf(esfListaInvitati));

			response.setRenderParameter("esfSportType", String.valueOf(esfSportType));
			if (delta != 0)
				response.setRenderParameter("delta", String.valueOf(delta));
			if(cur != 0)
				response.setRenderParameter("cur", String.valueOf(cur));
			response.setRenderParameter("jspPage", goToURL);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	@ProcessAction(name="salvaAzzurriRaduno")
	public void salvaAzzurriRaduno(ActionRequest request, ActionResponse response) {
		System.out.println("################# SALVA AZZURRI RADUNO #####################");
		
		try {
			long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno");
			String code = ParamUtil.getString(request, "code");

			String[] parametri = ParamUtil.getParameterValues(request, "invitato", new String[0]);
			System.out.println("[LISTA COMPLETA " + ParamUtil.getString(request, "idListaMostrataAzzurri") + "]");

			String delimiter = "\\|";
			String[] ListaIdAzzurri = ParamUtil.getString(request, "idListaMostrataAzzurri").split(delimiter);
			
			
			List<String> listaChecked = new ArrayList<String>(Arrays.asList(parametri));
			List<String> listaUnchecked = new ArrayList<>();
			
			for(String elemento : ListaIdAzzurri){
				
				if(listaChecked.indexOf(elemento) == -1){
					listaUnchecked.add(elemento);
				}
				System.out.println("[LISTA COMPLETA ID: " + elemento + "]");
			}
			
			for(String elemento : listaChecked){
				System.out.println("[LISTA CHECKED ID: " + elemento + "]");
			}
			for(String elemento : listaUnchecked){
				System.out.println("[LISTA UNCHECKED ID: " + elemento + "]");
			}
			System.out.println("[" + id_esf_raduno + "]");
			System.out.println("[" + code + "]");

			ESFRadunoAzzurriLocalServiceUtil.associaAzzurri(id_esf_raduno, listaChecked, listaUnchecked);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	@ProcessAction(name="ricercaStaff")
	public void ricercaStaff(ActionRequest request, ActionResponse response) {
		System.out.println("################# RICERCA STAFF #####################");
		
		try {
			long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno");
			String code = ParamUtil.getString(request, "code");
			String name = ParamUtil.getString(request, "name","");
			String surname = ParamUtil.getString(request, "surname","");
			Date startDate = ParamUtil.getDate(request, "startDate", DateUtilFormatter.getDefaultFormatter(), null);
			long esfSportType = ParamUtil.getLong(request, "esfSportType",0);
			String esfShootingDirectorQualification = ParamUtil.getString(request, "esfShootingDirectorQualification","");
			long esfListaInvitati = ParamUtil.getLong(request, "esfListaInvitati",0);
			int delta = ParamUtil.getInteger(request, "delta",0);
			int cur = ParamUtil.getInteger(request, "cur",0);
			String goToURL = ParamUtil.getString(request, "mvcPath");

//			System.out.println("id raduno [" + id_esf_raduno + "]");
//			System.out.println("codice [" + code + "]");
//			System.out.println("nome [" + name + "]");
//			System.out.println("data inizio [" + startDate + "]");
//			System.out.println("qualifica [" + esfShootingDirectorQualification + "]");
//			System.out.println("id tipo sport [" + esfSportType + "]");
//			System.out.println("id lista invitati [" + esfListaInvitati + "]");

			List<ESFRadunoStaff> listaInvitatiStaff = ESFRadunoStaffLocalServiceUtil.findById(id_esf_raduno);
			List<Long> listaIdInvitati = new ArrayList<>(); 
			
			// TRASFERISCO I VALORI NELLA LISTA DI LONG
			for(ESFRadunoStaff rs : listaInvitatiStaff){
				listaIdInvitati.add(rs.getUserId());
			}
			
			// CREO LA DYNAMIC QUERY E INSERISCO LE CONDIZIONI
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(VW_Staff.class, "Staff", PortletClassLoaderUtil.getClassLoader());
			if (!name.isEmpty()){
				dq.add(RestrictionsFactoryUtil.like("Staff.firstName", StringPool.PERCENT + name + StringPool.PERCENT));
				System.out.println("Nome [" + name + "]");
				//dq.add(RestrictionsFactoryUtil.like("Staff.firstName", "%" + name + "%"));
				
//				System.out.println("Nome [" + name + "]");
//				dq.add(RestrictionsFactoryUtil.like("Staff.firstName", "%" + name + "%"));
//				dq.add(RestrictionsFactoryUtil.like("Staff.lastName", "%" + name + "%"));
			}
			if (!surname.isEmpty()){
				dq.add(RestrictionsFactoryUtil.like("Staff.lastName", StringPool.PERCENT + surname + StringPool.PERCENT));
				System.out.println("Cognome [" + surname + "]");
			}

			if(startDate != null){
				System.out.println("startDate [" + startDate + "]");
				dq.add(RestrictionsFactoryUtil.ge("Staff.esfStartData", startDate));
			}
			
			if(esfSportType!=0){
				System.out.println("esfSportType [" + esfSportType + "]");
				dq.add(RestrictionsFactoryUtil.eq("Staff.primaryKey.esfSportTypeId", esfSportType));
			}
			
			
			if (!esfShootingDirectorQualification.isEmpty()){
				System.out.println("esfShootingDirectorQualification [" + esfShootingDirectorQualification + "]");
				dq.add(RestrictionsFactoryUtil.eq("Staff.esfShootingDirectorQualificationDesc", esfShootingDirectorQualification));
			}
			
			List<VW_Staff> listaStaff = new ArrayList<>();
			// PRENDO IL RISULTATO DELLA QUERY
			List<VW_Staff> listaStaffCompleta = VW_StaffLocalServiceUtil.dynamicQuery(dq);
			
//			for(VW_Staff staff: listaStaffCompleta){
//				System.out.println("[ID: [" + staff.getUserId() + "] - NOME: [" + staff.getFirstName() + "] [" + staff.getLastName() + "]");
//			}
			
			// COPIO GLI ELEMENTI NELLA LISTA FINALE
			int contatore = 0;
			while(contatore < listaStaffCompleta.size()){
				VW_Staff current = listaStaffCompleta.get(contatore);
				
				
				
				// VEDO SE IL TIRATORE E' STATO INVITATO E SETTO LA VARIABILE A 1
				if(listaIdInvitati.contains(current.getUserId())){
					current.setInvitato(1);
				}
				
				// CONTROLLO IL CAMPO DI RICERCA ---/INVITATI/NON INVITATI
				// INSERISCO TUTTI, INVITATI E NON INVITATI
				if(esfListaInvitati==0)
					listaStaff.add(current);
				// INSERISCO SOLO GLI INVITATI
				else if (esfListaInvitati==2){
					if(current.getInvitato()==1){
						listaStaff.add(current);
						}
				} 
				// INSERISCO SOLO I NON INVITATI
				else if(current.getInvitato()==0){
					listaStaff.add(current);					
				}
				contatore++;
			}
			
			// MESSAGGIO
			String msg = "La ricerca ha prodotto '" + listaStaff.size()  + "' risultati!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", msg);			
			
			request.setAttribute("listaStaff", listaStaff);
			response.setRenderParameter("id_esf_raduno", String.valueOf(id_esf_raduno));
			response.setRenderParameter("code", code);
			response.setRenderParameter("name", name);
			response.setRenderParameter("surname", surname);
			if(startDate != null)
				response.setRenderParameter("startDate",  DateUtilFormatter.formatDate(startDate));
			// TODO Auto-generated catch block
			response.setRenderParameter("esfShootingDirectorQualification", esfShootingDirectorQualification);
			response.setRenderParameter("esfSportType", String.valueOf(esfSportType));
			response.setRenderParameter("esfListaInvitati", String.valueOf(esfListaInvitati));

			response.setRenderParameter("esfSportType", String.valueOf(esfSportType));
			if (delta != 0)
				response.setRenderParameter("delta", String.valueOf(delta));
			if(cur != 0)
				response.setRenderParameter("cur", String.valueOf(cur));
//			System.out.println("delta [" + delta + "]");
//			System.out.println("cur [" + cur + "]");
			
			response.setRenderParameter("jspPage", goToURL);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MissingDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@ProcessAction(name="salvaStaffRaduno")
	public void salvaStaffRaduno(ActionRequest request, ActionResponse response) {
		System.out.println("################# SALVA STAFF RADUNO #####################");

		
		try {
			long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno");
			String code = ParamUtil.getString(request, "code");

			String[] parametri = ParamUtil.getParameterValues(request, "invitato", new String[0]);
			System.out.println("[LISTA COMPLETA " + ParamUtil.getString(request, "idListaMostrataStaff") + "]");

			String delimiter = "\\|";
			String[] listaIdStaff = ParamUtil.getString(request, "idListaMostrataStaff").split(delimiter);
			
			
			List<String> listaChecked = new ArrayList<String>(Arrays.asList(parametri));
			List<String> listaUnchecked = new ArrayList<>();
			
			for(String elemento : listaIdStaff){
				
				if(listaChecked.indexOf(elemento) == -1){
					listaUnchecked.add(elemento);
				}
				System.out.println("LISTA COMPLETA ID: [" + elemento + "]");
			}
			
			for(String elemento : listaChecked){
				System.out.println("[LISTA CHECKED ID: " + elemento + "]");
			}
			for(String elemento : listaUnchecked){
				System.out.println("[LISTA UNCHECKED ID: " + elemento + "]");
			}
			System.out.println("[" + id_esf_raduno + "]");
			System.out.println("[" + code + "]");

			ESFRadunoStaffLocalServiceUtil.associaStaff(id_esf_raduno, listaChecked, listaUnchecked);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	@ProcessAction(name="ricercaShooters")
	public void ricercaShooters(ActionRequest request, ActionResponse response) {
		System.out.println("################# RICERCA SHOOTERS #####################");
		long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno");
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name","");
		String surname = ParamUtil.getString(request, "surname","");
		//Date birthDate = ParamUtil.getDate(request, "birth-date", DateUtilFormatter.getDefaultFormatter(), null);
		String numero_tessera = ParamUtil.getString(request, "numero_tessera","");
		long esfAssociation = ParamUtil.getLong(request, "esfAssociation",0);
		long esfListaInvitati = ParamUtil.getLong(request, "esfListaInvitati",0);
		int delta = ParamUtil.getInteger(request, "delta",0);
		int cur = ParamUtil.getInteger(request, "cur",0);
		String goToURL = ParamUtil.getString(request, "mvcPath");
		String msg = "";
		
		System.out.println("id raduno [" + id_esf_raduno + "]");
		System.out.println("codice [" + code + "]");
		System.out.println("nome [" + name + "]");
		System.out.println("surname [" + surname + "]");
		//System.out.println("data nascita [" + birthDate + "]");
		System.out.println("numero_tessera [" + numero_tessera + "]");
		System.out.println("esfAssociation [" + esfAssociation + "]");

		try {

			List<EsfRadunoShooters> listaInvitatiShooters;
			listaInvitatiShooters = EsfRadunoShootersLocalServiceUtil.getEsfRadunoShooterses(0, 2);

			List<Long> listaIdInvitati = new ArrayList<>(); 
			
			// TRASFERISCO I VALORI NELLA LISTA DI LONG
			for(EsfRadunoShooters rs : listaInvitatiShooters){
				listaIdInvitati.add(rs.getUserId());
			}
		
			// CREO LA DYNAMIC QUERY E INSERISCO LE CONDIZIONI
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(VW_Shooters.class, "Shooters", PortletClassLoaderUtil.getClassLoader());
			if (!name.isEmpty()){
				dq.add(RestrictionsFactoryUtil.like("Shooters.Nome", StringPool.PERCENT + name + StringPool.PERCENT));
				System.out.println("Nome [" + name + "]");
			}
			if (!surname.isEmpty()){
				dq.add(RestrictionsFactoryUtil.like("Shooters.Cognome", StringPool.PERCENT + surname + StringPool.PERCENT));
				System.out.println("Cognome [" + surname + "]");
			}
			if (!numero_tessera.isEmpty()){
				dq.add(RestrictionsFactoryUtil.eq("Shooters.CodiceTessera", numero_tessera));
				System.out.println("numero_tessera [" + numero_tessera + "]");
			}
			if(esfAssociation!=0){
				System.out.println("esfAssociation [" + esfAssociation + "]");
				dq.add(RestrictionsFactoryUtil.eq("Shooters.primaryKey.organizationId", esfAssociation));
			}
			
			List<VW_Shooters> listaShooters = new ArrayList<>();
			// PRENDO IL RISULTATO DELLA QUERY
			List<VW_Shooters> listaShootersCompleta = VW_ShootersLocalServiceUtil.dynamicQuery(dq);
			
			// COPIO GLI ELEMENTI NELLA LISTA FINALE
			int contatore = 0;
			while(contatore < listaShootersCompleta.size()){
				VW_Shooters current = listaShootersCompleta.get(contatore);
				
				// VEDO SE IL TIRATORE E' STATO INVITATO E SETTO LA VARIABILE A 1
				if(listaIdInvitati.contains(current.getUserId())){
					current.setInvitato(1);
				}
				
				// CONTROLLO IL CAMPO DI RICERCA ---/INVITATI/NON INVITATI
				// INSERISCO TUTTI, INVITATI E NON INVITATI
				if(esfListaInvitati==0)
					listaShooters.add(current);
				// INSERISCO SOLO GLI INVITATI
				else if (esfListaInvitati==2){
					if(current.getInvitato()==1){
						listaShooters.add(current);
						}
				} 
				// INSERISCO SOLO I NON INVITATI
				else if(current.getInvitato()==0){
					listaShooters.add(current);					
				}
				contatore++;
			}
			
			// MESSAGGIO
			msg = "La ricerca ha prodotto '" + listaShooters.size()  + "' risultati!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", msg);			
			response.setRenderParameter("jspPage", goToURL);

			request.setAttribute("listaShooters", listaShooters);

//			if(birthDate != null)
//				response.setRenderParameter("birthDate",  DateUtilFormatter.formatDate(birthDate));

			if (delta != 0)
				response.setRenderParameter("delta", String.valueOf(delta));
			if(cur != 0)
				response.setRenderParameter("cur", String.valueOf(cur));
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}finally {

			response.setRenderParameter("id_esf_raduno", String.valueOf(id_esf_raduno));
			response.setRenderParameter("code", code);
			response.setRenderParameter("name", name);
			response.setRenderParameter("surname", surname);
			// TODO Auto-generated catch block
			response.setRenderParameter("numero_tessera", numero_tessera);
			response.setRenderParameter("esfAssociation", String.valueOf(esfAssociation));
			response.setRenderParameter("esfListaInvitati", String.valueOf(esfListaInvitati));
		}

		
		
		
	}
	
	@ProcessAction(name="salvaShootersRaduno")
	public void salvaShootersRaduno(ActionRequest request, ActionResponse response) {
		System.out.println("################# SALVA SHOOTERS RADUNO #####################");

	}

	@ProcessAction(name="managementRaduno")
	public void managementRaduno(ActionRequest request, ActionResponse response) {
		System.out.println("################# MANAGEMENT RADUNO #####################");

		long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno");
		String code = ParamUtil.getString(request, "code");
		String goToURL = ParamUtil.getString(request, "mvcPath");
		List<VW_Azzurri> listaAzzurri = null;
		List<ESFRadunoAzzurri> listaAzzurriInvitati = null;
		List<VW_Staff> listaStaff = null;
		List<ESFRadunoStaff> listaStaffInvitati = null;
		List<VW_Shooters> listaShooters = null;
		List<EsfRadunoShooters> listaShootersInvitati = null;
		List<ESFRadunoFiles> listaFiles = null;
		
		
		try{
			response.setRenderParameter("jspPage", goToURL);
			
			listaAzzurri = new ArrayList<>();
			listaAzzurriInvitati = ESFRadunoAzzurriLocalServiceUtil.findById(id_esf_raduno);
			listaStaff = new ArrayList<>();
			listaStaffInvitati = ESFRadunoStaffLocalServiceUtil.findById(id_esf_raduno);
			listaShooters = new ArrayList<>();
			listaShootersInvitati = EsfRadunoShootersLocalServiceUtil.findById(id_esf_raduno);
			listaFiles = ESFRadunoFilesLocalServiceUtil.findByRaduno(id_esf_raduno);
			
			for(ESFRadunoAzzurri ra : listaAzzurriInvitati){
				VW_Azzurri invitato = VW_AzzurriLocalServiceUtil.cercaAzzurro(ra.getEsfNationalId());
				
				System.out.println("[Azzurri: " + ra.getEsfNationalId() + "]");
				
				listaAzzurri.add(invitato);
			}

			for(ESFRadunoStaff rs : listaStaffInvitati){
				VW_Staff invitato = VW_StaffLocalServiceUtil.cercaStaff(rs.getUserId());
				System.out.println("[Staff: " + rs.getUserId() + "]");
				
				listaStaff.add(invitato);
			}
			
			for(EsfRadunoShooters rsh : listaShootersInvitati){
				VW_Shooters invitato = VW_ShootersLocalServiceUtil.cercaShooter(id_esf_raduno);
				System.out.println("[Shooters: " + rsh.getUserId() + "]");
				listaShooters.add(invitato);
			}
			
			request.setAttribute("listaAzzurri", listaAzzurri);
			request.setAttribute("listaStaff", listaStaff);
			request.setAttribute("listaShooters", listaShooters);
			request.setAttribute("listaFiles", listaFiles);
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchVW_AzzurriException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchVW_StaffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchVW_ShootersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			response.setRenderParameter("id_esf_raduno", String.valueOf(id_esf_raduno));
			response.setRenderParameter("code", code);

		}
		
		
	}
	
	
	
//
//	/**
//	 * Funzione di risposta al bottone "ricerca" nella Popup delle Associazioni
//	 * carica dalla Request i parametri del codice raduno, la data di inizio e la tipologia del raduno
//	 * Restituisce una lista di oggetti ESFRaduno e la mette nella request
//	 * @param request
//	 * @param response
//	 */
//	@ProcessAction(name="ricercaAssociazioni")
//	public void ricercaAssociazioni(ActionRequest request, ActionResponse response) {
//		System.out.println("################# RICERCA ASSOCIAZIONI #####################");
//		
//		String goToURL = "/html/esfraduni/popup/chooseAssociation.jsp";
//		List<ESFOrganization> allOrganization = new ArrayList<ESFOrganization>();
//		
//		try {
//			ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//			long scopeGroupId = themeDisplay.getScopeGroupId();
//			Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
//			long currentOrganizationId = group.getOrganizationId();
////			ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
////			long esfOrganizationId = currentESFOrganization.getEsfOrganizationId();
//			
//			
//			allOrganization = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId,"","");
//			ListUtil.subList(allOrganization, 0, 5);
////			// TODO RIMUOVERE LE PRINTLN
////			for(ESFOrganization org : allOrganization){
////				System.out.println("Codice: [" + org.getCode() + "] - INIZIO: [" + org.getName()  + "]");
////			}
//			request.setAttribute("allOrganization", allOrganization);
//			response.setRenderParameter("jspPage", goToURL);
//
//			
//		} catch (PortalException | SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}	
//	
	

	/**
	 * Funzione di preparazione alla Form di inserimento di un nuovo raduno
	 * Si incarica di valorizzare i campi necessari nella form
	 * invocata tramite il bottone "Aggiungi Raduno" nella view principale
	 * @param request
	 * @param response
	 * @throws SystemException 
	 */
	public void creaNuovoRaduno(ActionRequest request, ActionResponse response) throws SystemException {
		// System.out.println("CREA NUOVO RADUNO");

		String goToURL = "/html/esfraduni/new_edit_esfRaduno.jsp";
		
		try{
			
			List<ESFRadunoSottotipo> listaSottoTipiRaduno = trovaSottoTipiRaduno(); 
			
			request.setAttribute("listaTipiRaduno", trovaTipiRaduno());
			List<KeyValuePair> listaSottoTipiDisponibili = new ArrayList<KeyValuePair>();
			List<KeyValuePair> listaSottoTipiScelti = new ArrayList<KeyValuePair>();
			
			for(ESFRadunoSottotipo sottoTipoRaduno : listaSottoTipiRaduno){
				listaSottoTipiDisponibili.add(new KeyValuePair(String.valueOf(sottoTipoRaduno.getId_esf_raduno_sottotipo()),
						sottoTipoRaduno.getDescrizione()));
			}
			
			request.setAttribute("listaSottoTipiDisponibili", listaSottoTipiDisponibili);
			request.setAttribute("listaSottoTipiScelti", listaSottoTipiScelti);
			
			
		} catch ( SystemException se ) {
		// se va male...
			System.out.println("!!!!!!!   ERRORE : Non è stato possibile terminare l'azione di ASSEGNAZIONE DI ATTRIBUTO ALLA REQUEST !!!!!!!!!!");
			throw se;
		}
		
		response.setRenderParameter("jspPage", goToURL);

	}

	
	private void inserisciRaduno(ESFRaduno esfRaduno, ActionRequest request, ActionResponse response) {
		
		System.out.println("#################   INSERT #####################");
		if (esfRaduno == null)
			return;
		
		String[] valoriSottoTipiScelti = ParamUtil.getParameterValues(request, "valoriSottoTipiScelti", new String[0]);
		String code = "";
		esfRaduno.setCodice(code);
		
		try {
			String successMessage = "";
			
			ESFRaduno esfSalvato = ESFRadunoLocalServiceUtil.inserisciRaduno(esfRaduno, valoriSottoTipiScelti);

			successMessage = "Il Raduno con codice " + esfSalvato.getCodice() + " è stato creato con successo!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", successMessage);
		} catch (SystemException | NoSuchRadunoException e) {
			String errorMessage = "";

			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionMessages.add(request, "errorMsg");
			request.setAttribute("errorMessage", errorMessage);
		}
		response.setRenderParameter("backURL", "/html/esfraduni/view.jsp");
		
	}
	
	private void updateRaduno(ESFRaduno esfRaduno, ActionRequest request, ActionResponse response) {
		System.out.println("#################   UPDATE #####################");

		if (esfRaduno == null)
			return;
		String[] valoriSottoTipiScelti = ParamUtil.getParameterValues(request, "valoriSottoTipiScelti", new String[0]);
		
		try {
			String successMessage = "";
			
			ESFRadunoLocalServiceUtil.aggiornaRaduno(esfRaduno, valoriSottoTipiScelti);
			
			successMessage = "Il Raduno con codice " + esfRaduno.getCodice() + " è stato modificato con successo!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", successMessage);
			
		} catch (SystemException | NoSuchRadunoException e) {
			String errorMessage = "";

			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionMessages.add(request, "errorMsg");
			request.setAttribute("errorMessage", errorMessage);
		}
		response.setRenderParameter("backURL", "/html/esfraduni/view.jsp");
		
	}
	
	
	/**
	 * Funzione di salvataggio di un nuovo raduno che raccoglie i dati dalla form di inserimento
	 * invocata dal bottone "Salva" della new_edit_esfRaduno.jsp
	 * @param request
	 * @param response
	 */
	@ProcessAction(name="salvaRaduno")
	public void salvaRaduno(ActionRequest request, ActionResponse response) {

		String idRaduno = ParamUtil.getString(request, "id_esf_raduno");
		ESFRadunoImpl esfRaduno = new ESFRadunoImpl();
		boolean bInsert = true;
		
		if(!idRaduno.isEmpty()){
			esfRaduno.setId_esf_raduno(Long.parseLong(idRaduno));
			esfRaduno.setCodice(request.getParameter("code"));
			bInsert = false;
		}
			
		
		Date startDate = ParamUtil.getDate(request, "startDate", DateUtilFormatter.getDefaultFormatter());
		Date endDate = ParamUtil.getDate(request, "endDate", DateUtilFormatter.getDefaultFormatter());
		long esfTipoRaduno = ParamUtil.getLong(request, "esfTipoRaduno");
		String notes = ParamUtil.getString(request, "notes");
		long esfAssociationId = ParamUtil.getLong(request, "esfAssociationId");
		String site = ParamUtil.getString(request, "site");

		esfRaduno.setData_inizio(startDate);
		esfRaduno.setData_fine(endDate);
		esfRaduno.setTipo_raduno(esfTipoRaduno);
		esfRaduno.setNote(notes);
		esfRaduno.setId_associazione_ospitante(esfAssociationId);
		esfRaduno.setAltra_sede_ospitante(site);
		
		if (bInsert){
			inserisciRaduno(esfRaduno, request, response);
		}else{
			updateRaduno(esfRaduno, request, response);
		}

	}

	@ProcessAction(name="deleteRaduno")
	public void deleteRaduno(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		System.out.println("#################   CANCELLA #####################");

		long id_esf_raduno = Long.parseLong(request.getParameter("idRaduno"));
		
		System.out.println("[" + request.getParameter("idRaduno") + "]");
		
		
		String msg = "";
		
		ESFRaduno radunoCancellato = ESFRadunoLocalServiceUtil.cancellaRaduno(id_esf_raduno);
		
		if (radunoCancellato != null){
			msg = "Il Raduno con Codice '" + radunoCancellato.getCodice() + "' è stato cancellato!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", msg);
		}else{
			msg = "Non è stato possibile cancellare Il Raduno !";
			SessionMessages.add(request, "errorMsg");
			request.setAttribute("errorMessage", msg);
		}
		
	}
	
	@ProcessAction(name="viewRaduno")
	public void viewRaduno(ActionRequest request, ActionResponse response){
		System.out.println("#################  MODIFICA #####################");
		
		
		// PARAMUTIL E' PIU' COMODO PERCHE' PERMETTE DI PRENDERE LE DATE IN UN SOLO PASSAGGIO 
		long id_esf_raduno = Long.parseLong(request.getParameter("idRaduno"));
		String code = request.getParameter("code");
		Date startDate = ParamUtil.getDate(request, "startDate", DateUtilFormatter.getDefaultFormatter());
		Date endDate = ParamUtil.getDate(request, "endDate", DateUtilFormatter.getDefaultFormatter());
		long idTipoRaduno = ParamUtil.getLong(request, "idTipoRaduno");
		String notes = ParamUtil.getString(request, "notes");
		long esfAssociationId = ParamUtil.getLong(request, "esfAssociationId");
		String site = ParamUtil.getString(request, "site");
		
		List<ESFRadunoSottotipiRaduno> listaRadunoSottotipiRaduno = new ArrayList<ESFRadunoSottotipiRaduno>();
		List<ESFRadunoSottotipo> listaSottoTipiRaduno = new ArrayList<ESFRadunoSottotipo>();;
		try {
			request.setAttribute("listaTipiRaduno", trovaTipiRaduno());
			// trovo tutti i sotto tipi
			listaSottoTipiRaduno = trovaSottoTipiRaduno();
			// trovo i sottotipi del raduno da modificare
			listaRadunoSottotipiRaduno = ESFRadunoSottotipiRadunoLocalServiceUtil.cercaSottotipiRaduno(id_esf_raduno);
			
			// creo le liste per la visualizzazione delle input-move-boxes
			List<KeyValuePair> listaSottoTipiDisponibili = new ArrayList<KeyValuePair>();
			List<KeyValuePair> listaSottoTipiScelti = new ArrayList<KeyValuePair>();
			HashMap<String, String> map = new HashMap<String, String>();
			
			// riempio la lista di sinisstra con i sottotipi disponibili
			for(ESFRadunoSottotipo sottoTipoRaduno : listaSottoTipiRaduno){
				map.put(String.valueOf(sottoTipoRaduno.getId_esf_raduno_sottotipo()), sottoTipoRaduno.getDescrizione());
			}
			
			for(ESFRadunoSottotipiRaduno radunoSottoTipoRaduno : listaRadunoSottotipiRaduno){

				long indice = radunoSottoTipoRaduno.getId_esf_raduno_sottotipo();
				listaSottoTipiScelti.add(new KeyValuePair(String.valueOf(indice), map.get(String.valueOf(indice))));
				map.remove(String.valueOf(indice));
			}
			
			for(Map.Entry<String, String> entry : map.entrySet()) {
				listaSottoTipiDisponibili.add(new KeyValuePair(entry.getKey(), entry.getValue()));
			}
			
			ESFOrganization associazione = null;
			if(esfAssociationId!=0)
				associazione = ESFOrganizationLocalServiceUtil.getESFOrganization(esfAssociationId);
			
			request.setAttribute("associazione", associazione);
			request.setAttribute("listaSottoTipiDisponibili", listaSottoTipiDisponibili);
			request.setAttribute("listaSottoTipiScelti", listaSottoTipiScelti);

		
		} catch (SystemException | PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		ESFRadunoImpl esfRadunoEdit = new ESFRadunoImpl();
		
		esfRadunoEdit.setId_esf_raduno(id_esf_raduno);
		esfRadunoEdit.setCodice(code);
		esfRadunoEdit.setData_inizio(startDate);
		esfRadunoEdit.setData_fine(endDate);
		esfRadunoEdit.setTipo_raduno(idTipoRaduno);
		esfRadunoEdit.setNote(notes);
		esfRadunoEdit.setId_associazione_ospitante(esfAssociationId);
		esfRadunoEdit.setAltra_sede_ospitante(site);
		
		request.setAttribute("radunoEdit", esfRadunoEdit);
		String goToURL = "/html/esfraduni/new_edit_esfRaduno.jsp";
		response.setRenderParameter("jspPage", goToURL);
		
	}
	
	

	public void backToSearch(ActionRequest request, ActionResponse response) {
		System.out.println("#################   ANNULLA ######################");
		response.setRenderParameter("jspPage", "/html/esfraduni/view.jsp");
	}

	
	/**
	 * Funzione che trasferisce un File sul Server
	 * Prende in ingresso dalla uploadRequest sia l'i del raduno, che il suo codice
	 * Scrive inoltre nel DB i dati del file trasferito
	 * @param request
	 * @param response
	 */
	@ProcessAction(name="uploadDocument")
	public void uploadDocument(ActionRequest request, ActionResponse response){
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		
		if (uploadRequest == null)
			return;

		try {
			String id_esf_raduno = uploadRequest.getParameter("id_esf_raduno");
			String code = uploadRequest.getParameter("code");
			System.out.println("################# UPLOAD DA " + id_esf_raduno + " ######################");
			
			String paramName = "uploadedFile";
			

			if (uploadRequest.getSize(paramName) == 0) {
				return ;
			}
			
			
			File uploadedFile = uploadRequest.getFile(paramName);
			//String sourceFileName = uploadedFile.getName();
			String nomeOriginale = uploadRequest.getFileName(paramName);

			String dir = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
					"raduni_document" + File.separator + id_esf_raduno;
			
			File folder = new File(dir);
			File filePath = new File(folder.getAbsolutePath() + File.separator + nomeOriginale);
			
			FileUtils.copyFile(uploadedFile, filePath);
			
			
			String msg = "Il File '" + nomeOriginale	 + "' è stato Uplodato!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", msg);
			
			
			ESFRadunoFiles rf = new ESFRadunoFilesImpl();
			
			rf.setId_esf_raduno(Long.parseLong(id_esf_raduno));
			rf.setNome(nomeOriginale);
			rf.setPath(filePath.toString());
			
			ESFRadunoFilesLocalServiceUtil.addESFRadunoFiles(rf);
			
			String goToURL = "/html/esfraduni/upload/uploadFileRaduno.jsp";
			response.setRenderParameter("id_esf_raduno", id_esf_raduno);
			response.setRenderParameter("code", code);
			response.setRenderParameter("jspPage", goToURL);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Funzione che cancella il file associato al raduno, sia dal server che dal database
	 * Prende in ingresso dalla request l'id della tabella dei files associati ai raduni
	 * @param request
	 * @param response
	 */
	@ProcessAction(name="deleteFileDocumentRaduno")
	public void deleteFileDocumentRaduno(ActionRequest request, ActionResponse response){
		System.out.println("################# CANCELLA FILE #####################");

		long id_esf_raduno_files = Long.parseLong(request.getParameter("idFileRaduno"));	

		try {
			ESFRadunoFiles fileCancellato = ESFRadunoFilesLocalServiceUtil.deleteESFRadunoFiles(id_esf_raduno_files);
			
			if(fileCancellato == null)
				return;
			
			long id_esf_raduno = fileCancellato.getId_esf_raduno();
			File file = FileUtils.getFile(fileCancellato.getPath());
			
			if(file == null)
				return;

			FileUtils.deleteQuietly(file);
			ESFRaduno raduno = ESFRadunoLocalServiceUtil.findById(id_esf_raduno);
			String msg = "Il File '" + fileCancellato.getNome()	 + "' è stato Cancellato!";
			SessionMessages.add(request, "addSuccess");
			request.setAttribute("successMessage", msg);
			String goToURL = "/html/esfraduni/upload/uploadFileRaduno.jsp";
			response.setRenderParameter("id_esf_raduno", String.valueOf(id_esf_raduno));
			response.setRenderParameter("code", raduno.getCodice());
			response.setRenderParameter("jspPage", goToURL);
		} catch (NoSuchRadunoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Funzione che permette il download del file associato al raduno
	 * Prende in ingresso il nome e il path completo del file
	 * @param request
	 * @param response
	 */
	@ProcessAction(name="downloadFileDocumentRaduno")
	public void downloadFileDocumentRaduno(ActionRequest request, ActionResponse response){
		System.out.println("################# DOWNLOAD FILE #####################");
		String nome = request.getParameter("nome");
		String path = request.getParameter("path");

        try {
            File file = new File(path);
            InputStream in = new FileInputStream(file);
            HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(response);
            HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
            ServletResponseUtil.sendFile(httpReq,httpRes, nome, in, "application/download");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }       		
		
	}
}
