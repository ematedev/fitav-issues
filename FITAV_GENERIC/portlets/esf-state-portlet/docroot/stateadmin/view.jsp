<%@include file="/stateadmin/init.jsp"%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/stateadmin/html/search_esfState.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:success key="addESFStateMess" message="message-add-state"/>
<c:if
	test='<%=ESFStateModelPermission.contains(
					permissionChecker, scopeGroupId, ESFStateActionKeys.ADD_ESFSTATE)%>'>
	<aui:button-row cssClass="esfstate-admin-buttons">
		<portlet:renderURL var="addESFStateURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
			<portlet:param name="mvcPath" value="/stateadmin/html/edit_esfState.jsp" />
		</portlet:renderURL>
	
		<aui:button onClick="<%= addESFStateURL.toString()%>" value="Add State" />
	</aui:button-row>
</c:if>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
			results="<%= ESFStateLocalServiceUtil.getESFStates(
							searchContainer.getStart(),
							searchContainer.getEnd()) %>"
			total="<%= ESFStateLocalServiceUtil.getESFStatesCount() %>" />
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFState" modelVar="esfState">

		<portlet:renderURL var="viewESFState">
			<portlet:param name="mvcPath"
				value="/stateadmin/html/view_esfState.jsp" />
			<portlet:param name="esfStateId"
				value="<%=String.valueOf(esfState.getEsfStateId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="esfName"
			href="<%=viewESFState%>" />

		<liferay-ui:search-container-column-text property="esfDescription"
			href="<%=viewESFState%>" />

		<liferay-ui:search-container-column-jsp
			path="/stateadmin/html/esfState_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>