<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<liferay-ui:error key="qty-error" message="wrong-quantities" />
<%
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
ESFArticle esfArticle = null;
if (Validator.isNotNull(esfArticleId)) {
	esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
}
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>

<liferay-ui:header backURL="<%= viewURL %>" title='<%= LanguageUtil.format(pageContext, "article-x-assigned-to", new Object[]{esfArticle.getName()}) %>' />

<aui:button-row cssClass="users-article-admin-buttons">
	<portlet:renderURL var="addESFArticleESFUserURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "select_user.jsp" %>' />
		<portlet:param name="esfArticleId" value='<%= Long.toString(esfArticleId) %>' />
	</portlet:renderURL>
		
	<aui:button onClick="<%= addESFArticleESFUserURL.toString() %>" value="add-esfarticle-esfuser" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">
 
	<liferay-ui:search-container-results results="<%= ESFArticle_ESFUserLocalServiceUtil.findByEsfArticleId(esfArticleId) %>"
										 total="<%= ESFArticle_ESFUserLocalServiceUtil.findByEsfArticleId(esfArticleId).size() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticle_ESFUser" modelVar="esfArticleEsfUser">
		<liferay-ui:search-container-column-text name="firstName" value="<%= ESFUserLocalServiceUtil.getESFUser(esfArticleEsfUser.getEsfUserId()).getFirstName() %>" />
		<liferay-ui:search-container-column-text name="lastName" value="<%= ESFUserLocalServiceUtil.getESFUser(esfArticleEsfUser.getEsfUserId()).getLastName() %>" />
		<%
		
			ESFCard userCard= null;
			String userCardCode ="";
			List<ESFCard> cardstest = new ArrayList<ESFCard>();
			
			try{
				cardstest = ESFCardLocalServiceUtil.findActualUserCards(ESFUserLocalServiceUtil.getESFUser(esfArticleEsfUser.getEsfUserId()).getEsfUserId());
				
				if(Validator.isNotNull(cardstest) && 0 < cardstest.size()){
					userCardCode = cardstest.get(0).getCode();
				}
				
			}
			catch(Exception e){
				
			}
		%>

		<liferay-ui:search-container-column-text value="<%=userCardCode %>" name="card" />
		<liferay-ui:search-container-column-text name="description" value="<%= esfArticleEsfUser.getDescription() %>" />
		<liferay-ui:search-container-column-text name="deliveryDate" value="<%= sdf.format(esfArticleEsfUser.getDeliveryDate()) %>" />
		<liferay-ui:search-container-column-text name="totalQty" value="<%= Long.toString(esfArticleEsfUser.getTotalQty()) %>" />
		
		<liferay-ui:search-container-column-jsp path='<%= templatePath + "articles_user_actions.jsp" %>' align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>