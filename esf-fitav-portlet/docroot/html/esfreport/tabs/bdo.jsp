<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserRole"%>
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
<div class="separator"></div>
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
		
<hr>
<div class="btn-field-align">
		<aui:select name="esfStateIdBDO" label="associations_state" inlineField="true">
			<aui:option value="0" >-</aui:option>
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


<aui:button  value='BDOReportStateASS' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"BDOReport();" %>' inlineField="true"/>
</div>

<hr>

<div class="btn-field-align">
	
	<aui:select name="rolesIdBDO" label="roles" inlineField="true">
		<aui:option value="0" >-</aui:option>
		<%
		List<ESFUserRole> bdoRoles = new ArrayList<ESFUserRole>();
		bdoRoles= ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(3, 1, true);
		Role role = null; 
		for(ESFUserRole r : bdoRoles){
			if(Validator.isNotNull(RoleLocalServiceUtil.fetchRole(r.getEsfUserRoleId()))){
				role = RoleLocalServiceUtil.fetchRole(r.getEsfUserRoleId());
			}
		%>
			<aui:option value="<%=role.getRoleId()%>" label="<%=role.getName()%>"></aui:option>
		<%
		}
		%>
		
	</aui:select>

	<aui:button  value='BDOReportRole' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"BDOReportRole();" %>' inlineField="true"/>
</div>

<div class="separator"></div>
<aui:button value='NatonalAssemblyReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"NatonalAssemblyReport();" %>' inlineField="true"/>


</fieldset>
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


Liferay.provide(window,'<portlet:namespace/>BDOReport',function(){

	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateBDOReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionBDO').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceBDO').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationBDO').val();
	var stateIdValue = A.one('#<portlet:namespace/>esfStateIdBDO').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateBDOReport', genrateBDOReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);
	resourceURL.setParameter('stateIdValue', stateIdValue);
	
	window.open(resourceURL.toString());
});


Liferay.provide(window,'<portlet:namespace/>BDOReportRole',function(){

	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateBDORoleReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionBDO').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceBDO').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationBDO').val();
	var rolesIdBDO = A.one('#<portlet:namespace/>rolesIdBDO').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateBDORoleReport', genrateBDORoleReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);
	resourceURL.setParameter('rolesIdBDO', rolesIdBDO);
	
	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>NatonalAssemblyReport',function(){

	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateNatonalAssemblyReport = true;
	var regionIdValue = A.one('#<portlet:namespace/>selRegionBDO').val();
	var provinceIdValue = A.one('#<portlet:namespace/>selProvinceBDO').val();
	var organizationIdValue = A.one('#<portlet:namespace/>selOrganizationBDO').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateNatonalAssemblyReport', genrateNatonalAssemblyReport);
	resourceURL.setParameter('regionIdValue', regionIdValue);
	resourceURL.setParameter('provinceIdValue', provinceIdValue);
	resourceURL.setParameter('organizationIdValue', organizationIdValue);
	
	window.open(resourceURL.toString());
});


</aui:script>
