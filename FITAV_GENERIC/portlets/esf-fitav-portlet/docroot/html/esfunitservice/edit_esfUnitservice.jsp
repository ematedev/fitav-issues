<%@include file="init.jsp" %>

<%
	ESFUnitservice esfUnitservice = null;
	long esfUnitserviceId = ParamUtil.getLong(request, "esfUnitserviceId");
	
	if (esfUnitserviceId > 0) {
		esfUnitservice = ESFUnitserviceLocalServiceUtil.getESFUnitservice(esfUnitserviceId);
	}
	
	if(Validator.isNotNull(esfUnitservice)){
		String unitService = esfUnitservice.getDescription();
		String[] unitServiceName = {unitService};
	%>
	<h4><b><liferay-ui:message key="update-unitService-x" arguments="<%= unitServiceName%>"/></b>
				<div class="separator"></div>
	<% 
		
	}else{
	%>
	<h4><b><liferay-ui:message key="add-new-unitService" /></b>
				<div class="separator"></div>
<%
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