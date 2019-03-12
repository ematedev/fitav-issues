<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUserRole esfUserRole = (ESFUserRole)row.getObject(); 

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFUserRolePermission.contains(permissionChecker, esfUserRole.getEsfUserRoleId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfUserRoleId"
				value="<%=String.valueOf(esfUserRole.getEsfUserRoleId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfUserRole.jsp" %>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= ESFUserRolePermission.contains(permissionChecker, esfUserRole.getEsfUserRoleId(), ActionKeys.PERMISSIONS) %>">

		<liferay-security:permissionsURL
			modelResource="<%= ESFUserRole.class.getName() %>"
			modelResourceDescription="<%= esfUserRole.getName() %>"
			resourcePrimKey="<%= String.valueOf(esfUserRole.getEsfUserRoleId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>

	<c:if
		test="<%= ESFUserRolePermission.contains(permissionChecker, esfUserRole.getEsfUserRoleId(), ActionKeys.DELETE) %>">

		<portlet:actionURL name="deleteESFUserRole" var="deleteURL">
			<portlet:param name="esfUserRoleId"
				value="<%= String.valueOf(esfUserRole.getEsfUserRoleId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

	</c:if>

</liferay-ui:icon-menu>