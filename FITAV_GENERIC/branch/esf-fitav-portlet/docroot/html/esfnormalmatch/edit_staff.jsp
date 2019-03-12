
<%@include file="init.jsp"%>

<portlet:renderURL var="viewURLStaff">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
	<portlet:param name="organizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
</portlet:renderURL>


<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
</portlet:renderURL>
	<aui:button onClick="<%= backURL.toString() %>"  value="done"/><br/>

<%
portletSession.setAttribute("esfMatchId", esfMatchId);
PortletURL viewassURL = renderResponse.createRenderURL();
viewassURL.setParameter(
		"mvcPath", templatePath+"edit_staff.jsp");
viewassURL.setParameter(
		"organizationId", String.valueOf(currentOrganizationId));
viewassURL.setWindowState(WindowState.NORMAL);


PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter(
		"mvcPath", templatePath+"edit_staff");
iteratorURL.setParameter(
	"	organizationId", String.valueOf(currentOrganizationId));
iteratorURL.setParameter("esfMatchId", String.valueOf("esfMatchId"));
iteratorURL.setWindowState(WindowState.NORMAL);

PortletURL urlPaginator= renderResponse.createRenderURL();  

urlPaginator.setParameter("mvcPath", templatePath+"edit_staff.jsp");
urlPaginator.setParameter("esfMatchId", String.valueOf(esfMatchId));

%>

		<b>
			<liferay-ui:message key="staff-assegn" />
		</b>
		
		<div class="panel">

			<liferay-ui:search-container emptyResultsMessage="no-results" 
				iteratorURL="<%=viewassURL%>" curParam="selctedSatff">
				<%
				List<ESFPartecipant> esfUsersPartecipants = ESFPartecipantLocalServiceUtil.
				getESFPartecipantsByESFMatchId(esfMatchId);
				
					int totalPartecipants = esfUsersPartecipants.size();
				
					List<ESFUser> esfUsersIds = new ArrayList<ESFUser>();
					if(esfUsersPartecipants.size() > 0){
						for(ESFPartecipant u : esfUsersPartecipants){
							if(u.getEsfPartecipantTypeId()!=ESFKeys.ESFNationalDelegationType.SHOOTER)
								esfUsersIds.add(ESFUserLocalServiceUtil.getESFUser(u.getEsfUserId()));
							}
						}
				%>
				<liferay-ui:search-container-results
					results="<%= esfUsersIds %>"
					total="<%= esfUsersIds.size() %>" />
				
				<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

					<liferay-ui:search-container-column-text property="lastName"
						name="last-name" />
					
					<liferay-ui:search-container-column-text property="firstName"
						name="first-name" />

					<liferay-ui:search-container-column-text property="userEmail"
						name="email" />
					<%
					
						ESFPartecipant partecipant = 
							ESFPartecipantLocalServiceUtil.
									getESFPartecipantByESFMatchId_ESFUserId(
										esfMatchId, esfUser.getEsfUserId());
								
						ESFPartecipantType ptype = null;
							if(Validator.isNotNull(partecipant) && Validator.isNotNull(partecipant.getEsfPartecipantTypeId())){
								ptype = ESFPartecipantTypeLocalServiceUtil.
											getESFPartecipantType(partecipant.getEsfPartecipantTypeId());
							}
							
							String role = "";
							if(Validator.isNotNull(ptype)){
								role = ptype.getName();
							}
							if(Validator.isNotNull(role)){
								role = res.getString(role);
							}
							
					%>
					<liferay-ui:search-container-column-text name="role"
							value="<%=role%>" />	

					<liferay-ui:search-container-column-text property="fiscalCode"
						name="fiscal-code" />

					<liferay-ui:search-container-column-text property="jobTitle"
						name="job-title" />

					<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPDATE_STAFF_REMOVE) %>">	
	
						<liferay-ui:search-container-column-jsp
						path='<%=templatePath +
								"esfStaffSelected_actions.jsp"%>'
						align="right" />
					</c:if>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>

		<br/>
		<br/>

								
	<liferay-portlet:renderURL varImpl="searchURL">
		<portlet:param name="mvcPath"
			value='<%=templatePath + "edit_staff.jsp"%>' />
	 	<portlet:param name="esfMatchId"
			value='<%=String.valueOf(esfMatchId)%>' />
	</liferay-portlet:renderURL>

		
		<aui:form action="<%= searchURL %>" method="get">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
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

		<liferay-ui:search-container emptyResultsMessage="no-results" curParam="staff" iteratorURL="<%=urlPaginator %>"> 
		 <%
			 	String firstName = ParamUtil.getString(request, "firstName");
				String lastName = ParamUtil.getString(request, "lastName");
				String fiscalCode = ParamUtil.getString(request, "fiscalCode");
				
				viewassURL.setParameter("firstName", String.valueOf(firstName));
				viewassURL.setParameter("lastName", String.valueOf(lastName));
				viewassURL.setParameter("fiscalCode", String.valueOf(fiscalCode));
				
				%>
				
				<liferay-ui:search-container-results
					results="<%=ESFUserLocalServiceUtil.findStaffNormalMatch( firstName, lastName, fiscalCode, esfMatchId, searchContainer.getStart(), 
							searchContainer.getEnd())%>"
					total="<%=ESFUserLocalServiceUtil.countStaffNormalMatch( firstName, lastName, fiscalCode, esfMatchId)%>">
				</liferay-ui:search-container-results>
				
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			
			<liferay-ui:search-container-column-text property="lastName"
						name="lastName" />
					
			<liferay-ui:search-container-column-text  property="firstName"
						name="firstName" />
					
			<liferay-ui:search-container-column-text property="fiscalCode"
						name="fiscalCode" />

			<liferay-ui:search-container-column-text property="userEmail"
						name="userEmail" />

			<liferay-ui:search-container-column-text property="jobTitle"
						name="jobTitle" />
						
						<liferay-ui:search-container-column-text name = "role-column" >
						<portlet:actionURL name="addESFPartecipant" var="addESFPartecipantURL">
							<portlet:param name="esfMatchId"
								value="<%=String.valueOf(esfMatchId)%>" /> 
							<portlet:param name="esfUserId"
								value="<%=String.valueOf(esfUser.getEsfUserId())%>" /> 
						</portlet:actionURL> 
						
						<aui:form action = "<%=addESFPartecipantURL%>">	
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
							} 
						
						}%>
					
					<aui:input name="esfPartecipantTypeId" value="<%=partecipantId %>" type="hidden"></aui:input>
					<aui:input name="role" value="<%=role %>" disabled="true" ></aui:input>
					<%} %>
							<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPDATE_STAFF_ADD) %>">	
	
								<aui:button type = "submit" value = "add" align="right" ></aui:button>
							</c:if>
						</aui:form>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>

