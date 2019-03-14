<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFOrder esfOrder = (ESFOrder)row.getObject();

%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
		<portlet:param name="modifyMode" value="true" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_order.jsp" %>' />
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />
	
	<%
	List<ESFArticle> articles = ESFOrderLocalServiceUtil.getAvailableArticles(esfOrder.getEsfOrderId());
	if (articles.size() > 0) {
	%>
		<portlet:renderURL var="addArticleURL">
			<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_order_article.jsp" %>' />
		</portlet:renderURL>
		
		<liferay-ui:icon image="add" message="add-article" url="<%= addArticleURL.toString() %>" />
	<%
	}
	%>
	
	<%
	List<ESFArticle_ESFOrder> esfArticleEsfOrders = ESFArticle_ESFOrderLocalServiceUtil.findByEsfOrderId(esfOrder.getEsfOrderId());
	if (esfArticleEsfOrders.size() > 0) {
	%>
		<portlet:renderURL var="viewArticlesURL">
			<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "view_articles.jsp" %>' />
		</portlet:renderURL>
		
		<liferay-ui:icon image="view" message="view-articles" url="<%= viewArticlesURL.toString() %>" />
	<%
	}
	%>

	<portlet:actionURL name="deleteESFOrder" var="deleteURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>'/>
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
	
	
</liferay-ui:icon-menu>