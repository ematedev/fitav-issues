<%@include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFOrganizationModel esfOrganizationModel = (ESFOrganizationModel)row.getObject();
ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationModel.getEsfOrganizationId());
%>

<div>
	<%
	long classNameId = ClassNameLocalServiceUtil.getClassNameId(ESFOrganization.class.getName());
	for(String type : ESFOrganizationTypeLocalServiceUtil.getOrganizationTypes(esfOrganization.getEsfOrganizationId())) { %>
	
	<div><%=type %></div>
	
	<% } %>
</div>