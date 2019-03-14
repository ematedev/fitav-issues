<%@include file="init.jsp" %>

<c:choose>
	<c:when test="<%= ESFUserModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFUSERROLE) %>">

		<liferay-ui:error key="esfUserRole-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFUserRole.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfuserrole-admin-buttons">
			<c:if test='<%= ESFUserModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFUSERROLE) %>'>
				<portlet:renderURL var="addESFUserRoleURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfUserRole.jsp"%>' />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFUserRoleURL.toString() %>"
					value="Add ESFUserRole" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFUserRoleLocalServiceUtil.getAllEsfUserRole() %>"
				total="<%= ESFUserRoleLocalServiceUtil.getAllEsfUserRoleCount() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUserRole" modelVar="esfUserRole">

				<c:if test="<%= ESFUserRolePermission.contains(permissionChecker, esfUserRole.getEsfUserRoleId(), ActionKeys.UPDATE) %>">
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />
					<liferay-ui:search-container-column-text property="isBDO" name="Administrative"/>
					<liferay-ui:search-container-column-text property="isLEA" name="Militar"/>
				</c:if>

				<c:if test="<%= ESFUserRolePermission.contains(permissionChecker, esfUserRole.getEsfUserRoleId(), ActionKeys.UPDATE) ||
						ESFUserRolePermission.contains(permissionChecker, esfUserRole.getEsfUserRoleId(), ActionKeys.PERMISSIONS) ||
						ESFUserRolePermission.contains(permissionChecker, esfUserRole.getEsfUserRoleId(), ActionKeys.DELETE) %>">

					<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfUserRole_actions.jsp" %>' 
				 			align="right" />
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