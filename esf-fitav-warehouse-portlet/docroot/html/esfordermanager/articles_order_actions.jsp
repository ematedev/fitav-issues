<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFArticle_ESFOrder esfArticleEsfOrder = (ESFArticle_ESFOrder)row.getObject();

%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfOrderId()) %>" />
		<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfArticleId()) %>" />
		<portlet:param name="mode" value="update" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_order_article.jsp" %>' />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />
	
	<portlet:renderURL var="addBillURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfOrderId()) %>" />
		<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfArticleId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_bill.jsp" %>' />
		<portlet:param name="redirect" value='<%= currentURL %>' />
	</portlet:renderURL>
	<liferay-ui:icon image="add" message="add-bill" url="<%= addBillURL.toString() %>" />
	
	<%
	List<ESFBill> esfBills = ESFBillLocalServiceUtil.findByEA_EO(esfArticleEsfOrder.getEsfArticleId(), esfArticleEsfOrder.getEsfOrderId());
	if (esfBills.size() > 0) {
	%>
		<portlet:renderURL var="viewArticlesURL">
			<portlet:param name="esfOrderId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfOrderId()) %>" />
			<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfArticleId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "view_bills.jsp" %>' />
			<portlet:param name="redirect" value='<%= currentURL %>' />
		</portlet:renderURL>
		
		<liferay-ui:icon image="view" message="view-bills" url="<%= viewArticlesURL.toString() %>" />
	<%
	}
	%>
	
	<portlet:actionURL name="deleteESFArticleESFOrder" var="deleteURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfOrderId()) %>" />
		<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleEsfOrder.getEsfArticleId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view_articles.jsp" %>'/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
	
</liferay-ui:icon-menu>