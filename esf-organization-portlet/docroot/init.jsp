<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="com.liferay.portal.kernel.exception.SystemException"%><%@
page import="com.liferay.portal.kernel.exception.PortalException"%><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="com.liferay.portal.kernel.search.Indexer"%><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%><%@
page import="com.liferay.portal.kernel.search.SearchContext"%><%@
page import="com.liferay.portal.kernel.search.SearchContextFactory"%><%@
page import="com.liferay.portal.kernel.util.GetterUtil"%><%@
page import="com.liferay.portal.kernel.util.ParamUtil"%><%@
page import="com.liferay.portal.kernel.util.StringUtil"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="com.liferay.portal.kernel.util.Validator"%><%@
page import="com.liferay.portal.kernel.language.LanguageUtil"%><%@
page import="com.liferay.portal.kernel.log.Log"%><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil"%><%@
page import="com.liferay.portal.kernel.search.Document"%><%@
page import="com.liferay.portal.kernel.search.Field"%><%@
page import="com.liferay.portal.kernel.search.Hits"%><%@
page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="it.ethica.esf.model.ESFField"%><%@
page import="it.ethica.esf.model.ESFOrganization"%><%@
page import="it.ethica.esf.model.ESFOrganizationModel"%><%@
page import="it.ethica.esf.model.ESFSportType"%><%@
page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%><%@
page import="it.ethica.esf.service.permission.ActionKeys"%><%@
page import="it.ethica.esf.service.permission.ESFFieldModelPermission"%><%@
page import="it.ethica.esf.service.permission.ESFFieldPermission"%><%@
page import="it.ethica.esf.service.permission.ESFOrganizationPermission"%><%@
page import="it.ethica.esf.util.WebKeys"%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<portlet:defineObjects />
<theme:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
String redirect = ParamUtil.getString(request, "redirect", currentURL);
String templatePath = portletConfig.getInitParameter("template-path");

%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>' />
</portlet:renderURL>
