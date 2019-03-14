<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page import="it.ethica.esf.model.ESFCatridge"%>
<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
long esfCatridgeId = 0;
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFCatridge esfCatridge = (ESFCatridge)row.getObject(); 
esfCatridgeId = esfCatridge.getEsfCatridgeId();

%>

<liferay-ui:icon-menu>
<c:if test="<%= ESFGunPermission.containsCatridge(permissionChecker, esfCatridge.getEsfCatridgeId(), portletGroupId, ActionKeys.ESFGUN_UPDATE) %>">
		<portlet:renderURL var="editCatridgeURL">
			<portlet:param name="esfCatridgeId" value="<%=String.valueOf(esfCatridgeId) %>" />
			<portlet:param name="esfGunTypeId" value="<%=String.valueOf(esfGunTypeId) %>" />
			<portlet:param name="mvcPath" value="/html/esfguncategorization/edit_esfGunCatridge.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%= editCatridgeURL.toString() %>" />
</c:if>
<c:if test="<%= ESFGunPermission.containsCatridge(permissionChecker, esfCatridge.getEsfCatridgeId(), portletGroupId, ActionKeys.ESFGUN_DELETE) %>">

		<portlet:actionURL name="deleteESFGunCatridge" var="deleteCatridgeURL">
			<portlet:param name="esfCatridgeId" value="<%=String.valueOf(esfCatridgeId) %>" />
			<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteCatridgeURL.toString() %>" confirmation="delete_confirm"/>
</c:if>

</liferay-ui:icon-menu>