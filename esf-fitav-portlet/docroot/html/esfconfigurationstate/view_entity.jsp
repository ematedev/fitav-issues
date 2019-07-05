<%@ include file="init.jsp"%>

<%
	String tabs = ParamUtil.getString(request, "tabs", "Assegnati");

	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setWindowState(WindowState.NORMAL);

	portletURL.setParameter("mvcPath", "/html/esfconfigurationstate/view_entity.jsp");
	portletURL.setParameter("esfStateId", String.valueOf(esfStateId));
	portletURL.setParameter("tabs", tabs);

	String tabNames = "Assegnati,Non Assegnati";
%>

<liferay-ui:error key="assigned-state-error" message="assigned-state-error" />

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" refresh="false" >
	<liferay-ui:section>
		<%@ include file="/html/esfconfigurationstate/tabs/assigned.jsp"%>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/html/esfconfigurationstate/tabs/noassigned.jsp"%>
	</liferay-ui:section>
</liferay-ui:tabs>