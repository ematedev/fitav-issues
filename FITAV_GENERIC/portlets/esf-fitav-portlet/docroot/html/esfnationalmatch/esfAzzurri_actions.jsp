<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfMatchId = ParamUtil.getLong(request, "esfMatchId");



ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFNational esfUserRow = (ESFNational) row.getObject();
long sportTypeId = esfUserRow.getEsfSportTypeId();

%>

<liferay-ui:icon-menu>

	<portlet:actionURL name="addESFNationalDelegation" var="addESFNationalDelegationURL">
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
	</portlet:actionURL> 
	
	<liferay-ui:icon image="edit" message="add" url="<%=addESFNationalDelegationURL.toString()%>" />
			
</liferay-ui:icon-menu>