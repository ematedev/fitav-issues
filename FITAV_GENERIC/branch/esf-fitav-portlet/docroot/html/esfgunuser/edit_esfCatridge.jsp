<%@ include file="init.jsp"%>


<%
String namespace = renderResponse.getNamespace();
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFCatridge esfCatridge = null;
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
long esfGunTypeId = 0;
ESFGun esfGun = null;
ESFGunKind esfGunKind = null;

List <ESFGunKind> l = ESFGunKindLocalServiceUtil.getESFGunKinds();

Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));

if (esfGunId > 0) {

	esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfGun.getEsfGunKindId());
	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}

if (esfCatridgeId > 0) {
	
	esfCatridge = ESFCatridgeLocalServiceUtil.getESFCatridge(esfCatridgeId);
	esfGunTypeId = esfCatridge.getEsfGunTypeId();


}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(true);

List<ESFUser> gunners = ESFUserLocalServiceUtil.findAllShooters(
	currentOrganizationId, ESFKeys.ESFStateType.ENABLE, ESFKeys.ESFStateType.ENABLE);
User currentUser = PortalUtil.getUser(request);
%>


<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<portlet:actionURL name="editESFCatridge" var="editESFCatridgeURL" >
	<portlet:param name="esfCatridgeId" value="<%=String.valueOf(esfCatridgeId)%>" />

	</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>

	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	
</portlet:renderURL>


<aui:form action="<%=editESFCatridgeURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfCatridge%>"
		model="<%=ESFCatridge.class%>" />
		
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


		<div id="show_checkKind">
		
		<aui:select name="catridgeModel" required="true" inlineField="true" 
			>
			<%
			List<ESFCatridge> cats = ESFCatridgeLocalServiceUtil.getESFCatridges();
			
			
				for (ESFCatridge cat:cats){ 
					if (cat.getEsfGunTypeId()==esfGunTypeId){
			
			%>
			<aui:option label="<%= cat.getCatridgeModel()%>"
					value="<%= cat.getEsfCatridgeId() %>" />
			<%		}
				}
			 
			%>
		</aui:select>	

		</div>

		<aui:input name="note" type="text">
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
	var isCatridge = true;
	console.log(esfGunTypeId);
	
	A.io.request(
		'<%= resourceURL %>',
		{
			method: "POST",
			data: {
				esfGunTypeId:esfGunTypeId,
				isCatridge:isCatridge
			},
			contentType: "application/json; charset=utf-8",
			dataType: "json",
		on: {
			success: function() {
				var results = this.get('responseData');
				if(results) {

					var resultsOption = "";
					for(index in results.esfCatridges) {
						console.log(results.esfCatridges[index].name);
						resultsOption += "<option value='" + results.esfCatridges[index].esfCatridgeId + "'>" + results.esfCatridges[index].name + "</option>";
					}
					A.one("#<portlet:namespace/>catridgeModel").html(resultsOption);
		
				} else {

					A.one("#<portlet:namespace/>catridgeModel").html('');
			
					
				}
			}
		}
	});	
}
</aui:script>
