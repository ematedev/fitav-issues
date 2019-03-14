<%@include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/html/esfguncategorization/view.jsp" />
</liferay-portlet:renderURL>

<aui:a href="<%= viewURL.toString() %>" label="back"></aui:a>

<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUNKIND) %>">

		<%
		long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
		
		ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);
		%>

		<h3><%= esfGunType.getName() %></h3>

		<aui:button-row cssClass="esfguncategorization-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUNKIND) %>'>
				<portlet:renderURL var="addESFGunKindURL">
					<portlet:param name="mvcPath"
						value="/html/esfguncategorization/edit_esfGunKind.jsp" />
					<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFGunKindURL.toString() %>"
					value="Add ESFGunKind" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(
						esfGunTypeId,
						searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFGunKindLocalServiceUtil.getESFGunKindCountByESFGunType(esfGunTypeId) %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGunKind" modelVar="esfGunKind">

				<c:if test="<%= ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.UPDATE) %>">
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />
				</c:if>

				<c:if test="<%= ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.UPDATE) ||
						ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.PERMISSIONS) ||
						ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.DELETE) %>">

					<liferay-ui:search-container-column-jsp
							path="/html/esfguncategorization/esfGunKind_actions.jsp" 
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
