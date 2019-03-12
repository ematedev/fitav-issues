<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFMatchType esfMatchtype = (ESFMatchType) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfMatchTypeId"
			value="<%=String.valueOf(esfMatchtype.getEsfMatchTypeId())%>" />
		<portlet:param name="mvcPath"
			value='<%=templatePath + "edit_esfMatchType.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />

	<portlet:actionURL name="deleteESFMatchType" var="deleteURL">
		<portlet:param name="esfMatchTypeId"
			value="<%=String.valueOf(esfMatchtype.getEsfMatchTypeId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />

</liferay-ui:icon-menu>