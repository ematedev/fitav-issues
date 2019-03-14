<%@page import="com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil"%>
<%@page import="com.ethica.esf.model.ESFArticle_ESFUser"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFArticle esfArticle = (ESFArticle)row.getObject();

String mvcPath1 ="edit_esfArticleType.jsp";
%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL">
			<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath+"edit_article.jsp" %>' />
			<portlet:param name="modifyMode" value="true" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />
		
		<portlet:renderURL var="selectUserURL">
			<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath+"select_user.jsp" %>' />
		</portlet:renderURL>
		<liferay-ui:icon image="assign" message="assign-to" url="<%= selectUserURL.toString() %>" />
		
		<%
		List<ESFArticle_ESFUser> esfArticleEsfUser = ESFArticle_ESFUserLocalServiceUtil.findByEsfArticleId(esfArticle.getEsfArticleId());
		if (esfArticleEsfUser.size() > 0) {
		%>
			<portlet:renderURL var="viewUsersURL">
				<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
				<portlet:param name="mvcPath" value='<%= templatePath + "view_users.jsp" %>' />
				<portlet:param name="redirect" value='<%= currentURL %>' />
			</portlet:renderURL>
			
			<liferay-ui:icon image="view" message="assigned-to" url="<%= viewUsersURL.toString() %>" />
		<%
		}
		%>

		<portlet:actionURL name="deleteESFArticle" var="deleteURL">
			<portlet:param name="esfArticleId"
				value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
				<portlet:param name="mvcPath"
										value='<%= templatePath+"view.jsp" %>'/>
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>