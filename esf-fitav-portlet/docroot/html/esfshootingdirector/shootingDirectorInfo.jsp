<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFMatchTypeImpl"%>
<%@page import="it.ethica.esf.model.ESFMatchType"%>
<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFInstructsShootingDirectorImpl"%>
<%@page import="it.ethica.esf.model.ESFInstructsShootingDirector"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveCode"%>
<%@page import="it.ethica.esf.model.impl.ESFSuspensiveCodeImpl"%>
<%@page import="it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveShootingDirector"%>
<%@page import="it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="init.jsp"%>

<%
//Recupera l'id dell'utente che è stato inviato alla pagina tramite renderUrl
long esfUserId = ParamUtil.getLong(request, "esfUserId");
//Crea oggetto che rappresenta il calendario al giorno odierno
Calendar calendar = CalendarFactoryUtil.getCalendar();
//Inizializzazione variabili
String currDate = "";
String shDrName = "";

//Prende il calendario e ritorna la stringa corrispondente a oggi
currDate = ManageDate.CalendarToString(calendar);

//Inizializzazione variabili
List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
List<ESFSportType> sportTypes = new ArrayList<ESFSportType>(); 
ESFUser shDr = new ESFUserImpl();

//Trova l'utente attraverso il suo userId
shDr = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);

//Se l'utente non è null
if(Validator.isNotNull(shDr)){
	//Ne ricava il nome e cognome
	shDrName = shDr.getFirstName() + " " + shDr.getLastName(); 
}

//Prende tutte le possibili qualifiche 
shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//Prende tutte le possibili specialità
sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();


%>

<!-- Messaggio in testa alla pagina -->
<h3><liferay-ui:message key="infromation-shDR-x" arguments="<%=shDrName %>" /></h3>

<!-- Definizione dei gestori degli errori -->
<liferay-ui:error key="findingOld" message="findingOld" />
<liferay-ui:error key="error-delete-shDr" message="error-delete-shDr" />

<!-- Definisce la renderUrl che punta alla pagina principale del portlet -->
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<!-- ActionUrl per l'eliminazione di un direttore di tiro -->
<portlet:actionURL var="deleteURL" name="deleteESFShdr">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="mvcPath" value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
</portlet:actionURL>

<!-- Definisce la renderUrl che punta alla pagina definita dal bottone "genera convocazione" -->
<portlet:renderURL var="convocationsURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "convocations.jsp"%>' />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:renderURL>

<!-- ActionUrl per la creazione di un nuovo direttore di tiro -->
<portlet:actionURL name="addShooterDirector" var="addShooterDirectorURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="mvcPath" value='<%=templatePath + "shootingDirectorInfo.jsp"%>'/>
</portlet:actionURL>

<!-- Definisce il form per l'aggiunta o la convocazione d'utente selezionato -->
<aui:form action="<%=addShooterDirectorURL%>" name="<portlet:namespace />fm" >

	<!-- Definisce la struttura del form -->
	<div class="btn-field-align"> 
		
		<!-- Campo di testo Qualifica -->
		<aui:select  name="shDtId" inlineField="<%=true%>" label="qualification" >
			<aui:option value="0" label="-"></aui:option>
			<!-- Riempie con le qualifiche la combobox -->
			<%for(ESFShootingDirectorQualification s : shDts){%>
				<aui:option value="<%=s.getEsfShootingDirectorQualificationId()%>"  label="<%=s.getEsfShootingDirectorQualificationDesc()%>"></aui:option>
			<%}%>
		</aui:select>
		<!-- Campo di testo Specialità -->
		<aui:select  name="stId" inlineField="<%=true%>" label="sport-type" >
			<aui:option value="0"  label="-"></aui:option>
			<!-- Riempie con le specialità la combobox -->
			<%for(ESFSportType st : sportTypes){%>
				<aui:option value="<%=st.getEsfSportTypeId()%>"  label="<%=st.getName()%>"></aui:option>
			<%} %>
		</aui:select>
		
		<!-- Campo di testo Data di Inizio -->
		<aui:input name="startDate" type="text" label="start-date" inlineField="<%=true%>"/>
		
		<!-- Bottone di sottomissione aggiungi -->
		<aui:button type="submit" value="add" />
		
		<!-- Bottone che rimanda alla pagina convocations.jsp -->
		<aui:button onClick='<%=convocationsURL.toString() %>' value="convocations" inlineField="true"/>
	</div>
</aui:form>

<!-- Messaggio nomine -->
<h4><b><liferay-ui:message key="assignment" /></b>
				<div class="separator"></div>

