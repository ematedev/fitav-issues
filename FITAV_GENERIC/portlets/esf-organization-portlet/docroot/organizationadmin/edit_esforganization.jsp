<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.AddressCityException"%>
<%@page import="com.liferay.portal.AddressStreetException"%>
<%@page import="com.liferay.portal.AddressZipException"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.ListTypeConstants"%>
<%@page import="com.liferay.portal.NoSuchListTypeException"%>
<%@page import="com.liferay.portal.NoSuchRegionException"%>

<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.model.impl.ESFAddressImpl"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@include file="/init.jsp"%>

<%
	long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
	
	ESFOrganization esfOrganization = null;
	
	if (esfOrganizationId > 0) {
	esfOrganization =
		ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
	}
	
	String[] _CATEGORY_NAMES = {"Main", "Address"};
	String[][] categorySections = null;
	if (esfOrganizationId > 0) {
		categorySections = new String[][] {{"details", "fields"}, {"addresses", "phones"}};
	} else {
		categorySections = new String[][] {{"details"}, {"addresses", "phones"}};
	}
%>

<portlet:actionURL name="editESFOrganization"
	var="editESFOrganizationURL">
	<portlet:param name="esfOrganizationId"
		value="<%=String.valueOf(esfOrganizationId)%>" />
</portlet:actionURL>

<div>
	<aui:form action="<%=editESFOrganizationURL.toString()%>"
		name="<portlet:namespace />fm">
		
		
			<%
			request.setAttribute("addresses.className", Organization.class.getName());
			request.setAttribute("addresses.classPK", esfOrganizationId);
			request.setAttribute("emailAddresses.className", ESFOrganization.class.getName());
			request.setAttribute("emailAddresses.classPK", esfOrganizationId);
			request.setAttribute("phones.className", ESFOrganization.class.getName());
			request.setAttribute("phones.classPK", esfOrganizationId);
			request.setAttribute("websites.className", ESFOrganization.class.getName());
			request.setAttribute("websites.classPK", esfOrganizationId);
			%>
		<liferay-ui:form-navigator
			backURL="<%= viewURL %>"
			categoryNames="<%= _CATEGORY_NAMES %>"
			categorySections="<%= categorySections %>"
			formName="<portlet:namespace />fm"
			jspPath='<%= templatePath + "navigation/" %>'
		/>
	</aui:form>
</div>
