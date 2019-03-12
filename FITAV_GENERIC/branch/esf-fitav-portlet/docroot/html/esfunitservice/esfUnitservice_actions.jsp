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
		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString() %>" />

		<liferay-security:permissionsURL
			modelResource="<%= ESFUnitservice.class.getName() %>"
			modelResourceDescription="<%= esfUnitService.getDescription() %>"
			resourcePrimKey="<%= String.valueOf(esfUnitService.getEsfUnitserviceId()) %>"
			var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

		<portlet:actionURL name="deleteESFUnitservice" var="deleteESFUnitserviceURL" >
			<portlet:param name="esfUnitserviceId"
				value="<%= String.valueOf(esfUnitService.getEsfUnitserviceId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteESFUnitserviceURL.toString() %>" />

</liferay-ui:icon-menu>