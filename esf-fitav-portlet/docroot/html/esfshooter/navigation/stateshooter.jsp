<%@include file="init.jsp"%>
<%
	List<ESFState> esfStates = ESFStateLocalServiceUtil.findESFStates(ESFUser.class.getName());

	ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil
			.findESFEntityStateByC_PK(ESFUser.class.getName(), esfUserId);
	
	boolean cunUpdate = false;
	
	if(Validator.isNotNull(esfUser)){
		cunUpdate = ESFShooterPermission.contains(permissionChecker, esfUserId, ActionKeys.ESFSHOOTER_UPDATE); 
	}
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	String privacy1Date = "";
	String privacy2Date = "";
	String privacy3Date = "";
	
	boolean privacy2= false;
	boolean privacy3= false;
	
	if(Validator.isNotNull(esfUser)){
		privacy2 = esfUser.getPrivacy2();
		privacy3 = esfUser.getPrivacy3();
	}
	
	if (Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getDatePrivacy1())) {
		privacy1Date = sdf.format(esfUser.getDatePrivacy1());
	} else {
		privacy1Date = ManageDate.CalendarToString(calendar);
	}
	
	if (Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getDatePrivacy2())) {
		privacy2Date = sdf.format(esfUser.getDatePrivacy2());
	} else {
		privacy2Date = ManageDate.CalendarToString(calendar);
	}
	
	if (Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getDatePrivacy3())) {
		privacy3Date = sdf.format(esfUser.getDatePrivacy3());
	} else {
		privacy3Date = ManageDate.CalendarToString(calendar);
	}
	
	
if(Validator.isNotNull(esfUser)){
%>

		<aui:fieldset>
		<% if(cunUpdate){ %>
			<aui:select name="esfStateId">
				<%
					for (ESFState esfState : esfStates) {
						if (esfEntityState != null
								&& esfEntityState.getEsfStateId() == esfState.getEsfStateId()) {
				%>
							<aui:option value="<%=esfState.getEsfStateId()%>" selected="<%= true %>"
								label="<%=esfState.getName()%>"></aui:option>
				<%
						} else {
				%>
							<aui:option value="<%=esfState.getEsfStateId()%>"
								label="<%=esfState.getName()%>"></aui:option>
				<%
						}
					}
				%>
			</aui:select>
		<%}
		else{
			
			String 	stateValue="";
			String stateName="";
			for (ESFState esfState : esfStates) {
				if (esfEntityState != null
						&& esfEntityState.getEsfStateId() == esfState.getEsfStateId()) {
					stateValue=String.valueOf(esfState.getEsfStateId());
					stateName=esfState.getName();
				}
			}	
		
		%>
			<aui:input name="state"
			type="text" 
			label="state"
			value='<%=stateName %>'
			disabled="true"></aui:input>
			<aui:input name="esfStateId" type="hidden" value="<%=stateValue %>" />
		<%	}	%>
		
		</aui:fieldset>
		
<%} %>		
	<div>
		<div>
		
			<h4> <liferay-ui:message key="privacy1-info" /> </h4>
			<small> <liferay-ui:message key="Compulsory-acceptance" /></small>
			
			<div class="btn-field-align">
				<aui:input name="privacy1" type="radio" checked="<%=true%>" label="agree" disabled="true" inlineField="true"/>
				<aui:input name="privacy1" type="radio" checked="<%=false%>" label="notAgree" disabled="true" inlineField="true"/>
			</div>
				<aui:input name="privacy1Date" type="text" disabled="true" label="dateAgree" value="<%=privacy1Date %>" />
		
		</div>
		
		<div>
			<h4> <liferay-ui:message key="privacy2-info" /> </h4>
			<div class="btn-field-align">
				<aui:input  name="privacy2" type="radio" checked="<%=privacy2%>" label="agree" inlineField="true" value="true"/>
				<aui:input  name="privacy2" type="radio" checked="<%=!privacy2%>" label="notAgree" inlineField="true" value="false"/>
			</div>
				
				<aui:input name="privacy2Date" type="text" label="dateAgree"/>
		</div>
		
		<div>
			<h4> <liferay-ui:message key="privacy3-info" /> </h4>

			<div class="btn-field-align">
				<aui:input  name="privacy3" type="radio" checked="<%=privacy3%>" label="agree" inlineField="true" value="true"/>
				<aui:input  name="privacy3" type="radio" checked="<%=!privacy3%>" label="notAgree" inlineField="true" value="false"/>
			</div>
				<aui:input name="privacy3Date" type="text" label="dateAgree"/>
		
		</div>
	</div>
		
		
<aui:script use="aui-base,node,aui-io-request">		
		
		$(function() {
		$("#<portlet:namespace/>privacy1Date").datepicker();
		$("#<portlet:namespace/>privacy1Date").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>privacy1Date").datepicker("setDate",
				'<%= privacy1Date %>');
		});
		
		
		$(function() {
		$("#<portlet:namespace/>privacy2Date").datepicker();
		$("#<portlet:namespace/>privacy2Date").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>privacy2Date").datepicker("setDate",
				'<%= privacy2Date %>');
		});
		
		
		$(function() {
		$("#<portlet:namespace/>privacy3Date").datepicker();
		$("#<portlet:namespace/>privacy3Date").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>privacy3Date").datepicker("setDate",
				'<%= privacy3Date %>');
		});
</aui:script>	