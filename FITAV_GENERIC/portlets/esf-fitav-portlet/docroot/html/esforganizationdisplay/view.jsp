
<%@include file="init.jsp"%>

<%
	int numberOfPhones = 3;

	String[][] categorySections = null;
	String[] _CATEGORY_NAMES = null;

	if (currentType == ESFKeys.ESFOrganizationTypeId.ASSOCIATION) {

		_CATEGORY_NAMES = new String[] { "main", "more" };

		categorySections = new String[][] { { "details", "addresses", "phones" },
				{ "state", "coni", "otherDetails", "associated_company" } };
	} else {
		_CATEGORY_NAMES = new String[] { "main" };
		categorySections = new String[][] { { "details", "addresses", "phones" } };
	}
%>

<div>

	<liferay-ui:error key="organiz-bdo-message"
		message="organiz-bdo-message" />
	<liferay-ui:error key="organiz-field-message"
		message="organiz-field-message" />
	<liferay-ui:error key="organiz-payment-message"
		message="organiz-payment-message" />

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

	<liferay-ui:form-navigator backURL="<%=viewURL%>"
		categoryNames="<%=_CATEGORY_NAMES%>"
		categorySections="<%=categorySections%>" formName="fm"
		jspPath='<%=templatePath + "navigationview/"%>' showButtons="false" />

	<c:if test="<%= ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE) %>">	
				
		<aui:button-row>
			<aui:button type="submit" value="edit" onClick="<%= editURL %>" id="editOrganizationDisplay"></aui:button>
		</aui:button-row>
	
	</c:if>	
</div>
