<%@page import="it.ethica.esf.permission.ESFElectronicPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	ESFElectronic esfElectronic = (ESFElectronic) row.getObject();
%>

<liferay-ui:icon-menu>

<c:if test="<%= ESFElectronicPermission.contains(permissionChecker,esfElectronic.getElectronicId(), groupId, ActionKeys.ESFELECTRONIC_UPDATE) %>">
	<portlet:renderURL var="editURL">
		<portlet:param name="esfElectronicId" value="<%=String.valueOf(esfElectronic.getElectronicId()) %>" />
		<portlet:param name="mvcPath" value="/html/esfelectronic/edit_esfElectronic.jsp" />
	
	</portlet:renderURL>
	
	
	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString() %>" />
</c:if>	
<%if(false){ %>
<c:if test="<%= ESFElectronicPermission.contains(permissionChecker,esfElectronic.getElectronicId(), groupId, ActionKeys.ESFELECTRONIC_PERMISSION) %>">
	
	<liferay-security:permissionsURL
		modelResource="<%= ESFElectronic.class.getName() %>"
		modelResourceDescription="<%= esfElectronic.getName() %>"
		resourcePrimKey="<%= String.valueOf(esfElectronic.getElectronicId()) %>"
		var="permissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
</c:if>
<% }%>
<c:if test="<%= ESFElectronicPermission.contains(permissionChecker,esfElectronic.getElectronicId(), groupId, ActionKeys.ESFELECTRONIC_DELETE) %>">
	<portlet:actionURL name="deleteEsfElectronic" var="deleteURL" >
		<portlet:param name="esfElectronicId"
			value="<%= String.valueOf(esfElectronic.getElectronicId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>
</c:if>

</liferay-ui:icon-menu>