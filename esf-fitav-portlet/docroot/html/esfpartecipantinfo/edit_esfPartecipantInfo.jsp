<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFPartecipantInfo"%>
<%@ include file="init.jsp"%>

<%
	String namespace = renderResponse.getNamespace();
	ESFPartecipantInfo esfPartecipantInfo = null;

	List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();
	/*long esfGunTypeId = 0;
	
	ESFGunKind esfGunKind = null;*/
	
	long esfPartecipantInfoId = ParamUtil.getLong(request, "esfPartecipantInfoId");

	if (esfPartecipantInfoId > 0) {

		 esfPartecipantInfo = ESFPartecipantInfoLocalServiceUtil.
							getESFPartecipantInfo(esfPartecipantInfoId);
	}
	
	

	String firstName = "";
	String lastName = "";
	String isPortalUser = "false";
	String protocol = "";
	String placeOfBirth = "";
	String dateOfBirth = "";
	String residenceCity = "";
	String province = "";
	String zip = "";
	String address = "";
	String phoneNumber = "";
	String email = "";
	String maritialStatus = "";
	String fiscalCode = "";
	String releasedBy = "";
	String passportReleaseDate = "";
	String passportExpirationDate = "";
	String passport = "";
	String europeanCardNumber = "";
	String europeanCardReleaseDate = "";
	String europeanCardExpirationDate = "";
	String gunLicenceNumber = "";
	String gunLicenceReleaseDate = "";
	String gunLicenceExpirationDate = "";
	String firstGunType = "";
	String firstGunExtraCanes = "";
	String firstGunKind = "";
	String firstGunCaliber = "";
	String firstGunCode = "";
	String secondGunType = "";
	String secondGunKind = "";
	String secondGunCaliber = "";
	String secondGunCode = "";
	String secondGunExtraCanes = "";
	String gunCartridgeType = "";
	String gunCartridgeKind = "";
	String cartridgeCaliber = "";
	String esfMatchId = "";
	String esfUserId = "";
	long firstGunTypeId = 0;
	long firstGunKindId = 0; 
	long secondGunTypeId = 0;
	long secondGunKindId = 0;

	if (Validator.isNotNull(esfPartecipantInfo)) {
		firstName = String.valueOf(esfPartecipantInfo.getFirstName());
		lastName = String.valueOf(esfPartecipantInfo.getLastName());
		isPortalUser = String.valueOf(esfPartecipantInfo.getIsPortalUser());
		esfUserId = String.valueOf(esfPartecipantInfo.getEsfUserId());
		protocol = String.valueOf(esfPartecipantInfo.getProtocol());
		placeOfBirth = String.valueOf(esfPartecipantInfo.getPlaceOfBirth());
		dateOfBirth = ManageDate.DateToString(esfPartecipantInfo.getDateOfBirth());
		residenceCity = String.valueOf(esfPartecipantInfo.getResidenceCity());
		province = String.valueOf(esfPartecipantInfo.getProvince());
		zip = String.valueOf(esfPartecipantInfo.getZip());
		if(zip.equals("0")){
			zip = "";
		}
		address = String.valueOf(esfPartecipantInfo.getAddress());
		phoneNumber = String.valueOf(esfPartecipantInfo.getPhonNumber());
		email = String.valueOf(esfPartecipantInfo.getEmail());
		maritialStatus = String.valueOf(esfPartecipantInfo.getMaritialStatus());
		releasedBy = String.valueOf(esfPartecipantInfo.getReleasedBy());
		passportReleaseDate = ManageDate.DateToString(esfPartecipantInfo.getPassportReleaseDate());
		fiscalCode = String.valueOf(esfPartecipantInfo.getFiscalCode());
		passportExpirationDate = ManageDate.DateToString(esfPartecipantInfo.getPassportExpirationDate());
		passport = String.valueOf(esfPartecipantInfo.getPassport());
		europeanCardReleaseDate = ManageDate.DateToString(esfPartecipantInfo.getEuropeanCardReleaseDate());
		europeanCardExpirationDate = ManageDate.DateToString(esfPartecipantInfo.getEuropeanCardExpirationDate());
		europeanCardNumber = String.valueOf(esfPartecipantInfo.getEuropeanCardNumber());
		gunLicenceNumber = String.valueOf(esfPartecipantInfo.getGunLicenceNumber());
		gunLicenceReleaseDate = ManageDate.DateToString(esfPartecipantInfo.getGunLicenceReleaseDate());
		gunLicenceExpirationDate = ManageDate.DateToString(esfPartecipantInfo.getGunLicenceExpirationDate());
		firstGunType = String.valueOf(esfPartecipantInfo.getFirstGunType());
		firstGunKind = String.valueOf(esfPartecipantInfo.getFirstGunKind());
		firstGunCaliber = String.valueOf(esfPartecipantInfo.getFirstGunCaliber());
		if(firstGunCaliber.equals("0.0")){
			firstGunCaliber = "";
		}
		firstGunCode = String.valueOf(esfPartecipantInfo.getFirstGunCode());
		firstGunExtraCanes = String.valueOf(esfPartecipantInfo.getFirstGunExtraCanes());
		secondGunType = String.valueOf(esfPartecipantInfo.getSecondGunType());
		secondGunKind = String.valueOf(esfPartecipantInfo.getSecondGunKind());
		secondGunCaliber = String.valueOf(esfPartecipantInfo.getSecondGunCaliber());
		if(secondGunCaliber.equals("0.0")){
			secondGunCaliber = "";
		}
		secondGunCode = String.valueOf(esfPartecipantInfo.getSecondGunCode());
		secondGunExtraCanes = String.valueOf(esfPartecipantInfo.getSecondGunExtraCanes());
		gunCartridgeType = String.valueOf(esfPartecipantInfo.getGunCartridgeType());
		gunCartridgeKind = String.valueOf(esfPartecipantInfo.getGunCartridgeKind());
		cartridgeCaliber = String.valueOf(esfPartecipantInfo.getCartridgeCaliber());
		secondGunCaliber = String.valueOf(esfPartecipantInfo.getSecondGunCaliber());
		secondGunCaliber = String.valueOf(esfPartecipantInfo.getSecondGunCaliber());
		esfMatchId = String.valueOf(esfPartecipantInfo.getEsfMatchId());
		esfUserId = String.valueOf(esfPartecipantInfo.getEsfUserId());
		firstGunTypeId = esfPartecipantInfo.getEsfGunTypeIdOne();
		firstGunKindId = esfPartecipantInfo.getEsfGunKindIdOne();
		secondGunTypeId = esfPartecipantInfo.getEsfGunTypeIdTwo();
		secondGunKindId = esfPartecipantInfo.getEsfGunKindIdTwo();
	
	}else{
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		dateOfBirth = ManageDate.CalendarToString(calendar);	
		passportReleaseDate = ManageDate.CalendarToString(calendar);
		passportExpirationDate = ManageDate.CalendarToString(calendar);
		europeanCardReleaseDate = ManageDate.CalendarToString(calendar);
		europeanCardExpirationDate = ManageDate.CalendarToString(calendar);
		gunLicenceReleaseDate = ManageDate.CalendarToString(calendar);
		gunLicenceExpirationDate = ManageDate.CalendarToString(calendar);
	}
