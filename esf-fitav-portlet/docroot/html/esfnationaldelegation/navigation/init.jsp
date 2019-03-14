<%@include file="../init.jsp"%>

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
page import="com.liferay.portal.model.User"%><%@
page import="com.liferay.portal.service.CountryServiceUtil"%><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil"%><%@
page import="com.liferay.portal.service.ServiceContext"%><%@
page import="com.liferay.portal.service.ServiceContextFactory"%><%@
page import="com.liferay.portal.service.UserLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFDescription"%><%@
page import="it.ethica.esf.model.ESFField"%><%@
page import="it.ethica.esf.model.ESFFlight"%><%@
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
page import="it.ethica.esf.permission.ESFTournamentPermission"%><%@
page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFFlightLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%><%@
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
page import="java.util.Locale" %><%@
page import="it.ethica.esf.util.ESFKeys.ESFAddressListType"%><%@
page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%><%@
page import="com.liferay.portal.model.Contact"%><%@
page import="com.liferay.portal.model.User"%><%@
page import="com.liferay.portal.service.UserLocalServiceUtil"%><%@
page import="com.liferay.portal.kernel.util.StringUtil"%><%@
page import="com.liferay.portal.service.ListTypeServiceUtil"%><%@
page import="com.liferay.portal.model.ListType"%><%@
page import="it.ethica.esf.util.ESFListType"%><%@
page import="it.ethica.esf.model.ESFCountry"%><%@
page import="it.ethica.esf.service.ESFCountryLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFEntityState"%><%@
page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCard"%><%@
page import="com.liferay.portal.service.CompanyLocalServiceUtil"%><%@
page import="it.ethica.esf.permission.ESFGunPermission"%><%@
page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCatridge"%>
<%


	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	if(esfUserId == 0){
		esfUserId = (Long)request.getAttribute("esfUserId");
	}

		request.setAttribute(
			"addresses.className", ESFUser.class.getName());
		request.setAttribute("addresses.classPK", esfUserId);
		request.setAttribute(
			"phones.className", ESFUser.class.getName());
		request.setAttribute("phones.classPK", esfUserId);
		request.setAttribute(
			"websites.className", ESFUser.class.getName());
		request.setAttribute("websites.classPK", esfUserId);
		request.setAttribute(
			"card.userId", esfUserId);
		
	ESFUser esfUser = null;
	String skype=null;
	long userCardId=0;

	if (esfUserId > 0) {
		esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
		User tmpUser = UserLocalServiceUtil.fetchUser(esfUserId);
		Contact userContatc = tmpUser.getContact();
		skype = userContatc.getSkypeSn();
	}
%>
