
<%@page import="it.ethica.esf.model.impl.ESFMatchImpl"%>
<%@include file="init.jsp"%>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFNationalDelegation esfNationalDelegation = (ESFNationalDelegation) row.getObject();
	ESFMatch match = null;
	String leaveMatchDate="";
	if(Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(esfNationalDelegation.getEsfMatchId()))){
		match = ESFMatchLocalServiceUtil.fetchESFMatch(esfNationalDelegation.getEsfMatchId());
		leaveMatchDate = sdf.format( match.getStartDate());
	}
	Calendar cal = CalendarFactoryUtil.getCalendar();
	if(Validator.isNotNull(esfNationalDelegation.getLeaveDate())){
		cal.setTime(esfNationalDelegation.getLeaveDate());
	}	
	String leaveDate = ManageDate.CalendarToString(cal);
	
	String leaveDateId = "leaveDate" + String.valueOf(esfNationalDelegation.getEsfUserId());
%>

<aui:script use="aui-base,node,aui-io-request">
	$(function() {
		$("#<portlet:namespace/><%=leaveDateId%>").datepicker();
		$("#<portlet:namespace/><%=leaveDateId%>").datepicker("option",
				"dateFormat", "dd/mm/yy");
		<% if(Validator.isNotNull(esfNationalDelegation.getLeaveDate())){%>
			$("#<portlet:namespace/><%=leaveDateId%>").datepicker("setDate",
			'<%= leaveDate %>');
		<%}else{%>
			$("#<portlet:namespace/><%=leaveDateId%>").datepicker("setDate",
			'<%= leaveMatchDate %>');
	<%}%>
	});
</aui:script>	

<aui:input name="<%=leaveDateId%>" style = "border:none; box-shadow:none;" cssClass = "dateInput" label = " "
			type = "text" placeholder = '<%=res.getString("leave-date")%>'
			value = "<%=ManageDate.DateToString(esfNationalDelegation.getLeaveDate())%>" />