%>

<portlet:resourceURL var="resourceURL" escapeXml="false" />

<portlet:resourceURL var="resourceOneURL" escapeXml="false" />

<portlet:renderURL var="chooseAssociationURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>

<aui:script>
	$(function() {
		$("#<portlet:namespace/>dateOfBirth").datepicker();
		$("#<portlet:namespace/>dateOfBirth").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>dateOfBirth").datepicker("setDate",
				'<%= dateOfBirth %>');
	});
	$(function() {
		$("#<portlet:namespace/>passportReleaseDate").datepicker();
		$("#<portlet:namespace/>passportReleaseDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>passportReleaseDate").datepicker("setDate",
				'<%= passportReleaseDate %>');
	});
	$(function() {
		$("#<portlet:namespace/>passportExpirationDate").datepicker();
		$("#<portlet:namespace/>passportExpirationDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>passportExpirationDate").datepicker("setDate",
				'<%= passportExpirationDate %>');
	});
	$(function() {
		$("#<portlet:namespace/>europeanCardReleaseDate").datepicker();
		$("#<portlet:namespace/>europeanCardReleaseDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>europeanCardReleaseDate").datepicker("setDate",
				'<%= europeanCardReleaseDate %>');
	});

	$(function() {
		$("#<portlet:namespace/>europeanCardExpirationDate").datepicker();
		$("#<portlet:namespace/>europeanCardExpirationDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>europeanCardExpirationDate").datepicker("setDate",
				'<%= europeanCardExpirationDate %>');
	});

	$(function() {
		$("#<portlet:namespace/>gunLicenceReleaseDate").datepicker();
		$("#<portlet:namespace/>gunLicenceReleaseDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>gunLicenceReleaseDate").datepicker("setDate",
				'<%= gunLicenceReleaseDate %>');
	});

	$(function() {
		$("#<portlet:namespace/>gunLicenceExpirationDate").datepicker();
		$("#<portlet:namespace/>gunLicenceExpirationDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>gunLicenceExpirationDate").datepicker("setDate",
				'<%= gunLicenceExpirationDate %>');
	});
	
