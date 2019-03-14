<%@include file="/stateadmin/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFState esfState = (ESFState) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=ESFStatePermission.contains(
						permissionChecker, esfState.getEsfStateId(),
						ESFStateActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
			<portlet:param name="esfStateId"
				value="<%=String.valueOf(esfState.getEsfStateId())%>" />
			<portlet:param name="mvcPath"
				value="/stateadmin/html/edit_esfState.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	</c:if>

	<c:if
		test="<%=ESFStatePermission.contains(
						permissionChecker, esfState.getEsfStateId(),
						ESFStateActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%=ESFState.class.getName()%>"
			modelResourceDescription="<%=esfState.getEsfName()%>"
			resourcePrimKey="<%=String.valueOf(esfState.getEsfStateId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>

	<c:if
		test="<%=ESFStatePermission.contains(
						permissionChecker, esfState.getEsfStateId(),
						ESFStateActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteESFState" var="deleteURL">
			<portlet:param name="esfStateId"
				value="<%=String.valueOf(esfState.getEsfStateId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>