<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFCategory esfCategory = (ESFCategory)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="updateESFCategoryURL">
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="esfCategoryId" value="<%= String.valueOf(esfCategory.getEsfCategoryId()) %>" />
		<portlet:param name="mvcPath" value="/html/admin/esfcategory/edit.jsp" />
	</liferay-portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= updateESFCategoryURL %>"
	/>

	<liferay-portlet:actionURL name="deleteESFCategory" var="deleteESFCategoryURL">
		<portlet:param name="esfCategoryId" value="<%= String.valueOf(esfCategory.getEsfCategoryId()) %>" />
	</liferay-portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteESFCategoryURL %>"
	/>
</liferay-ui:icon-menu>