
<%@include file="init.jsp"%>


<%
	ESFEntityState esfEntityState =
		ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
			ESFOrganization.class.getName(), currentOrganizationId);

	String stateName = "";
	String stateChanged = "";
	String variationChanged = "";
	
	if(Validator.isNotNull(esfEntityState)){
		stateName = ESFStateLocalServiceUtil.fetchESFState(esfEntityState.getEsfStateId()).getName();
		stateChanged = stateName;
	}
	
	ESFOrganization org = null;
	org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
	Integer varOrgId = (int)org.getVariations();
	String orgNote = "";
	if(varOrgId>0){
		variationChanged = ListTypeServiceUtil.getListType(varOrgId).getName();
	}
%>
<div class="row detail">
<h3>
	<liferay-ui:message key="state" />
</h3>
<c:choose>
	
		<c:when test="<%=stateName != null%>">
			<h4>
				<liferay-ui:message key="state_Org" />
			</h4>
			<p>
				<liferay-ui:message key="<%=stateName%>" />
			</p>
		</c:when>
	
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="no-content" />
		</div>
	</c:otherwise>
</c:choose>

<h4>
	<liferay-ui:message key="variation" />
</h4>

	<%if(org.getVariations() > 0 ){ %>
	<p>
		<liferay-ui:message key="<%=ESFOrganizationLocalServiceUtil.getNameT(org)%>" />
	</p>
	<%}else{ %>
	<p>
		<liferay-ui:message key="no-content" />
	</p>
	<%} %>

	<h4>
	<liferay-ui:message key="note" />
	</h4>

	<%if(Validator.isNotNull(org)){ %>
	<p>
		<liferay-ui:message key="<%=org.getNote()%>" />
	</p>
	<%}else{ %>
	<p>
		<liferay-ui:message key="no-content" />
	</p>
	<%} %>

</div>

<%
List<ESFHistoricalAssociation> historyTot =  ESFHistoricalAssociationLocalServiceUtil.findESFHistoricalAssociationByesfOrganizationId(currentOrganizationId);
if(historyTot.size()>0){
%>

<h3>
	<liferay-ui:message key="OrganizatioHistory" />
</h3>

<%	for(ESFHistoricalAssociation h : historyTot){ 
	String variation = "";
	String state = "";
	String variationName = "";
	
	Integer varId = (int) h.getVariationId();
	if(varId>0){
	ListType listVar = ListTypeServiceUtil.getListType(varId);
	variationName = listVar.getName();
	}
	
	if(h.getStateId()>0){
		stateChanged =  ESFStateLocalServiceUtil.fetchESFState(h.getStateId()).getName();
		state = stateChanged;
	}
	if(h.getVariationId()>0){
		
		variationChanged =  variationName;
		
	}
	variation = variationChanged;
	%>
<div class="row organization-history">

	<div class="name">
		<aui:input name="name" type="text" disabled="true"
					 value='<%=h.getName()%>' inlineField="true">
		</aui:input>
	</div>
	
	<div class="code">
		<aui:input name="code"  type="text" disabled="true"
					 value='<%=h.getCode()%>' inlineField="true">
		</aui:input>
	</div>
	
	<div class="state">
	<%
	System.out.println("state="+state);
	%>
		<aui:input name="state" label="state_Org" type="text" disabled="true"
					value='<%=state%>' inlineField="true">
		</aui:input>
	</div>
	
	<div class="variation">
		<aui:input name="variation"  type="text" disabled="true"
					 value='<%=variation%>' inlineField="true">
		</aui:input>
	</div>
	
	<div class="dateChange">
		<aui:input name="dateChange" cssClass="date" type="text" disabled="true"
					 value='<%=sdf.format(h.getDateChange())%>' inlineField="true">
		</aui:input>
	</div>
		
</div>
<%
	}

} %>

