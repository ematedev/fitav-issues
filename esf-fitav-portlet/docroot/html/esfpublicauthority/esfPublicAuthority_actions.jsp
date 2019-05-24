<%@ include file="init.jsp"%>

<%
// String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
boolean isRowNull = row==null;
ESFPublicAuthority esfPublicAuthority = (ESFPublicAuthority) row.getObject();
boolean isDocumentNull = esfPublicAuthority == null;
String entityID = String.valueOf(esfPublicAuthority.getEsfPublicAuthorityId());
%>

<portlet:renderURL var="editESFPublicAuthorityURL">
	<portlet:param name="mvcPath" value="/html/esfpublicauthority/edit_esfPublicAuthority.jsp" />
	<portlet:param name="esfPublicAuthorityId" value="<%=entityID%>"/>	
</portlet:renderURL>

<portlet:actionURL name="deleteESFPublicAuthority" var="deleteESFPublicAuthorityURL">
	<portlet:param name="esfPublicAuthorityId" value="<%=entityID%>" />         
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="edit" url="${editESFPublicAuthorityURL}" />
	<liferay-ui:icon-delete image="delete" message="delete" url="${deleteESFPublicAuthorityURL}" />
</liferay-ui:icon-menu>