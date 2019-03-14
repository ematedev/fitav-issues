<%@page import="it.ethica.esf.permission.ESFMatchTypePermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFMatchType esfMatchtype = (ESFMatchType) row.getObject();
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="esfMatchTypeId"
			value="<%=String.valueOf(esfMatchtype.getEsfMatchTypeId())%>" />
		<portlet:param name="mvcPath"
			value='<%=templatePath + "edit_esfMatchType.jsp"%>' />
	</portlet:renderURL>

<c:if test="<%= ESFMatchTypePermission.contains(permissionChecker,esfMatchtype.getEsfMatchTypeId(), scopeGroupId, ActionKeys.ESFMATCHTYPE_UPDATE) %>">

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />
</c:if>

	<portlet:actionURL name="deleteESFMatchType" var="deleteURL">
		<portlet:param name="esfMatchTypeId"
			value="<%=String.valueOf(esfMatchtype.getEsfMatchTypeId())%>" />
	</portlet:actionURL>

<c:if test="<%= ESFMatchTypePermission.contains(permissionChecker,esfMatchtype.getEsfMatchTypeId(), scopeGroupId, ActionKeys.ESFMATCHTYPE_DELETE) %>">

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
</c:if>

</liferay-ui:icon-menu>