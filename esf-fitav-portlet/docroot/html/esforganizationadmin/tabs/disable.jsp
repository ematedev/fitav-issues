
<liferay-ui:search-container emptyResultsMessage="no-result">
	<liferay-ui:search-container-results
		results="<%=ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId,
							ESFKeys.ESFStateType.DISABLE, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFOrganizationLocalServiceUtil
							.findAllChildOrganizations(currentOrganizationId, ESFKeys.ESFStateType.DISABLE).size()%>">
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganizationEnable">

		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text property="code" />
		<c:if test='<%= ESFOrganizationPermission.contains(permissionChecker, esfOrganizationEnable.getEsfOrganizationId(), ActionKeys.ESFORGANIZATIONADMIN_VIEW_ACTION) %>'>
			<liferay-ui:search-container-column-jsp	path='<%=templatePath + "esforganization_actions.jsp"%>' align="right" />
		</c:if>
	
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


