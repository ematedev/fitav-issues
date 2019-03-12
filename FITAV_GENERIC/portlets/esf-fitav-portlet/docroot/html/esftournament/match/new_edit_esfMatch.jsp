<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp"%>

<%
	String namespace = renderResponse.getNamespace();
	ESFMatch esfMatch = null;
	ESFOrganization esfMatchOrganization = null;

	if (esfMatchId > 0) {
		esfMatch =
	ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);
		esfMatchOrganization = ESFOrganizationLocalServiceUtil
				.getESFOrganization(esfMatch.getEsfAssociationId());
	}

	String associations;
	String fields;
	String sporttypes;

	if (Validator.isNull(request.getAttribute("associations"))) {
		associations = StringPool.BLANK;
	}
	else {
		associations = request.getAttribute("associations").toString();
	}
	if (Validator.isNull(request.getAttribute("fields"))) {
		fields = StringPool.BLANK;
	}
	else {
		fields = request.getAttribute("fields").toString();
	}
	if (Validator.isNull(request.getAttribute("sporttypes"))) {
		sporttypes = StringPool.BLANK;
	}
	else {
		sporttypes = request.getAttribute("sporttypes").toString();
	}
	
%>

<portlet:resourceURL var="associationsURL" id="associations"
	escapeXml="false" />
<portlet:resourceURL var="fieldsURL" id="fields" escapeXml="false" />
<portlet:resourceURL var="sporttypesURL" id="sporttypes"
	escapeXml="false" />

<portlet:renderURL var="viewURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%=templatePath + "match/view.jsp"%>'></portlet:param>
<%-- 	<portlet:param name="isNational" --%>
<%-- 				value="<%=String.valueOf(isNational)%>" /> --%>
	<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
	<portlet:param name="esfTournamentId"
				value="<%=String.valueOf(esfTournamentId)%>" />
</portlet:renderURL>

<portlet:renderURL var="chooseAssociationURL"
	windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath" value='<%=templatePath + "match/popup/view.jsp" %>'></portlet:param>
</portlet:renderURL>

<portlet:actionURL
	name='<%=esfMatch == null ? "addESFMatch" : "updateESFMatch"%>'
	var="editESFMatchURL" />

<aui:form action="<%=editESFMatchURL%>" name="fm">

	<aui:model-context bean="<%=esfMatch%>" model="<%=ESFMatch.class%>" />

	<aui:fieldset>

		<aui:input type="hidden" name="esfTournamentId"
			value='<%=esfTournamentId%>' />

		<aui:input type="hidden" name="esfMatchId" value='<%=esfMatchId%>' />
		
