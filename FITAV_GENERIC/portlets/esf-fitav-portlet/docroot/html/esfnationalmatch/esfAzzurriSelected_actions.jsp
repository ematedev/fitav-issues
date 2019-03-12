<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFNationalDelegation esfUserRow = (ESFNationalDelegation) row.getObject();

long sportTypeId = esfUserRow.getEsfSportTypeId();
long qualificationId = esfUserRow.getEsfShooterQualificationId();

%>


<liferay-ui:icon-menu>
	
	<portlet:actionURL name="deleteESFNationalDelegation" var="deleteESFNationalDelegationURL">
		<portlet:param name="esfPartecipantTypeId"
				value="<%=String.valueOf(ESFKeys.ESFNationalDelegationType.SHOOTER)%>" />
		<portlet:param name="esfUserId"
				value="<%=String.valueOf(esfUserRow.getEsfUserId())%>" /> 
		<portlet:param name="isAzzurro"
				value="<%=String.valueOf(true)%>" />	
		<portlet:param name="esfMatchId"
			value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="sportTypeId"
			value="<%=String.valueOf(sportTypeId)%>" />
		<portlet:param name="qualificationId"
			value="<%=String.valueOf(qualificationId)%>" />
			
	</portlet:actionURL>
	
	<liferay-ui:icon image="edit" message="delete"
			url="<%=deleteESFNationalDelegationURL.toString()%>" />
			
</liferay-ui:icon-menu>