<%@include file="init.jsp"%>

<aui:fieldset>

	<aui:model-context bean="<%=currentESFOrganization%>"
		model="<%=ESFOrganization.class%>" />

	<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
			
	String currDateC = "";
			
	if(currentESFOrganization!=null && currentESFOrganization.getConiDate() != null)
		 currDateC =ManageDate.DateToString(currentESFOrganization.getConiDate());
	
	
	%>

	<aui:script>
	$(function() {
		$("#<portlet:namespace/>coniDate").datepicker();
		$("#<portlet:namespace/>coniDate").datepicker("option", "dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>coniDate").datepicker("setDate", '<%= currDateC %>');
		
	});
	
	</aui:script>
	<c:choose>
		<c:when test="<%=ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_FISCAL_CODE)%>">
		
			<aui:input name="coniDate" type="text" />
		
			<aui:input name="coniCode" />
				
		</c:when>
		<c:otherwise>
		
			<aui:input name="coniDate" type="hidden" value="<%= currDateC %>" />
		
			<aui:input name="coniCode" type="hidden" value="<%= currentESFOrganization.getConiCode() %>"/>
		
		</c:otherwise>
	</c:choose>
	
</aui:fieldset>
