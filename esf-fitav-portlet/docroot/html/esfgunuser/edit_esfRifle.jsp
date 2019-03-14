<%@page import="it.ethica.esf.model.impl.ESFgunUserImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>


<%
String namespace = renderResponse.getNamespace();
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFGun esfGun = null;
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
//ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunTypeId = 0;
ESFGunKind esfGunKind = null;
String esfKindName = "";
String code = "";
String note = "";
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));
List <ESFGunKind> l = ESFGunKindLocalServiceUtil.getESFGunKinds();
ESFgunUser gunUserData = new ESFgunUserImpl();
if(Validator.isNotNull(esfgunUserId) && Validator.isNotNull(ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId)) ){
	 gunUserData = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
}
if(Validator.isNotNull(gunUserData)){
	code = gunUserData.getCode();
	note = gunUserData.getNote();
}
if (esfGunId > 0) {

	esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfGun.getEsfGunKindId());
	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}
if(Validator.isNotNull(esfGunKind) && Validator.isNotNull(esfGunKind.getName())){
	esfKindName = esfGunKind.getName();
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);

%>


<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<portlet:actionURL name="assignESFGun" var="assignESFGunURL" >
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode) %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId) %>'/>
</portlet:renderURL>

<portlet:renderURL var="addESFGunKindURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunKind.jsp" %>'/>
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode) %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId) %>'/>
	<portlet:param name="esfGunTypeId" value='<%=String.valueOf(esfGunTypeId) %>'/>
</portlet:renderURL>

<portlet:renderURL var="changeWeaponURL">
	<portlet:param name="mvcPath" value='<%= templatePath+"esfguncategorization/esfrifle.jsp" %>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:renderURL>



<aui:form action="<%=assignESFGunURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfGun%>"
		model="<%=ESFGun.class%>" />
		
	<aui:fieldset>
	
		<div id="show_checkKind" class="btn-field-align">
		<aui:input type="hidden" label="userId" name="shooterId"  readonly="true"/>
		<aui:input type="text" name="userName" readonly="true" inlineField="true">
			<aui:validator name="required" />
		</aui:input>
			<aui:button class="aui-icon aui-icon-large aui-iconfont-add "
					id='<%=namespace + "chooseUserTrigger"%>' value="search">
			</aui:button>
		</div>
		
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
		
		<aui:select name="esfGunKindId" required="true" inlineField="true" 
			>
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
		
		<aui:input name="code" label="freshman" >
			<aui:validator name="required"  />
		</aui:input>
		
		<aui:input name="isFavoriteGun" type="checkbox" ></aui:input>		
								
		<aui:input name="shooter_note" type="text">
		</aui:input>
		

				
	</aui:fieldset>
	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='/html/esfgunuser/view.jsp' />
			<portlet:param name="op" value='<%="updAddr"%>' />
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

