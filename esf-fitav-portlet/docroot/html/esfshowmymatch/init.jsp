<%@include file="/html/init.jsp"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.service.ESFPartecipantLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFPartecipant"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalService"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.model.ESFMatch"%>
<%@page import="it.ethica.esf.service.persistence.ESFPartecipantTypeUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>

<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="it.ethica.esf.model.ESFUser"%>


<!-- metodo visto in ESFCard->init & ESFCard->view -->
<%-- <liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view_search.jsp"%>' />
</liferay-portlet:renderURL> --%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view_search.jsp"%>' />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</liferay-portlet:renderURL>

<%
	ESFUser utente = null;
	ESFDescription description = null;
	long userId = 0;
	try {
		themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		userId = themeDisplay.getUserId();
		utente = ESFUserLocalServiceUtil.getESFUser(userId);
	} catch (Exception e) {
		e.printStackTrace();
	}

	/*get delle chiavi di ricerca 
	long companyId = themeDisplay.getCompanyId();
	System.out.println("company id: " + companyId);
	String className = ESFUser.class.getName();
	System.out.println("class name: " + className);
	long classPK = utente.getPrimaryKey();
	System.out.println("classPK: " + classPK); */

	/*get dei match dell'utente loggato*/
	List<ESFMatch> myMatches = null;
	try {
		myMatches = ESFMatchLocalServiceUtil.findbyUserId_IsNational(
				userId, false);
	} catch (Exception e) {
		e.printStackTrace();
	}

	/*get dei tipi di sport*/
	List<ESFSportType> sportTypes = null;
	try {
		sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
	} catch (Exception e) {
		e.printStackTrace();
	}

	/*get delle associazioni sportive*/
	List<ESFOrganization> organizations = null;
	try {
		organizations = ESFOrganizationLocalServiceUtil
				.findAllESFOrganizations(3, ESFKeys.ESFStateType.ENABLE);
	} catch (Exception e) {
		e.printStackTrace();
	}

	/*get dell'utente se partecipante*/
	ESFPartecipant partecipant = null;
	try {
		partecipant = ESFPartecipantLocalServiceUtil.findbyUserId(userId);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	boolean isNational=false;
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String startDate =ManageDate.CalendarToString(calendar);
	System.out.println("////////////////////////startDate in init: "+startDate);
	Date date=null;
%>