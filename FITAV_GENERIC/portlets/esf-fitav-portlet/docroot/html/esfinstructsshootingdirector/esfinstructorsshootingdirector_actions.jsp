<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="it.ethica.esf.model.ESFInstructsShootingDirector"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFInstructsShootingDirector ishDr = ( ESFInstructsShootingDirector) row.getObject();
%>
<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
			<portlet:param name="ishDrId"
				value="<%= String.valueOf(ishDr.getEsfInstructsShootingDirectorId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "editinstructorsshootingdirector.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="view" url="<%=editURL.toString()%>" />

	
	<portlet:actionURL name="deleteESFISTRShdr" var="deleteURL">
			<portlet:param name="ishDrId"
				value="<%=String.valueOf(ishDr.getEsfInstructsShootingDirectorId())%>" />
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
</liferay-ui:icon-menu>