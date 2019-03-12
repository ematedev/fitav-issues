<%@include file="init.jsp"%>



<portlet:actionURL var="actionShooterToNationalURL" name="actionShooterToNational"  >
</portlet:actionURL>
<portlet:renderURL var="renderURL">
	<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
</portlet:renderURL>
<%
List<ESFSportType> sports = new ArrayList<ESFSportType>();
sports = ESFSportTypeLocalServiceUtil.getisOlimpic(true);
boolean selected= false;

String userID=request.getParameter("esfUser");
String stId = ParamUtil.getString(request, "stId");
String stName = "";
String userName = "";

if(Validator.isNotNull(stId)){
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId))) && 
			Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId)).getName())){
		stName = ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId)).getName();
	}
}

if(Validator.isNotNull(userID) && Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(Long.parseLong(userID))) &&
		Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(Long.parseLong(userID)).getLastName()) && 
			Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(Long.parseLong(userID)).getFirstName())){
	userName  = ESFUserLocalServiceUtil.fetchESFUser(Long.parseLong(userID)).getFirstName()  + " " + ESFUserLocalServiceUtil.fetchESFUser(Long.parseLong(userID)).getLastName();
}

Calendar now = CalendarFactoryUtil.getCalendar();

int year=now.get(Calendar.YEAR);

%>

<h3>Assegnazione <%=userName %> alla specialità <%=stName %></h3>

<aui:form action="<%= actionShooterToNationalURL %>" method="post" name="fm">
		
	<aui:input type="hidden" name="esfUserID" value="<%=userID %>" />
	
	<aui:input name="sportType" readonly="<%=selected %>" value="<%=Long.valueOf(stId) %>" type="hidden"/>
	<aui:input  label="sport-type" name="sportTypeName" readonly="<%=selected %>" value="<%=stName%>" />
	
		<aui:select label="year-delegation" name="yearDelegation" >
	
			
			<aui:option value="<%=year %>" > 
			<%=year %>
			</aui:option>
			<aui:option value="<%=year+1 %>" > 
			<%=year+1%>
			</aui:option>
			
	
	</aui:select>
	
	
	<div class="interBox">
		<aui:input type="radio" name="isNational" id="isNational" label="isNational" checked="true"/>
		<aui:input type="radio" name="isNational" id="isNationalB/23" label="isNationalB/23" checked="false"/>
	</div>
	
	
	<div class="interBox">
		<aui:input type="checkbox" name="isUniversity" key="is-University" />
	</div>
	
	<div class="separator"></div>
	
	<div class="Box">
	
	<aui:button name="submit" type="submit" value="save" />
		
	<aui:button onClick="<%= renderURL.toString() %>" value="back" />
	</div>
	
</aui:form>
