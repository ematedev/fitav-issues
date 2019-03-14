<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFOrganizationModel esfOrganizationModel = (ESFOrganizationModel)row.getObject();
ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationModel.getEsfOrganizationId());
%>

<liferay-ui:icon-menu>
	<% if (ESFOrganizationPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.UPDATE)) { %>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfOrganizationId" value="<%= String.valueOf(esfOrganization.getEsfOrganizationId()) %>" />
		<portlet:param name="mvcPath" value="/html/portlet/esforganizationadmin/edit_navigation.jsp" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>
	<% } %>
	<% if(ESFOrganizationPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.PERMISSIONS)) {%>
	<liferay-security:permissionsURL
        modelResource="<%= ESFOrganization.class.getName() %>"
        modelResourceDescription="<%=esfOrganization.getName() %>"
        resourcePrimKey="<%= String.valueOf(esfOrganization.getEsfOrganizationId()) %>"
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
	<% if (ESFOrganizationPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.DELETE)) { %>
	<portlet:actionURL name="deleteESFOrganization" var="deleteURL">
		<portlet:param name="esfOrganizationId" value="<%= String.valueOf(esfOrganization.getEsfOrganizationId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>"></liferay-ui:icon-delete>
	<% } %>
</liferay-ui:icon-menu>