<%@page import="it.ethica.esf.model.ESFSuspensiveShootingDirector"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>
<%

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFSuspensiveShootingDirector suspensive = ( ESFSuspensiveShootingDirector) row.getObject();
long esfUserId = suspensive.getEsfUserId();
long esfSuspensionId = suspensive.getEsfSuspensiveShooingDirectorId();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUserId)%>" />
			<portlet:param name="esfSuspensionId"
				value="<%= String.valueOf(esfSuspensionId)%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "newsospensive.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="view" url="<%=editURL.toString()%>" />
	
		<portlet:actionURL name="deleteSospensive" var="deleteURL">
			<portlet:param name="esfSuspensionId"
				value="<%=String.valueOf(esfSuspensionId)%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUserId)%>" />
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
</liferay-ui:icon-menu>