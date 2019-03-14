<%@include file="/useradmin/init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUserModel esfUserModel = (ESFUserModel)row.getObject();
ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserModel.getEsfUserId());
%>

<liferay-ui:icon-menu>
	<% if (ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.UPDATE_ESFUSER)) { %>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_user.jsp"%>' />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>
	<% } %>
	<% if (ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.DELETE_ESFUSER)) { %>
	<portlet:actionURL name="deleteUser" var="deleteURL">
		<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>"></liferay-ui:icon-delete>
	<% } %>
</liferay-ui:icon-menu>