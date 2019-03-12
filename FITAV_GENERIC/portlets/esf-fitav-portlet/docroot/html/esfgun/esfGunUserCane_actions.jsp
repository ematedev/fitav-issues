<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>


<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfGunId = ParamUtil.getLong(request, "esfGunId");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFCane esfcane = (ESFCane)row.getObject(); 
long caneId = esfcane.getEsfCaneId();

String templatePath1="/html/esfgun/";
String mvcPath1="shooter_assigned.jsp";
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="deleteESFGunUserCane" var="deleteESFGunUserCaneURL">
		<portlet:param name="esfGunUserId" value="<%= String.valueOf(esfcane.getShooterId()) %>" />
		<portlet:param name="esfGunId" value="<%= String.valueOf(esfGunId) %>" />
		<portlet:param name="esfCaneId" value="<%= String.valueOf(caneId) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + mvcPath1 %>'/>
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteESFGunUserCaneURL.toString() %>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>