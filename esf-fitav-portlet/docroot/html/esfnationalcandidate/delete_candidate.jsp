<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Contact shooterContact = (Contact)row.getObject();
%>

<liferay-ui:icon-menu>

		<portlet:actionURL name="deleteCandidate" var="deleteCandidateURL">
			<portlet:param name="contactId"
				value="<%= String.valueOf(shooterContact.getContactId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteCandidateURL.toString() %>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>