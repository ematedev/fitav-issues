<%@include file="init.jsp"%>

<portlet:renderURL var="tabURL" />

<%

String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
int urlEndIndex = currentUrlPage.indexOf('?');
String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();

long esfMatchId = ParamUtil.getLong(request, "esfMatchId",0);

if(urlEndIndex != -1){
	backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
}
portletDisplay.setURLBack(backtoViewUrl);


PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath",templatePath + "edit_azzurri.jsp");
viewassURL.setParameter(
	"organizationId", String.valueOf(currentOrganizationId));
viewassURL.setWindowState(WindowState.NORMAL);

List<ESFUser> esfUsers = 
			ESFUserLocalServiceUtil.
				findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
						esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);

int totalShooterPartecipant =esfUsers.size();

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
				
				<liferay-ui:search-container-results
					results="<%= ESFUserLocalServiceUtil.
									findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
										esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER,searchContainer.getStart(),searchContainer.getEnd()) %>"
					total="<%= totalShooterPartecipant %>" />
				
				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
<%
request.setAttribute( "phones.className", ESFUser.class.getName());
String className = (String)request.getAttribute("phones.className");

List<Phone> phones = new ArrayList<Phone>();
String phoneNumber = "";

phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, esfUser.getEsfUserId());

if(0 < phones.size() && Validator.isNotNull(phones.get(0).getNumber())){
	phoneNumber = phones.get(0).getNumber();
}

String orgName = "";
String specialitys = "";


List<ESFNationalDelegation> delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(esfUser.getEsfUserId(), esfMatchId);

for(ESFNationalDelegation del : delegations){
	if(del.getEsfPartecipantTypeId() == ESFKeys.ESFNationalDelegationType.SHOOTER){
		long s=del.getEsfSportTypeId();
		if(s > 0){
			ESFSportType esfSportType=ESFSportTypeLocalServiceUtil.fetchESFSportType(s);
			
			if(Validator.isNotNull(esfSportType) && Validator.isNotNull(esfSportType.getName())){
			
				String speciality = ESFSportTypeLocalServiceUtil.fetchESFSportType(s).getName();
				specialitys += "-"+ speciality ;
			}
		}
	}
	
}

if(Validator.isNotNull(specialitys)){
	specialitys = specialitys.substring(1).trim();
}
%>
					<liferay-ui:search-container-column-text property="lastName"
						name="last-name" />
						
					<liferay-ui:search-container-column-text property="firstName"
						name="first-name" />
						
					<liferay-ui:search-container-column-text name="user-email">
		
							<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text value="<%=phoneNumber %>" name="phones" />

					<liferay-ui:search-container-column-text value="<%=orgName %>" name="organization-code" />
					
					<liferay-ui:search-container-column-text value="<%=specialitys %>" name="speciality" />

					<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_DELETE) %>">	

						<liferay-ui:search-container-column-jsp
							path='<%=templatePath + "esfAzzurriSelected_actions.jsp"%>' align="right" />

						</liferay-ui:search-container-row>
					
					</c:if>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>

<%

List<ESFSportType> sports = new ArrayList<ESFSportType>();
List<Long> idSport = new ArrayList<Long>();
String sport1="";
String sport2="";
String sport3="";

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

String tabs = "";

tabs = sport1+ "," + sport2 + "," + sport3;

String tabValue = ParamUtil.getString(request, "myParam", sport1);

%>

<liferay-ui:tabs names='<%=tabs %>' url="<%=tabURL.toString()%>"  tabsValues='<%=tabs %>' param="myParam" refresh="false">

	<liferay-ui:section>
	 	<jsp:include page="tabsAzzurri/tab1.jsp" flush="true" />
	</liferay-ui:section>
	<liferay-ui:section>
		 <jsp:include page="tabsAzzurri/tab2.jsp" flush="true" />
	</liferay-ui:section>
	<liferay-ui:section>
	 	<jsp:include page="tabsAzzurri/tab3.jsp" flush="true" />
	</liferay-ui:section>
 
</liferay-ui:tabs>

<br>
<br>
<portlet:renderURL var="backURL" windowState="<%=WindowState.NORMAL.toString()%>">
		<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
</portlet:renderURL>
<aui:button onClick="<%= backURL.toString() %>" value="go-back" />


