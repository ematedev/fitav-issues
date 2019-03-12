
<%@include file="../init.jsp"%>

<%	
	String backUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	String namespace = renderResponse.getNamespace();
	List<ESFNationalDelegation> officialPartecipants = 
									new ArrayList<ESFNationalDelegation>();
	portletSession.setAttribute("backToGeneralUrl", backUrl);
	String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	int urlEndIndex = currentUrlPage.indexOf('?');
	String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
		
	if(urlEndIndex != -1){
		backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
	}
	portletDisplay.setURLBack(backtoViewUrl);

	int officialPartecipantsSize = 0;
	int shooterPartecipantsSize = 0;


	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	
	List<ESFNationalDelegation> shooter = new ArrayList<ESFNationalDelegation>();
	List<Long> shooterId = new ArrayList<Long>();
	
	
	List<ESFNationalDelegation> shooterPartecipants = 
				ESFNationalDelegationLocalServiceUtil.
						getESFNationalDelegationByMatchId_PartecipantTypeId(
							esfMatchId,
								ESFKeys.ESFNationalDelegationType.SHOOTER);
	
	for(ESFNationalDelegation nd : shooterPartecipants){
		
		if(!shooterId.contains(nd.getEsfUserId())){
			shooter.add(nd);
		}
		shooterId.add(nd.getEsfUserId());
	}
	
	List<ESFNationalDelegation> officialPartecipantsImmutableList= 
							ESFNationalDelegationLocalServiceUtil.
										getESFNationalDelegationByESFMatchId(esfMatchId);

	for(ESFNationalDelegation s : officialPartecipantsImmutableList){
		if (s.getEsfPartecipantTypeId() != ESFKeys.ESFNationalDelegationType.SHOOTER){
			officialPartecipants.add(s);
		}
	}
	
	
	
	if(Validator.isNotNull(shooter)){
		shooterPartecipantsSize = shooter.size();
	}
	
	if(Validator.isNotNull(officialPartecipants)){
		officialPartecipantsSize = officialPartecipants.size();
	}
	String totalDay="0";
%>
	<portlet:renderURL var="backURL"
		windowState="<%=WindowState.NORMAL.toString()%>">
		<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
		<portlet:param name="organizationId"
			value="<%=String.valueOf(currentOrganizationId)%>" />
	</portlet:renderURL>
	
<portlet:actionURL name = "modifyESFNationalDelegationDates" var="modifyESFNationalDelegationDates">
	<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
</portlet:actionURL>

