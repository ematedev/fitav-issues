<%@include file="init.jsp"%>



<portlet:actionURL var="actionShooterToNationalURL" name="actionShooterToNational"  >
</portlet:actionURL>
<portlet:renderURL var="renderURL">
	<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
</portlet:renderURL>
<%
List<ESFSportType> sports = new ArrayList<ESFSportType>();
sports = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

String userID=request.getParameter("esfUser");

ESFUser userPromoved = ESFUserLocalServiceUtil.fetchESFUser(Long.parseLong(userID));
String userName = userPromoved.getFirstName()+ " " + userPromoved.getLastName();

Calendar now = CalendarFactoryUtil.getCalendar();

int year=now.get(Calendar.YEAR);

%>

<h3><%=userName %></h3>

<aui:form action="<%= actionShooterToNationalURL %>" method="post" name="fm">
		
	<aui:input type="hidden" name="esfUserID" value="<%=userID %>" />
	
	<aui:select label="sport-type" name="sportType" >
		<%for(ESFSportType st: sports){
			
			if(st.getIsOlimpic()){%>
			
			<aui:option value="<%=st.getEsfSportTypeId() %>" > 
			
				<%=st.getName()%>
			
			</aui:option>
			
		<%}
		} %>
	</aui:select>
	
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
