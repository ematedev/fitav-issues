<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFFornitureType esfFornitureType = (ESFFornitureType)row.getObject(); 
%>
 
<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL" >
			<portlet:param name="esfFornitureTypeId"
				value="<%=String.valueOf(esfFornitureType.getEsfFornitureTypeId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfFornitureType.jsp"%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />

		<liferay-security:permissionsURL
			modelResource="<%= ESFFornitureType.class.getName() %>"
			modelResourceDescription="<%= esfFornitureType.getDescription() %>"
			resourcePrimKey="<%= String.valueOf(esfFornitureType.getEsfFornitureTypeId()) %>"
			var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
		
		<portlet:actionURL name="deleteESFFornitureType" var="deleteURL" >
			<portlet:param name="esfFornitureTypeId"
				value="<%= String.valueOf(esfFornitureType.getEsfFornitureTypeId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>