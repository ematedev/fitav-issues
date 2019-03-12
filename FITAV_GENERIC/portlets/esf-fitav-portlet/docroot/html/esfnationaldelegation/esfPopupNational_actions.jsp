<%@page import="it.ethica.esf.model.ESFNationalDelegationModel"%>
<%@include file="init.jsp"%>

<%
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfUserRow = (ESFUser) row.getObject();
String stId = ParamUtil.getString(request, "stId");
%>

<c:if test="<%= ESFNationalDelegationModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFNATIONALDELEGATION_ADD) %>">	
	
<portlet:renderURL var="popupURL2" windowState="<%= LiferayWindowState.NORMAL.toString() %>" >
	<portlet:param name="mvcPath" value='<%=templatePath+ "esfPopupNational2.jsp"%>' />
	<portlet:param name="esfUser" value='<%= String.valueOf(esfUserRow.getEsfUserId()) %>' />
	<portlet:param name="stId" value='<%= stId %>' />
</portlet:renderURL>

<liferay-ui:icon image="submit" message="Transformation" url="<%=popupURL2.toString()%>" />

</c:if>
