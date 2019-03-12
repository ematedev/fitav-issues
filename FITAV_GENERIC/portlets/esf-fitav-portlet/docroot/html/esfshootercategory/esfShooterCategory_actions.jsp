<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFShooterCategoryPermission"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFShooterCategory esfShooterCategory = (ESFShooterCategory) row.getObject();
%>

<liferay-ui:icon-menu>
<c:if test="<%= ESFShooterCategoryPermission.contains(permissionChecker,esfShooterCategory.getEsfShooterCategoryId(), ActionKeys.ESFSHOOTERCATEGORY_UPDATE) %>">			
	<portlet:renderURL var="editURL">
		<portlet:param name="esfShooterCategoryId"
			value="<%= String.valueOf(esfShooterCategory.getEsfShooterCategoryId())%>" />
		<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfShooterCategory.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />
</c:if>

<c:if test="<%= ESFShooterCategoryPermission.contains(permissionChecker,esfShooterCategory.getEsfShooterCategoryId(), ActionKeys.ESFSHOOTERCATEGORY_DELETE) %>">			
	<portlet:actionURL var="deleteESFShooterCategoryURL" name="deleteESFShooterCategory">
		<portlet:param name="esfShooterCategoryId"
			value="<%= String.valueOf(esfShooterCategory.getEsfShooterCategoryId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteESFShooterCategoryURL %>" confirmation="delete_confirm"/>
</c:if>
</liferay-ui:icon-menu>