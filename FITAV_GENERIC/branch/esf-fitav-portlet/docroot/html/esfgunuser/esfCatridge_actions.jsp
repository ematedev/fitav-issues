
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFgunUser esfgunUser = (ESFgunUser)row.getObject(); 


String mvcPath1 = "";//ParamUtil.getString(request, "mvcPath");
String templatePath1="/html/esfgunuser/";

	mvcPath1="edit_esfCatridge.jsp";

long esfUserId=esfgunUser.getEsfUserId();
%>

<liferay-ui:icon-menu>

	
		
		<portlet:actionURL name="deleteESFCatridge" var="deleteURL">
			<portlet:param name="esfCatridgeId" value="<%= String.valueOf(esfgunUser.getEsfGunId()) %>" />
			<portlet:param name="esfgunUserId" value="<%= String.valueOf(esfgunUser.getEsfGunUserId()) %>" />
			<portlet:param name="mvcPath" value='/html/esfgunuser/view.jsp'/>
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	
</liferay-ui:icon-menu>