<%@ include file="/html/init.jsp" %>

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
long siteGroupId = 0;
try {
	Group siteGroup = GroupLocalServiceUtil.getOrganizationGroup(themeDisplay.getCompanyId(), currentOrganizationId);
	siteGroupId = siteGroup.getGroupId();
}
catch(Exception ex) {
}

ServiceContext serviceContext = new ServiceContext();
serviceContext.setCompanyId(themeDisplay.getCompanyId());
long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

Group global = GroupLocalServiceUtil.fetchFriendlyURLGroup(themeDisplay.getCompanyId(), ESFRenewalConstants.PATH_FOLDER_GLOBAL);
long globalId = global.getGroupId();

String requiredRoles = portletPreferences.getValue("requiredRoles", StringPool.BLANK);
String[] requiredRolesList = StringUtil.split(requiredRoles);
%>