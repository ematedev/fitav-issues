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

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />

	<portlet:actionURL var="deleteESFShooterQualificationURL" name="deleteESFShooterQualification">
		<portlet:param name="esfShooterQualificationId"
			value="<%= String.valueOf(esfShooterQualification.getEsfShooterQualificationId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteESFShooterQualificationURL %>" />
</liferay-ui:icon-menu>