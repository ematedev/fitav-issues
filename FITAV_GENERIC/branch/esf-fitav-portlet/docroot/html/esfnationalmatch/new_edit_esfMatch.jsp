
<%@include file="init.jsp"%>

<liferay-ui:error key="mail_error" message="mail_error"/>
<%
	String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	int urlEndIndex = currentUrlPage.indexOf('?');
	String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId",0);
	if(urlEndIndex != -1){
		backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
	}
	portletDisplay.setURLBack(backtoViewUrl);

	String namespace = renderResponse.getNamespace();
	ESFMatch esfMatch = null;
	ESFOrganization esfMatchOrganization = null;
	boolean disabled=false;
	boolean checked = false;
	
	boolean olimpicMatch = 
			GetterUtil.getBoolean(
				portletPreferences.getValue(
					"olimpicMatch", StringPool.TRUE));

	boolean nationalMatch = 
			GetterUtil.getBoolean(
				portletPreferences.getValue(
					"nationalMatch", StringPool.TRUE));

	boolean event = 
			GetterUtil.getBoolean(
				portletPreferences.getValue(
					"event", StringPool.TRUE));
		
	String typeEvent = "";
	if(olimpicMatch){
		typeEvent ="olimpicMatch";
	}else if(nationalMatch){
		typeEvent ="nationalMatch";
	}else if(event){
		typeEvent ="event";
	}

	if (esfMatchId > 0) {
		esfMatch = ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);
		if(esfMatch.getEsfAssociationId()>0){
			esfMatchOrganization = ESFOrganizationLocalServiceUtil
				.getESFOrganization(esfMatch.getEsfAssociationId());
		}
	}
	
	if(esfMatch!=null && !esfMatch.isIsDraft()){
		disabled=true;
	}
	
	String notNationalAssotiation = "";
	
	if(Validator.isNotNull(esfMatch) &&
			Validator.isNotNull(esfMatch.getNotNationalAssotiation())){
		notNationalAssotiation = esfMatch.getNotNationalAssotiation();
	}
	
	String dispalyOne = "";
	String displayTwo = "";
	if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getCountryId()) &&
			esfMatch.getCountryId()>0 ){
		dispalyOne = "none";
		checked = true;
	}
	if(Validator.isNotNull(esfMatch) && esfMatch.getEsfAssociationId() > 0){
		dispalyOne = "";
	}
	if(dispalyOne.equals("")){
		displayTwo = "none";
	}
	
	Calendar cal = Calendar.getInstance();
	List <ESFMatch> esfMatches = ESFMatchLocalServiceUtil.
							findESFMatchesByYearIsNational(
										cal.get(cal.YEAR),isNational);
	String matchCodeValue = "";
	matchCodeValue = String.valueOf(cal.get(cal.YEAR)) + "_" +
						String.valueOf(esfMatches.size() + 1);

	
	
	String esfDescription = "";
	List<ESFMatchType> esfMatchTypes = null;
	esfMatchTypes = ESFMatchTypeLocalServiceUtil.findAllByNational(isNational);
	ESFMatchType esfMatchType  = null;
	if(esfMatchId >0) {
		
		esfMatchType  = ESFMatchTypeLocalServiceUtil.
				fetchESFMatchType(esfMatch.getEsfMatchTypeId());
		
		if(esfMatchType != null){
			esfDescription = esfMatchType.getName();
		}
	}
	
	User userLogged = themeDisplay.getUser();
	
	
	List<Role> roles = userLogged.getRoles();
	

%>

<portlet:resourceURL var="resourceURL" escapeXml="false" />

<portlet:renderURL var="chooseAssociationURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>

<portlet:renderURL  var="add_DescriptionURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"edit_esfDescription.jsp" %>' />
		<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId) %>' />
</portlet:renderURL>

<portlet:renderURL  var="add_MatchTypeURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"edit_esfMatchType.jsp" %>' />
		<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId) %>' />
</portlet:renderURL>

<portlet:actionURL name="updateESFMatch" var="editESFMatchURL" />

