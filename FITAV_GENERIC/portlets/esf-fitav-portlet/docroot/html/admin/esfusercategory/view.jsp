<%@ include file="init.jsp" %>

<liferay-portlet:renderURL var="addESFUserCategoryURL">
	<portlet:param name="mvcPath" value='/html/admin/esfusercategory/edit.jsp' />
	<portlet:param name="redirect" value="<%= redirect %>" />
</liferay-portlet:renderURL>
<aui:button value="add" icon="add" iconAlign="left" onClick='<%= addESFUserCategoryURL %>' />

<liferay-ui:search-container
		total="<%= ESFUserCategoryLocalServiceUtil.getESFUserCategoriesCount() %>"
		emptyResultsMessage="no-esf-user-category"
	>
	<liferay-ui:search-container-results results="<%= ESFUserCategoryLocalServiceUtil.getESFUserCategories(-1, -1) %>" />

	<liferay-ui:search-container-row 
		className="it.ethica.esf.model.ESFUserCategory"
		escapedModel="<%= true %>"
		keyProperty="esfUserCategoryId"
		modelVar="userCategory"
	>

		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="mvcPath" value="/html/admin/esfusercategory/edit.jsp" />
			<portlet:param name="esfUserCategoryId" value="<%= String.valueOf(userCategory.getEsfUserCategoryId()) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="screen-name"
			value="<%= Validator.isNotNull(userCategory.getEsfUserId())?UserLocalServiceUtil.getUser(userCategory.getEsfUserId()).getScreenName():StringPool.MINUS %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="category"
			value="<%= Validator.isNotNull(userCategory.getEsfCategoryId())?ESFCategoryLocalServiceUtil.getESFCategory(userCategory.getEsfCategoryId()).getName():StringPool.MINUS %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="sport-type"
			value="<%= Validator.isNotNull(userCategory.getEsfSportTypeId())?ESFSportTypeLocalServiceUtil.getESFSportType(userCategory.getEsfSportTypeId()).getName():StringPool.MINUS %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/admin/esfusercategory/action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>