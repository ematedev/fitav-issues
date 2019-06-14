<%@include file="../init.jsp"%>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ESFRadunoFiles file = (ESFRadunoFiles) row.getObject();

%>
<portlet:actionURL var="dowloadFileURL" name="downloadFileDocumentRaduno">
	<portlet:param name="nome" value="<%= String.valueOf(file.getNome()) %>"/>	
	<portlet:param name="path" value="<%= String.valueOf(file.getPath()) %>"/>	
</portlet:actionURL>
<portlet:actionURL var="deleteFileURL" name="deleteFileDocumentRaduno">
	<portlet:param name="idFileRaduno" value="<%= String.valueOf(file.getId_esf_raduno_files()) %>"/>	
</portlet:actionURL>	

<liferay-ui:icon-menu>
	<liferay-ui:icon image="view" message="view" url="<%=dowloadFileURL.toString()%>" />
	<liferay-ui:icon-delete image="delete" message="delete" url="<%=deleteFileURL.toString()%>" />
</liferay-ui:icon-menu>

