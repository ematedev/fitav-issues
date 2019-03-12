<%@page import="it.ethica.esf.permission.ESFUserRoleModelPermission"%>
<%@include file="init.jsp"%>

<%

String tabs = ParamUtil.getString(request, "tabs1", "enabled");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter(
	"mvcPath", "/html/esfuserrole/view.jsp");
portletURL.setParameter("tabs", tabs);

String tabNames = "enabled,disabled";
%>



<liferay-ui:error key="userrole-state-error"
	message="userrole-state-error" />
<liferay-ui:error key="userrole-name-message"
	message="userrole-name-message" />
<liferay-ui:error key="userrole-maxuser-error"
	message="userrole-maxuser-error" />
	
	<aui:button-row cssClass="esfuserrole-admin-buttons">
		<portlet:renderURL var="addESFUserRoleURL">
			<portlet:param name="mvcPath"
				value="/html/esfuserrole/edit_esfUserRole.jsp" />
		</portlet:renderURL>
<c:if test="<%= ESFUserRoleModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFUSERROLE_ADD) %>">
		<aui:button onClick="<%= addESFUserRoleURL.toString() %>"
			value="add-role" />
</c:if>	
	</aui:button-row>

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" >
	<c:if test='<%=tabs.equals("enabled")%>'>
		<%@include file="/html/esfuserrole/tabs/enable.jsp"%> 
	</c:if>
	
	<c:if test='<%=tabs.equals("disabled")%>'>
		<%@include file="/html/esfuserrole/tabs/disable.jsp"%>
	</c:if>
</liferay-ui:tabs>