</aui:script>
<portlet:actionURL name="editESFPartecipantInfo"
	var="editESFPartecipantInfoURL">
	<portlet:param name="esfPartecipantInfoId"
		value="<%=String.valueOf(esfPartecipantInfoId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFPartecipantInfoURL%>" name="fm">


<h3>
	<liferay-ui:message key="general-info" /> : 
</h3>

<%
String display="";
String inserted="";
if (Validator.isNotNull(ParamUtil.getString(request, "inserted"))){
inserted = ParamUtil.getString(request, "inserted");
}
if (!firstName.equals("") || !inserted.equals("")){
	display="none";
}
%>
<div style = "display:<%=display%>;">
<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
				id='<%=namespace + "chooseAssociationTrigger"%>' value="add-shooter">
</aui:button>
</div>

	<div class="general-info row-fluid">
		<div class="span4">
			<aui:input name="firstName" id="firstName" type="text"
				label="first-name" value='<%=firstName%>'>
				<aui:validator name="required" />
			</aui:input>

			<aui:input name="lastName" id="lastName" type="text"
				label="last-name" value='<%=lastName%>'>
				<aui:validator name="required" />
			</aui:input>

			<aui:input name="placeOfBirth" id="placeOfBirth" type="text"
				label="place-of-birth" value='<%=placeOfBirth%>'>
			</aui:input>

			<aui:input name="maritialStatus" id="maritialStatus" type="text"
				label="maritial-status" value='<%=maritialStatus%>'>
			</aui:input>

			<aui:input name="dateOfBirth" id="dateOfBirth" type="text"
				label="date-of-birth" value='<%=dateOfBirth%>'>
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="span4">

			<aui:input name="residenceCity" id="residenceCity" type="text"
				label="residence-city" value='<%=residenceCity%>'>
			</aui:input>

			<aui:input name="province" id="province" type="text" label="province"
				value='<%=province%>'>
			</aui:input>

			<aui:input name="zip" id="zip" type="text" label="zip"
				value='<%=zip%>'>
			</aui:input>

			<aui:input id="address" name="address" type="text" label="address"
				value='<%=address%>'>
			</aui:input>

			<aui:input id="phoneNumber" name="phoneNumber" type="text"
				label="phone-number" value='<%=phoneNumber%>'>
			</aui:input>
		</div>
		<div class="span4">

			<aui:input name="email" id="email" type="text" label="email"
				value='<%=email%>'>
				<aui:validator name="required" />
			</aui:input>

			<aui:input name="fiscalCode" id="fiscalCode" type="text"
				label="fiscal-code" value='<%=fiscalCode%>'>
			</aui:input>
		</div>
	</div>
	<div class="separator"></div>
	<h3>
		<liferay-ui:message key="documents-info" />
		:
	</h3>
	<div class="documents row-fluid">
		<div class="span4">
			<aui:input name="passport" id="passport" type="text"
				label="passport-number" value='<%=passport%>'>
			</aui:input>

			<aui:input name="releasedBy" id="releasedBy" type="text"
				label="released-by" value='<%=releasedBy%>'>
			</aui:input>

			<aui:input name="passportReleaseDate" id="passportReleaseDate"
				type="text" label="passport-release-date"
				value='<%=passportReleaseDate%>'>
			</aui:input>

			<aui:input name="passportExpirationDate" id="passportExpirationDate"
				type="text" label="passport-expiration-date"
				value='<%=passportExpirationDate%>'>
			</aui:input>
		</div>
		<div class="span4">
			<aui:input name="europeanCardNumber" id="europeanCardNumber"
				type="text" label="european-card-number"
				value='<%=europeanCardNumber%>'>
			</aui:input>

			<aui:input name="europeanCardReleaseDate"
				id="europeanCardReleaseDate" type="text"
				label="european-card-release-date"
				value='<%=europeanCardReleaseDate%>'>
			</aui:input>

			<aui:input name="europeanCardExpirationDate"
				id="europeanCardExpirationDate" type="text"
				label="european-card-expiraion-date"
				value='<%=europeanCardExpirationDate%>'>
			</aui:input>
		</div>
		<div class="span4">
			<aui:input name="gunLicenceNumber" id="gunLicenceNumber" type="text"
				label="gun-licence-number" value='<%=gunLicenceNumber%>'>
			</aui:input>

			<aui:input name="gunLicenceReleaseDate" id="gunLicenceReleaseDate"
				type="text" label="gun-licence-release-date"
				value='<%=gunLicenceReleaseDate%>'>
			</aui:input>

			<aui:input name="gunLicenceExpirationDate"
				id="gunLicenceExpirationDate" type="text"
				label="gun-licence-expiration-date"
				value='<%=gunLicenceExpirationDate%>'>
			</aui:input>
		</div>
	</div>
	<div class="separator"></div>
	<h2>
		<liferay-ui:message key="guns-info" />
		:
	</h2>
	<div class="guns-info row-fluid">
		<div class="span4">
			<h4>
				<liferay-ui:message key="first-gun-info" />
				:
			</h4>
			<aui:select name="esfGunTypeIdOne"
				id="esfGunTypeIdOne" label="first-gun-type">
				<aui:option label="-" value="0" />
				<%
					for (ESFGunType esfGunType : esfGunTypes) {

						if(esfGunType.getEsfGunTypeId() == firstGunTypeId){
				%>
				<aui:option label="<%=esfGunType.getName()%>"
					value="<%=esfGunType.getEsfGunTypeId()%>" selected="true" />
				<%
					}
						else{
				%>
				<aui:option label="<%=esfGunType.getName()%>"
					value="<%=esfGunType.getEsfGunTypeId()%>" />
				<%
					}
					}
				%>
			</aui:select>

			<aui:select name="esfGunKindIdOne" id="esfGunKindIdOne"
				label="first-gun-kind">
				<%
					if(firstGunKindId != 0){
				%>

				<aui:option label="<%=firstGunKind%>"
					value="<%=String.valueOf(firstGunKindId)%>" selected="true" />

				<%
					}
				%>
			</aui:select>

			<aui:input name="firstGunCaliber" id="firstGunCaliber" type="text"
				label="first-gun-caliber" value='<%=firstGunCaliber%>'>
			</aui:input>

			<aui:input name="firstGunCode" id="firstGunCode" type="text"
				label="first-gun-code" value='<%=firstGunCode%>'>
			</aui:input>

			<aui:input name="firstGunExtraCanes" id="firstGunExtraCanes"
				label="first-gun-canes-extra"
				value='<%=firstGunExtraCanes%>'
				type='hidden'>
			</aui:input>

		</div>
		<div class="span4">
			<h4>
				<liferay-ui:message key="second-gun-info" />
				:
			</h4>
			<aui:select name="esfGunTypeIdTwo" id="esfGunTypeIdTwo"
				label="second-gun-type">
				<aui:option label="-" value="0" />
				<%
					for (ESFGunType esfGunType : esfGunTypes) {

						if(esfGunType.getEsfGunTypeId() == secondGunTypeId){
				%>
				<aui:option label="<%=esfGunType.getName()%>"
					value="<%=esfGunType.getEsfGunTypeId()%>" selected="true" />
				<%
					}
						else{
				%>
				<aui:option label="<%=esfGunType.getName()%>"
					value="<%=esfGunType.getEsfGunTypeId()%>" />
				<%
						}
					}
				%>
			</aui:select>
 
			<aui:select name="esfGunKindIdTwo" id="esfGunKindIdTwo"
				label="second-gun-kind">  
				
				<%
					if(secondGunKindId != 0){
				%>

				<aui:option label="<%=secondGunKind%>"
					value="<%=String.valueOf(secondGunKindId)%>" selected="true" />

				<%
					}
				%>
			</aui:select>

			<aui:input name="secondGunCaliber" id="secondGunCaliber" type="text"
				label="second-gun-caliber" value='<%=secondGunCaliber%>'>
			</aui:input>

			<aui:input name="secondGunCode" id="secondGunCode" type="text"
				label="second-gun-code" value='<%=secondGunCode%>'>
			</aui:input>

			<aui:input name="secondGunExtraCanes" id="secondGunExtraCanes"
				 label="second-gun-canes-extra"
				value='<%=secondGunExtraCanes%>'
				type='hidden'
				>
			</aui:input>
		</div>
		<div class="span4">
			<h4>
				<liferay-ui:message key="cartridges-info" />
				:
			</h4>
			<div style="display: none">
				<aui:input name="isPortalUser" id="isPortalUser" type="text"
					value='<%=isPortalUser%>'>
				</aui:input>
				<aui:input name="esfPartecipantInfoId" id="esfPartecipantInfoId"
					type="text" value='<%=esfPartecipantInfoId%>'>
				</aui:input>
				<aui:input name="esfUserId" id="esfUserId" type="text"
					value='<%=esfUserId%>'>
				</aui:input>
			</div>
			<aui:input name="gunCartridgeType" id="gunCartridgeTypeId"
				type="text" label="gun-cartridge-type" value='<%=gunCartridgeType%>'>
			</aui:input>

			<aui:input name="gunCartridgeKind" id="gunCartridgeKindId"
				type="text" label="gun-cartridge-kind" value='<%=gunCartridgeKind%>'>
			</aui:input>

			<aui:input name="cartridgeCaliber" id="cartridgeCaliberId"
				type="text" label="cartridge-caliber" value='<%=cartridgeCaliber%>'>

			</aui:input>
		</div>
	</div>
	<aui:button-row>
		<aui:button type="submit" class="class" cssClass="class"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

