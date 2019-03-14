<%@ include file="/html/init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFDocument esfDocument = (ESFDocument)row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfDocumentId" value="<%= String.valueOf(esfDocument.getEsfDocumentId()) %>" />
		<portlet:param name="mvcPath" value="/html/esfdocuments/edit_esfdocument.jsp" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>
	<portlet:actionURL name="deleteEntry" var="deleteURL">
		<portlet:param name="esfDocumentId" value="<%= String.valueOf(esfDocument.getEsfDocumentId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>"></liferay-ui:icon-delete>
</liferay-ui:icon-menu>