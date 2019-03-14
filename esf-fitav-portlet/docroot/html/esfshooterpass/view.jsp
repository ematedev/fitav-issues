<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFShooterPassModelPermission"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="java.util.Date"%>
<%@include file="init.jsp"%>

<%

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = "";
currDate = ManageDate.CalendarToString(calendar);

List<ESFCountry> countries = ESFCountryLocalServiceUtil.getESFCountries(0,
		ESFCountryLocalServiceUtil.getESFCountriesCount());


List<ESFGunType> gunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);
List<ESFGunType> catridgeTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(true);

%>
<portlet:resourceURL var="resourceURL" escapeXml="false" />
<h2><liferay-ui:message key="shooterPassInformation"> </liferay-ui:message></h2>



<div>
<aui:input name="shooterName" label="firstName" inlineField="true">
					<aui:validator name="required" errorMessage="please-enter-a-name" />
</aui:input>

<aui:input name="birthday" type="text" inlineField="true" />

</div>

<div class="row">
	<div class="span4">
		<aui:select id="nationality" name="nationality"
							showEmptyOption="true" required="false">
					<%for (ESFCountry country : countries) { %>		
							<aui:option label="<%=country.getName()%>"
								value="<%=country.getIdCountry()%>" />
					<%} %>
		</aui:select>
	</div>
	<div class="span4">
		<aui:input name="cities"></aui:input>
	</div>
	<div class="span4">
		<aui:input name="street1"></aui:input>
	</div>
</div>

<div class="row">
	
		<aui:input name="esf-association" type="text" inlineField="true"/>
	
		<aui:input name="startDate" type="text" inlineField="true"/>
	
		<aui:input name="endDate" type="text" inlineField="true"/>
	
		<aui:input name="matchType" label="esf-match-type-id" type="text" inlineField="true"/>
	
</div>

<h2><liferay-ui:message key="firstWeapon"> </liferay-ui:message></h2>

	<div >
	
		<aui:input name="type_1" type="text" inlineField="true" label="esf-unitservice-id" >
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="caliber_1" type="number" inlineField="true" label="caliber">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:select name="brand-id_1" type="text" inlineField="true" label="brand-id" required="true" showEmptyOption="true">
		
					<%for (ESFGunType gunType : gunTypes) { %>	
							<aui:option label="<%=gunType.getName()%>"
								value="<%=gunType.getEsfGunTypeId()%>" />
					<%} %>
		
		</aui:select>
		
		<aui:select name="kind-name_1" type="text" inlineField="true" label="kind-name" required="true" showEmptyOption="true">
		
		</aui:select>
		
		<aui:input name="freshman_1" type="number" inlineField="true" label="freshman">
			<aui:validator name="required" />
		</aui:input>
		
	</div>

<h2><liferay-ui:message key="secondWeapon"> </liferay-ui:message></h2>


	<div >
	
		<aui:input name="type_2" type="text" inlineField="true" label="esf-unitservice-id" />
		
		<aui:input name="caliber_2" type="number" inlineField="true" label="caliber"/>
		
		<aui:select name="brand-id_2" type="text" inlineField="true" label="brand-id" showEmptyOption="true">
		
					<%for (ESFGunType gunType : gunTypes) { %>	
							<aui:option label="<%=gunType.getName()%>"
								value="<%=gunType.getEsfGunTypeId()%>" />
					<%} %>
		
		</aui:select>
		
		<aui:select name="kind-name_2" type="text" inlineField="true" label="kind-name" showEmptyOption="true">
		
		</aui:select>
		
		<aui:input name="freshman_2" type="number" inlineField="true" label="freshman"/>
		
	</div>

<h2><liferay-ui:message key="CATRIDGES"> </liferay-ui:message></h2>

<div >

	<aui:select name="brand-id-catridge" type="text" inlineField="true" showEmptyOption="true" label="brand-id">
			<%for (ESFGunType catridgeType : catridgeTypes) { %>	
							<aui:option label="<%=catridgeType.getName()%>"
								value="<%=catridgeType.getEsfGunTypeId()%>" />
					<%} %>
	</aui:select>
	
	<aui:input name="catridgeCaliber" type="number" inlineField="true"/>

</div>

<h2><liferay-ui:message key="canesExtra"> </liferay-ui:message></h2>

<div >
	<aui:input name="canes-extra" type="text" inlineField="true" />

	<aui:input name="first-gun-canes-extra" type="text" inlineField="true" />
		
	<aui:input name="second-gun-canes-extra" type="text" inlineField="true" />
	
</div>
<c:if test="<%= ESFShooterPassModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFGENERATE_PASS) %>">
	<aui:button  value='generatePasses' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"generatePass();" %>' inlineField="true"/>
</c:if>
<aui:script use="aui-base,node,aui-io-request, node,liferay-portlet-url,node-event-simulate">

