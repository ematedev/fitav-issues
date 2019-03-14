<%@include file="init.jsp"%>

<%
	ESFMatch esfMatch = null;

	if (esfMatchId > 0) {
		esfMatch =
	ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);
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

<aui:script use="node,aui-io-request">

var associations = JSON.parse('<%= associations.equals("")?null:HtmlUtil.escapeJS(associations) %>');
var fields = JSON.parse('<%= fields.equals("")?null:HtmlUtil.escapeJS(fields) %>');
var sporttypes = JSON.parse('<%= sporttypes.equals("")?null:HtmlUtil.escapeJS(sporttypes) %>');

var associationId = '<%= esfMatchId > 0?esfMatch.getEsfAssociationId():ESFKeys.ESFAddressConstant.DEFAULT_STRING%>';
var sporttypeId = '<%= esfMatchId > 0?esfMatch.getEsfSportTypeId():ESFKeys.ESFAddressConstant.DEFAULT_NUMBER%>';

var associationsOptions = '<option value="">-</option>';
for(assIndex in associations) {
	if(associations[assIndex][0] == associationId)
		associationsOptions += '<option selected="selected" value="'+ associations[assIndex][0] +'">' + associations[assIndex][1] + '</option>';
	else 
		associationsOptions += '<option value="'+ associations[assIndex][0] +'">' + associations[assIndex][1] + '</option>';
}

var fieldsOptions = '<option value="">-</option>';
for(fieldIndex in fields) {
	if(fields[fieldIndex][0] == fieldId)
		fieldsOptions += '<option selected="selected" value="'+ fields[fieldIndex][0] +'">' + fields[fieldIndex][1] + '</option>';
	else	
		fieldsOptions += '<option value="'+ fields[fieldIndex][0] +'">' + fields[fieldIndex][1] + '</option>';
}

var sporttypesOptions = '<option value="0">-</option>';
for(sportIndex in sporttypes) {
	if(sporttypes[sportIndex][0] == sporttypeId)
		sporttypesOptions += '<option selected="selected" value='+ sporttypes[sportIndex][0] +'>' + sporttypes[sportIndex][1] + '</option>';
	else
		sporttypesOptions += '<option value='+ sporttypes[sportIndex][0] +'>' + sporttypes[sportIndex][1] + '</option>';
}

A.one('#<portlet:namespace/>associations').html(associationsOptions);
A.one('#<portlet:namespace/>fields').html(fieldsOptions);
A.one('#<portlet:namespace/>sporttypes').html(sporttypesOptions);

A.one('#<portlet:namespace/>associations').on('change', changeSelect);
A.one('#<portlet:namespace/>fields').on('change', changeSelect);
A.one('#<portlet:namespace/>sporttypes').on('change', changeSelect);

function changeSelect(event) {
	var element = event.currentTarget;
	var type = element.get('id').replace('<portlet:namespace/>', '');
	var param = '';
	var idAssociation = ''; 
	var idField = '';
	if(type == 'associations') {
		idAssociation = A.one('#<portlet:namespace/>associations').get('value');
	}
	else if(type == 'fields'){
		idAssociation = A.one('#<portlet:namespace/>associations').get('value');
		idField = A.one('#<portlet:namespace/>fields').get('value');
	}
	
	var resourceURL = '';
	if (type == 'associations') {
		resourceURL = '<%= associationsURL %>';
	}
	else if (type == 'fields') {
		resourceURL = '<%= fieldsURL %>';
	}
	else if (type == 'sporttypes') {
		resourceURL = '<%= sporttypesURL %>';
	}
	A.io.request(
		resourceURL,
		{
			method: 'POST',
			contentType: "application/json; charset=utf-8",
			data: {
				param:param,
				idAssociation:idAssociation,
				idField:idField
			},
			on: {
				success: function() {
					var results = JSON.parse(this.get('responseData'));
					var resultsOption = '<option value="">-</option>';
					console.log(type);
					console.log(results);
					if(type == 'associations'){
						A.one('#<portlet:namespace/>fields').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>fields').html(resultsOption);
						}
						A.one('#<portlet:namespace/>sporttypes').html('<option value="0">-</option>');
					}
					else if(type == 'fields') {
						A.one('#<portlet:namespace/>sporttypes').html('<option value="0">-</option>');
						for(index in results) {
							resultsOption += '<option value='+ results[index][0] +'>' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>sporttypes').html(resultsOption);
						}
					}
				}
		}
	});
}
</aui:script>
	


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
		String currDate = "";
		
		if(esfMatch != null){
			currDate = ManageDate.DateToString(esfMatch.getStartDate());
		}
		else if(esfTournament != null && esfTournament.getIsSingleMatch()){
			currDate = ManageDate.DateToString(esfTournament.getStartDate());
		}
		else{
			Calendar calendar = CalendarFactoryUtil.getCalendar();
			currDate = ManageDate.CalendarToString(calendar);
		}

		%>

		<aui:script>
		$(function() {
			$( "#datepicker" ).datepicker();
			$( "#datepicker" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
			$( "#datepicker" ).datepicker( "setDate", '<%= currDate %>' );

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
			startDate
		</label>
		<input name="<portlet:namespace/>startDate" id="datepicker" type="text">

		<aui:input name="startHour">
		</aui:input>

		<aui:input name="endHour">
		</aui:input>

		<aui:input name="numDisk">
		</aui:input>

		<aui:select id="associations" name="esfAssociationId"
			showEmptyOption="true"></aui:select>
		<aui:select id="fields" name="esfFieldId" showEmptyOption="true"></aui:select>
		<aui:select id="sporttypes" name="esfSportTypeid"
			showEmptyOption="true"></aui:select>

		<aui:input name="isDraft" type="checkbox"
			checked="<%= esfMatch == null ? true : esfMatch.isIsDraft() %>"/>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="button" value="save" id='<%= renderResponse.getNamespace()+"checkDraft" %>'></aui:button>
		<aui:button type="cancel" onClick="<%=viewURL%>"></aui:button>
	</aui:button-row>

</aui:form>

<aui:script use="aui-base,node">

A.one("#<portlet:namespace/>checkDraft").on('click',function() {
	if (A.one('#<portlet:namespace/>isDraft').get('value') == 'true') {
		return true;
	}
	else {
		if (confirm(Liferay.Language.get('draft-confirm-message'))) {
			A.one('#<portlet:namespace/>fm').submit();
		}
	}
});

</aui:script>

