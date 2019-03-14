<%@include file="init.jsp"%>
<%
	long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
	String tabs = ParamUtil.getString(request, "tabs1", "Non Assegnati");

	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setWindowState(WindowState.NORMAL);

	portletURL.setParameter("esfOrganizationId", String.valueOf(esfOrganizationId));
	
	portletURL.setParameter("esfUserRoleId", String.valueOf(esfUserRoleId));
	
	if(tabs.equals("Assegnati")){
		portletURL.setParameter("type", "A");
	}else{
		portletURL.setParameter("type", "NA");
	}
	
	portletURL.setParameter(
		"mvcPath", "/html/esfuserrole/assignMembers_esfUserRole.jsp");
	
	portletURL.setParameter("tabs", tabs);

	String tabNames = "Non Assegnati,Assegnati";
%>

<liferay-ui:error key="assigned-cardsorgan-error"
	message="assigned-cardsorgan-error" />

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" >
	<c:if test='<%=tabs.equals("Assegnati")%>'>
		<%@include file="/html/esfuserrole/tabs/assigned.jsp"%> 
	</c:if>
	
	<c:if test='<%=tabs.equals("Non Assegnati")%>'>
		<%@include file="/html/esfuserrole/tabs/noassigned.jsp"%>
	</c:if>
</liferay-ui:tabs>