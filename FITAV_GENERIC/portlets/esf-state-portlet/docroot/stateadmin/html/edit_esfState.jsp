<%@include file="/stateadmin/init.jsp"%>

<%
	ESFState esfState = null;

	long esfStateId = ParamUtil.getLong(request, "esfStateId");

	if (esfStateId > 0) {
		esfState = ESFStateLocalServiceUtil.getESFState(esfStateId);
	}
%>

<portlet:renderURL var="viewURL" windowState="<%= WindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/atateadmin/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL
	name='<%=esfState == null ? "addESFState" : "updateESFState"%>'
	var="editESFStateURL" />

<aui:form action="<%=editESFStateURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=esfState%>" model="<%=ESFState.class%>" />
	<aui:fieldset>
		<aui:input type="hidden" name="esfStateId"
			value='<%=esfState == null ? "" : esfState.getEsfStateId()%>' />
		<aui:input name="esfName"
			value='<%=esfState == null ? "" : esfState.getEsfName()%>'>
		</aui:input>
		<aui:input name="esfDescription"
			value='<%=esfState == null
							? "" : esfState.getEsfDescription()%>'>
		</aui:input>

	</aui:fieldset>


	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>