</aui:form>

<aui:script>

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
		title: 'Seleziona tiratore',
		id:'<portlet:namespace/>chooseAssociationPopUp',
		uri:'<%=chooseAssociationURL.toString()%>'
		});

	});
	
/*---------------------------------------------------*/

	A.one('#<portlet:namespace/>esfGunTypeIdOne').on('change', changeSelectOne);
	
	A.one('#<portlet:namespace/>esfGunTypeIdTwo').on('change', changeSelectTwo);


	function changeSelectOne(event){
		console.log("INTO");
		var element = event.currentTarget;
		var esfGunTypeId = A.one('#<portlet:namespace/>esfGunTypeIdOne').get('value');
		console.log(esfGunTypeId);
		A.io.request(
			'<%= resourceURL %>',
			{
				method: "POST",
				data: {
					esfGunTypeId:esfGunTypeId,
				},
				contentType: "application/json; charset=utf-8",
				dataType: "json",
			on: {
				success: function() {
					var results = this.get('responseData');
					if(results) {

						var resultsOption = "";
						for(index in results.esfGunKinds) {
							console.log(results.esfGunKinds[index].name);
							resultsOption += "<option value='" + results.esfGunKinds[index].esfGunKindId + "'>" + results.esfGunKinds[index].name + "</option>";
						}
						A.one("#<portlet:namespace/>esfGunKindIdOne").html(resultsOption);
					} else {

						A.one("#<portlet:namespace/>esfGunKindIdOne").html('');
					}
				}
			}
		});	
	}
	
	function changeSelectTwo(event){
		console.log("INTO");
		var element = event.currentTarget;
		var esfGunTypeId = A.one('#<portlet:namespace/>esfGunTypeIdTwo').get('value');
		console.log(esfGunTypeId);
		A.io.request(
			'<%= resourceURL %>',
			{
				method: "POST",
				data: {
					esfGunTypeId:esfGunTypeId,
				},
				contentType: "application/json; charset=utf-8",
				dataType: "json",
			on: {
				success: function() {
					var results = this.get('responseData');
					if(results) {

						var resultsOption = "";
						for(index in results.esfGunKinds) {
							console.log(results.esfGunKinds[index].name);
							resultsOption += "<option value='" + results.esfGunKinds[index].esfGunKindId + "'>" + results.esfGunKinds[index].name + "</option>";
						}
						A.one("#<portlet:namespace/>esfGunKindIdTwo").html(resultsOption);
					} else {

						A.one("#<portlet:namespace/>esfGunKindIdTwo").html('');
					}
				}
			}
		});	
	}


	
