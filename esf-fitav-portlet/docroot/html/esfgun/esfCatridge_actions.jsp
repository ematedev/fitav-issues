<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFCatridge esfCatridge = (ESFCatridge)row.getObject(); 


String mvcPath1 = "";//ParamUtil.getString(request, "mvcPath");
String templatePath1="/html/esfgun/";

	mvcPath1="edit_esfCatridge.jsp";

%>

<liferay-ui:icon-menu>

<c:if test="<%= ESFGunPermission.containsCatridge(permissionChecker, esfCatridge.getEsfCatridgeId(), portletGroupId, ActionKeys.ESFGUN_UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="esfCatridgeId"
				value="<%=String.valueOf(esfCatridge.getEsfCatridgeId()) %>" />
			<portlet:param name="mvcPath"
										value='<%=templatePath1+mvcPath1 %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
		</portlet:renderURL>
		

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString() %>" />
</c:if>	
<c:if test="<%= ESFGunPermission.containsCatridge(permissionChecker, esfCatridge.getEsfCatridgeId(), portletGroupId, ActionKeys.ESFGUN_DELETE) %>">	
		<portlet:actionURL name="deleteESFCatridge" var="deleteURL">
			<portlet:param name="esfCatridgeId"
				value="<%= String.valueOf(esfCatridge.getEsfCatridgeId()) %>" />
				<portlet:param name="mvcPath"
										value='/html/esfgun/view.jsp'/>
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>
</c:if>
<c:if test="<%= ESFGunPermission.containsCatridge(permissionChecker, esfCatridge.getEsfCatridgeId(), portletGroupId, ActionKeys.ESFGUN_ASSIGN) %>">
		<portlet:renderURL var="AssignURL">
			<portlet:param name="esfGunId"
				value="<%=String.valueOf(esfCatridge.getEsfCatridgeId()) %>" />
			<portlet:param name="mvcPath"
										value='<%=templatePath1+"assignUser.jsp" %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="type" value='<%=String.valueOf(ESFKeys.ESFGunType.CATRIDGE)%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="assign_shooter"
			url="<%=AssignURL.toString() %>" />
</c:if>	
</liferay-ui:icon-menu>

