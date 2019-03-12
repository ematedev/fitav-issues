<%@include file="init.jsp"%>

<aui:fieldset>

	<aui:model-context bean="<%=currentESFOrganization%>"
		model="<%=ESFOrganization.class%>" />

	<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
			
	String currDateC = "";
			
	if(currentESFOrganization!=null && currentESFOrganization.getConiDate() != null)
		 currDateC =ManageDate.DateToString(currentESFOrganization.getConiDate());
	
	String readOnly="readonly";
	String readOnlyConi="";
	if(ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_FISCAL_CODE)){
		readOnlyConi=readOnly;
	}
	
	%>

	<aui:script>
	$(function() {
		$("#<portlet:namespace/>coniDate").datepicker();
		$("#<portlet:namespace/>coniDate").datepicker("option", "dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>coniDate").datepicker("setDate", '<%= currDateC %>');
		
	});
	
	</aui:script>

	<aui:input name="coniDate" type="text"  <%= readOnlyConi %> />

	<aui:input name="coniCode"   <%= readOnlyConi %> />

</aui:fieldset>
