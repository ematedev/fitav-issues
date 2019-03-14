<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFUser esfUser = (ESFUser) row.getObject();
	long esfUserId = esfUser.getEsfUserId();
%>
<liferay-ui:icon-menu >

<c:if test="<%= ESFShooterPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFSHOOTER_VIEW) %>">	
		<portlet:renderURL var="editURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUser.getEsfUserId())%>" />
			<portlet:param name="organizationId"
				value="<%= String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfShooter.jsp"%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="view"
			url="<%=editURL.toString()%>" />

</c:if>
	
<c:if
		test="<%=ESFShooterPermission.contains(permissionChecker, esfUser.getEsfUserId(),
							ActionKeys.ESFSHOOTER_VIEW_CURRICULUM)%>">
							
	<portlet:resourceURL var="generateCVURL">
	
		<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUserId)%>" />
		<portlet:param name="generateCurriculum"
				value="<%= String.valueOf(true)%>" />

	</portlet:resourceURL>
							
		<liferay-ui:icon image="view" message="curriculum" url="<%=generateCVURL.toString()%>" />
		
</c:if>

</liferay-ui:icon-menu>

