<%@page import="it.ethica.esf.model.ESFInstructsShootingDirector"%>
<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShootingDirectorQualification"%>
<%@include file="init.jsp"%>

<liferay-ui:error key="find-Suspensive" message="find-Suspensive" />
<liferay-ui:error key="error-assign-director" message="error-assign-director" />

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
List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

List<ESFInstructsShootingDirector> insts = ESFInstructsShootingDirectorLocalServiceUtil.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

portletSession.setAttribute("esfMatchId", esfMatchId);
PortletURL viewassURL = renderResponse.createRenderURL();
viewassURL.setParameter( "mvcPath", templatePath+"edit_staff.jsp");
viewassURL.setParameter( "organizationId", String.valueOf(currentOrganizationId));
viewassURL.setWindowState(WindowState.NORMAL);


PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter( "mvcPath", templatePath+"edit_staff");
iteratorURL.setParameter( "organizationId", String.valueOf(currentOrganizationId));
iteratorURL.setParameter("esfMatchId", String.valueOf("esfMatchId"));
iteratorURL.setWindowState(WindowState.NORMAL);

PortletURL urlPaginator= renderResponse.createRenderURL();  

urlPaginator.setParameter("mvcPath", templatePath+"edit_staff.jsp");
urlPaginator.setParameter("esfMatchId", String.valueOf(esfMatchId));

%>

<b><liferay-ui:message key="staff-assegn" /></b>
		
<div class="panel">

<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=viewassURL%>" curParam="selctedSatff">
<%
/*List<ESFPartecipant> esfUsersPartecipants = ESFPartecipantLocalServiceUtil.getESFPartecipantsByESFMatchId(esfMatchId);
int totalPartecipants = esfUsersPartecipants.size();
List<ESFUser> esfUsersIds = new ArrayList<ESFUser>();
if(esfUsersPartecipants.size() > 0){
	for(ESFPartecipant u : esfUsersPartecipants){
		if(u.getEsfPartecipantTypeId()!=ESFKeys.ESFNationalDelegationType.SHOOTER)
			esfUsersIds.add(ESFUserLocalServiceUtil.getESFUser(u.getEsfUserId()));
	}
}
*/
int tot = 0;
List<ESFNationalDelegation> del = new ArrayList<ESFNationalDelegation>();
del = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(esfMatchId, ESFKeys.ESFNationalDelegationType.REFEREE);
tot = del.size();

if(searchContainer.getEnd() < tot){
	del = del.subList(searchContainer.getStart() , searchContainer.getEnd() );
}else{
	del = del.subList(searchContainer.getStart() ,tot );
}


