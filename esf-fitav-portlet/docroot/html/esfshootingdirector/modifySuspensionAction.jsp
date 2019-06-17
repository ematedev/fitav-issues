<%@page import="it.ethica.esf.model.ESFSuspensiveShootingDirector"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

//Prendi la riga dell'utente selezionato dal search container
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

//Prendi la sospensione dell'utente
ESFSuspensiveShootingDirector suspensive = ( ESFSuspensiveShootingDirector) row.getObject();

//Prendi l'id dell'utente selezionato
long esfUserId = suspensive.getEsfUserId();

//Prendi l'id della sospensione
long esfSuspensionId = suspensive.getEsfSuspensiveShooingDirectorId();

%>

<!-- Definisce il menu a tendina -->
<liferay-ui:icon-menu>

	<!-- Definisce la render url utilizzata per andare alla pagina dell'aggiunta/modifica della sospensione -->
	<portlet:renderURL var="editURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUserId)%>" />
			<portlet:param name="esfSuspensionId"
				value="<%= String.valueOf(esfSuspensionId)%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "newsospensive.jsp"%>' />
	</portlet:renderURL>
	
	<!-- Definisce l'icona per l'aggiunta/modifica di una sospensione -->
	<liferay-ui:icon image="edit" message="view" url="<%=editURL.toString()%>" />
	
	<!-- Definisce l'action url che va a eliminare la sospensione dell'utente selezionato -->
	<portlet:actionURL name="deleteSospensive" var="deleteURL">
			<portlet:param name="esfSuspensionId"
				value="<%=String.valueOf(esfSuspensionId)%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUserId)%>" />
	</portlet:actionURL>
		
	<!-- Definisce l'icona per l'eliminazione di una sospensione -->
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
</liferay-ui:icon-menu>