<%@page import="it.ethica.esf.permission.ESFUnitservicePermission"%>
<%@include file="init.jsp"%>
<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFUnitservice esfUnitService = (ESFUnitservice)row.getObject();
%>


<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL">
			<portlet:param name="esfUnitserviceId"
				value="<%=String.valueOf(esfUnitService.getEsfUnitserviceId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfUnitservice.jsp"%>' />
		</portlet:renderURL>
		
	<c:if test="<%= ESFUnitservicePermission.contains(permissionChecker,esfUnitService.getEsfUnitserviceId(), scopeGroupId, ActionKeys.ESFUNITSERVICE_UPDATE) %>">
	
		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString() %>" />
		
	</c:if>
<%if(false){ %>	
		<liferay-security:permissionsURL
			modelResource="<%= ESFUnitservice.class.getName() %>"
			modelResourceDescription="<%= esfUnitService.getDescription() %>"
			resourcePrimKey="<%= String.valueOf(esfUnitService.getEsfUnitserviceId()) %>"
			var="permissionsURL" />
			
	<c:if test="<%= ESFUnitservicePermission.contains(permissionChecker,esfUnitService.getEsfUnitserviceId(), scopeGroupId, ActionKeys.ESFUNITSERVICE_PERMISSION) %>">
	
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	
	</c:if>
<% }%>
		<portlet:actionURL name="deleteESFUnitservice" var="deleteESFUnitserviceURL" >
			<portlet:param name="esfUnitserviceId"
				value="<%= String.valueOf(esfUnitService.getEsfUnitserviceId()) %>" />
		</portlet:actionURL>
	
	<c:if test="<%= ESFUnitservicePermission.contains(permissionChecker,esfUnitService.getEsfUnitserviceId(), scopeGroupId, ActionKeys.ESFUNITSERVICE_DELETE) %>">
	
		<liferay-ui:icon-delete url="<%=deleteESFUnitserviceURL.toString() %>" confirmation="delete_confirm"/>
	
	</c:if>

</liferay-ui:icon-menu>