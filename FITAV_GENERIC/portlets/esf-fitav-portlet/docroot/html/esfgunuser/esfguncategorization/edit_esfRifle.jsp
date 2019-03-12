
<%@ include file="../init.jsp"%>


<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFGun esfGun = null;
//ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunTypeId = 0;
ESFGunKind esfGunKind = null;
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));
List <ESFGunKind> l=ESFGunKindLocalServiceUtil.getESFGunKinds();
if (esfGunId > 0) {

	esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfGun.getEsfGunKindId());
	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();


String shooterName = "";

ESFUser shooter = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);
if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getFirstName()) && Validator.isNotNull(shooter.getLastName())){
	shooterName = (shooter.getFirstName() + "" + shooter.getLastName()).toUpperCase();
}

%>


<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<portlet:actionURL name="editESFNewGun" var="editESFGunURL" >
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>"/>
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode) %>'/>
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>"/>
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:renderURL>

<portlet:renderURL var="addESFGunKindURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunKind.jsp" %>'/>
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode) %>'/>
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>"/>
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:renderURL>



<aui:form action="<%=editESFGunURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfGun%>"
		model="<%=ESFGun.class%>" />
				<aui:input name="name" type="text" label="shooter" value="<%=shooterName %>" disabled="true" />
	<aui:fieldset>

		<%if (modifyMode) {
			for (ESFGunType esfGunType : esfGunTypes) {
				if(esfGunType.getEsfGunTypeId() == esfGunTypeId){
			%>
			<aui:input name="brand-id" readonly="true" 
					value="<%=esfGunType.getName() %>" type="text"/>
					
			<aui:input name="esfGunTypeId" type="hidden"
					value="<%= esfGunTypeId%>" />
			<% 
				}
			}
		} else {  
		
		%> 
		
		<aui:select name="esfGunTypeId" label="brand-id" required="true" inlineField="true" disabled="<%=modifyMode %>" >
			<aui:option label="-"
					value="0" />
			<%
			for (ESFGunType esfGunType : esfGunTypes) {

				if(esfGunType.getEsfGunTypeId() == esfGunTypeId){
			%>
				<aui:option label="<%= esfGunType.getName()%>"
					value="<%= esfGunType.getEsfGunTypeId()%>" selected="true"/>
			<%
				}
				else{
			%>
				<aui:option label="<%= esfGunType.getName()%>"
					value="<%= esfGunType.getEsfGunTypeId()%>" />
			<%
				}
			}
			%>	
		</aui:select>
		<% if (!modifyMode) { %>
		<aui:button onClick="<%= addESFGunTypeURL.toString() %>"
		value="add-brand"/>

		 <% } %>

		<%} %> <!-- fine else modify mode -->
		
		
		<div id="show_checkKind">
		<aui:select name="esfGunKindId" required="true" inlineField="true" 
			>
			<%
			if(esfGunKind != null){
			%>
			<% for (ESFGunKind esfGunKind1:l){ 
						if (esfGunKind1.getEsfGunTypeId()==esfGunTypeId){
			
			%>
			<aui:option label="<%= esfGunKind1.getName() %>"
					value="<%= esfGunKind1.getEsfGunKindId() %>" selected="true"/>
			<%}}%>
			
				
			<%
				
			} 
			%>
		</aui:select>	
	
		<aui:button onClick="<%= addESFGunKindURL.toString() %>"
				value="add-model" 
		 />
	
		</div>
		
		<aui:input name="name" type="text" label="name" >
			<aui:validator name="required" errorMessage="please-enter-a-name" />
		</aui:input>
		
		<aui:input name="catridgeCaliber" type="text" label="caliber" >
		</aui:input>
		
		<aui:select name="typology" listType="it.ethica.esf.model.ESFGun.type" />	
					
		<aui:input name="measures" type="text">
		</aui:input>
		
		<aui:input type="text" name="note" />
		
		<aui:input type="text" name="code"  label="freshman">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="isFavoriteGun" label="is-favorite-gun" type="checkbox"/>
		
		<aui:input type="text" name="noteShooter" />
				
	</aui:fieldset>
	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
			<portlet:param name="op" value='<%="updAddr"%>' />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button type="submit" value="ADD-AND-ASSOCIATE"></aui:button>
		<aui:button type="cancel" onClick="<%= backUrl%>"></aui:button>
	</aui:button-row>
</aui:form>

<aui:script use="node,aui-io-request,liferay-portlet-url,aui-base">

A.one('#<portlet:namespace/>esfGunTypeId').on('change', changeSelect);

function changeSelect(event){
	var element = event.currentTarget;
	var esfGunTypeId = A.one('#<portlet:namespace/>esfGunTypeId').get('value');
	
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