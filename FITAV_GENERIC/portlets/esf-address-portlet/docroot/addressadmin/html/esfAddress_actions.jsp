<%@include file="/addressadmin/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFAddress esfAddress = (ESFAddress) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=ESFAddressPermission.contains(
						permissionChecker, esfAddress.getEsfAddressId(),
						ESFAddressActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL"
			windowState="<%=WindowState.MAXIMIZED.toString()%>">
			<portlet:param name="esfAddressId"
				value="<%=String.valueOf(esfAddress.getEsfAddressId())%>" />
			<portlet:param name="mvcPath"
				value="/addressadmin/html/edit_esfAddress.jsp" />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	</c:if>

	<c:if
		test="<%=ESFAddressPermission.contains(
						permissionChecker, esfAddress.getEsfAddressId(),
						ESFAddressActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%=ESFAddress.class.getName()%>"
			modelResourceDescription="<%=esfAddress.getStreet1()%>"
			resourcePrimKey="<%=String.valueOf(esfAddress.getEsfAddressId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>

	<c:if
		test="<%=ESFAddressPermission.contains(
						permissionChecker, esfAddress.getEsfAddressId(),
						ESFAddressActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteESFAddress" var="deleteURL">
			<portlet:param name="esfAddressId"
				value="<%=String.valueOf(esfAddress.getEsfAddressId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>