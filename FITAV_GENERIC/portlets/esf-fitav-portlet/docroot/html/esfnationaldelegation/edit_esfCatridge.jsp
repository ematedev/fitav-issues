<%@ include file="init.jsp"%>


<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFCatridge esfCatridge = null;
long esfUserId = ParamUtil.getLong(request, "esfUserId");
ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
long esfGunTypeId = 0;
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));

if (esfCatridgeId > 0) {
	
	esfCatridge = ESFCatridgeLocalServiceUtil.getESFCatridge(esfCatridgeId);
	esfGunTypeId = esfCatridge.getEsfGunTypeId();
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(true);


%>

<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<portlet:actionURL name="editESFCatridge" var="editESFCatridgeURL" >
	<portlet:param name="esfCatridgeId" value="<%=String.valueOf(esfCatridgeId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="isCatridgeProductor" value="true"/>
</portlet:renderURL>


<aui:form action="<%=editESFCatridgeURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfCatridge%>"
		model="<%=ESFCatridge.class%>" />
		
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
		
		<aui:select name="catridgeModel"  inlineField="true" >
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
		
		<aui:input name="note" type="text"/>

				
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
	var isCatridge = true;
	
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
					resultsOption += "<option value=0>-</option>";
					for(index in results.esfCatridges) {
						resultsOption += "<option value='" + results.esfCatridges[index].esfCatridgeId + "'>" + results.esfCatridges[index].name + "</option>";
					}
					
					A.one("#<portlet:namespace/>catridgeModel").html(resultsOption);
		
				} else {
					console.log("else");
					A.one("#<portlet:namespace/>catridgeModel").html('');
			
					
				}
			}
		}
	});	
}
</aui:script>