<aui:form action="<%=modifyESFNationalDelegationDates%>">
		<div id="shooter-partecipant">
			<h1>	<liferay-ui:message key="shooters" /> 	</h1>	
		<h4>
			<span class="portlet-title-text"> 
					(<liferay-ui:message key="total-shooter" />
					 : <%=shooterPartecipantsSize%>)
			</span>
		</h4>
				<liferay-ui:search-container emptyResultsMessage="no-results">
					<liferay-ui:search-container-results
						results="<%= shooter%>"
						total="<%=shooterPartecipantsSize%>" />
					<liferay-ui:search-container-row
						className="it.ethica.esf.model.ESFNationalDelegation" modelVar="esfNationalDelegation">
		
						<%
						ESFUser esfUser=ESFUserLocalServiceUtil.fetchESFUser(
													esfNationalDelegation.getEsfUserId());
						
						Date leave=esfNationalDelegation.getLeaveDate();
						Date returnDate=esfNationalDelegation.getReturnDate();
						
						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
						if(Validator.isNull(leave)){
							leave = match.getStartDate();
						}
						
						if(Validator.isNull(returnDate)){
							returnDate = match.getEndDate();
						}
							
						totalDay = 
							String.valueOf(
								Days.daysBetween(new DateTime(leave),
								 		new DateTime(returnDate)).getDays());
						
						long esfSportTypeId = esfNationalDelegation.
															getEsfSportTypeId();
						String esfSportType = "";
						if(esfSportTypeId != 0){
							esfSportType = 
										ESFSportTypeLocalServiceUtil.
												getESFSportType(esfSportTypeId).getName();
						}
						
						
						String specialitys = "";
						List<ESFNationalDelegation> delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(esfUser.getEsfUserId(), esfMatchId);

						for(ESFNationalDelegation del : delegations){
							if(del.getEsfPartecipantTypeId() == ESFKeys.ESFNationalDelegationType.SHOOTER){
								long s = del.getEsfSportTypeId();
								String speciality = "";
								if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(s)) && 
										Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(s).getName())){
									speciality = ESFSportTypeLocalServiceUtil.fetchESFSportType(s).getName();
								}
								
								specialitys = specialitys+ " - "+ speciality ;
		
							}
						}
						if(Validator.isNotNull(specialitys)){
							specialitys = specialitys.substring(2).trim();
						}
						
						%>
						
						<liferay-ui:search-container-column-text name="shooter"
								value='<%= esfUser.getFirstName()+" "+esfUser.getLastName()%>' />
						
						<liferay-ui:search-container-column-text name="user-email">
						
						<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
						
						</liferay-ui:search-container-column-text>
					
						<liferay-ui:search-container-column-text name="sport-type"
							value='<%= specialitys%>' />
							
						<liferay-ui:search-container-column-jsp name="leave-date" path='<%=templatePath + "changeLeaveDate.jsp"%>'>
						</liferay-ui:search-container-column-jsp>
						
						<liferay-ui:search-container-column-jsp name="return-date" path='<%=templatePath + "changeReturnDate.jsp"%>'>
						</liferay-ui:search-container-column-jsp>
					
		
						<liferay-ui:search-container-column-text name="total-day"
							value='<%=totalDay%>' />
						
						<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_VIEW_SHOOTER) %>">	
						
							<liferay-ui:search-container-column-text name="edit">
								<portlet:renderURL var="editURL">
									<portlet:param name="esfUserId"
										value="<%= String.valueOf(esfUser.getEsfUserId())%>" />
									<portlet:param name="esfMatchId"
										value="<%= String.valueOf(esfMatchId)%>" />
									<portlet:param name="organizationId"
										value="<%= String.valueOf(currentOrganizationId)%>" />
									<portlet:param name="backToGeneralUrl"
										value="<%= backUrl%>" />
									<portlet:param name="mvcPath"
										value='<%="/html/esfnationalmatch/tabs/edit_esfShooter.jsp"%>' />
									<portlet:param name="op" value="updAddr" />
								</portlet:renderURL>
									
								<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
												href = "<%=editURL%>" value="view">
								</aui:button>
				
							</liferay-ui:search-container-column-text>
						</c:if>	
						
						
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
	
		</div>
	
		<div id="official-partecipant">
		<h1>
			<liferay-ui:message key="staff" />
		</h1>	
		<h4>
			(<span class="portlet-title-text"> 
				<liferay-ui:message key="total-official" />
				 : <%=officialPartecipantsSize%>
			</span>)
		</h4>
			<liferay-ui:search-container emptyResultsMessage="no-results">
		
					<liferay-ui:search-container-results
						results="<%=officialPartecipants %>"
						total="<%=officialPartecipantsSize%>" />

					<liferay-ui:search-container-row
						className="it.ethica.esf.model.ESFNationalDelegation" modelVar="esfNationalDelegationStaff">
		
						<%
						ESFUser esfUser=ESFUserLocalServiceUtil.fetchESFUser(
								esfNationalDelegationStaff.getEsfUserId());
						
						Date leave=esfNationalDelegationStaff.getLeaveDate();
						Date returnDate=esfNationalDelegationStaff.getReturnDate();
						
						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
						if(Validator.isNull(leave)){
							leave = match.getStartDate();
						}
						
						if(Validator.isNull(returnDate)){
							returnDate = match.getEndDate();
						}
							
						totalDay = 
							String.valueOf(
								Days.daysBetween(new DateTime(leave),
								 		new DateTime(returnDate)).getDays());
						
						ESFPartecipantType ptype = ESFPartecipantTypeLocalServiceUtil.
													fetchESFPartecipantType(
														esfNationalDelegationStaff.
															getEsfPartecipantTypeId());
						String role = "";
						if(Validator.isNotNull(ptype)){
							role = ptype.getName();
						}
						
						%>
						<liferay-ui:search-container-column-text name="shooter"
							value='<%= esfUser.getFirstName()+" "+esfUser.getLastName()%>' />
						
						<liferay-ui:search-container-column-text name="user-email">
		
							<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
						</liferay-ui:search-container-column-text>
					
						<liferay-ui:search-container-column-text name="role"
							value="<%=res.getString(role)%>" />

						<liferay-ui:search-container-column-jsp name="leave-date" path='<%=templatePath + "changeLeaveDate.jsp"%>'>
						</liferay-ui:search-container-column-jsp>
						
						<liferay-ui:search-container-column-jsp name="return-date" path='<%=templatePath + "changeReturnDate.jsp"%>'>
						</liferay-ui:search-container-column-jsp>	

						<liferay-ui:search-container-column-text name="total-day"
							value='<%=totalDay%>' />
						
						<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_VIEW_SHOOTER) %>">	
							
							<liferay-ui:search-container-column-text name="edit">

								<portlet:renderURL var="editURL">
									<portlet:param name="esfUserId"
										value="<%= String.valueOf(esfUser.getEsfUserId())%>" />
									<portlet:param name="esfMatchId"
										value="<%= String.valueOf(esfMatchId)%>" />
									<portlet:param name="organizationId"
										value="<%= String.valueOf(currentOrganizationId)%>" />
									<portlet:param name="backToGeneralUrl"
										value="<%= backUrl%>" />
									<portlet:param name="mvcPath"
										value='<%="/html/esfnationalmatch/tabs/edit_esfShooter.jsp"%>' />
									<portlet:param name="op" value="updAddr" />
								</portlet:renderURL>
									
								<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
												href = "<%=editURL%>" value="view">
								</aui:button>

							</liferay-ui:search-container-column-text>
						</c:if>
							
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
		</div>
<br></br>
<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_UPDATE_ITINERARY) %>">
	<aui:button type="submit" value="save" />
</c:if>	
		
<aui:button onClick="<%= backURL.toString() %>" value="go-back" />
</aui:form>
