<%@include file="init.jsp" %>

<c:choose>
	<c:when test="<%= ESFModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFSPORTTYPE) %>">

		<liferay-ui:error key="esfunitservice-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFUnitservice.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfunitservice-admin-buttons">
			<c:if test='<%= ESFModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFSPORTTYPE) %>'>
				<portlet:renderURL var="addESFUnitserviceURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfUnitservice.jsp"%>' />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFUnitserviceURL.toString() %>" 
					value="add-esf-unitservice" />
			</c:if>
		</aui:button-row>
	
		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results results="<%= ESFUnitserviceLocalServiceUtil.getAllESFUnitservices(searchContainer.getStart(), searchContainer.getEnd()) %>"
												 total="<%= ESFUnitserviceLocalServiceUtil.getESFUnitservicesCount() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUnitservice" modelVar="esfUnitservice">

					<liferay-ui:search-container-column-text property="description" />
					<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfUnitservice_actions.jsp"%>'
				 			align="right" />
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