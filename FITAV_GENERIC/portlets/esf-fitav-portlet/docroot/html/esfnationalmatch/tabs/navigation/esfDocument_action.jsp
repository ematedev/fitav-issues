<%@include file="init.jsp"%>

<%
ResultRow row =
(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFDocument esfDocument = (ESFDocument) row.getObject();
long esfDocumentId = esfDocument.getEsfDocumentId();

%>

<liferay-ui:icon-menu >

	<portlet:actionURL var="deleteESFdocumentURL" name="deleteESFdocument">
		<portlet:param name="esfDocumentId"
			value="<%= String.valueOf(esfDocumentId)%>" />
		<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="esfUserId"  value="<%=String.valueOf(esfUserId)%>" />
		<portlet:param name="organizationId" value="<%= String.valueOf(currentOrganizationId)%>" />
	</portlet:actionURL>

	<portlet:renderURL var="editESFDocumentURL">
		<portlet:param name="mvcPath" value='<%= templatePath +"edit_esfDocument.jsp" %>' />
		<portlet:param name="esfDocumentId" value="<%=String.valueOf(esfDocument.getEsfDocumentId())%>" />
		<portlet:param name="esfUserId"  value="<%=String.valueOf(esfUserId)%>" />
		<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="organizationId" value="<%= String.valueOf(currentOrganizationId)%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon url="<%= editESFDocumentURL.toString()%>" message="edit-document" image="edit"/>
	
	<liferay-ui:icon-delete url="<%= deleteESFdocumentURL.toString()%>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>