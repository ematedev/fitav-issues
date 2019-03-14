<%@ include file="/html/init.jsp" %>

<%
List<ESFRenewalCompany> esfRenewalCompanies = ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByStatus(ESFRenewalConstants.RENEWAL_STATUS_PENDING);
int totalResults = esfRenewalCompanies.size();
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/renewal/admin/view.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/renewal/admin/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:header
	title='to-renew'
/>

<portlet:renderURL var="renewedURL">
	<portlet:param name="mvcPath" value="/html/renewal/admin/renewed.jsp"/>
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:renderURL>

<aui:button-row cssClass="admin-select">
	<aui:button value="renewed" onClick="<%= renewedURL %>" />
</aui:button-row>

<liferay-ui:search-container
	curParam="curRenewal"
	var="searchContainer"
	iteratorURL="<%= iteratorURL %>"
	emptyResultsMessage="no-results">

	<liferay-ui:search-container-results
		results="<%= esfRenewalCompanies %>"
		total="<%= totalResults %>"
		/>
	
	<liferay-ui:search-container-row className="it.ethica.esf.renewal.model.ESFRenewalCompany" modelVar="esfRenewalCompany" keyProperty="esfRenewalCompanyId" >
		<%
		ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfRenewalCompany.getEsfOrganizationId());
		%>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= esfOrganization.getName() %>"
		/>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/renewal/admin/renewal_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>