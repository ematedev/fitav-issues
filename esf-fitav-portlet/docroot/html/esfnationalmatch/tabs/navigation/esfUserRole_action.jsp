<%@include file="init.jsp"%>


<%
	String mvcPath ="/html/esfnationalmatch/tabs/navigation/assignroles.jsp";
	
	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFUserRole role = (ESFUserRole) row.getObject();

%>

<liferay-ui:icon-menu>
	<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ROLE_ASSIGN) %>">	
	
		<portlet:renderURL var="assignRolesURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="mvcPath" 	value='<%=mvcPath %>' />
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)  %>" />
			<portlet:param name="roleId" value="<%=String.valueOf(role.getEsfUserRoleId())  %>" />
			<portlet:param name="op" value="chooseorg" />
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId)%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=assignRolesURL.toString() %>" message="assign-role"/>
	</c:if>
</liferay-ui:icon-menu>