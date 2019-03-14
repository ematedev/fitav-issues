<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFField esfField = (ESFField)row.getObject();

ESFEntityState stateGiveWay = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(
	ESFField.class.getName(), esfField.getEsfFieldId(), ESFKeys.ESFStateType.GIVEWAY);

ESFEntityState stateGiveDisable = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(
	ESFField.class.getName(), esfField.getEsfFieldId(), ESFKeys.ESFStateType.DISABLE);
%>

<liferay-ui:icon-menu>

	<c:if
		test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.ESFFIELD_UPDATE) && stateGiveWay == null%>">
	
		<portlet:renderURL var="editURL">
			<portlet:param name="esfFieldId"
				value="<%=String.valueOf(esfField.getEsfFieldId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esffield.jsp" %>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.ESFFIELD_GIVEWAY) && stateGiveWay == null 
					&& stateGiveDisable == null%>">
		<portlet:renderURL var="giveWayURL">
			<portlet:param name="esfFieldId" value="<%= String.valueOf(esfField.getEsfFieldId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "choose_organization.jsp" %>' />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="give-away-field" url="<%=giveWayURL.toString() %>" />
	</c:if>
	
	<c:if
		test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.ESFFIELD_UPDATE) && stateGiveWay != null 
					&& stateGiveDisable == null%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfFieldId"
				value="<%=String.valueOf(esfField.getEsfFieldId()) %>" />
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esffield.jsp" %>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />
	</c:if>		

	<c:if
		test="<%= ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.ESFFIELD_RETURN_GIVEWAY) && stateGiveWay != null %>">
		<portlet:actionURL name="returnESFField" var="returnURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfFieldId" value="<%= String.valueOf(esfField.getEsfFieldId()) %>" />
			<portlet:param name="esfOrganizationId" value="<%= String.valueOf(currentOrganizationId) %>" />
		</portlet:actionURL>
		
		<liferay-ui:icon image="edit" message="return-field" url="<%=returnURL.toString() %>" />
	</c:if>

</liferay-ui:icon-menu>