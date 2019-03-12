<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Contact nationalContact = (Contact)row.getObject();

ESFNational esfNational = ESFNationalLocalServiceUtil.getActiveESFNational(nationalContact.getClassPK());
%>

<liferay-ui:icon-menu>

		<portlet:actionURL name="deleteNational" var="deleteNationalURL">
			<portlet:param name="esfNationalId"
				value="<%= String.valueOf(esfNational.getEsfNationalId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteNationalURL.toString() %>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>