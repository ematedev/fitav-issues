<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFField esfField = (ESFField)row.getObject(); 

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
			<portlet:param name="esfFieldId"
				value="<%=String.valueOf(esfField.getEsfFieldId()) %>" />
			<portlet:param name="mvcPath" value="/html/esffield/edit_esfField.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.PERMISSIONS) %>">

		<liferay-security:permissionsURL
			modelResource="<%= ESFField.class.getName() %>"
			modelResourceDescription="<%= esfField.getName() %>"
			resourcePrimKey="<%= String.valueOf(esfField.getEsfFieldId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>

	<c:if
		test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.DELETE) %>">

		<portlet:actionURL name="deleteESFField" var="deleteURL">
			<portlet:param name="esfFieldId"
				value="<%= String.valueOf(esfField.getEsfFieldId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

	</c:if>

</liferay-ui:icon-menu>