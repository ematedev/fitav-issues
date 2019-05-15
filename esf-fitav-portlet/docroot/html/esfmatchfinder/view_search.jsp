<%@include file="init.jsp"%>

<%		
	String dateString = ParamUtil.getString(request, "startDate");
	Date startDate = ManageDate.StringToDate(dateString);
	long description = ParamUtil.getLong(request, "description");
	long matchType = ParamUtil.getLong(request, "matchType");
	long assotiationName = ParamUtil.getLong(request, "assotiationName");
	
	PortletURL viewassURL = renderResponse.createRenderURL();
	viewassURL.setParameter(
		"mvcPath", "/html/esfmatchfinder/view_search.jsp");
	viewassURL.setParameter("startDate", startDate.toString());
	viewassURL.setParameter("description", String.valueOf(description));
	viewassURL.setParameter("matchType", String.valueOf(matchType));
	viewassURL.setParameter("assotiationName", String.valueOf(assotiationName));
	viewassURL.setParameter("isNational", String.valueOf(isNational));
	Calendar cal = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(cal);
	
	List<ESFOrganization> esfOrganizations = 
					ESFOrganizationLocalServiceUtil.findAllESFOrganizations(3, ESFKeys.ESFStateType.ENABLE);		//   DA SISTEMARE -----------------------------------------
						

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
		'<%= currDate %>');
	});
</aui:script>	

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

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
			<aui:input name="isNational" type="hidden"
				value="<%=isNational%>" /> 
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>
	<liferay-ui:search-container emptyResultsMessage="no-result">
		<liferay-ui:search-container-results>
			<%
				List<ESFMatch> esfMatches =
							ESFMatchLocalServiceUtil.
									getESFMatchesByMatchStartDate_T_A_D_N(
										startDate, matchType, assotiationName,
										description, isNational);
			
				/*ESFMatchLocalServiceUtil.
				getESFMatchesByMatchStartDate_t_A_D_N(
					startDate, matchType, assotiationName,
					description, isNational, searchContainer.getStart(),
					searchContainer.getEnd());*/
							
	
						pageContext.setAttribute("results", esfMatches);
						pageContext.setAttribute("total", esfMatches.size());
			%>
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">
			
			<% 
				Date d = esfMatch.getStartDate();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			%>
			<liferay-ui:search-container-column-text value="<%=sdf.format(esfMatch.getStartDate())%>"
				name="start-date" />
			
			<% 
				String desc = "";
				if(Validator.isNotNull(esfMatch)){
					if(Validator.isNotNull(esfMatch.getDescription())){
						desc = ESFDescriptionLocalServiceUtil.fetchESFDescription(
										esfMatch.getDescription()).getDescription();
					}	
				}
			%>
			<liferay-ui:search-container-column-text value="<%=desc%>"
				name="description" />	
	
			<% 
				String matchT = "";
				if(Validator.isNotNull(esfMatch)){
					if(Validator.isNotNull(esfMatch.getEsfMatchTypeId())){
						matchT = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(
							esfMatch.getEsfMatchTypeId()).getDescription();
					}
				}
			%>	
			<liferay-ui:search-container-column-text value="<%=matchT%>"
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