<!-- Definisce la tabella dove vengono visualizzate le nomine dell'utente selezionato -->
<liferay-ui:search-container emptyResultsMessage="no-result" curParam="ShootingDirector">
	
	<!-- Contiene i risultati della ricerca -->
	<liferay-ui:search-container-results
	    results="<%=ESFShootingDirectorLocalServiceUtil.findByUserId(esfUserId, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFShootingDirectorLocalServiceUtil.countByUserId(esfUserId)%>"/>
	
	
	<!-- Definisce la struttura di una riga -->
	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFShootingDirector" modelVar="shDt">
		
		<%
			//Inizializza le variabili
			ESFUser shDtInfo = new ESFUserImpl();
			ESFCard userCard= null;
			List<ESFCard> cardstest = new ArrayList<ESFCard>();
			String name = "";
			String cardCode = "";
			String qualification ="";
			String stName= "";
			
			//Se l'utente è valido
			if(Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()))){
				
				//Prendi il nome
				name = ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getFirstName();
				
				//Aggiungi il cognome
				name = name + " " + ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getLastName();
				
				try{
					//Tenta di trovare le tessere associate all'utente selezionato
					cardstest = ESFCardLocalServiceUtil.findActualUserCards(shDt.getEsfUserId());
					//Se la lista è valida e ha almeno un elemento...
					if(Validator.isNotNull(cardstest) && 0 < cardstest.size()){
						//Prendi il codice della carta del primo elemento
						cardCode = cardstest.get(0).getCode();
					}
					
				}
				catch(Exception e){ 
					
				}
			}
			
			//Se la qualifica dell'utente selezionato è valida...
			if(Validator.isNotNull(ESFShootingDirectorQualificationLocalServiceUtil.fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()))){
				//Prendi il codice della qualifica
				qualification = ESFShootingDirectorQualificationLocalServiceUtil.
						fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()).getEsfShootingDirectorQualificationDesc();
			}
			
			//Se la specialità dell'utente selezionato è valida...
			if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()))){
				//Prendi il nome della specialità
				stName = ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()).getName();
			}
			
		%>
		<!-- Definizione delle colonne -->
		<liferay-ui:search-container-column-text name="name" value="<%=name %>" />
		<liferay-ui:search-container-column-text name="card" value="<%=cardCode %>"/>
		<liferay-ui:search-container-column-text name="region-code" value="<%=shDt.getRegionId() %>" />
		<liferay-ui:search-container-column-text name="qualification" value="<%=qualification %>" />
		<liferay-ui:search-container-column-text name="sport-type" value="<%=stName %>" />
		<liferay-ui:search-container-column-text name="esf-date-assign" value="<%=sdf.format(shDt.getEsfStartData()) %>" />
		<liferay-ui:search-container-column-text name = "delete" >
			<aui:form action = "<%=deleteURL%>">
				<aui:input name="shDrId" value="<%=String.valueOf(shDt.getEsfShootingDirectorId()) %>" type="hidden"></aui:input>
				<aui:button type = "delete" value = "delete" align="right"  confirmation="delete_confirm"></aui:button>
			</aui:form> 
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<!-- Iteratore che si preoccupa di stampare i risultati nella pagina JSP -->
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<!-- Messaggio sospensioni -->
<h4><b><liferay-ui:message key="suspensive" /></b>
				<div class="separator"></div>

