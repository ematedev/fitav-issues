<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfUserRow = (ESFUser) row.getObject();

%>

<liferay-ui:icon-menu>
	
	<portlet:actionURL name="deleteESFNationalDelegation" var="deleteESFNationalDelegationURL">
		<portlet:param name="esfPartecipantTypeId"
				value="<%=String.valueOf(ESFKeys.ESFNationalDelegationType.SHOOTER)%>" />
			<portlet:param name="esfUserId"
				value="<%=String.valueOf(esfUserRow.getEsfUserId())%>" /> 
			<portlet:param name="isAzzurro"
				value="<%=String.valueOf(false)%>" />	
		<portlet:param name="esfMatchId"
			value="<%=String.valueOf(esfMatchId)%>" />
	</portlet:actionURL>
	
	<liferay-ui:icon image="edit" message="delete"
			url="<%=deleteESFNationalDelegationURL.toString()%>" />
			
</liferay-ui:icon-menu>