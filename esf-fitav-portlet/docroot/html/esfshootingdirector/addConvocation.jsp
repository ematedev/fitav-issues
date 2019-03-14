<%@page import="it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFNationalDelegationImpl"%>
<%@page import="it.ethica.esf.model.ESFNationalDelegation"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterCategory"%>
<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFMatchImpl"%>
<%@page import="it.ethica.esf.model.ESFMatch"%>
<%@page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp"%>

<%
long directorId = ParamUtil.getLong(request, "directorId");
String matchCode = ParamUtil.getString(request, "matchCode");
ESFUser shDr = new ESFUserImpl();

String shDrName = "";

shDr = ESFUserLocalServiceUtil.fetchESFUser(directorId);

if(Validator.isNotNull(shDr)){
	shDrName = shDr.getFirstName() + " " + shDr.getLastName();
	
}

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath",  "/html/esfshooteingdirector/addConvocation.jsp");
viewassURL.setParameter("matchCode", matchCode);


%>

<h3><liferay-ui:message key="infromation-shDR-x" arguments="<%=shDrName %>" /></h3>
<br>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "addConvocation.jsp"%>' />
</liferay-portlet:renderURL>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
	<portlet:param name="esfUserId" value="<%=String.valueOf(directorId)%>" />
</portlet:renderURL>

<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>

<portlet:actionURL name="addShootingDirectorToMatch" var="addShootingDirectorToMatchURL">
	<portlet:param name="esfUserId"
		value="<%=String.valueOf(directorId)%>" /> 
</portlet:actionURL> 

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		<div class="search-form">
			<span class="aui-search-bar">
				<aui:input inlineField="<%=true%>" label="matchCode" name="matchCode"
					placeholder="matchCode" size="30" title="search-entries" type="text" />
				<aui:button type="submit" value="search" />
			</span>
		
		</div>

</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result" >
	<liferay-ui:search-container-results
		results = "<%=ESFMatchLocalServiceUtil.findMatchToDispute( matchCode, false, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total= "<%=ESFMatchLocalServiceUtil.countMatchToDispute(matchCode, false)%>" />
		
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">
				
			<%
			boolean find = false;
			find = ESFNationalDelegationLocalServiceUtil.findConvocation(esfMatch.getEsfMatchId(), directorId, ESFKeys.ESFNationalDelegationType.REFEREE);
			%>
			
				<liferay-ui:search-container-column-text name="code"
					value="<%=Validator.isNotNull(esfMatch.getCode()) ? esfMatch.getCode() : StringPool.BLANK%>" />

				<liferay-ui:search-container-column-text name="start-date" value="<%=sdf.format(esfMatch.getStartDate())%>" />
					
				<liferay-ui:search-container-column-text name="end-date" value="<%=sdf.format(esfMatch.getEndDate())%>" />
					
				<liferay-ui:search-container-column-text name="match-type"
					value='<%=esfMatch.getEsfMatchTypeId() != 0 ? ESFMatchTypeLocalServiceUtil.fetchESFMatchType(
									esfMatch.getEsfMatchTypeId()).getName() : ""%>' />	
				<%
				String description = "";
				if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getDescription()) && (esfMatch.getDescription() != 0)){
					description = ESFDescriptionLocalServiceUtil.fetchESFDescription(
								esfMatch.getDescription()).getName();
				}
					
				%>
				<liferay-ui:search-container-column-text name="description"
					value='<%= description%>' />
					
					
				<liferay-ui:search-container-column-text name="speciality" value='<%=esfMatch.getEsfSportTypeId() != 0
								? ESFSportTypeLocalServiceUtil.getESFSportType( esfMatch.getEsfSportTypeId()).getName() : ""%>' />
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
				<liferay-ui:search-container-column-text name="Category" value='<%=category%>' />

				<liferay-ui:search-container-column-text
					name="sport-assocition-place" value='<%=esfMatch.getEsfAssociationId() != 0
								? ESFOrganizationLocalServiceUtil.fetchESFOrganization( esfMatch.getEsfAssociationId()).getName() : ""%>' />
				
				<liferay-ui:search-container-column-text name="summon" value='<%=find? res.getString("yes")  :res.getString("no")%>' />
				
				<liferay-ui:search-container-column-text name = "add-shDirector" >
					<aui:form action = "<%=addShootingDirectorToMatchURL%>">	
						<div class="btn-field-align">
						
							<aui:input name="esfPartecipantTypeId" value="<%=ESFKeys.ESFNationalDelegationType.REFEREE %>" type="hidden"></aui:input>
							<aui:input name="esfMatchId" value="<%=String.valueOf(esfMatch.getEsfMatchId()) %>" type="hidden"></aui:input>
							
							<aui:button type = "submit" value = "add" align="right" ></aui:button>
						</div>	
					</aui:form>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>