<%@include file="init.jsp"%>

<%
	List<ESFState> esfStates =
		ESFStateLocalServiceUtil.findESFStates(ESFUserRole.class.getName());

	ESFEntityState esfEntityState =
		ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
			ESFUserRole.class.getName(), esfUserRoleId);
%>

<portlet:renderURL var="viewURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value="/html/esfuserrole/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name='updateESFEntityState'
	var="updateESFEntityStateURL" />

<aui:form action="<%=updateESFEntityStateURL%>"
	name="<portlet:namespace />fm">
	<aui:fieldset>

		<aui:select name="esfStateId">
			<%
				for (ESFState esfState : esfStates) {
								if (esfEntityState != null &&
									esfEntityState.getEsfStateId() == esfState.getEsfStateId()) {
			%>
			<aui:option value="<%=esfState.getEsfStateId()%>" selected="true"
				label="<%=esfState.getName()%>"></aui:option>
			<%
				}
								else {
			%>
			<aui:option value="<%=esfState.getEsfStateId()%>"
				label="<%=esfState.getName()%>"></aui:option>
			<%
				}
							}
			%>
		</aui:select>
		
		<aui:input type="hidden" name="esfUserRoleId" 
					value='<%= esfUserRoleId%>' />
					
	</aui:fieldset>


	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>" value="cancel"></aui:button>
	</aui:button-row>
</aui:form>
