<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFOrganizationUnitservice esfOrganizationUnitservice = (ESFOrganizationUnitservice)row.getObject(); 
%>

	<liferay-ui:icon-menu>
		<c:if test="<%= ESFOrganizationUnitServicePermission.contains(permissionChecker,esfOrganizationUnitservice.getEsfOrganizationUnitserviceId(), ActionKeys.ESFORGANIZATIONUNITSERVICE_UPDATE) %>">	
			<portlet:renderURL var="editURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
				<portlet:param name="esfOrganizationUnitserviceId"
					value="<%=String.valueOf(esfOrganizationUnitservice.getEsfOrganizationUnitserviceId()) %>" />
				<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfOrganizationUnitservice.jsp"%>' />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" message="edit"
				url="<%=editURL.toString() %>" />
		</c:if>
		
	<c:if test="<%= ESFOrganizationUnitServicePermission.contains(permissionChecker,esfOrganizationUnitservice.getEsfOrganizationUnitserviceId(), ActionKeys.ESFORGANIZATIONUNITSERVICE_DELETE) %>">	
		<portlet:actionURL name="deleteESFOrganizationUnitservice" var="deleteESFOrganizationUnitserviceURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfOrganizationUnitserviceId"
				value="<%= String.valueOf(esfOrganizationUnitservice.getEsfOrganizationUnitserviceId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteESFOrganizationUnitserviceURL.toString() %>" confirmation="delete_confirm"/>
	</c:if>
	
	</liferay-ui:icon-menu>