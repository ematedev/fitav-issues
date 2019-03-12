<%@ include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@page import="it.ethica.esf.service.ESFAirportLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFAirport"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);


long currentOrganizationId = group.getOrganizationId();

long organizationId = group.getOrganizationId();
%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>' />
</portlet:renderURL>