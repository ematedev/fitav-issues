<%@ include file="/html/init.jsp" %>

<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.model.LayoutSetPrototype"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>


<%@page import="it.ethica.esf.model.ESFOrganizationUnitservice"%>
<%@page import="it.ethica.esf.model.ESFField"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFOrganizationModel"%>
<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFOrganizationPermission"%>
<%@page import="it.ethica.esf.service.ESFUnitserviceLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ESFServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.model.ESFUnitservice"%>
<%@page import="it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil"%>

<%
long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");

ESFOrganization esfOrganization = null;

if (esfOrganizationId > 0) {
	esfOrganization =
		ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
}

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();
ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
		.fetchESFOrganization(currentOrganizationId);

int currentType = 0;

if (currentESFOrganization != null) {

	currentType = Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>' />
</portlet:renderURL>