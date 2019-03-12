<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");



ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFTournament esfTournamentRow = (ESFTournament) row.getObject();
%>

<liferay-ui:icon-menu>

<c:if
		test="<%=ESFTournamentPermission.contains(
						permissionChecker, esfTournamentRow.getEsfTournamentId(),
						ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentRow.getEsfTournamentId())%>" />
			<portlet:param name="mvcPath"
				value='<%= templatePath + "edit_esfTournament.jsp" %>'/>
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString()%>" />
</c:if>

<c:if
	test="<%=ESFTournamentPermission.contains(
					permissionChecker, esfTournamentRow.getEsfTournamentId(),
					ActionKeys.PERMISSIONS)%>">
	<liferay-security:permissionsURL
		modelResource="<%= ESFTournament.class.getName()%>"
		modelResourceDescription="<%= esfTournamentRow.getTitle()%>"
		resourcePrimKey="<%=String.valueOf(esfTournamentRow.getEsfTournamentId())%>"
		var="permissionsURL" />

	<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
</c:if>

<c:if
	test="<%=ESFTournamentPermission.contains(
					permissionChecker, esfTournamentRow.getEsfTournamentId(),
					ActionKeys.UPDATE)%>">

	<portlet:renderURL var="matchURL">

		<portlet:param name="esfTournamentId"
			value="<%=String.valueOf(esfTournamentRow.getEsfTournamentId())%>" />
		<portlet:param name="mvcPath"
			value='<%= templatePath + "match/view.jsp" %>'/>
		<portlet:param name="op" value="updAddr" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="match"
		url="<%=matchURL.toString()%>" />

</c:if>

<c:if
	test="<%=ESFTournamentPermission.contains(
					permissionChecker, esfTournamentRow.getEsfTournamentId(),
					ActionKeys.UPDATE) /*&& esfTournamentRow.isIsNationalMatch() */%>">

	<portlet:renderURL var="delegationURL">
		<portlet:param name="esfTournamentId"
			value="<%=String.valueOf(esfTournamentRow.getEsfTournamentId())%>" />
		<portlet:param name="mvcPath"
			value='<%= templatePath + "delegation/view.jsp" %>'/>
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="delegation"
		url="<%= delegationURL.toString() %>" />
		
</c:if>		

<c:if
	test="<%=ESFTournamentPermission.contains(
					permissionChecker, esfTournamentRow.getEsfTournamentId(),
					ActionKeys.DELETE)%>">
	<portlet:actionURL name="deleteESFTournament" var="deleteURL">
		<portlet:param name="esfTournamentId"
			value="<%=String.valueOf(esfTournamentRow.getEsfTournamentId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
</c:if>

</liferay-ui:icon-menu>