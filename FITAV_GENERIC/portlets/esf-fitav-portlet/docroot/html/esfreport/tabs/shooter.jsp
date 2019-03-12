<%@page import="java.util.Date"%>
<%@include file="../init.jsp"%>


<%

List<ESFSportType> nationalSports = new ArrayList<ESFSportType>();
nationalSports = ESFSportTypeLocalServiceUtil.getisOlimpic(true);

List<ESFOrganization> orgs = new ArrayList<ESFOrganization>();
orgs = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId);

%>

<aui:button  value='SummaryShooterReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"SummaryShooterReport();" %>' inlineField="true"/>
<aui:button  value='SummaryShooterYearReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"SummaryShooterYearReport();" %>' inlineField="true"/>
<aui:button  value='SummaryShooterSocReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"SummaryShooterSocReport();" %>' inlineField="true"/>

<h3>
	<liferay-ui:message key="select_filters" />
</h3>
<div class="separator"></div>
<fieldset>
		<div class="box">
			<div class="interBox">

				<aui:select name="selRegion" id="selRegionSH" showEmptyOption="false" >
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

				<aui:select name="selProvince" id="selProvinceSH" showEmptyOption="false">
				<aui:option value="0" >-</aui:option>
				</aui:select>
			</div>

			<div class="interBox">

				<aui:select name="selOrganization" id="selOrganizationSH"  showEmptyOption="false">
				<aui:option value="0" >-</aui:option>
				</aui:select>
			</div>
			
			<div class="interBox">

				<aui:input name="givenDate" id="givenDateInput" label="Data inizio" />
			</div>

		</div>
		<aui:button  value='ShooterReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"ShooterReport();" %>' inlineField="true"/>
		<aui:button  value='ShooterNoRenewalReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"ShooterNoRenewalReport();" %>' inlineField="true"/>
		<br>
		
<div class="separator"></div>
		
<h3>
	<liferay-ui:message key="select_national_filters" />
</h3>

	<div class="box">
	
		<aui:select name="esfSprtType" label="esf-sport-type" inlineField="true">
				<aui:option value="0" >-</aui:option>
				<%
					for (ESFSportType st : nationalSports) {
	
						if (Validator.isNotNull(st)) {
							String name = st.getName() ;
				%>
						<aui:option value="<%=st.getEsfSportTypeId()%>" label="<%=name%>"></aui:option>
				<%
						}
					}
				%>
		</aui:select>
		
		<div class="align_National_info">
			<aui:input type="radio" name="isNational" id="isNational" label="isNational" checked="true"/>
			<aui:input type="radio" name="isNational" id="isNationalB/23" label="isNationalB/23" checked="false"/>
			<aui:input type="checkbox" name="isUniversity" key="is-University" />
		</div>
	</div>
		<aui:button  value='NationalReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"NationalReport();" %>' inlineField="true"/>
		<br>
		
	
<style>
.align_National_info {
	margin-top: 30px;
	margin-left: 20px;
}
.align_National_info > label {
	display: inline-block;
}
.align_National_info > label:not(:first-child) {
	margin-left: 10px;
}
</style>

</fieldset>
<portlet:resourceURL var="getProvinceReportSHURL" id="getProvinceReportSH" escapeXml="false" />
<portlet:resourceURL var="getOrganizationReportSHURL" id="getOrganizationSH" escapeXml="false" />

<aui:script use="node,aui-io-request,node-event-simulate">

A.one('#<portlet:namespace/>selRegionSH').on('change', function(){
	
	var param = '';
	var regionIdValue = A.one('#<portlet:namespace/>selRegionSH').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportSHURL %>';
	
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
						
						A.one('#<portlet:namespace/>selProvinceSH').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selProvinceSH').html(resultsOption);
						}
						A.one('#<portlet:namespace/>selOrganizationSH').html('<option value="0">-</option>');
						
					}
				}
		});
});


A.one('#<portlet:namespace/>selProvinceSH').on('change', function(){
	
	var param = '';
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceSH').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportSHURL %>';
	
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
						
						A.one('#<portlet:namespace/>selOrganizationSH').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selOrganizationSH').html(resultsOption);
						}
						
						
					}
				}
	});
});


Liferay.provide(window,'<portlet:namespace/>ShooterReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateShooterReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionSH').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceSH').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationSH').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateShooterReport', genrateShooterReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);

	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>ShooterNoRenewalReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateShooterNoRenewalReportReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionSH').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceSH').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationSH').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateShooterNoRenewalReportReport', genrateShooterNoRenewalReportReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);

	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>NationalReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generateNationalReport = true;
	var isNational = A.one('#<portlet:namespace/>isNational').val();
	var isUniversity = A.one('#<portlet:namespace/>isUniversity').val();
	var esfSprtType = A.one('#<portlet:namespace/>esfSprtType').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generateNationalReport', generateNationalReport);
	resourceURL.setParameter('isNational', isNational);
	resourceURL.setParameter('isUniversity', isUniversity);
	resourceURL.setParameter('esfSprtTypeId', esfSprtType);

	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>SummaryShooterReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generateSummaryShooterReport = true;
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generateSummaryShooterReport', generateSummaryShooterReport);

	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>SummaryShooterYearReport',function(){

	var givenDate = A.one('#<portlet:namespace/>givenDateInput').val();

	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generateSummaryShooterYearReportReport = true;
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generateSummaryShooterYearReportReport', generateSummaryShooterYearReportReport);
	resourceURL.setParameter('givenDate', givenDate);

	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>SummaryShooterSocReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generateSummaryShooterSocReport = true;
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generateSummaryShooterSocReport', generateSummaryShooterSocReport);

	window.open(resourceURL.toString());
});

</aui:script>