<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.permission.ESFUserRolePermission"%>
<%@include file="init.jsp" %>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");
%>

<c:choose>
	<c:when test="<%= ESFUserModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFUSER)
						&& ESFUserModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFUSERROLE)%>">

		<h2>
			<%= ESFUserLocalServiceUtil.getESFUser(esfUserId).getScreenName() %>
			<liferay-ui:message key="roles"></liferay-ui:message>
		</h2>

		<aui:button-row cssClass="esfuseresfuserrole-admin-buttons">
			<c:if test='<%= ESFUserPermission.contains(permissionChecker, esfUserId, ActionKeys.UPDATE) %>'>
				<portlet:renderURL var="editESFUserESFUserRoleURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
					<portlet:param name="esfUserId" value="<%= String.valueOf(esfUserId) %>" />
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfUserEsfUserRole.jsp"%>' />
				</portlet:renderURL>

				<aui:button onClick="<%= editESFUserESFUserRoleURL.toString() %>"
					value="Edit User Roles" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFUserLocalServiceUtil.getActiveESFUserRoles(esfUserId) %>"
				total="<%= ESFUserLocalServiceUtil.getActiveESFUserRoles(esfUserId).size() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUserESFUserRole" modelVar="esfUserEsfUserRole">

				<%
				ESFUserRole esfUserRole = ESFUserRoleLocalServiceUtil.getESFUserRole(esfUserEsfUserRole.getEsfUserRoleId());
				String roleType = "regular";
				if (esfUserRole.isIsBDO()) {
					roleType = "administrative";
				}
				else if (esfUserRole.isIsLEA()) {
					roleType = "militar";
				}
				%>

				<c:if test="<%= ESFUserRolePermission.contains(permissionChecker, esfUserEsfUserRole.getEsfUserRoleId(), ActionKeys.VIEW) %>">
					<liferay-ui:search-container-column-text name="role-type" value="<%= roleType %>" />
					<liferay-ui:search-container-column-text name="name" value="<%= esfUserRole.getName() %>" />
					<liferay-ui:search-container-column-text name="description" value="<%= esfUserRole.getDescription() %>"/>
					<liferay-ui:search-container-column-date property="startDate" />
					<liferay-ui:search-container-column-text name="endDate" value='<%= esfUserEsfUserRole.getEndDate() == null ? "active" : esfUserEsfUserRole.getEndDate().toString() %>'/>
				</c:if>
				
				<c:if test='<%= ESFUserPermission.contains(permissionChecker, esfUserId, ActionKeys.UPDATE) %>'>
					<portlet:actionURL name="deleteEsfUserEsfUserRole" var="deleteEsfUserEsfUserRoleURL">
						<portlet:param name="esfUserId" value="<%= String.valueOf(esfUserId) %>" />
						<portlet:param name="esfUserRoleId" value="<%= String.valueOf(esfUserRole.getEsfUserRoleId()) %>" />
					</portlet:actionURL>
					<liferay-ui:search-container-column-text>
						<liferay-ui:icon-menu>
							<liferay-ui:icon-delete url="<%= deleteEsfUserEsfUserRoleURL.toString() %>"></liferay-ui:icon-delete>
						</liferay-ui:icon-menu>
					</liferay-ui:search-container-column-text>
				</c:if>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>