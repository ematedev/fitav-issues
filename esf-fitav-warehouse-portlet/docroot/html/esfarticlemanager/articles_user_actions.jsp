<%@page import="com.ethica.esf.model.ESFArticle_ESFUser"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFArticle_ESFUser esfArticleEsfUser = (ESFArticle_ESFUser)row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleEsfUser.getEsfArticleId()) %>" />
		<portlet:param name="esfUserId" value="<%= String.valueOf(esfArticleEsfUser.getEsfUserId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "assign_to_user.jsp" %>' />
		<portlet:param name="modifyMode" value="true" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteESFArticle_ESFUser" var="deleteURL">
		<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleEsfUser.getEsfArticleId()) %>" />
		<portlet:param name="esfUserId" value="<%= String.valueOf(esfArticleEsfUser.getEsfUserId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view_users.jsp" %>' />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>