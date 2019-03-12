<%@include file="init.jsp" %>

<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUN) %>">

		<liferay-portlet:renderURL varImpl="searchURL">
				<portlet:param name="mvcPath" value="/html/esfgun/view_search.jsp" />
		</liferay-portlet:renderURL>

		<aui:form action="<%= searchURL %>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />

			<div class="search-form">
				<span class="aui-search-bar">
					<aui:input inlineField="<%= true %>" label="" name="keywords"
							size="30" title="search-entries" type="text" />

					<aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>

		<aui:button-row cssClass="esfgun-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUN) %>'>
				<portlet:renderURL var="addESFGunURL">
					<portlet:param name="mvcPath"
						value="/html/esfgun/edit_esfGun.jsp" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFGunURL.toString() %>"
					value="Add ESFGun" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFGunLocalServiceUtil.getESFGuns(
						searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFGunLocalServiceUtil.getESFGunsCount() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGun" modelVar="esfGun">

				<c:if test="<%= ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.UPDATE) %>">
					<liferay-ui:search-container-column-text name="name" value="<%= ESFGunLocalServiceUtil.getFullName(esfGun)  %>" />
					<liferay-ui:search-container-column-text name="owner" value="<%= UserLocalServiceUtil.getUser(esfGun.getEsfUserId()).getFullName() %>"/>
					<liferay-ui:search-container-column-text property="code" />
				</c:if>

				<c:if test="<%= ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.UPDATE) ||
						ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.PERMISSIONS) ||
						ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.DELETE) %>">

					<liferay-ui:search-container-column-jsp
							path="/html/esfgun/esfGun_actions.jsp" 
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
