<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFForniture esfFornitureType = (ESFForniture)row.getObject(); 

%>
	<liferay-ui:icon-menu>
		<portlet:renderURL var="editURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfFornitureId"
				value="<%=String.valueOf(esfFornitureType.getEsfFornitureId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfForniture.jsp"%>' />
		</portlet:renderURL>
		
		<portlet:renderURL var="updateQuantURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfFornitureId"
				value="<%=String.valueOf(esfFornitureType.getEsfFornitureId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "update_esfFornitureQuantity.jsp"%>' />
		</portlet:renderURL>
		
		<portlet:renderURL var="assignFornitureURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfFornitureId"
				value="<%=String.valueOf(esfFornitureType.getEsfFornitureId()) %>" />
			
			<portlet:param name="mvcPath" value='<%= templatePath + "assignUser.jsp"%>' />
		</portlet:renderURL>
		
		
		<liferay-ui:icon image="edit" message="assign"
			url="<%=assignFornitureURL.toString() %>" />
		
		<liferay-ui:icon image="edit" message="update"
			url="<%=updateQuantURL.toString() %>" />
		
	
		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />
		<liferay-security:permissionsURL
			modelResource="<%= ESFForniture.class.getName() %>"
			modelResourceDescription="<%= esfFornitureType.getDescription() %>"
			resourcePrimKey="<%= String.valueOf(esfFornitureType.getEsfFornitureId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
		<portlet:actionURL name="deleteESFForniture" var="deleteESFFornitureURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfFornitureId"
				value="<%= String.valueOf(esfFornitureType.getEsfFornitureId()) %>" />
		</portlet:actionURL>
		
		
		
		<liferay-ui:icon-delete url="<%=deleteESFFornitureURL.toString() %>" confirmation="delete_confirm"/>
		
	</liferay-ui:icon-menu>