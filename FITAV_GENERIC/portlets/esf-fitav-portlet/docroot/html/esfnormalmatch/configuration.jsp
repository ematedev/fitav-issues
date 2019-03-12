<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@include file="init.jsp"%>

<%
	boolean isViewMode_cfg = GetterUtil.getBoolean(portletPreferences.getValue("isViewMode", StringPool.TRUE));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%=configurationURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
	
	<aui:input name="preferences--isViewMode--" type="checkbox" value="<%= isViewMode_cfg %>" />
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>