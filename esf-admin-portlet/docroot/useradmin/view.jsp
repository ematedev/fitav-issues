<%@include file="/useradmin/init.jsp"%>

<h2>
	<liferay-ui:message key="esf-users-list"></liferay-ui:message>
</h2>

<% if (ESFUserPermission.contains(permissionChecker, user.getUserId(), ActionKeys.ADD_ESFUSER)) { %>

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

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view_search.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="<portlet:namespace/>fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input name="keywords" inlineField="<%= true %>" label="" size="30" title="search-users" type="text" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

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

		<% if(ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.UPDATE_ESFUSER) 
				|| ESFUserPermission.contains(permissionChecker, esfUser.getEsfUserId(), ActionKeys.DELETE_ESFUSER)) { %>

		<liferay-ui:search-container-column-jsp
			path='<%= templatePath + "user_actions.jsp" %>' />

		<% } %>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>