<!-- Definisce la tabella dove vengono visualizzate le sospensioni dell'utente selezionato -->
<liferay-ui:search-container emptyResultsMessage="no-result" curParam="suspensive">

	<!-- Contiene i risultati della ricerca -->
	<liferay-ui:search-container-results
		results="<%=ESFSuspensiveShootingDirectorLocalServiceUtil.findByUserId(esfUserId, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFSuspensiveShootingDirectorLocalServiceUtil.countByUserId(esfUserId)%>" />
		
	<!-- Definisce la struttura di una riga -->	
	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFSuspensiveShootingDirector" modelVar="suspensive">
				
	<%
		//Inizializzazione delle variabili
		String suspcode = "";
		String instructsName = "";
		String suspendedMatch = ""; 
		ESFSuspensiveCode codeSusp = new ESFSuspensiveCodeImpl();
		ESFInstructsShootingDirector ins = new ESFInstructsShootingDirectorImpl();
		ESFMatchType matchType =new ESFMatchTypeImpl(); 
		
		//Se il codice della sospensione è maggiore di 0...
		if(0 < suspensive.getCodice_Sosp()){
			
			//Prendi l'istanza di ESFSuspendiveCode usando il codice di sospensione dell'utente selezionato
			codeSusp = ESFSuspensiveCodeLocalServiceUtil.fetchESFSuspensiveCode(suspensive.getCodice_Sosp());
			
			//Se l'istanza è valida...
			if(Validator.isNotNull(codeSusp)){
				//Prendi il codice
				suspcode = codeSusp.getCode();
			}
		}
		
		//Prendo gli incarichi sospesi ------------------------------------------------------------------------
		
		
		//Se il codice degli incarico 1 è maggiore di 0
		if(0 < suspensive.getQualif1_Utiliz()){
			
			//Prendo l'istanza di ESFInstructsShootingDirector utilizzando il codice dell'incarico dell'utente selezionato
			ins = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(suspensive.getQualif1_Utiliz());
			
			//Se l'istanza è valida...
			if(Validator.isNotNull(ins)){
				
				//Prendo il codice
				instructsName = ins.getEsfInstructsShootingDirectorCode();
			}
		}
		
		//Se il codice degli incarico 1 è maggiore di 0
		if(0 < suspensive.getQualif2_Utiliz()){
			
			//Prendo l'istanza di ESFInstructsShootingDirector utilizzando il codice dell'incarico dell'utente selezionato
			ins = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(suspensive.getQualif2_Utiliz());
			
			//Se l'istanza è valida...
			if(Validator.isNotNull(ins)){
				
				//Prendo il codice e lo attacco al precendente
				instructsName = instructsName + "-" + ins.getEsfInstructsShootingDirectorCode();
			}
		}
		
		//Se il codice degli incarico 2 è maggiore di 0
		if(0 < suspensive.getQualif3_Utiliz()){
			
			//Prendo l'istanza di ESFInstructsShootingDirector utilizzando il codice dell'incarico dell'utente selezionato
			ins = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(suspensive.getQualif3_Utiliz());
			
			//Se l'istanza è valida...
			if(Validator.isNotNull(ins)){
				
				//Prendo il codice e lo attacco al precendente
				instructsName = instructsName + "-" + ins.getEsfInstructsShootingDirectorCode();
			}
		}
		
		
		//Prendo i Tipi di gara sospesi --------------------------------------------------------------------------
		
		
		//Se il codice del tipo di gara 1 è maggiore di 0
		if(0 < suspensive.getTipo_Gara1_noUtil()){
			
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara1_noUtil());
			
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
				
				//Prendo il codice
				suspendedMatch = matchType.getName();
			}
		}
		
		//Se il codice del tipo di gara 2 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara2_noUtil()){
			
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara2_noUtil());
			
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
				
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
		 
		//Se il codice del tipo di gara 3 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara3_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara3_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
		
		//Se il codice del tipo di gara 4 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara4_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara4_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
				
		//Se il codice del tipo di gara 5 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara5_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara5_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
				
		//Se il codice del tipo di gara 6 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara6_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara6_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
				
		//Se il codice del tipo di gara 7 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara7_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara7_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
				
		//Se il codice del tipo di gara 8 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara8_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara8_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
				
		//Se il codice del tipo di gara 9 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara9_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara9_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
				
		//Se il codice del tipo di gara 10 è maggiore di 0 
		if(0 < suspensive.getTipo_Gara10_noUtil()){
					
			//Prendo l'istanza di ESFMatchType utilizzando il codice dell'tipo di gara dell'utente selezionato
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara10_noUtil());
					
			//Se l'istanza è valida...
			if(Validator.isNotNull(matchType)){
						
				//Prendo il codice e lo attacco al precendente
				suspendedMatch = suspendedMatch + "-" + matchType.getName();
			}
		}
		
		%>
		<!-- Definizione delle colonne -->
		<liferay-ui:search-container-column-text name="suspensionCode" value="<%=suspcode %>" />
		<liferay-ui:search-container-column-text name="suspensiveInstructorsshDirector" value="<%=instructsName %>" />
		<liferay-ui:search-container-column-text name="esfMatchTypeId" value="<%=suspendedMatch %>" />
		<liferay-ui:search-container-column-text name="note" value="<%=suspensive.getNote() %>" />
		<liferay-ui:search-container-column-text name="start-date" value="<%=sdf.format(suspensive.getEsfStartData()) %>" />
		<liferay-ui:search-container-column-text name="end-date" value="<%=sdf.format(suspensive.getEsfEndData()) %>" />
		<!-- Tasto action nel container -->
		<liferay-ui:search-container-column-jsp path='<%=templatePath + "modifySuspensionAction.jsp"%>' align="right" />
	</liferay-ui:search-container-row>
	<!-- Iteratore che si preoccupa di stampare i risultati nella pagina JSP -->
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<!-- Bottone che permette di tornare alla pagina precedente -->
<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>

<!-- Definisce uno script simil JS -->
<aui:script use="aui-base,node,aui-io-request">
	
	//Funzione che aggiunge la possibilità di selezionare la data dal campo "Data inizio" con un form apposito
	$(function() {
		$("#<portlet:namespace/>startDate").datepicker();
		$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>startDate").datepicker("setDate", '<%= currDate %>'); 
	});

</aui:script>
