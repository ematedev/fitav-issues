<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfUserRow = (ESFUser) row.getObject();

ESFPartecipant esfPartecipant = ESFPartecipantLocalServiceUtil.
								getESFPartecipantByESFMatchId_ESFUserId(
										esfMatchId, esfUserRow.getEsfUserId());

String id=String.valueOf(esfPartecipant.getEsfUserId());
%>

<liferay-ui:icon-menu>

	<portlet:actionURL name="deleteESFPartecipant" var="deleteStaffURL">
		<portlet:param name="esfPartecipantTypeId"
			value="<%=String.valueOf(String.valueOf(-1))%>" />
		<portlet:param name="esfPartecipantId"
			value="<%=String.valueOf(esfPartecipant.getEsfPartecipantId())%>" />
		<portlet:param name="esfMatchId"
			value="<%=String.valueOf(esfMatchId)%>" />
	</portlet:actionURL>
	
	<liferay-ui:icon image="delete" message="remove"
			url="<%=deleteStaffURL.toString()%>" />
			
</liferay-ui:icon-menu>