<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="java.util.List"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@include file="init.jsp"%>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");

ESFUser esfUser = null;

if (esfUserId > 0) {

	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
}
%>

<portlet:actionURL name="editESFUserESFUserRole" var="editESFUserESFUserRoleURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>

<%
List<ESFUserRole> esUserRoles = ESFUserRoleLocalServiceUtil.getAllEsfUserRole();
%>

<div>
	<aui:form action="<%=editESFUserESFUserRoleURL.toString()%>"
		name="<portlet:namespace />fm">
		<aui:fieldset>
			<aui:select name="esfUserRoleId">
			<% for (ESFUserRole esfUserRole : esUserRoles) { %>
				<aui:option value="<%= esfUserRole.getEsfUserRoleId() %>">
					<%= esfUserRole.getName() %>
				</aui:option>
			<% } %>
			</aui:select>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button onClick="<%= viewURL.toString() %>" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

