<%@include file="/tooladmin/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFTool esfTool = (ESFTool) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=ESFToolPermission.contains(
						permissionChecker, esfTool.getEsfToolId(),
						ESFToolActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL" windowState="<%=WindowState.MAXIMIZED.toString()%>">
			<portlet:param name="esfToolId"
				value="<%=String.valueOf(esfTool.getEsfToolId())%>" />
			<portlet:param name="mvcPath"
				value="/tooladmin/html/edit_esfTool.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	</c:if>

	<c:if
		test="<%=ESFToolPermission.contains(
						permissionChecker, esfTool.getEsfToolId(),
						ESFToolActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%=ESFTool.class.getName()%>"
			modelResourceDescription="<%=esfTool.getCode()%>"
			resourcePrimKey="<%=String.valueOf(esfTool.getEsfToolId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>

	<c:if
		test="<%=ESFToolPermission.contains(
						permissionChecker, esfTool.getEsfToolId(),
						ESFToolActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteESFTool" var="deleteURL">
			<portlet:param name="esfToolId"
				value="<%=String.valueOf(esfTool.getEsfToolId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>