/*--------------------------------------------*/ 

 
	/*A.one('#<portlet:namespace/>deleteAssociationTrigger').on('click', function(event){
		
		A.one('#<portlet:namespace />esfAssociation').set('value','');
		A.one('#<portlet:namespace />esfAssociationId').set('value','');
	
		});
	*/
});

function changeOptionsOne(firstGunTypeId, firstGunKindId){
	
	var arr = document.getElementById('<portlet:namespace />esfGunTypeIdOne').getElementsByTagName('option');
	
	for(var i = 0; i < arr.length; i++){

		for(var a in arr[i]){
			if(arr[i]['value'] === firstGunTypeId){
				arr[i].selected = 'selected';
			}
		}
	}
	
	$("#<portlet:namespace />esfGunTypeIdOne").change();
	
	changeSelectFirst(firstGunKindId);
	
	
	function changeSelectFirst(firstGunKindId){
		AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){

				var esfGunTypeId = A.one('#<portlet:namespace/>esfGunTypeIdOne').get('value');
				A.io.request(
					'<%= resourceURL %>',
					{
						method: "POST",
						data: {
							esfGunTypeId:esfGunTypeId,
						},
						contentType: "application/json; charset=utf-8",
						dataType: "json",
					on: {
						success: function() {
							var results = this.get('responseData');
							if(results) {
	
								var resultsOption = "";
								for(index in results.esfGunKinds) {
									resultsOption += "<option value='" + results.esfGunKinds[index].esfGunKindId + "'>" + results.esfGunKinds[index].name + "</option>";
								}
								A.one("#<portlet:namespace/>esfGunKindIdOne").html(resultsOption);
							} else {
	
								A.one("#<portlet:namespace/>esfGunKindIdOne").html('');
							}

							var arrOne = document.getElementById('<portlet:namespace />esfGunKindIdOne').getElementsByTagName('option');
							
							for(var i = 0; i < arrOne.length; i++){
								for(var a in arrOne[i]){
									if(arrOne[i]['value'] === firstGunKindId){
										arrOne[i].selected = 'selected';
									}
								}
							}
							
						}
					}
				});	
			//}
	
		});
	}
}


