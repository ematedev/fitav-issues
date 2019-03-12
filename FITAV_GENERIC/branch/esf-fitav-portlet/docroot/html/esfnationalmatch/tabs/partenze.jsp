<%@page import="it.ethica.esf.model.ESFDeparture"%>
<%@page import="it.ethica.esf.service.ESFDepartureLocalServiceUtil"%>
<%@include file="../init.jsp"%>

<%
	
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	List<ESFDeparture> esfDepartures = ESFDepartureLocalServiceUtil.
									findESFDeparturesByESFMatchId(esfMatchId);
	List<ESFUser> esfUsersAllImmutableList = 
					ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(esfMatchId);

%>

<portlet:renderURL var="addESFDepartureURL">
	<portlet:param name="mvcPath"
		value="/html/esfnationalmatch/choose_travel.jsp" />
	<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" />
</portlet:renderURL>

<portlet:renderURL var="backURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
	<portlet:param name="organizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
</portlet:renderURL>

<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_ADD_DEPARTURE) %>">	
						
<aui:button onClick="<%= addESFDepartureURL.toString()%>"
	value="add-departure" />
</c:if>


<%if(esfDepartures.size() == 0){%>
<h2>
	<liferay-ui:message key="no-departures" />
</h2>
<%
}
int i = 0;
for(ESFDeparture departure : esfDepartures){
	if(departure.getEsfUserId() == 0){
		List<ESFUser> esfUsers = ESFUserLocalServiceUtil.
									getESFUsersByDeparture(departure.getEsfDepartureId());

%>

<h2>
	<%=departure.getCompanyName() %>
	(<%= " " + departure.getCode() + "   "%>)
	<%=departure.getDepartureFrom() + " --> "%>
	<%=departure.getArrivalTo()%>
	<% 
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String departureDescription = "";
	String arriveHour = "";
	String leaveHour = "";
	String leaveDate = "";
	String arriveDate = "";
	
	if(Validator.isNotNull(departure.getLeaveDate())){
		leaveDate = dateFormat.format(departure.getLeaveDate());
	}
	if(Validator.isNotNull(departure.getArriveDate())){
		arriveDate = dateFormat.format(departure.getArriveDate());
	}
	if(!"".equals(departure.getLeaveHour())){
		leaveHour = ","+departure.getLeaveHour();
	}
	if(!"".equals(departure.getArriveHour())){
		arriveHour = ","+departure.getArriveHour();
	}
	departureDescription = "(" + leaveDate + leaveHour + "-" + arriveDate + arriveHour + ")";
	
	
	%>
	<span class="flightDates"> <%= departureDescription%> </span>
</h2>

<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_UPDATE_DEPARTURE) %>">	
	<portlet:renderURL var="editESFDepartureURL">
		<%
		
		if ("aereo".equalsIgnoreCase(departure.getTypeTravel())) {%>
		<portlet:param name="mvcPath"
			value="/html/esfnationalmatch/edit_esfDeparture.jsp" />
		<%} else{ ;%>
		<portlet:param name="mvcPath"
			value="/html/esfnationalmatch/edit_esfDepartureB.jsp" />
		<%} %>
		<portlet:param name="esfMatchId"
			value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="esfDepartureId"
			value="<%=String.valueOf(departure.getEsfDepartureId())%>" />
	</portlet:renderURL>
	
	<aui:button onClick="<%= editESFDepartureURL.toString()%>"
		value="edit-departures" />
</c:if>	

<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_DELETE_DEPARTURE) %>">	
	<portlet:actionURL name="deleteESFDeparture" var="deleteESFDepartureURL">
		<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchId)%>" />	
			<portlet:param name="esfDepartureId"
				value="<%=String.valueOf(departure.getEsfDepartureId())%>" />
	</portlet:actionURL> 
	
	<aui:form action = "<%=deleteESFDepartureURL%>" cssClass="formButton">	
		<aui:button type = "delet" value = "delete"></aui:button>
	</aui:form>
