<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUserModel esfUserModel = (ESFUserModel)row.getObject();
ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserModel.getEsfUserId());
%>

<liferay-ui:icon-menu>
	<% if (ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.UPDATE)) { %>
		<portlet:renderURL var="editURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
			<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_user.jsp"%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>
	<% } %>
	<% if (ESFUserModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFUSERROLE)) { %>
		<portlet:renderURL var="viewEsfUserRoleURL">
			<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "view_esfUserEsfUserRole.jsp"%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="view" message="View Roles" url="<%= viewEsfUserRoleURL.toString() %>"/>
	<% } %>
	<% if (ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.PERMISSIONS)) { %>
		<liferay-security:permissionsURL
			modelResource="<%= ESFUser.class.getName() %>"
			modelResourceDescription="<%= esfUser.getScreenName() %>"
			resourcePrimKey="<%= String.valueOf(esfUser.getEsfUserId()) %>"
			var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	<% } %>
	<% if (ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.DELETE)) { %>
		<portlet:actionURL name="deleteUser" var="deleteURL">
			<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>"></liferay-ui:icon-delete>
	<% } %>
</liferay-ui:icon-menu>