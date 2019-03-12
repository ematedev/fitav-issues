
<%@ include file="init.jsp"%>


<% 
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	ESFDeparture esfDeparture = null;
	String namespace = renderResponse.getNamespace();
	long esfDepartureId = ParamUtil.getLong(request, "esfDepartureId");
	String path = request.getPathInfo();
	request.setAttribute("path", path);

	if( esfDepartureId == 0){
		esfDepartureId =ParamUtil.getLong(request, "esfDepartureId");
	}
	
	if (esfDepartureId > 0) {

		esfDeparture = ESFDepartureLocalServiceUtil.getESFDeparture(esfDepartureId);
	
	}
	
	List <ESFUser> tempESFUsers = ESFUserLocalServiceUtil.getESFUsersByDeparture(esfDepartureId);
	List<ESFUser> esfUsersAssignedToDeparture = new ArrayList<ESFUser>();
	List<ESFAirport> esfAirports = ESFAirportLocalServiceUtil.getAllESFAirport();
	
	for(ESFUser e : tempESFUsers){
		if(Validator.isNotNull(e.getEsfUserId()) && e.getEsfUserId() > 0 ){
			esfUsersAssignedToDeparture.add(e);
		}
	}
	
	if(Validator.isNotNull(esfDeparture)){
		ESFDepartureLocalServiceUtil.getESFDeparturesByEsfMatchId_F_L_L_C_D(
			esfMatchId, esfDeparture.getCode(), esfDeparture.getLeaveDate(),
			esfDeparture.getLeaveHour(), esfDeparture.getCompanyName(), 
			esfDeparture.getDepartureFrom());
	}
	
	long esfUserId = ParamUtil.getLong(request, "esfNationalDelegationUserId");
	
	String leaveDate = "";
	String arriveDate = "";
	String leaveHour = "";
	String arriveHour = "";	
	String code = "";
	String companyName = "";
	String departureFrom = "";
	String arrivalTo = "";
	Boolean returned = false; 
	String stopoverIdString = "";
	
	if (Validator.isNotNull(esfDeparture)) {
		leaveDate = ManageDate.DateToString(esfDeparture.getLeaveDate());
		arriveDate = ManageDate.DateToString(esfDeparture.getArriveDate());
		leaveHour = String.valueOf(esfDeparture.getLeaveHour());
		arriveHour = String.valueOf(esfDeparture.getArriveHour());
		code = String.valueOf(esfDeparture.getCode());
		companyName = String.valueOf(esfDeparture.getCompanyName());
		departureFrom = String.valueOf(esfDeparture.getDepartureFrom());
		arrivalTo = String.valueOf(esfDeparture.getArrivalTo());
		returned = Boolean.valueOf(esfDeparture.getIsReturn());
		stopoverIdString = esfDeparture.getStopoverId();
	}else{
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		leaveDate=ManageDate.CalendarToString(calendar);	
		arriveDate=ManageDate.CalendarToString(calendar);	
	}
%>
<portlet:renderURL var="chooseAssociationURL">
	<portlet:param name="mvcPath"
		value="/html/esfnationalmatch/insert_airport.jsp"/>
		<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" />
