<%@page import="it.ethica.esf.permission.ESFShooterQualificationModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFShooterQualificationPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp" %>

<h3><liferay-ui:message key="shooter-qualification"></liferay-ui:message></h3>

<portlet:renderURL var="editURL">
	<portlet:param name="mvcPath"
			value='<%=templatePath + "edit_esfShooterQualification.jsp"%>' />
</portlet:renderURL>

<c:if test="<%= ESFShooterQualificationModelPermission.contains(permissionChecker, groupId, ActionKeys.ESFSHOOTERQUALIFICATION_ADD) %>">

<aui:button-row>
	<aui:button onClick="<%= editURL.toString() %>" value="add-shooter-qualification" />
</aui:button-row>

</c:if>

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%= ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications(searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%= ESFShooterQualificationLocalServiceUtil.getESFShooterQualificationsCount() %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFShooterQualification" modelVar="esfShooterQualification">
		<liferay-ui:search-container-column-text property="code" />
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text property="description" />
		
		<c:if test="<%= ESFShooterQualificationPermission.contains(permissionChecker,esfShooterQualification.getEsfShooterQualificationId(), groupId, ActionKeys.ESFSHOOTERQUALIFICATION_VIEW_ACTION) %>">
		
		<liferay-ui:search-container-column-jsp
				path='<%= templatePath + "esfShooterQualification_actions.jsp" %>'
				align="right" />

	</c:if>
	
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>