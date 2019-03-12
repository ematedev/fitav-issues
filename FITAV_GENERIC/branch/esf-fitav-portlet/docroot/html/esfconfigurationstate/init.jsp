<%@ include file="/html/init.jsp" %>

<%@page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.model.ClassName"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>

<%
long esfStateId = ParamUtil.getLong(request, "esfStateId");
%>

<portlet:actionURL name="updateESFStateAssEntity"
	var="updateESFStateAssEntityVar" />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>' />
</portlet:renderURL>