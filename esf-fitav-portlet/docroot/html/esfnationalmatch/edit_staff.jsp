
<%@include file="init.jsp"%>


<portlet:renderURL var="viewURLStaff">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
	<portlet:param name="organizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
</portlet:renderURL>


<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
</portlet:renderURL>


<%

Group currentGroup = themeDisplay.getLayout().getGroup();
long fitavId = currentGroup.getClassPK();
long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
int urlEndIndex = currentUrlPage.indexOf('?');
String backtoviewURLStaff = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	
if(urlEndIndex != -1){
	viewURLStaff = currentUrlPage.substring(0, urlEndIndex);
}
portletDisplay.setURLBack(viewURLStaff);
/*end*/

if(esfMatchId == 0){
	esfMatchId = ParamUtil.getLong(request, "esfMatchId");
}

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", templatePath +"edit_staff.jsp");
viewassURL.setParameter(
	"organizationId", String.valueOf(currentOrganizationId));
viewassURL.setParameter("esfMatchId", String.valueOf(esfMatchId));
viewassURL.setWindowState(WindowState.NORMAL);

List<ESFNationalDelegation> esfUsersPartecipants = ESFNationalDelegationLocalServiceUtil.
			getESFNationalDelegationByESFMatchIdNotShooter(esfMatchId);


int totalPartecipants = esfUsersPartecipants.size();

List<ESFUser> esfUsersIds = new ArrayList<ESFUser>();

if(esfUsersPartecipants.size() > 0){
	  
	for(ESFNationalDelegation u : esfUsersPartecipants){
		if(u.getEsfPartecipantTypeId()!=ESFKeys.ESFNationalDelegationType.SHOOTER)
			esfUsersIds.add(ESFUserLocalServiceUtil.getESFUser(u.getEsfUserId()));
		
	}
}

String firstName = ParamUtil.getString(request, "firstName");
String lastName = ParamUtil.getString(request, "lastName");
String fiscalCode = ParamUtil.getString(request, "fiscalCode");

viewassURL.setParameter("firstName", String.valueOf(firstName));
viewassURL.setParameter("lastName", String.valueOf(lastName));
viewassURL.setParameter("fiscalCode", String.valueOf(fiscalCode));

List<Long> esfUserESFUserRoleAssignId = new ArrayList<Long>();

