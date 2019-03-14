<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFOrganizationModel esfOrganizationModel = (ESFOrganizationModel)row.getObject();

Group esfOrganizationGroup = GroupLocalServiceUtil.getOrganizationGroup(themeDisplay.getCompanyId(),esfOrganizationModel.getEsfOrganizationId());

%>

<liferay-ui:icon-menu>

	<c:if test='<%= ESFOrganizationPermission.contains(permissionChecker, esfOrganizationModel.getEsfOrganizationId(), ActionKeys.ESFORGANIZATIONADMIN_VIEW) %>'>
	
		<portlet:renderURL var="editURL">
			<portlet:param name="esfOrganizationId" value="<%= String.valueOf(esfOrganizationModel.getEsfOrganizationId()) %>" />
			<portlet:param name="op" value='updAddr' />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esforganization.jsp"%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="view" message="details" url="<%= editURL.toString() %>"/>
	
	</c:if>

	<c:if test='<%= ESFOrganizationPermission.contains(permissionChecker, esfOrganizationModel.getEsfOrganizationId(), ActionKeys.ESFORGANIZATIONADMIN_VIEW_CHILD) %>'>
	
		<liferay-ui:icon image="submit" message="view" url="<%= esfOrganizationGroup.getPathFriendlyURL(true, themeDisplay) + esfOrganizationGroup.getFriendlyURL() %>"/>
	
	</c:if>
	
	
</liferay-ui:icon-menu>