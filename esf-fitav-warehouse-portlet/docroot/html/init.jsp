<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="com.ethica.esf.util.ESFOrderConstants"%><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="com.liferay.portal.kernel.language.LanguageUtil"%><%@
page import="com.liferay.portal.kernel.util.ParamUtil"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="com.liferay.portal.kernel.util.Validator"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="com.liferay.portal.model.Group"%><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil"%><%@
page import="com.liferay.portal.util.PortalUtil"%>


<%@page import="javax.portlet.WindowState"%>

<%@page import="java.util.List"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
WindowState windowState = renderRequest.getWindowState();

String currentURL = PortalUtil.getCurrentURL(request);

String redirect = ParamUtil.getString(request, "redirect", currentURL);

String rootPortletId = portletDisplay.getRootPortletId();

String templatePath = portletConfig.getInitParameter("template-path");

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();
%>

<liferay-portlet:renderURL var="viewURL">
	<liferay-portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
</liferay-portlet:renderURL>