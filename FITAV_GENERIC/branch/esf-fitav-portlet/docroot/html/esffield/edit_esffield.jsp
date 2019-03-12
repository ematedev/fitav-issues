<%@page import="it.ethica.esf.util.ESFKeys.ESFStateType"%>
<%@ include file="init.jsp" %>

<%
ESFField esfField = null;


long esfFieldId = ParamUtil.getLong(request, "esfFieldId");

int number = (Integer)request.getAttribute("numberOfMachines");

if (esfFieldId > 0) {

	esfField = ESFFieldLocalServiceUtil.getESFField(esfFieldId);

}

List<ESFSportType> esfSportTypes = ESFSportTypeLocalServiceUtil
		.getAllESFSportTypes();
List<ESFSportType> esfFieldSportType = ESFSportTypeLocalServiceUtil.findByESFFieldId(esfFieldId);

List<ESFState> esfStates =
ESFStateLocalServiceUtil.findESFStates(ESFField.class.getName());
ESFEntityState esfEntityState =
ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
	ESFField.class.getName(), esfFieldId);
%>

<portlet:actionURL name="editESFField" var="editESFFieldURL" />

<aui:form action="<%= editESFFieldURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfField %>" model="<%= ESFField.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfFieldId"
				value='<%= esfField == null ? "" : esfField.getEsfFieldId() %>' />
			<aui:input type="hidden" name="ownerOrganizationId"
				value='<%= currentOrganizationId %>' />
				
			<aui:input name="name" >
				<aui:validator name="required" errorMessage="please-enter-a-name" />
			</aui:input>
			
			<aui:select name="esfSportTypeId" multiple="true">
				<% 
				for (ESFSportType esfSportType : esfSportTypes) { %>
					<aui:option selected="<%= esfField == null ? false : esfFieldSportType.contains(esfSportType) %>"
						label="<%= esfSportType.getName() %>" 
						value="<%= esfSportType.getEsfSportTypeId()  %>"/>
				<% } %>
			</aui:select>
			
			<c:choose>
				<c:when test="<%=ESFFieldPermission.contains(permissionChecker, esfField.getEsfFieldId(), ActionKeys.ESFFIELD_UPDATE_STATE) %>">
					<aui:select name="esfStateId">
					<% 
						String fieldName = "";
						for(ESFState esfState: esfStates){ 
							if(esfEntityState != null && esfEntityState.getEsfStateId() == esfState.getEsfStateId()){
								fieldName =  esfState.getName()+"++";
					%>
								<aui:option value="<%= esfState.getEsfStateId()%>" selected="true"
									label="<%= fieldName%>"></aui:option>
					<%	
							}else{ 
								fieldName = esfState.getName()+"++";
					%>
								<aui:option value="<%= esfState.getEsfStateId()%>"
									label="<%= fieldName%>"></aui:option>
					<%		}
						} 
					%>
					</aui:select>
				</c:when>
				<c:otherwise>
					<% 
						String fieldName = "";
						String stateId= String.valueOf(ESFStateType.DISABLE);
						for(ESFState esfState: esfStates){ 
							if(esfEntityState != null && esfEntityState.getEsfStateId() == esfState.getEsfStateId()){
								fieldName =  esfState.getName();
								stateId= String.valueOf(esfState.getEsfStateId());
							}
						}
					%>
					<aui:input name="esfStateId" type="hidden" value="<%= stateId %>" >
					</aui:input>
			
				</c:otherwise>
			</c:choose>
			
		</aui:fieldset>
		<aui:fieldset>
			<h3>
				<liferay-ui:message key="more-info" />
			</h3>
			
			<aui:select name="billboard" >
				<%
				List<ListType> billboards =  ListTypeServiceUtil.
				getListTypes(ESFField.class.getName() + ESFListType.BILLBOARD);
			
				for (ListType billboard : billboards) {
			
					String label = billboard.getName();
			
				%>	
					<aui:option label="<%= label %>" 
						value="<%= billboard.getListTypeId() %>"/>
				<% 
				}
				%>
			</aui:select>	
			
			<aui:input name="billboardStations" />
			<div>
				<h3><liferay-ui:message key="esf-field-background-id" /></h3>
				<aui:input name="backgroundRampart" inlineField="true"/>
				
				<aui:input name="backgroundNet" inlineField="true"/>
				
				<aui:input name="backgroundLeadRecovery" inlineField="true"/>
			</div>
			<aui:input name="disabledAccess" />
			<aui:input name="note" type="textarea" />
			
			<h3><liferay-ui:message key="esf-field-machines" /></h3>
			
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields">	
					<liferay-util:include page='<%= jspMachineTL %>' servletContext="<%= application%>" >
						<liferay-util:param name="iesima" value="<%= Integer.toString(0) %>"></liferay-util:param>
						<liferay-util:param name="idOwner" value="<%= Long.toString(esfFieldId) %>"></liferay-util:param>
					</liferay-util:include>
				</div>
			</div>
			
			<% 
	
			for (int i = ESFKeys.MinElemIncludePage.MINMACHINE; i < ESFKeys.MinElemIncludePage.MAXMACHINE; i++){ 
				
				String visible = "display:none;";
				
				if(i < number){
					
					visible = "";
				}
			%>
			
			<div class="lfr-form-row lfr-form-row-inline" style="<%= visible%>" id='<%= "cont-"+i%>'>
				<div class="row-fields">	
					<liferay-util:include page='<%= jspMachineTL %>' servletContext="<%= application%>" >
						<liferay-util:param name="iesima" value="<%= Integer.toString(i) %>"></liferay-util:param>
						<liferay-util:param name="idOwner" value="<%= Long.toString(esfFieldId) %>"></liferay-util:param>
					</liferay-util:include>
				</div>
			</div>
			
			<%} %>
	
	
		<aui:input name="numberOfMachines" type="hidden" value="<%= number%>" />
		
		<aui:button name="btnadd" value="add-addr" cssClass="btn"></aui:button>
		<aui:button name="btnrem" value="rem-addr"></aui:button>

			
		</aui:fieldset>
		
		<liferay-ui:asset-links className="<%= ESFField.class.getName() %>"
			classPK="<%= esfFieldId %>"></liferay-ui:asset-links>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>" value="cancel"></aui:button>
		</aui:button-row>
</aui:form>

<aui:script use="node,aui-io-request,liferay-auto-fields">

A.one('#<portlet:namespace/>btnadd').on('click', addMachine);
A.one('#<portlet:namespace/>btnrem').on('click', removeMachine);

var maxS = '<%= ESFKeys.MinElemIncludePage.MAXMACHINE %>'; 
var minS = '<%= ESFKeys.MinElemIncludePage.MINMACHINE %>'; 

var max = parseInt(maxS);
var min = parseInt(minS);

function addMachine(event){
	var numS = A.one('#<portlet:namespace/>numberOfMachines').get('value');
	var num = parseInt(numS);
	
	if(max > num){
		
		A.one('#cont-'+num).setStyle('display', "");
		num++;
		A.one('#<portlet:namespace/>numberOfMachines').set('value', num);
	
	}
	else{
		alert('Massimo '+max+' macchine');
	}
}

function removeMachine(event){
	var numS = A.one('#<portlet:namespace/>numberOfMachines').get('value');
	var num = parseInt(numS);
	
	if(num > min){
		num--;
		A.one('#<portlet:namespace/>numberOfMachines').set('value', num);
		A.one('#cont-'+num).setStyle('display', "none");
	}
}


</aui:script>