$(function() {
	
		$("#<portlet:namespace/>birthday").datepicker();
		$("#<portlet:namespace/>birthday").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>birthday").datepicker("setDate",
		'<%= currDate %>');

	});
	
	$(function() {
		
		$("#<portlet:namespace/>startDate").datepicker();
		$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>startDate").datepicker("setDate",
			'<%= currDate %>');
	});
	
	$(function() {
		
		$("#<portlet:namespace/>endDate").datepicker();
		$("#<portlet:namespace/>endDate").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>endDate").datepicker("setDate",
		'<%= currDate %>');
	});
	
	A.one('#<portlet:namespace/>brand-id_1').on('change', changeSelectBrand1);
	A.one('#<portlet:namespace/>brand-id_2').on('change', changeSelectBrand2);
	
	
	function changeSelectBrand1(event){

		var element = event.currentTarget;
		var esfGunKindId1 = A.one('#<portlet:namespace/>brand-id_1').get('value');
		var type = 1;
		var filterModelGun = true;
		
		A.io.request(
			'<%= resourceURL %>',
			{
			
				method: "POST",
				data:{
					esfGunKindId1:esfGunKindId1,
					type:type,
					filterModelGun:filterModelGun,
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
							A.one("#<portlet:namespace/>kind-name_1").html(resultsOption);
						}else{
							A.one("#<portlet:namespace/>kind-name_1").html('');
						}
					}
				}
			});
		
		
	}
	
	function changeSelectBrand2(event){

		var element = event.currentTarget;
		var esfGunKindId2 = A.one('#<portlet:namespace/>brand-id_2').get('value');
		var type = 1;
		var filterModelGun = true;
		
		A.io.request(
			'<%= resourceURL %>',
			{
			
				method: "POST",
				data:{
					esfGunKindId2:esfGunKindId2,
					type:type,
					filterModelGun:filterModelGun,
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
							A.one("#<portlet:namespace/>kind-name_2").html(resultsOption);
						}else{
							A.one("#<portlet:namespace/>kind-name_2").html('');
						}
					}
				}
			});
		
		
	}
	

</aui:script>


<aui:script>


Liferay.provide(window,'<portlet:namespace/>generatePass',function(){

	var A = new AUI();
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generatepass = true;
	var shooterName = A.one('#<portlet:namespace/>shooterName').val();
	var birthday = A.one('#<portlet:namespace/>birthday').val();
	var nationality = A.one('#<portlet:namespace/>nationality').val();
	var cities = A.one('#<portlet:namespace/>cities').val();
	var street1 = A.one('#<portlet:namespace/>street1').val();
	var esfAssociation = A.one('#<portlet:namespace/>esf-association').val();
	var startDate = A.one('#<portlet:namespace/>startDate').val();
	var endDate = A.one('#<portlet:namespace/>endDate').val();
	var type1 = A.one('#<portlet:namespace/>type_1').val();
	var caliber1 = A.one('#<portlet:namespace/>caliber_1').val();
	var brand1= A.one('#<portlet:namespace/>brand-id_1').val();
	var kind1 = A.one('#<portlet:namespace/>kind-name_1').val();
	var freshman_1 = A.one('#<portlet:namespace/>freshman_1').val();
	var type2 = A.one('#<portlet:namespace/>type_2').val();
	var caliber2 = A.one('#<portlet:namespace/>caliber_2').val();
	var brand2= A.one('#<portlet:namespace/>brand-id_2').val();
	var kind2 = A.one('#<portlet:namespace/>kind-name_2').val();
	var freshman_2 = A.one('#<portlet:namespace/>freshman_2').val();
	var catridgeId = A.one('#<portlet:namespace/>brand-id-catridge').val();
	var catridgeCaliber = A.one('#<portlet:namespace/>catridgeCaliber').val();
	var canesExtra = A.one('#<portlet:namespace/>canes-extra').val();
	var firstCanesExtra = A.one('#<portlet:namespace/>first-gun-canes-extra').val();
	var secondCanesExtra = A.one('#<portlet:namespace/>second-gun-canes-extra').val();
	var matchType = A.one('#<portlet:namespace/>matchType').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generatepass', generatepass);
	resourceURL.setParameter('shooterName', shooterName);
	resourceURL.setParameter('birthday', birthday);
	resourceURL.setParameter('nationality', nationality);
	resourceURL.setParameter('cities', cities);
	resourceURL.setParameter('street1', street1);
	resourceURL.setParameter('esfAssociation', esfAssociation);
	resourceURL.setParameter('startDate', startDate);
	resourceURL.setParameter('endDate', endDate);
	resourceURL.setParameter('type1', type1);
	resourceURL.setParameter('caliber1', caliber1);
	resourceURL.setParameter('brand1', brand1);
	resourceURL.setParameter('kind1', kind1);
	resourceURL.setParameter('freshman_1', freshman_1);
	resourceURL.setParameter('type2', type2);
	resourceURL.setParameter('caliber2', caliber2);
	resourceURL.setParameter('brand2', brand2);
	resourceURL.setParameter('kind2', kind2);
	resourceURL.setParameter('freshman_2', freshman_2);
	resourceURL.setParameter('catridgeId', catridgeId);
	resourceURL.setParameter('catridgeCaliber', catridgeCaliber);
	resourceURL.setParameter('canesExtra', canesExtra);
	resourceURL.setParameter('firstCanesExtra', firstCanesExtra);
	resourceURL.setParameter('secondCanesExtra', secondCanesExtra);
	resourceURL.setParameter('matchType', matchType);
	
	window.open(resourceURL.toString());
},['aui-base,node,aui-io-request, node,liferay-portlet-url,node-event-simulated']);


</aui:script>

