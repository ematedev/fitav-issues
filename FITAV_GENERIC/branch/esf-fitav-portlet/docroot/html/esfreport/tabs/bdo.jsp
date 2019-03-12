<%@include file="../init.jsp"%>

<%
	List<ESFState> esfStates = ESFStateLocalServiceUtil
			.findESFStates(ESFOrganization.class.getName());
	
	List<ESFOrganization> orgs = new ArrayList<ESFOrganization>();
	orgs = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(currentOrganizationId);

%>

<portlet:resourceURL var="selProvinceURL" id="selProvince" escapeXml="false" />
<portlet:resourceURL var="selOrganizationURL" id="selOrganization" escapeXml="false" />


<h3>
	<liferay-ui:message key="select_filters" />
</h3>
<portlet:actionURL var="bdoReportURL" name="bdoReport">
</portlet:actionURL>

<aui:form action="<%=bdoReportURL%>" name="<portlet:namespace/>fm">

	<fieldset>
		<div class="box">
			<div class="interBox">

				<aui:select name="selRegion" id="selRegionBDO" showEmptyOption="false" >
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

				<aui:select name="selProvince" id="selProvinceBDO" showEmptyOption="false">
				<aui:option value="0" >-</aui:option>
				</aui:select>
			</div>

			<div class="interBox">

				<aui:select name="selOrganization" id="selOrganizationBDO"  showEmptyOption="false">
				<aui:option value="0" >-</aui:option>
				</aui:select>
			</div>
			
		</div>

		<aui:select name="esfStateId" inlineField="true">
			<%
				for (ESFState esfState : esfStates) {

							if (Validator.isNotNull(esfState)) {
								String name = esfState.getName() + "**";
			%>
			<aui:option value="<%=esfState.getEsfStateId()%>" label="<%=name%>"></aui:option>
			<%
				}
						}
			%>
		</aui:select>

	</fieldset>
	<aui:input type="submit" value="Report" name="" />
</aui:form>


<portlet:resourceURL var="getProvinceReportBDOURL" id="getProvinceReportBDO" escapeXml="false" />
<portlet:resourceURL var="getOrganizationReportBDOURL" id="getOrganizationBDO" escapeXml="false" />

<aui:script use="node,aui-io-request,node-event-simulate">

A.one('#<portlet:namespace/>selRegionBDO').on('change', function(){
	
	var param = '';
	var regionIdValue = A.one('#<portlet:namespace/>selRegionBDO').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportBDOURL %>';
	
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
						
						A.one('#<portlet:namespace/>selProvinceBDO').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selProvinceBDO').html(resultsOption);
						}
						A.one('#<portlet:namespace/>selOrganizationBDO').html('<option value="0">-</option>');
						
					}
				}
		});
});


A.one('#<portlet:namespace/>selProvinceBDO').on('change', function(){
	
	var param = '';
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceBDO').val();
	var resourceURL = '';
	
	resourceURL = '<%= getProvinceReportBDOURL %>';
	
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
						
						A.one('#<portlet:namespace/>selOrganizationBDO').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>selOrganizationBDO').html(resultsOption);
						}
						
						
					}
				}
	});
});

</aui:script>
