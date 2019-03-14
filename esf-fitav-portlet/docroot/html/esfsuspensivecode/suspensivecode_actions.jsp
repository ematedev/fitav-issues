<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveCode"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFSuspensiveCode suCode = ( ESFSuspensiveCode) row.getObject();
%>
<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
			<portlet:param name="suCodeId"
				value="<%= String.valueOf(suCode.getEsfSuspensiveCodeId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "suspensivecode_edit.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="view" url="<%=editURL.toString()%>" />

	
	<portlet:actionURL name="deleteSuspensiveCode" var="deleteURL">
			<portlet:param name="suCodeId"
				value="<%=String.valueOf(suCode.getEsfSuspensiveCodeId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "view.jsp"%>' />
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
</liferay-ui:icon-menu>