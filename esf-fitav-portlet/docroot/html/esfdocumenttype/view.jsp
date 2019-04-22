
<%@ include file="init.jsp"%>

<%
//Recupero tutti i record, nel caso l'anagrafica possa crescere molto conviene gestire la paginazione
// List<ESFDocumentType> esfDocumentsType = ESFDocumentTypeLocalServiceUtil.getESFDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
// int totalDocuments = (esfDocumentsType!=null) ? esfDocumentsType.size() : 0;

%>

<!-- URL per pagina di aggiunta/modifica -->
<portlet:renderURL var="addESFDocumentTypeURL">
	<portlet:param name="mvcPath" value="/html/esfdocumenttype/edit_esfDocumentType.jsp" />
	<!-- Passo -1 come ID per indicare che e' una creazione-->
	<portlet:param name="esfDocumentTypeId" value="-1"/>	
</portlet:renderURL>
<!-- ATTENZIONE
	le stringhe inserite nei value dei bottoni vengono ricercate nel File Language.properties e Language_it.properties
	nel codice sorgente sotto il package content
  -->
<aui:button-row>
	<aui:button onClick="${addESFDocumentTypeURL}" value="add-document-type" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">
    <liferay-ui:search-container-results>
		<%
		total = ESFDocumentTypeLocalServiceUtil.getESFDocumentTypesCount();
		results = ESFDocumentTypeLocalServiceUtil.getESFDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		searchContainer.setTotal(total);
		searchContainer.setResults(results);		
		%>
	</liferay-ui:search-container-results>
		
    <liferay-ui:search-container-row
        className="it.ethica.esf.model.ESFDocumentType" 
        keyProperty="esfDocumentTypeId" modelVar="documentType">
        <liferay-ui:search-container-column-text property="description" />
        <liferay-ui:search-container-column-text property="expirationMonthsNotice" />
        <!-- Aggiungere una jsp per gestire le azioni possibili sull'entity -->
        
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>