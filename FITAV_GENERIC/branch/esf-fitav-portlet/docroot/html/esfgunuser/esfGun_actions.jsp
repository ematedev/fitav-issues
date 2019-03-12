
<%@page import="it.ethica.esf.permission.ESFGunKindPermission"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFgunUser esfGun = (ESFgunUser)row.getObject(); 


String mvcPath1 = "";//ParamUtil.getString(request, "mvcPath");
String templatePath1="/html/esfgunuser/";

mvcPath1="alter_esfRifle.jsp";

long esfUserId=esfGun.getEsfUserId();
long esfgunUserId=esfGun.getEsfGunUserId();

%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFGunKindPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
		
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGun.getEsfGunId()) %>" />
			<portlet:param name="mvcPath" value='<%=templatePath1+mvcPath1 %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="esfgunUserId" value='<%=String.valueOf(esfgunUserId)%>' />
			
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />
	</c:if>
	
	<c:if
		test="<%= ESFGunKindPermission.contains(permissionChecker, esfGun.getEsfGunId(), ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteESFGun" var="deleteURL">
			<portlet:param name="esfGunId" value="<%= String.valueOf(esfGun.getEsfGunUserId()) %>" />
			<portlet:param name="mvcPath" value='/html/esfgunuser/view.jsp'/>
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>