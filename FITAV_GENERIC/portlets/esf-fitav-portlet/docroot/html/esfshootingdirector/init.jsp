<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/html/init.jsp" %>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShootingDirectorQualification"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShootingDirector"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFRegionUtil"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFRegion"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.model.impl.ESFCardImpl"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>

<%
PortletPreferences prefs = renderRequest.getPreferences();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();

Locale local = renderRequest.getLocale();
ResourceBundle res = portletConfig.getResourceBundle(locale);
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

