<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFSportType esfSportType = (ESFSportType) row.getObject();
%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL">
			<portlet:param name="esfSportTypeId"
				value="<%=String.valueOf(esfSportType.getEsfSportTypeId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfSportType.jsp"%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />

		<liferay-security:permissionsURL
			modelResource="<%= ESFSportType.class.getName() %>"
			modelResourceDescription="<%= esfSportType.getName() %>"
			resourcePrimKey="<%= String.valueOf(esfSportType.getEsfSportTypeId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />


		<portlet:actionURL name="deleteESFSportType" var="deleteURL" >
			<portlet:param name="esfSportTypeId"
				value="<%= String.valueOf(esfSportType.getEsfSportTypeId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />


</liferay-ui:icon-menu>