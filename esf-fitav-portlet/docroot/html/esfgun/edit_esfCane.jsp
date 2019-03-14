
<%@page import="it.ethica.esf.model.impl.ESFgunUserImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.model.impl.ESFCaneImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@ include file="init.jsp"%>

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFCane esfCane = new ESFCaneImpl();
String namespace = renderResponse.getNamespace();
long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
long esfGunTypeId = 0;
long shooterId = ParamUtil.getLong(request, "shooterId");
long gUId = ParamUtil.getLong(request, "gUId");
ESFGunKind esfGunKind = new ESFGunKindImpl();
ESFGun gun = new ESFGunImpl();
ESFgunUser gU = new ESFgunUserImpl();
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));
List <ESFGunKind> l=ESFGunKindLocalServiceUtil.getESFGunKinds();
List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil.findbyESFGunId(esfCaneId);
String kindName = "";
String typologyName = "";
int typologyId = 0;
long kindId = 0;
long gunId = 0;
String gunName = "";
String shooter_note = "";
long gunUserId = 0;
boolean isFavorite = false;

for(ESFgunUser gunUser : gunUsers){
	if(ESFKeys.ESFGunType.CANE == gunUser.getType()){
		gU = gunUser;
	}
}


if(Validator.isNotNull(gU) && Validator.isNotNull(gU.getNote())){
	shooter_note = gU.getNote();
}
if(Validator.isNotNull(gU) && Validator.isNotNull(gU.getEsfGunUserId())){
	gunUserId = gU.getEsfGunUserId();
}
if(Validator.isNotNull(gU) && Validator.isNotNull(gU.getIsFavorite())){
	isFavorite = gU.getIsFavorite();
}
if(Validator.isNotNull(esfCaneId) && esfCaneId > 0){
	
	esfCane = ESFCaneLocalServiceUtil.fetchESFCane(esfCaneId);
	
	if(Validator.isNotNull(esfCane) && Validator.isNotNull(esfCane.getEsfGunKindId())){
		
		gunId = esfCane.getEsfGunKindId();
		
		gun = ESFGunLocalServiceUtil.fetchESFGun(esfCane.getEsfGunKindId());
		
		if(Validator.isNotNull(gun)){ 
			
			if(Validator.isNotNull(gun.getEsfGunKindId())){
				kindId = gun.getEsfGunKindId();
				esfGunKind = ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId());
			}
			if(Validator.isNotNull(gun.getName())){
				gunName = gun.getName();
			}
			
		}
		
		if(Validator.isNotNull(esfGunKind) && Validator.isNotNull(esfGunKind.getName())){
			kindName = esfGunKind.getName();
		}
		if(Validator.isNotNull(esfGunKind) && Validator.isNotNull(esfGunKind.getEsfGunTypeId())){
			esfGunTypeId = esfGunKind.getEsfGunTypeId();
		}
		
	}
	
}


List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();

int type = ESFKeys.ESFGunType.CANE;

boolean editable = true;

if(0 == shooterId){
	editable = false;
}
String shooterName = "";
ESFUser shooter = ESFUserLocalServiceUtil.fetchESFUser(shooterId);
if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getFirstName()) && Validator.isNotNull(shooter.getLastName())){
	shooterName = (shooter.getFirstName() + " " + shooter.getLastName());
}

ESFGunKind kind = new ESFGunKindImpl();
ESFCane cane = new ESFCaneImpl();

if(esfCaneId > 0){
	
	cane = ESFCaneLocalServiceUtil.fetchESFCane(esfCaneId);
	if(cane.getEsfGunKindId() > 0){
	kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(cane.getEsfGunKindId());
	}
	esfGunTypeId = ESFGunTypeLocalServiceUtil.fetchESFGunType(cane.getEsfGunTypeId()).getEsfGunTypeId();

}

%>
<liferay-ui:error key="error" message="error"/>
<liferay-ui:error key="duplicate_code" message="duplicate_code"/>

<%if(esfCaneId>0){ %>
<h3><liferay-ui:message key="edit_cane_message"></liferay-ui:message></h3>
<%}else{%>
<h3><liferay-ui:message key="add_cane_message"></liferay-ui:message></h3>
<%} %>


<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<portlet:actionURL name="editESFCane" var="editESFCaneURL" >
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="mvcPath" value='<%=templatePath %>' />
	<portlet:param name="type" value='<%=String.valueOf(type)%>' />
</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode)%>'/>
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
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
	
	<aui:input name="esfGunUserId" value="<%=gunUserId %>" type="hidden"/>
	
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
<div class="btn-field-align">	
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

