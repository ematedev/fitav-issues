<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFStockist esfStockist = (ESFStockist)row.getObject();

%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfStockistId" value="<%= String.valueOf(esfStockist.getEsfStockistId()) %>" />
		<portlet:param name="modifyMode" value="true" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_stockist.jsp" %>' />
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" message="edit"
		url="<%= editURL.toString() %>" />
		


	<portlet:actionURL name="deleteESFStockist" var="deleteURL">
		<portlet:param name="esfStockistId" value="<%= String.valueOf(esfStockist.getEsfStockistId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>'/>
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>