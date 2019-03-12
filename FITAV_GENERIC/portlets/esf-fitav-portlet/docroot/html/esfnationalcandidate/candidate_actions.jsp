<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Contact shooterContact = (Contact)row.getObject();
%>

<liferay-ui:icon-menu>

		<portlet:actionURL name="chooseCandidate" var="chooseCandidateURL">
			<portlet:param name="contactId"
				value="<%= String.valueOf(shooterContact.getContactId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="add" url="<%= chooseCandidateURL.toString() %>" />

</liferay-ui:icon-menu>