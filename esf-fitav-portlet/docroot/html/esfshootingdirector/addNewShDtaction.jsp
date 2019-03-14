<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfUser = (ESFUser) row.getObject();
long esfUserId = esfUser.getEsfUserId();
%>

	<portlet:renderURL var="editURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(esfUser.getEsfUserId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="view" url="<%=editURL.toString()%>" />

