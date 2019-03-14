<%@ include file="init.jsp"%>

<%
ESFState esfState = null;

if(esfStateId > 0){
	
	esfState = ESFStateLocalServiceUtil.getESFState(esfStateId);
}
%>

<portlet:actionURL
	name='<%= esfState == null ? "addESFState" : "updateESFState"%>'
	var="editESFStateURL">
	<portlet:param name="esfStateId" value="<%=String.valueOf(esfStateId)%>" />
</portlet:actionURL>

<aui:form action="<%= editESFStateURL%>" method="post" name="fm">

	<aui:model-context bean="<%= esfState %>" model="<%= ESFState.class %>" />
	
	<aui:fieldset>
		<aui:input name="name" />
		<aui:input name="description" />
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
	</aui:fieldset>
	
</aui:form>