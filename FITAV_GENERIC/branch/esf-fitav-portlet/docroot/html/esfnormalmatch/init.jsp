<%@ include file="/html/init.jsp" %><%@
page import="it.ethica.esf.service.ESFPartecipantTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFPartecipantType" %><%@
page import="java.util.Date"%><%@
page import="it.ethica.esf.service.ESFPartecipantTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFPartecipantType" %><%@
page import="it.ethica.esf.permission.ESFUserAdminPermission"%><%@
page import="java.util.ResourceBundle"%><%@
page import="java.util.LinkedList"%><%@
page import="java.util.Locale"%><%@
page import="it.ethica.esf.model.ESFPartecipantType"%><%@
page import="it.ethica.esf.service.ESFPartecipantTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFDocument"%><%@
page import="it.ethica.esf.service.ESFDocumentLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFGun"%><%@
page import="it.ethica.esf.model.ESFGunKind"%><%@
page import="it.ethica.esf.model.ESFGunType"%><%@
page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%><%@	
page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%><%@
page import="com.liferay.portal.model.ListType"%><%@
page import="com.liferay.portal.service.ListTypeServiceUtil"%><%@
page import="com.liferay.portal.model.User"%><%@
page import="com.liferay.portal.service.UserLocalServiceUtil"%><%@
page import="javax.portlet.PortletSessionUtil"%><%@
page import="com.liferay.portal.kernel.servlet.SessionErrors"%><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages"%><%@
page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%><%@
page import="it.ethica.esf.util.ESFKeys"%><%@
page import="it.ethica.esf.util.ActionKeys"%><%@
page import="it.ethica.esf.service.ESFTournamentLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFTournament"%><%@
page import="java.util.List"%><%@
page import="java.text.SimpleDateFormat"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil"%><%@
page import="com.liferay.portal.model.Group"%><%@
page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFOrganization"%><%@
page import="java.util.Calendar"%><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%><%@
page import="it.ethica.esf.util.ManageDate"%><%@
page import="it.ethica.esf.model.impl.ESFTeamImpl"%><%@
page import="java.util.ArrayList"%><%@
page import="java.util.Collections"%><%@
page import="com.liferay.portal.kernel.util.Validator"%><%@
page import="com.liferay.portal.kernel.util.StringUtil"%><%@
page import="it.ethica.esf.service.ESFTeamLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFTeam"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFGun"%><%@
page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFUser"%><%@
page import="it.ethica.esf.service.ESFNationalLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFNational"%><%@
page import="it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFSportType"%><%@
page import="it.ethica.esf.model.ESFUserRole"%><%@
page import="it.ethica.esf.service.persistence.ESFNationalDelegationPK"%><%@
page import="it.ethica.esf.model.ESFNationalDelegation"%><%@
page import="com.liferay.portal.service.ServiceContextFactory"%><%@
page import="com.liferay.portal.service.ServiceContext"%><%@
page import="it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFShooterQualification"%><%@
page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFShooterCategory"%><%@
page import="it.ethica.esf.util.ESFListType"%><%@
page import="com.liferay.portal.service.ListTypeServiceUtil"%><%@
page import="com.liferay.portal.model.ListType"%><%@
page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%><%@
page import="it.ethica.esf.service.impl.ESFFieldLocalServiceImpl"%><%@
page import="it.ethica.esf.permission.ESFMatchPermission"%><%@
page import="it.ethica.esf.model.ESFMatch"%><%@
page import="com.liferay.portal.kernel.util.HtmlUtil"%><%@
page import="com.liferay.portal.kernel.util.Validator"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="it.ethica.esf.model.ESFField"%><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%><%@
page import="it.ethica.esf.util.ManageDate"%><%@
page import="it.ethica.esf.model.ESFPartecipant"%><%@
page import="it.ethica.esf.service.ESFPartecipantLocalServiceUtil"%><%@
page import="javax.portlet.PortletURL"%><%@
page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFDescription"%><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%><%@
page import="it.ethica.esf.model.ESFMatchType"%><%@
page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%><%@
page import="com.liferay.portlet.documentlibrary.*" %><%@
page import="com.liferay.portal.util.PortalUtil"%><%@
page import="it.ethica.esf.service.ESFPartecipantTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFPartecipantType" %><%@
page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil" %>
<%@page import="it.ethica.esf.service.ESFShooterCategoryESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFShooterCategoryESFMatchLocalService"%>
<%@page import="it.ethica.esf.permission.ESFNormalMatchModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFNormalMatchPermission"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.ThemeLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Theme"%>
<%@page import="com.liferay.portal.service.ThemeServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="it.ethica.esf.model.ESFOrganizationModel"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.service.persistence.RoleUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys.ESFUserRoleMatch"%>
<%@page import="it.ethica.esf.service.persistence.ESFUserESFUserRoleUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import = "com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import = "com.liferay.portal.theme.ThemeDisplay" %>


<%
Locale local = renderRequest.getLocale();
ResourceBundle res = portletConfig.getResourceBundle(locale);

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();

ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
		.fetchESFOrganization(currentOrganizationId);

long esfMatchId = ParamUtil.getLong(request, "esfMatchId",0);



if(esfMatchId == 0 && Validator.isNotNull(portletSession.getAttribute("esfMatchId"))){
	esfMatchId = (Long)portletSession.getAttribute("esfMatchId");
}

boolean isNational=false;
%>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
	<portlet:param name="esfMatchId"
				value='<%=String.valueOf(esfMatchId)%>' />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
		<portlet:param name="organizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
</portlet:renderURL>