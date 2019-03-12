<%@ include file="/html/init.jsp" %>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.permission.ESFCardPermission"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.service.permission.PortletPermission"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="it.ethica.esf.permission.ESFCardPermission"%>
<%@page import="it.ethica.esf.permission.ESFCardModelPermission"%>
<%@page import="it.ethica.esf.service.ESFConfigurationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFConfigurationImpl"%>
<%@page import="it.ethica.esf.model.ESFConfiguration"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%
PortletURL portletURL = renderResponse.createRenderURL();
%>