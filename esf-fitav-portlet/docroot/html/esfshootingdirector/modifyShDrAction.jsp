<%@page import="it.ethica.esf.model.VW_NomineDirettoriTiro"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

VW_NomineDirettoriTiro direttore = (VW_NomineDirettoriTiro)row.getObject();

long esfUserId = direttore.getUserId();

%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUserId)%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="view" url="<%=editURL.toString()%>" />
	
	<portlet:renderURL var="addSospensiveURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUserId)%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "newsospensive.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="add-suspensive" url="<%=addSospensiveURL.toString()%>" />
	
	<portlet:actionURL name="deleteESFShdr" var="deleteURL">
			<portlet:param name="shDrId"
				value="<%=String.valueOf(direttore.getIdDirettoreTiro())%>" />
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	
</liferay-ui:icon-menu>