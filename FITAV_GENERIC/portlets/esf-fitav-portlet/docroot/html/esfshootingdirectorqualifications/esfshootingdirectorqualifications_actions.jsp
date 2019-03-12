<%@page import="it.ethica.esf.model.ESFShootingDirectorQualification"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFShootingDirectorQualification shDrq = ( ESFShootingDirectorQualification) row.getObject();
%>
<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
			<portlet:param name="shDrqId"
				value="<%= String.valueOf(shDrq.getEsfShootingDirectorQualificationId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "editshootingdirectorqualifications.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="view" url="<%=editURL.toString()%>" />

	
	<portlet:actionURL name="deleteESFShdrQ" var="deleteURL">
			<portlet:param name="shDrqId"
				value="<%=String.valueOf(shDrq.getEsfShootingDirectorQualificationId())%>" />
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
</liferay-ui:icon-menu>