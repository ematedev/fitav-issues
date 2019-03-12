<%@include file="init.jsp"%>

<%
	List<ESFState> esfStates = ESFStateLocalServiceUtil.findESFStates(ESFOrganization.class.getName());

	ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil
			.findESFEntityStateByC_PK(ESFOrganization.class.getName(), currentOrganizationId);
	ESFOrganization org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	Date now = new Date();
	String currDateE = ManageDate.DateToString(now);
	
	boolean readOnlyState=false;
	if(!ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_STATE)){
		readOnlyState=true;
	}
	
%>
<div>
	<aui:fieldset>
		<%
		if(readOnlyState){
			
			ESFState estate=ESFStateLocalServiceUtil.fetchESFState(esfEntityState.getEsfStateId());
		%>
			<aui:input name="esfStateIdH" label="state" type="text" disabled="true" value="<%= estate.getName() %>" />
			<aui:input name="esfStateId" type="hidden"  value="<%=String.valueOf(esfEntityState.getEsfStateId()) %>"  />
				
		<%
		}else{
		%>
		<aui:select name="esfStateId" inlineField="true">


			<%
				for (ESFState esfState : esfStates) {
					boolean selected = false;
					if (Validator.isNotNull(esfState)) {
						String name = esfState.getName() + "**";
						if (esfState.getEsfStateId() == esfEntityState.getEsfStateId()) {
							selected = true;
						}
			%>
					<aui:option value="<%=esfState.getEsfStateId()%>"
						selected="<%=selected%>" label="<%=name%>"></aui:option>
			<%
					}
				}
		}
			%>
		</aui:select>

	</aui:fieldset>

	<%
		List<ListType> variations = ListTypeServiceUtil
			.getListTypes("it.ethica.esf.model.ESFOrganization.variation");
	
		if(readOnlyState){
			ListType lt=ListTypeServiceUtil.getListType(Integer.parseInt(String.valueOf(org.getVariations())));
		%>
			<aui:input name="variationH" label="variation" type="text" disabled="true" value="<%= lt.getName() %>" />
			<aui:input name="variation" type="hidden"  value="<%=String.valueOf(org.getVariations()) %>"  />
				
		<%
		}else{
		%>

			<aui:select name="variation">
	
			<%
				for (ListType variation : variations) {
						boolean varSelected = false;
						if (Validator.isNotNull(variation)) {
							String variationName = variation.getName();
							if (variation.getListTypeId() == org.getVariations()) {
								varSelected = true;
							}
			%>
	
			<aui:option value="<%=variation.getListTypeId()%>"
				selected="<%=varSelected%>" label="<%=variationName%>"></aui:option>
		<%
					}
				}
			}
		%>


	</aui:select>

	<aui:input name="stateVariationDate" type="text">

	</aui:input>

</div>


<aui:script>
	$(function() {
		$("#<portlet:namespace/>stateVariationDate").datepicker();
		$("#<portlet:namespace/>stateVariationDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>stateVariationDate").datepicker("setDate",
				'<%= currDateE %>');

	});

	
</aui:script>