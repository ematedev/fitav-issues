
<%@ include file="init.jsp"%>


<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFCane esfCane = null;
long esfUserId = ParamUtil.getLong(request, "esfUserId");

long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
long esfGunTypeId = 0;
ESFGunKind esfGunKind = null;
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));
List <ESFGunKind> l=ESFGunKindLocalServiceUtil.getESFGunKinds();
if (esfCaneId > 0) {

	esfCane = ESFCaneLocalServiceUtil.getESFCane(esfCaneId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfCane.getEsfGunKindId());
	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);

List<ESFUser> gunners = ESFUserLocalServiceUtil.findAllShooters(
	currentOrganizationId, ESFKeys.ESFStateType.ENABLE, ESFKeys.ESFStateType.ENABLE);
%>


<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<portlet:actionURL name="editESFCane" var="editESFCaneURL" >
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode)%>'/>
	<portlet:param name="from" value="cane"/>
</portlet:renderURL>

<portlet:renderURL var="addESFGunKindURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunKind.jsp" %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode)%>'/>
	<portlet:param name="from" value="cane"/>
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
</portlet:renderURL>



<aui:form action="<%=editESFCaneURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfCane%>"
		model="<%=ESFCane.class%>" />
		
	<aui:fieldset>
	
		
<div class="btn-field-align">
		<aui:select name="esfGunTypeId" label="brand-id" required="true" inlineField="true" disabled="<%=modifyMode %>" >
			<aui:option label="-" value="0" />
<%	for (ESFGunType esfGunType : esfGunTypes) {%>
				<aui:option label="<%= esfGunType.getName()%>" value="<%= esfGunType.getEsfGunTypeId()%>" />
<% }%>	
		</aui:select>
		<% if (!modifyMode) { %>
		
		<aui:button onClick="<%= addESFGunTypeURL.toString() %>" value="add-brand"/>

		 <% } %>
</div>		

	<div id="show_checkKind">

		<aui:select name="esfGunKindId" inlineField="true" >
		
			<%
			if(esfGunKind != null){
			
				for (ESFGunKind esfGunKind1:l){ 
					if (esfGunKind1.getEsfGunTypeId()==esfGunTypeId){
			
			%>
			<aui:option label="<%= esfGunKind1.getName() %>"
					value="<%= esfGunKind1.getEsfGunKindId() %>" selected="true"/>
			<%		}
				}
			} 
			%>
		</aui:select>	

	</div>
	
		<aui:select name="typology">
			<%
				List<ListType>  listType = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFGun.type");
				for(ListType t : listType){
				%>
					<aui:option label="<%= t.getName()%>" value="<%= t.getListTypeId()%>" />
			<%
				}
			%>
		</aui:select>
		
		<aui:input name="measures" label="measures" type="text"/>
		
		<aui:input name="caliber" label="caliber" type="text">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="min">0</aui:validator>
		</aui:input>
	
		
		<aui:input name="code" label="freshman" >
			<aui:validator name="required"  />
		</aui:input>
		
		<aui:input name="isFavoriteGun" type="checkbox" ></aui:input>		
								
		<aui:input name="shooter_note" type="text">
		</aui:input>
						
	</aui:fieldset>
	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%=templatePath + "edit_esfShooter.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= backUrl%>"></aui:button>
	</aui:button-row>
</aui:form>

<aui:script use="node,aui-io-request,liferay-portlet-url,aui-base">

A.one('#<portlet:namespace/>esfGunTypeId').on('change', changeSelect);

function changeSelect(event){
	console.log("INTO");
	var element = event.currentTarget;
	var esfGunTypeId = A.one('#<portlet:namespace/>esfGunTypeId').get('value');
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
					resultsOption += "<option value=0>-</option>";
					for(index in results.esfGunKinds) {
						console.log(results.esfGunKinds[index].name);
						resultsOption += "<option value='" + results.esfGunKinds[index].esfGunKindId + "'>" + results.esfGunKinds[index].name + "</option>";
					}
					A.one("#<portlet:namespace/>esfGunKindId").html(resultsOption);
		
				} else {

					A.one("#<portlet:namespace/>esfGunKindId").html('');
			
					
				}
			}
		}
	});	
}
</aui:script>