<%-- 		<aui:input type="hidden" name="isNational" value='<%=isNational%>' /> --%>

		<%
		String startDate = "";
		String endDate = "";
		
		if(esfMatch != null){
			startDate = ManageDate.DateToString(esfMatch.getStartDate());
			endDate = ManageDate.DateToString(esfMatch.getEndDate());
		}
		else if(esfTournament != null && esfTournament.getIsSingleMatch()){
			startDate = ManageDate.DateToString(esfTournament.getStartDate());
			endDate = ManageDate.DateToString(esfTournament.getEndDate());
		}
		else{
			Calendar calendar = CalendarFactoryUtil.getCalendar();
			startDate = ManageDate.CalendarToString(calendar);
			endDate = ManageDate.CalendarToString(calendar);
		}

		%>

		<aui:script>
		$(function() {
			$( "#datepicker" ).datepicker();
			$( "#datepicker" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
			$( "#datepicker" ).datepicker( "setDate", '<%= startDate %>' );

			$( "#datepicker2" ).datepicker();
			$( "#datepicker2" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
			$( "#datepicker2" ).datepicker( "setDate", '<%= endDate %>' );
			
			$('input[name="<portlet:namespace/>startHour"]').ptTimeSelect({
					containerClass: undefined,
					containerWidth: undefined,
					hoursLabel:     'Ore',
					minutesLabel:   'Minuti',
					setButtonLabel: 'Set',
					popupImage:     undefined,
					onFocusDisplay: true,
					zIndex:         10,
					onBeforeShow:   undefined,
					onClose:        undefined
			});

			$('input[name="<portlet:namespace/>endHour"]').ptTimeSelect({
				containerClass: undefined,
				containerWidth: undefined,
				hoursLabel:     'Ore',
				minutesLabel:   'Minuti',
				setButtonLabel: 'Set',
				popupImage:     undefined,
				onFocusDisplay: true,
				zIndex:         10,
				onBeforeShow:   undefined,
				onClose:        undefined
			});
		});	
		</aui:script>

		<label class="control-label" for="<portlet:namespace/>startDate">
			Data di Inizio
		</label>
		
		<input name="<portlet:namespace/>startDate" id="datepicker" type="text">

		<label class="control-label" for="<portlet:namespace/>startDate" >
			Data di Fine
		</label>
		
		<input name="<portlet:namespace/>endDate" id="datepicker2" type="text">

		<aui:input name="startHour">
		</aui:input>

		<aui:select name="description" showEmptyOption="true">
			<%
			List<ESFDescription> esfDescriptions = ESFDescriptionLocalServiceUtil.findAll();
			for (ESFDescription esfDescription : esfDescriptions) { %>
			
			<aui:option label="<%= esfDescription.getDescription() %>"
				value="<%= esfDescription.getEsfDescriptionId() %>"></aui:option>
			<% } %>
		</aui:select>
		
		<aui:input name="notes"></aui:input>
		
		<aui:input name="numDisk">
		</aui:input>

		<aui:input name="esfAssociationId" type="hidden"
			value="<%= esfMatchOrganization == null ? StringPool.BLANK : esfMatchOrganization.getEsfOrganizationId() %>">
		</aui:input>
		<aui:input inlineField="true" name="esfAssociation" disabled="true" type="text"
			value="<%= esfMatchOrganization == null ? StringPool.BLANK : esfMatchOrganization.getName() %>">
		</aui:input>
		<aui:button class="aui-icon aui-icon-large aui-iconfont-add" id='<%= namespace + "chooseAssociationTrigger" %>' value="add">
		</aui:button>

		<aui:input id="numFields" name="numFields" >
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="min">0</aui:validator>
		</aui:input>
		
		<aui:select id="sporttypes" name="esfSportTypeid"
			showEmptyOption="true">
			<%
			List<ESFSportType> esfSportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
			for (ESFSportType esfSportType : esfSportTypes) { %>

			
			<aui:option label="<%= esfSportType.getName() %>"
				value="<%= esfSportType.getEsfSportTypeId() %>"></aui:option>
			<% } %>
		</aui:select>

		<aui:input name="isDraft" type="checkbox"
			checked="<%= esfMatch == null ? true : esfMatch.isIsDraft() %>"/>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="button" value="save" id='<%= renderResponse.getNamespace()+"checkDraft" %>'></aui:button>
		<aui:button type="cancel" onClick="<%=viewURL%>"></aui:button>
	</aui:button-row>

</aui:form>

<aui:script use="aui-base,node">


AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){

	A.one('#<portlet:namespace/>chooseAssociationTrigger').on('click', function(event){
	var login_popup= Liferay.Util.openWindow({
		dialog: {
			centered: true,
			destroyOnClose: true,
			cache: false,
			width: 700,
			height: 500,
			modal: true
		},
		title: 'Sedi Gara',
		id:'<portlet:namespace/>chooseAssociationPopUp',
		uri:'<%=chooseAssociationURL.toString()%>'
		});

	});
});


Liferay.provide(
	window,
	'<portlet:namespace/>retrieveAssociation',
	function(dataId, dataName) {
		var A = AUI();

		A.one('#<portlet:namespace/>esfAssociationId').set('value', dataId);
		A.one('#<portlet:namespace/>esfAssociation').set('value', dataName);
		
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
		dialog.destroy();
	},
	['liferay-util-window']
);

A.one("#<portlet:namespace/>checkDraft").on('click',function() {
	if (A.one('#<portlet:namespace/>isDraft').get('value') == 'true') {
		A.one('#<portlet:namespace/>fm').submit();
	}
	else {
		if (confirm(Liferay.Language.get('draft-confirm-message'))) {
			A.one('#<portlet:namespace/>fm').submit();
		}
	}
});

</aui:script>

