<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp" %>

<%
	ESFGunKind esfGunKind = null;

	long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
	long esfGunTypeId = 0;

	if (esfGunKindId > 0) {
		esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKind(esfGunKindId);
		esfGunTypeId = esfGunKind.getEsfGunTypeId();
	}
	else {
		esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
	}
%>

<portlet:resourceURL var="locationURL" id="view.jsp" escapeXml="false" />

<portlet:renderURL var="viewURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esfguncategorization/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFGunKind" var="editESFGunKindURL">
	<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
</portlet:actionURL>

<aui:form action="<%= editESFGunKindURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfGunKind %>" model="<%= ESFGunKind.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfGunKindId"
				value='<%= esfGunKind == null ? "" : esfGunKind.getEsfGunKindId() %>' />
			<aui:input name="name" />
			<aui:input name="description" type="textarea" />
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>
