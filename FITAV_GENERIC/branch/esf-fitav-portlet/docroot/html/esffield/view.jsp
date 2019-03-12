
<%@ include file="init.jsp"%>

<%
	//check if this organization exist AND is an association, otherwise just show an error message

	if (currentOrganizationId == 0 && currentESFOrganization == null &&
		!currentESFOrganization.isAssociation()) {
%>

<div class="alert alert-error">
	<liferay-ui:message
		key="place-this-portlet-inside-an-esforganization-site" />
</div>

<%
	}
	else {

		String tabs =
			ParamUtil.getString(request, "tabs1", "Attivi");

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setWindowState(WindowState.NORMAL);

		portletURL.setParameter("struts_action", templatePath +
			"view.jsp");
		portletURL.setParameter("tabs", tabs);

		String tabNames = "Attivi,Non Attivi,Ceduti";
%>

		<c:if test="<%= ESFFieldModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFFIELD_ADD) %>">	
			<aui:button-row cssClass="esffield-admin-buttons">
				<portlet:renderURL var="addESFFieldURL">
					<portlet:param name="esfOrganizationId"
						value="<%=String.valueOf(currentOrganizationId)%>" />
					<portlet:param name="redirect" value="<%=redirect%>" />
					<portlet:param name="mvcPath"
						value='<%=templatePath +
										"edit_esffield.jsp"%>' />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFFieldURL.toString() %>"
					value="add-esffield" />
			</aui:button-row>
		</c:if>
			
		<liferay-ui:tabs names="<%=tabNames%>"
			url="<%=portletURL.toString()%>">
			<c:if test='<%=tabs.equals("Attivi")%>'>
				<%@ include file="/html/esffield/tabs/enable.jsp"%>
			</c:if>

			<c:if test='<%=tabs.equals("Non Attivi")%>'>
				<%@ include file="/html/esffield/tabs/disable.jsp"%>
			</c:if>
			
			<c:if test='<%=tabs.equals("Ceduti")%>'>
				<%@ include file="/html/esffield/tabs/giveway.jsp"%>
			</c:if>
		</liferay-ui:tabs>

<%
	}
%>
