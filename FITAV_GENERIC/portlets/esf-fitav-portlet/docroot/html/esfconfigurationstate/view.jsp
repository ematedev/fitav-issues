<%@page import="it.ethica.esf.permission.ESFConfigurationStatePermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFConfigurationStateModelPermission"%>
<%@ include file="init.jsp"%>

<liferay-ui:error key="state-assigned-message"
	message="state-assigned-message" />
<liferay-ui:error key="state-name-message"
	message="state-name-message" />

<aui:button-row cssClass="esfstate-admin-buttons">
<c:if test="<%= ESFConfigurationStateModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFCONFIGURATIONSTATE_ADD) %>">
		<portlet:renderURL var="addESFStateURL">
			<portlet:param name="mvcPath"
				value='<%= templatePath + "edit_esfState.jsp"%>' />
		</portlet:renderURL>

		<aui:button onClick="<%= addESFStateURL.toString() %>"
			value="Add-State" label="Add-State"/>
</c:if>			
</aui:button-row>
	
<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results 
	results="<%= ESFStateLocalServiceUtil.findAllESFStates() %>"
					total="<%= ESFStateLocalServiceUtil.findAllESFStates().size() %>" />
	
	
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFState" modelVar="esfState">

		<liferay-ui:search-container-column-text property="name"/>

		<liferay-ui:search-container-column-text property="description"/>
		
<c:if test="<%= ESFConfigurationStatePermission.contains(permissionChecker,esfState.getEsfStateId(), groupId, ActionKeys.ESFCONFIGURATIONSTATE_VIEW_ACTION) %>">
		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfState_action.jsp"%>' align="right" />
</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
