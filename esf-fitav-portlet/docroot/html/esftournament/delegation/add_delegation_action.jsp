<%@include file="init.jsp"%>

<%
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfDelegation = null;

if (className.equals(ESFUserRole.class.getName())) {

	esfDelegation = (ESFUser) row.getObject();	
}
else if (className.equals(ESFNational.class.getName())) {

	ESFNational esfNational = (ESFNational) row.getObject();
	esfDelegation = ESFUserLocalServiceUtil.fetchESFUser(esfNational.getEsfUserId());
}
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="addESFNationalDelegation" var="addESFNationalDelegationURL">
		<portlet:param name="esfTournamentId"
			value="<%= String.valueOf(esfTournamentId)%>" />
		<portlet:param name="esfUserId"
			value="<%= String.valueOf(esfDelegation.getEsfUserId())%>" />
		<portlet:param name="className" value="<%= className %>" />
		<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
	</portlet:actionURL>

	<liferay-ui:icon image="add" message="add"
		url="<%= addESFNationalDelegationURL.toString() %>" />
</liferay-ui:icon-menu>
