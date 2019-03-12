<%@page import="it.ethica.esf.permission.ESFShooterCategoryPermission"%>
<%@page import="it.ethica.esf.permission.ESFShooterPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFShooterCategoryModelPermission"%>
<%@ include file="init.jsp" %>

<portlet:renderURL var="editURL">
	<portlet:param name="mvcPath"
			value='<%=templatePath + "edit_esfShooterCategory.jsp"%>' />
</portlet:renderURL>

<c:if test="<%= ESFShooterCategoryModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFSHOOTERCATEGORY_ADD) %>">	
<aui:button-row>
	<aui:button onClick="<%= editURL.toString() %>" value="add-shooter-category" />
</aui:button-row>
</c:if>

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%= ESFShooterCategoryLocalServiceUtil.getESFShooterCategories(
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFShooterCategoryLocalServiceUtil.getESFShooterCategoriesCount() %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFShooterCategory" modelVar="esfShooterCategory">
		
		<liferay-ui:search-container-column-text property="code" />
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text property="description" />
		
<c:if test="<%= ESFShooterCategoryPermission.contains(permissionChecker,esfShooterCategory.getEsfShooterCategoryId(), ActionKeys.ESFSHOOTERCATEGORY_ACTION_VIEW) %>">
		<liferay-ui:search-container-column-jsp
				path='<%= templatePath + "esfShooterCategory_actions.jsp" %>'
				align="right" />
</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>