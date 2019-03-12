
<%@include file="init.jsp"%>

<liferay-ui:success key="user-success-insertupdate"
	message="user-success-insertupdate-mess" />
<liferay-ui:success key="user-success-insert"
	message="user-success-insert" />
<liferay-ui:success key="user-success-update"
	message="user-success-update" />


<liferay-ui:error key="user-email-message" message="user-email-mess" />
<liferay-ui:error key="user-birthday-message"
	message="user-birthday-message" />
<liferay-ui:error key="user-error-insert" message="user-error-insert" />
<liferay-ui:error key="user-error-update" message="user-error-update" />
<liferay-ui:error key="select-type-of-army"
	message="select-type-of-army" />

<%
	String tabs = ParamUtil.getString(request, "tabs1", "Abilitati");

	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setWindowState(WindowState.NORMAL);

	portletURL.setParameter("mvcPath", "/html/esfuseradmin/view.jsp");
	portletURL.setParameter("tabs", tabs);

	String tabNames = "Abilitati,Disabilitati";
%>


<c:if
	test="<%=ESFUserAdminModelPermission.contains(permissionChecker, scopeGroupId,
						ActionKeys.ESFUSERADMIN_ADD)%>">

	<aui:button-row cssClass="esfuser-admin-buttons">

		<portlet:renderURL var="addESFUserURL">
			<portlet:param name="mvcPath"
				value="/html/esfuseradmin/edit_esfUser.jsp" />
			<portlet:param name="op" value="addAddr" />
		</portlet:renderURL>
		<aui:button onClick="<%= addESFUserURL.toString() %>" value="add-user" />

	</aui:button-row>

</c:if>

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>">

	<c:if test='<%=tabs.equals("Abilitati")%>'>
		<%@include file="/html/esfuseradmin/tabs/enable.jsp"%>
	</c:if>

	<c:if test='<%=tabs.equals("Disabilitati")%>'>
		<%@include file="/html/esfuseradmin/tabs/disable.jsp"%>
	</c:if>

</liferay-ui:tabs>