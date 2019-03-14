<%@include file="/init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFOrganizationModel esfOrganizationModel = (ESFOrganizationModel)row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfOrganizationId" value="<%= String.valueOf(esfOrganizationModel.getEsfOrganizationId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_esforganization.jsp"%>' />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>
	<portlet:renderURL var="addFieldURL">
		<portlet:param name="esfOrganizationId" value="<%= String.valueOf(esfOrganizationModel.getEsfOrganizationId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfField.jsp"%>' />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Add Field" url="<%= addFieldURL.toString() %>"/>
	<portlet:actionURL name="deleteESFOrganization" var="deleteURL">
		<portlet:param name="esfOrganizationId" value="<%= String.valueOf(esfOrganizationModel.getEsfOrganizationId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>"></liferay-ui:icon-delete>
</liferay-ui:icon-menu>