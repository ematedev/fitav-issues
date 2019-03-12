<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFUserRole esfUserRoleRow = (ESFUserRole) row.getObject();
	
	String assignPermURL = "/group/control_panel/manage?p_p_id=128&p_p_lifecycle=0"+
					"&p_p_state=maximized&p_p_mode=view&refererPlid="+themeDisplay.getPlid()+"&controlPanelCategory=users"+
					"&_128_cmd=view&_128_redirect=%2Fgroup%2Fcontrol_panel%2Fmanage%3Fp_p_id%3D128%26p_p_lifecycle%3D0%26"+
					"p_p_state%3Dmaximized%26p_p_mode%3Dview%26refererPlid%3D"+themeDisplay.getPlid()+"%26controlPanelCategory"+
					"%3Dusers%26_128_struts_action%3D%252Froles_admin%252Fview%26_128_cur%3D1%26_128_delta"+
					"%3D20%26_128_keywords%3D%26_128_advancedSearch%3Dfalse%26_128_andOperator%3Dtrue"+
					"%26_128_description%3D%26_128_name%3D%26_128_type%3D0%26_128_orderByCol%3Dtitle"+
					"%26_128_orderByType%3Dasc%26_128_resetCur%3Dfalse&_128_struts_action=%2Froles_admin"+
					"%2Fedit_role_permissions&_128_roleId="+esfUserRoleRow.getEsfUserRoleId();
	
%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL">
			<portlet:param name="esfUserRoleId"
				value="<%=String.valueOf(esfUserRoleRow.getEsfUserRoleId())%>" />
			<portlet:param name="mvcPath"
				value="/html/esfuserrole/edit_esfUserRole.jsp" />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>

		<portlet:renderURL var="membersURL">
			<portlet:param name="esfUserRoleId"
				value="<%=String.valueOf(esfUserRoleRow.getEsfUserRoleId())%>" />
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="mvcPath"
				value="/html/esfuserrole/choose_organization.jsp" />
			<portlet:param name="op" value="chooseorg" />
		</portlet:renderURL>
		
		<portlet:renderURL var="stateURL">
			<portlet:param name="esfUserRoleId"
				value="<%=String.valueOf(esfUserRoleRow.getEsfUserRoleId())%>" />
			<portlet:param name="mvcPath"
				value="/html/esfuserrole/edit_esfUserRoleState.jsp" />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>
		
<c:if test="<%= ESFUserRolePermission.contains(permissionChecker,esfUserRoleRow.getEsfUserRoleId(), scopeGroupId, ActionKeys.ESFUSERROLE_EDIT) %>">

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString()%>" />
</c:if>
<c:if test="<%= ESFUserRolePermission.contains(permissionChecker,esfUserRoleRow.getEsfUserRoleId(), scopeGroupId, ActionKeys.ESFUSERROLE_STATE) %>">
		<liferay-ui:icon image="edit" message="sel-entity-state"
			url="<%=stateURL.toString()%>" />
</c:if>		
<c:if test="<%= ESFUserRolePermission.contains(permissionChecker,esfUserRoleRow.getEsfUserRoleId(), scopeGroupId, ActionKeys.ESFUSERROLE_ASSIGN) %>">		
		<liferay-ui:icon image="edit" message="assign-members"
			url="<%=membersURL.toString()%>" />
</c:if>
<c:if test="<%= ESFUserRolePermission.contains(permissionChecker,esfUserRoleRow.getEsfUserRoleId(), scopeGroupId, ActionKeys.ESFUSERROLE_PERMISSION) %>">		
		<liferay-ui:icon image="edit" message="define-permission"
 			url="<%=assignPermURL.toString()%>" /> 
</c:if>	
<%if(false){ %>
		<liferay-security:permissionsURL
			modelResource="<%=ESFUserRole.class.getName()%>"
			modelResourceDescription="<%=esfUserRoleRow.getName()%>"
			resourcePrimKey="<%=String.valueOf(esfUserRoleRow.getEsfUserRoleId())%>"
			var="permissionsURL" />
<c:if test="<%= ESFUserRolePermission.contains(permissionChecker,esfUserRoleRow.getEsfUserRoleId(), scopeGroupId, ActionKeys.ESFUSERROLE_DEFINEPERMISSION) %>">
		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
</c:if>	
<%} %>
</liferay-ui:icon-menu>