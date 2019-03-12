<%@ include file="/html/init.jsp" %>

<%
String tabs = ParamUtil.getString(request, "tabs1", "closed");

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("mvcPath", "/html/renewal/admin/renewed.jsp");
portletURL.setParameter("redirect", redirect);
portletURL.setParameter("tabs1", tabs);

// String tabNames = "opened,closed,pending";
String tabNames = "closed,pending";
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='renewed'
/>

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" param="tabs1">
<%-- 	<c:if test='<%=tabs.equals("opened")%>'> --%>
<%-- 		<%@ include file="/html/renewal/admin/tabs/opened.jsp"%>  --%>
<%-- 	</c:if> --%>
	<c:if test='<%=tabs.equals("closed")%>'>
		<%@ include file="/html/renewal/admin/tabs/closed.jsp"%>
	</c:if>
	<c:if test='<%=tabs.equals("pending")%>'>
		<%@ include file="/html/renewal/admin/tabs/pending.jsp"%>
	</c:if>
</liferay-ui:tabs>