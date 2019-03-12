<%@include file="navigation_init.jsp"%>
<aui:fieldset>
	<aui:model-context bean="<%=esfOrganization%>"
		model="<%=ESFOrganization.class%>" />
	<aui:input name="name" />
	<aui:input name="code" />
	<aui:input name="vat" />
	<aui:input name="fiscalCode" />
</aui:fieldset>
<liferay-ui:asset-links className="<%= ESFOrganization.class.getName() %>"
	classPK="<%= esfOrganizationId %>"></liferay-ui:asset-links>

<liferay-ui:asset-categories-error />
<liferay-ui:asset-tags-error />
<liferay-ui:panel defaultState="closed" extended="<%= true %>" id="esfOrganizationCategorizationPanel" persistState="<%= true %>" title="categorization">
	<aui:fieldset>
		<aui:input name="categories" type="assetCategories" />

		<aui:input name="tags" type="assetTags" />
	</aui:fieldset>
</liferay-ui:panel>

<liferay-ui:panel defaultState="closed" extended="<%= true %>" id="esfOrganizationAssetLinksPanel" persistState="<%= true %>" title="related-assets">
	<aui:fieldset>
		<liferay-ui:input-asset-links
			className="<%= ESFOrganization.class.getName() %>"
			classPK="<%= esfOrganizationId %>"
		/>
	</aui:fieldset>
</liferay-ui:panel>