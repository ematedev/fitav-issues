<%@include file="init.jsp"%>
<%
PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", "/html/match/view.jsp");


%>
<c:choose>
	<c:when
		test="<%=ESFModelPermission.contains(permissionChecker, scopeGroupId,
					ActionKeys.VIEW_ESFMATCH)%>">

		<% String tournamentTitle = ESFTournamentLocalServiceUtil.getESFTournament(
				esfTournamentId).getTitle(); %>

		<liferay-ui:error key="date-message" message="date-message" />
		<liferay-ui:error key="date-torunament-message" message="date-torunament-message" />
		<liferay-ui:error key="match-success-insertupdate" message="match-success-insertupdate" />
		<liferay-ui:error key="partecipant-already-assigned-message"
			message="partecipant-already-assigned-message" />
			
		<h3><liferay-ui:message key="matches-of-tournament"> <%= tournamentTitle %></liferay-ui:message></h3>

		<aui:button-row cssClass="esfmatch-admin-buttons">
			<c:if
				test='<%=ESFModelPermission.contains(
								permissionChecker, scopeGroupId,
								ActionKeys.ADD_ESFMATCH)%>'>
				<portlet:renderURL var="addEsfMatchURL">
					<portlet:param name="mvcPath"
						value='<%=templatePath + "match/new_edit_esfMatch.jsp"%>' />
<%-- 					<portlet:param name="isNational" --%>
<%-- 						value="<%=String.valueOf(isNational)%>" /> --%>
					<portlet:param name="organizationId"
						value="<%=String.valueOf(currentOrganizationId)%>" />
					<portlet:param name="esfTournamentId"
						value="<%=String.valueOf(esfTournamentId)%>" />
					<portlet:param name="op" value="addAddr" />
				</portlet:renderURL>

				<aui:button onClick="<%= addEsfMatchURL.toString() %>"
					value="add-match" />
			</c:if>
			
			<portlet:renderURL var="backTorunament">
					<portlet:param name="mvcPath"
						value='<%=templatePath + "view.jsp"%>' />
					<portlet:param name="esfTournamentId"
						value="<%=String.valueOf(esfTournamentId)%>" />
					<portlet:param name="op" value="addAddr" />
			</portlet:renderURL>
		
			<aui:button type="cancel" onClick="<%=backTorunament%>">
				
			</aui:button>
		
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=viewassURL %>">

			

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">

				<%
					SimpleDateFormat sdf =
										new SimpleDateFormat("dd/MM/yyyy");
				%>

				<liferay-ui:search-container-column-text name="start-date"
					value="<%=sdf.format(esfMatch.getStartDate())%>" />

				<liferay-ui:search-container-column-text name="start-hour"
					value="<%=esfMatch.getStartHour()%>" />

				<liferay-ui:search-container-column-text name="sport-type"
					value='<%= esfMatch.getEsfSportTypeId()!=0 ? ESFSportTypeLocalServiceUtil.getESFSportType(
						esfMatch.getEsfSportTypeId()).getName():""%>' />
					
				<liferay-ui:search-container-column-text name="num-disk"
					value="<%= String.valueOf(esfMatch.getNumDisk())%>" />
				
				<liferay-ui:search-container-column-text name="num-fields"
					value='<%= String.valueOf(esfMatch.getNumFields()) %>' />
					
				<liferay-ui:search-container-column-jsp
					path='<%=templatePath +
								"match/esfMatch_actions.jsp"%>'
					align="right" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message
				key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>
