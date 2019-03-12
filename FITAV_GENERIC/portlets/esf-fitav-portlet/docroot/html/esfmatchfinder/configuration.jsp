<%@include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

<%
	boolean nationalFinder_cfg =
		GetterUtil.getBoolean(portletPreferences.getValue(
			"nationalFinder", StringPool.TRUE));
%>

<h2>
	<liferay-ui:message key = "choose-match-type"/>
</h2>

<aui:form action="<%=configurationURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />

	<aui:input name="preferences--nationalFinder--" type="checkbox" value="<%=nationalFinder_cfg%>" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>