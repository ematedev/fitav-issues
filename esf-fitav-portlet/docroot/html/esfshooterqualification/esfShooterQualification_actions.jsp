<%@page import="it.ethica.esf.permission.ESFShooterQualificationPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFShooterQualification esfShooterQualification = (ESFShooterQualification) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfShooterQualificationId"
			value="<%= String.valueOf(esfShooterQualification.getEsfShooterQualificationId())%>" />
		<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfShooterQualification.jsp"%>' />
	</portlet:renderURL>

<c:if test="<%= ESFShooterQualificationPermission.contains(permissionChecker,esfShooterQualification.getEsfShooterQualificationId(), groupId, ActionKeys.ESFSHOOTERQUALIFICATION_UPDATE) %>">

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />

</c:if>

	<portlet:actionURL var="deleteESFShooterQualificationURL" name="deleteESFShooterQualification">
		<portlet:param name="esfShooterQualificationId"
			value="<%= String.valueOf(esfShooterQualification.getEsfShooterQualificationId())%>" />
	</portlet:actionURL>

<c:if test="<%= ESFShooterQualificationPermission.contains(permissionChecker, esfShooterQualification.getEsfShooterQualificationId(), groupId, ActionKeys.ESFSHOOTERQUALIFICATION_DELETE) %>">

	<liferay-ui:icon-delete url="<%= deleteESFShooterQualificationURL %>" confirmation="delete_confirm"/>
	
</c:if>	
</liferay-ui:icon-menu>