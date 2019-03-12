<%@ include file="init.jsp"%>
<%
	long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");

	String tabs = ParamUtil.getString(request, "tabs1", "Assegnati");

	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("esfOrganizationId", String.valueOf(esfOrganizationId));
	
	portletURL.setParameter("esfUserRoleId", String.valueOf(esfUserRoleId));
	
	if(tabs.equals("Assegnati")){
		portletURL.setParameter("type", "NA");
	}else{
		portletURL.setParameter("type", "A");
	}
	
	portletURL.setParameter(
		"mvcPath", templatePath+"assignMembers_esfUserRole.jsp");
	
	portletURL.setParameter("tabs", tabs);

	String tabNames = "Assegnati,Non Assegnati";
	
%>

<liferay-ui:error key="assigned-cardsorgan-error"
	message="assigned-cardsorgan-error" />

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>">
	<c:if test='<%=tabs.equals("Assegnati")%>'>
		<%@ include file="/html/esfbdoadmin/tabs/assigned.jsp"%> 
	</c:if>
	
	<c:if test='<%=tabs.equals("Non Assegnati")%>'>
		<%@ include file="/html/esfbdoadmin/tabs/noassigned.jsp"%>
	</c:if>
	


</liferay-ui:tabs>