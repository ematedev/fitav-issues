<<<<<<< HEAD
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFShootingDirector shDr = ( ESFShootingDirector) row.getObject();
long esfShootingDirectorId = shDr.getEsfShootingDirectorId();
%>
<liferay-ui:icon-menu>
																			<%-- MODIFICHE CONSIGLIATE DA GIULIANO (da verificare)--%>
																			<%-- <portlet:param name="esfShootingDirectorId" --%>
																			<%-- value="<%= String.valueOf(shDr.getEsfShootingDirectorId()) %>" /> --%>				
	<portlet:renderURL var="editURL">										
 			<portlet:param name="esfUserId"									
				value="<%= String.valueOf(shDr.getEsfUserId())%>" />		
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_shootingDirectorInfo.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	
	<portlet:actionURL name="deleteESFShdr" var="deleteURL">
			<portlet:param name="shDrId"
				value="<%=String.valueOf(shDr.getEsfShootingDirectorId())%>" />
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
=======
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFShootingDirector shDr = ( ESFShootingDirector) row.getObject();
long esfShootingDirectorId = shDr.getEsfShootingDirectorId();
%>
<liferay-ui:icon-menu>				
	<portlet:renderURL var="editURL">										
 			<portlet:param name="esfUserId"									
				value="<%= String.valueOf(shDr.getEsfUserId())%>" />
			<portlet:param name="esfShootingDirectorId"
				value="<%= String.valueOf(shDr.getEsfShootingDirectorId()) %>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_shootingDirectorInfo.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	
	<portlet:actionURL name="deleteESFShdr" var="deleteURL">
			<portlet:param name="shDrId"
				value="<%=String.valueOf(shDr.getEsfShootingDirectorId())%>" />
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
</liferay-ui:icon-menu>