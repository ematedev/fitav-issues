<%@ include file="init.jsp" %>

<liferay-ui:header title='articles-in-stock' />

<liferay-ui:error key="qty-error" message="wrong-quantities" />

<aui:button-row cssClass="esfarticle-admin-buttons">
	<portlet:renderURL var="addESFArticleURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_article.jsp" %>' />
	</portlet:renderURL>
	<aui:button onClick="<%= addESFArticleURL.toString() %>" value="add-esfarticle" />
</aui:button-row>

<liferay-portlet:renderURL var="disabledArticlesURL">
	<liferay-portlet:param name="mvcPath" value='<%= templatePath + "disabled_articles.jsp" %>'/>
</liferay-portlet:renderURL>

<aui:button onClick="<%= disabledArticlesURL.toString() %>" value="disabled-articles" />

<liferay-ui:search-container emptyResultsMessage="no-results">

	<liferay-ui:search-container-results results="<%= ESFArticleLocalServiceUtil.getEnabledESFArticles(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFArticleLocalServiceUtil.getEnabledESFArticles().size() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticle" modelVar="esfArticle">
		<liferay-ui:search-container-column-text name="code" value="<%= esfArticle.getCode() %>" />
		<liferay-ui:search-container-column-text name="name" value="<%= esfArticle.getName() %>" />
		<liferay-ui:search-container-column-text name="description" value="<%= esfArticle.getDescription() %>" />
		<liferay-ui:search-container-column-text name="type" value="<%= ESFArticleTypeLocalServiceUtil.getESFArticleType((esfArticle.getEsfArticleTypeId())).getDescription() %>" />
		<liferay-ui:search-container-column-text name="totalQty" value="<%= Long.toString(esfArticle.getTotalQty()) %>" />

		<liferay-ui:search-container-column-jsp path='<%= templatePath + "article_actions.jsp" %>' align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>