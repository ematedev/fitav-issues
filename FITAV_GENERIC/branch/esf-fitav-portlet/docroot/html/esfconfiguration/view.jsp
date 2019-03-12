<%@ include file="init.jsp" %>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="key" placeholder="Key"
					size="30" title="search-entries" type="text" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

		<liferay-ui:error key="esfconfiguration-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFConfiguration.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfconfiguration-admin-buttons">
			<portlet:renderURL var="addESFConfigurationURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfConfiguration.jsp"%>' />
				</portlet:renderURL>
				
				<aui:button onClick="<%= addESFConfigurationURL.toString() %>"
					value="add-esf-configuration" />
		</aui:button-row>
	
		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results results="<%= ESFConfigurationLocalServiceUtil.getAllEsfConfigurations(searchContainer.getStart(), searchContainer.getEnd()) %>"
												 total="<%= ESFConfigurationLocalServiceUtil.getESFConfigurationsCount() %>" />
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFConfiguration" modelVar="esfConfiguration">
					<liferay-ui:search-container-column-text property="key" />
					<liferay-ui:search-container-column-text property="value" />
			
			<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfConfiguration_actions.jsp"%>'
				 			align="right" />

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
