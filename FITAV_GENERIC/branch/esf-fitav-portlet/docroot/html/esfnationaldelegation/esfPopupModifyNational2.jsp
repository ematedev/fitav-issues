<%@page import="java.util.Locale"%>
<%@include file="init.jsp"%>



	<portlet:actionURL var="actionModifyNationalURL" name="actionModifyNational"  >
	</portlet:actionURL>

	<portlet:renderURL var="renderURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
	</portlet:renderURL>

<%

String userID=request.getParameter("esfNational");
String startdate =renderRequest.getParameter("startDate");
String enddate= renderRequest.getParameter("endDate");
startdate = startdate.substring(8,10)+"/"+startdate.substring(5,7)+"/"+startdate.substring(0,4);
enddate = enddate.substring(8,10)+"/"+enddate.substring(5,7)+"/"+enddate.substring(0,4);
Calendar cal = Calendar.getInstance();

%>

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
	<div class="box">
		<div class="interBox">
		<aui:input name="" type="submit" value="ok" />
		</div>
		<div class="interBox">
			<aui:button onClick="<%= renderURL.toString() %>"
			value="back" />
		</div>
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