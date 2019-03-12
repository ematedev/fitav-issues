<%@ include file="/html/init.jsp" %>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" 
	value='<%= templatePath+"popup/view.jsp" %>' />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchUserURL">
	<portlet:param name="mvcPath" 
	value='<%= templatePath+"popup/view_search.jsp" %>' />
</liferay-portlet:renderURL>