<%@ include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFRenewalCompany esfRenewalCompany = (ESFRenewalCompany) row.getObject();

ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfRenewalCompany.getEsfOrganizationId());
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="editRenewalCompanyURL">
		<portlet:param name="esfOrganizationId" value="<%= Long.toString(esfOrganization.getEsfOrganizationId()) %>" />
		<portlet:param name="year" value="<%= Integer.toString(esfRenewalCompany.getYear()) %>" />
		<portlet:param name="redirect" value='<%= currentURL %>' />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit.jsp" %>' />
	</liferay-portlet:renderURL>
	<liferay-ui:icon
		image="submit"
		message=""
		url="<%= editRenewalCompanyURL.toString() %>"
	/>
</liferay-ui:icon-menu>