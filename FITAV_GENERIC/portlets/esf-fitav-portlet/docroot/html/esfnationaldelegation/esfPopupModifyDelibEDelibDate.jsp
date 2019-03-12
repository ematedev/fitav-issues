<%@page import="it.ethica.esf.model.impl.ESFNationalImpl"%>
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
<h3>Modifica Delibere Tiratore <%=userName %> Specialità <%=stName %></h3>
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
		<div class="interBox">
		<aui:button type="submit"></aui:button>
			<aui:button onClick="<%= renderURL.toString() %>"
			value="back" />
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