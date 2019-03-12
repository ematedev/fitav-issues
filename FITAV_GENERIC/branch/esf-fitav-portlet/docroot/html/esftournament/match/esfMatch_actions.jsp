<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFMatch esfMatchRow = (ESFMatch) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=ESFMatchPermission.contains(
						permissionChecker, esfMatchRow.getEsfMatchId(),
						ActionKeys.UPDATE)%>">
		<% if (esfMatchRow.isIsDraft()) { %>
			<portlet:renderURL var="editURL">
<%-- 				<portlet:param name="isNational" --%>
<%-- 					value="<%=String.valueOf(isNational)%>" /> --%>
				<portlet:param name="organizationId"
					value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="esfTournamentId"
					value="<%=String.valueOf(esfTournamentId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
				<portlet:param name="associationId"
					value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
				<portlet:param name="mvcPath"
					value='<%= templatePath + "match/new_edit_esfMatch.jsp" %>'/>
				<portlet:param name="op" value="updAddr" />
			</portlet:renderURL>

			<liferay-ui:icon image="edit" message="edit"
				url="<%=editURL.toString()%>" />
		<% } %>
		<portlet:renderURL var="editCTURL">
<%-- 			<portlet:param name="isNational" --%>
<%-- 				value="<%=String.valueOf(isNational)%>" /> --%>
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
			<portlet:param name="mvcPath"
				value='<%= templatePath + "match/edit_esfCT.jsp" %>'/>
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="ct"
			url="<%=editCTURL.toString()%>" />

		<portlet:renderURL var="editShooterURL">
<%-- 			<portlet:param name="isNational" --%>
<%-- 				value="<%=String.valueOf(isNational)%>" /> --%>
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />

			<portlet:param name="mvcPath"
				value='<%= templatePath + "match/edit_esfShooter.jsp" %>'/>
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="shooter"
			url="<%=editShooterURL.toString()%>" />
		
		<portlet:renderURL var="editRefereeURL">
<%-- 			<portlet:param name="isNational" --%>
<%-- 				value="<%=String.valueOf(isNational)%>" /> --%>
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
			<portlet:param name="mvcPath"
				value='<%= templatePath + "match/edit_esfReferee.jsp" %>'/>
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="referee"
			url="<%=editRefereeURL.toString()%>" />
			
		<portlet:renderURL var="editDoctorURL">
<%-- 			<portlet:param name="isNational" --%>
<%-- 				value="<%=String.valueOf(isNational)%>" /> --%>
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
			<portlet:param name="mvcPath"
				value='<%= templatePath + "match/edit_esfDoctor.jsp" %>'/>
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="doctor"
			url="<%=editDoctorURL.toString()%>" />
			
	</c:if>

	<c:if
		test="<%=ESFMatchPermission.contains(
						permissionChecker, esfMatchRow.getEsfMatchId(),
						ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%= ESFMatch.class.getName()%>"
			modelResourceDescription="<%= String.valueOf(esfMatchRow.getNumDisk())%>"
			resourcePrimKey="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>
	
	<c:if
		test="<%=ESFMatchPermission.contains(
						permissionChecker, esfMatchRow.getEsfMatchId(),
						ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteESFMatch" var="deleteURL">
<%-- 			<portlet:param name="isNational" --%>
<%-- 				value="<%=String.valueOf(isNational)%>" /> --%>
			<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>

</liferay-ui:icon-menu>