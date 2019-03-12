<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	ESFOrganization esfOrganization = (ESFOrganization) row.getObject();
%>
<liferay-ui:icon-menu>
	
	<c:if test="<%= ESFCardPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.ESFCARD_VIEW) %>">	
	
		<portlet:renderURL var="viewURL">
			<portlet:param name="esfOrganizationIdToFind" value="<%=String.valueOf(esfOrganization.getEsfOrganizationId()) %>" />
			<portlet:param name="esfOrganizationType" value="<%=String.valueOf(esfOrganization.getType()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>' />
		</portlet:renderURL>
	
		<liferay-ui:icon image="edit" message="view" url="<%=viewURL.toString() %>" />

	</c:if>
</liferay-ui:icon-menu>