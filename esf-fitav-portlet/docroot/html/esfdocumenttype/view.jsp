<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>

<%
//Recupero tutti i record, nel caso l'anagrafica possa crescere molto conviene gestire la paginazione
List<ESFDocumentType> esfDocumentsType = ESFDocumentTypeLocalServiceUtil.getESFDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
int totalDocuments = (esfDocumentsType!=null) ? esfDocumentsType.size() : 0;
// boolean hasDocuments = totalDocuments > 0;
%>

<liferay-ui:success key="success-document-type-persist" message="success-document-type-persist"/>
<liferay-ui:success key="success-document-type-delete" message="success-document-type-delete"/>
<liferay-ui:error key="error-document-type-persist" message="error-document-type-persist" />
<liferay-ui:error key="error-document-type-delete-impossible" message="error-document-type-delete-impossible" />

<!-- URL per pagina di aggiunta/modifica -->
<portlet:renderURL var="addESFDocumentTypeURL">
	<portlet:param name="mvcPath" value="/html/esfdocumenttype/edit_esfDocumentType.jsp" />
	<!-- Passo -1 come ID per indicare che e' una creazione-->
	<portlet:param name="esfDocumentTypeId" value="-1"/>
</portlet:renderURL>
<!-- ATTENZIONE
	le stringhe inserite nei value dei bottoni vengono ricercate nel File 
	Language.properties e Language_It.properties
	nel codice sorgente sotto il package content
  -->
<aui:button-row>
	<aui:button onClick="${addESFDocumentTypeURL}" value="add-document-type" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">
    <liferay-ui:search-container-results results="<%=esfDocumentsType%>" total="<%=totalDocuments%>" />
    <liferay-ui:search-container-row
        className="it.ethica.esf.model.ESFDocumentType" 
        keyProperty="esfDocumentTypeId" modelVar="documentType">
        <liferay-ui:search-container-column-text property="description" />
        <liferay-ui:search-container-column-text property="expirationMonthsNotice"  />
        <liferay-ui:search-container-column-jsp
			path="/html/esfdocumenttype/esfDocumentType_actions.jsp" align="center" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>