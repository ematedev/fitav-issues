<%@include file="../init.jsp"%>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ESFRadunoFiles file = (ESFRadunoFiles) row.getObject();

%>
<liferay-ui:icon-menu>

	
	<portlet:renderURL var="viewFile">
	</portlet:renderURL>
	<portlet:actionURL var="deleteFileURL" name="deleteFileDocumentRaduno">
		<portlet:param name="idFileRaduno" value="<%= String.valueOf(file.getId_esf_raduno_files()) %>"/>	
	</portlet:actionURL>	
	
	<liferay-ui:icon image="view" message="view" url="<%=viewFile.toString()%>" />
	<liferay-ui:icon-delete image="delete" message="delete" url="<%=deleteFileURL.toString()%>" />
		
</liferay-ui:icon-menu>