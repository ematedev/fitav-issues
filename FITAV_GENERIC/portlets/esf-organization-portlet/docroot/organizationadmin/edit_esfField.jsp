<%@include file="/init.jsp" %>

<%
	long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
	
	ESFOrganization esfOrganization = null;
	
	if (esfOrganizationId > 0) {
	esfOrganization =
		ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
	}
	
	ESFField esfField = null;

	long esfFieldId = ParamUtil.getLong(request, "esfFieldId");

	if (esfFieldId > 0) {
		esfField = ESFFieldLocalServiceUtil.getESFField(esfFieldId);
	}

	List<ESFSportType> esfSportTypes = ESFSportTypeLocalServiceUtil
			.getAllESFSportTypes();
%>

<portlet:actionURL name="editESFField" var="editESFFieldURL" />

<aui:form action="<%= editESFFieldURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfField %>" model="<%= ESFField.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfFieldId"
				value='<%= esfField == null ? "" : esfField.getEsfFieldId() %>' />
			<aui:input type="hidden" name="ownerOrganizationId"
				value='<%= esfOrganizationId %>' />
			<aui:input name="name" />
			<aui:select name="esfSportTypeId" multiple="true">
				<% 
				for (ESFSportType esfSportType : esfSportTypes) { %>
					<aui:option 
						label="<%= esfSportType.getName() %>" 
						value="<%= esfSportType.getEsfSportTypeId()  %>"/>
				<% } %>
			</aui:select>
			<aui:input name="street1" type="text" />
			<aui:input name="street2" type="text" />
			<aui:input name="street3" type="text" />
			<aui:input name="zip" type="text" />
			<aui:input name="latitude" type="text" />
			<aui:input name="longitude" type="text" />
		</aui:fieldset>
		
		<liferay-ui:asset-links className="<%= ESFField.class.getName() %>"
			classPK="<%= esfFieldId %>"></liferay-ui:asset-links>
		
		<liferay-ui:asset-categories-error />
		<liferay-ui:asset-tags-error />
		<liferay-ui:panel defaultState="closed" extended="<%= true %>" id="esfFieldCategorizationPanel" persistState="<%= true %>" title="categorization">
			<aui:fieldset>
				<aui:input name="categories" type="assetCategories" />

				<aui:input name="tags" type="assetTags" />
			</aui:fieldset>
		</liferay-ui:panel>

		<liferay-ui:panel defaultState="closed" extended="<%= true %>" id="esfFieldAssetLinksPanel" persistState="<%= true %>" title="related-assets">
			<aui:fieldset>
				<liferay-ui:input-asset-links
					className="<%= ESFField.class.getName() %>"
					classPK="<%= esfFieldId %>"
				/>
			</aui:fieldset>
		</liferay-ui:panel>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>
