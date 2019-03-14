<%@include file="init.jsp" %>

<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUNTYPE) %>">

		<liferay-ui:error key="esfGunKind-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFGunKind.class.getSimpleName()) %>' />
				
		<liferay-ui:error key="esfGunType-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFGunType.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfguncategorization-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUNTYPE) %>'>
				<portlet:renderURL var="addESFGunTypeURL">
					<portlet:param name="mvcPath"
						value="/html/esfguncategorization/edit_esfGunType.jsp" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFGunTypeURL.toString() %>"
					value="Add ESFGunType" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFGunTypeLocalServiceUtil.getESFGunTypes(
						searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFGunTypeLocalServiceUtil.getESFGunTypesCount() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGunType" modelVar="esfGunType">

				<c:if test="<%= ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.UPDATE) %>">
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />
				</c:if>

				<c:if test="<%= ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.UPDATE) ||
						ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.PERMISSIONS) ||
						ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.DELETE) %>">

					<liferay-ui:search-container-column-jsp
							path="/html/esfguncategorization/esfGunType_actions.jsp" 
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
