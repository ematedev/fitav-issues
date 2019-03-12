<%@ include file="/html/init.jsp" %>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.ethica.esf.service.ESFCountryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCountry"%>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalService"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>





<%
	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

	long currentOrganizationId = group.getOrganizationId();

	ESFOrganization currentESFOrganization =
		ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);

	int currentType = 0;

	if (currentESFOrganization != null) {

		currentType =
			Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
	}
%>