<%@page import="it.ethica.esf.service.VW_NomineDirettoriTiroLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.DateUtilFormatter"%>
<%@page import="it.ethica.esf.portlet.CompareByData"%>
<%@page import="java.util.Date"%>
<%@page import="it.ethica.esf.model.VW_NomineDirettoriTiro"%>
<%@include file="init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>   
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>

<%

//Inizializzazione della lista di tutte le regioni
List<ESFRegion> regioni = ESFRegionLocalServiceUtil.getESFRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//Inizializzazione della lista di tutti i Direttori di Tiro
List<ESFShootingDirectorQualification> qualificheDirettori = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//Inizializzazione della lista di tutti i tipi di sport
List<ESFSportType> specialita = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

Object listaNomineDirettoriObject = request.getAttribute("listaNomine");
List<VW_NomineDirettoriTiro> listaNomineDirettori = new ArrayList<VW_NomineDirettoriTiro>();
Object direttoreNominatoId = request.getAttribute("IdDirettoreAssegnato");  
//successMessage e errorMessage

if(direttoreNominatoId != null) {
	listaNomineDirettori.add(VW_NomineDirettoriTiroLocalServiceUtil.findByIdDirettore(Integer.parseInt(String.valueOf(direttoreNominatoId))).get(0));
}

if(listaNomineDirettoriObject != null) { 
	listaNomineDirettori = (List<VW_NomineDirettoriTiro>)listaNomineDirettoriObject;
}   

//Iterator url per il search container
PortletURL iteratorActionUrl = renderResponse.createActionURL();
iteratorActionUrl.setParameter("mvcPath", "/html/esfshootingdirector/view.jsp");
iteratorActionUrl.setParameter("javax.portlet.action", "cercaNomineDirettoriTiro");
iteratorActionUrl.setParameter("lastname", ParamUtil.getString(request, "lastname"));
iteratorActionUrl.setParameter("firstname", ParamUtil.getString(request, "firstname"));
iteratorActionUrl.setParameter("card", ParamUtil.getString(request, "card"));
iteratorActionUrl.setParameter("regionId", ParamUtil.getString(request, "regionId"));
iteratorActionUrl.setParameter("qualifica", ParamUtil.getString(request, "qualifica"));
iteratorActionUrl.setParameter("specialita", ParamUtil.getString(request, "specialita"));

%>
<!-- Gestione dei messaggi di errore -->
<liferay-ui:success key="success-message" message="${successMessage}"/> 
<liferay-ui:error key="error-ricerca" message="E' occorso un errore durante la ricerca" />

<!-- Definisce il bottone "Aggiungi direttore di tiro" -->
<aui:button-row cssClass="esfshooter-admin-buttons">
	<portlet:renderURL var="newShootingDirectorURL">
		<portlet:param name="mvcPath" value='<%=templatePath + "newShootingDirector.jsp"%>' />
	</portlet:renderURL> 
	<aui:button onClick="<%= newShootingDirectorURL.toString() %>" value="add-shDirector" />
</aui:button-row>

<!-- Action che comunica con la portlet -->
<portlet:actionURL var="searchUrl" name="cercaNomineDirettoriTiro"></portlet:actionURL>

