<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>
<%
ResultRow row =
(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFAirport esfAirport = (ESFAirport) row.getObject();
%>
<liferay-ui:icon-menu>
	
		<portlet:actionURL var="cancURL" name="cancURL">
			<portlet:param name="esfAirportId"
				value="<%= String.valueOf(esfAirport.getEsfAirportId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="edit" message="delete" 
			url="<%=cancURL.toString()%>" />
</liferay-ui:icon-menu>