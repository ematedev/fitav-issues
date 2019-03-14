<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

iteratorURL.setParameter("mvcPath", templatePath + "/select_user.jsp");
iteratorURL.setParameter("esfArticleId", Long.toString(esfArticleId));
%>

<liferay-ui:header backURL="<%= viewURL %>" title="select-user-to-assign" />

<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%= iteratorURL %>">

	<liferay-ui:search-container-results results="<%= ESFUserLocalServiceUtil.getESFUsers(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFUserLocalServiceUtil.getESFUsersCount() %>" />

	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
		<liferay-ui:search-container-column-text name="firstName" />

		<liferay-ui:search-container-column-jsp path='<%= templatePath + "user_actions.jsp" %>' align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>