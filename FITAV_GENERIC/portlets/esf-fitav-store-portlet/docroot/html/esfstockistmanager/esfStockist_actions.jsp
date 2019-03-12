<%@page import="it.ethica.esf.permission.ESFStokistPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFStockist esfStockist = (ESFStockist)row.getObject();

String mvcPath1 ="edit_esfStockist.jsp";
%>

<liferay-ui:icon-menu>
<c:if test="<%= ESFStokistPermission.contains(permissionChecker,esfStockist.getEsfStockistId(), themeDisplay.getLayout().getGroupId(), ActionKeys.ESFSTOKISTMANAGER_UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfStockistId"
				value="<%= String.valueOf(esfStockist.getEsfStockistId()) %>" />
			<portlet:param name="mvcPath"
										value='<%= templatePath+mvcPath1 %>' />
			<portlet:param name="modifyMode" value="true" />
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" message="edit"
			url="<%= editURL.toString() %>" />
			
</c:if>

<c:if test="<%= ESFStokistPermission.contains(permissionChecker,esfStockist.getEsfStockistId(), themeDisplay.getLayout().getGroupId(), ActionKeys.ESFSTOKISTMANAGER_REMOVE)%>">

		<portlet:actionURL name="deleteESFStockist" var="deleteURL">
			<portlet:param name="esfStockistId"
				value="<%= String.valueOf(esfStockist.getEsfStockistId()) %>" />
				<portlet:param name="mvcPath"
										value='<%= templatePath+"view.jsp" %>'/>
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</c:if>
</liferay-ui:icon-menu>