<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFState esfState = (ESFState)row.getObject();

%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfStateId" value="<%= String.valueOf(esfState.getEsfStateId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfState.jsp"%>' />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>
	
	<portlet:actionURL name="deleteESFState" var="deleteURL">
		<portlet:param name="esfStateId" value="<%= String.valueOf(esfState.getEsfStateId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />

	<portlet:renderURL var="assignURL">
		<portlet:param name="esfStateId" value="<%= String.valueOf(esfState.getEsfStateId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view_entity.jsp"%>' />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Assign Entity" url="<%= assignURL.toString() %>"/>
	
</liferay-ui:icon-menu>