%>
		<b>
			<liferay-ui:message key="staff-assegn" />
		</b>
		
		<div class="panel">

			<liferay-ui:search-container emptyResultsMessage="no-results" 
				iteratorURL="<%=viewassURL%>" curParam="selctedSatff">
				
				<liferay-ui:search-container-results
					results="<%= esfUsersIds %>"
					total="<%= esfUsersIds.size() %>" />
				
				<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

					<liferay-ui:search-container-column-text property="lastName"
						name="last-name" />
					
					<liferay-ui:search-container-column-text property="firstName"
						name="first-name" />
						
					<liferay-ui:search-container-column-text name="user-email">
			
					<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
			
					</liferay-ui:search-container-column-text>
					<%
					
					ESFNationalDelegation partecipant = null ;
					
					List<ESFNationalDelegation> partecipants = 
							ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchIdNotShooter(esfMatchId);
					
					
					for(ESFNationalDelegation n : partecipants){
						if(n.getEsfUserId() == esfUser.getEsfUserId()){
							partecipant = n ;
						}
					}
					
					String role = "";
										
					if(Validator.isNotNull(partecipant)){
						ESFPartecipantType ptype = null;
							if(Validator.isNotNull(partecipant)){
								ptype = ESFPartecipantTypeLocalServiceUtil.
											getESFPartecipantType(partecipant.getEsfPartecipantTypeId());
							}
							
							
							if(Validator.isNotNull(ptype)){
								role = ptype.getName();
							}
					}
					%>
					<liferay-ui:search-container-column-text name="role"
							value="<%=res.getString(role)%>" />	
					
					<%String issf_role="";
						issf_role=role+"*";	%>
					
					<liferay-ui:search-container-column-text name="issf_role"
							value='<%=res.getString(issf_role)%>' />
							
					<liferay-ui:search-container-column-text property="fiscalCode"
						name="fiscal-code" />

					<liferay-ui:search-container-column-text property="jobTitle"
						name="job-title" />

					<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_DELETE_STAFF) %>">	
						<liferay-ui:search-container-column-jsp
						path='<%=templatePath + "staffSelected_actions.jsp"%>' align="right" />
					</c:if>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>


		<br/>
		<br/>
		
	<liferay-portlet:renderURL varImpl="searchStaffURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "edit_staff.jsp"%>' />
	<portlet:param name="esfMatchId"
		value='<%=String.valueOf(esfMatchId)%>' />
	</liferay-portlet:renderURL>
		
		<aui:form action="<%=searchStaffURL%>" method="get">
			<liferay-portlet:renderURLParams varImpl="searchStaffURL" />
			<div class="search-form">
				<span class="aui-search-bar"> 
				
					<aui:input inlineField="<%=true%>" label="last-name" name="lastName"
						placeholder="last-name" size="" title="search-entries" />
	
					<aui:input inlineField="<%=true%>" label="first-name" 	name="firstName"
						placeholder="first-name" size="" title="search-entries" />
					
					<aui:input inlineField="<%=true%>" label="fiscal-code" name="fiscalCode"
						placeholder="fiscal-code" size="" title="search-entries" />	
					<aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>

		<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=viewassURL%>"
			 curParam="AllStaff"	>
		
			
			<%

			viewassURL.setParameter("firstName", String.valueOf(firstName));
			viewassURL.setParameter("lastName", String.valueOf(lastName));
			viewassURL.setParameter("fiscalCode", String.valueOf(fiscalCode));
			
				List<ESFUserESFUserRole> userRole = new ArrayList<ESFUserESFUserRole>();
				List<ESFUserESFUserRole> userRoles = new ArrayList<ESFUserESFUserRole>(); 
				
				userRole = ESFUserESFUserRoleLocalServiceUtil.
						getESFUserESFUserRoleAllNationalStaff(esfMatchId);   
						 
				userRoles = ESFUserESFUserRoleLocalServiceUtil.
						getESFUserESFUserRoleAllNationalStaff(esfMatchId,
							searchContainer.getStart(), searchContainer.getEnd());

				%>
				<liferay-ui:search-container-results>
				<%
				results=ESFUserLocalServiceUtil.findStaffMatch( firstName, lastName, fiscalCode, esfMatchId, fitavId, searchContainer.getStart(), 
						searchContainer.getEnd());
				total=ESFUserLocalServiceUtil.countStaffMatch( firstName, lastName, fiscalCode, esfMatchId, fitavId);
						
				searchContainer.setTotal(total);
				searchContainer.setResults(results);
			%>
			
			</liferay-ui:search-container-results>
							
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			
			<liferay-ui:search-container-column-text property="lastName"
						name="lastName" />
					
					<liferay-ui:search-container-column-text  property="firstName"
						name="firstName" />
					
					<liferay-ui:search-container-column-text property="fiscalCode"
						name="fiscalCode" />
						
					<liferay-ui:search-container-column-text name="user-email">
			
					<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
			
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text property="jobTitle"
						name="jobTitle" />
						
					<liferay-ui:search-container-column-text name = "role-column" >
						<portlet:actionURL name="addESFNationalDelegation" var="addESFNationalDelegationURL">
							<portlet:param name="esfMatchId"
								value="<%=String.valueOf(esfMatchId)%>" /> 
							<portlet:param name="esfUserId"
								value="<%=String.valueOf(esfUser.getEsfUserId())%>" /> 
						</portlet:actionURL> 
						<aui:form action = "<%=addESFNationalDelegationURL%>">	
					<%
					List<ESFUserESFUserRole> userRoled = new ArrayList<ESFUserESFUserRole>();
					userRoled = ESFUserESFUserRoleLocalServiceUtil.
							findStaffRole(esfUser.getEsfUserId());
					
					if(1<userRoled.size()){	
					%>
							<aui:select name = "esfPartecipantTypeId" label = " " id = "role">
							<%
								for(ESFUserESFUserRole u : userRoled){
									Role r = RoleLocalServiceUtil.fetchRole(u.getEsfUserRoleId());
									if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.DOCTOR)){%>
									<aui:option value = "2" label = "doctor"></aui:option>
									<%}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.COACH)){%>
									<aui:option value = "3" label = "ct"></aui:option>
									<%}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.STAFF)){ %>
									<aui:option value = "4" label = "staff"></aui:option>
									<%}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.REFEREE)){ %>
									<aui:option value = "5" label = "referee"></aui:option>
									<%}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.DT)){ %>
									<aui:option value = "6" label = "DT"></aui:option>
									<%} %>
							</aui:select>
							<%}	%>	
							
					<%}else{ 
						
						int partecipantId = 0;
						String role = "";
						for(ESFUserESFUserRole u : userRoled){
							
							Role r = RoleLocalServiceUtil.fetchRole(u.getEsfUserRoleId());
							
							if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.DOCTOR)){
								partecipantId = 2;
								role = ESFKeys.ESFUserRoleMatch.DOCTOR;
							}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.COACH)){
								partecipantId = 3;
								role = ESFKeys.ESFUserRoleMatch.COACH;
							}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.STAFF)){
								partecipantId = 4;
								role = ESFKeys.ESFUserRoleMatch.STAFF;
							}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.REFEREE)){
								partecipantId = 5;
								role = ESFKeys.ESFUserRoleMatch.REFEREE;
							}else if(r.getName().equalsIgnoreCase(ESFKeys.ESFUserRoleMatch.DT)){
								partecipantId = 6;
								role = ESFKeys.ESFUserRoleMatch.DT;
							}
						
						}%>
					
					<aui:input name="esfPartecipantTypeId" value="<%=partecipantId %>" type="hidden"></aui:input>
					<aui:input name="role" value="<%=role %>" disabled="true" ></aui:input>
					<%} %>
					<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_STAFF) %>">	
				
						<aui:button type = "submit" value = "add" align="right" ></aui:button>
					</c:if>
					</aui:form>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>

<aui:button onClick="<%= backURL.toString() %>"  value="go-back"/><br/>