<%@include file="init.jsp"%>

<%
String namespace = renderResponse.getNamespace();

ESFTournament esfTournament = null;

if (esfTournamentId > 0) {
	esfTournament =
		ESFTournamentLocalServiceUtil.getESFTournament(esfTournamentId);
}

List<ESFOrganization> associations =
	ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId);

List<ESFTeam> esfTeams = Collections.emptyList();

int[] esfTeamIndexes = null;

String teamIndexesParam =
	ParamUtil.getString(request, "esfTeamIndexes");
// boolean isNational = ParamUtil.getBoolean(request, "isNational");

if (Validator.isNotNull(teamIndexesParam)) {
	esfTeams = new ArrayList<ESFTeam>();

	esfTeamIndexes = StringUtil.split(teamIndexesParam, 0);

	for (int esfTeamIndexe : esfTeamIndexes) {
		esfTeams.add(new ESFTeamImpl());
	}
}
else {
	if (esfTournament != null && esfTournament.isIsTeamMatch()) {
		esfTeams =
			ESFTeamLocalServiceUtil.findByTournament(esfTournament.getEsfTournamentId());

		esfTeamIndexes = new int[esfTeams.size()];

		for (int i = 0; i < esfTeams.size(); i++) {
			esfTeamIndexes[i] = i;
		}
	}

	if (esfTeams.isEmpty()) {
		esfTeams = new ArrayList<ESFTeam>();

		esfTeams.add(new ESFTeamImpl());
		esfTeamIndexes = new int[] {
			0
		};
	}

	if (esfTeamIndexes == null) {
		esfTeamIndexes = new int[0];
	}
}
%>

<portlet:renderURL var="viewURL"
	windowState="<%= WindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>'></portlet:param>
</portlet:renderURL>

<portlet:actionURL
	name='<%= esfTournament == null
				? "addESFTournament" : "updateESFTournament" %>'
	var="editESFTournamentURL" />

<aui:form action="<%=editESFTournamentURL%>" name="fm">

	<aui:model-context bean="<%=esfTournament%>"
		model="<%=ESFTournament.class%>" />

	<aui:fieldset cssClass="tournament">

		<aui:input type="hidden" name="esfTournamentId"
			value='<%=esfTournament == null
						? "" : esfTournament.getEsfTournamentId()%>' />

		<aui:input type="hidden" name="esfOrganizationId"
			value='<%=currentOrganizationId%>' />

<%-- 		<aui:input type="hidden" name="isNational" --%>
<%-- 			value='<%= isNational %>' /> --%>

		<aui:input name="isSingleMatch" type="checkbox" value='<%=esfTournament != null &&
							esfTournament.getIsSingleMatch() ? "true" : "false"%>'>
		</aui:input>

		<aui:input name="title" id="title">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="description">
		</aui:input>

		<%
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		String currDate = ManageDate.CalendarToString(calendar);
		%>

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

		<label class="control-label" for="<portlet:namespace/>startDate">
			<liferay-ui:message key="start-date" />
		</label>
		<input name="<portlet:namespace/>startDate" id="datepicker" type="text" />
		
		<label class="control-label" for="<portlet:namespace/>endDate">
			<liferay-ui:message key="end-date" />
		</label>
		<input name="<portlet:namespace/>endDate" id="datepicker2" type="text" />

<%-- 		<aui:input name="maxnum"> --%>
<%-- 			<aui:validator name="digits"></aui:validator> --%>
<%-- 			<aui:validator name="max">100</aui:validator> --%>
<%-- 			<aui:validator name="min">2</aui:validator> --%>
<%-- 		</aui:input> --%>

