<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.persistence.AddressUtil"%>
<%@page import="com.liferay.portal.service.AddressServiceUtil"%>
<%@page import="com.liferay.portal.model.Address"%>
<%@include file="/init.jsp"%>

<h2>
	<liferay-ui:message key="esf-organizations-list"></liferay-ui:message>
</h2>

<liferay-ui:success key="esfOrganizationAdded"
	message="organization-added" />
	
<liferay-ui:success key="esf_organization_deleted"
	message="esf-organization-deleted"/>

<portlet:renderURL var="addESFOrganizationURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "edit_esforganization.jsp"%>' />
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addESFOrganizationURL.toString() %>"
		value="add-organization" />
</aui:button-row>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view_search.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get"
	name="<portlet:namespace/>fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<span class="aui-search-bar"> <aui:input name="keywords"
				inlineField="<%=true%>" label="" size="30" title="search-users"
				type="text" /> <aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%=ESFOrganizationLocalServiceUtil.getESFOrganizations(
					searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFOrganizationLocalServiceUtil.getESFOrganizationsCount()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFOrganization"
		modelVar="esfOrganizationSC">

		<portlet:renderURL var="viewESFOrganization">
			<portlet:param name="mvcPath"
				value='<%= templatePath + "edit_esforganization.jsp"%>' />
			<portlet:param name="esfOrganizationId"
				value="<%=String.valueOf(esfOrganizationSC.getEsfOrganizationId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="name"
			href="<%=viewESFOrganization%>" />

		<liferay-ui:search-container-column-text property="code" />

		<liferay-ui:search-container-column-text property="vat" />

		<liferay-ui:search-container-column-text property="fiscalCode" />

		<liferay-ui:search-container-column-jsp
			path="/organizationadmin/esforganization_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>