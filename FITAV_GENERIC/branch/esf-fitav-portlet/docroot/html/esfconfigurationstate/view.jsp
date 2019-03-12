<%@ include file="init.jsp"%>

<liferay-ui:error key="state-assigned-message"
	message="state-assigned-message" />
<liferay-ui:error key="state-name-message"
	message="state-name-message" />

<aui:button-row cssClass="esfstate-admin-buttons">
		<portlet:renderURL var="addESFStateURL">
			<portlet:param name="mvcPath"
				value='<%= templatePath + "edit_esfState.jsp"%>' />
		</portlet:renderURL>

		<aui:button onClick="<%= addESFStateURL.toString() %>"
			value="Add-State" label="Add-State"/>
			
</aui:button-row>
	
<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results 
	results="<%= ESFStateLocalServiceUtil.findAllESFStates() %>"
					total="<%= ESFStateLocalServiceUtil.findAllESFStates().size() %>" />
	
	
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFState" modelVar="esfState">

		<liferay-ui:search-container-column-text property="name"/>

		<liferay-ui:search-container-column-text property="description"/>
		
		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfState_action.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
