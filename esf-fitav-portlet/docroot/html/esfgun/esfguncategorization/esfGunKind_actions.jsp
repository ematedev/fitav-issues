<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="../init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFGunKind esfGunKind = (ESFGunKind)row.getObject(); 

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfGunKindId"
				value="<%=String.valueOf(esfGunKind.getEsfGunKindId()) %>" />
			<portlet:param name="esfGunTypeId"
				value="<%=String.valueOf(esfGunTypeId) %>" />
			<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/edit_esfGunKind.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%= editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.PERMISSIONS) %>">

		<liferay-security:permissionsURL
			modelResource="<%= ESFGunKind.class.getName() %>"
			modelResourceDescription="<%= esfGunKind.getName() %>"
			resourcePrimKey="<%= String.valueOf(esfGunKind.getEsfGunKindId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>

	<c:if
		test="<%= ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.DELETE) %>">

		<portlet:actionURL name="deleteESFGunKind" var="deleteURL">
			<portlet:param name="esfGunKindId"
				value="<%= String.valueOf(esfGunKind.getEsfGunKindId()) %>" />
			<portlet:param name="esfGunTypeId"
				value="<%= String.valueOf(esfGunTypeId) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>

	</c:if>

</liferay-ui:icon-menu>