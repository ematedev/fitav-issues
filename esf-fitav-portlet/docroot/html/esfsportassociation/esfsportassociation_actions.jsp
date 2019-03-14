<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFOrganizationModel esfOrganizationModel = (ESFOrganizationModel) row.getObject();

	Group esfOrganizationGroup = GroupLocalServiceUtil.getOrganizationGroup(themeDisplay.getCompanyId(), esfOrganizationModel.getEsfOrganizationId());
%>

<liferay-ui:icon image="submit" message="view" url="<%=esfOrganizationGroup.getPathFriendlyURL(true, themeDisplay) + esfOrganizationGroup.getFriendlyURL()%>" />


