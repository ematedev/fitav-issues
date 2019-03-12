<%@ include file="/html/init.jsp"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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
<%@page
	import="com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="it.ethica.esf.model.ESFField"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFOrganizationModel"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.permission.ESFOrganizationPermission"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.permission.ESFSportAssociationPermission"%>
<%@page import="it.ethica.esf.permission.ESFSportAssociationModelPermission"%>

<%
	long esfOrganizationId = ParamUtil.getLong(request,
			"esfOrganizationId");

	boolean isSimplyOrganizzation = ParamUtil.getBoolean(request,
		"isSimplyOrganizzation",false);

	int currentType = 0;

	int orgSelectedType = 0;

	ESFOrganization esfOrganization = null;

	if (esfOrganizationId > 0) {

		esfOrganization = ESFOrganizationLocalServiceUtil
				.getESFOrganization(esfOrganizationId);

		orgSelectedType = Integer.valueOf(String
				.valueOf(esfOrganization.getType()));
		
		isSimplyOrganizzation=esfOrganization.getIsSimplyOrganizzation();
	}

	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

	long currentOrganizationId = group.getOrganizationId();

	ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
			.fetchESFOrganization(currentOrganizationId);

	if (currentESFOrganization != null) {

		currentType = Integer.valueOf(String
				.valueOf(currentESFOrganization.getType()));
	}
	
%>

<portlet:renderURL var="viewURL" windowState='<%= WindowState.NORMAL.toString()%>'>
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>
