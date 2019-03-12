<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFUser esfUser = (ESFUser)row.getObject();

String mvcPath1 ="edit_esfArticleType.jsp";
%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="assignURL">
			<portlet:param name="esfUserId" value="<%= String.valueOf(esfUser.getEsfUserId()) %>" />
			<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleId) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath+"assign_to_user.jsp" %>' />
		</portlet:renderURL>
		<liferay-ui:icon image="add" message="assign" url="<%= assignURL.toString() %>" />
</liferay-ui:icon-menu>