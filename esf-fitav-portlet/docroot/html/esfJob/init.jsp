<%@ include file="/html/init.jsp"%>

<%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="it.ethica.esf.model.ESFJob"%><%@
page import="it.ethica.esf.service.ESFJobLocalServiceUtil"%><%@
page import="java.util.ResourceBundle" %><%@
page import="java.util.Locale" %>

<%
 Locale local = renderRequest.getLocale();
 ResourceBundle res = portletConfig.getResourceBundle(locale);
 %> 

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view_search.jsp"%>' />
</liferay-portlet:renderURL>