<%@ include file="init.jsp" %>

<%
long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
List<ESFArticle_ESFOrder> esfArticleEsfOrders = ESFArticle_ESFOrderLocalServiceUtil.findByEsfOrderId(esfOrderId);
ESFOrder esfOrder = ESFOrderLocalServiceUtil.getESFOrder(esfOrderId);
%>

<liferay-ui:header backURL="<%= viewURL %>" title='<%= LanguageUtil.format(pageContext, "order-x-articles", new Object[]{esfOrder.getName()}) %>' />

<%
List<ESFArticle> articles = ESFOrderLocalServiceUtil.getAvailableArticles(esfOrderId);
if (articles.size() > 0) {
%>
	<portlet:renderURL var="addArticleURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_order_article.jsp" %>' />
	</portlet:renderURL>
	
	<aui:button onClick="<%= addArticleURL.toString() %>" value="associate-article" />
<%
}
%>

<liferay-ui:search-container emptyResultsMessage="no-results">

	<liferay-ui:search-container-results results="<%= esfArticleEsfOrders %>" total="<%= esfArticleEsfOrders.size() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticle_ESFOrder" modelVar="esfArticleEsfOrder">
		<liferay-ui:search-container-column-text name="articleCode" value="<%= ESFArticleLocalServiceUtil.getESFArticle(esfArticleEsfOrder.getEsfArticleId()).getCode() %>" />
		<liferay-ui:search-container-column-text name="articleName" value="<%= ESFArticleLocalServiceUtil.getESFArticle(esfArticleEsfOrder.getEsfArticleId()).getName() %>" />
		<liferay-ui:search-container-column-text name="totalQty" value="<%= Long.toString(esfArticleEsfOrder.getTotalQty()) %>" />

		<liferay-ui:search-container-column-jsp
				path='<%= templatePath + "articles_order_actions.jsp" %>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
