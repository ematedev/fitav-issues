<%@ include file="/html/init.jsp" %>
<%@ page import="com.ethica.esf.model.ESFArticleType" %><%@
page import="com.ethica.esf.model.ESFStockist" %><%@
page import="it.ethica.esf.model.ESFUser" %><%@
page import="com.ethica.esf.service.ESFArticleTypeLocalServiceUtil"%><%@
page import="com.ethica.esf.service.ESFStockistLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%><%@ 
page import="it.ethica.esf.model.ESFCard"%><%@
page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%><%@ 
page import="com.ethica.esf.model.ESFArticle"%><%@
page import="com.ethica.esf.service.ESFArticleLocalServiceUtil"%><%@ 
page import="com.ethica.esf.model.ESFOrder"%><%@
page import="com.ethica.esf.service.ESFOrderLocalServiceUtil"%>
<%@page import="com.ethica.esf.util.ESFArticleConstants"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath + "view_search.jsp" %>' />
</liferay-portlet:renderURL>