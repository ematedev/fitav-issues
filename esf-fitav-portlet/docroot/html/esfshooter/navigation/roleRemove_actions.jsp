<%@include file="init.jsp"%>


<%
	String mvcPath = "/html/esfshooter/navigation/roles.jsp";
	ResultRow row =(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFUserESFUserRole role = (ESFUserESFUserRole) row.getObject();
	

%>

<liferay-ui:icon-menu>
	<c:if test="<%= ESFShooterPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFSHOOTER_ROLE_DELETE) %>">	

		<portlet:actionURL name="removeRole" var="removeRoleURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="mvcPath" 	value='<%=mvcPath %>' />
			<portlet:param name="esfUserId" value="<%=String.valueOf(role.getEsfUserId())  %>" />
			<portlet:param name="esfUserRoleId" value="<%=String.valueOf(role.getEsfUserRoleId()) %>" />
			<portlet:param name="esforgId" value="<%=String.valueOf(role.getEsfOrganizationId()) %>" />
			<portlet:param name="esfstartDate" value="<%=String.valueOf(role.getStartDate()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=removeRoleURL.toString() %>" message="remove-role"/>
	</c:if>
</liferay-ui:icon-menu>