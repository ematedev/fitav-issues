

<%@include file="init.jsp"%>
<% 
	String dateString = ParamUtil.getString(request, "startDate");
	Date startDate = null;
	if(Validator.isNotNull(dateString)){
		startDate = ManageDate.StringToDate(dateString);
	}
	
	long matchTypeId = ParamUtil.getLong(request, "matchType");
	String code = ParamUtil.getString(request, "code");
	long assotiationName = ParamUtil.getLong(request, "assotiationName");
	boolean returned = ParamUtil.getBoolean(request, "returned");
	List<ESFMatchType> esfMatchType = 
					ESFMatchTypeLocalServiceUtil.findAllByNational(isNational);
	
	List <ESFOrganization> temp = 
	ESFOrganizationLocalServiceUtil.getESFOrganizations(
		com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
		com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	
	List<ESFOrganization>esfOrganizations=new ArrayList<ESFOrganization>();
	for(ESFOrganization org: temp)
		if(org.getType()==ESFKeys.ESFOrganizationTypeId.ASSOCIATION)
			esfOrganizations.add(org);
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

		<liferay-ui:success key="user-success-insertupdate"
			message="user-success-insertupdate-mess" />
		<liferay-ui:error key="date-message" message="date-message" />
		<liferay-ui:error key="match-success-insertupdate"
			message="match-success-insertupdate" />
		
		<aui:button-row cssClass="esfmatch-admin-buttons">
		
			<c:if test="<%= ESFNormalMatchModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFNORMALMATCH_ADD) %>">	
				<portlet:renderURL var="addEsfMatchURL">
					<portlet:param name="mvcPath" value='<%=templatePath + "new_edit_esfMatch.jsp"%>' />
					<portlet:param name="op" value="addAddr" />
				</portlet:renderURL>
				<aui:button onClick="<%= addEsfMatchURL.toString() %>" value="add-match" />
			</c:if>
			
			<c:if test="<%= returned %>">	
				<portlet:renderURL var="returnURL">
					<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp" %>' />
				</portlet:renderURL>
				<aui:button onClick="<%= returnURL.toString() %>" value="go-back" />	
			</c:if>
</aui:button-row>

<aui:form action="<%=searchURL%>" method="get">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input name="returned" value="<%=true%>" type="hidden"/>
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
			
			<%
			if(Validator.isNull(currentESFOrganization)) {%>
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
			<% }%>
			
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>


		<liferay-ui:search-container emptyResultsMessage="no-results">

			<%
			List<ESFMatch> matchs = new ArrayList<ESFMatch>();
			List<ESFMatch> matchsT = new ArrayList<ESFMatch>();
			
			if(Validator.isNotNull(currentESFOrganization) && currentESFOrganization.getType()==3) {
				
				matchs = ESFMatchLocalServiceUtil.
						findESFMatchsByStateIsNational_C_S_M_C_I(ESFKeys.ESFStateType.ENABLE,
								isNational, code, startDate, matchTypeId, currentOrganizationId);
				
				matchsT = ESFMatchLocalServiceUtil.
						findESFMatchsByStateIsNational_C_S_M_C_A(ESFKeys.ESFStateType.ENABLE,
								isNational, code, startDate, matchTypeId, currentOrganizationId,
								searchContainer.getStart(), searchContainer.getEnd());
			
			}else{
								
				matchs = ESFMatchLocalServiceUtil.
						findESFMatchsByStateIsNational_C_S_M_C_A(ESFKeys.ESFStateType.ENABLE,
								isNational, code, startDate, matchTypeId, assotiationName);
				
				matchsT = ESFMatchLocalServiceUtil.
								findESFMatchsByStateIsNational_C_S_M_C_A(ESFKeys.ESFStateType.ENABLE,
										isNational, code, startDate, matchTypeId, assotiationName,
										searchContainer.getStart(), searchContainer.getEnd());
			}
			
			%>
			<liferay-ui:search-container-results
				results="<%= matchsT%>"
				total="<%=matchs.size()%>" />
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">

				<%
					SimpleDateFormat sdf =
						new SimpleDateFormat("dd/MM/yyyy");
				%>

				<liferay-ui:search-container-column-text name="code"
					value="<%=Validator.isNotNull(esfMatch.getCode())
								? esfMatch.getCode() : StringPool.BLANK%>" />

				<liferay-ui:search-container-column-text name="start-date"
					value="<%=sdf.format(esfMatch.getStartDate())%>" />
					
				<liferay-ui:search-container-column-text name="end-date"
					value="<%=sdf.format(esfMatch.getEndDate())%>" />
					
					
				<liferay-ui:search-container-column-text name="match-type"
					value='<%=esfMatch.getEsfMatchTypeId() != 0
								? ESFMatchTypeLocalServiceUtil.fetchESFMatchType(
									esfMatch.getEsfMatchTypeId()).getName()
								: ""%>' />	
				<%
				String description = "";
				if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getDescription()) && (esfMatch.getDescription() != 0)){
					description = ESFDescriptionLocalServiceUtil.fetchESFDescription(
								esfMatch.getDescription()).getName();
				}
					
				%>
				<liferay-ui:search-container-column-text name="description"
					value='<%= description%>' />
					
					
				<liferay-ui:search-container-column-text name="speciality"
					value='<%=esfMatch.getEsfSportTypeId() != 0
								? ESFSportTypeLocalServiceUtil.getESFSportType(
									esfMatch.getEsfSportTypeId()).getName()
								: ""%>' />
				<%
				String category = "";
				if(Validator.isNotNull(esfMatch.getEsfMatchId())){
				List<ESFShooterCategory> shooterCategorys = ESFShooterCategoryLocalServiceUtil.findByMatchId(esfMatch.getEsfMatchId());
				List<String> cats = new ArrayList<String>();
					if(Validator.isNotNull(shooterCategorys) && shooterCategorys.size()>0){
						for(int i = 0; i < shooterCategorys.size(); i++){
							cats.add(i,shooterCategorys.get(i).getName());
						}
					}
					if(Validator.isNotNull(cats) && cats.size()>0){
						for(int i = 0; i < cats.size(); i++){
								category = category + "-"+cats.get(i) + "-";
						}
					}
					if(category.length()-1>0){
					category = category.substring(1, category.length()-1);
					}
				}
				%>
				<liferay-ui:search-container-column-text name="Category"
					value='<%=category%>' />

				<liferay-ui:search-container-column-text
					name="sport-assocition-place"
					value='<%=esfMatch.getEsfAssociationId() != 0
								? ESFOrganizationLocalServiceUtil.fetchESFOrganization(
									esfMatch.getEsfAssociationId()).getName()
								: ""%>' />

				<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatch.getEsfMatchId(), ActionKeys.ESFNORMALMATCH_VIEW_ACTION) %>">	
				
					<liferay-ui:search-container-column-jsp
						path='<%=templatePath + "esfMatch_actions.jsp"%>' align="right" />
				</c:if>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
