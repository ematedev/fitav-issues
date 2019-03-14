
<%@ include file="init.jsp" %>

<%
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser    esfUser = (ESFUser) row.getObject();

String namespace = renderResponse.getNamespace();
%>

<button id='<%= namespace + "sendUser" + esfUser.getEsfUserId() %>'
	class="btn btn-small"
	value="<%= String.valueOf(esfUser.getEsfUserId()) %>"
	dataid="<%= String.valueOf(esfUser.getEsfUserId()) %>"
	dataname="<%= esfUser.getLastName() %>">

	<liferay-ui:icon image="add" message="add" />
</button>

<aui:script use="aui-base,node">

A.one('#<portlet:namespace/>sendUser<%= esfUser.getEsfUserId() %>').on('click', function(event) {

	var dataId = event._currentTarget.getAttribute('dataid');
	var dataName = event._currentTarget.getAttribute('dataname');

	Liferay.Util.getOpener().<portlet:namespace/>retrieveUser(dataId, dataName);
	//Liferay.Util.getOpener().<portlet:namespace/>changeSelect;
});

</aui:script>