<%@page import="it.ethica.esf.permission.ESFBrandPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFBrand esfBrand = (ESFBrand)row.getObject(); 
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfBrandId" value="<%=String.valueOf(esfBrand.getBrandId()) %>" />
		<portlet:param name="mvcPath" value="/html/esfbrand/edit_esfBrand.jsp" />
	</portlet:renderURL>
	
<c:if test="<%= ESFBrandPermission.contains(permissionChecker, esfBrand.getBrandId(), groupId, ActionKeys.ESFBRAND_UPDATE) %>">
	
	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString() %>" />
</c:if>
<%if(false){ %>
	<liferay-security:permissionsURL
		modelResource="<%= ESFBrand.class.getName() %>"
		modelResourceDescription="<%= esfBrand.getName() %>"
		resourcePrimKey="<%= String.valueOf(esfBrand.getBrandId()) %>"
		var="permissionsURL" />

<c:if test="<%= ESFBrandPermission.contains(permissionChecker, esfBrand.getBrandId(), groupId, ActionKeys.ESFBRAND_PERMISSION) %>">

	<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

</c:if>
<%} %>
	<portlet:actionURL name="deleteEsfBrand" var="deleteURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
		<portlet:param name="esfBrandId"
			value="<%= String.valueOf(esfBrand.getBrandId()) %>" />
	</portlet:actionURL>

<c:if test="<%= ESFBrandPermission.contains(permissionChecker, esfBrand.getBrandId(), groupId, ActionKeys.ESFBRAND_DELETE) %>">

	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>

</c:if>
</liferay-ui:icon-menu>