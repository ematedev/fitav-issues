<%@ include file="../init.jsp" %>
<%@page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%>

<%
long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
boolean isCatridge = false;

%>
			
<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUNKIND) %>">

	
<%ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);%>

<h3><%= esfGunType.getName() %></h3>

<aui:button-row cssClass="esfguncategorization-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUNKIND) %>'>

	<portlet:renderURL var="addESFGunCatridgeURL">
		<portlet:param name="mvcPath"
				value="/html/esfgun/esfguncategorization/edit_esfGunCatridge.jsp" />
		<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
	</portlet:renderURL>
				
	<aui:button onClick="<%= addESFGunCatridgeURL.toString() %>"
			value="add-esfgunkind" />
	<aui:button onClick="<%= viewURL.toString() %>" value="go-back"/>


			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFCatridgeLocalServiceUtil.getESFCatridgesByType(esfGunTypeId, searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFCatridgeLocalServiceUtil.countESFCatridgesByType(esfGunTypeId) %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFCatridge" modelVar="esfCatridge">
				
				<%
				String model = "";
				String name = "";	
				String description = "";
				
				if(Validator.isNotNull(esfCatridge.getCatridgeModel())){
					name = esfCatridge.getCatridgeModel();
				}
				if(Validator.isNotNull(esfCatridge.getNote())){
					description = esfCatridge.getNote();
				}
				
				if(Validator.isNotNull(esfCatridge.getEsfGunTypeId()) && 
						Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(esfCatridge.getEsfGunTypeId())) &&
						Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(esfCatridge.getEsfGunTypeId()).getName())){
					
					model = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfCatridge.getEsfGunTypeId()).getName();
					
				}
				
				%>

				<liferay-ui:search-container-column-text name="model"
					value="<%=model%>" />
				<liferay-ui:search-container-column-text name="Nome"
					value="<%=name%>" />
				<liferay-ui:search-container-column-text name="description"
					value="<%=description%>" />



					<liferay-ui:search-container-column-jsp
							path="/html/esfgun/esfguncategorization/esfGunCatridge_actions.jsp" 
				 			align="right" cssClass="gun_actions_button"/>

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