</portlet:renderURL>
<aui:script>
		$(function() {
			$("#<portlet:namespace/>leaveDate").datepicker();
			$("#<portlet:namespace/>leaveDate").datepicker("option", "dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>leaveDate").datepicker("setDate", '<%= leaveDate %>');
			
		});
		
		$(function() {
			$("#<portlet:namespace/>arriveDate").datepicker();
			$("#<portlet:namespace/>arriveDate").datepicker("option", "dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>arriveDate").datepicker("setDate", '<%= arriveDate %>');
			
		});
		
		$(function() {
			$('input[name="<portlet:namespace/>leaveHour"]').ptTimeSelect({
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
		
		$(function() {
			$('input[name="<portlet:namespace/>arriveHour"]').ptTimeSelect({
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

<portlet:actionURL name="editESFDeparture" var="editESFDepartureURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
</portlet:actionURL>


<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="mvcPath" value="/html/esfnationalmatch/edit_esfDeparture.jsp" />
		<portlet:param name="esfDepartureId" value="<%=String.valueOf(esfDepartureId)%>" />
		<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
</liferay-portlet:renderURL>

<div class="row-fluid">
	<aui:form name="fm" action = "<%=editESFDepartureURL%>" onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace()+"addStopover();"%>'>
	<div class = "span4">
			<aui:model-context bean="<%=esfDeparture%>"
				model="<%=ESFDeparture.class%>" />
	
			<aui:fieldset>
				<aui:input type="hidden" name="esfDepartureId"
					value='<%=esfDepartureId%>' />
		
				<aui:input type="hidden" name="typeTravel"
					value='aereo' />
					
				<aui:input name="code" type="text" label="code" value='<%=code%>' required ="true">
					
				</aui:input>
				<aui:input name="companyName" type="text" label="CompanyName"
					value='<%=companyName%>'>
					
				</aui:input>
				<aui:select inlineField="true" name="departureFrom" showEmptyOption="true">
					<%
						for (ESFAirport ea : esfAirports) {
							String nome = ea.getCity().toUpperCase()+" "+ea.getName();
					%>
					<aui:option label="<%=  nome %>" value="<%= nome %>"></aui:option>
					<%
						}
					%>
				</aui:select>
				<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_ADD_AIRPORT) %>">	
					<aui:button class="aui-icon aui-icon-large aui-iconfont-delete"
						 value="add" onClick="<%=chooseAssociationURL.toString() %>">
					</aui:button>
				</c:if>
				<aui:input label="meetingPlace" name="meetingPlace" value=""></aui:input>
				<aui:input inlineField="false" name="leaveDate" type="text">
					
				</aui:input>

				<aui:input name="leaveHour" value="<%=leaveHour%>">
					
				</aui:input>
	
				<aui:select inlineField="true" name="arrivalTo" showEmptyOption="true">
					<%
						for (ESFAirport ea : esfAirports) {
							String nome = ea.getCity().toUpperCase()+" "+ea.getName();
					%>
					<aui:option label="<%=  nome %>" value="<%=  nome %>"></aui:option>
					<%
						}
					%>
				</aui:select>
				
				<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_ADD_AIRPORT) %>">	
				
					<aui:button class="aui-icon aui-icon-large aui-iconfont-delete"
						 value="add" onClick="<%=chooseAssociationURL.toString() %>">
					</aui:button>
				</c:if>
				
				<aui:input inlineField="false" name="arriveDate" type="text">
					
				</aui:input>
		
	
				<aui:input name="arriveHour" value="<%=arriveHour%>"></aui:input>

<%
List<ESFAirport>  airport = ESFAirportLocalServiceUtil.getAllESFAirport();
String[] stopoverId = stopoverIdString.split("-");


List<KeyValuePair> leftListesfairport = new ArrayList<KeyValuePair>();
List<KeyValuePair> rightListesfairport  = new ArrayList<KeyValuePair>();

for(ESFAirport ar : airport){
	
	if(Arrays.asList(stopoverId).contains(String.valueOf(ar.getEsfAirportId())) ){
		rightListesfairport.add(new KeyValuePair(String.valueOf( ar.getEsfAirportId()), ar.getName()));
	}
}

for(ESFAirport a : airport){
	
	if(!Arrays.asList(stopoverId).contains(String.valueOf(a.getEsfAirportId())) ){
		leftListesfairport.add(new KeyValuePair(String.valueOf( a.getEsfAirportId()), a.getName()));
	}	
}
%>								 
		<H3><liferay-ui:message key="stopover">stopover</liferay-ui:message></H3>
	
		<aui:input name="values" type="hidden" />
		    <liferay-ui:input-move-boxes
		        leftBoxName="availableValuesairport"
		        leftList="<%= leftListesfairport%>"
		        leftReorder="true"
		        leftTitle="available"
		        rightBoxName="selectedValuesairport"
		        rightList="<%=rightListesfairport%>"
		        rightTitle="selected"
		    />		
				
				<aui:input id="isReturn" name="isReturn" type="checkbox" label="return-trips" checked="false"
							value='<%=esfDeparture != null
							? esfDeparture.getIsReturn()
							: StringPool.BLANK%>'></aui:input>
				
				<aui:input type = "hidden" name = "esfUserIds" id = "esfUserIds"
								label = ""/>
				
				<aui:input type = "hidden" name = "allPresentUsers" id = "allPresentUsers"
								 label = ""/>

</aui:fieldset>

			<portlet:renderURL var="goBackURL">
				<portlet:param name="mvcPath" value="/html/esfnationalmatch/management_esfMatch.jsp" />
				<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
				<portlet:param name="myParam" value="Itenerari" />
			</portlet:renderURL>

	
			<aui:button-row>
				<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_ITINERARY_ADD_ITINERARY) %>">	
					<aui:button type="submit" id = "submitForm" ></aui:button>
				</c:if>	
				<aui:button type="button" cssClass="btn btn-primary" 
					onClick="<%= goBackURL %>" value ="returnButton"></aui:button>
			</aui:button-row>
	</div>
	<% 


	
		int i = 0;
	%>

	<div class = "span7">
		
			<liferay-ui:search-container id="searchContainerId" emptyResultsMessage="no-results" delta="5" iteratorURL="<%=iteratorURL%>" >
				<liferay-ui:search-container-results 
					results="<%= ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(esfMatchId,
															searchContainer.getStart(), searchContainer.getEnd())%>" 
					total="<%= ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(esfMatchId).size() %>" />
				
				<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
					
					<%
						i++;
					
						ESFNationalDelegation esfNationalDelegation = 
							ESFNationalDelegationLocalServiceUtil.
										getESFNationalDelegationByESFUserId_ESFMatchId(
													esfUser.getEsfUserId(), esfMatchId).get(0);
					
						ESFPartecipantType ptype = 
											ESFPartecipantTypeLocalServiceUtil.
													fetchESFPartecipantType(
														esfNationalDelegation.
																getEsfPartecipantTypeId());
						
						String role = "";
						if(Validator.isNotNull(ptype)){
							role = ptype.getName();
						}
						
						boolean checked = false;
						
						if(esfUsersAssignedToDeparture.size() > 0 && 
										esfUsersAssignedToDeparture.contains(esfUser)){
							checked = true;
						}
						String idIesimo = "partecipant" + i;
					%>
					<liferay-ui:search-container-column-text name="" >
						
							<%--aui:input type = "checkbox" name = '<%=String.valueOf(idIesimo)%>' 
								id = '<%=String.valueOf(idIesimo)%>' label = "" checked = "<%=checked%>" 
								onChange='<%="addToArray(\'"+idIesimo+"\',\'"+esfUser.getEsfUserId()+"\');">'/--%>
							<aui:input type = "checkbox" name = '<%=String.valueOf(idIesimo)%>' 
								id = '<%=String.valueOf(idIesimo)%>' label = "" checked = "<%=checked%>" 
								onChange='<%="addToArray(\'"+idIesimo+"\',\'"+esfUser.getEsfUserId()+"\');"%>'/>
							
							<input type = "hidden" 
								label = "" class = "allIds" value = <%=esfUser.getEsfUserId()%>/>
							<%
								if(checked){
							%>
								<input type = "hidden" label = "" class = "allIdsPresent"
								 	value = <%=esfUser.getEsfUserId()%>/>
							<%	}
							%>
						
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text property="lastName"
						name="last-name" />
					
					<liferay-ui:search-container-column-text property="firstName"
						name="first-name" />
					
					<liferay-ui:search-container-column-text name="role"
							value="<%=res.getString(role)%>" />
							
					<liferay-ui:search-container-column-text property="userEmail"
						name="email" />

					<liferay-ui:search-container-column-text property="fiscalCode"
						name="fiscal-code" />
						
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
<h4>Ricordati di salvare prima di cliccare sui bottoni, altrimenti perdi le modifiche fatte !!!</h4>
	</aui:form>
	
</div>

<aui:script use="aui-base,node,aui-io-request,liferay-util-list-fields">

AUI().ready('event', function(A){
		var x = document.getElementsByClassName("allIds");
		values = A.one('#<portlet:namespace/>allPresentUsers').get('value');
		for(var i = 0; i < x.length; i++){
			values += x[i].value; 
		}
		A.one('#<portlet:namespace/>allPresentUsers').set('value', values);
		
		var y = document.getElementsByClassName("allIdsPresent");
		valuesPresent = A.one('#<portlet:namespace/>esfUserIds').get('value');
		for(var i = 0; i < y.length; i++){
			valuesPresent += y[i].value; 
		}
		A.one('#<portlet:namespace/>esfUserIds').set('value', valuesPresent);
	});


window.addToArray = function(idIesimo, esfUserIdHiden) {
	
	var oldValue = "";
	oldValue = A.one('#<portlet:namespace/>esfUserIds').get('value');
	
	if((A.one('#<portlet:namespace/>'+idIesimo).get('value')) === 'true'){
		A.one('#<portlet:namespace/>esfUserIds').set('value', oldValue + esfUserIdHiden + "/");
	}
	else{
		var esfUserIdLength = esfUserIdHiden.length;
		var startIndexOfElementToRemove = oldValue.indexOf(esfUserIdHiden + "/");
		if((startIndexOfElementToRemove + esfUserIdHiden.length + 1) <= oldValue.length ){
			var newValues = oldValue.substr(0 , startIndexOfElementToRemove) + 
					 oldValue.substr(startIndexOfElementToRemove + esfUserIdLength +1);
			A.one('#<portlet:namespace/>esfUserIds').set('value', newValues);
		}
	}
}

Liferay.provide(
		  window,
		  '<portlet:namespace />addStopover',
		  function() {
		   var A = AUI();
		    var selectedValues = Liferay.Util.listSelect('#<portlet:namespace/>selectedValuesairport');
		    A.one('#<portlet:namespace/>values').val(selectedValues);
		   submitForm(document.<portlet:namespace/>fm);
		  } );


</aui:script>
