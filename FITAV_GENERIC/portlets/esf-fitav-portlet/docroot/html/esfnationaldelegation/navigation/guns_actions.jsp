
<%@include file="init.jsp"%>

<%
	String mvcPath = "/html/esfnationaldelegation/navigation/alter_esfRifle.jsp";
	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFgunUser esfGunRow = (ESFgunUser) row.getObject();
	
%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editESFGunURL">
			<portlet:param name="mvcPath" value='<%=mvcPath %>' />
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunRow.getEsfGunId()) %>" />
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>" />
			<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfGunRow.getEsfGunUserId()) %>" />
			<portlet:param name="modifyMode" value="true"/>
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editESFGunURL.toString() %>" />


		<portlet:actionURL name="deleteESFGun" var="deleteURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfGunId" value="<%= String.valueOf(esfGunRow.getEsfGunId()) %>" />
			<portlet:param name="mvcPath" 	value='<%=mvcPath %>' />
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>" />
			<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfGunRow.getEsfGunUserId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
		
</liferay-ui:icon-menu>