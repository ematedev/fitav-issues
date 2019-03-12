<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfUserRow = (ESFUser) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:actionURL name="addESFPartecipant" var="addShooterURL">
<%-- 			<portlet:param name="isNational" value="<%=String.valueOf(isNational)%>" /> --%>
			<portlet:param name="esfUserId"
				value="<%=String.valueOf(esfUserRow.getEsfUserId())%>" /> 
			<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentId)%>" /> 
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchId)%>" /> 
			<portlet:param name="esfTeamId"
				value="<%=String.valueOf(0)%>" />
			<portlet:param name="ct"
				value="<%=String.valueOf(0)%>" />
			<portlet:param name="esfPartecipantTypeId"
				value="<%=String.valueOf(ESFKeys.ESFNationalDelegationType.SHOOTER)%>" />
			<portlet:param name="result"
				value="<%=String.valueOf(0)%>" />
	</portlet:actionURL> 
	
	<liferay-ui:icon image="edit" message="add"
			url="<%=addShooterURL.toString()%>" />
			
</liferay-ui:icon-menu>
