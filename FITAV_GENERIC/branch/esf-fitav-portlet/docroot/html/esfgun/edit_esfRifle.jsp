
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@ include file="init.jsp"%>

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFGunKind esfGun = new ESFGunKindImpl();
//ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunTypeId = 0;
String measures = "";
ESFGunKind esfGunKind = new ESFGunKindImpl();
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));
List <ESFGunKind> l=ESFGunKindLocalServiceUtil.getESFGunKinds();

if (esfGunId > 0) {

	esfGun = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGunId);

	if(Validator.isNotNull(esfGun) && Validator.isNotNull(esfGun.getEsfGunTypeId())){
		esfGunTypeId = esfGun.getEsfGunTypeId();
	}
		
}
List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);

List<ESFUser> gunners = ESFUserLocalServiceUtil.findAllShooters(
	currentOrganizationId, ESFKeys.ESFStateType.ENABLE, ESFKeys.ESFStateType.ENABLE);

User currentUser = PortalUtil.getUser(request);
%>

<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />
<%if(esfGunTypeId>0){ %>
<h3><liferay-ui:message key="edit_rifle_message"></liferay-ui:message></h3>
<%}else{%>
<h3><liferay-ui:message key="add_rifle_message"></liferay-ui:message></h3>
<%} %>

<portlet:actionURL name="editESFGun" var="editESFGunURL" >
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>"/>
	</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode) %>'/>
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>"/>
</portlet:renderURL>

<portlet:renderURL var="addESFGunKindURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunKind.jsp" %>'/>
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="modifyMode" value='<%=String.valueOf(modifyMode) %>'/>
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>"/>
</portlet:renderURL>

<aui:form action="<%=editESFGunURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfGun%>"
		model="<%=ESFGun.class%>" />
		
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
				}else{
			%>
				<aui:option label="<%= esfGunType.getName()%>"
					value="<%= esfGunType.getEsfGunTypeId()%>" />
			<%
				}
			}
			%>	
		</aui:select>
		<% if (!modifyMode) { %>
		<aui:button onClick="<%= addESFGunTypeURL.toString() %>" value="add-brand" inlineField="true" cssClass=".btn-field-align .btn"/>

		 <% } %>
</div>
		<%} %> <!-- fine else modify mode -->
			<aui:input name="name" />
			<aui:input name="description" type="textarea" />
	</aui:fieldset>
	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
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
	var element = event.currentTarget;
	var esfGunTypeId = A.one('#<portlet:namespace/>esfGunTypeId').get('value');
	var type = 1;
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