<%@ include file="init.jsp" %>

<liferay-portlet:renderURL var="addESFCategoryURL">
	<portlet:param name="mvcPath" value='/html/admin/esfcategory/edit.jsp' />
	<portlet:param name="redirect" value="<%= redirect %>" />
</liferay-portlet:renderURL>
<aui:button value="add" icon="add" iconAlign="left" onClick='<%= addESFCategoryURL %>' />
<liferay-ui:search-container
		curParam="category"
		total="<%= ESFCategoryLocalServiceUtil.getESFCategoriesCount() %>"
		emptyResultsMessage="no-category"
	>
	<liferay-ui:search-container-results results="<%= ESFCategoryLocalServiceUtil.getESFCategories(-1, -1) %>" />

	<liferay-ui:search-container-row 
		className="it.ethica.esf.model.ESFCategory"
		escapedModel="<%= true %>"
		keyProperty="esfCategoryId"
		modelVar="esfCategory"
	>

		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="mvcPath" value="/html/admin/esfcategory/edit.jsp" />
			<portlet:param name="esfCategory" value="<%= String.valueOf(esfCategory.getEsfCategoryId()) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="name"
			property="name"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="description"
			property="description"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/admin/esfcategory/action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>