<%@page import="it.ethica.esf.model.VM_TiratoriTesserati"%>
<%@page import="it.ethica.esf.model.VW_NomineDirettoriTiro"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

VW_NomineDirettoriTiro vw_shDr = null;
ESFShootingDirector director = null; 

String tableType = (String) row.getParameter("tableType"); 
boolean isView = "view".equals(tableType); 
long esfShootingDirectorId = 0;
long esfUserId = 0;

if(isView){
	vw_shDr = ( VW_NomineDirettoriTiro ) row.getObject();
	esfShootingDirectorId = vw_shDr.getIdDirettoreTiro();
	esfUserId = vw_shDr.getUserId();
} else{
	director = (ESFShootingDirector) row.getObject();
	esfShootingDirectorId = director.getEsfShootingDirectorId();
	esfUserId = director.getEsfUserId();
}

%>

<portlet:renderURL var="viewURL">
	<portlet:param name="esfUserId"
		value="<%= String.valueOf(esfUserId)%>" />
	<portlet:param name="mvcPath"
		value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
</portlet:renderURL>
<portlet:renderURL var="editURL">										
	<portlet:param name="esfUserId"									
			value="<%= String.valueOf(esfUserId)%>" />
	<portlet:param name="esfShootingDirectorId"
			value="<%= String.valueOf(esfShootingDirectorId) %>" />
	<portlet:param name="mvcPath"
			value='<%=templatePath + "edit_shootingDirectorInfo.jsp"%>' />
	<portlet:param name="tableType" value="<%=tableType%>"/>
</portlet:renderURL>
<portlet:renderURL var="addSospensiveURL">
	<portlet:param name="esfUserId"
		value="<%= String.valueOf(esfUserId)%>" />
	<portlet:param name="mvcPath"
		value='<%=templatePath + "newsospensive.jsp"%>' />
</portlet:renderURL>
<portlet:actionURL name="deleteESFShdr" var="deleteURL">
	<portlet:param name="shDrId"
		value="<%=String.valueOf(esfShootingDirectorId)%>" />
</portlet:actionURL>

<liferay-ui:icon-menu>
	<%if(isView){ %>
	<liferay-ui:icon image="edit" message="view" url="<%=viewURL.toString()%>" />
	<liferay-ui:icon image="edit" message="add-suspensive" url="<%=addSospensiveURL.toString()%>" />
	<%} %>
	<liferay-ui:icon image="calendar" message="edit" url="<%=editURL.toString()%>" />
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
</liferay-ui:icon-menu>