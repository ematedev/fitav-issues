
<%@ include file="init.jsp"%>

<%
	ESFDeparture esfDeparture = null;
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	long esfDepartureId = ParamUtil.getLong(request, "esfDepartureId");
	
	if( esfDepartureId == 0){
		esfDepartureId =ParamUtil.getLong(request, "esfDepartureId");
	}
	
	if (esfDepartureId > 0) {

		esfDeparture = ESFDepartureLocalServiceUtil.getESFDeparture(esfDepartureId);
	
	}
	
	List <ESFUser> tempESFUsers = ESFUserLocalServiceUtil.getESFUsersByDeparture(esfDepartureId);
	List<ESFUser> esfUsersAssignedToDeparture = new ArrayList<ESFUser>();
	
	
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
	<aui:form name="fm" action = "<%=editESFDepartureURL%>">
	<div class = "span4">
			<aui:model-context bean="<%=esfDeparture%>"
				model="<%=ESFDeparture.class%>" />
	
			<aui:fieldset>
				<aui:input type="hidden" name="esfDepartureId"
					value='<%=esfDepartureId%>' />
				<aui:input type="hidden" name ="isBus" value="true"/>
				<aui:input name="code" type="text" label="code" value='<%=code%>' required="true">
					
				</aui:input>
				<aui:input name="companyName" type="text" label="CompanyName"
					value='<%=companyName%>'>
					
				</aui:input>
				<aui:select label="typeTravel" name="typeTravel" showEmptyOption="true">
					<%
						List<String> typeTravel = new ArrayList<String>();
						typeTravel.add("MEZZO PROPRIO");
						typeTravel.add("MEZZO A NOLEGGIO");
						for (String tT : typeTravel) {
							String nome = tT;
					%>
					<aui:option label="<%=  nome %>" value="<%= nome %>"></aui:option>
					<%
						}
					%>
				</aui:select>
				<aui:input name="departureFrom" type="text"/>
				<aui:input label="meetingPlace" name="meetingPlace" value=""/>
				<aui:input name="leaveDate" type="text">
					
				</aui:input>
	
				<aui:input name="leaveHour" value="<%=leaveHour%>">
					
				</aui:input>
				<aui:input name="arrivalTo" type="text"/>
				<aui:input name="arriveDate" type="text">
					
				</aui:input>
	
				<aui:input name="arriveHour" value="<%=arriveHour%>"></aui:input>
				
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
					<aui:button type="submit" id = "submitForm" />
				</c:if>
				<aui:button type="button" cssClass="btn btn-primary" 
					onClick="<%= goBackURL %>" value = "returnButton"></aui:button>
			</aui:button-row>
	</div>
	<% 
		/*
			viene aggiunto alla fine del nome di ogni variabile checkbox per distinguire
			i vari utenti
		*/
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

					<liferay-ui:search-container-column-text property="jobTitle"
						name="job-title" />
						
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
			<h4>Ricordati di salvare prima di cliccare sui bottoni, altrimenti perdi le modifiche fatte !!!</h4>
			
		</div>
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

</aui:script>