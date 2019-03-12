<%@include file="init.jsp" %>

<%
	ESFOrganizationUnitservice esfOrganizationUnitservice = null;

	long esfOrganizationUnitserviceId = ParamUtil.getLong(request, "esfOrganizationUnitserviceId");

	if (esfOrganizationUnitserviceId > 0) {
		esfOrganizationUnitservice = ESFOrganizationUnitserviceLocalServiceUtil.getESFOrganizationUnitservice(esfOrganizationUnitserviceId);
	}
	List <ESFUnitservice> esfUnitservices = ESFUnitserviceLocalServiceUtil.getAllESFUnitservices();
	
%>

<portlet:actionURL name="editESFOrganizationUnitservice" var="editESFOrganizationUnitserviceURL" windowState="<%=WindowState.NORMAL.toString()%>" />

<aui:form action="<%= editESFOrganizationUnitserviceURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfOrganizationUnitservice %>" model="<%= ESFOrganizationUnitservice.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfOrganizationUnitserviceId"
				value='<%=esfOrganizationUnitservice == null ? "": esfOrganizationUnitservice.getEsfOrganizationUnitserviceId() %>' />
		
			<aui:select name="esfUnitserviceId" required="true">
				<%for (ESFUnitservice esfUnitservice : esfUnitservices) {  %>
					<aui:option value="<%= esfUnitservice.getEsfUnitserviceId() %>">
						<liferay-ui:message key="<%= esfUnitservice.getDescription() %>" />
 					</aui:option>
	 			<% } %>
			</aui:select>
		<aui:input type="hidden" name="esfOrganizationId" value="<%=currentOrganizationId %>"/> 
		<aui:input name="numberUnitservices" />
		<aui:input name="description" type="textarea" />
		</aui:fieldset>
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>" value="cancel"></aui:button>
		</aui:button-row>
</aui:form>