<%@include file="init.jsp"%>



<portlet:actionURL var="actionModifyNationalURL" name="actionModifyNationalDelibeDelibDate"  >
	</portlet:actionURL>

	<portlet:renderURL var="renderURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
	</portlet:renderURL>

<%

String userID=request.getParameter("esfNational");
String deliberate ="";
String delibDate=""; 
if(Validator.isNotNull(renderRequest.getParameter("deliberate")))
{
	deliberate = renderRequest.getParameter("deliberate");
}
if(Validator.isNotNull(renderRequest.getParameter("delibDate")))
{
	delibDate = renderRequest.getParameter("delibDate");
	delibDate = delibDate.substring(8,10)+"/"+delibDate.substring(5,7)+"/"+delibDate.substring(0,4);
}
%>

<aui:form action="<%= actionModifyNationalURL %>" method="post" name="fm">
		
	<aui:input type="hidden" name="esfNationalID" value="<%=userID %>" />
	
	<div class="interBox">
		<aui:input name="deliberate" type="text" value="<%=deliberate%>" >
			<aui:validator name="required" errorMessage="this-field-is-required" />
		</aui:input>
		<aui:input name="delibDate" type="text" value="<%= delibDate %>">
			<aui:validator name="required" errorMessage="this-field-is-required"/>
		</aui:input>
	</div>	
	<div class="separator"></div>
	<div class="box">
		<div class="interBox">
		<aui:input name="" type="submit" value="OK" />
		</div>
		<div class="interBox">
			<aui:button onClick="<%= renderURL.toString() %>"
			value="back" />
		</div>
	</div>
	
</aui:form>
<% 

Calendar calendar = CalendarFactoryUtil.getCalendar();

%>
 
<aui:script>
		$(function() {
			$("#<portlet:namespace/>delibDate").datepicker();
			$("#<portlet:namespace/>delibDate").datepicker("option", "dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>delibDate").datepicker("setDate", '<%= delibDate %>');
		});

			
</aui:script>