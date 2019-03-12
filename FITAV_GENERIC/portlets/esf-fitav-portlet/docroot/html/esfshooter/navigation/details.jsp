<%@include file="init.jsp"%>

<%
	boolean ckval = false;
	boolean showBottons= false; 
	boolean readOnlyFC = false; 

	if (Validator.isNotNull(esfUser) && esfUser.getTypearmy() > 0) {
		ckval = true;
	}
	
	String jobArea = "jobArea";

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = "";

	if (Validator.isNotNull(esfUser)) {
		currDate = sdf.format(esfUser.getBirthday());

	} else {
		currDate = ManageDate.CalendarToString(calendar);
	}
	String deathDate = "";
	
	

	if(Validator.isNotNull(esfUserId)){
		showBottons=ESFShooterPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFSHOOTER_UPDATE) ;
	}else{
		showBottons=ESFShooterModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFSHOOTER_ADD) ;
	}
	
	if(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getValidateCF()) && esfUser.getValidateCF()){
		readOnlyFC = true;
	}


%>


<portlet:resourceURL var='fiscalCodeURL' id='<%="fiscalCode"%>' />

<aui:script use="aui-base,node,aui-io-request">
	A.one('#<portlet:namespace/>calculate').on('click', Calculate);

	function Calculate(event) {
		
		console.log("calculate");
		var lastName = A.one('#<portlet:namespace/>lastName').get('value');
		var firstName = A.one('#<portlet:namespace/>firstName').get('value');
		var middleName = A.one('#<portlet:namespace/>middleName').get('value');
		var birthcity = A.one('#<portlet:namespace/>birthcity').get('value');
		var birthday = A.one('#<portlet:namespace/>birthday').get('value');
		var male = A.one('#<portlet:namespace/>male').get('value');
		console.log(lastName);
		console.log(firstName);
		A.io
				.request(
						'<%= fiscalCodeURL %>',
						{
							method : 'POST',
							contentType : "application/json; charset=utf-8",
							dataType : 'json',
							data : {
								<portlet:namespace/>lastName : lastName,
								<portlet:namespace/>firstName : firstName,
								<portlet:namespace/>middleName : middleName,
								<portlet:namespace/>birthcity : birthcity,
								<portlet:namespace/>male : male,
								<portlet:namespace/>birthday : birthday
							},
							on : {
								success : function() {
									var ok = "ok";
									var results = this.get('responseData');
									var fiscalcode = results.fiscalCode;
									var message = "";
									if (results.result == ok) {

										document
												.getElementById("<portlet:namespace/>fiscalCode").value = fiscalcode;

									} else {
										if (01 == fiscalcode) {
											message = "controllare che i dati inseriti siano esatti";
										}
										if(02 == fiscalcode) {
											message = "comune non trovato";
										}
										alert(message);
										document
												.getElementById("<portlet:namespace/>fiscalCode").value = "";
									}
								}
							}
						});
	}

	$(function() {
		$("#<portlet:namespace/>birthday").datepicker();
		$("#<portlet:namespace/>birthday").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>birthday").datepicker("setDate",
				'<%= currDate %>');

	});
	
	$(function() {
		$("#<portlet:namespace/>dateOfDeathString").datepicker();
		$("#<portlet:namespace/>dateOfDeathString").datepicker("option", "dateFormat",
				"dd/mm/yy");
	});
	
	

	
</aui:script>

