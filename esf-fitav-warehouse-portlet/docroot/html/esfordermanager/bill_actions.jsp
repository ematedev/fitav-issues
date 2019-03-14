<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFBill esfBill = (ESFBill)row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfBillId" value="<%= String.valueOf(esfBill.getEsfBillId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_bill.jsp" %>' />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="modifyMode" value="true" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteESFBill" var="deleteURL">
		<portlet:param name="esfBillId" value="<%= String.valueOf(esfBill.getEsfBillId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view_bills.jsp" %>' />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>