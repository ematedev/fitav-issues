<%@ include file="/html/init.jsp" %>

<%
String name = ParamUtil.getString(request, "name");
String code = ParamUtil.getString(request, "code");
int year = ParamUtil.getInteger(request, "year", actualYear);
String searchOrgId = ParamUtil.getString(request, "searchOrgId");

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter("name", name);
viewassURL.setParameter("code", code);
viewassURL.setParameter("searchOrgId", searchOrgId);

List<Integer> yearsList = ESFRenewalCompanyLocalServiceUtil.getAllYears();

String orderByCol = ParamUtil.getString(request, "orderByCol", "name");
String orderByType = ParamUtil.getString(request, "orderByType", "desc");
%>

<liferay-portlet:actionURL name="populateESFRenewalCompany" var="populateESFRenewalCompanyURL" />

<%-- <aui:button value="populate" onClick="<%= populateESFRenewalCompanyURL %>" cssClass="btn btn-primary"/> --%>

<liferay-portlet:renderURL varImpl="searchURL" />

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%=true%>" value="<%= code %>" name="code" placeholder="code" size="30" title="search-entries" type="text" /> 
			<aui:input inlineField="<%=true%>" value="<%= name %>" name="name" placeholder="name" size="30" title="search-entries" type="text" /> 
			<aui:select label="provinces" name="searchOrgId" inlineField="<%=true%>">
				<%
					if (currentType == ESFKeys.ESFOrganizationTypeId.PROVINCE) {
				%>
						<aui:option value="<%=currentESFOrganization.getEsfOrganizationId()%>" selected="true" label="<%=currentESFOrganization.getName()%>"></aui:option>
				<%
					} else {
				%>

						<aui:option value="" label="-"></aui:option>
				<%
						List<ESFOrganization> esfOrgsForSearch = ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T(currentOrganizationId,ESFKeys.ESFOrganizationTypeId.PROVINCE);
						for (ESFOrganization esfOrgForSearch : esfOrgsForSearch) {
				%>

							<aui:option	value="<%=esfOrgForSearch.getEsfOrganizationId()%>" label="<%=esfOrgForSearch.getName()%>"></aui:option>

				<%
						}
					}
				%>
			</aui:select>
			<aui:select name="year" >
				<%
				if (Validator.isNotNull(yearsList)) {
					for (int yearValue : yearsList) {
					%>
						<aui:option value="<%= yearValue %>" label="<%= yearValue %>" selected="<%= yearValue == year %>" />
					<%
					}
				}
				%>
			</aui:select>
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>



<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%= viewassURL %>">

<% List<ESFRenewalCompany> listaRinnoviAssociazione = ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByN_C_R_Y(
		name, code, searchOrgId, year, searchContainer.getStart(), searchContainer.getEnd()); %>

	<liferay-ui:search-container-results
		results="<%= listaRinnoviAssociazione %>"
		total="<%= listaRinnoviAssociazione.size() %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.renewal.model.ESFRenewalCompany" modelVar="esfRenewalCompany">

		<%
		ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfRenewalCompany.getEsfOrganizationId());
		int status = esfRenewalCompany.getStatus();
		String statusLabel = StringPool.BLANK;
		switch (status) {
			case ESFRenewalConstants.RENEWAL_STATUS_NO_PAYMENT:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_NO_PAYMENT_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_STATUS_PENDING:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_PENDING_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_STATUS_COMPLETED:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_STATUS_DISABLED:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_DISABLED_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED_LABEL;
				break;
			default:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_NO_PAYMENT_LABEL;
				break;
		}
		%>

		<liferay-ui:search-container-column-text name="code" value='<%= esfOrganization.getCode() %>' />
		<liferay-ui:search-container-column-text name="name" value='<%= esfOrganization.getName() %>' />
		<liferay-ui:search-container-column-text name="status" value="<%= LanguageUtil.get(pageContext, statusLabel) %>" orderable="<%= true %>" />
		<liferay-ui:search-container-column-jsp path='<%= templatePath + "renewal_actions.jsp"%>' align="right"/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>