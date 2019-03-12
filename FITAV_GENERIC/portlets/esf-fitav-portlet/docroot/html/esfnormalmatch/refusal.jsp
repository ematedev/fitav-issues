<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFInstructsShootingDirector"%>
<%@include file="init.jsp"%>

<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = "";

List<ESFInstructsShootingDirector> insts = ESFInstructsShootingDirectorLocalServiceUtil.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);


long delegationId = ParamUtil.getLong(request, "delId");

ESFNationalDelegation del =  ESFNationalDelegationLocalServiceUtil.fetchESFNationalDelegation(delegationId);
ESFUser staff = ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId());
ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(del.getEsfMatchId());

String userName="";
String matchCode = "";
if(Validator.isNotNull(user)){
	userName = staff.getFirstName() + " " +staff.getLastName();
}

if(Validator.isNotNull(match)){
	matchCode = match.getCode() ;
}
%>
<h4><b> Stai compilando il rifiuto alla convocazione come Direttori di tiro di <%=userName.toUpperCase()%> per la gara <%=matchCode.toUpperCase() %>
<br>

<portlet:actionURL name="refusal" var="refusalURL">
	<portlet:param name="delegationId"
				value="<%=String.valueOf(delegationId)%>" />

</portlet:actionURL>

<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath"
			value='<%=templatePath + "edit_staff.jsp"%>' />
</portlet:renderURL>
	

<aui:form action="<%= refusalURL %>" name="<portlet:namespace />fm" >
	<div>
	<aui:select name = "instructId" label = "instructors" inlineField="true" >
		<aui:option value = "0" label = "-" ></aui:option>
		<% 
		
		for(ESFInstructsShootingDirector inst : insts){
	
		%>
		<aui:option value ="<%=inst.getEsfInstructsShootingDirectorId()%>" label = "<%=inst.getEsfInstructsShootingDirectorCode() %>" ></aui:option>
		
		<%
		}
		
		%>
	</aui:select>
	
	<aui:input name="refusalDate" type="text" label="refusalDate" inlineField="true"/>
	

	
	<aui:input name="refusalMotivation" type="text" label="refusalMotivation" inlineField="true"/>
	
	
	</div>
	<div>
		<aui:button type="submit" value="add" />
		<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>

	</div>
</aui:form>




<aui:script use="aui-base,node,aui-io-request">

	$(function() {
		$("#<portlet:namespace/>refusalDate").datepicker();
		$("#<portlet:namespace/>refusalDate").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>refusalDate").datepicker("setDate",
				'<%= currDate %>');
	
	});
	</aui:script>
