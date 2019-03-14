<%@include file="init.jsp"%>

<%
int numberOfPhones = 3;

String[][] categorySections = null;
String[] _CATEGORY_NAMES = null;

if(currentType == ESFKeys.ESFOrganizationTypeId.ASSOCIATION){
	
	_CATEGORY_NAMES = new String[]{"Main", "More"};
	
	categorySections = new String[][] {{
		"details", "addresses", "phones"
	}, {
		"state", "coni","otherDetails","associated_company"
	}};
}
else{
	_CATEGORY_NAMES = new String[]{"Main"};
	categorySections = new String[][] {{"details", "addresses", "phones"}};
}


boolean showBotton=
	ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, 
			ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE);
%>

<portlet:actionURL name="editESFOrganization"
	var="editESFOrganizationURL">
	<portlet:param name="esfOrganizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
	<portlet:param name="isSimplyOrganizzation" value="<%=String.valueOf(currentESFOrganization.getIsSimplyOrganizzation())%>" />
	
</portlet:actionURL>

<div class="fitav-navigator">
	<aui:form action="<%=editESFOrganizationURL.toString()%>"
		name="fme">

		<%
		request.setAttribute("addresses.className", Organization.class.getName());
		request.setAttribute("addresses.classPK", currentOrganizationId);
		request.setAttribute("emailAddresses.className", ESFOrganization.class.getName());
		request.setAttribute("emailAddresses.classPK", currentOrganizationId);
		request.setAttribute("phones.className", Organization.class.getName());
		request.setAttribute("phones.classPK", currentOrganizationId);
		request.setAttribute("phones.number", numberOfPhones);
		request.setAttribute("websites.className", ESFOrganization.class.getName());
		request.setAttribute("websites.classPK", currentOrganizationId);
		%>

		<liferay-ui:form-navigator
			backURL="<%= viewURL %>"
			categoryNames="<%= _CATEGORY_NAMES %>"
			categorySections="<%= categorySections %>"
			formName="fme"
			jspPath='<%= templatePath + "navigationedit/" %>'
			showButtons="<%= showBotton %>"
		/>
	</aui:form>
</div>
