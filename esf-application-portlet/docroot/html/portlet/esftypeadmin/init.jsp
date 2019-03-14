<%@include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="it.ethica.esf.service.ESFTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="it.ethica.esf.model.ESFType"%>
<%@page import="java.text.DateFormat"%>

<% String portletRoot = "/html/portlet/esftypeadmin"; %>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=portletRoot + "/view.jsp" %>' />
</portlet:renderURL>