</c:if>

				
<div class="panel">
	<liferay-ui:search-container emptyResultsMessage="no-users-assined">

		<liferay-ui:search-container-results
					results="<%= esfUsers %>"
					total="<%= esfUsers.size() %>" />
					
		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

			<%
			String role = "";
			if(ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(
						esfUser.getEsfUserId(), esfMatchId).size()> 0){
				ESFNationalDelegation esfNationalDelegation =
						ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(
								esfUser.getEsfUserId(), esfMatchId).get(0);
				ESFPartecipantType ptype =
						ESFPartecipantTypeLocalServiceUtil.fetchESFPartecipantType(esfNationalDelegation.getEsfPartecipantTypeId());
								
				if (Validator.isNotNull(ptype)) {
					role = ptype.getName();
				}
			}
			%>

			<liferay-ui:search-container-column-text property="firstName"
				name="first-name" />

			<liferay-ui:search-container-column-text property="lastName"
				name="last-name" />

			<liferay-ui:search-container-column-text name="role"
				value="<%= (StringPool.BLANK.equalsIgnoreCase(role)? role : res.getString(role))%>" />
				
			<liferay-ui:search-container-column-text name="user-email">
			
				<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
			
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text property="fiscalCode"
				name="fiscal-code" />

			<liferay-ui:search-container-column-text property="jobTitle"
				name="job-title" />

			<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_DELETE_USER_FROM_DEPARTURE) %>">	

				<liferay-ui:search-container-column-text>
					<portlet:actionURL name="deleteESFDeparturePartecipant" var="deleteESFDeparturetUserURL">
						<portlet:param name="esfMatchId"
								value="<%=String.valueOf(esfMatchId)%>" />
						<portlet:param name="esfUserId"
								value="<%=String.valueOf(esfUser.getEsfUserId())%>" />
					</portlet:actionURL> 
					<aui:form action = "<%=deleteESFDeparturetUserURL%>">	
						<aui:button type = "delet" value = "delete"></aui:button>
					</aui:form>
				</liferay-ui:search-container-column-text>
			</c:if>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<%
	}
	}
%>

<h2>
	<liferay-ui:message key="choose-users" />
</h2>
<div class="panel">

	<liferay-ui:search-container emptyResultsMessage="no-results">

		<liferay-ui:search-container-results
					results="<%= ESFUserLocalServiceUtil.
										finNationalDelegationESFUsersByMatchId(
											esfMatchId, searchContainer.getStart(),
											searchContainer.getEnd()) %>"
					total="<%= ESFUserLocalServiceUtil.
										finNationalDelegationESFUsersByMatchId(
											esfMatchId).size() %>" />

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

			<%
					String role = "";
					if(ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(
							esfUser.getEsfUserId(), esfMatchId).size()>0){
						ESFNationalDelegation esfNationalDelegation =
							ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(
								esfUser.getEsfUserId(), esfMatchId).get(0);

						ESFPartecipantType ptype =
							ESFPartecipantTypeLocalServiceUtil.fetchESFPartecipantType(esfNationalDelegation.getEsfPartecipantTypeId());
						
						if (Validator.isNotNull(ptype)) {
							role = ptype.getName();
						}
					}	
			%>

			<liferay-ui:search-container-column-text property="firstName"
				name="first-name" />

			<liferay-ui:search-container-column-text property="lastName"
				name="last-name" />

			<liferay-ui:search-container-column-text name="role"
				value="<%=(StringPool.BLANK.equalsIgnoreCase(role)? role : res.getString(role))%>" />

			<liferay-ui:search-container-column-text name="user-email">
			
				<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
			
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text property="fiscalCode"
				name="fiscal-code" />

			<liferay-ui:search-container-column-text property="jobTitle"
				name="job-title" />

<%if(esfDepartures.size() > 0){ %>
			<liferay-ui:search-container-column-text name = "choose-departure">
			
						<portlet:actionURL name="addUserToESFDeparture" var="addUserToESFDepartureURL">
							<portlet:param name="esfMatchId"
								value="<%=String.valueOf(esfMatchId)%>" />
						</portlet:actionURL> 
						<aui:form action = "<%=addUserToESFDepartureURL%>">	
						<%
							List<String> labelValues = new ArrayList<String>();
							List<ESFDeparture> esfDepartureApp = new ArrayList<ESFDeparture>();
							for(ESFDeparture e : esfDepartures){
									if(e.getEsfUserId() == 0){
										List<ESFUser>allPartecipants = 
														ESFUserLocalServiceUtil.
															getESFUsersByDeparture(
																e.getEsfDepartureId());
										if(!allPartecipants.contains(esfUser)){
		
										String labelValue = 
													e.getCompanyName() + " " +
																e.getCode();
										labelValues.add(labelValue);
										esfDepartureApp.add(e);
										}
									}
							}
							if(labelValues.size()>0) {
								%>
								<aui:select name = "esfDepartureId" label = " " >
								<%
								for(int j = 0; j<labelValues.size();j++)
								{
									long esfDepartureId = esfDepartureApp.get(j).getEsfDepartureId();
									String actualLabel = labelValues.get(j);
	
							%>
									<aui:option value = "<%=String.valueOf(esfDepartureId)%>" 
										label = "<%=actualLabel%>">
									</aui:option>
							<%	}%>
								</aui:select>
						<%	} %>
							<div style = "display : none;">
								<aui:input type = "text"  name = "esfUserId" value = "<%=String.valueOf(esfUser.getEsfUserId())%>">
								</aui:input>
							</div>
							<%if(labelValues.size()>0) { %>
								<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_ADD_USER_FROM_DEPARTURE) %>">	
									<aui:button type = "submit" value = "add"></aui:button>
								</c:if>
							<%} %>
						</aui:form>
			</liferay-ui:search-container-column-text>
<%} %>				
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<aui:button onClick="<%= backURL.toString() %>" value="go-back" />
