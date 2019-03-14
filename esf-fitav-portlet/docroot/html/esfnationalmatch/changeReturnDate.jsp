
<%@page import="it.ethica.esf.model.impl.ESFMatchImpl"%>
<%@include file="init.jsp"%>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFNationalDelegation esfNationalDelegation = (ESFNationalDelegation) row.getObject();
	ESFMatch match = null;
	String returnMatchDate="";
	if(Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(esfNationalDelegation.getEsfMatchId()))){
		match = ESFMatchLocalServiceUtil.fetchESFMatch(esfNationalDelegation.getEsfMatchId());
		returnMatchDate = sdf.format( match.getEndDate());
	}
	
	
	
	Calendar cal = CalendarFactoryUtil.getCalendar();
	if(Validator.isNotNull(esfNationalDelegation.getReturnDate())){
		cal.setTime(esfNationalDelegation.getReturnDate());
	}	
	String returnDate = ManageDate.CalendarToString(cal);
	
	String returnDateId = "returnDate" + String.valueOf(esfNationalDelegation.getEsfUserId());
	
%>

<aui:script use="aui-base,node,aui-io-request">
	$(function() {
		$("#<portlet:namespace/><%=returnDateId%>").datepicker();
		$("#<portlet:namespace/><%=returnDateId%>").datepicker("option",
				"dateFormat", "dd/mm/yy");
		<% if(Validator.isNotNull(esfNationalDelegation.getReturnDate())){%>
			$("#<portlet:namespace/><%=returnDateId%>").datepicker("setDate",
			'<%= returnDate %>');
		<%}else{%>
			$("#<portlet:namespace/><%=returnDateId%>").datepicker("setDate",
			'<%= returnMatchDate %>');
		<%}%>
	});
</aui:script>	

<aui:input class = "dateInput" style = "border:none; box-shadow:none;" name="<%=returnDateId%>" label = " " placeholder = '<%=res.getString("return-date")%>' 
			value="<%=ManageDate.DateToString(esfNationalDelegation.getReturnDate())%>" />