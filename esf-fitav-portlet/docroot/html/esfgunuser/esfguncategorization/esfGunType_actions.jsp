<%@ include file="../init.jsp" %>
<%@page import="it.ethica.esf.permission.ESFGunTypePermission"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<% 
		
long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
long esfGunId = ParamUtil.getLong(request, "esfGunId");

String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFGunType esfGunType = (ESFGunType)row.getObject(); 

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUNKIND) %>">

		<portlet:renderURL var="esfKindURL">
			<portlet:param name="esfGunTypeId"
				value="<%=String.valueOf(esfGunType.getEsfGunTypeId()) %>" />
			<portlet:param name="mvcPath" value="/html/esfgunuser/esfguncategorization/view_esfGunKind.jsp" />
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
			<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="view" url="<%= esfKindURL %>" label="view-models"/>

	</c:if>

	<c:if
		test="<%= ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfGunTypeId"
				value="<%=String.valueOf(esfGunType.getEsfGunTypeId()) %>" />
			<portlet:param name="mvcPath" value="/html/esfgunuser/esfguncategorization/edit_esfGunType.jsp" />
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
			<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.PERMISSIONS) %>">

		<liferay-security:permissionsURL
			modelResource="<%= ESFGunType.class.getName() %>"
			modelResourceDescription="<%= esfGunType.getName() %>"
			resourcePrimKey="<%= String.valueOf(esfGunType.getEsfGunTypeId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>

	<c:if
		test="<%= ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.DELETE) %>">

		<portlet:actionURL name="deleteESFGunType" var="deleteURL">
			<portlet:param name="esfGunTypeId"
				value="<%= String.valueOf(esfGunType.getEsfGunTypeId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>

	</c:if>

</liferay-ui:icon-menu>