<%@ include file="/html/init.jsp" %>

<%@page import="it.ethica.esf.service.ESFNationalLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFNational"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ContactLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Contact"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
int juniorMaxAge = 20;

Calendar juniorMaxBirthday = CalendarFactoryUtil.getCalendar();

juniorMaxBirthday.add(Calendar.YEAR, -juniorMaxAge);
%>