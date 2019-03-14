<%@include file="init.jsp"%>

<portlet:actionURL
	name='updateMultiESFPartecipant' var="updateESFPartecipantURL" />

<portlet:renderURL var="backListShooter">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "match/edit_esfShooter.jsp"%>' />
<%-- 	<portlet:param name="isNational" --%>
<%-- 					value="<%=String.valueOf(isNational)%>" /> --%>
	<portlet:param name="esfTournamentId"
		value="<%=String.valueOf(esfTournamentId)%>" />
	<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" />
	<portlet:param name="op" value="addAddr" />
</portlet:renderURL>

<h3>
	<liferay-ui:message key="shooter-matches-of-tournament-complete">
		</liferay-ui:message>
</h3>

<b>
	<liferay-ui:message key="user-partecipant-assegn" />
</b>

<aui:form action="<%= updateESFPartecipantURL%>" name="<portlet:namespace />fm">

	<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= backListShooter%>"></aui:button>
	</aui:button-row>
	
	<aui:input type="hidden" name="esfTournamentId"
			value='<%=esfTournamentId%>' />

	<aui:input type="hidden" name="esfMatchId" value='<%= esfMatchId%>' />

<%-- 	<aui:input type="hidden" name="isNational" value='<%= isNational%>' /> --%>
	
	<aui:input type="hidden" name="esfPartecipantTypeId" 
	value='<%= ESFKeys.ESFNationalDelegationType.SHOOTER%>' />
	
	<%
	List<ESFUser> coaches = new ArrayList<ESFUser>();
	List<ESFUser> esfUsers = new ArrayList<ESFUser>();
	
	coaches = ESFUserLocalServiceUtil.findNationalPartecipantCoaches(
		esfTournamentId, esfMatchId, true);
	
	esfUsers = ESFUserLocalServiceUtil.findNationalPartecipantShooters(
		esfTournamentId, esfMatchId, true);
	
	List<ESFTeam> esfTeams = ESFTeamLocalServiceUtil.findByTournament(esfTournamentId);
	
	for (ESFUser esfUser : esfUsers) {
	
		ESFPartecipant esfPartecipant =	ESFPartecipantLocalServiceUtil.getPartecipantByU_M_T(
								esfUser.getEsfUserId(), esfMatchId, 
								ESFKeys.ESFNationalDelegationType.SHOOTER);
		%>
	
		<%= esfUser.getFirstName() + " " +
							esfUser.getLastName()%>
			
		<aui:input type="hidden" name="esfUserId" value='<%= esfUser.getEsfUserId()%>' />
		
		<aui:input type="hidden" name="esfPartecipantId" 
		value='<%= esfPartecipant.getEsfPartecipantId()%>' />
		
		<aui:input name="result" value="<%= esfPartecipant.getResult()%>">
			 <aui:validator name="digits"></aui:validator>
		</aui:input>

		<aui:select name="ct" >
			<aui:option value="0" label='-'></aui:option>
		<% 
			for(ESFUser coache : coaches){ 
				if(esfPartecipant.getCt() == coache.getEsfUserId()){
		%>
					<aui:option value="<%= coache.getEsfUserId()%>" selected="true"
						label='<%= coache.getFirstName()+" "+coache.getLastName()%>'></aui:option>
		<%	
				}else{ 
		%>
					<aui:option value="<%= coache.getEsfUserId()%>"
						label='<%= coache.getFirstName()+" "+coache.getLastName()%>'></aui:option>
		<%		}
			} 
		%>
		</aui:select>
	
		<aui:select name="esfTeamId" >
			<aui:option value="0" label='-'></aui:option>
		<% 
			for(ESFTeam esfTeam : esfTeams){ 
				if(esfPartecipant.getEsfTeamId() == esfTeam.getEsfTeamId()){
		%>
					<aui:option value="<%= esfTeam.getEsfTeamId()%>" selected="true"
						label='<%= esfTeam.getName()%>'></aui:option>
		<%	
				}else{ 
		%>
					<aui:option value="<%= esfTeam.getEsfTeamId()%>"
						label='<%= esfTeam.getName()%>'></aui:option>
		<%		}
			} 
		%>
		</aui:select>
	<%
		}
	%>
	
</aui:form>
