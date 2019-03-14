<%@include file="init.jsp"%>

<%
	String mvcPath = "/html/esfnationaldelegation/edit_esfCatridge.jsp";
	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ESFCatridge esfCatridgeRow = (ESFCatridge) row.getObject();

%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="editESFCatridgeURL">
							<portlet:param name="mvcPath"
										value='<%= mvcPath %>' />
							<portlet:param name="esfCatridgeId"
										value="<%=String.valueOf(esfCatridgeRow.getEsfCatridgeId()) %>" />
							<portlet:param name="esfUserId"
										value="<%=String.valueOf(esfUserId) %>" />
							<portlet:param name="modifyMode" value="true"/>
							
						</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editESFCatridgeURL.toString() %>" />

		<portlet:actionURL name="deleteESFCatridge" var="deleteURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfCatridgeId"
				value="<%= String.valueOf(esfCatridgeRow.getEsfCatridgeId()) %>" />
				<portlet:param name="mvcPath"
										value='<%=mvcPath %>' />
				<portlet:param name="esfUserId"
										value="<%=String.valueOf(esfUserId) %>" />
				
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>