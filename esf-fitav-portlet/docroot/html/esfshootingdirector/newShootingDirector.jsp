<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="it.ethica.esf.model.impl.VM_TiratoriTesseratiImpl"%>
<%@page import="it.ethica.esf.model.VM_TiratoriTesserati"%>
<%@page import="it.ethica.esf.service.VM_TiratoriTesseratiLocalServiceUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp"%>

<h3>Creazione Nuovi Direttori di Tiro</h3>

<%  
Object listaTiratoriObject = request.getAttribute("listaTiratori");
List<VM_TiratoriTesserati> listaTiratori = new ArrayList<VM_TiratoriTesserati>();

if(listaTiratoriObject != null) {
	listaTiratori = (List<VM_TiratoriTesserati>)listaTiratoriObject;
}   

//Iterator url per il search container
PortletURL iteratorActionUrl = renderResponse.createActionURL();
iteratorActionUrl.setParameter("mvcPath", "/html/esfshootingdirector/newShootingDirector.jsp");
iteratorActionUrl.setParameter("javax.portlet.action", "cercaTiratoriTesserati");
iteratorActionUrl.setParameter("lastname", ParamUtil.getString(request, "lastname"));
iteratorActionUrl.setParameter("firstname", ParamUtil.getString(request, "firstname"));
iteratorActionUrl.setParameter("card", ParamUtil.getString(request, "card"));

//Url bottone annulla
PortletURL annullaUrl = renderResponse.createRenderURL();
annullaUrl.setParameter("jspPage", "/html/esfshootingdirector/view.jsp");

%> 

<!-- Gestione messaggi -->
<liferay-ui:error key="error-ricerca" message="E' occorso un errore durante la ricerca" />

<!-- Bottone annulla...riporta alla pagina view.jsp -->
<aui:button-row cssClass="esfshooter-admin-buttons">
	<aui:button onClick="<%= annullaUrl.toString() %>" value="cancel" />
</aui:button-row>

<!-- Action che comunica con la portlet -->
<portlet:actionURL var="searchUrl" name="cercaTiratoriTesserati"></portlet:actionURL>


<!-- Definisce il form della ricerca -->
<aui:form action="<%=searchUrl%>" method="POST" name="fm">
		
		
		<!-- Struttura del form di ricerca -->
		<div class="search-form">
		
			<span class="aui-search-bar"> 
			
			<aui:input inlineField="<%=true%>" label="" name="lastname"
					placeholder="last-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="firstname"
					placeholder="first-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="card" 
				placeholder="card" size="30" title="search-entries" type="text" /> 
			
			<aui:button type="submit" value="search" />
			
			</span>
			
		</div>
	
</aui:form>

<% 
	
	//_log.debug("################ Sono ancora vivo ####################")
%>
<!-- Definisce la tabella dove vengono visualizzati i membri -->
<liferay-ui:search-container  delta="20" deltaConfigurable="true" emptyResultsMessage="no-result" iteratorURL="<%=iteratorActionUrl%>">
	
	<!-- Definisce il contenitore dei risultati della chiamata al DB -->
	<liferay-ui:search-container-results>
		<% 
			pageContext.setAttribute("results", ListUtil.subList(listaTiratori, searchContainer.getStart(), searchContainer.getEnd()));
			pageContext.setAttribute("total", listaTiratori.size()); 
		%>
	</liferay-ui:search-container-results>

	<!-- Definisce la struttura di un elemento -->
	<liferay-ui:search-container-row className="it.ethica.esf.model.VM_TiratoriTesserati" modelVar="vm_tiratoriTesserati">
		
		<%
			// Prendo i campi dall'oggetto 
			String nome = vm_tiratoriTesserati.getNome();
			String cognome = vm_tiratoriTesserati.getCognome();
			String cf = vm_tiratoriTesserati.getCF();
			String email = vm_tiratoriTesserati.getEmail();
			String codTessera = vm_tiratoriTesserati.getCodiceTessera();
			String codOrganizzazione = vm_tiratoriTesserati.getCodiceOrganizzazione();
			
		%>

		
		<liferay-ui:search-container-column-text value='<%= cognome %>' name="last-name" align="Center"/>

		<liferay-ui:search-container-column-text value="<%= nome %>" name="first-name" align="Center"/>

		<liferay-ui:search-container-column-text value="<%= cf %>" name="fiscalCode" align="Center"/>

		<liferay-ui:search-container-column-text value="<%= email %>" name="user-email" align="Center">
		
			<a href="mailto:<%= email %>" target="_top"><p><%= email %></p></a>
		
		</liferay-ui:search-container-column-text> 

		<liferay-ui:search-container-column-text value='<%= codTessera != null ? codTessera : "" %>' name="card" align="Center" />
 
		<liferay-ui:search-container-column-text value="<%= codOrganizzazione %>" name="orgName" align="Center"/>
		
		<!-- Definisce il pulsante visualizza -->
		<liferay-ui:search-container-column-jsp path='<%=templatePath + "addNewShDtaction.jsp"%>' align="right" />
				
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

