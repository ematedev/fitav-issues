
<%@include file="init.jsp"%>

<%
	if (currentOrganizationId == 0) {
%>

		<div class="alert alert-error">
			<liferay-ui:message
				key="place-this-portlet-inside-an-esforganization-site">
			</liferay-ui:message>
		</div>

<%
	} else {

		String tabs = ParamUtil.getString(request, "tabs1", "Abilitati");

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setWindowState(WindowState.NORMAL);

		portletURL.setParameter("struts_action", "/html/esforganizationadmin/view.jsp");
		portletURL.setParameter("tabs", tabs);

		String tabNames = "Abilitati,Disabilitati";

%>

		<liferay-ui:success key="esfOrganizationUpdated" message="organization-updated" />
		<liferay-ui:success key="esfOrganizationAdded" message="organization-added" />
		<liferay-ui:error key="name-null-message" message="name-null-message" />
		<liferay-ui:error key="code-null-message" message="code-null-messagee" />

		<c:if test='<%= ESFOrganizationModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFORGANIZATIONADMIN_ADD) %>'>
		
			<aui:button-row cssClass="esforganization-admin-buttons">
			
				<portlet:renderURL var="addESFOrganizationRegionURL">
					<portlet:param name="op" value='addAddr' />
					<portlet:param name="mvcPath" value='<%=templatePath + "edit_esforganization.jsp"%>' />
				</portlet:renderURL>
			
				<%
					int typeLabelIndex = currentType < ESFKeys.ESFOrganizationTypeLabel.length ? currentType + 1
									: ESFKeys.ESFOrganizationTypeLabel.length;
				%>
			
				<aui:button onClick="<%= addESFOrganizationRegionURL.toString() %>"
					value='<%="insert-" + ESFKeys.ESFOrganizationTypeLabel[typeLabelIndex]%>' />
			
			</aui:button-row>
	
		</c:if>


		<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>">
			<c:if test='<%=tabs.equals("Abilitati")%>'>
				<%@include file="/html/esforganizationadmin/tabs/enable.jsp"%>
			</c:if>

			<c:if test='<%=tabs.equals("Disabilitati")%>'>
				<%@include file="/html/esforganizationadmin/tabs/disable.jsp"%>
			</c:if>
		</liferay-ui:tabs>

<%
	}
%>