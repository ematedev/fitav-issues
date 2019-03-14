<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFOrganization esfOrganization = (ESFOrganization) row.getObject();

String namespace = renderResponse.getNamespace();
%>

<button id='<%= namespace + "sendAssociation" + esfOrganization.getEsfOrganizationId()%>'
	class="btn btn-small"
	value="<%= String.valueOf(esfOrganization.getEsfOrganizationId()) %>"
	dataid="<%= String.valueOf(esfOrganization.getEsfOrganizationId()) %>"
	dataname="<%= esfOrganization.getName() %>">
	
	<liferay-ui:icon image="add" message="add" />
</button>

<aui:script use="aui-base,node">

A.one('#<portlet:namespace/>sendAssociation<%=esfOrganization.getEsfOrganizationId()%>').on('click', function(event) {

	var dataId = event._currentTarget.getAttribute('dataid');
	var dataName = event._currentTarget.getAttribute('dataname');

	Liferay.Util.getOpener().<portlet:namespace/>retrieveAssociation(dataId, dataName);
	//Liferay.Util.getOpener().<portlet:namespace/>changeSelect;
});

</aui:script>