<!-- Definisce il form per la ricerca fra i membri tesserati -->	
<aui:form action="<%= searchUrl %>" method="POST" name="fm"> 

	<!-- Struttura del form di ricerca -->
	<div class="search-form">
		<span class="aui-search-bar">
		
			<!-- Campo di testo Cognome -->
			<aui:input inlineField="<%=true%>" label="lastName" name="lastname"
				placeholder="last-name" size="30" title="search-entries" type="text" />
					
			<!-- Campo di testo Nome -->
			<aui:input inlineField="<%=true%>" label="firstName" name="firstname"
				placeholder="first-name" size="30" title="search-entries" type="text" />
					
			<!-- Campo di testo Tessera -->
			<aui:input inlineField="<%=true%>" label="card" name="card" 
				placeholder="card" size="30" title="search-entries" type="text" />
					
			<!-- ComboBox Regioni -->
			<aui:select  name="regionId" inlineField="<%=true%>" label="regions">
				<aui:option value="0"  label="-"></aui:option>
				<!-- Ciclo for che riempie le opzioni della ComboBox regioni -->
				<%for(ESFRegion r : regioni){ %>
					<aui:option value="<%=r.getIdRegion()%>"  label="<%=r.getName()%>"></aui:option>
				<%}%>
			</aui:select>
				
			<!-- ComboBox Qualifica -->
			<aui:select  name="qualifica" inlineField="<%=true%>"  label="qualification" >
				<aui:option value="0"  label="-"></aui:option>
				<!-- Ciclo for che riempie le opzioni della ComboBox qualifiche -->
				<%for(ESFShootingDirectorQualification s : qualificheDirettori){%>
					<aui:option value="<%=s.getEsfShootingDirectorQualificationId()%>"  label="<%=s.getEsfShootingDirectorQualificationDesc()%>"></aui:option>
				<%}%>
			</aui:select>
				
			<!-- ComboBox Tipi di sport/Specialità -->
			<aui:select  name="specialita" inlineField="<%=true%>" label="sport-type" >
				<aui:option value="0"  label="-"></aui:option>
				<!-- Ciclo for che riempie le opzioni della ComboBox tipi di sport/specialità -->
				<%for(ESFSportType st : specialita){%>
					<aui:option value="<%=st.getEsfSportTypeId()%>"  label="<%=st.getName()%>"></aui:option>
				<%} %>
			</aui:select>
			
			<!-- Bottone di submit -->
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<!-- Valori hidden che servono a prendere i campi della select -->
<aui:input name="qualifiche" type="hidden"/>
<aui:input name="spec" type="hidden"/>


<!-- Definisce la tabella dove vengono visualizzati i membri -->
<liferay-ui:search-container emptyResultsMessage="no-result" delta="20" total= "<%= 0 %>" iteratorURL = "<%=iteratorActionUrl%>">
	<!-- Definisce il contenitore dei risultati della chiamata al DB -->
	<liferay-ui:search-container-results>
	<%  
		
		pageContext.setAttribute("results", ListUtil.subList(listaNomineDirettori, searchContainer.getStart(), searchContainer.getEnd()));
		pageContext.setAttribute("total", listaNomineDirettori.size()); 
	%> 
	</liferay-ui:search-container-results>
	<!-- Definisce la struttura di una riga della tabella NB: si fa un foreach su results con "shDt" come variabile assegnata a ogni ciclo -->
	<liferay-ui:search-container-row className="it.ethica.esf.model.VW_NomineDirettoriTiro" modelVar="direttore">
		
		<%
			String nome = direttore.getNome();
			String cognome = direttore.getCognome();
			String codRegione = direttore.getRegione();
			String qualifica = direttore.getQualifica();
			String codTessera = direttore.getCodiceTessera();
			String spec = direttore.getSpecialita(); 
			Date dataAssegnazione = direttore.getDataAssegnazione(); 
			String dataFormattata = DateUtilFormatter.formatDate(dataAssegnazione);
			
		%>
		<liferay-ui:search-container-row-parameter name="tableType" value="view"/>
		<!-- Vengono definite le colonne della tabella e le variabili ad esse collegate -->
		<liferay-ui:search-container-column-text name="stato" value="<%= String.valueOf(direttore.getAutenticazione()) %>"/>
		<liferay-ui:search-container-column-text name="name" value='<%= String.format("%s %s", cognome, nome) %>' />
		<liferay-ui:search-container-column-text name="card" value="<%= codTessera %>"/>
		<liferay-ui:search-container-column-text name="region-code" value="<%= codRegione %>" />
		<liferay-ui:search-container-column-text name="qualification" value="<%= qualifica %>" />
		<liferay-ui:search-container-column-text name="sport-type" value="<%= spec %>" />
		<liferay-ui:search-container-column-text name="esf-date-assign" value="<%= dataFormattata %>" />
		<liferay-ui:search-container-column-jsp path='<%=templatePath + "modifyShootingDirectorInfoAction.jsp"%>' align="right" /> 
	</liferay-ui:search-container-row>
	<!-- Iteratore che si preoccupa di stampare i risultati nella pagina JSP -->
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

