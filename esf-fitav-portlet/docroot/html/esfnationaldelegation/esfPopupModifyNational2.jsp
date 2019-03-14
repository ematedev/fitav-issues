<%@page import="it.ethica.esf.model.impl.ESFNationalImpl"%>
<%@page import="it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@include file="init.jsp"%>



	<portlet:actionURL var="actionModifyNationalURL" name="actionModifyNational"  >
	</portlet:actionURL>

	<portlet:renderURL var="renderURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
	</portlet:renderURL>

<%
String userID = request.getParameter("esfNational");
String startdate =renderRequest.getParameter("startDate");
String enddate= renderRequest.getParameter("endDate");
startdate = startdate.substring(8,10)+"/"+startdate.substring(5,7)+"/"+startdate.substring(0,4);
enddate = enddate.substring(8,10)+"/"+enddate.substring(5,7)+"/"+enddate.substring(0,4);
Calendar cal = Calendar.getInstance();
String stName = "";
String userName = ""; 
long esfSTId = 0;
ESFNational national = new ESFNationalImpl();

if(Validator.isNotNull(userID) && Validator.isNotNull(ESFNationalLocalServiceUtil.fetchESFNational(Long.valueOf(userID)))){
	national = ESFNationalLocalServiceUtil.fetchESFNational(Long.valueOf(userID));
}

if(Validator.isNotNull(national) && Validator.isNotNull(national.getEsfSportTypeId())){
	esfSTId = national.getEsfSportTypeId();
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(esfSTId)) && 
			Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(esfSTId).getName())){
		stName = ESFSportTypeLocalServiceUtil.fetchESFSportType(esfSTId).getName();
	}
}

if(Validator.isNotNull(national) && Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(national.getEsfUserId())) &&
		Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(national.getEsfUserId()).getLastName()) && 
			Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(national.getEsfUserId()).getFirstName())){
	userName  =ESFUserLocalServiceUtil.fetchESFUser(national.getEsfUserId()).getFirstName()  + " " +  ESFUserLocalServiceUtil.fetchESFUser(national.getEsfUserId()).getLastName();
}

%>
<h3>Modifica Date Mandato Tiratore <%=userName %> Specialità <%=stName %></h3>

<aui:form action="<%= actionModifyNationalURL %>" method="post" name="fm">
		
	<aui:input type="hidden" name="esfNationalID" value="<%=userID %>" />
	
	<div class="interBox">
		<aui:input name="startDate" type="text" value="<%=startdate %>" >
			<aui:validator name="required" errorMessage="this-field-is-required" />
		</aui:input>
		<aui:input name="endDate" type="text" value="<%= enddate %>">
			<aui:validator name="required" errorMessage="this-field-is-required"/>
		</aui:input>
	</div>	
	<div class="separator"></div>

		<div class="interBox">
		<aui:button type="submit"></aui:button>
			<aui:button onClick="<%= renderURL.toString() %>"
			value="back" />
		</div>
	
</aui:form>
<% 

Calendar calendar = CalendarFactoryUtil.getCalendar();

String endDateString = ManageDate.CalendarToString(calendar);
String startDateString =  ManageDate.CalendarToString(calendar);

%>
 
<aui:script>
		$(function() {
			$("#<portlet:namespace/>endDate").datepicker();
			$("#<portlet:namespace/>endDate").datepicker("option", "dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>endDate").datepicker("setDate", '<%= enddate %>');
			
			
			
		});
		$(function() {
			$("#<portlet:namespace/>startDate").datepicker();
			$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>startDate").datepicker("setDate", '<%= startdate %>');
			
			
		});
			
</aui:script>