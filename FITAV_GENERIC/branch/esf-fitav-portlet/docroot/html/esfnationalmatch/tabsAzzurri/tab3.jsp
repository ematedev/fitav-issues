<%@page import="java.util.Hashtable"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>

<%@include file="../init.jsp"%>

<%

PortletURL viewassURL = renderResponse.createRenderURL();
long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
viewassURL.setParameter(
	"mvcPath",templatePath + "edit_azzurri.jsp");
viewassURL.setParameter(
	"organizationId", String.valueOf(currentOrganizationId));
viewassURL.setWindowState(WindowState.NORMAL);

List<ESFUser> esfUsers = 
ESFUserLocalServiceUtil.
	findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
			esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);

portletSession.setAttribute("esfMatchId", esfMatchId);

List<ESFCard> cards =
ESFCardLocalServiceUtil.findAllESFCardsByState(ESFKeys.ESFStateType.ENABLE);
Hashtable<Long, ESFCard> allEsfCards =
new Hashtable<Long, ESFCard>();
for (ESFCard card : cards) {
allEsfCards.put(card.getEsfUserId(), card);
}

List<ESFSportType> sports = new ArrayList<ESFSportType>();
List<Long> idSport = new ArrayList<Long>();

sports = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

for(ESFSportType sport : sports){
	if(sport.getIsOlimpic()){
		idSport.add(sport.getEsfSportTypeId());
	}
	
}
%>

<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=viewassURL %>" curParam="AllShooters">

			<liferay-ui:search-container-results
				results="<%= ESFNationalLocalServiceUtil.findNationalbySportId_MatchId(idSport.get(2), esfMatchId,
						searchContainer.getStart(),searchContainer.getEnd())%>"
				total="<%= ESFNationalLocalServiceUtil.countNationalbySportId_MatchId(idSport.get(2), esfMatchId)%>" />
		
			<liferay-ui:search-container-row className="it.ethica.esf.model.ESFNational" modelVar="esfNational">
			
		<%
				
			ESFUser esfUser = ESFUserLocalServiceUtil.fetchESFUser(esfNational.getEsfUserId());
		
		
			request.setAttribute( "phones.className", ESFUser.class.getName());
			String className = (String)request.getAttribute("phones.className");
			
			List<Phone> phones = new ArrayList<Phone>();
			String phoneNumber = "";
			
			phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, esfUser.getEsfUserId());
			
			if(0 < phones.size() && Validator.isNotNull(phones.get(0).getNumber())){
				phoneNumber = phones.get(0).getNumber();
			}
			String orgName = "";

			if( Validator.isNotNull(allEsfCards) &&  Validator.isNotNull(esfUser.getEsfUserId())  && Validator.isNotNull(allEsfCards.get(esfUser.getEsfUserId())) &&
					Validator.isNotNull(allEsfCards.get(esfUser.getEsfUserId()).getEsfOrganizationId()) && Validator.isNotNull(allEsfCards.get(esfUser.getEsfUserId()).getCode())){
				orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(
						allEsfCards.get(esfUser.getEsfUserId()).getEsfOrganizationId()).getName();
			}
		%>		
				
				
				<liferay-ui:search-container-column-text value="<%=esfNational.getUserName() %>" name="first-name" />

				<liferay-ui:search-container-column-text name="user-email">
		
						<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text value="<%=phoneNumber %>" name="phones" />

				<liferay-ui:search-container-column-text value="<%=orgName %>" name="organization-code" />
				
				<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">	
				
					<liferay-ui:search-container-column-jsp path='<%=templatePath+"esfAzzurri_actions.jsp"%>' align="right" />
				
				</c:if>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>