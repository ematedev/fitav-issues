<%@ include file="/html/init.jsp" %>

<%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%><%@
page import="com.liferay.portal.kernel.util.HtmlUtil"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="com.liferay.portal.kernel.util.StringUtil"%><%@
page import="com.liferay.portal.kernel.util.Validator"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="com.liferay.portal.model.Country"%><%@
page import="com.liferay.portal.model.Group"%><%@
page import="com.liferay.portal.model.ListType"%><%@
page import="com.liferay.portal.model.User"%><%@
page import="com.liferay.portal.service.CountryServiceUtil"%><%@
page import="com.liferay.portal.service.ListTypeServiceUtil"%><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil"%><%@
page import="com.liferay.portal.service.ServiceContext"%><%@
page import="com.liferay.portal.service.ServiceContextFactory"%><%@
page import="com.liferay.portal.service.UserLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFDescription"%><%@
page import="it.ethica.esf.model.ESFDocument"%><%@
page import="it.ethica.esf.model.ESFField"%><%@
page import="it.ethica.esf.model.ESFFlight"%><%@
page import="it.ethica.esf.model.ESFGun"%><%@
page import="it.ethica.esf.model.ESFGunKind"%><%@
page import="it.ethica.esf.model.ESFGunType"%><%@
page import="it.ethica.esf.model.ESFMatch"%><%@
page import="it.ethica.esf.model.ESFMatchType"%><%@
page import="it.ethica.esf.model.ESFNational"%><%@
page import="it.ethica.esf.model.ESFNationalDelegation"%><%@
page import="it.ethica.esf.model.ESFNationalDelegationSoap"%><%@
page import="it.ethica.esf.model.ESFNationalMatchResult"%><%@
page import="it.ethica.esf.model.ESFOrganization"%><%@
page import="it.ethica.esf.model.ESFPartecipant"%><%@
page import="it.ethica.esf.model.ESFPartecipantType"%><%@
page import="it.ethica.esf.model.ESFPhone"%><%@
page import="it.ethica.esf.service.ESFPhoneLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFShooterCategory"%><%@
page import="it.ethica.esf.model.ESFShooterQualification"%><%@
page import="it.ethica.esf.model.ESFSportType"%><%@
page import="it.ethica.esf.model.ESFTeam"%><%@
page import="it.ethica.esf.model.ESFTournament"%><%@
page import="it.ethica.esf.model.ESFUser"%><%@
page import="it.ethica.esf.model.ESFUserRole"%><%@
page import="it.ethica.esf.model.impl.ESFTeamImpl"%><%@
page import="it.ethica.esf.permission.ESFMatchPermission"%><%@
page import="com.liferay.portal.theme.ThemeDisplay"%><%@
page import="it.ethica.esf.permission.ESFTournamentPermission"%><%@
page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFDocumentLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFFlightLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFNationalLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFPartecipantLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFPartecipantTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFTeamLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFTournamentLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%><%@	
page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.impl.ESFFieldLocalServiceImpl"%><%@
page import="it.ethica.esf.service.persistence.ESFNationalDelegationPK"%><%@
page import="it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil"%><%@
page import="it.ethica.esf.util.ActionKeys"%><%@
page import="it.ethica.esf.util.ESFKeys"%><%@
page import="it.ethica.esf.util.ESFListType"%><%@
page import="it.ethica.esf.util.ManageDate"%><%@
page import="org.joda.time.Days"%><%@
page import="org.joda.time.DateTime"%><%@
page import="java.util.ArrayList"%><%@
page import="java.util.Collections"%><%@
page import="java.util.Date"%><%@
page import="java.util.List"%><%@
page import="java.text.SimpleDateFormat"%><%@
page import="java.util.Calendar"%><%@
page import="javax.portlet.PortletURL"%><%@
page import="java.util.ResourceBundle" %><%@
page import="java.util.Locale" %>
<%@page import="java.util.prefs.Preferences"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="it.ethica.esf.permission.ESFNationalMatchPermission"%>
<%@page import="it.ethica.esf.permission.ESFNationalMatchModelPermission"%>

<%@ page import= "com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import= "javax.portlet.PortletPreferences" %>
<%@page import="it.ethica.esf.model.impl.ESFSportTypeImpl"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%><%@
page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCatridge"%><%@
page import="it.ethica.esf.service.ESFCaneLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCane"%>
<%@page import="it.ethica.esf.model.impl.ESFMatchImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFOrganizationImpl"%>
<%@page import="java.util.Hashtable"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="net.sf.jasperreports.util.NoWriteFieldHandler"%>
<%@page import="it.ethica.esf.service.impl.ESFMatchTypeLocalServiceImpl"%>
<%@page import="java.util.Hashtable"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFNationalMatchResultImpl"%>
<%@page import="com.liferay.portal.service.persistence.RoleUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys.ESFUserRoleMatch"%>
<%@page import="it.ethica.esf.service.persistence.ESFUserESFUserRoleUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="it.ethica.esf.model.ESFAirport"%>
<%@page import="it.ethica.esf.service.ESFAirportLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFDepartureLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDeparture"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="it.ethica.esf.model.impl.ESFCatridgeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFCaneImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.service.ESFJobLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFJob"%>

<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.permission.ESFGunPermission"%>


<portlet:defineObjects />


<%
Locale local = renderRequest.getLocale();
ResourceBundle res = portletConfig.getResourceBundle(locale);

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();

ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
		.fetchESFOrganization(currentOrganizationId);

int currentType = 0;

if (currentESFOrganization != null) {

	currentType =
		Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
}


boolean isNational=true;

%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
	<portlet:param name="organizationId" value="<%=String.valueOf(currentOrganizationId)%>" />
</portlet:renderURL>