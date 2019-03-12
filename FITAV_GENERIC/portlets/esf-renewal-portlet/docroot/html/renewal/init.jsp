
<%@page import="com.liferay.portal.model.ResourceConstants"%>
<%@page import="com.liferay.portal.service.ResourcePermissionLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.ethica.esf.util.ESFRenewalConstants"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@ include file="/html/init.jsp" %>
<%@page import="java.util.Date"%>
<%@page import="com.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>

<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
</portlet:renderURL>

<%

String classNameAddr = (String)request.getAttribute("addresses.className");
long classPKAddr = (Long)request.getAttribute("addresses.classPK");

List<ESFAddress> esfAddresses = Collections.emptyList();

esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(
	themeDisplay.getCompanyId(), classNameAddr, classPKAddr);

ESFAddress esfAddressesToPrint [] = new ESFAddress[esfAddresses.size()];

int x = 0;

for(ESFAddress esfAddress : esfAddresses) {
	esfAddressesToPrint[x] = esfAddress;
	x++;
}


long groupid = themeDisplay.getScopeGroupId();
Group siteGroup = GroupLocalServiceUtil.getOrganizationGroup(themeDisplay.getCompanyId(), currentOrganizationId);
long siteGroupId = siteGroup.getGroupId();


ServiceContext serviceContext = new ServiceContext();
serviceContext.setCompanyId(themeDisplay.getCompanyId());
long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

Group global = GroupLocalServiceUtil.fetchFriendlyURLGroup(themeDisplay.getCompanyId(), ESFRenewalConstants.PATH_FOLDER_GLOBAL);
long globalId = global.getGroupId();

%>