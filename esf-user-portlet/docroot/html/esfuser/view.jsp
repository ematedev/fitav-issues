<%@include file="init.jsp"%>

<h2>
	<liferay-ui:message key="esf-users-list"></liferay-ui:message>
</h2>

<% if (ESFUserModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFUSER)) { %>

<portlet:renderURL var="addESFUserURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "edit_user.jsp" %>' />
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addESFUserURL.toString() %>" value="add-user" />
</aui:button-row>

<%
} 
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
%>

<liferay-ui:search-container>

	<liferay-ui:search-container-results
		results="<%= ESFUserLocalServiceUtil.getESFUsers(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFUserLocalServiceUtil.getESFUsersCount() %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
		<liferay-ui:search-container-column-text property="firstName" />

		<liferay-ui:search-container-column-text property="lastName" />

		<liferay-ui:search-container-column-text property="screenName" />

		<liferay-ui:search-container-column-text property="userEmail" />

		<liferay-ui:search-container-column-text name="createDate"
			value="<%= dateFormat.format(esfUser.getOriginalUser().getCreateDate()) %>" />

		<liferay-ui:search-container-column-text name="birthday"
			value="<%= dateFormat.format(esfUser.getBirthday()) %>" />

		<% if(ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.UPDATE) 
				|| ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.DELETE)
				|| ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.PERMISSIONS)) { %>

		<liferay-ui:search-container-column-jsp
			path='<%= templatePath + "user_actions.jsp" %>' />

		<% } %>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>