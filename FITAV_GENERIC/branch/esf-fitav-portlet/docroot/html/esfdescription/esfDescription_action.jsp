<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFDescription esfDescription = (ESFDescription) row.getObject();
%>

<liferay-ui:icon-menu>


	<portlet:renderURL var="editURL">
		<portlet:param name="esfDescriptionId"
			value="<%=String.valueOf(esfDescription.getEsfDescriptionId())%>" />
		<portlet:param name="mvcPath"
			value='<%= templatePath +"edit_esfDescription.jsp" %>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit"
		url="<%=editURL.toString()%>" />

	<portlet:actionURL name="deleteESFDescrition" var="deleteURL">
		<portlet:param name="esfDescriptionId"
			value="<%=String.valueOf(esfDescription.getEsfDescriptionId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />

</liferay-ui:icon-menu>