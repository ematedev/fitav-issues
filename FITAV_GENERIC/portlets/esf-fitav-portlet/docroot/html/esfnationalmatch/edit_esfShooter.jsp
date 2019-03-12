<%@include file="init.jsp"%>

<portlet:renderURL var="backURL"
		windowState="<%=WindowState.NORMAL.toString()%>">
		<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
		
	</portlet:renderURL>
	<aui:button onClick="<%= backURL.toString() %>" value="back" /><br/>

<%	
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 

	String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	int urlEndIndex = currentUrlPage.indexOf('?');
	String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	
	if(urlEndIndex != -1){
		backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
	}
	portletDisplay.setURLBack(backtoViewUrl);

	PortletURL viewassURL = renderResponse.createRenderURL();
	
	viewassURL.setParameter(
		"mvcPath",templatePath + "edit_esfShooter.jsp");
	viewassURL.setParameter(
		"organizationId", String.valueOf(currentOrganizationId));
	viewassURL.setWindowState(WindowState.NORMAL);
	
	if(esfMatchId == 0){
		esfMatchId = ParamUtil.getLong(request, "esfMatchId");
	}
	
	List<ESFUser> esfUsers = 
					ESFUserLocalServiceUtil.
						findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
								esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);

	int totalPartecipants = esfUsers.size();
	
	List<Long>esfNatiIds = new ArrayList<Long>();
	
	List<ESFNationalDelegation>esfNationalDelegations = 
					ESFNationalDelegationLocalServiceUtil.
							getESFNationalDelegations(0, 
								ESFNationalDelegationLocalServiceUtil.
										getESFNationalDelegationsCount());
	
	if(esfNationalDelegations.size() > 0){
		
		for(ESFNationalDelegation e : esfNationalDelegations){
			if(e.getEsfMatchId()==esfMatchId){
				esfNatiIds.add(e.getEsfUserId());
			}
		}
	}
	
	String firstName = ParamUtil.getString(request, "firstName");
	String lastName = ParamUtil.getString(request, "lastName");
	String fiscalCode = ParamUtil.getString(request, "fiscalCode");
	
	viewassURL.setParameter("firstName", String.valueOf(firstName));
	viewassURL.setParameter("lastName", String.valueOf(lastName));
	viewassURL.setParameter("fiscalCode", String.valueOf(fiscalCode));
	
%>


		<liferay-ui:error key="date-match-message"
			message="date-match-message" />
			
<liferay-portlet:renderURL varImpl="searchShootersURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "edit_esfShooter.jsp"%>' />
	<portlet:param name="esfMatchId"
		value='<%=String.valueOf(esfMatchId)%>' />
</liferay-portlet:renderURL>
		
		<b>
			<liferay-ui:message key="user-partecipant-assegn" />
		</b>
		
		<div class="panel">

		<liferay-ui:search-container emptyResultsMessage="no-results" 
				iteratorURL="<%=viewassURL%>" curParam="AllShooterPartecipants">

				<liferay-ui:search-container-results
					results="<%= ESFUserLocalServiceUtil.
									findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
										esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER,searchContainer.getStart(),searchContainer.getEnd()) %>"
					total="<%= totalPartecipants %>" />
				
				<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
					
					<liferay-ui:search-container-column-text property="lastName"
						name="last-name" />
						
					<liferay-ui:search-container-column-text property="firstName"
						name="first-name" />

					<liferay-ui:search-container-column-text property="userEmail"
						name="email" />

					<liferay-ui:search-container-column-text property="fiscalCode"
						name="fiscal-code" />

					<liferay-ui:search-container-column-text property="jobTitle"
						name="job-title" />

					<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_SHOOTER_DELETE) %>">	
						<liferay-ui:search-container-column-jsp
							path='<%=templatePath +
								"esfShooterSelected_actions.jsp"%>'
							align="right" />
					</c:if>		
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		
		</div>
		
		<br/>
		<br/>
		<br/>
		
		<aui:form action="<%=searchShootersURL%>" method="get">
			<liferay-portlet:renderURLParams varImpl="searchShootersURL" />
			<div class="search-form">
				<span class="aui-search-bar"> 
				
					<aui:input inlineField="<%=true%>" label="" name="lastName"
						placeholder="last-name" size="" title="search-entries" />
						
					<aui:input inlineField="<%=true%>" label="" name="firstName"
						placeholder="first-name" size="" title="search-entries" />
						
					<aui:input inlineField="<%=true%>" label="" name="fiscalCode"
						placeholder="fiscal-code" size="" title="search-entries" />	
					<aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>
		
		<aui:button-row cssClass="esfmatch-admin-buttons">

			<portlet:renderURL var="backMatch"  windowState="<%=WindowState.NORMAL.toString()%>">
				<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
				<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
				<portlet:param name="op" value="addAddr" />
			</portlet:renderURL>

			<aui:button type="cancel" onClick="<%=backMatch%>" value="done">
			</aui:button>

		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=viewassURL %>" 
			curParam="AllShooters">
		
			<liferay-ui:search-container-results
				results="<%= ESFUserLocalServiceUtil.
								getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(esfMatchId,
									firstName, lastName, fiscalCode,1,currentOrganizationId,
									searchContainer.getStart(),searchContainer.getEnd())%>"
				total="<%= ESFUserLocalServiceUtil
						.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
								esfMatchId, firstName, lastName, fiscalCode, 1,
								currentOrganizationId).size()%>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			
				<liferay-ui:search-container-column-text property="lastName"
						name="last-name" />
			
				<liferay-ui:search-container-column-text property="firstName"
						name="first-name" />
			

					<liferay-ui:search-container-column-text property="userEmail"
						name="email" />

					<liferay-ui:search-container-column-text property="fiscalCode"
						name="fiscal-code" />

					<liferay-ui:search-container-column-text property="jobTitle"
						name="job-title" />


			<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_SHOOTER_ADD) %>">	
				<liferay-ui:search-container-column-jsp
					path='<%=templatePath +
								"esfShooter_actions.jsp"%>'
					align="right" />
			</c:if>
					
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
