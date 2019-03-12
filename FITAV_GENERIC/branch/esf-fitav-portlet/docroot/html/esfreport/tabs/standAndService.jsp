<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@include file="../init.jsp"%>

<%
	long brandId = 0;
	long electronicId = 0;
	String regName = "";
	
	List<ESFOrganization> orgs = new ArrayList<ESFOrganization>();
	orgs = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId);

%>

<h3>
	<liferay-ui:message key="select_filters" />
</h3>

<portlet:actionURL var="standReportURL" name="standReport">
</portlet:actionURL>

<aui:form action="<%=standReportURL%>" name="<portlet:namespace/>fm">

	<fieldset>


		<div class="separator"></div>
		<fieldset>
			<div class="box">
			
			<div class="box">
			<div class="interBox">

				<aui:select name="selRegion" id="selRegionStand" showEmptyOption="false" >
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

				<aui:select name="selProvince" id="selProvinceStand" showEmptyOption="false">
				<aui:option value="0" >-</aui:option>
				</aui:select>
			</div>

			<div class="interBox">

				<aui:select name="selOrganization" id="selOrganizationStand"  showEmptyOption="false">
				<aui:option value="0" >-</aui:option>
				</aui:select>
			</div>
			
		</div>

			</div>
		</fieldset>

		<div class="">
			<div class="interBox">

				<aui:input type="number" name="nFields">
					<aui:validator errorMessage="must-be-number" name="number" />
				</aui:input>

			</div>


			<div class="interBox">

				<%
					String sportType = "";
						List<ESFSportType> esfSportTypes = new ArrayList<ESFSportType>();
						List<KeyValuePair> leftListesfSportType = new ArrayList<KeyValuePair>();
						List<KeyValuePair> rightListesfSportType = new ArrayList<KeyValuePair>();

						esfSportTypes = ESFSportTypeLocalServiceUtil
								.getAllESFSportTypes();

						for (ESFSportType type : esfSportTypes) {
							if (Validator.isNotNull(type)) {
								leftListesfSportType.add(new KeyValuePair(String
										.valueOf(type.getEsfSportTypeId()), type
										.getName()));
							}

						}
				%>
				<liferay-ui:message key="speciality">speciality</liferay-ui:message>

				<aui:input name="valuesSportType" type="hidden" />
				<liferay-ui:input-move-boxes leftBoxName="availableValuesSportType"
					leftList="<%=leftListesfSportType%>" leftReorder="true"
					leftTitle="available" rightBoxName="selectedValuesSportType"
					rightList="<%=rightListesfSportType%>" rightTitle="selected" />
			</div>

			<div class="interBox">

				<aui:select name="selBillboard">
					<%
						List<ListType> types = null;
								try {
									types = ListTypeServiceUtil
											.getListTypes(it.ethica.esf.model.ESFField.class
													.getName() + ".billboard");
								} catch (Exception e) {
									e.printStackTrace();
								}
								for (ListType ls : types) {
					%>
					<aui:option value="<%=ls.getListTypeId()%>">
						<%=ls.getName()%>
					</aui:option>
					<%
						}
					%>
				</aui:select>

			</div>

		</div>

	</fieldset>
	<div class="separator"></div>
	<fieldset>

		<h4>
			<liferay-ui:message key="esf-field-background-id" />
			:
		</h4>

		<div>

			<aui:input type="checkbox" name="backgroundRampart"
				inlineField="true" />

			<aui:input type="checkbox" name="backgroundNet" inlineField="true" />

			<aui:input type="checkbox" name="backgroundLeadRecovery"
				inlineField="true" />

			<aui:input type="checkbox" name="disabledAccess" inlineField="true" />

			<aui:input type="checkbox" name="billboardStations"
				inlineField="true" />

		</div>
	</fieldset>
	<div class="separator"></div>
	<fieldset>

		<liferay-ui:message key="machines" />

		<div class="box">

			<div class="interBox">

				<aui:select name='<%="brand"%>'>
					<aui:option label="-" value="0" />
					<%
						List<ESFBrand> esfBrands = ESFBrandLocalServiceUtil
										.findAll();
								for (ESFBrand esfBrand : esfBrands) {
									String label = esfBrand.getName();
									if (esfBrand.getBrandId() == brandId) {
					%>
					<aui:option label="<%=label%>" value="<%=esfBrand.getBrandId()%>"
						selected="true" />
					<%
						} else {
					%>
					<aui:option label="<%=label%>" value="<%=esfBrand.getBrandId()%>" />

					<%
						}
								}
					%>
				</aui:select>

			</div>

			<div class="interBox">

				<aui:select name='<%="electronic"%>'>

					<aui:option label="-" value="0" />

					<%
						List<ESFElectronic> esfElectronics = ESFElectronicLocalServiceUtil
										.findAll();
								for (ESFElectronic esfElectronic : esfElectronics) {
									String label = esfElectronic.getName();
									if (esfElectronic.getElectronicId() == electronicId) {
					%>
					<aui:option label="<%=label%>"
						value="<%=esfElectronic.getElectronicId()%>" selected="true" />
					<%
						} else {
					%>
					<aui:option label="<%=label%>"
						value="<%=esfElectronic.getElectronicId()%>" />

					<%
						}
								}
					%>
				</aui:select>

			</div>

		</div>

	</fieldset>
	<div class="separator"></div>
	<fieldset>

		<liferay-ui:message key="selServices" />

		<div>

			<%
				for (ESFUnitservice s : services) {
			%>
			<aui:input type="checkbox" name="<%=s.getDescription()%>"
				value="<%=s.getEsfUnitserviceId()%>" inlineField="true" />
			<%
				}
			%>

		</div>
	</fieldset>
	<br>
	<aui:input type="submit" value="Report" name="" />

</aui:form>


<portlet:resourceURL var="getProvinceReportStandURL" id="getProvinceReportStand" escapeXml="false" />
<portlet:resourceURL var="getOrganizationReportStandURL" id="getOrganizationStand" escapeXml="false" />

<aui:script use="node,aui-io-request,node-event-simulate">

A.one('#<portlet:namespace/>selRegionStand').on('change', function(){
	
	var param = '';
	var regionIdValue = A.one('#<portlet:namespace/>selRegionStand').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportStandURL %>';
	
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
						
						A.one('#<portlet:namespace/>selProvinceStand').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selProvinceStand').html(resultsOption);
						}
						A.one('#<portlet:namespace/>selOrganizationStand').html('<option value="0">-</option>');
						
					}
				}
		});
});


A.one('#<portlet:namespace/>selProvinceStand').on('change', function(){
	
	var param = '';
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceStand').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportStandURL %>';
	
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
						
						A.one('#<portlet:namespace/>selOrganizationStand').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selOrganizationStand').html(resultsOption);
						}
						
						
					}
				}
	});
});

</aui:script>



