<%@ include file="/html/init.jsp"%>

<%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page
	import="com.liferay.portal.kernel.portlet.LiferayWindowState"%><%@
page
	import="com.liferay.portal.kernel.util.StringPool"%><%@
page
	import="com.liferay.portal.kernel.util.WebKeys"%><%@
page
	import="it.ethica.esf.model.ESFDocument"%><%@
page
	import="it.ethica.esf.service.ESFDocumentLocalServiceUtil"%><%@
page
	import="java.util.ResourceBundle"%><%@
page import="java.util.Locale"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactory"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="it.ethica.esf.util.ESFListType"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import=" com.liferay.portal.kernel.servlet.SessionErrors"%>

<%
	Locale local = renderRequest.getLocale();
	ResourceBundle res = portletConfig.getResourceBundle(locale);

	Long esfUserId = themeDisplay.getUserId();
%>



<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>