<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil"%><%@
page import="com.liferay.portal.util.PortalUtil"%><%@
page import="javax.portlet.WindowState"%><%@
page import="it.ethica.esf.util.ESFListType"%><%@
page import="com.liferay.portal.service.ListTypeServiceUtil"%><%@
page import="com.liferay.portal.model.ListType"%><%@
page import="it.ethica.esf.util.ESFKeys"%><%@
page import="com.liferay.portal.kernel.util.HtmlUtil"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="com.liferay.portal.kernel.util.Validator"%><%@
page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%><%@
page import="java.util.ArrayList"%><%@
page import="it.ethica.esf.model.ESFAddress"%><%@
page import="java.util.List"%>
<portlet:defineObjects />

<liferay-theme:defineObjects />
<%!
private static Log _log = LogFactoryUtil.getLog("init.jsp");
%>
<%
WindowState windowState = renderRequest.getWindowState();

String currentURL = PortalUtil.getCurrentURL(request);

String redirect = ParamUtil.getString(request, "redirect", currentURL);

String rootPortletId = portletDisplay.getRootPortletId();

String templatePath = portletConfig.getInitParameter("template-path");

String jspAddressTL = "/html/address_tl.jsp";

String jspPhoneTL = "/html/phone_tl.jsp";

String jspMachineTL = "/html/machine_tl.jsp";

%>