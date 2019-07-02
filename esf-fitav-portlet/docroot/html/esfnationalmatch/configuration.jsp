<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@include file="init.jsp"%>

<%
	boolean olimpicMatch = GetterUtil.getBoolean(portletPreferences.getValue("olimpicMatch", StringPool.TRUE));
	boolean nationalMatch = GetterUtil.getBoolean(portletPreferences.getValue("nationalMatch", StringPool.FALSE));
	boolean event = GetterUtil.getBoolean(portletPreferences.getValue("event", StringPool.FALSE));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%=configurationURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
	
	<aui:input name="preferences--olimpicMatch--" type="checkbox" label="olimpicMatch" value="<%= olimpicMatch %>" />
	<aui:input name="preferences--nationalMatch--" type="checkbox" label="nationalMatch" value="<%= nationalMatch %>" />
	<aui:input name="preferences--event--" type="checkbox" label="event" value="<%= event %>" />
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>