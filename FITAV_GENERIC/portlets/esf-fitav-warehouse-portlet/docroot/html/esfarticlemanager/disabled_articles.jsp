<%@ include file="init.jsp" %>

<liferay-ui:header backURL="<%= viewURL %>" title='disabled-articles' />

<liferay-ui:search-container emptyResultsMessage="no-results">

	<liferay-ui:search-container-results results="<%= ESFArticleLocalServiceUtil.getDisabledESFArticles(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFArticleLocalServiceUtil.getDisabledESFArticles().size() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticle" modelVar="esfArticle">
		<liferay-ui:search-container-column-text name="code" value="<%= esfArticle.getCode() %>" />
		<liferay-ui:search-container-column-text name="name" value="<%= esfArticle.getName() %>" />
		<liferay-ui:search-container-column-text name="description" value="<%= esfArticle.getDescription() %>" />
		<liferay-ui:search-container-column-text name="type" value="<%= ESFArticleTypeLocalServiceUtil.getESFArticleType((esfArticle.getEsfArticleTypeId())).getDescription() %>" />
		<liferay-ui:search-container-column-text name="totalQty" value="<%= Long.toString(esfArticle.getTotalQty()) %>" />

		<liferay-ui:search-container-column-jsp path='<%= templatePath + "disabled_article_actions.jsp" %>' align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>