<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@include file="../init.jsp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String catName = "";
String orgName = "";
String regName = "";
String provName = "";
String organizationName="";
String shootersCategoryName="";
String matchShooterName="";
String qualificationName="";
String userRoleName="";
String countryName="";
String regionName="";
String provinceName="";
String organizationNameReport="";
String descriptionName="";
String countryReportName="";
String matchReportName="";
String matchTypeReportName="";
String sportTypeReportName="";
String qualificationReportName="";
String categoryReportName="";
String userNameReport="";

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = ManageDate.CalendarToString(calendar);

List<ESFState> esfStates = ESFStateLocalServiceUtil.findESFStates(ESFOrganization.class.getName());
List<ListType> variations = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFOrganization.variation");

List<ESFOrganization> orgs = new ArrayList<ESFOrganization>();
orgs = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId);


%>

<portlet:actionURL var="actReportAssociazioniURL"
	name="actReportAssociazioni">
</portlet:actionURL>

<aui:form action="<%=actReportAssociazioniURL%>"
	name="<portlet:namespace/>fm">

<h3> <liferay-ui:message key="select_filters" /> </h3>

<aui:input name="reportingYear" type="text" inlineField="true" label="reportingYear">
	<aui:validator name="number"></aui:validator>
</aui:input>


	<div class="separator"></div>
	<fieldset>
		<div class="box">
			<div class="interBox">
			<aui:select name="selRegion" id="selRegionAss" showEmptyOption="false" >
						<aui:option value="0" >-</aui:option>
						<%if(Validator.isNotNull(orgs)){ 
							for(ESFOrganization org : orgs){%>
							<aui:option value="<%=org.getEsfOrganizationId()%>" label="<%=org.getName()%>"></aui:option>
						<%
							}
						}
						%>
					</aui:select>
				</div>
	
				<div class="interBox">
	
					<aui:select name="selProvince" id="selProvinceAss" showEmptyOption="false">
					<aui:option value="0" >-</aui:option>
					</aui:select>
				</div>
	
				<div class="interBox">
	
					<aui:select name="selOrganization" id="selOrganizationAss"  showEmptyOption="false">
					<aui:option value="0" >-</aui:option>
					</aui:select>
				</div>
		</div>
	</fieldset>
	<div class="separator"></div>

<div>

<aui:select name="esfStateId" inlineField="true" >
	

	<% 
		for(ESFState esfState: esfStates){ 
			
			if(Validator.isNotNull(esfState)){
				String name = esfState.getName()+"**";
	%>
			<aui:option value="<%= esfState.getEsfStateId()%>" label="<%= name%>"></aui:option>
	<%	
			}
		} 
	%>
	</aui:select>


<aui:select name="variation" inlineField="true">	

	<% 
		for(ListType variation: variations){ 
			if(Validator.isNotNull(variation)){
				String variationName = variation.getName();
	%>
				<aui:option value="<%= variation.getListTypeId()%>" label="<%= variationName%>"></aui:option>
	<%	
			}
		} 
	%>


</aui:select>


</div>
	<div class="separator"></div>

	<fieldset>
		<liferay-ui:message key="category" />
		<div>

			<aui:input type="checkbox" name="all" inlineField="true" />
			<%
				List<ListType> list = ListTypeServiceUtil.getListTypes(
											it.ethica.esf.model.ESFOrganization
												.class.getName()+".category");
				
					for (ListType s : list) {
			%>
			<aui:input type="checkbox" name="<%=s.getName()%>"
				value="<%=s.getListTypeId()%>" inlineField="true" />
			<%
				}
			%>

			
		</div>

	</fieldset>

	<div class="separator"></div>
	
	<h3> <liferay-ui:message key="selectInformationView" /> </h3>
	
	<div class="separator"></div>
<div>

<aui:input type="checkbox" name="all" inlineField="true" />
<aui:input type="checkbox" name="bdoInformation" label="bdoInformation" inlineField="true" />
<aui:input type="checkbox" name="addresses" inlineField="true" />
<aui:input type="checkbox" name="Category" inlineField="true" />
<aui:input type="checkbox" name="documents-info" inlineField="true" />
<aui:input type="checkbox" name="payments" label="payments" inlineField="true" />
</div>


	<div class="separator"></div>
	<aui:input type="submit" value="Report" name="" />

</aui:form>

<portlet:resourceURL var="getProvinceReportAssURL" id="getProvinceReportBDO" escapeXml="false" />
<portlet:resourceURL var="getOrganizationReportAssURL" id="getOrganizationBDO" escapeXml="false" />

<aui:script use="node,aui-io-request,node-event-simulate">

	var showDate = function() {

		if ($('#<portlet:namespace/>showDate').val() == 'true') {
			$('#date').show();
		} else {
			$('#date').hide();
		}

	}

A.one('#<portlet:namespace/>selRegionAss').on('change', function(){
	
	var param = '';
	var regionIdValue = A.one('#<portlet:namespace/>selRegionAss').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportAssURL %>';
	
	A.io.request(
			resourceURL,
			{
				
				method: 'POST',
				contentType: "application/json; charset=utf-8",
				
				data: {
					param:param,
					regionId:regionIdValue
				},
				
				on: {
					success: function() {
						
						var results = JSON.parse(this.get('responseData'));
						var resultsOption = '<option value="">-</option>';
						
						A.one('#<portlet:namespace/>selProvinceAss').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selProvinceAss').html(resultsOption);
						}
						A.one('#<portlet:namespace/>selOrganizationAss').html('<option value="0">-</option>');
						
					}
				}
		});
});

A.one('#<portlet:namespace/>selProvinceAss').on('change', function(){
	
	var param = '';
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceAss').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportAssURL %>';
	
	A.io.request(
			resourceURL,
			{
				method: 'POST',
				contentType: "application/json; charset=utf-8",
				
				data: {
					param:param,
					regionId:provinceIdValue
				},
				on: {
					success: function() {
						
						var results = JSON.parse(this.get('responseData'));
						var resultsOption = '<option value="">-</option>';
						
						A.one('#<portlet:namespace/>selOrganizationAss').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selOrganizationAss').html(resultsOption);
						}
						
						
					}
				}
	});
});

</aui:script>

