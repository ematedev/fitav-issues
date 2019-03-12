<%@page import="it.ethica.esf.permission.ESFUnitservicePermission"%>
<%@page import="it.ethica.esf.permission.ESFUnitserviceModelPermission"%>
<%@include file="init.jsp" %>

		<liferay-ui:error key="esfunitservice-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFUnitservice.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfunitservice-admin-buttons">
				<portlet:renderURL var="addESFUnitserviceURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfUnitservice.jsp"%>' />
				</portlet:renderURL>
<c:if test="<%= ESFUnitserviceModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFUNITSERVICE_ADD) %>">
				<aui:button onClick="<%= addESFUnitserviceURL.toString() %>" 
					value="add-esf-unitservice" />
</c:if>
		</aui:button-row>
	
		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results results="<%= ESFUnitserviceLocalServiceUtil.getAllESFUnitservices(searchContainer.getStart(), searchContainer.getEnd()) %>"
												 total="<%= ESFUnitserviceLocalServiceUtil.getESFUnitservicesCount() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUnitservice" modelVar="esfUnitservice">

					<liferay-ui:search-container-column-text property="description" />
			
<c:if test="<%= ESFUnitservicePermission.contains(permissionChecker,esfUnitservice.getEsfUnitserviceId(), scopeGroupId, ActionKeys.ESFUNITSERVICE_VIEW_ACTION) %>">
					
					<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfUnitservice_actions.jsp"%>' align="right" />
</c:if>	
			
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
