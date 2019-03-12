
<%@include file="init.jsp"%>

	<%
		boolean ckval=false;
		if(Validator.isNotNull(esfUser) && esfUser.getTypearmy()>0){
			ckval=true;
		}
		String jobArea="jobArea";
		%>
<portlet:resourceURL var='fiscalCodeURL' id='<%="fiscalCode"%>'/>
	<aui:script use="aui-base,node,aui-io-request">
	
	A.one('#<portlet:namespace/>calculate').on('click', Calculate);

	function Calculate(event) {
		
		var lastName = A.one('#<portlet:namespace/>lastName').get('value');
		var firstName = A.one('#<portlet:namespace/>firstName').get('value');
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
	
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = "";
	
			if(Validator.isNotNull(esfUser)){
				currDate=sdf.format(esfUser.getBirthday());
				
			}
			else{
				currDate=ManageDate.CalendarToString(calendar);	
			}
					
	%>

	$(function() {
			$("#<portlet:namespace/>birthday").datepicker();
			$("#<portlet:namespace/>birthday").datepicker("option",
					"dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>birthday").datepicker("setDate",
					'<%= currDate %>');

		});

		var status='<%=ckval %>';
	 	
		window.showArmy = function() {
			if(status){
				A.one('#army-content').show();
				status=false;
			}else{
				A.one('#army-content').hide();
				status=true;
			}
		}
		
		if(status!='true'){
			 A.one('#army-content').hide();
			 status=true;
		}else{
			status=false;
		}
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
					value='<%=Validator.isNotNull(esfUser) ?
								esfUser.getOriginalUser().getMiddleName() : ""%>' />
			
				<aui:input name="lastName">
					<aui:validator name="required" errorMessage="please-enter-a-lastname" />
				</aui:input>
	
				<aui:input name="birthcity" />
			</div>
		</div>
	<div class="span6">
		<div id="idOne">
			<aui:select label="gender" name="male">
				<aui:option label="male" value="true" />
				<aui:option label="female" value="false" />
			</aui:select>

	<aui:input name="fiscalCode">
		<aui:validator name="minLength"	errorMessage="please-enter-correct-fiscalcode">16</aui:validator>
		<aui:validator name="maxLength"	errorMessage="please-enter-correct-fiscalcode">16</aui:validator>
		
	</aui:input>
	<liferay-ui:error key="error" message="error-fiscal-code" />
	
	<aui:button type="button" value="calculate" name="calculate"></aui:button>
	
	<aui:input id="emailaddresses" name="userEmail">
		<aui:validator name="email" />
		<aui:validator name="required" errorMessage="please-enter-a-useremail" />
	</aui:input>
			
			</div>
		</div>	
</div>		

<div class="separator"></div>

<div class="row">
	<div class="span6">
			<div id="idOne">
			
				<aui:input name="birthday" type="text" />

	<aui:select id="nationality" name="nationality" showEmptyOption="true" required="false">
		<%
			List<ESFCountry> countries=ESFCountryLocalServiceUtil.
					getESFCountries(0, ESFCountryLocalServiceUtil.getESFCountriesCount());

			for (ESFCountry country : countries) {
				if(Validator.isNotNull(esfUser) && country.getIdCountry().equals(""+esfUser.getNationality())){
					%>
					<aui:option label="<%=country.getName()%>"
						value="<%=country.getIdCountry()%>" />
					<%
				}else{
					%>
					<aui:option label="<%=country.getName()%>"
						value="<%=country.getIdCountry()%>" />
					<%
				}
			}
		%>
	</aui:select>
			
		<aui:input name="issfIdNumber" type="text" label="issfIdNumber"/>

	</div>
</div>
	<div class="span6">
		<div id="idOne">
		
			<label class="control-label" ><%=res.getString(jobArea) %></label>
		<select   name="<portlet:namespace/>job">
				<option label="-" value = "-"/>
				<% 
				List<ESFJob> esfJob= ESFJobLocalServiceUtil.findAll();
				
					for(ESFJob j : esfJob){
						if(j.getEsfName().equalsIgnoreCase(esfUser.getJobTitle())){
				%>
				<option label="<%=j.getEsfName()%>"  
					value = "<%=j.getEsfName()%>" selected="<%=true %>"  />
				
				<%	
						}else{%>
				<option label="<%=j.getEsfName()%>"  
					value = "<%=j.getEsfName()%>" />
							
					<%	}
				}%>
			</select>
			
<%String jobUser = "";
if(Validator.isNotNull(esfUser)){
	jobUser = esfUser.getJob();
}
%>
	<aui:input name="work" type="text" value="<%=jobUser%>" /> 
			
	<%
		if(ckval){
	%>
			<aui:input name="ckisarmy" type="checkbox" onChange="showArmy();" checked="true" />
	<%
		}else{
	%>	
		<aui:input name="ckisarmy" type="checkbox" onChange="showArmy();" checked="false" />
	<%
		}
	%>
	<div id="army-content">
		<aui:select id="typearmy" name="typearmy" showEmptyOption="false" required="false">
		<%
			List<ListType> armys =  ListTypeServiceUtil.getListTypes(ESFUser.class.getName() + ESFListType.TYPEARMY);

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
		if(Validator.isNotNull(esfUser) && esfUser.getIsSportsGroups()){
			isSportsGroupsUser = true;
		}
		
		%>
		<aui:input id="isSportsGroups" name="isSportsGroups" type="checkbox" checked="<%=isSportsGroupsUser %>" label="is-sports-groups" />
		
	</div>


		</div>
	</div>
</div>	

</aui:fieldset>