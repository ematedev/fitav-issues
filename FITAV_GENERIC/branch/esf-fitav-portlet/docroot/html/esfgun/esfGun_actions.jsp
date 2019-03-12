<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@ include file="init.jsp"%> 

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFGunKind esfGun = (ESFGunKind)row.getObject(); 
long gunId = esfGun.getEsfGunKindId();

String mvcPath1 = "";//ParamUtil.getString(request, "mvcPath");
String templatePath1="/html/esfgun/";


mvcPath1="edit_esfRifle.jsp";

%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL">
			<portlet:param name="esfGunId"
				value="<%=String.valueOf(esfGun.getEsfGunKindId()) %>" />
			<portlet:param name="mvcPath"
										value='<%=templatePath1+mvcPath1 %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />
			
		<portlet:actionURL name="deleteESFGun" var="deleteURL">
			<portlet:param name="esfGunId" value="<%= String.valueOf(esfGun.getEsfGunKindId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>'/>
		</portlet:actionURL>
	
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	
		<portlet:renderURL var="AssignURL">
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGun.getEsfGunKindId()) %>" />
			<portlet:param name="mvcPath" value='<%=templatePath1+"assignUser.jsp" %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="type" value='<%=String.valueOf(ESFKeys.ESFGunType.RIFLE)%>' />
		</portlet:renderURL>
	
		<liferay-ui:icon image="edit" message="assign_shooter" url="<%=AssignURL.toString() %>" />
				
		<portlet:renderURL var="AssignedURL">
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGun.getEsfGunKindId()) %>" />
			<portlet:param name="mvcPath" value='<%=templatePath1+"shooter_assigned.jsp" %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="esfGunId" value='<%=String.valueOf(gunId)%>' />
			<portlet:param name="type" value='<%=String.valueOf(ESFKeys.ESFGunType.RIFLE)%>' />
		</portlet:renderURL>
	
		<liferay-ui:icon image="edit" message="shooter_assigned" url="<%=AssignedURL.toString() %>" />
	
</liferay-ui:icon-menu>