<%@ include file="/html/init.jsp" %>

<%@page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.service.ESFTournamentLocalServiceUtil"%>
<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@page import="it.ethica.esf.model.ESFTournament"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.ethica.esf.permission.ESFTournamentPermission"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="it.ethica.esf.model.impl.ESFTeamImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="it.ethica.esf.service.ESFTeamLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFTeam"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFNationalLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFNational"%>
<%@page import="it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="it.ethica.esf.service.persistence.ESFNationalDelegationPK"%>
<%@page import="it.ethica.esf.model.ESFNationalDelegation"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterQualification"%>
<%@page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterCategory"%>
<%@page import="it.ethica.esf.util.ESFListType"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();

long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
// ESFTournament esfTournamentParam = ESFTournamentLocalServiceUtil.getESFTournament(esfTournamentId);

ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
		.fetchESFOrganization(currentOrganizationId);

// int currentType = 0;
// boolean isRoot = true;

// if (currentESFOrganization != null) {

// 	currentType = currentESFOrganization.getType();
// 	isRoot = currentType == 0 ? true : false;
// }
%>
