
<%@ include file="init.jsp"%>


<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFCatridge esfCatridge = null;


long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));

if (esfCatridgeId > 0) {
	
	esfCatridge = ESFCatridgeLocalServiceUtil.getESFCatridge(esfCatridgeId);
	esfGunTypeId = esfCatridge.getEsfGunTypeId();

}

//List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();
List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(true);

List<ESFUser> gunners = ESFUserLocalServiceUtil.findAllShooters(
	currentOrganizationId, ESFKeys.ESFStateType.ENABLE, ESFKeys.ESFStateType.ENABLE);
User currentUser = PortalUtil.getUser(request);
%>


<portlet:resourceURL var="resourceURL" id='<%="esfGunTypeId"%>' escapeXml="false" />

<%if(esfCatridgeId>0){ %>
<h3><liferay-ui:message key="edit_catridge_message"></liferay-ui:message></h3>
<%}else{%>
<h3><liferay-ui:message key="add_catridge_message"></liferay-ui:message></h3>
<%} %>

<portlet:actionURL name="editESFCatridge" var="editESFCatridgeURL" >
	<portlet:param name="esfCatridgeId" value="<%=String.valueOf(esfCatridgeId)%>" />
		<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>"/>

	</portlet:actionURL>
	
<portlet:renderURL var="addESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "add_esfGunType.jsp" %>'/>
	<portlet:param name="isCatridgeProductor" value='true'/>
	<portlet:param name="pathBack" value='<%=thisPath %>'/>
	<portlet:param name="from" value="1"/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	
</portlet:renderURL>


<aui:form action="<%=editESFCatridgeURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfCatridge%>"
		model="<%=ESFCatridge.class%>" />
		
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
			<aui:option label="-" value="0" />
			<%
			for (ESFGunType esfGunType : esfGunTypes) {

				if(esfGunType.getEsfGunTypeId() == esfGunTypeId){
			%>
				<aui:option label="<%= esfGunType.getName()%>"
					value="<%= esfGunType.getEsfGunTypeId()%>" selected="true" />
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
		<aui:button onClick="<%= addESFGunTypeURL.toString() %>" value="add-brand"/>
</div>
		 <% } %>

		<%} %> <!-- fine else modify mode -->
		
		<aui:input name="catridgeModel"  >
		</aui:input>

		<aui:input name="catridgeCaliber" type="text">
		</aui:input>

		<aui:input name="note" type="text">
		</aui:input>

				
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


