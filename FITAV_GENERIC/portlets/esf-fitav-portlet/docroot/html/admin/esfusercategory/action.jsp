<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUserCategory esfUserCategory = (ESFUserCategory)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="updateESFUserCategoryURL">
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="esfUserCategoryId" value="<%= String.valueOf(esfUserCategory.getEsfUserCategoryId()) %>" />
		<portlet:param name="mvcPath" value="/html/admin/esfusercategory/edit.jsp" />
	</liferay-portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= updateESFUserCategoryURL %>"
	/>
</liferay-ui:icon-menu>