<%@page import="java.text.DateFormat"%>
<%@include file="init.jsp"%>

<% 
	String dateString = ParamUtil.getString(request, "startDate");
	Date startDate = null;
	if(Validator.isNotNull(dateString)){
		startDate = ManageDate.StringToDate(dateString);
	}

	long matchTypeId = ParamUtil.getLong(request, "matchType");
	String code = ParamUtil.getString(request, "code");
	long esfCountryId = ParamUtil.getLong(request, "esfCountryId");

	List<ESFMatchType> esfMatchType = 
			ESFMatchTypeLocalServiceUtil.findAllByNational(isNational);
	
	String eventType = "";
	String addMatch = "";
	
	boolean olimpicMatch = 
		GetterUtil.getBoolean(
			portletPreferences.getValue(
				"olimpicMatch", StringPool.TRUE));

	boolean nationalMatch = 
		GetterUtil.getBoolean(
			portletPreferences.getValue(
				"nationalMatch", StringPool.TRUE));

	boolean event = 
		GetterUtil.getBoolean(
			portletPreferences.getValue(
				"event", StringPool.TRUE));
	
	if(olimpicMatch && !nationalMatch && !event){
		eventType = "olimpicMatch";
		addMatch = "add_Olimpic-Match";
	}
	
	if(nationalMatch && !olimpicMatch && !event){
		eventType = "nationalMatch";
		addMatch = "add_National-Match";
	}
	
	if(event && !nationalMatch && !olimpicMatch){
		eventType = "event";
		addMatch = "add_Event";
	}

%>

<aui:script use="aui-base,node,aui-io-request">
		$(function() {
			$("#<portlet:namespace/>startDate").datepicker();
			$("#<portlet:namespace/>startDate").datepicker("option",
					"dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>startDate").datepicker("setDate",
			'<%= dateString %>');
		});
	</aui:script>

	<c:if test="<%= ESFNationalMatchModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFNATIONALMATCH_ADD) %>">
		<aui:button-row cssClass="esfmatch-admin-buttons">
		
			<portlet:renderURL var="addEsfMatchURL">
				<portlet:param name="mvcPath" value='<%=templatePath + "new_edit_esfMatch.jsp"%>' />
				<portlet:param name="esfMatchId" value='' />
				<portlet:param name="organizationId" value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="op" value="addAddr" />
			</portlet:renderURL>
			<aui:button onClick="<%= addEsfMatchURL.toString() %>" value="<%=addMatch%>" />
		
		</aui:button-row>
	</c:if>

