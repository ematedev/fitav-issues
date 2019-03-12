<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@ include file="/html/init.jsp"%>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.ethica.esf.permission.ESFGunTypePermission"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.permission.ESFGunModelPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="it.ethica.esf.permission.ESFGunKindPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>


<%
Locale local = renderRequest.getLocale();
ResourceBundle res = portletConfig.getResourceBundle(locale);
%>