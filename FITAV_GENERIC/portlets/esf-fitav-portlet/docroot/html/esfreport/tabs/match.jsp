<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@include file="../init.jsp"%>

<%
List<ESFOrganization> orgs = new ArrayList<ESFOrganization>();
orgs = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId);

List<ESFMatchType> normalMatchTypes = new ArrayList<ESFMatchType>();
List<ESFMatchType> olimpicMatchTypes = new ArrayList<ESFMatchType>();
List<ESFSportType> normalSportTypes = new ArrayList<ESFSportType>();
List<ESFSportType> olimpicSportTypes = new ArrayList<ESFSportType>();

normalMatchTypes = ESFMatchTypeLocalServiceUtil.findAllByNational(false);
normalSportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
olimpicMatchTypes = ESFMatchTypeLocalServiceUtil.findAllByNational(true);
olimpicSportTypes = ESFSportTypeLocalServiceUtil.getisOlimpic(true);

Calendar calendar = GregorianCalendar.getInstance();
int year = calendar.get( Calendar.YEAR );
%>

<h3>
	<liferay-ui:message key="normal_match" />
</h3>

<div class="box">
			<div class="interBox">
			<aui:select name="selRegion" id="selRegionMatch" showEmptyOption="false" >
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
	
					<aui:select name="selProvince" id="selProvinceMatch" showEmptyOption="false">
					<aui:option value="0" >-</aui:option>
					</aui:select>
				</div>
	
				<div class="interBox">
	
					<aui:select name="selOrganization" id="selOrganizationMatch"  showEmptyOption="false">
					<aui:option value="0" >-</aui:option>
					</aui:select>
				</div>
		</div>
		
<div class="btn-field-align">
	
		<aui:select name="match-type" inlineField="true">
			<aui:option value="0" >-</aui:option>
			<% 
				for(ESFMatchType normalMatchType: normalMatchTypes){ 
					if(Validator.isNotNull(normalMatchType)){
						String normalMatchTypeName = normalMatchType.getName();
			%>
						<aui:option value="<%= normalMatchType.getEsfMatchTypeId()%>" label="<%= normalMatchTypeName%>"></aui:option>
			<%	
					}
				} 
			%>
		</aui:select>
		
		<aui:select name="esf-sport-types" inlineField="true">
			<aui:option value="0" >-</aui:option>
			<% 
				for(ESFSportType normalSportType: normalSportTypes){ 
					if(Validator.isNotNull(normalSportType)){
						String normalSportTypeName = normalSportType.getName();
			%>
						<aui:option value="<%= normalSportType.getEsfSportTypeId()%>" label="<%= normalSportTypeName%>"></aui:option>
			<%	
					}
				} 
			%>
		</aui:select>
	
		<aui:select name="yearNormalMatch" inlineField="true" label="select_years_earlier">
			<%
			for(int i = 0; i < 10 ; i++){%>
				<aui:option value="<%= year-i%>" label="<%= year-i%>"></aui:option>
			<% }
			%>
		
		</aui:select>
	
		<aui:button  value='NormalMatchReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"NormalMatchReport();" %>' />
	</div>



<div class="separator"></div>
<h3>
	<liferay-ui:message key="Olimpic-Match" />
</h3>
<div class="btn-field-align">

	<aui:select name="olimpic-match-type" inlineField="true">
		<aui:option value="0" >-</aui:option>
			<% 
			for(ESFMatchType olimpicMatchType: olimpicMatchTypes){ 
				if(Validator.isNotNull(olimpicMatchType)){
					String olimpicMatchTypeName = olimpicMatchType.getName();
		%>
					<aui:option value="<%= olimpicMatchType.getEsfMatchTypeId()%>" label="<%= olimpicMatchTypeName%>"></aui:option>
		<%	
				}
			} 
		%>
	</aui:select>
	
		<aui:select name="olimpicSport" inlineField="true" label="olimpicSport">
		<aui:option value="0" >-</aui:option>
		<% 
			for(ESFSportType olimpicSportType: olimpicSportTypes){ 
				if(Validator.isNotNull(olimpicSportType)){
					String olimpicSportTypeName = olimpicSportType.getName();
		%>
					<aui:option value="<%= olimpicSportType.getEsfSportTypeId()%>" label="<%= olimpicSportTypeName%>"></aui:option>
		<%	
				}
			} 
		%>
	</aui:select>
	
		<aui:select name="yearOlimpicMatch" inlineField="true" label="select_years_earlier">
		<%
		for(int i = 0; i < 10 ; i++){%>
			<aui:option value="<%= year-i%>" label="<%= year-i%>"></aui:option>
		<% }%>
