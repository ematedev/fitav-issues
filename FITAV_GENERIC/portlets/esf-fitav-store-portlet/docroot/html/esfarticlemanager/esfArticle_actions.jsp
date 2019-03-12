<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFArticleManagerPermission"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFArticle esfArticle = (ESFArticle)row.getObject();

String mvcPath1 ="edit_esfArticleType.jsp";
%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL">
			<portlet:param name="esfArticleId"
				value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
		<portlet:param name="mvcPath"
										value='<%= templatePath+"edit_esfArticle.jsp" %>' />
		<portlet:param name="modifyMode" value="true" />
		</portlet:renderURL>
<!--<c:if test="<%= ESFArticleManagerPermission.contains(permissionChecker,esfArticle.getEsfArticleId(), scopeGroupId, ActionKeys.ESFARTICLE_UPDATE)%>">-->
		<liferay-ui:icon image="edit" message="edit"
			url="<%= editURL.toString() %>" />
<!--</c:if>-->
		<portlet:renderURL var="assignURL">
			<portlet:param name="esfArticleId"
				value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
				<portlet:param name="mvcPath"
										value='<%= templatePath+"assign_esfArticle.jsp" %>'/>
		</portlet:renderURL>
<!--<c:if test="<%= ESFArticleManagerPermission.contains(permissionChecker,esfArticle.getEsfArticleId(), scopeGroupId, ActionKeys.ESFARTICLE_ASSIGN)%>">-->
		<liferay-ui:icon image="edit" message="assign"
		url="<%= assignURL.toString() %>" />
<!--</c:if>-->
		<portlet:actionURL name="deleteESFArticle" var="deleteURL">
			<portlet:param name="esfArticleId"
				value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
				<portlet:param name="mvcPath"
										value='<%= templatePath+"view.jsp" %>'/>
		</portlet:actionURL>
<!--<c:if test="<%= ESFArticleManagerPermission.contains(permissionChecker,esfArticle.getEsfArticleId(), scopeGroupId, ActionKeys.ESFARTICLE_REMOVE)%>">-->
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
<!--</c:if>-->
</liferay-ui:icon-menu>