<aui:form action="<%=editESFMatchURL%>" name="fm">

	<aui:model-context bean="<%=esfMatch%>" model="<%=ESFMatch.class%>" />

	
		<aui:input type="hidden" name="esfMatchId" value='<%=esfMatchId%>' />

		<%
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		calendar.setTime(new Date());
		String	startDate = calendar.toString() ;
		String endDate = calendar.toString();
		if(esfMatchId >0) {
			startDate = format1.format(esfMatch.getStartDate());
			endDate = format1.format(esfMatch.getEndDate());

		}else{
			startDate= format1.format(new Date());
			endDate= format1.format(new Date());
		}
		%>

		<aui:script>
		$(function() {
			$("#<portlet:namespace/>startDate").datepicker();
			$("#<portlet:namespace/>startDate").datepicker("setDate", '<%= startDate %>');
			$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat", 'dd/mm/yy');
			
		});
		
		$(function() {
			$("#<portlet:namespace/>endDate").datepicker();
			$("#<portlet:namespace/>endDate").datepicker("setDate", '<%= endDate %>');
			$("#<portlet:namespace/>endDate").datepicker("option", "dateFormat", 'dd/mm/yy');
		});
		
		
		$(function() {
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
		});	
		</aui:script>
		
		<aui:input name="eventType" type="hidden"
			value="<%=typeEvent%>"></aui:input>
		
		<aui:input name="code"
			value="<%=matchCodeValue%>"></aui:input>

		<aui:input name="startDate" type="text" >
			<aui:validator name="required" errorMessage="this-field-is-required" />
		</aui:input>

		<aui:input name="endDate" type="text" >
			<aui:validator name="required" errorMessage="this-field-is-required" />
		</aui:input>
		
		<div class="btn-field-align">
	
			<aui:select name="esfMatchTypeId"  lable="esfMatchTypeId" id="esfMatchTypeId" inlineField="true">
				<aui:option label="-" value="0" />
	
				<%
				boolean select = false;
				
				for(ESFMatchType matchType : esfMatchTypes){
					
					if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getEsfMatchTypeId())
							&& esfMatch.getEsfMatchTypeId() == esfMatchType.getEsfMatchTypeId()){
						select = true;
					}
				%>
				<aui:option label="<%=matchType.getName() %>" value="<%=matchType.getEsfMatchTypeId() %>"  selected="<%=select %>"/>
				
				<%} %>
			</aui:select>
			
			<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_VIEW_ADD_MATCH_TYPE) %>">	
		
				<aui:button onClick="<%= add_MatchTypeURL.toString() %>" value="add-addr" />
		
			</c:if>

		</div>
		
		<div class="btn-field-align">
			<aui:select name="description" label="event" inlineField="true">
			<%
				List<ESFDescription> esfDescriptions = ESFDescriptionLocalServiceUtil.findAllByNational(isNational);
					for (ESFDescription esfDescriptio : esfDescriptions) {
			%>
				<aui:option label="<%=esfDescriptio.getName()%>"
					value="<%=esfDescriptio.getEsfDescriptionId()%>"></aui:option>
			<%
				}
			%>
		</aui:select>

		<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_VIEW_ADD_DESCRIPTION) %>">	
		
			<aui:button onClick="<%= add_DescriptionURL.toString() %>" value="add-addr" />
		
		</c:if>
</div>		

<%
List<ESFSportType> esfSportTypes = null ;
if(olimpicMatch){
	esfSportTypes = ESFSportTypeLocalServiceUtil.getisOlimpic(true);
}else if(nationalMatch){
	esfSportTypes = ESFSportTypeLocalServiceUtil.getNational(true);
}else {
	esfSportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
}

List<KeyValuePair> leftListesfSportType = new ArrayList<KeyValuePair>();
List<KeyValuePair> rightListesfSportType  = new ArrayList<KeyValuePair>();

String sportType = "";
if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getEsfNationalSportTypeId())){
	sportType = esfMatch.getEsfNationalSportTypeId();
}


String [] splits = null;
List<Long> sportTypeId = new ArrayList<Long>();
if(Validator.isNotNull(sportType)){
	splits = sportType.split("-");
	
}
if(Validator.isNotNull(splits)){	
	for(ESFSportType esfSportType : esfSportTypes){
		for(String s : splits){
			if(Validator.isNumber(s) && Long.valueOf(s) == esfSportType.getEsfSportTypeId()){
				rightListesfSportType.add(new KeyValuePair(String.valueOf(esfSportType.getEsfSportTypeId()) ,
						esfSportType.getName()));
				sportTypeId.add(esfSportType.getEsfSportTypeId());
			}
		}
	}
}

