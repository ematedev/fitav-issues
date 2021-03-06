
<liferay-ui:search-container emptyResultsMessage="no-fields-for-this-organization">
				<liferay-ui:search-container-results
					results="<%= ESFFieldLocalServiceUtil.findByESFOrganization(currentOrganizationId,ESFKeys.ESFStateType.DISABLE, searchContainer.getStart(), searchContainer.getEnd()) %>"
					total="<%= ESFFieldLocalServiceUtil.findByESFOrganization(currentOrganizationId,ESFKeys.ESFStateType.DISABLE).size() %>" />
	
				<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFField" modelVar="esfField">
	
					<%
					String backgroundRampart="no_present";
					String billboardStations="no_present";
					String backgroundLeadRecovery="no_present";
					if(esfField.getBackgroundLeadRecovery()){
						backgroundRampart = "present";
					}
					if(esfField.getBillboardStations()){
						billboardStations = "present";
					}
					if(esfField.getBackgroundLeadRecovery()){
						backgroundLeadRecovery = "present";
					}
	
					List<ESFSportType> esfSportTypeList = ESFSportTypeLocalServiceUtil
						.findByESFFieldId(esfField.getEsfFieldId());
	
					String esfSportTypes = StringPool.BLANK;
	
					for (int i = 0 ; i < esfSportTypeList.size() ; i++) {
	
						ESFSportType esfSportType = esfSportTypeList.get(i);
	
						if(i == esfSportTypeList.size() - 1) {
							esfSportTypes = StringUtil.add(esfSportTypes, 
									esfSportType.getName(),StringPool.BLANK);
						}
						else {
							esfSportTypes = StringUtil.add(esfSportTypes, 
								esfSportType.getName(), StringPool.COMMA_AND_SPACE);
						}
					}
					%>
	
					<liferay-ui:search-container-column-text property="name" />
					
					<liferay-ui:search-container-column-text name="esf-sport-types" value="<%= esfSportTypes %>" />
					
					<liferay-ui:search-container-column-text name="backgroundRampart" value="<%= res.getString(backgroundRampart)%>" />
					
					<liferay-ui:search-container-column-text name="backgroundLeadRecovery" value="<%= res.getString(backgroundLeadRecovery) %>" />
					
					<liferay-ui:search-container-column-text name="billboardStations" value="<%= res.getString(billboardStations) %>" />
					
					<liferay-ui:search-container-column-text name="note" value="<%= esfField.getNote() %>" />
					
					<c:if test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.ESFFIELD_VIEW_ACTION_DISABLE) %>">
	
						<liferay-ui:search-container-column-jsp
								path='<%= templatePath + "esffield_actions.jsp"%>'
					 			align="right" />
				 	</c:if>
	
				</liferay-ui:search-container-row>
	
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>