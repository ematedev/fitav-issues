<%@page import="it.ethica.esf.permission.ESFGunCategorizationPermission"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFGunType esfGunType = (ESFGunType) row.getObject();

	boolean isCatridge = false;
	if (Validator.isNotNull(esfGunType)
			&& Validator.isNotNull(esfGunType.getIsCatridgeProductor())) {

		isCatridge = esfGunType.getIsCatridgeProductor();

	}
%>

<liferay-ui:icon-menu>

	<%
		if (isCatridge) {
	%>
<c:if test="<%= ESFGunCategorizationPermission.contains(permissionChecker,esfGunType.getEsfGunTypeId(), ActionKeys.ESFGUNCATEGORIZZATION__VIEW) %>">	
	<portlet:renderURL var="esfCatridgeURL">
		<portlet:param name="esfGunTypeId"
			value="<%=String.valueOf(esfGunType.getEsfGunTypeId())%>" />
		<portlet:param name="mvcPath"
			value="/html/esfguncategorization/view_esfGunCatridge.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon image="view" url="<%=esfCatridgeURL%>"
		label="view-models" />
</c:if>

	<%
		} else {
	%>

<c:if test="<%= ESFGunCategorizationPermission.contains(permissionChecker,esfGunType.getEsfGunTypeId(), ActionKeys.ESFGUNCATEGORIZZATION__VIEW) %>">
	<portlet:renderURL var="esfKindURL">
		<portlet:param name="esfGunTypeId"
			value="<%=String.valueOf(esfGunType.getEsfGunTypeId())%>" />
		<portlet:param name="mvcPath"
			value="/html/esfguncategorization/view_esfGunKind.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon image="view" url="<%=esfKindURL%>"
		label="view-models" />

</c:if>
	<%
		}
	%>
<c:if test="<%= ESFGunCategorizationPermission.contains(permissionChecker,esfGunType.getEsfGunTypeId(), ActionKeys.ESFGUNCATEGORIZZATION__UPDATE) %>">
	<portlet:renderURL var="editURL">
		<portlet:param name="esfGunTypeId"
			value="<%=String.valueOf(esfGunType.getEsfGunTypeId())%>" />
		<portlet:param name="mvcPath"
			value="/html/esfguncategorization/edit_esfGunType.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />
</c:if>

<%if(false){ %>
<c:if test="<%= ESFGunCategorizationPermission.contains(permissionChecker,esfGunType.getEsfGunTypeId(), ActionKeys.ESFGUNCATEGORIZZATION__PERMISSION) %>">
	<liferay-security:permissionsURL
		modelResource="<%=ESFGunType.class.getName()%>"
		modelResourceDescription="<%=esfGunType.getName()%>"
		resourcePrimKey="<%=String.valueOf(esfGunType.getEsfGunTypeId())%>"
		var="permissionsURL" />

	<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
</c:if>
<%} %>

<c:if test="<%= ESFGunCategorizationPermission.contains(permissionChecker,esfGunType.getEsfGunTypeId(), ActionKeys.ESFGUNCATEGORIZZATION__DELETE) %>">
	<portlet:actionURL name="deleteESFGunType" var="deleteURL">
		<portlet:param name="esfGunTypeId"
			value="<%=String.valueOf(esfGunType.getEsfGunTypeId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
</c:if>
</liferay-ui:icon-menu>