for(ESFSportType type : esfSportTypes){
	if(Validator.isNotNull(sportTypeId) && Validator.isNotNull(type) &&  !sportTypeId.contains(type.getEsfSportTypeId())){
		leftListesfSportType.add(new KeyValuePair(String.valueOf(type.getEsfSportTypeId()) , type.getName()));
	}
	
}

%>		
	<liferay-ui:message key="speciality">speciality</liferay-ui:message>	
	
	<aui:input name="valuesSportType" type="hidden" />
    <liferay-ui:input-move-boxes
        leftBoxName="availableValuesSportType"
        leftList="<%= leftListesfSportType%>"
        leftReorder="true"
        leftTitle="available"
        rightBoxName="selectedValuesSportType"
        rightList="<%=rightListesfSportType%>"
        rightTitle="selected"
    />

		<aui:input name="numDisk">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="min">0</aui:validator>
		</aui:input>
		
		<aui:input leable="num-disk-team" name="numDiskTeam">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="min">0</aui:validator>
		</aui:input>

		<aui:input name="notes" type="textarea"></aui:input>

		<aui:input name="isDraft" type="checkbox"
			checked="<%=esfMatch == null ? true : esfMatch.isIsDraft()%>" />
			

		<aui:input id='<%="siteInternational"%>' name="siteInternational"
			checked="<%=checked%>" type="checkbox" label="international-place"
			onChange="showInput();" />

		<aui:input name="disabledHidden"
			id='<%=namespace + "disabledHidden"%>' type="hidden" value="false">
		</aui:input>
		
		<aui:input name="esfAssociationId" type="hidden"
			value="<%=esfMatchOrganization == null ? StringPool.BLANK : esfMatchOrganization.getEsfOrganizationId()%>">
		</aui:input>
<div class="btn-field-align">
		 <div id="assotiationIt" style="display : <%=dispalyOne%>;">
			<aui:input inlineField="true" name="esfAssociation" disabled="true"
				type="text"
				value="<%=esfMatchOrganization == null ? StringPool.BLANK : esfMatchOrganization.getName()%>">
			</aui:input>
			
			<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_VIEW_ADD_ASSOCIATION) %>">	
		
				<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
					id='<%=namespace + "chooseAssociationTrigger"%>' value="add">
				</aui:button>
			
			</c:if>	
			<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_VIEW_DELETE_ASSOCIATION) %>">	
			
				<aui:button class="aui-icon aui-icon-large aui-iconfont-delete"
					id='<%=namespace + "deleteAssociationTrigger"%>' value="delete">
				</aui:button>
			</c:if>
			
			<aui:input name="site"></aui:input>
		</div>
</div>		
		 <div id="esfInternationalAss" style='display : <%=displayTwo%>;'>
			<aui:input inlineField="true" name="notNationalAssotiation"
				id='<%=namespace + "notNationalAssotiation"%>' type="text"
				value="<%=notNationalAssotiation%>">

			 </aui:input>

		<aui:select name="esfCountryId">
		<aui:option label="-" value="0" />
		
			<%
				List<Country> countries = CountryServiceUtil.getCountries();
				for (int i=0;i< countries.size();i++) {
					Country country=countries.get(i);
					boolean selected = false;
					if(Validator.isNotNull(esfMatch) && esfMatch.getCountryId()==country.getCountryId())
						 selected = true;
			%>
					<aui:option label="<%=country.getName()%>"	value="<%=country.getCountryId()%>" 	selected="<%=selected%>" />
			<%
				}
			%>
		</aui:select>
		
		</div>

		<div class="separator"></div>

		<liferay-ui:message key="matches-options" />
		<br />
		<aui:input name="isJuniorMatch" 
			inlineField="true" type="checkbox"
			checked="<%=esfMatch != null
				? esfMatch.getIsJuniorMatch() : false%>" />
				


		<aui:input name="isOlimpicQualificationMatch" leable="isOlimpicQualificationMatch" 
			type="checkbox" checked="<%=esfMatch != null ? esfMatch.getIsOlimpicQualificationMatch() : false%>" />

<%
List<ESFShooterQualification> esfShooterQualifications =
ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications();
	
