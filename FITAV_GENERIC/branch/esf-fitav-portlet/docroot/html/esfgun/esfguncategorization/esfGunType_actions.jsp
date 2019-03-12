<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="../init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFGunType esfGunType = (ESFGunType)row.getObject(); 

boolean isCatridge = false;
if(Validator.isNotNull(esfGunType) && Validator.isNotNull(esfGunType.getIsCatridgeProductor())){
	
	isCatridge = esfGunType.getIsCatridgeProductor();
	
}

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUNKIND) %>">


	<%if(isCatridge){ %>
		<portlet:renderURL var="esfCatridgeURL">
			<portlet:param name="esfGunTypeId"
				value="<%=String.valueOf(esfGunType.getEsfGunTypeId()) %>" />
			<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/view_esfGunCatridge.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="view" url="<%= esfCatridgeURL %>" label="view-models"/>

	<%}else{ %>
		<portlet:renderURL var="esfKindURL">
			<portlet:param name="esfGunTypeId"
				value="<%=String.valueOf(esfGunType.getEsfGunTypeId()) %>" />
			<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/view_esfGunKind.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="view" url="<%= esfKindURL %>" label="view-models"/>
	<% }%>
	</c:if>

	<c:if
		test="<%= ESFGunTypePermission.contains(permissionChecker, esfGunType.getEsfGunTypeId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfGunTypeId"
				value="<%=String.valueOf(esfGunType.getEsfGunTypeId()) %>" />
			<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/edit_esfGunType.jsp" />
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

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

	</c:if>

</liferay-ui:icon-menu>