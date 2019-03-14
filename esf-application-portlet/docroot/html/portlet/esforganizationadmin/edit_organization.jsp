<%@include file="init.jsp" %>

<%
long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");

ESFOrganization esfOrganization = null;

if(esfOrganizationId > 0) {
	esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
}
%>
<%--
ServiceContext esc = ServiceContextFactory.getInstance(ESFOrganization.class.getName(), renderRequest);
ESFTypeLocalServiceUtil.addESFType(user.getUserId(), "testType-2", ClassNameLocalServiceUtil.getClassNameId(ESFOrganization.class.getName()), esc);
--%>
<h2><liferay-ui:message key="organization-detail"></liferay-ui:message></h2>

<portlet:actionURL name="editESFOrganization" var="editESFOrganizationURL">
	<portlet:param name="esfOrganizationId" value="<%=String.valueOf(esfOrganizationId) %>"/>
</portlet:actionURL>

<aui:form action="<%=editESFOrganizationURL.toString() %>" name="<portlet:namespace />edit_esforganization_form">
	<aui:fieldset>
		<aui:model-context bean="<%= esfOrganization %>" model="<%=ESFOrganization.class %>" />
		<aui:input name="name" label="<%=LanguageUtil.get(locale, \"name\") %>"/>
		<aui:select name="types" multiple="false">
			<% for(ESFType type : ESFTypeLocalServiceUtil.findByClassName(ESFOrganization.class.getName())) { %>
			
			<aui:option value="<%=type.getEsfTypeId() %>" label="<%=type.getName() %>" />
			
			<% } %>
		</aui:select>
	</aui:fieldset>
	<aui:fieldset>
		<aui:button type="submit" />
		<aui:button onClick="<%= viewURL.toString() %>" type="cancel" />
	</aui:fieldset>
</aui:form>