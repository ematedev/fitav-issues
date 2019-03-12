<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="it.ethica.esf.permission.ESFUserModelPermission"%><%@
page import="com.liferay.portal.kernel.language.LanguageUtil"%><%@
page import="com.liferay.portal.kernel.util.ParamUtil"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="it.ethica.esf.model.ESFUser"%><%@
page import="it.ethica.esf.model.ESFUserModel"%><%@
page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%><%@
page import="it.ethica.esf.util.ActionKeys"%><%@
page import="it.ethica.esf.permission.ESFUserPermission"%><%@
page import="java.text.DateFormat"%>

<portlet:defineObjects />
<theme:defineObjects />

<%
String templatePath = portletConfig.getInitParameter("template-path");
%>

<portlet:renderURL var="viewURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>' />
</portlet:renderURL>
