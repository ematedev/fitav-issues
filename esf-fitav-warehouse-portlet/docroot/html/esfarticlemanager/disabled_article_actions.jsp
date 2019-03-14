<%@page import="com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil"%>
<%@page import="com.ethica.esf.model.ESFArticle_ESFUser"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFArticle esfArticle = (ESFArticle)row.getObject();
%>

<liferay-ui:icon-menu>

		<portlet:actionURL name="enableESFArticle" var="enableESFArticleURL">
			<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "disabled_articles.jsp" %>'/>
		</portlet:actionURL>
		<liferay-ui:icon image="action" label="enable" url="<%= enableESFArticleURL.toString() %>" />
</liferay-ui:icon-menu>