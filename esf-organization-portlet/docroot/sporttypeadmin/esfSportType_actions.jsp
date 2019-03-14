<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFSportType esfSportType = (ESFSportType)row.getObject(); 

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFSportTypePermission.contains(permissionChecker, esfSportType.getEsfSportTypeId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfSportTypeId"
				value="<%=String.valueOf(esfSportType.getEsfSportTypeId()) %>" />
			<portlet:param name="mvcPath" value="/html/esffield/edit_esfSportType.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= ESFSportTypePermission.contains(permissionChecker, esfSportType.getEsfSportTypeId(), ActionKeys.PERMISSIONS) %>">

		<liferay-security:permissionsURL
			modelResource="<%= ESFSportType.class.getName() %>"
			modelResourceDescription="<%= esfSportType.getName() %>"
			resourcePrimKey="<%= String.valueOf(esfSportType.getEsfSportTypeId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>

	<c:if
		test="<%= ESFSportTypePermission.contains(permissionChecker, esfSportType.getEsfSportTypeId(), ActionKeys.DELETE) %>">

		<portlet:actionURL name="deleteESFSportType" var="deleteURL">
			<portlet:param name="esfSportTypeId"
				value="<%= String.valueOf(esfSportType.getEsfSportTypeId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

	</c:if>

</liferay-ui:icon-menu>