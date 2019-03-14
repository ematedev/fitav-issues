<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@include file="/html/init.jsp"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.impl.ESFConfigurationImpl"%>
<%@page import="it.ethica.esf.model.ESFConfiguration"%>
<%@page import="it.ethica.esf.service.ESFConfigurationLocalServiceUtil"%>

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();
%>