<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@include file="../init.jsp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%


SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = ManageDate.CalendarToString(calendar);

List<ESFState> esfStates = ESFStateLocalServiceUtil.findESFStates(ESFOrganization.class.getName());
List<ListType> variations = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFOrganization.variation");

List<ESFOrganization> orgs = new ArrayList<ESFOrganization>();
orgs = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId);


%>

<h3> <liferay-ui:message key="select_filters" /> </h3>
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
	
	<aui:button  value='CompanyCategoryReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"CompanyCategoryReport();" %>' inlineField="true"/>
	<aui:button  value='ShootersAndCategoryReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"ShootersAndCategoryReport();" %>' inlineField="true"/>
	<br>
	<div class="separator"></div>
	
	<div class="btn-field-align">
		<aui:select name="variation" inlineField="true">
		<aui:option value="0" >-</aui:option>
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
		<aui:button  value='VariationReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"VariationReport();" %>' inlineField="true"/>
	
	</div>

<portlet:resourceURL var="getProvinceReportAssURL" id="getProvinceReportAss" escapeXml="false" />
<portlet:resourceURL var="getOrganizationReportAssURL" id="getOrganizationAss" escapeXml="false" />

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

Liferay.provide(window,'<portlet:namespace/>CompanyCategoryReport',function(){
	
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateCompanyCategoryReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionAss').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceAss').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationAss').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateCompanyCategoryReport', genrateCompanyCategoryReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);

	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>ShootersAndCategoryReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generateShootersAndCategoryReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionAss').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceAss').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationAss').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generateShootersAndCategoryReport', generateShootersAndCategoryReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);

	window.open(resourceURL.toString());
});


Liferay.provide(window,'<portlet:namespace/>VariationReport',function(){
	
	console.log("Liferay="+Liferay);
	console.log("PortletURL="+Liferay.PortletURL);
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateVariationReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionAss').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceAss').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationAss').val();
	var variationId = A.one('#<portlet:namespace/>variation').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateVariationReport', genrateVariationReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);
	resourceURL.setParameter('variationId', variationId);
	
	window.open(resourceURL.toString());
});

</aui:script>

