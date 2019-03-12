<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFArticleType esfArticleType = (ESFArticleType)row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfArticleTypeId" value="<%= String.valueOf(esfArticleType.getEsfArticleTypeId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_article_type.jsp" %>' />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="modifyMode" value="true" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteESFArticleType" var="deleteURL">
		<portlet:param name="esfArticleTypeId" value="<%= String.valueOf(esfArticleType.getEsfArticleTypeId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>