<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFDocument esfDocument = (ESFDocument) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfDocumentId"
			value="<%=String.valueOf(esfDocument.getEsfDocumentId())%>" />
		<portlet:param name="mvcPath"
			value='<%= templatePath +"edit_esfDocument.jsp" %>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />

</liferay-ui:icon-menu>