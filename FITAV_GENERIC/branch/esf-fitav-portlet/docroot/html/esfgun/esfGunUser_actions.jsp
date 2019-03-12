<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>


<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfGunId = ParamUtil.getLong(request, "esfGunId");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFgunUser esfGunUser = (ESFgunUser)row.getObject(); 

String templatePath1="/html/esfgun/";
String mvcPath1="shooter_assigned.jsp";
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="deleteESFGunUser" var="deleteGunUserURL">
		<portlet:param name="esfGunUserId" value="<%= String.valueOf(esfGunUser.getEsfGunUserId()) %>" />
		<portlet:param name="esfGunId" value="<%= String.valueOf(esfGunId) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + mvcPath1 %>'/>
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteGunUserURL.toString() %>" />

</liferay-ui:icon-menu>