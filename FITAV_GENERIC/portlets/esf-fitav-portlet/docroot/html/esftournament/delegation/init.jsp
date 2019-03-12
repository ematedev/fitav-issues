<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>

<%
List<ESFUserRole> coach =
	ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
		"Allenatore", "Allenatore", ESFKeys.ESFStateType.ENABLE);

long coachClassPK = 0;

if (!coach.isEmpty()) {

	coachClassPK = coach.get(0).getEsfUserRoleId();
}
%>

<portlet:renderURL var="viewURL" windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>'/>
</portlet:renderURL>

<portlet:renderURL var="delegationURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "delegation/view.jsp" %>'/>
	<portlet:param name="esfTournamentId" value='<%= String.valueOf(esfTournamentId) %>'/>
</portlet:renderURL>

