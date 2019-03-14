<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="../init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFGun esfGun = (ESFGun)row.getObject(); 

long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
//long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunId = esfGun.getEsfGunId();

String mvcPath1 = "";//ParamUtil.getString(request, "mvcPath");
String templatePath1="/html/esfgunuser/";


	mvcPath1="edit_esfRifle.jsp";

%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="AssignURL">
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGun.getEsfGunId()) %>" />
			<portlet:param name="mvcPath" value='/html/esfgunuser/esfguncategorization/assignUser.jsp' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="type" value='<%=String.valueOf(ESFKeys.ESFGunType.RIFLE)%>' />
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
			<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="assign_shooter"
			url="<%=AssignURL.toString() %>" />

	<c:if
		test="<%= ESFGunPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.PERMISSIONS) %>">

		<liferay-security:permissionsURL
			modelResource="<%= ESFGun.class.getName() %>"
			modelResourceDescription="<%= ESFGunLocalServiceUtil.getFullName(esfGun) %>"
			resourcePrimKey="<%= String.valueOf(esfGun.getEsfGunId()) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>
		

	
	
</liferay-ui:icon-menu>