<aui:fieldset>

	<aui:model-context bean="<%=esfUser%>" model="<%=ESFUser.class%>" />

	<aui:input type="hidden" name="esfUserId"
		value='<%=esfUser == null ? "" : esfUser.getEsfUserId()%>' />


	<div class="row">
		<div class="span6">
			<div id="idOne">

				<aui:input name="firstName">
					<aui:validator name="required" errorMessage="please-enter-a-name" />
				</aui:input>

				<aui:input name="middleName" type="text"
					value='<%=Validator.isNotNull(esfUser) ? esfUser.getOriginalUser().getMiddleName() : ""%>' />

				<aui:input name="lastName">
					<aui:validator name="required" errorMessage="please-enter-a-lastname" />
				</aui:input>

				<aui:input name="birthcity" />
				
				<aui:input name="oldShooterCode" type="text"
					value='<%=Validator.isNotNull(esfUser) ? 
							esfUser.getCodeUser() : ""%>' >
					<aui:validator name="number" />
				</aui:input>
			</div>
		</div>
		<div class="span6">
			<div id="idOne">
				<aui:select label="gender" name="male">
					<aui:option label="male" value="true" />
					<aui:option label="female" value="false" />
				</aui:select>
				
			<div  class="btn-field-align">
			
				<div id="showModificableCF">
					<aui:input name="fiscalCode" inlineField="true" type="text">
						<aui:validator name="minLength"
							errorMessage="please-enter-correct-fiscalcode">16</aui:validator>
						<aui:validator name="maxLength"
							errorMessage="please-enter-correct-fiscalcode">16</aui:validator>
					</aui:input>
					<liferay-ui:error key="error" message="error-fiscal-code" />
	
					<aui:button type="button" value="calculate" name="calculate" inlineField="true"></aui:button>
				</div>
				
				<div id="showNotModificableCF">
					<aui:input name="fiscalCodeNotModificable" inlineField="true" 
					type="text" value="<%=(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getFiscalCode()))?
							esfUser.getFiscalCode() :StringPool.BLANK%>" disabled="true" label="fiscalCode"/>
					<%if(!showBottons){ %>
						<aui:input name="validateCFNOtModificable" type="checkbox" checked="true" label="validateCF" disabled="true"/>
					<% }%>
				</div>
				
				<%if(showBottons ){ 
					if(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getFiscalCode()) && !StringPool.BLANK.equals(esfUser.getFiscalCode())){
					%>
						<aui:input name="validateCF" type="checkbox" checked="<%= readOnlyFC %>" label="validateCF" onChange="showCF()"/>
				<%	}
				
				}%>
			</div>
			
				<aui:input id="emailaddresses" name="userEmail">
					<aui:validator name="email" />
					<aui:validator name="required"
						errorMessage="please-enter-a-useremail" />
				</aui:input>
				
				<%
				if(Validator.isNotNull(esfUser)){
						if(Validator.isNotNull(esfUser.getDateOfDeath())){
							deathDate = sdf.format(esfUser.getDateOfDeath());
						}
				%>
					<aui:input name="dateOfDeathString" label="dateOfDeathString" type="text" value="<%=deathDate %>" />
				<%} %>
			</div>
		</div>
	</div>

	<div class="separator"></div>

	<div class="row">
		<div class="span6">
			<div id="idOne">

				<aui:input name="birthday" type="text" />

				<aui:select id="nationality" name="nationality"
					showEmptyOption="true" required="false">
					<%
						List<ESFCountry> countries = ESFCountryLocalServiceUtil.getESFCountries(0,
										ESFCountryLocalServiceUtil.getESFCountriesCount());

								for (ESFCountry country : countries) {
									if (Validator.isNotNull(esfUser)
											&& country.getIdCountry().equals("" + esfUser.getNationality())) {
					%>
					<aui:option label="<%=country.getName()%>"
						value="<%=country.getIdCountry()%>" selected="<%=true%>" />
					<%
						} else {
					%>
					<aui:option label="<%=country.getName()%>"
						value="<%=country.getIdCountry()%>" />
					<%
						}
								}
					%>
				</aui:select>

				<aui:input name="issfIdNumber" type="text" label="issfIdNumber" />

			</div>
		</div>
		<div class="span6">
			<div id="idOne">
				<label class="control-label"><%=res.getString(jobArea)%></label> 
				<select name="<portlet:namespace/>job">

					<%
						List<ESFJob> esfJob = ESFJobLocalServiceUtil.findAll();
						boolean isValid=Validator.isNotNull(esfUser);
							for (ESFJob j : esfJob) {
								if (isValid && j.getEsfName().equalsIgnoreCase(esfUser.getJobTitle())) {
					%>
					<option label="<%=j.getEsfName()%>" value="<%=j.getEsfName()%>"
						selected="<%=true%>" />

					<%
						} else {
					%>
					<option label="<%=j.getEsfName()%>" value="<%=j.getEsfName()%>" />

					<%
						}
							}
					%>
				</select>
				<%
					String jobUser = "";
					if (Validator.isNotNull(esfUser)) {
						jobUser = esfUser.getJob();
					}
				%>
				<aui:input name="work" type="text" value="<%=jobUser%>" />

				<aui:input name="ckisarmy" type="checkbox" onChange="showArmy();" checked="<%= ckval %>" />
				
				<div id="army-content">
				
					<aui:select id="typearmy" name="typearmy" required="false">
					
						<aui:option label="-" value="0" />
						<%
							List<ListType> armys = 
								ListTypeServiceUtil.getListTypes(ESFUser.class.getName() + ESFListType.TYPEARMY);

							for (ListType army : armys) {
						%>
								<aui:option label="<%=army.getName()%>"
									value="<%=army.getListTypeId()%>" />
						<%
							}
						%>
					</aui:select>
					<%
						boolean isSportsGroupsUser = false;
						if (Validator.isNotNull(esfUser) && esfUser.getIsSportsGroups()) {
							isSportsGroupsUser = true;
						}
					%>
					<aui:input id="isSportsGroups" name="isSportsGroups"
						type="checkbox" checked="<%=isSportsGroupsUser%>"
						label="is-sports-groups" />

				</div>

			</div>
		</div>
	</div>
	
</aui:fieldset>



<aui:script use="aui-base,node,aui-io-request">

var status = '<%=ckval %>';
var statusCF = '<%= readOnlyFC%>';

window.showArmy = function() {
	
	if (status) {
		A.one('#army-content').show();
		status = false;
	} else {
		A.one('#army-content').hide();
		status = true;
	}
}

if (status!='true' ) {
	A.one('#army-content').hide();
	status = true;
} else {
	status = false;
}

window.showCF = function(){
	console.log("click statusCF="+statusCF)
	if(statusCF){
		
		A.one('#showModificableCF').hide();
		A.one('#showNotModificableCF').show();

		statusCF = false;
	} else {
		
		A.one('#showModificableCF').show();
		A.one('#showNotModificableCF').hide();

		statusCF = true;
	}
	
}

if(statusCF !="false" ){

	A.one('#showModificableCF').hide();
	A.one('#showNotModificableCF').show();
	statusCF = false;
} else{
	
	A.one('#showModificableCF').show();
	A.one('#showNotModificableCF').hide();
	statusCF = true;
}
</aui:script>
