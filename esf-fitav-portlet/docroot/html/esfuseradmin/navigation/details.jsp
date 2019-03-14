<%@include file="init.jsp"%>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);
	if(Validator.isNotNull(esfUser)){
		currDate =currDate=sdf.format(esfUser.getBirthday());;
	}
%>


<portlet:actionURL
	name='<%="prova"%>'
	var="provaUrl">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="paramUserId" value="" />
</portlet:actionURL>

<portlet:resourceURL var='fiscalCodeURL' id='<%="fiscalCode"%>'/>


<aui:script use="aui-base,node,aui-io-request">

A.one('#<portlet:namespace/>calculate').on('click', Calculate);

	function Calculate(event) {
		
		var lastName = A.one('#<portlet:namespace/>lastName').get('value');
		var firstName = A.one('#<portlet:namespace/>firstName').get('value');
		var middleName = A.one('#<portlet:namespace/>middleName').get('value');
		var birthcity = A.one('#<portlet:namespace/>birthcity').get('value');
		var male = A.one('#<portlet:namespace/>male').get('value');
		var birthday = A.one('#<portlet:namespace/>birthday').get('value');
		
		A.io.request(
				'<%= fiscalCodeURL %>',
				{
					method: 'POST',
					contentType: "application/json; charset=utf-8",
					dataType:'json',
					data: {
						<portlet:namespace/>lastName:lastName,
						<portlet:namespace/>firstName:firstName,
						<portlet:namespace/>middleName:middleName,
						<portlet:namespace/>birthcity:birthcity,
						<portlet:namespace/>male:male,
						<portlet:namespace/>birthday:birthday
					},
					on: {
						success: function() {
							var ok ="ok";
							var results = this.get('responseData');
							var fiscalcode = results.fiscalCode;
							var message = "";
							if(results.result == ok){
							
								document.getElementById("<portlet:namespace/>fiscalCode").value = fiscalcode;
							
							}
							else{
								if(01 == fiscalcode){
									message="controllare che i dati inseriti siano esatti";
								}
								else{
									message="errore di connessione";
								}
								alert(message);
								document.getElementById("<portlet:namespace/>fiscalCode").value = "";
							}
						}
					}	
				});
		
				
	
	}
	
	$(function() {
		$("#<portlet:namespace/>birthday").datepicker();
		$("#<portlet:namespace/>birthday").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>birthday").datepicker("setDate",
				'<%= currDate %>');

		});

</aui:script>

<aui:fieldset>

	<aui:model-context bean="<%=esfUser%>" model="<%=ESFUser.class%>" />

	<aui:input type="hidden" name="esfUserId"
		value='<%=esfUser == null ? "" : esfUser.getEsfUserId()%>' />

<div class="row">
		<div class="span6">
			<div id="idOne">

	<aui:input name="lastName" id="lastName">
		<aui:validator name="required" errorMessage="please-enter-a-lastname" />
	</aui:input>
	
	<aui:input name="firstName">
		<aui:validator name="required" errorMessage="please-enter-a-name" />
	</aui:input>

	<aui:input name="middleName" type="text"
		value='<%=Validator.isNotNull(esfUser) ?
					esfUser.getOriginalUser().getMiddleName() : ""%>' />

	<aui:select label="gender" name="male">
		<aui:option label="male" value="true" />
		<aui:option label="female" value="false" />
	</aui:select>
	
	<aui:input name="birthcity" />

			</div>
		</div>
		
<div class="span6">
			<div id="idOne">
	<aui:input name="fiscalCode" id="fiscalCode">
		<aui:validator name="minLength"	errorMessage="please-enter-correct-fiscalcode">16</aui:validator>
		<aui:validator name="maxLength"	errorMessage="please-enter-correct-fiscalcode">16</aui:validator>
	</aui:input>
	
	<aui:button type="button" value="calculate" name="calculate"></aui:button>

	<aui:input id="emailaddresses" name="userEmail">
		<aui:validator name="email" />
		<aui:validator name="required" errorMessage="please-enter-a-useremail" />
	</aui:input>

	<aui:input name="birthday" type="text" />
<%String job = "";
if(Validator.isNotNull(esfUser)){
	job = esfUser.getJob();
}
%>
	<aui:input name="work" type="text" value="<%=job%>" /> 
	
<!-- MAC_002 - to be confirmed -->
<%-- 	<aui:input type="hidden" name="esfStateId" --%>
<%-- 		value="<%=ESFKeys.ESFStateType.ENABLE%>" /> --%>

			</div>
		</div>
</div>
</aui:fieldset>


