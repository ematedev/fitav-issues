<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUserModel esfUserModel = (ESFUserModel)row.getObject();
ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserModel.getEsfUserId());
%>

<liferay-ui:icon-menu>
	<% if (ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.UPDATE)) { %>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
		<portlet:param name="mvcPath" value="/html/portlet/esfuseradmin/edit_navigation.jsp" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>
	<% } %>
	<% if(ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.PERMISSIONS)) {%>
	<liferay-security:permissionsURL
        modelResource="<%= ESFUser.class.getName() %>"
        modelResourceDescription="<%=esfUser.getScreenName() %>"
        resourcePrimKey="<%= String.valueOf(esfUser.getEsfUserId()) %>"
        var="permissionsURL"
        windowState="<%=LiferayWindowState.POP_UP.toString() %>" 
    />

    <liferay-ui:icon 
    	image="permissions"    	 
    	method="get"
		url="<%= permissionsURL %>"
		useDialog="<%= true %>"
	/>
	<% } %>
	<% if (ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.DELETE)) { %>
	<portlet:actionURL name="deleteUser" var="deleteURL">
		<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>"></liferay-ui:icon-delete>
	<% } %>
</liferay-ui:icon-menu>