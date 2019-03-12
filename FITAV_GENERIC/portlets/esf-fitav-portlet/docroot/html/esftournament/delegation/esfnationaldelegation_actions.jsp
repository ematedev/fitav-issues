<%@include file="init.jsp"%>

<%
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFNationalDelegation esfNationalDelegation = (ESFNationalDelegation) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:resourceURL var="associationsURL" id="associations"
		escapeXml="false" >
		<portlet:param name="action" value="report" />
		<portlet:param name="userId" value="<%= String.valueOf(esfNationalDelegation.getEsfUserId())%>" />
	</portlet:resourceURL>

	<liferay-ui:icon image="print" message="print-document"
		url="<%= associationsURL.toString() %>" />

	<portlet:renderURL var="updateESFNationalDelegationURL">
		<portlet:param name="esfTournamentId"
			value="<%= String.valueOf(esfNationalDelegation.getEsfTournamentId())%>" />
		<portlet:param name="esfUserId"
			value="<%= String.valueOf(esfNationalDelegation.getEsfUserId())%>" />
		<portlet:param name="className" value="<%= esfNationalDelegation.getClassName() %>" />
		<portlet:param name="classPK" value="<%= String.valueOf(esfNationalDelegation.getClassPK()) %>" />
		<portlet:param name="mvcPath" 
				value='<%= templatePath + "delegation/edit_esfnationaldelegation.jsp" %>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%= updateESFNationalDelegationURL.toString() %>" />
		
	<portlet:actionURL name="deleteESFNationalDelegation" var="deleteESFNationalDelegationURL">
		<portlet:param name="esfTournamentId"
			value="<%= String.valueOf(esfNationalDelegation.getEsfTournamentId())%>" />
		<portlet:param name="esfUserId"
			value="<%= String.valueOf(esfNationalDelegation.getEsfUserId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteESFNationalDelegationURL.toString() %>" />
</liferay-ui:icon-menu>
