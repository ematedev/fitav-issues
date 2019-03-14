
<%@include file="init.jsp"%>

<%		

	List<ESFOrganization> esfOrganizations = 
					ESFOrganizationLocalServiceUtil.findAllESFOrganizations(3,ESFKeys.ESFStateType.ENABLE);		//   DA SISTEMARE -----------------------------------------
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);

	List<ESFDescription> esfDescription = 
			ESFDescriptionLocalServiceUtil.findAll();
	
	List<ESFMatchType> esfMatchType = 
					ESFMatchTypeLocalServiceUtil.findAll();
%>

<aui:script use="aui-base,node,aui-io-request">
	$(function() {
		$("#<portlet:namespace/>startDate").datepicker();
		$("#<portlet:namespace/>startDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>startDate").datepicker("setDate",
		null);
	}); 
</aui:script>	

<aui:form action="<%=searchURL%>" method="get">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input inlineField="<%=true%>" label="start-date" name="startDate"
				placeholder="start-date" size="" title="search-entries"
				type="text" />
			
			<aui:select inlineField="<%=true%>" name="description" label = "description">
				<aui:option label="-" value="0" />
				<% 
					for(ESFDescription d : esfDescription){
				%>
				<aui:option value = "<%=d.getPrimaryKey()%>">
					<%=d.getDescription()%>
				</aui:option>
				<%}%>
			</aui:select>
			<aui:select inlineField="<%=true%>" name="matchType" label = "match-type">
				<aui:option label="-" value="0" />
				<% 
					for(ESFMatchType m : esfMatchType){
				%>
				<aui:option value = "<%=m.getPrimaryKey()%>">
					<%=m.getDescription()%>
				</aui:option>
				<%}%>
			</aui:select>
			<aui:select inlineField="<%=true%>" name="assotiationName" label = "assotiation-name">
				<aui:option label="-" value="0" />
				<% 
					for(ESFOrganization o : esfOrganizations){
				%>
				<aui:option value = "<%=o.getPrimaryKey()%>">
					<%=o.getName()%>
				</aui:option>
				<%}%>
			</aui:select>	
			<aui:input inlineField="<%=true%>" name="isNational" type="hidden"
				value="<%=isNational%>" /> 
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>
	<liferay-ui:search-container emptyResultsMessage="no-result">
		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">
			
			<% 
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			%>
			<liferay-ui:search-container-column-text value="<%=sdf.format(esfMatch.getStartDate())%>"
				name="start-date" />
			
			<% 
				String description = "";
				if(Validator.isNotNull(esfMatch)){
					if(Validator.isNotNull(esfMatch.getDescription())){
							description = ESFDescriptionLocalServiceUtil.fetchESFDescription(
										esfMatch.getDescription()).getDescription();
					}
				}
			%>
			<liferay-ui:search-container-column-text value="<%=description%>"
				name="description" />	
	
			<% 
				String matchType = "";
				if(Validator.isNotNull(esfMatch)){
					if(Validator.isNotNull(esfMatch.getEsfMatchId())){
						matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(
								esfMatch.getEsfMatchId()).getDescription();
					}	
				}
			%>	
			<liferay-ui:search-container-column-text value="<%=matchType%>"
				name="match-type" />	
			<% 
				String asName = "";
				if(Validator.isNotNull(esfMatch)){
					if(Validator.isNotNull(esfMatch.getEsfAssociationId())){
						asName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(
							esfMatch.getEsfAssociationId()).getName();
					}
				}
			%>	
			<liferay-ui:search-container-column-text value="<%=asName%>"
				name="assotiation-name" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>