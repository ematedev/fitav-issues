<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFEventType esfeventType = (ESFEventType) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfEventTypeId"
			value="<%=String.valueOf(esfeventType.getEsfEventTypeId())%>" />
		<portlet:param name="mvcPath"
			value='<%= templatePath +"edit_esfEventType.jsp" %>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />
		
		<portlet:actionURL name="deleteESFEventType" var="deleteURL">
		<portlet:param name="esfEventTypeId"
			value="<%=String.valueOf(esfeventType.getEsfEventTypeId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>	

</liferay-ui:icon-menu>