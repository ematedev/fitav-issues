<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFgunUser gunUser = (ESFgunUser)row.getObject(); 

String mvcPath1 = "";//ParamUtil.getString(request, "mvcPath");
String templatePath1="/html/esfgunuser/";

	mvcPath1="alter_esfCane.jsp";


long esfUserId = gunUser.getEsfUserId();
%>

<liferay-ui:icon-menu>
	
		<portlet:renderURL var="editURL">
			<portlet:param name="esfCaneId" value="<%=String.valueOf(gunUser.getEsfGunId()) %>" />
			<portlet:param name="esfGunUserId" value="<%=String.valueOf(gunUser.getEsfGunUserId()) %>" />
			<portlet:param name="mvcPath" value='<%=templatePath1+mvcPath1 %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString() %>" />

		<portlet:actionURL name="deleteESFCane" var="deleteURL">
			<portlet:param name="esfCaneId" value="<%= String.valueOf(gunUser.getEsfGunId()) %>" />
			<portlet:param name="esfgunUserId" value="<%= String.valueOf(gunUser.getEsfGunUserId()) %>" />
			<portlet:param name="mvcPath" value='/html/esfgunuser/view.jsp'/>
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>