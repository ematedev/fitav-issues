<%@ include file="init.jsp" %>

<h3><liferay-ui:message key="renewal-request-was-taken-over" /></h3>

<aui:button-row>
	<aui:button href="<%= group.getPathFriendlyURL(true, themeDisplay) + group.getFriendlyURL() %>" value="back" />
</aui:button-row>