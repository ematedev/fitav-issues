<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFNationalDelegation del = (ESFNationalDelegation) row.getObject();

long partecipantType = del.getEsfPartecipantTypeId();
long esfPartecipantId = del.getEsfUserId();
long delId = del.getEsfNationalDelgationId();

%>

<liferay-ui:icon-menu>

	<portlet:actionURL name="deleteESFPartecipant" var="deleteStaffURL">
		<portlet:param name="esfPartecipantTypeId"
			value="<%=String.valueOf(partecipantType)%>" />
		<portlet:param name="esfPartecipantId"
			value="<%=String.valueOf(esfPartecipantId)%>" />
		<portlet:param name="esfMatchId"
			value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="delId"
			value="<%=String.valueOf(delId)%>" />
	</portlet:actionURL>
	
	<liferay-ui:icon image="delete" message="remove"
			url="<%=deleteStaffURL.toString()%>" />
	
	<portlet:renderURL var="refusalURL">
		<portlet:param name="delId"
			value="<%=String.valueOf(delId)%>" />
		<portlet:param name="mvcPath"
			value='<%=templatePath + "refusal.jsp"%>' />
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" message="refusalAndInstructor" url="<%=refusalURL.toString()%>" />
	
			
</liferay-ui:icon-menu>