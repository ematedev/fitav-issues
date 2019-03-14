<%@include file="init.jsp"%>

<%
if (currentOrganizationId == 0) { %>

	<div class="alert alert-error">
		<liferay-ui:message key="place-this-portlet-inside-an-esforganization-site" >
		</liferay-ui:message>
	</div>

<%
}
else {
%>

<c:choose>
	<c:when test="<%=ESFModelPermission.contains( 
		permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFTOURNAMENT)%>">

		<liferay-ui:error key="" message="" />

		<c:if test='<%=ESFModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFTOURNAMENT)%>'>
			<aui:button-row cssClass="esftournament-admin-buttons">
				<portlet:renderURL var="addEsfTournamentURL">
					<portlet:param name="mvcPath" value='<%=templatePath + "edit_esfTournament.jsp"%>' />
					<portlet:param name="op" value="addAddr" />
				</portlet:renderURL>
				<aui:button onClick="<%= addEsfTournamentURL.toString() %>"
					value='<%= "add-national-tournament" %>' />
			</aui:button-row>
		</c:if>

		<liferay-ui:search-container delta="5"	emptyResultsMessage="no-tournament-were-found">

			<liferay-ui:search-container-results
				results="<%=ESFTournamentLocalServiceUtil.findESFTournamentsByOrganizationId(
							currentOrganizationId, true,
							ESFKeys.ESFStateType.ENABLE, true)%>"
				total="<%=ESFTournamentLocalServiceUtil.findESFTournamentsByOrganizationId(
							currentOrganizationId, true,
							ESFKeys.ESFStateType.ENABLE, true).size()%>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFTournament"
				modelVar="esfTournament">

				<%
				int numMatch = 0;
					
				//int numMatch = ESFMatchLocalServiceUtil.findESFMatchsByT_S(
				//	esfTournament.getEsfTournamentId(),
				//	ESFKeys.ESFStateType.ENABLE).size();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				%>

				<liferay-ui:search-container-column-text name="title"
					value="<%=esfTournament.getTitle()%>" />
				<liferay-ui:search-container-column-text name="description"
					value="<%=esfTournament.getDescription()%>" />
				<liferay-ui:search-container-column-text name="N. Match"
					value="<%= String.valueOf(numMatch)%>" />
				<liferay-ui:search-container-column-text name="start-date"
					value="<%=sdf.format(esfTournament.getStartDate())%>" />
				<liferay-ui:search-container-column-text name="end-date"
					value="<%=sdf.format(esfTournament.getEndDate())%>" />

				<liferay-ui:search-container-column-jsp
					path='<%=templatePath +
								"esfTournament_actions.jsp"%>'
					align="right" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true"/>
		</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message
				key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>

<%
}
%>