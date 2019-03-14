<%@include file="init.jsp" %>

<%
long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");

ESFOrganization esfOrganization = null;

if(esfOrganizationId > 0) {
	esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
}
%>

<portlet:actionURL name="saveAll" var="saveAllURL">
	<portlet:param name="esfOrganizationId" value="<%=String.valueOf(esfOrganizationId) %>"/>
</portlet:actionURL>

<%-- <aui:form action="<%=saveAllURL.toString() %>" name="<portlet:namespace />ESFOrganization_form"> --%>
	<liferay-ui:form-navigator
		backURL="<%= viewURL %>"
		categoryNames="<%= categoryNames %>"
		categorySections="<%= categorySections %>"		
		jspPath="/html/portlet/esforganizationadmin/"
		showButtons="false"						
	/>
<%-- </aui:form> --%>

<%!
private static final String[] categoryNames = {"organization-information"};
private static final String[][] categorySections = {{"edit_organization"}};
%>