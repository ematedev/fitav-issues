<%@ include file="init.jsp" %> 

<%
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
ESFArticle esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
ESFOrder esfOrder = ESFOrderLocalServiceUtil.getESFOrder(esfOrderId);
%>

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="esfOrderId" value="<%= Long.toString(esfOrderId) %>"/>
	<liferay-portlet:param name="mvcPath" value='<%= templatePath + "view_articles.jsp" %>'/>
</liferay-portlet:renderURL>

<liferay-ui:header backURL="<%= backURL %>" title='<%= LanguageUtil.format(pageContext, "order-x-article-y-bills", new Object[]{esfArticle.getName(), esfOrder.getName()}) %>' />

<aui:button-row cssClass="bill-admin-buttons">
	<portlet:renderURL var="addESFBillURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_bill.jsp" %>' />
		<portlet:param name="esfArticleId" value='<%= Long.toString(esfArticleId) %>' />
		<portlet:param name="esfOrderId" value='<%= Long.toString(esfOrderId) %>' />
		<portlet:param name="redirect" value='<%= currentURL %>' />
	</portlet:renderURL>
		
	<aui:button onClick="<%= addESFBillURL.toString() %>" value="add-esfbill" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">
 
	<liferay-ui:search-container-results results="<%= ESFBillLocalServiceUtil.findByEA_EO(esfArticleId, esfOrderId) %>"
										 total="<%= ESFBillLocalServiceUtil.findByEA_EO(esfArticleId, esfOrderId).size() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFBill" modelVar="esfBill">
		<liferay-ui:search-container-column-text name="orderName" value="<%= ESFOrderLocalServiceUtil.getESFOrder(esfBill.getEsfOrderId()).getName() %>" />
		<liferay-ui:search-container-column-text name="articleName" value="<%= ESFArticleLocalServiceUtil.getESFArticle(esfBill.getEsfArticleId()).getName() %>" />
		<liferay-ui:search-container-column-text name="billNumber" value="<%= esfBill.getBillNumber() %>" />
		<liferay-ui:search-container-column-text name="totalQty" value="<%= Long.toString(esfBill.getTotalQty()) %>" />
		<liferay-ui:search-container-column-jsp path='<%= templatePath + "bill_actions.jsp" %>' align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>