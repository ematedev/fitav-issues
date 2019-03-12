<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFMatch esfMatchRow = (ESFMatch) row.getObject();
%>

<liferay-ui:icon-menu>

	<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNORMALMATCH_VIEW) %>">	
		<portlet:renderURL var="editURL">
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" /> 
			<portlet:param name="mvcPath"
				value='<%=templatePath + "new_edit_esfMatch.jsp"%>' />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>
		<liferay-ui:icon image="view" message="view" url="<%=editURL.toString()%>" />
	</c:if>
			
								
	<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNORMALMATCH_VIEW_STAFF) %>">	
		<portlet:renderURL var="editStaffURL">
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_staff.jsp"%>' />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="staff"
			url="<%=editStaffURL.toString()%>" />
	</c:if>

	<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNORMALMATCH_VIEW_RESULT) %>">	
		<portlet:renderURL var="addResultURL">
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfAddResult.jsp"%>' />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="add-result"
			url="<%=addResultURL.toString()%>" />
	</c:if>
	
	<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNORMALMATCH_DELETE) %>">	
		<portlet:actionURL name="deleteESFMatch" var="deleteURL">
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>"/>
	</c:if>
	
</liferay-ui:icon-menu>
