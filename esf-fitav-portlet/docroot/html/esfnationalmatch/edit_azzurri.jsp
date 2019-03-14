<%@include file="init.jsp"%>

<portlet:renderURL var="tabURL" />

<liferay-ui:error key="errorDeleteDelegation" message="errorDeleteDelegation" />
<liferay-ui:error key="errorDeleteDelegationImpl" message="errorDeleteDelegationImpl" />

<%

String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
String className = (String)request.getAttribute("phones.className");
String phoneNumber = "";
String orgName = "Errore Società";
String specialitys = "";
String qualification = "";
String shooterName = "";
String shooterLastName = "";
String sport1="";
String sport2="";
String sport3="";

int urlEndIndex = currentUrlPage.indexOf('?');
long esfMatchId = ParamUtil.getLong(request, "esfMatchId",0);
long sportTypeId = 0;
long qualificationId = 0;

request.setAttribute( "phones.className", ESFUser.class.getName());

List<Phone> phones = new ArrayList<Phone>();
List<ESFSportType> sports = new ArrayList<ESFSportType>();
List<Long> idSport = new ArrayList<Long>();

if(urlEndIndex != -1){
	backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
}

portletDisplay.setURLBack(backtoViewUrl);
PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter( "mvcPath",templatePath + "edit_azzurri.jsp");
viewassURL.setParameter( "organizationId", String.valueOf(currentOrganizationId));
viewassURL.setWindowState(WindowState.NORMAL);
viewassURL.setParameter("esfMatchId", String.valueOf(esfMatchId));

sports = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

for(ESFSportType sport : sports){
	if(sport.getIsOlimpic()){
		idSport.add(sport.getEsfSportTypeId());
	}
	
}

if(Validator.isNotNull(idSport) && idSport.size()>=3){
	
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(0))) &&
			Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(0)).getName())){
		sport1 = ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(0)).getName();
	}
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(1))) &&
			Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(1)).getName())){
		sport2 = ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(1)).getName();
	}
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(2))) &&
			Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(2)).getName())){
		sport3 = ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport.get(2)).getName();
	}

}

portletSession.setAttribute("esfMatchId", esfMatchId);

String matchCode = "";
if(Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId))){
	ESFMatch thisMatch =  ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
	
	if(Validator.isNotNull(thisMatch.getCode())){
		matchCode = thisMatch.getCode();
	}
}

%>

		<liferay-ui:error key="date-match-message" message="date-match-message" />

		<b><liferay-ui:message key="azzurri-partecipant-assegn" /><%=matchCode %> </b>
		<br></br>
		<div class="panel">

		<liferay-ui:search-container emptyResultsMessage="no-results" curParam="AllShooterPartecipants"
				iteratorURL="<%=viewassURL%>">
				
				<liferay-ui:search-container-results >
				<% 
				List<ESFNationalDelegation> shooter = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);
				int tot = shooter.size();
				
				
				if(searchContainer.getEnd() <= tot){
					shooter = shooter.subList(searchContainer.getStart(), searchContainer.getEnd());
				}else{
					shooter = shooter.subList(searchContainer.getStart(), tot);
				}
				
				
				pageContext.setAttribute("results", shooter);
				pageContext.setAttribute("total", tot);
				%>
				
				</liferay-ui:search-container-results>
				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFNationalDelegation" modelVar="esfShooter">
<%


ESFUser esfUser = ESFUserLocalServiceUtil.fetchESFUser(esfShooter.getEsfUserId());
if(Validator.isNotNull(esfUser)){
	if(Validator.isNotNull(esfUser.getFirstName())){
		shooterName = esfUser.getFirstName();
	}
	if(Validator.isNotNull(esfUser.getLastName())){
		shooterLastName = esfUser.getLastName();
	}
}

List<ESFCard> userCards = ESFCardLocalServiceUtil.findActualUserCards(esfUser.getEsfUserId());

phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, esfUser.getEsfUserId());

if(0 < phones.size() && Validator.isNotNull(phones.get(0).getNumber())){
	phoneNumber = phones.get(0).getNumber();
}

sportTypeId = esfShooter.getEsfSportTypeId();
qualificationId = esfShooter.getEsfShooterQualificationId();

if(0 < sportTypeId && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(sportTypeId)) && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(sportTypeId).getName())){
	specialitys = ESFSportTypeLocalServiceUtil.fetchESFSportType(sportTypeId).getName();
}

if(0 < qualificationId && Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qualificationId)) && Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qualificationId).getName())){
	qualification = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qualificationId).getName();
}

if( Validator.isNotNull(userCards) && 1 == userCards.size() && Validator.isNotNull(userCards.get(0))){
	
	if(Validator.isNotNull(userCards.get(0).getEsfOrganizationId()) && Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCards.get(0).getEsfOrganizationId())) &&
			Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCards.get(0).getEsfOrganizationId()).getName())){
		orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCards.get(0).getEsfOrganizationId()).getName();
	}
}

%>
					<liferay-ui:search-container-column-text value="<%=shooterName %>" name="last-name" />
						
					<liferay-ui:search-container-column-text value="<%=shooterLastName %>" name="first-name" />
						
					<liferay-ui:search-container-column-text name="user-email">
		
							<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text value="<%=phoneNumber %>" name="phones" />

					<liferay-ui:search-container-column-text value="<%=orgName %>" name="organization-code" />
					
					<liferay-ui:search-container-column-text value="<%=specialitys %>" name="speciality" />
					
					<liferay-ui:search-container-column-text value="<%=qualification %>" name="qualification" />

					<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_DELETE) %>">	

						<liferay-ui:search-container-column-jsp
							path='<%=templatePath + "esfAzzurriSelected_actions.jsp"%>' align="right" />
					
					</c:if>
					</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
<%
String tabs = "";

tabs = sport1+ "," + sport2 + "," + sport3;

String tabValue = ParamUtil.getString(request, "myParam", sport1);

%>

<liferay-ui:tabs names='<%=tabs %>' url="<%=tabURL.toString()%>"  tabsValues='<%=tabs %>' param="myParam" refresh="false">

	<liferay-ui:section>
	 	<jsp:include page="tabsAzzurri/tab1.jsp" flush="<%= false %>" />
	</liferay-ui:section>
	<liferay-ui:section>
		 <jsp:include page="tabsAzzurri/tab2.jsp" flush="<%= false %>" />
	</liferay-ui:section>
	<liferay-ui:section>
	 	<jsp:include page="tabsAzzurri/tab3.jsp" flush="<%= false %>" />
	</liferay-ui:section>
 
</liferay-ui:tabs>

<br>
<br>
<portlet:renderURL var="backURL" windowState="<%=WindowState.NORMAL.toString()%>">
		<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
</portlet:renderURL>
<aui:button onClick="<%= backURL.toString() %>" value="go-back" />


