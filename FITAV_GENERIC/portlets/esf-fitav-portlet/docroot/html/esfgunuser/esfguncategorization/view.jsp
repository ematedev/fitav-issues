<%@page import="it.ethica.esf.permission.ESFGunTypePermission"%>
<%@ include file="../init.jsp" %>
	<% 
		
	long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
	%>

<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUNTYPE) %>">

		<liferay-ui:error key="esfGunType-reference-error" message='esfGunType-reference-error' />

		<aui:button-row cssClass="esfguncategorization-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUNTYPE) %>'>
				<portlet:renderURL var="addESFGunTypeURL">
					<portlet:param name="mvcPath" value="/html/esfgunuser/esfguncategorization/edit_esfGunType.jsp" />
					<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
					<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFGunTypeURL.toString() %>"
					value="add-esfgunyype" />
					
				<portlet:renderURL var="addESFGunKindURL">
					<portlet:param name="mvcPath" value="/html/esfgunuser/esfguncategorization/edit_esfGunKind.jsp" />
					<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
					<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
					<portlet:param name="flagSearch" value="<%= String.valueOf(false) %>" />
				</portlet:renderURL>
				
				<aui:button onClick="<%= addESFGunKindURL.toString() %>"
					value="add-esfgunkind" />
					
				<portlet:renderURL var="backURL">
					<portlet:param name="mvcPath"
						value="/html/esfgunuser/view.jsp" />
					<portlet:param name="flagSearch" value="<%= String.valueOf(false) %>" />
				</portlet:renderURL>
				
				<aui:button onClick="<%= backURL.toString() %>"
					value="go-back" />	
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
							path="/html/esfgunuser/esfguncategorization/esfGunType_actions.jsp" 
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
