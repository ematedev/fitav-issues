<%@include file="../init.jsp" %>

<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFOrganizationModel"%>
<%@page import="it.ethica.esf.model.ESFType"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.permission.ESFModelPermission"%>
<%@page import="it.ethica.esf.service.permission.ESFOrganizationPermission"%>

<%@page import="java.text.DateFormat"%>

<% String portletRoot = "/html/portlet/esforganizationadmin"; %>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=portletRoot + "/view.jsp" %>' />
</portlet:renderURL>