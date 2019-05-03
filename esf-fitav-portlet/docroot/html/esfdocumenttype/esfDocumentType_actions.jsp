<%@ include file="init.jsp"%>

<%
// String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
boolean isRowNull = row==null;
ESFDocumentType esfDocumentType = (ESFDocumentType) row.getObject();
boolean isDocumentNull = esfDocumentType == null;
String documentID = String.valueOf(esfDocumentType.getEsfDocumentTypeId());
%>

<portlet:renderURL var="editESFDocumentTypeURL">
	<portlet:param name="mvcPath" value="/html/esfdocumenttype/edit_esfDocumentType.jsp" />
	<portlet:param name="esfDocumentTypeId" value="<%=documentID%>"/>	
</portlet:renderURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="edit" url="${editESFDocumentTypeURL}" />
</liferay-ui:icon-menu>