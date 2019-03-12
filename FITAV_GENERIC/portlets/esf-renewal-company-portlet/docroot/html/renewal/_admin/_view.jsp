<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/init.jsp" %>

<portlet:renderURL var="toRenewURL">
	<portlet:param name="mvcPath" value="/html/renewal/admin/to_renew.jsp"/>
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:renderURL>

<portlet:renderURL var="renewedURL">
	<portlet:param name="mvcPath" value="/html/renewal/admin/renewed.jsp"/>
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:renderURL>

<aui:button-row cssClass="admin-select">
	<aui:button value="to-renew" onClick="<%= toRenewURL %>" />
	<aui:button value="renewed" onClick="<%= renewedURL %>" />
</aui:button-row>