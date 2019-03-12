
<liferay-ui:search-container emptyResultsMessage="no-result">
	<liferay-ui:search-container-results
		results="<%=ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId,
							ESFKeys.ESFStateType.ENABLE, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFOrganizationLocalServiceUtil
							.findAllChildOrganizations(currentOrganizationId, ESFKeys.ESFStateType.ENABLE).size()%>">
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganizationEnable">

		
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text property="code" />
		<liferay-ui:search-container-column-jsp	path='<%=templatePath + "esforganization_actions.jsp"%>' align="right" />
		

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>