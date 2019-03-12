<%@ include file="init.jsp"%>

<%
	ESFEventType esfEventType = null;

	long esfEventTypeId =
		ParamUtil.getLong(request, "esfEventTypeId");

	if (esfEventTypeId >0) {

		esfEventType =
				ESFEventTypeLocalServiceUtil.getESFEventType(esfEventTypeId);
	}
	
	String macrocategory = "";
	String eventType = "";
	
	if (Validator.isNotNull(esfEventType)) {
		macrocategory = String.valueOf(esfEventType.getMacrocategory());
		eventType = String.valueOf(esfEventType.getEventType());
		
	}
	
%>

<portlet:actionURL name="editESFeventType" var="editESFeventTypeURL">
	<portlet:param name="esfEventTypeId"
		value="<%=String.valueOf(esfEventTypeId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFeventTypeURL%>"
	name="fm">
	<aui:model-context bean="<%= esfEventType%>"
		model="<%=ESFEventType.class%>" />

	<aui:fieldset>
	
	<aui:input type="hidden" name="esfEventTypeId"
			value='<%=esfEventTypeId%>' />

		<aui:input type="hidden" name="userId"
			value='<%=themeDisplay.getUserId()%>' />
			
		<aui:input type="hidden" name="companyId"
			value='<%=themeDisplay.getCompanyId()%>' />

			
		<aui:input name="macrocategory" type="text" label="Macrocategory"
			 value='<%=macrocategory%>'>
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="eventType" type="text" label="EventType" 
			 value='<%=eventType%>'>
			<aui:validator name="required" />

		</aui:input>	

	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>