<!-- pulsante marca arma -->
<aui:button onClick="<%= addESFGunTypeURL.toString() %>" value="add-brand"/>	
</div>
		 <% } %>

		<%} %> <!-- fine else modify mode -->
		
		<% if (!modifyMode) { %>
		<div id="show_checkKind">
<div class="btn-field-align">	
		<aui:select name="esfGunKindId" inlineField="true" >
			<%
			if(esfGunKind != null){
				
				 for (ESFGunKind esfGunKind1 : l){ 
					if (esfGunKind1.getEsfGunTypeId() == esfGunTypeId){
			%>
			<aui:option label="<%= esfGunKind1.getName() %>" value="<%= esfGunKind1.getEsfGunKindId() %>" selected="true"/>
			<%		
					}
				}
			} 
			%>
		</aui:select>	
<!-- pulsante modello arma -->
<aui:button onClick="<%= addESFGunKindURL.toString() %>" value="add-model" />
</div>	
	 <% }else{ %>
	 
	 		<aui:select name="esfGunKindId" inlineField="true" showEmptyOption="true">
	 			<%
	 			List<ESFGunKind> kinds = ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(esfGunTypeId);
	 			for (ESFGunKind esfGunKind1 : kinds){ 
	 				boolean find = false;
	 				
	 				if(esfGunKind1.getEsfGunKindId() == kind.getEsfGunKindId()){
	 					find = true;
	 				}
	 				%>
	 			<aui:option label="<%= esfGunKind1.getName() %>" value="<%= esfGunKind1.getEsfGunKindId() %>" selected="<%=find %>"/>
	 			
	 			<%	
	 			}%>
	 		</aui:select>
	 <%} %>
		</div>
		<aui:input name="code" label="freshman">
			<aui:validator name="required"  />
		</aui:input>
		
		<aui:input name="measures" label="measures"/>
		<aui:input name="caneCaliber" label="caliber">
		</aui:input>
		
		<%if(esfCaneId > 0){ %>
			<aui:select name="typology">
				<%
					List<ListType>  listType = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFGun.type");
					for(ListType t : listType){
						boolean find = false;
						if(t.getListTypeId() == esfCane.getTypeId()){
							find = true;
						}
					%>
						<aui:option label="<%= t.getName()%>" value="<%= t.getListTypeId()%>" selected="<%=find %>"/>
				<%
						
					}
				%>
			</aui:select>
		
		<%}else{ %>
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
		
		<%} %>
		<!-- aggiungere calibro tipologia e misure -->
		<%
		if(editable){ %>
		<aui:input type="hidden" label="userId" name="shooterId"  readonly="true" value="<%=shooterId %>"/>
		<aui:input type="text" name="userName" readonly="true" inlineField="true" value="<%=shooterName %>">
			<aui:validator name="required" />
		</aui:input>
		<%} else{ %>
	<div id="show_checkKind" class="btn-field-align">
		<aui:input type="hidden" label="userId" name="shooterId"  readonly="true"/>
		<aui:input type="text" name="userName" readonly="true" inlineField="true">
			<aui:validator name="required" />
		</aui:input>
		<aui:button class="aui-icon aui-icon-large aui-iconfont-add "
				id='<%=namespace + "chooseUserTrigger"%>' value="add">
		</aui:button>
	</div>
		<%} %>
	
	
		<aui:input name="isFavoriteGun" type="checkbox" value="<%=isFavorite%>"/>
		
		<aui:input name="shooter_note" type="text" value="<%=shooter_note %>">
		</aui:input>
		
	</aui:fieldset>
	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%="/html/esfgun/view.jsp"%>'  />
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
	var type = 1;
	console.log(esfGunTypeId);
	
	A.io.request(
		'<%= resourceURL %>',
		{
			method: "POST",
			data: {
				esfGunTypeId:esfGunTypeId,
				type:type,
			},
			contentType: "application/json; charset=utf-8",
			dataType: "json",
		on: {
			success: function() {
				var results = this.get('responseData');
				if(results) {

					var resultsOption = "<option value='0'>-</option>";
					//var resultsOption = "";
					for(index in results.esfGunKinds) {
						console.log(results.esfGunKinds[index].name);
						resultsOption += "<option value='" + results.esfGunKinds[index].esfGunKindId + "'>" + results.esfGunKinds[index].name + "</option>";
					}
					A.one("#<portlet:namespace/>esfGunKindId").html(resultsOption);
		
				} else {

					A.one("#<portlet:namespace/>esfGunKindId").html('');
			
					
				}
				//A.one("#<portlet:namespace/>esfGunId").focus();
				
			}
		}
	});	
}

A.one('#<portlet:namespace/>esfGunKindId').on('change', changeSelectKind);

function changeSelectKind(event){
	console.log("INTO kind");
	var element = event.currentTarget;
	var esfGunKindId = A.one('#<portlet:namespace/>esfGunKindId').get('value');
	var type = 2;
	console.log(esfGunKindId);
	
	A.io.request(
			'<%= resourceURL %>',
			{
				method: "POST",
				data: {
					esfGunKindId:esfGunKindId,
					type:type,
				},
				contentType: "application/json; charset=utf-8",
				dataType: "json",
			on: {
				success: function() {
					var results = this.get('responseData');
					if(results) {

						var resultsOption = "";
						for(index in results.esfGuns) {
							console.log(results.esfGuns[index].name);
							resultsOption += "<option value='" + results.esfGuns[index].esfGunId + "'>" + results.esfGuns[index].name + "</option>";
						}
						A.one("#<portlet:namespace/>esfGunId").html(resultsOption);
			
					} else {

						A.one("#<portlet:namespace/>esfGunId").html('');
				
						
					}
				}
			}
		});	
}

</aui:script>

