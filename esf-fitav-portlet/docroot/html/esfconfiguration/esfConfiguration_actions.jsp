<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFConfiguration esfConfiguration = (ESFConfiguration)row.getObject(); 
%>
 
<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfConfigurationId"
				value="<%=String.valueOf(esfConfiguration.getEsfConfigurationId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfConfiguration.jsp"%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString() %>" />

		<portlet:actionURL name="deleteESFConfiguration" var="deleteURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfConfigurationId"
				value="<%= String.valueOf(esfConfiguration.getEsfConfigurationId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>