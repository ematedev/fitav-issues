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

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString() %>" />

	<liferay-security:permissionsURL
		modelResource="<%= ESFBrand.class.getName() %>"
		modelResourceDescription="<%= esfBrand.getName() %>"
		resourcePrimKey="<%= String.valueOf(esfBrand.getBrandId()) %>"
		var="permissionsURL" />

	<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	<portlet:actionURL name="deleteEsfBrand" var="deleteURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
		<portlet:param name="esfBrandId"
			value="<%= String.valueOf(esfBrand.getBrandId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>