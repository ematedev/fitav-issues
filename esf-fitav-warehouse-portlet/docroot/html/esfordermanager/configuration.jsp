<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<%
	String folderName =
		GetterUtil.getString(portletPreferences.getValue(
			"folderName", StringPool.BLANK));

	String saleValues = GetterUtil.getString(portletPreferences.getValue(
		"saleValues", StringPool.BLANK));
	String vatValues = GetterUtil.getString(portletPreferences.getValue(
		"vatValues", StringPool.BLANK));
%>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<aui:input name="preferences--folderName--" type="text" value="<%= folderName %>" />
	<aui:input helpMessage="add-one-value-per-line" name="preferences--saleValues--" type="textarea" value="<%= saleValues %>" />
	<aui:input helpMessage="add-one-value-per-line" name="preferences--vatValues--" type="textarea" value="<%= vatValues %>" />
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>