<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFJob esfJob = (ESFJob) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfJobId"
			value="<%=String.valueOf(esfJob.getEsfJobId())%>" />
		<portlet:param name="mvcPath"
			value='<%= templatePath +"edit_esfJob.jsp" %>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />

	<portlet:actionURL name="deleteESFJob" var="deleteURL">
		<portlet:param name="esfJobId"
			value="<%=String.valueOf(esfJob.getEsfJobId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>