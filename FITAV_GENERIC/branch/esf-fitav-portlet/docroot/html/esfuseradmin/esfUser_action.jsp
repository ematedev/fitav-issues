
<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFUser esfUser = (ESFUser) row.getObject();
	
	
	List<ESFCard> cards=ESFCardFinderUtil.findCardByUserState(ESFKeys.ESFStateType.ENABLE, esfUser.getEsfUserId());
	
%>

<liferay-ui:icon-menu>

<c:if test="<%= ESFUserAdminPermission.contains(permissionChecker, esfUser.getEsfUserId(),  ActionKeys.ESFUSERADMIN_VIEW) %>">	
		
	<portlet:renderURL var="editURL">
		<portlet:param name="esfUserId" value="<%=String.valueOf(esfUser.getEsfUserId())%>" />
		<portlet:param name="mvcPath"  value="/html/esfuseradmin/edit_esfUser.jsp" />
		<portlet:param name="op" value="updAddr" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="view"
		url="<%=editURL.toString()%>" />
</c:if>

<c:if test="<%= ESFUserAdminPermission.contains(permissionChecker, esfUser.getEsfUserId(),  ActionKeys.ESFUSERADMIN_ASSIGN_CARD) && Validator.isNotNull(cards)  && cards.size()>0 %>">	
	<portlet:renderURL var="cardURL">
		<portlet:param name="esfUserId" value="<%=String.valueOf(esfUser.getEsfUserId())%>" />
		<portlet:param name="organizationId" value="<%=String.valueOf(currentOrganizationId)%>" />
		<portlet:param name="mvcPath" value="/html/esfuseradmin/assigncard.jsp" />
		<portlet:param name="op" value="updAddr" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="get-card" url="<%=cardURL.toString()%>" />
</c:if>

</liferay-ui:icon-menu>