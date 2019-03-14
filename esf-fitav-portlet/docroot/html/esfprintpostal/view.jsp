<%@ include file="init.jsp"%>

<%
List<ESFOrganization> orgs = new ArrayList<ESFOrganization>();
orgs = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId);

ESFConfiguration bankaccount = new ESFConfigurationImpl();
bankaccount = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("Conto_Corrente");

%>
<aui:input name="bankaccount" label="bankaccount" value="<%= bankaccount.getValue()%>" disabled="true" />
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
				<aui:input name="postalType" label="postalType" cssClass="postalTypeClass"/>
					
			</div>
	</fieldset>
	<aui:button  value='Print' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"Print();" %>' inlineField="true"/>

<portlet:resourceURL var="getProvinceURL" id="getProvince" escapeXml="false" />
<portlet:resourceURL var="getOrganizationAssURL" id="getOrganizationAss" escapeXml="false" />

<aui:script use="node,aui-io-request,node-event-simulate">

A.one('#<portlet:namespace/>selRegionAss').on('change', function(){
	
	var param = '';
	var regionIdValue = A.one('#<portlet:namespace/>selRegionAss').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceURL %>';
	
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
	
	resourceURL = '<%= getProvinceURL %>';
	
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

Liferay.provide(window,'<portlet:namespace/>Print',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var printPostal = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionAss').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceAss').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationAss').val();
	var postalType = A.one('#<portlet:namespace/>postalType').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('printPostal', printPostal);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);
	resourceURL.setParameter('postalType', postalType);
	
	window.open(resourceURL.toString());
},['liferay-portlet-url']);

</aui:script>