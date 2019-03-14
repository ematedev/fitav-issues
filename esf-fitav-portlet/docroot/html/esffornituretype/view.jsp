<%@ include file="init.jsp" %>

		<liferay-ui:error key="esffornituretype-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFFornitureType.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esffornituretype-admin-buttons">
			<portlet:renderURL var="addESFFornitureTypeURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfFornitureType.jsp"%>' />
				</portlet:renderURL>
				
				<aui:button onClick="<%= addESFFornitureTypeURL.toString() %>"
					value="add-esf-fornituretype" />
		</aui:button-row>
	
		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results results="<%= ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes() %>"
												 total="<%= ESFFornitureTypeLocalServiceUtil.getESFFornitureTypesCount() %>" />
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFFornitureType" modelVar="esfFornitureType">
					<liferay-ui:search-container-column-text property="description" />
			<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfFornitureType_actions.jsp"%>'
				 			align="right" />

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
