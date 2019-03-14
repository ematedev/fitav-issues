<%@include file="init.jsp"%>

<%
ESFTournament esfTournament = ESFTournamentLocalServiceUtil.getESFTournament(esfTournamentId);
%>

<h3><%= esfTournament.getTitle() %> <small><%= esfTournament.getDescription() %></small></h3>

<!-- ESFNationalDelegationShooters -->
<p class="lead"><liferay-ui:message key="national-shooter"></liferay-ui:message></p>

<portlet:renderURL var="addESFNationalDelegationShooterURL">
	<portlet:param name="esfTournamentId"
		value="<%=String.valueOf(esfTournamentId)%>"/>
	<portlet:param name="backURL" value="<%= redirect %>"/>
	<portlet:param name="className" value="<%= ESFNational.class.getName() %>"/>
	<portlet:param name="mvcPath" value='<%= templatePath + "delegation/select_esfUser.jsp" %>'/>
</portlet:renderURL>

<aui:button onClick="<%= addESFNationalDelegationShooterURL.toString() %>"
	value="add-national-delegation-shooter" />
	
<liferay-ui:search-container
	id="0"
	curParam="0"
	delta="5"
	emptyResultsMessage="no-delegation-were-found">

	<liferay-ui:search-container-results
		results="<%= ESFNationalDelegationLocalServiceUtil.getESFNationalDelegation(
				esfTournamentId, ESFNational.class.getName(),
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFNationalDelegationLocalServiceUtil.getESFNationalDelegation(
				esfTournamentId, ESFNational.class.getName()).size() %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFNationalDelegation"
		modelVar="esfNationalDelegation">

		<%
		ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfNationalDelegation.getEsfUserId());
		ESFGun esfGun1 = ESFGunLocalServiceUtil.fetchESFGun(esfNationalDelegation.getEsfGunId1());
		ESFGun esfGun2 = ESFGunLocalServiceUtil.fetchESFGun(esfNationalDelegation.getEsfGunId2());		
		%>

		<liferay-ui:search-container-column-text name="Name"
			value="<%= esfUser.getLastName() + StringPool.SPACE + esfUser.getFirstName() %>" />
		<liferay-ui:search-container-column-text name="leave-date" 
				value="<%= ManageDate.DateToString(esfNationalDelegation.getLeaveDate()) %>"/>
		<liferay-ui:search-container-column-text name="return-date"
				value="<%= ManageDate.DateToString(esfNationalDelegation.getReturnDate()) %>" />
		<liferay-ui:search-container-column-text name="first-gun"
			value="<%= esfGun1 == null ? StringPool.BLANK : esfGun1.getFullName() %>" />
		<liferay-ui:search-container-column-text name="second-gun"
			value="<%= esfGun2 == null ? StringPool.BLANK : esfGun2.getFullName() %>" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "delegation/esfnationaldelegation_actions.jsp"%>'
			align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>

<!-- ESFNationalDelegationStaff -->
<p class="lead"><liferay-ui:message key="national-staff"></liferay-ui:message></p>

<portlet:renderURL var="addESFNationalDelegationCoachURL">
	<portlet:param name="esfTournamentId"
		value="<%=String.valueOf(esfTournamentId)%>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
	<portlet:param name="className" value="<%= ESFUserRole.class.getName() %>"/>
	<portlet:param name="classPK" value="<%= String.valueOf(coachClassPK) %>"/>
	<portlet:param name="mvcPath" value='<%= templatePath + "delegation/select_esfUser.jsp" %>'/>
</portlet:renderURL>

<aui:button onClick="<%= addESFNationalDelegationCoachURL.toString() %>"
	value="add-national-delegation-coach" />
	
<liferay-ui:search-container
	id="1"
	curParam="1"
	delta="5"
	emptyResultsMessage="no-delegation-were-found">

	<liferay-ui:search-container-results
		results="<%= ESFNationalDelegationLocalServiceUtil.getESFNationalDelegation(
				esfTournamentId, ESFUserRole.class.getName(),
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFNationalDelegationLocalServiceUtil.getESFNationalDelegation(
				esfTournamentId, ESFUserRole.class.getName()).size() %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFNationalDelegation"
		modelVar="esfNationalDelegation">

		<%
		ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfNationalDelegation.getEsfUserId());
		ESFSportType esfSportType = ESFSportTypeLocalServiceUtil.fetchESFSportType(esfNationalDelegation.getEsfSportTypeId());
		boolean isCoach = esfNationalDelegation.getClassPK() == coachClassPK;
		%>

		<liferay-ui:search-container-column-text name="Name"
			value="<%= esfUser.getLastName() + StringPool.SPACE + esfUser.getFirstName() %>" />
		<liferay-ui:search-container-column-text name="leave-date" 
				value="<%= ManageDate.DateToString(esfNationalDelegation.getLeaveDate()) %>"/>
		<liferay-ui:search-container-column-text name="return-date"
				value="<%= ManageDate.DateToString(esfNationalDelegation.getReturnDate()) %>" />
		<liferay-ui:search-container-column-text name="role"
			value='<%= isCoach ? ("ct" + (esfSportType != null ? esfSportType.getName() : StringPool.BLANK)) : "doctor" %>' />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "delegation/esfnationaldelegation_actions.jsp"%>'
			align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>

<aui:button-row>
	<aui:button type="cancel" onClick="<%= viewURL %>" value="back"></aui:button>
</aui:button-row>

