<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<%
	List<ESFUserRole> allEsfUserRolePerPage = ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(ESFKeys.ESFStateType.ENABLE);
	%>
	<aui:select name="preferences--requiredRoles--" multiple="true" label="required-roles">
	<%
	for (ESFUserRole role : allEsfUserRolePerPage) {
		boolean selected = false;
		if (ArrayUtil.contains(requiredRolesList, Long.toString(role.getEsfUserRoleId()))) {
			selected = true;
		}
	%>
		<aui:option value="<%= role.getEsfUserRoleId() %>" selected="<%= selected %>"><%= role.getTitle() %></aui:option>
	<%
	}
	%>
	</aui:select>

	<aui:button type="submit" />
</aui:form>