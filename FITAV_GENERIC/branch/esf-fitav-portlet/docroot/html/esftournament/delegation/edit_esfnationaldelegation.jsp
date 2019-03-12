<%@page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@include file="init.jsp"%>

<%
ESFNationalDelegation esfNationalDelegation = null;
ESFTournament esfTournament = null;
ESFUser esfUser = null;

Calendar currDateCal = CalendarFactoryUtil.getCalendar();
String currDate = ManageDate.CalendarToString(currDateCal);

long esfUserId = ParamUtil.getLong(request, "esfUserId");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

int esfNationalDelegationType = 0;

if (className.equals(ESFNational.class.getName())) {

	esfNationalDelegationType = ESFKeys.ESFNationalDelegationType.SHOOTER;
}
else if (className.equals(ESFUserRole.class.getName())) {

	esfNationalDelegationType = ESFKeys.ESFNationalDelegationType.STAFF;
}

if (esfTournamentId > 0 && esfUserId > 0) {

	ESFNationalDelegationPK esfNationalDelegationPK =
			new ESFNationalDelegationPK(esfTournamentId, esfUserId);
	esfNationalDelegation = ESFNationalDelegationLocalServiceUtil
			.getESFNationalDelegation(esfNationalDelegationPK);

	esfTournament = ESFTournamentLocalServiceUtil.fetchESFTournament(
			esfNationalDelegation.getEsfTournamentId());

	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
}
%>

<portlet:actionURL name="updateESFNationalDelegation" var="updateESFNationalDelegationURL" />

<aui:form action="<%= updateESFNationalDelegationURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfNationalDelegation %>" model="<%= ESFNationalDelegation.class %>" />

	<aui:input name="esfTournamentId" type="hidden"></aui:input>
	<aui:input name="esfUserId" type="hidden"></aui:input>
	<aui:input name="className" type="hidden"></aui:input>
	<aui:input name="classPK" type="hidden"></aui:input>

<%-- 	<aui:input name="leaveDate"></aui:input> --%>

	<label class="control-label" for="<portlet:namespace/>leaveDate">
		<liferay-ui:message key="leave-date" />
	</label>
	<input name="<portlet:namespace/>leaveDate" id="datepicker" type="text" />
	
	<label class="control-label" for="<portlet:namespace/>returnDate">
		<liferay-ui:message key="return-date" />
	</label>
	<input name="<portlet:namespace/>returnDate" id="datepicker2" type="text" />

<%-- 	<aui:input name="returnDate"></aui:input> --%>

	<c:choose>
		<c:when test="<%= esfNationalDelegationType == ESFKeys.ESFNationalDelegationType.SHOOTER %>">

			<aui:select name="esfGunId1"
				helpMessage="gun1-and-gun2-cannot-be-equals"
				showEmptyOption="true">
				<%
				List<ESFGun> esfGuns = ESFGunLocalServiceUtil.getESFGunsByUserId(esfUserId);

				for (ESFGun esfGun : esfGuns) {
				%>

				<aui:option label="<%= esfGun.getFullName() %>"
					value="<%= esfGun.getEsfGunId() %>"></aui:option>

				<% } %>
			</aui:select>

			<aui:select name="esfGunId2"
				helpMessage="gun1-and-gun2-cannot-be-equals"
				showEmptyOption="true">
				<%
				List<ESFGun> esfGuns = ESFGunLocalServiceUtil.getESFGunsByUserId(esfUserId);

				for (ESFGun esfGun : esfGuns) {
				%>

				<aui:option label="<%= esfGun.getFullName() %>"
					value="<%= esfGun.getEsfGunId() %>"></aui:option>

				<% } %>
			</aui:select>

		</c:when>
		<c:when test="<%= esfNationalDelegationType == ESFKeys.ESFNationalDelegationType.STAFF %>">

			<aui:select name="esfSportTypeId" showEmptyOption="true">
				<%
				List<ESFSportType> esfSportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

				for (ESFSportType esfSportType : esfSportTypes) {
				%>

				<aui:option label="<%= esfSportType.getName() %>"
					value="<%= esfSportType.getEsfSportTypeId() %>"></aui:option>

				<% } %>
			</aui:select>

		</c:when>
	</c:choose>


	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= delegationURL %>"></aui:button>
	</aui:button-row>
</aui:form>

<aui:script>
$(function() {
	$( "#datepicker" ).datepicker();
	$( "#datepicker" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
	$( "#datepicker" ).datepicker( "setDate", '<%= esfTournament != null?ManageDate.DateToString(esfTournament.getStartDate()) : currDate %>' );
	$( "#datepicker2" ).datepicker();
	$( "#datepicker2" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
	$( "#datepicker2" ).datepicker( "setDate", '<%= esfTournament != null?ManageDate.DateToString(esfTournament.getEndDate()) : currDate %>' );
});
</aui:script>
