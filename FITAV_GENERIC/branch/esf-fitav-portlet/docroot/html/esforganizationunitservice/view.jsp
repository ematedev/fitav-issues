<%@page import="it.ethica.esf.permission.ESFOrganizationUnitServicePermission"%>
<%@page import="it.ethica.esf.permission.ESFOrganizationUnitServiceModelPermission"%>
<%@include file="init.jsp"%>

<%
	if (currentOrganizationId == 0) {
%>
<div class="alert alert-error">
	<liferay-ui:message key="place-this-portlet-inside-an-association-site">
	</liferay-ui:message>
</div>
<%
	} else if (currentType != ESFKeys.ESFOrganizationTypeId.ASSOCIATION) {
%>
<div class="alert alert-error">
	<liferay-ui:message key="place-this-portlet-inside-an-association-site">
	</liferay-ui:message>
</div>

<%
	} else {
%>

<c:if test="<%= ESFOrganizationUnitServiceModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFORGANIZATIONUNITSERVICE_ADD) %>">	
	<aui:button-row cssClass="esforganization-admin-buttons">
		<portlet:renderURL var="addESFOrganizationUnitserviceURL">
			<portlet:param name="mvcPath"
				value='<%=templatePath
									+ "edit_esfOrganizationUnitservice.jsp"%>' />
		</portlet:renderURL>
		<aui:button
			onClick="<%= addESFOrganizationUnitserviceURL.toString() %>"
			value="add-esf-organizationunitservice" />
	</aui:button-row>
</c:if>

<%
	if (ESFOrganizationUnitserviceLocalServiceUtil
				.findByESFOrganizationId(
						currentESFOrganization.getEsfOrganizationId())
				.size() == 0) {
%>

<div class="alert alert-info">
	<liferay-ui:message key="no-result" />
</div>

<%
	} else {
%>

<liferay-ui:search-container emptyResultsMessage="no-results">

	<liferay-ui:search-container-results>
		<%
			List<ESFOrganizationUnitservice> esfUnitservice = ESFOrganizationUnitserviceLocalServiceUtil
									.findByESFOrganizationId(currentESFOrganization
											.getEsfOrganizationId());
			List<ESFOrganizationUnitservice> esfUnitserviceSE = ESFOrganizationUnitserviceLocalServiceUtil
									.findByESFOrganizationId(
											currentESFOrganization
													.getEsfOrganizationId(),
											searchContainer.getStart(),
											searchContainer.getEnd());

			pageContext.setAttribute("results", esfUnitservice);
			pageContext.setAttribute("total",esfUnitserviceSE.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFOrganizationUnitservice"
		modelVar="esfOrganizationUnitservice">
		<%
			String name = "";

							if (Validator
									.isNotNull(esfOrganizationUnitservice)
									&& Validator
											.isNotNull(esfOrganizationUnitservice
													.getEsfUnitserviceId())
									&& Validator
											.isNotNull(ESFUnitserviceLocalServiceUtil
													.fetchESFUnitservice(esfOrganizationUnitservice
															.getEsfUnitserviceId()))
									&&Validator
									.isNotNull(ESFUnitserviceLocalServiceUtil
											.fetchESFUnitservice(
													esfOrganizationUnitservice
															.getEsfUnitserviceId())
											.getDescription())) {
								name = ESFUnitserviceLocalServiceUtil
										.fetchESFUnitservice(
												esfOrganizationUnitservice
														.getEsfUnitserviceId())
										.getDescription();
							}

							String description = "";

							if (Validator.isNotNull(esfOrganizationUnitservice
									.getDescription())) {
								description = esfOrganizationUnitservice
										.getDescription();
							}
		%>

		<liferay-ui:search-container-column-text value="<%=name%>"
			name="esf-unitservice-id" />
		<liferay-ui:search-container-column-text property="numberUnitservices"
			name="number-unitservices" />
		<liferay-ui:search-container-column-text value="<%=description%>"
			name="description" />

		<c:if test="<%= ESFOrganizationUnitServicePermission.contains(permissionChecker,esfOrganizationUnitservice.getEsfOrganizationUnitserviceId(), ActionKeys.ESFORGANIZATIONUNITSERVICE_VIEW_ACTION) %>">	
			<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfOrganizationUnitservice_actions.jsp"%>'
			align="right" />
		</c:if>	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<%
	}
%>
<%
	}
%>