</div>
<div class="btn-field-align">	
	</aui:select>
	
		<aui:select name="esfCountryId" leable="esfCountryId" inlineField="true">
				<aui:option label="-" value="0" />
			<%
				List<Country> countries = CountryServiceUtil.getCountries();
				for (Country country : countries) {
			%>
					<aui:option label="<%=country.getName()%>"
						value="<%=country.getCountryId()%>"></aui:option>
			<%
				}
			%>
			</aui:select>

	<aui:button  value='NationalMatchReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"NationalMatchReport();" %>' />

</div>


<portlet:resourceURL var="getProvinceReportMatchURL" id="getProvinceReportMatch" escapeXml="false" />
<portlet:resourceURL var="getOrganizationReportMatchURL" id="getOrganizationMatch" escapeXml="false" />

<aui:script use="node,aui-io-request,node-event-simulate">

A.one('#<portlet:namespace/>selRegionMatch').on('change', function(){
	
	var param = '';
	var regionIdValue = A.one('#<portlet:namespace/>selRegionMatch').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportMatchURL %>';
	
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
						
						A.one('#<portlet:namespace/>selProvinceMatch').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selProvinceMatch').html(resultsOption);
						}
						A.one('#<portlet:namespace/>selOrganizationMatch').html('<option value="0">-</option>');
						
					}
				}
		});
});

A.one('#<portlet:namespace/>selProvinceMatch').on('change', function(){
	
	var param = '';
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceMatch').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportMatchURL %>';
	
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
						
						A.one('#<portlet:namespace/>selOrganizationMatch').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selOrganizationMatch').html(resultsOption);
						}
						
						
					}
				}
	});
});

Liferay.provide(window,'<portlet:namespace/>NormalMatchReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateNormalMatchReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionMatch').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceMatch').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationMatch').val();
	var matchTypeId = A.one('#<portlet:namespace/>match-type').val();
	var sportTypeId = A.one('#<portlet:namespace/>esf-sport-types').val();
	var yearNormalMatch = A.one('#<portlet:namespace/>yearNormalMatch').val();

	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateNormalMatchReport', genrateNormalMatchReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);
	resourceURL.setParameter('matchTypeId', matchTypeId);
	resourceURL.setParameter('sportTypeId', sportTypeId);
	resourceURL.setParameter('yearNormalMatch', yearNormalMatch);
	
	window.open(resourceURL.toString());
});


Liferay.provide(window,'<portlet:namespace/>NationalMatchReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateNationalMatchReport = true;
	var matchTypeId = A.one('#<portlet:namespace/>olimpic-match-type').val();
	var sportTypeId = A.one('#<portlet:namespace/>olimpicSport').val();
	var yearOlimpicMatch = A.one('#<portlet:namespace/>yearOlimpicMatch').val();
	var countryId = A.one('#<portlet:namespace/>esfCountryId').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateNationalMatchReport', genrateNationalMatchReport);
	resourceURL.setParameter('matchTypeId', matchTypeId);
	resourceURL.setParameter('sportTypeId', sportTypeId);
	resourceURL.setParameter('yearOlimpicMatch', yearOlimpicMatch);
	resourceURL.setParameter('countryId', countryId);

	window.open(resourceURL.toString());
});

</aui:script>




