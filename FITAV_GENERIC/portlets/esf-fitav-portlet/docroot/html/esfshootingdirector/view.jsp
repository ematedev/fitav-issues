<%@include file="init.jsp"%>

<%
List<ESFRegion> regions = new ArrayList<ESFRegion>();
List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
List<ESFSportType> sportTypes = new ArrayList<ESFSportType>();

regions = ESFRegionLocalServiceUtil.getESFRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

%>
<liferay-ui:error key="error-delete-shDr" message="error-delete-shDr" />
<liferay-ui:error key="error-deleteSospensive" message="error-deleteSospensive" />
<liferay-ui:error key="error-updateSuspensive" message="error-updateSuspensive" />


	<aui:button-row cssClass="esfshooter-admin-buttons">
		<portlet:renderURL var="newShootingDirectorURL">
			<portlet:param name="mvcPath" value='<%=templatePath + "newShootingDirector.jsp"%>' />
		</portlet:renderURL>

	<aui:button onClick="<%= newShootingDirectorURL.toString() %>" value="add-shDirector" />
	</aui:button-row>
	
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "viewSearch.jsp"%>' />
</liferay-portlet:renderURL>
	
<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		<div class="search-form">
			<span class="aui-search-bar">
				<aui:input inlineField="<%=true%>" label="lastName" name="lastname"
					placeholder="last-name" size="30" title="search-entries" type="text" />
				<aui:input inlineField="<%=true%>" label="firstName" name="firstname"
					placeholder="first-name" size="30" title="search-entries" type="text" />
				<aui:input inlineField="<%=true%>" label="card" name="card" 
					placeholder="card" size="30" title="search-entries" type="text" />
				<aui:select  name="regionId" inlineField="<%=true%>" label="regions">
					<aui:option value="0"  label="-"></aui:option>
				<%for(ESFRegion r : regions){ %>
					<aui:option value="<%=r.getIdRegion()%>"  label="<%=r.getName()%>"></aui:option>
				<%}%>
				</aui:select>
				<aui:select  name="shDtId" inlineField="<%=true%>" label="qualification" >
					<aui:option value="0"  label="-"></aui:option>
				<%for(ESFShootingDirectorQualification s : shDts){%>
					<aui:option value="<%=s.getEsfShootingDirectorQualificationId()%>"  label="<%=s.getEsfShootingDirectorQualificationDesc()%>"></aui:option>
				<%}%>
				</aui:select>
				<aui:select  name="stId" inlineField="<%=true%>" label="sport-type" >
					<aui:option value="0"  label="-"></aui:option>
				<%for(ESFSportType st : sportTypes){%>
					<aui:option value="<%=st.getEsfSportTypeId()%>"  label="<%=st.getName()%>"></aui:option>
				<%} %>
				</aui:select>
				
	<aui:button type="submit" value="search" />
			</span>
		</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result" >
	<liferay-ui:search-container-results
		results = "<%=ESFShootingDirectorLocalServiceUtil.findAll(searchContainer.getStart(), searchContainer.getEnd())%>"
		total= "<%=ESFShootingDirectorLocalServiceUtil.countTotal() %>" />

		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFShootingDirector" modelVar="shDt">
		
		<%
			ESFUser shDtInfo = new ESFUserImpl();
			ESFCard userCard= null;
			List<ESFCard> cardstest = new ArrayList<ESFCard>();
			String name = "";
			String cardCode = "";
			String qualification ="";
			String stName= "";
			
			if(Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()))){
				name = ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getFirstName();
				
				name = name + " " + ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getLastName();
				
				try{
					cardstest = ESFCardLocalServiceUtil.findActualUserCards(shDt.getEsfUserId());
					
					if(Validator.isNotNull(cardstest) && 0 < cardstest.size()){
						cardCode = cardstest.get(0).getCode();
					}
					
				}
				catch(Exception e){
					
				}
			}
			
			if(Validator.isNotNull(ESFShootingDirectorQualificationLocalServiceUtil.fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()))){
				qualification = ESFShootingDirectorQualificationLocalServiceUtil.
						fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()).getEsfShootingDirectorQualificationDesc();
			}
			
			if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()))){
				stName = ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()).getName();
			}
		%>
		
		<liferay-ui:search-container-column-text name="name" value="<%=name %>" />
		<liferay-ui:search-container-column-text name="card" value="<%=cardCode %>"/>
		<liferay-ui:search-container-column-text name="region-code" value="<%=shDt.getRegionId() %>" />
		<liferay-ui:search-container-column-text name="qualification" value="<%=qualification %>" />
		<liferay-ui:search-container-column-text name="sport-type" value="<%=stName %>" />
		<liferay-ui:search-container-column-text name="esf-date-assign" value="<%=sdf.format(shDt.getEsfStartData()) %>" />
		<liferay-ui:search-container-column-jsp
				path='<%=templatePath + "modifyShDrAction.jsp"%>' align="right" />

		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
