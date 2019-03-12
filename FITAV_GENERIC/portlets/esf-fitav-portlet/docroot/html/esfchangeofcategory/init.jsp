<%@ include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="it.ethica.esf.model.ESFRenewal"%>
<%@page import="it.ethica.esf.service.ESFRenewalLocalServiceUtil"%>
<%@page import="it.ethica.esf.migration.util.ManageDate"%>
<%@page import="it.ethica.esf.permission.ESFUserAdminPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.security.acl.Owner"%>
<%@page import="javax.portlet.PortletURL"%>	
<%@page import="sun.security.acl.OwnerImpl"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="java.util.Date"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactory"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.text.SimpleDateFormat"%><%@
page import="java.util.ResourceBundle" %><%@
page import="java.util.Locale" %>
<%@page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterCategory"%>
<%@page import="it.ethica.esf.service.ESFCategoryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCategory"%>
<%@page import="it.ethica.esf.service.ESFUserCategoryLocalServiceUtil"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>


<% 
	PortletURL portletURL = renderResponse.createRenderURL();
	Locale local = renderRequest.getLocale();
	//ResourceBundle res = portletConfig.getResourceBundle(locale);
%>