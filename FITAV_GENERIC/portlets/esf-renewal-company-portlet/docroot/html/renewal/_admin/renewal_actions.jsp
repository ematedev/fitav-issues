<%@ include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFRenewalCompany esfRenewalCompany = (ESFRenewalCompany)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:actionURL name="validateRenewal" var="validateRenewalURL">
		<portlet:param name="esfRenewalCompanyId" value="<%= Long.toString(esfRenewalCompany.getEsfRenewalCompanyId()) %>" />
	</liferay-portlet:actionURL>
	<liferay-ui:icon
		image="edit"
		message="validate"
		url="<%= validateRenewalURL.toString() %>"
	/>
</liferay-ui:icon-menu>