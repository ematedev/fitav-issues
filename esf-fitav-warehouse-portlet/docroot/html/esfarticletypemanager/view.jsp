<%@ include file="init.jsp" %> 

<liferay-ui:header title='article-type' />

<aui:button-row cssClass="esfarticletype-admin-buttons">
	<portlet:renderURL var="addESFArticleTypeURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_article_type.jsp" %>' />
		<portlet:param name="redirect" value='<%= currentURL %>' />
	</portlet:renderURL>
		
	<aui:button onClick="<%= addESFArticleTypeURL.toString() %>" value="add-esfarticletype" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">
 
	<liferay-ui:search-container-results results="<%= ESFArticleTypeLocalServiceUtil.getESFArticleTypes(searchContainer.getStart(), searchContainer.getEnd()) %>"
										 total="<%= ESFArticleTypeLocalServiceUtil.getESFArticleTypesCount() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticleType" modelVar="esfArticleType">
		<liferay-ui:search-container-column-text name="description" value="<%= esfArticleType.getDescription() %>" />
		<liferay-ui:search-container-column-text name="area" value="<%= esfArticleType.getArea() %>" />
		<liferay-ui:search-container-column-text name="department" value="<%= esfArticleType.getDepartment() %>" />
		<liferay-ui:search-container-column-jsp path='<%= templatePath + "article_type_actions.jsp" %>' align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>