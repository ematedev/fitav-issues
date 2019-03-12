<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp" %>

<%
	ESFGunType esfGunType = null;

	long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");

	if (esfGunTypeId > 0) {
		esfGunType = ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);
	}
%>

<portlet:resourceURL var="locationURL" id="view.jsp" escapeXml="false" />

<portlet:renderURL var="viewURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esfguncategorization/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFGunType" var="editESFGunTypeURL" />

<aui:form action="<%= editESFGunTypeURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfGunType %>" model="<%= ESFGunType.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfGunTypeId"
				value='<%= esfGunType == null ? "" : esfGunType.getEsfGunTypeId() %>' />
			<aui:input name="name" />
			<aui:input name="description" type="textarea" />
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>
