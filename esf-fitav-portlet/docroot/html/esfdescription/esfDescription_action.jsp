<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFDescriptionPermission"%>
<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFDescription esfDescription = (ESFDescription) row.getObject();
%>

<liferay-ui:icon-menu>

<c:if test="<%= ESFDescriptionPermission.contains(permissionChecker, esfDescription.getEsfDescriptionId(), groupId,  ActionKeys.ESFDESCRIPTION_UPDATE) %>">
	<portlet:renderURL var="editURL">
		<portlet:param name="esfDescriptionId"
			value="<%=String.valueOf(esfDescription.getEsfDescriptionId())%>" />
		<portlet:param name="mvcPath"
			value='<%= templatePath +"edit_esfDescription.jsp" %>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />
</c:if>
<c:if test="<%= ESFDescriptionPermission.contains(permissionChecker, esfDescription.getEsfDescriptionId(), groupId,  ActionKeys.ESFDESCRIPTION_DELETE) %>">
	<portlet:actionURL name="deleteESFDescrition" var="deleteURL">
		<portlet:param name="esfDescriptionId"
			value="<%=String.valueOf(esfDescription.getEsfDescriptionId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
</c:if>
</liferay-ui:icon-menu>