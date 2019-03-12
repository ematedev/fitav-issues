<h3>
	<liferay-ui:message key="CATRIDGES" />
</h3>


<liferay-ui:search-container emptyResultsMessage="no-results" delta="20"
	curParam="sc3">
	<liferay-ui:search-container-results
		results="<%=ESFCatridgeLocalServiceUtil.getESFCatridges(
						searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFCatridgeLocalServiceUtil.getESFCatridgesCount()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFCatridge" modelVar="esfCatridge">

		<liferay-ui:search-container-column-text name="Marca"
			value="<%=ESFCatridgeLocalServiceUtil.getNameM(esfCatridge)%>" />

		<liferay-ui:search-container-column-text property="catridgeModel" />

		<liferay-ui:search-container-column-text property="catridgeCaliber" />

		<liferay-ui:search-container-column-text property="note" />

<c:if test="<%= ESFGunPermission.containsCatridge(permissionChecker, esfCatridge.getEsfCatridgeId(), portletGroupId, ActionKeys.ESFGUN_VIEW_ACTION)  %>">	
		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfCatridge_actions.jsp"%>' align="right"
			cssClass="gun_actions_button" />
</c:if>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>
