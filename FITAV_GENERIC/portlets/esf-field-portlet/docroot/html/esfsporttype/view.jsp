<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@include file="init.jsp" %>

<c:choose>
	<c:when test="<%= ESFSportTypeModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFSPORTTYPE) %>">

		<liferay-ui:error key="esfSportRype-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFSportType.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfsporttype-admin-buttons">
			<c:if test='<%= ESFSportTypeModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFSPORTTYPE) %>'>
				<portlet:renderURL var="addESFSportTypeURL">
					<portlet:param name="mvcPath"
						value="/html/esfsporttype/edit_esfSportType.jsp" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFSportTypeURL.toString() %>"
					value="Add ESFSportType" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFSportTypeLocalServiceUtil.getESFSportTypes(scopeGroupId,
								searchContainer.getStart(),
								searchContainer.getEnd()) %>"
				total="<%= ESFSportTypeLocalServiceUtil.getESFSportTypesCountByGroupId(scopeGroupId) %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFSportType" modelVar="esfSportType">

				<c:if test="<%= ESFSportTypePermission.contains(permissionChecker, esfSportType.getEsfSportTypeId(), ActionKeys.UPDATE) %>">
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />
				</c:if>

				<c:if test="<%= ESFSportTypePermission.contains(permissionChecker, esfSportType.getEsfSportTypeId(), ActionKeys.UPDATE) ||
						ESFSportTypePermission.contains(permissionChecker, esfSportType.getEsfSportTypeId(), ActionKeys.PERMISSIONS) ||
						ESFSportTypePermission.contains(permissionChecker, esfSportType.getEsfSportTypeId(), ActionKeys.DELETE) %>">

					<liferay-ui:search-container-column-jsp
							path="/html/esfsporttype/esfSportType_actions.jsp" 
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