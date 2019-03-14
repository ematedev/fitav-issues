<%@ include file="/html/init.jsp" %>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.ethica.esf.service.ESFUnitserviceLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUnitservice"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFFornitureTypePermission"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long organizationId = group.getOrganizationId();
%>

<portlet:renderURL var="viewURL" >
	
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>'/>
</portlet:renderURL>
