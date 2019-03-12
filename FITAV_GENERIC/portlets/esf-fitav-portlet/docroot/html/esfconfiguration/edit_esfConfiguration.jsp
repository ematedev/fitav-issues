<%@ include file="init.jsp" %>

<%
	ESFConfiguration esfConfiguration = null;

	long esfConfigurationId = ParamUtil.getLong(request, "esfConfigurationId");

	if (esfConfigurationId > 0) {
		esfConfiguration = ESFConfigurationLocalServiceUtil.getESFConfiguration(esfConfigurationId);
	}
	System.out.println(esfConfigurationId);
%>
 
<portlet:actionURL name="editESFConfiguration" var="editESFConfigurationURL" windowState="<%=WindowState.NORMAL.toString()%>" />

<aui:form action="<%= editESFConfigurationURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfConfiguration %>" model="<%= ESFConfiguration.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfConfigurationId"
				value='<%= esfConfiguration == null ? "" : esfConfiguration.getEsfConfigurationId() %>' />
			<%if(esfConfiguration==null) {%>
				<aui:input name="key" />
			<%}else{ %>
				<aui:input type="hidden" name="key" value="<%=esfConfiguration.getKey() %>" />
			<%} %>
			<aui:input name="value" size="30" />
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>