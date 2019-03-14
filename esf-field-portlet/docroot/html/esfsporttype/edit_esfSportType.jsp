<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp" %>

<%
	ESFSportType esfSportType = null;

	long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");

	if (esfSportTypeId > 0) {
		esfSportType = ESFSportTypeLocalServiceUtil.getESFSportType(esfSportTypeId);
	}
%>

<portlet:renderURL var="viewURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esffield/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFSportType" var="editESFSportTypeURL" />

<aui:form action="<%= editESFSportTypeURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfSportType %>" model="<%= ESFSportType.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfSportTypeId"
				value='<%= esfSportType == null ? "" : esfSportType.getEsfSportTypeId() %>' />
			<aui:input name="name" />
			<aui:input name="description" type="textarea"/>
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>
