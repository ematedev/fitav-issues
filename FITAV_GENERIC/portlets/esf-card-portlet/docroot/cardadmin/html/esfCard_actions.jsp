<%@include file="/cardadmin/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	ESFCard esfCard = (ESFCard)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=ESFCardPermission.contains(
						permissionChecker, esfCard.getEsfCardId(),
						ESFCardActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL" windowState="<%= WindowState.MAXIMIZED.toString() %>"> 
			<portlet:param name="esfCardId"
				value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
			<portlet:param name="mvcPath"
				value="/cardadmin/html/edit_esfCard.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	</c:if>
	
	<c:if
		test="<%=ESFCardPermission.contains(
						permissionChecker, esfCard.getEsfCardId(),
						ESFCardActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%=ESFCard.class.getName()%>"
			modelResourceDescription="<%=esfCard.getCode()%>"
			resourcePrimKey="<%=String.valueOf(esfCard.getEsfCardId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>

	<c:if
		test="<%=ESFCardPermission.contains(
						permissionChecker, esfCard.getEsfCardId(),
						ESFCardActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteESFCard" var="deleteURL">
			<portlet:param name="esfCardId"
				value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>