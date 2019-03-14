<%@include file="init.jsp" %>

<%
ESFUserRole esfUserRole = null;

long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");

if (esfUserRoleId > 0) {
	esfUserRole = ESFUserRoleLocalServiceUtil.getESFUserRole(esfUserRoleId);
}
%>

<portlet:actionURL name="editESFUserRole" var="editESFUserRoleURL" />

<aui:form action="<%= editESFUserRoleURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfUserRole %>" model="<%= ESFUserRole.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfUserRoleId"
				value='<%= esfUserRole == null ? "" : esfUserRole.getEsfUserRoleId() %>' />
			<aui:input name="name" />
			<aui:input name="description" type="textarea"/>
			<aui:input name="isBDO" />
			<aui:input name="isLEA" />
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>
