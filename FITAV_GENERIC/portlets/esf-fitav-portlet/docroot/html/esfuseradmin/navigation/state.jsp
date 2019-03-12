<%@include file="init.jsp"%>

<%
	List<ESFState> esfStates =
		ESFStateLocalServiceUtil.findESFStates(ESFUser.class.getName());

	ESFEntityState esfEntityState =
		ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
			ESFUser.class.getName(), esfUserId);
	
%>
<c:choose>
	<c:when test="<%= esfUserId > 0 %>">
		<aui:fieldset>
		
			<aui:select name="esfStateId">
			<% 
				for(ESFState esfState: esfStates){ 
					if(esfEntityState != null && esfEntityState.getEsfStateId() == esfState.getEsfStateId()){
			%>
						<aui:option value="<%= esfState.getEsfStateId()%>" selected="true"
							label="<%= esfState.getName()%>"></aui:option>
			<%	
					}else{ 
			%>
						<aui:option value="<%= esfState.getEsfStateId()%>"
							label="<%= esfState.getName()%>"></aui:option>
			<%		}
				} 
			%>
			</aui:select>
		
			<%
			String visible = "display:none;";
		
			if (esfEntityState.getEsfStateId() != ESFKeys.ESFStateType.ENABLE) {
				visible = "";
			}
			%>
		
			<div id="cont-check-dis" style="<%=visible%>">
				<liferay-ui:icon-help message="help-disable-role"/>
				<aui:input name="disable" type="checkbox">
				</aui:input>
			</div>
			
		</aui:fieldset>
	
		<aui:script use="node,aui-io-request,liferay-auto-fields">
			
			A.one('#<portlet:namespace/>esfStateId').on('change', changeDisable);
			
			function changeDisable(event){
				var val = A.one('#<portlet:namespace/>esfStateId').get('value');
				if(val == '<%= ESFKeys.ESFStateType.ENABLE %>'){
					A.one('#cont-check-dis').setStyle('display', "none");
				}
				else{
					A.one('#cont-check-dis').setStyle('display', "");
				}
				console.log(val);
			}
		</aui:script>
	
	</c:when>
	<c:otherwise>
		<aui:input type="hidden" name="esfStateId"
				value='<%= ESFKeys.ESFStateType.ENABLE%>' />
		<div class="alert alert-info">
			<liferay-ui:message key="default-state" />
		</div>
	</c:otherwise>
</c:choose>