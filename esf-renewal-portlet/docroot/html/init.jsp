
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil"%><%@
page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalService"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>

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
ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);

int currentType = 0;

if (currentESFOrganization != null) {

	currentType = Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
}


ESFUserRole esfUserRole = null;

long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");

if (esfUserRoleId > 0) {
	esfUserRole =
		ESFUserRoleLocalServiceUtil.getESFUserRole(esfUserRoleId);
}

request.setAttribute("addresses.className", Organization.class.getName());
request.setAttribute("addresses.classPK", currentOrganizationId);
request.setAttribute("emailAddresses.className", ESFOrganization.class.getName());
request.setAttribute("emailAddresses.classPK", currentOrganizationId);
request.setAttribute("phones.className", Organization.class.getName());
request.setAttribute("phones.classPK", currentOrganizationId);
%>