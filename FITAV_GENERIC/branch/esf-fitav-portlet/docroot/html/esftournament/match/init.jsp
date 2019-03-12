<%@ include file="/html/esftournament/init.jsp" %>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.impl.ESFFieldLocalServiceImpl"%>
<%@page import="it.ethica.esf.permission.ESFMatchPermission"%>
<%@page import="it.ethica.esf.model.ESFMatch"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="it.ethica.esf.model.ESFField"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="it.ethica.esf.model.ESFPartecipant"%>
<%@page import="it.ethica.esf.service.ESFPartecipantLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%

long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

// boolean isNational = ParamUtil.getBoolean(request, "isNational");

ESFTournament esfTournament = null;

if(esfTournamentId > 0){
	esfTournament = ESFTournamentLocalServiceUtil.getESFTournament(esfTournamentId);
}

%>
