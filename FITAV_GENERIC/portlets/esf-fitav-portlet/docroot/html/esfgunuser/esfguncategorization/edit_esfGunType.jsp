<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="../init.jsp" %>

<%
	ESFGunType esfGunType = null;

	long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");

	if (esfGunTypeId > 0) {
		esfGunType = ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);
	}
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
%>

<portlet:resourceURL var="locationURL" id="view.jsp" escapeXml="false" />

<portlet:renderURL var="viewCategorizationURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esfgunuser/esfguncategorization/view.jsp" />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:renderURL>

<portlet:actionURL name="editESFGunType" var="editESFGunTypeURL" >
	<portlet:param name="mvcPath" value="/html/esfgunuser/esfguncategorization/view.jsp" />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>

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
			<aui:button type="cancel" onClick="<%= viewCategorizationURL %>" value="back"></aui:button>
		</aui:button-row>
</aui:form>