%>
	<liferay-ui:search-container-results
			results="<%= del %>"
			total="<%= tot %>" />
				
	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFNationalDelegation" modelVar="staff">
	
	<%
	ESFUser staffInfo = ESFUserLocalServiceUtil.fetchESFUser(staff.getEsfUserId());
	String firstName = "";
	String lastName = "";
	String mail = "";
	String role = ESFKeys.ESFUserRoleMatch.REFEREE;
	String refusalName = "";
	String refusalDate = "";
	String instrictCode = "";
	String dateAssign = "";
	
	if(Validator.isNotNull(staffInfo)){
		firstName = staffInfo.getFirstName();
		lastName = staffInfo.getLastName();
		mail = staffInfo.getUserEmail();
	}
	
	List<ESFNationalDelegation> delegation = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(staffInfo.getEsfUserId(), esfMatchId);
	
	if(0 < delegation.get(0).getTaskId()){
		refusalName = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(delegation.get(0).getTaskId()).getEsfInstructsShootingDirectorCode();
	}
	 
	
	
	if(Validator.isNotNull(delegation.get(0).getRefusalDate()) ){
		refusalDate = sdf.format(delegation.get(0).getRefusalDate());
	}

	
	if(0 < delegation.get(0).getTaskId() ){
		instrictCode = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(delegation.get(0).getTaskId()).getEsfInstructsShootingDirectorDesc();
	}
	
	if(Validator.isNotNull(delegation.get(0).getNominationDate())){
		dateAssign = sdf.format(delegation.get(0).getNominationDate());
	}
	
	if(Validator.isNotNull(delegation.get(0).getRefusal())){
		refusalName = delegation.get(0).getRefusal() ;
	}
	
	%>

	<liferay-ui:search-container-column-text name="lastName" value="<%=lastName %>" />
					
	<liferay-ui:search-container-column-text name="firstName" value="<%=firstName %>" />

	 <liferay-ui:search-container-column-text name="userEmail" value="<%=mail %>" />
					<%
					
					/*	ESFPartecipant partecipant = 
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
							}*/
							
					%>
	<liferay-ui:search-container-column-text name="role" value="<%=role%>" />
	
	<liferay-ui:search-container-column-text name="esf-date-assign" value="<%=dateAssign %>" />
	
	<liferay-ui:search-container-column-text name="instructors" value="<%= instrictCode%>"/>
	
	<liferay-ui:search-container-column-text name="refusalDate" value="<%=refusalDate%>" />
	
	<liferay-ui:search-container-column-text name="refusalMotivation" value="<%=refusalName%>" />

	<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPDATE_STAFF_REMOVE) %>">	
	
	<liferay-ui:search-container-column-jsp path='<%=templatePath + "esfStaffSelected_actions.jsp"%>' align="right" />
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
			
				<aui:select  name="shDtId" inlineField="<%=true%>" label="qualification" >
					<aui:option value="0"  label="-"></aui:option>
				<%for(ESFShootingDirectorQualification s : shDts){%>
					<aui:option value="<%=s.getEsfShootingDirectorQualificationId()%>"  label="<%=s.getEsfShootingDirectorQualificationDesc()%>"></aui:option>
				<%}%>
			</aui:select>
			
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<portlet:actionURL name="addESFPartecipant" var="addESFPartecipantURL">
	<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" /> 
</portlet:actionURL> 

<liferay-ui:search-container emptyResultsMessage="no-results" curParam="staff" iteratorURL="<%=urlPaginator %>"> 
		 <%
			 	String firstName = ParamUtil.getString(request, "firstName");
				String lastName = ParamUtil.getString(request, "lastName");
				
				long shDtId = ParamUtil.getLong(request, "shDtId");
				
				viewassURL.setParameter("firstName", String.valueOf(firstName));
				viewassURL.setParameter("lastName", String.valueOf(lastName));
				viewassURL.setParameter("shDtId", String.valueOf(shDtId));
				
		%>
				
	<liferay-ui:search-container-results
		results="<%=ESFUserLocalServiceUtil.findDirectorByMatch( firstName, lastName, esfMatchId, shDtId, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFUserLocalServiceUtil.countDirectorByMatch( firstName, lastName, esfMatchId, shDtId)%>">
	</liferay-ui:search-container-results>
				
	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			
			<liferay-ui:search-container-column-text property="lastName" name="lastName" />
					
			<liferay-ui:search-container-column-text  property="firstName" name="firstName" />
					
			<liferay-ui:search-container-column-text property="fiscalCode" 	name="fiscalCode" />

			<liferay-ui:search-container-column-text property="userEmail" name="userEmail" />

			<liferay-ui:search-container-column-text property="jobTitle" name="jobTitle" />
						
			<liferay-ui:search-container-column-text name = "role-column" >
						
			<aui:form action = "<%=addESFPartecipantURL%>">	
				<div class="btn-field-align">
					<aui:input name="esfPartecipantTypeId" value="<%=ESFKeys.ESFNationalDelegationType.REFEREE %>" type="hidden"></aui:input>
					<aui:input name="esfUserId" value="<%=String.valueOf(esfUser.getEsfUserId()) %>" type="hidden"></aui:input>
					<aui:input name="role" value="<%=ESFKeys.ESFUserRoleMatch.REFEREE %>" disabled="true" inlineField="true" ></aui:input>
				<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPDATE_STAFF_ADD) %>">
					<aui:button type = "submit" value = "add" align="right" ></aui:button>
				</c:if>
				</div>	
			</aui:form>
			</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