function changeOptionsTwo(secondGunTypeId, secondGunKindId){
	
	var arr = document.getElementById('<portlet:namespace />esfGunTypeIdTwo').getElementsByTagName('option');
	
	for(var i = 0; i < arr.length; i++){

		for(var a in arr[i]){
			if(arr[i]['value'] === secondGunTypeId){
				arr[i].selected = 'selected';
			}
		}
	}
	
	$("#<portlet:namespace />esfGunTypeIdTwo").change();
	
	changeSelectSecond(secondGunKindId);
	
	
	function changeSelectSecond(secondGunKindId){
		AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	
				//var element = event.currentTarget;
				var esfGunTypeId = A.one('#<portlet:namespace/>esfGunTypeIdTwo').get('value');
				console.log(esfGunTypeId);
				A.io.request(
					'<%= resourceURL %>',
					{
						method: "POST",
						data: {
							esfGunTypeId:esfGunTypeId,
						},
						contentType: "application/json; charset=utf-8",
						dataType: "json",
					on: {
						success: function() {
							var results = this.get('responseData');
							if(results) {
	
								var resultsOption = "";
								for(index in results.esfGunKinds) {
									console.log(results.esfGunKinds[index].name);
									resultsOption += "<option value='" + results.esfGunKinds[index].esfGunKindId + "'>" + results.esfGunKinds[index].name + "</option>";
								}
								A.one("#<portlet:namespace/>esfGunKindIdTwo").html(resultsOption);
							} else {
	
								A.one("#<portlet:namespace/>esfGunKindIdTwo").html('');
							}
							var arrTwo = document.getElementById('#<portlet:namespace />esfGunKindIdTwo').getElementsByTagName('option');
							
							for(var i = 0; i < arr.length; i++){

								for(var a in arr[i]){
									if(arr[i]['value'] === esfGunKindIdTwo){
										arr[i].selected = 'selected';
									}
								}
							}
						}
					}
				});	
			//}
	
		});
	}
	
}



