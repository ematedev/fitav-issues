<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFArticleTypeManagerPermission"%>
<%@ include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFArticleType esfArticleType = (ESFArticleType)row.getObject();

String mvcPath1 ="edit_esfArticleType.jsp";
%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editURL">
			<portlet:param name="esfArticleTypeId"
				value="<%= String.valueOf(esfArticleType.getEsfArticleTypeId()) %>" />
			<portlet:param name="mvcPath"
										value='<%= templatePath+mvcPath1 %>' />
	<portlet:param name="modifyMode" value="true" />
		</portlet:renderURL>
<c:if test="<%=ESFArticleTypeManagerPermission.contains(permissionChecker,esfArticleType.getEsfArticleTypeId(), scopeGroupId, ActionKeys.ESFARTICOLTYPE_UPDATE)%>">	
		<liferay-ui:icon image="edit" message="edit"
			url="<%= editURL.toString() %>" />
</c:if>

		<portlet:actionURL name="deleteESFArticleType" var="deleteURL">
			<portlet:param name="esfArticleTypeId"
				value="<%= String.valueOf(esfArticleType.getEsfArticleTypeId()) %>" />
				<portlet:param name="mvcPath"
										value='<%= templatePath+"view.jsp" %>'/>
		</portlet:actionURL>
<c:if test="<%=ESFArticleTypeManagerPermission.contains(permissionChecker, esfArticleType.getEsfArticleTypeId() , scopeGroupId , ActionKeys.ESFARTICOLTYPE_REMOVE)%>">	
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</c:if>
</liferay-ui:icon-menu>