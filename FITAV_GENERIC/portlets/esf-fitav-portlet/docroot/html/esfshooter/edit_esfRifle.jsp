<%@ include file="init.jsp"%>

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFGun esfGun = null;
long esfUserId = ParamUtil.getLong(request, "esfUserId");
ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);


long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunTypeId = 0;
ESFGunKind esfGunKind = null;
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));
List <ESFGunKind> l=ESFGunKindLocalServiceUtil.getESFGunKinds();
String userName = "";
if (esfGunId > 0) {

	esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfGun.getEsfGunKindId());
	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);

if (esfUserId > 0) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
}

if( Validator.isNotNull(esfUser) ){
	
	userName = esfUser.getFirstName()+" "+esfUser.getLastName();
	String[] shooterName = {userName};
%>	
<h4><b><liferay-ui:message key="update-shooter-x" arguments="<%= shooterName%>"/></b>
				<div class="separator"></div>
<%
}
%>


<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<portlet:actionURL name="editESFRifle" var="editESFRifleURL" >
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode)%>'/>
</portlet:renderURL>

<portlet:renderURL var="addESFGunKindURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunKind.jsp" %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode)%>'/>
</portlet:renderURL>



<aui:form action="<%=editESFRifleURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfGun%>"
		model="<%=ESFGun.class%>" />
		
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
		
		
		<div id="show_checkKind" class="btn-field-align">
		
		<aui:select name="esfGunKindId"  inlineField="true" showEmptyOption="true" >
			
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
			<aui:button onClick="<%= addESFGunKindURL.toString() %>" value="add-esfgunkind"/>
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
			<portlet:param name="mvcPath" value='<%=templatePath + "edit_esfShooter.jsp"%>' />

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

					var resultsOption = "<option value=0>-</option>";
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