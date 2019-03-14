
<%@include file="init.jsp"%>

<%
	String mvcPath = "/html/esfnationalmatch/tabs/navigation/alter_esfCatridge.jsp";
	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFgunUser esfGunRow = (ESFgunUser) row.getObject();
	
%>

<liferay-ui:icon-menu>
		<portlet:actionURL name="deleteESFGun" var="deleteURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfGunId" value="<%= String.valueOf(esfGunRow.getEsfGunId()) %>" />
			<portlet:param name="mvcPath" 	value='<%=mvcPath %>' />
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>" />
			<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfGunRow.getEsfGunUserId()) %>" />
			<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>