List<ESFShooterQualification> esfShooterQualificationsESFMatch =
	ESFShooterQualificationLocalServiceUtil.findByMatchId(esfMatchId);


List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();
List<KeyValuePair> rightList  = new ArrayList<KeyValuePair>();

for(ESFShooterQualification qm : esfShooterQualificationsESFMatch){
	rightList.add(new KeyValuePair(String.valueOf(qm.getEsfShooterQualificationId()) , qm.getName()));
}

for(ESFShooterQualification q : esfShooterQualifications){

	if(Validator.isNotNull(rightList) && !esfShooterQualificationsESFMatch.contains(q)){
		leftList.add(new KeyValuePair(String.valueOf(q.getEsfShooterQualificationId()) , q.getName()));
	}
}

%>

	<liferay-ui:message key="shooter-qualification">shooter-qualification</liferay-ui:message>	
	<aui:input name="values" type="hidden" />
    <liferay-ui:input-move-boxes
        leftBoxName="availableValues"
        leftList="<%= leftList%>"
        leftReorder="true"
        leftTitle="available"
        rightBoxName=" selectedValues"
        rightList="<%=rightList%>"
        rightTitle="selected"
    />
		
		

	<aui:button-row>

		<c:if test="<%= 
					ESFNationalMatchPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFNATIONALMATCH_UPDATE) 
					||	ESFNationalMatchModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFNATIONALMATCH_ADD)) 	
					%>">	
		
			<aui:button type="button" value="save"
				id='<%=renderResponse.getNamespace()+"checkDraft"%>'>
			</aui:button>
		</c:if>
		
		<aui:button type="cancel" onClick="<%=viewURL%>"></aui:button>
	</aui:button-row>

</aui:form>

<aui:script use="aui-base,node,aui-io-request,liferay-util-list-fields">

window.showInput = function() {
	/*if(status){*/
		if((A.one('#<portlet:namespace/>siteInternational').get('value')) === 'true'){
			A.one('#assotiationIt').hide();
			A.one('#esfInternationalAss').show();
			A.one('#<portlet:namespace/>esfAssociation').set('disabled', true);
			A.one('#<portlet:namespace/>notNationalAssotiation').set('disabled', false);
		}
		else{
			A.one('#assotiationIt').show();
			A.one('#esfInternationalAss').hide();
			A.one('#<portlet:namespace/>esfAssociation').set('disabled', false);
			A.one('#<portlet:namespace/>notNationalAssotiation').set('disabled', true);
		}
	}

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
A.one('#<portlet:namespace/>deleteAssociationTrigger').on('click', function(event){
	
	A.one('#<portlet:namespace />esfAssociation').set('value','');
	A.one('#<portlet:namespace />esfAssociationId').set('value','');

	});
A.one('#<portlet:namespace/>siteInternational').on('click', function(event){
	if(A.one('#<portlet:namespace/>siteInternational').get('value')=='true'){
		
	A.one('#<portlet:namespace/>esfAssociation').set('disabled', true);
	A.one('#<portlet:namespace/>disabledHidden').set('value', true);
	A.one('#<portlet:namespace/>esfAssociationInternational').set('disabled', false);

	}else{
		A.one('#<portlet:namespace/>esfAssociation').set('disabled', false);
		A.one('#<portlet:namespace/>disabledHidden').set('value', false);
		A.one('#<portlet:namespace/>esfAssociationInternational').set('disabled', true);
	}

	});
	
A.one("#<portlet:namespace/>checkDraft").on('click',function() {
	
	var selectedValues = Liferay.Util.listSelect('#<portlet:namespace/>selectedValues');
	var selectedValuesSportType = Liferay.Util.listSelect('#<portlet:namespace/>selectedValuesSportType');
    A.one('#<portlet:namespace/>values').val(selectedValues);
    A.one('#<portlet:namespace/>valuesSportType').val(selectedValuesSportType);
	
	if (A.one('#<portlet:namespace/>isDraft').get('value') == 'true') {
		A.one('#<portlet:namespace/>fm').submit();
	}
	else {
			A.one('#<portlet:namespace/>fm').submit();
	}
});

$('#<portlet:namespace/>startDate').on('change', function(){
	$('#<portlet:namespace/>endDate').val($(this).val());
});

</aui:script>