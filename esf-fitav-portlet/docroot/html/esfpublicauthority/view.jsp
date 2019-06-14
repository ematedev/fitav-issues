<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>

<%
//Recupero tutti i record, nel caso l'anagrafica possa crescere molto conviene gestire la paginazione
List<ESFPublicAuthority> esfPublicAuthority = ESFPublicAuthorityLocalServiceUtil.getESFPublicAuthorities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
int totalDocuments = (esfPublicAuthority!=null) ? esfPublicAuthority.size() : 0;
%>

<liferay-ui:success key="success-public-authority-persist" message="success-public-authority-persist"/>
<liferay-ui:success key="success-public-authority-delete" message="success-public-authority-delete"/>
<liferay-ui:error key="error-public-authority-persist" message="error-public-authority-persist" />
<liferay-ui:error key="error-public-authority-delete-impossible" message="error-public-authority-delete-impossible" />

<!-- URL per pagina di aggiunta/modifica -->
<portlet:renderURL var="addESFPublicAuthorityURL">
	<portlet:param name="mvcPath" value="/html/esfpublicauthority/edit_esfPublicAuthority.jsp" />
	<!-- Passo -1 come ID per indicare che e' una creazione-->
	<portlet:param name="esfPublicAuthorityId" value="-1"/>
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="${addESFPublicAuthorityURL}" value="add-public-authority" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">
    <liferay-ui:search-container-results results="<%=esfPublicAuthority%>" total="<%=totalDocuments%>" />
    <liferay-ui:search-container-row
        className="it.ethica.esf.model.ESFPublicAuthority" 
        keyProperty="esfPublicAuthorityId" modelVar="publicAuthority">
        <liferay-ui:search-container-column-text property="description" />
        <liferay-ui:search-container-column-jsp
			path="/html/esfpublicauthority/esfPublicAuthority_actions.jsp" align="center" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>