<aui:form action="<%=searchURL%>" method="get">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input name="returned" value="<%=true%>" type="hidden"/>
			<aui:input name="eventType" value="<%=eventType%>" type="hidden"/>
			<aui:input inlineField="<%=true%>" label="code" name="code"
				placeholder="code" size="" title="search-entries"
				type="text" />
				
			<aui:input inlineField="<%=true%>" label="start-date" name="startDate"
				placeholder="start-date" size="" title="search-entries"
				type="text" />
			
			<aui:select inlineField="<%=true%>" name="matchType" label = "match-type">
				<aui:option label="-" value="0" />
				<% 
					for(ESFMatchType m : esfMatchType){
				%>
				<aui:option value = "<%=m.getPrimaryKey()%>">
					<%=m.getName()%>
				</aui:option>
				<%}%>
			</aui:select>
				
			<aui:select name="esfCountryId" leable="esfCountryId">
				<aui:option label="-" value="0" />
			<%
				List<Country> countries = CountryServiceUtil.getCountries();
				for (Country country : countries) {
			%>
					<aui:option label="<%=country.getName()%>"
						value="<%=country.getCountryId()%>"></aui:option>
			<%
				}
			%>
			</aui:select>
			
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

		<liferay-ui:success key="user-success-insertupdate" message="user-success-insertupdate-mess" />
		<liferay-ui:error key="date-message" message="date-message" />
		<liferay-ui:error key="match-success-insertupdate" message="match-success-insertupdate" />
		
		<liferay-ui:search-container emptyResultsMessage="no-results">

			<liferay-ui:search-container-results 
				results="<%=
							ESFMatchLocalServiceUtil.
								findESFMatchsByStateIsNational_C_S_M_C_O(ESFKeys.ESFStateType.ENABLE,
								isNational, code, startDate, matchTypeId, esfCountryId, eventType,
								searchContainer.getStart(), searchContainer.getEnd())
						%>"
				total="<%=
							ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(
										ESFKeys.ESFStateType.ENABLE, isNational, code, startDate,
										matchTypeId, esfCountryId, eventType).size()
						%>" />
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">
				<%
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				String speciality = "";
				String eventName = "";
				
				List<ESFSportType> esfSportTypes = null ;
				
				if(olimpicMatch){
					esfSportTypes = ESFSportTypeLocalServiceUtil.getNational(true);
				}else{
					esfSportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
				}
				
				ESFSportType spec = new ESFSportTypeImpl();
				
				String sportType = esfMatch.getEsfNationalSportTypeId();
				
				if(Validator.isNotNull(sportType)){
					
					String [] splits = sportType.split("-");
				
					if( 0 < splits.length ){
						
						for(String s : splits){
							
							if( Validator.isNumber(s)){
								spec = ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.parseLong(s));
								if(Validator.isNotNull(spec) && Validator.isNotNull(spec.getName())){
									speciality = speciality + " " +spec.getName();
								}
							}
							
						}
					   
					}
				
				}
				
				if(!speciality.equals("")){
					speciality = speciality + "-";
				}

				String matchType = "";
				if(Validator.isNotNull(esfMatch.getEsfMatchTypeId()) && 
						Validator.isNotNull(ESFMatchTypeLocalServiceUtil.fetchESFMatchType(esfMatch.getEsfMatchTypeId()).getName())
						&& !"".equalsIgnoreCase(ESFMatchTypeLocalServiceUtil.fetchESFMatchType(esfMatch.getEsfMatchTypeId()).getName())){
					matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(esfMatch.getEsfMatchTypeId()).getName()+"-";
				}
				
				String matchCountry = "";
				if(Validator.isNotNull(esfMatch.getCountryId()) &&
					Validator.isNotNull(CountryServiceUtil.fetchCountry(esfMatch.getCountryId()).getName())){
					matchCountry = CountryServiceUtil.fetchCountry(esfMatch.getCountryId()).getName();
					matchCountry = matchCountry.toUpperCase();
				}else{
					matchCountry = "ITALIA";
				}	

				if(Validator.isNotNull(esfMatch.getDescription())) {
					eventName =	ESFDescriptionLocalServiceUtil.fetchESFDescription( esfMatch.getDescription()).getName()+"-";
				}

				String description =  matchType+eventName+speciality+matchCountry;
				%>
				<liferay-ui:search-container-column-text name="code"
					value="<%=Validator.isNotNull(esfMatch.getCode())
								? esfMatch.getCode() : StringPool.BLANK%>" />
				<liferay-ui:search-container-column-text name="start-date"
					value="<%=sdf.format(esfMatch.getStartDate())%>" />
				<liferay-ui:search-container-column-text name="end-date"
					value="<%=sdf.format(esfMatch.getEndDate())%>" />
				<liferay-ui:search-container-column-text name="description"
					value='<%=description%>' />
				<%	String site ="";
					if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getSite()) && !esfMatch.getSite().equals("")){
						site = esfMatch.getSite();
					}else if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getNotNationalAssotiation())){
						site = esfMatch.getNotNationalAssotiation();
					}%>
				<liferay-ui:search-container-column-text
					name="match-site" value='<%=site%>' />

				
					<liferay-ui:search-container-column-jsp
						path='<%=templatePath + "esfMatch_actions.jsp"%>' align="right" />

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
