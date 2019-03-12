<%@include file="init.jsp"%>
<%
PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", "/html/match/edit_esfReferee.jsp");


%>
<c:choose>
	<c:when
		test="<%=ESFModelPermission.contains(
						permissionChecker, scopeGroupId,
						ActionKeys.VIEW_ESFMATCH)%>">

		<%
			String tournamentTitle =
						ESFTournamentLocalServiceUtil.getESFTournament(
							esfTournamentId).getTitle();
		%>

		<liferay-ui:error key="date-torunament-message"
			message="date-torunament-message" />

		<h3>
			<liferay-ui:message key="referee-matches-of-tournament">
				<%=tournamentTitle%></liferay-ui:message>
		</h3>

		<b>
			<liferay-ui:message key="referee-partecipant-assegn" />
		</b>
		
		<div class="panel">

		<%
		
		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		
		esfUsers = ESFUserLocalServiceUtil.findNationalPartecipantReferees(
				esfTournamentId, esfMatchId, true);
		
		for (ESFUser esfUser : esfUsers) {

			ESFPartecipant esfPartecipant =
								ESFPartecipantLocalServiceUtil.getPartecipantByU_M_T(
									esfUser.getEsfUserId(), esfMatchId, 
									ESFKeys.ESFNationalDelegationType.REFEREE);
			%>
	
			<portlet:actionURL name="deleteESFPartecipant" var="deleteRefereeURL">
<%-- 				<portlet:param name="isNational" value="<%=String.valueOf(isNational)%>" /> --%>
				<portlet:param name="esfPartecipantTypeId"
					value="<%=String.valueOf(ESFKeys.ESFNationalDelegationType.REFEREE)%>" />
				<portlet:param name="esfPartecipantId"
					value="<%=String.valueOf(esfPartecipant.getEsfPartecipantId())%>" />
				<portlet:param name="esfTournamentId"
					value="<%=String.valueOf(esfTournamentId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchId)%>" />
			</portlet:actionURL>
	
			<%= esfUser.getFirstName() + " " +
								esfUser.getLastName()%>
								
			<liferay-ui:icon-delete url="<%=deleteRefereeURL.toString()%>" />

		<%
			}
		%>
		
		</div>

		<aui:button-row cssClass="esfmatch-admin-buttons">
			
			<portlet:renderURL var="backMatch">
				<portlet:param name="mvcPath"
					value='<%=templatePath + "match/view.jsp"%>' />
<%-- 				<portlet:param name="isNational" value="<%=String.valueOf(isNational)%>" /> --%>
				<portlet:param name="esfTournamentId"
					value="<%=String.valueOf(esfTournamentId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchId)%>" />
				<portlet:param name="op" value="addAddr" />
			</portlet:renderURL>

			<aui:button type="cancel" onClick="<%=backMatch%>" value="done">

			</aui:button>

		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=viewassURL %>">
		
		<%
		List<ESFUser> esfPartecipants = new ArrayList<ESFUser>();
		int esfPartecipantsCount = 0;
		
		esfPartecipants = ESFUserLocalServiceUtil.findNationalPartecipantReferees(
			esfTournamentId, esfMatchId, false,
			searchContainer.getStart(),
			searchContainer.getEnd());
		
		esfPartecipantsCount =  ESFUserLocalServiceUtil.findNationalPartecipantReferees(
				esfTournamentId, esfMatchId, false).size();
		%>
			<liferay-ui:search-container-results
				results="<%= esfPartecipants%>"
				total="<%= esfPartecipantsCount%>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

				<liferay-ui:search-container-column-text property="firstName"
					name="first-name" />

				<liferay-ui:search-container-column-text property="lastName"
					name="last-name" />

				<liferay-ui:search-container-column-text property="screenName"
					name="screen-name" />

				<liferay-ui:search-container-column-jsp
					path='<%=templatePath +
								"match/esfReferee_actions.jsp"%>'
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
