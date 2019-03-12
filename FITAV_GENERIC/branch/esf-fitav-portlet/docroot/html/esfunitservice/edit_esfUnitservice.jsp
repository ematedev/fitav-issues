<%@include file="init.jsp" %>

<%
	ESFUnitservice esfUnitservice = null;
	long esfUnitserviceId = ParamUtil.getLong(request, "esfUnitserviceId");
	
	if (esfUnitserviceId > 0) {
		esfUnitservice = ESFUnitserviceLocalServiceUtil.getESFUnitservice(esfUnitserviceId);
	}
%>

<portlet:actionURL  name="editESFUnitservice" var="editESFUnitserviceURL" />

<aui:form action="<%= editESFUnitserviceURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfUnitservice %>" model="<%= ESFUnitservice.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfUnitserviceId"
				value='<%= esfUnitservice == null ? "" : esfUnitservice.getEsfUnitserviceId() %>' />
			<aui:input name="description" />
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>" value="cancel"></aui:button>
		</aui:button-row>
</aui:form>