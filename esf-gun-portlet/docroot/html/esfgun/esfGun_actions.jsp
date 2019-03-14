<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFGun esfGun = (ESFGun)row.getObject(); 

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfGunId"
				value="<%=String.valueOf(esfGun.getEsfGunId()) %>" />
			<portlet:param name="mvcPath" value="/html/esfgun/edit_esfGun.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.PERMISSIONS) %>">

		<liferay-security:permissionsURL
			modelResource="<%= ESFGun.class.getName() %>"
			modelResourceDescription="<%= ESFGunLocalServiceUtil.getFullName(esfGun) %>"
			resourcePrimKey="<%= String.valueOf(esfGun.getEsfGunId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>

	<c:if
		test="<%= ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.DELETE) %>">

		<portlet:actionURL name="deleteESFGun" var="deleteURL">
			<portlet:param name="esfGunId"
				value="<%= String.valueOf(esfGun.getEsfGunId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

	</c:if>

</liferay-ui:icon-menu>