Liferay.provide(
	window,
	'<portlet:namespace/>retrieveAssociation',
	function(firstName, lastName, placeOfBirth, dateOfBirth, residenceCity, province, zip,
			address, phoneNumber, email, fiscalCode, releasedBy, passportReleaseDate,
			passportExpirationDate, passport, europeanCardNumber, europeanCardReleaseDate,
			europeanCardExpirationDate, gunLicenceNumber, gunLicenceReleaseDate, 
			gunLicenceExpirationDate, firstGunType, firstGunExtraCanes, firstGunKind,
			firstGunCaliber, firstGunCode, secondGunType, secondGunKind, secondGunCaliber,
			secondGunCode, secondGunExtraCanes, firstGunTypeId, firstGunKindId, secondGunTypeId,
			secondGunKindId, isPortalUser, esfUserId) {
		
		var A = AUI();
		
		A.one('#<portlet:namespace/>firstName').set('value', firstName);
		A.one('#<portlet:namespace/>lastName').set('value', lastName);
		A.one('#<portlet:namespace/>placeOfBirth').set('value', placeOfBirth);
		A.one('#<portlet:namespace/>dateOfBirth').set('value', dateOfBirth);
		A.one('#<portlet:namespace/>residenceCity').set('value', residenceCity);
		A.one('#<portlet:namespace/>province').set('value', province);
		A.one('#<portlet:namespace/>zip').set('value', zip);
		A.one('#<portlet:namespace/>address').set('value', address);
		A.one('#<portlet:namespace/>phoneNumber').set('value', phoneNumber);
		A.one('#<portlet:namespace/>email').set('value', email);
		A.one('#<portlet:namespace/>fiscalCode').set('value', fiscalCode);
		A.one('#<portlet:namespace/>releasedBy').set('value', releasedBy);
		A.one('#<portlet:namespace/>passportReleaseDate').set('value', passportReleaseDate);
		A.one('#<portlet:namespace/>passportExpirationDate').set('value', passportExpirationDate);
		A.one('#<portlet:namespace/>passport').set('value', passport);
		A.one('#<portlet:namespace/>europeanCardNumber').set('value', europeanCardNumber);
		A.one('#<portlet:namespace/>europeanCardReleaseDate').set('value', europeanCardReleaseDate);
		A.one('#<portlet:namespace/>europeanCardExpirationDate').set('value', europeanCardExpirationDate);
		A.one('#<portlet:namespace/>gunLicenceNumber').set('value', gunLicenceNumber);
		A.one('#<portlet:namespace/>gunLicenceReleaseDate').set('value', gunLicenceReleaseDate);
		A.one('#<portlet:namespace/>gunLicenceExpirationDate').set('value', gunLicenceExpirationDate);
		
		A.one('#<portlet:namespace/>isPortalUser').set('value', isPortalUser);
		A.one('#<portlet:namespace/>firstGunCaliber').set('value', firstGunCaliber);
		A.one('#<portlet:namespace/>firstGunExtraCanes').set('value', firstGunExtraCanes);
		A.one('#<portlet:namespace/>secondGunCaliber').set('value', secondGunCaliber);
		A.one('#<portlet:namespace/>firstGunCode').set('value', firstGunCode);
		A.one('#<portlet:namespace/>secondGunCaliber').set('value', secondGunCaliber);
		A.one('#<portlet:namespace/>secondGunCode').set('value', secondGunCode);
		A.one('#<portlet:namespace/>secondGunExtraCanes').set('value', secondGunExtraCanes);
		A.one('#<portlet:namespace/>esfUserId').set('value', esfUserId);
		
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
		dialog.destroy();
		
		changeOptionsOne(firstGunTypeId, firstGunKindId);
		
		changeOptionsTwo(secondGunTypeId, secondGunKindId);

	},
	['liferay-util-window']
);


</aui:script>