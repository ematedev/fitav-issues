<%@include file="init.jsp" %>

<c:choose>
	<c:when test="<%= ESFFieldModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFFIELD) %>">

		<liferay-portlet:renderURL varImpl="searchURL">
				<portlet:param name="mvcPath" value="/html/esffield/view_search.jsp" />
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

		<aui:button-row cssClass="esffield-admin-buttons">
			<c:if test='<%= ESFFieldModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFFIELD) %>'>
				<portlet:renderURL var="addESFFieldURL">
					<portlet:param name="mvcPath"
						value="/html/esffield/edit_esfField.jsp" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFFieldURL.toString() %>"
					value="Add ESFField" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFFieldLocalServiceUtil.getESFFields(scopeGroupId,
								searchContainer.getStart(),
								searchContainer.getEnd()) %>"
				total="<%= ESFFieldLocalServiceUtil.getESFFieldsCountByGroupId(scopeGroupId) %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFField" modelVar="esfField">

				<%

				List<ESFSportType> esfSportTypeList = ESFSportTypeLocalServiceUtil
					.getESFSportTypesByESFField(esfField.getEsfFieldId());

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

				<c:if test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.UPDATE) %>">
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="ownerOrganizationId" />
					<liferay-ui:search-container-column-text property="esfAddressId" />
					<liferay-ui:search-container-column-text name="esfSportTypes" value="<%= esfSportTypes %>" />
				</c:if>

				<c:if test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.UPDATE) ||
						ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.PERMISSIONS) ||
						ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.DELETE) %>">

					<liferay-ui:search-container-column-jsp
							path="/html/esffield/esfField_actions.jsp" 
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