<%-- 		<aui:input name="minnum"> --%>
<%-- 			<aui:validator name="digits"></aui:validator> --%>
<%-- 			<aui:validator name="max">100</aui:validator> --%>
<%-- 			<aui:validator name="min">2</aui:validator> --%>
<%-- 		</aui:input> --%>

		<p class="lead"><liferay-ui:message key="matches-options"></liferay-ui:message></p>
		
		<div>
			<aui:input name="isIndividualMatch" inlineField="true"/>
	
			<aui:input name="isTeamMatch" type="checkbox" inlineField="true"
				value='<%=esfTournament != null &&
								esfTournament.getIsTeamMatch() ? "true" : "false"%>' >
			</aui:input>
	
			<aui:input name="isJuniorMatch" inlineField="true"/>
	
			<aui:input name="isFinal" inlineField="true"/>
	
			<div class="separator"></div>
		</div>
		<p class="lead"><liferay-ui:message key="sport-options"></liferay-ui:message></p>
		<div>
			<select name='<%= namespace +  "esfShooterCategoryIds" %>' multiple >
			<%

			List<ESFShooterCategory> esfShooterCategories =
					ESFShooterCategoryLocalServiceUtil.getESFShooterCategories();
			if (esfShooterCategories.isEmpty()) {
				ServiceContext serviceContext =
						ServiceContextFactory.getInstance(
								ESFShooterCategory.class.getName(), renderRequest);				
				ESFShooterCategoryLocalServiceUtil.addESFShooterCategory(
						serviceContext.getUserId(), "Veterani", serviceContext);
				ESFShooterCategoryLocalServiceUtil.addESFShooterCategory(
						serviceContext.getUserId(), "Prima", serviceContext);
			}
			List<ESFShooterCategory> esfTournamentESFShooterCategories =
					ESFShooterCategoryLocalServiceUtil.getESFShooterCategories(esfTournamentId);

			for (ESFShooterCategory esfShooterCategory : esfShooterCategories) {

				boolean selected = false;
				String label = esfShooterCategory.getName();
		
				if (label.contains("-") && label.split("-").length > 1) {
		
					label = label.split("-")[1];
				}
				if (esfTournamentESFShooterCategories.contains(esfShooterCategory)) {
					selected = true;
				}
			%>
		
				<option value="<%= esfShooterCategory.getEsfShooterCategoryId() %>"
					<%= selected ? "selected" : StringPool.BLANK %>><%= label %></option>
		
			<% } %>
			</select>
			<select name='<%= namespace + "esfShooterQualificationIds" %>' multiple>
			<%

			List<ESFShooterQualification> esfShooterQualifications =
					ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications();
			if (esfShooterQualifications.isEmpty()) {
				ServiceContext serviceContext =
						ServiceContextFactory.getInstance(
								ESFShooterQualification.class.getName(), renderRequest);				
				ESFShooterQualificationLocalServiceUtil.addESFShooterQualification(
						serviceContext.getUserId(), "Lady", serviceContext);
				ESFShooterQualificationLocalServiceUtil.addESFShooterQualification(
						serviceContext.getUserId(), "Lady Junior", serviceContext);
			}
			List<ESFShooterQualification> esfTournamentESFShooterQualifications =
					ESFShooterQualificationLocalServiceUtil.getESFShooterCategories(esfTournamentId);

			for (ESFShooterQualification esfShooterQualification : esfShooterQualifications) {

				boolean selected = false;
				String label = esfShooterQualification.getName();
		
				if (label.contains("-") && label.split("-").length > 1) {
		
					label = label.split("-")[1];
				}
				if (esfTournamentESFShooterQualifications.contains(esfShooterQualification)) {
					selected = true;
				}
			%>
		
				<option value="<%= esfShooterQualification.getEsfShooterQualificationId() %>"
					<%= selected ? "selected" : StringPool.BLANK %>><%= label %></option>
		
			<% } %>
			</select>
		</div>

		<%
		String visible = "display:none;";

		if (esfTournament != null && esfTournament.getIsTeamMatch()) {
			visible = "";
		}
		%>

		<div id="cont-fields" style="<%=visible%>">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields">
				
					<%
					for (int i = 0; i < esfTeamIndexes.length; i++) {
						int teamIndex = esfTeamIndexes[i];

						ESFTeam esfTeam = esfTeams.get(i);%>

					<aui:input name='<%="nameTeam" + teamIndex%>'
						id='<%="nameTeam" + teamIndex%>' type="text" value="<%=esfTeam.getName()%>">
						<aui:validator name="alfa" />
					</aui:input>

					<%}%>
				</div>
			</div>

			<aui:input name="esfTeamIndexes" type="hidden" value="<%=StringUtil.merge(esfTeamIndexes)%>" />
		</div>

	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%=viewURL%>"></aui:button>
	</aui:button-row>
	
</aui:form>

<aui:script use="node,aui-io-request,liferay-auto-fields">

new Liferay.AutoFields({
	contentBox: 'fieldset.tournament',
	fieldIndexes: '<portlet:namespace />esfTeamIndexes'
	}
	).render();

A.one('#<portlet:namespace/>isSingleMatchCheckbox').on('click', changeSingleMatch);
A.one('#<portlet:namespace/>isTeamMatchCheckbox').on('click', changeTeamMatch);

function changeSingleMatch(event){
	var element = A.one(event.currentTarget);
	var val = element.attr('checked');

	if(val == true){
		A.one('#<portlet:namespace/>title').set('value', "Match Singolo");
	}
	else{
		A.one('#<portlet:namespace/>title').set('value', "");
	}
}

function changeTeamMatch(event){
	var element=A.one(event.currentTarget); 
	var val=element.attr( 'checked');
	
	if(val==true){
		A.one('#cont-fields').setStyle('display', "");
	}
	else{
		A.one('#cont-fields').setStyle('display', "none");
	}
}

</aui:script>