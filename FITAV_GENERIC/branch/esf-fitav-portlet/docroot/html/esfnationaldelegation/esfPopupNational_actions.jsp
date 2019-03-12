<%@include file="init.jsp"%>

<%
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfUserRow = (ESFUser) row.getObject();

%>

<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserRow.getEsfUserId(), ActionKeys.ESFNATIONALDELEGATION_ADD) %>">	
	
<portlet:renderURL var="popupURL2" windowState="<%= LiferayWindowState.NORMAL.toString() %>" >
	<portlet:param name="mvcPath" value='<%=templatePath+ "esfPopupNational2.jsp"%>' />
	<portlet:param name="esfUser" value='<%= String.valueOf(esfUserRow.getEsfUserId()) %>' />
</portlet:renderURL>

<liferay-ui:icon image="submit" message="Transformation" url="<%=popupURL2.toString()%>" />

</c:if>
