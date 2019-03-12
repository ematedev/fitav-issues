<%@page import="it.ethica.esf.permission.ESFUserAdminPermission"%>
<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	String esfFornitureId = ParamUtil.getString(request, "esfFornitureId");
	
	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFUser esfUser = (ESFUser) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=ESFUserAdminPermission.contains(
						permissionChecker, esfUser.getEsfUserId(),
						ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUser.getEsfUserId())%>" />
			<portlet:param name="esfFornitureId"
				value="<%= esfFornitureId %>" />
			
				
			<portlet:param name="mvcPath"
				value='<%=templatePath + "assignForniture.jsp"%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="choose" 
			url="<%=editURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>