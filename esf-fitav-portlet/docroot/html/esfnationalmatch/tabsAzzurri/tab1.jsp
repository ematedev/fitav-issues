<%@include file="../init.jsp"%>

<%
long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
String sortingOrder = orderByType;
String orgName = "Errore Società";
String phoneNumber = "";
String className = (String)request.getAttribute("phones.className");

List<ESFSportType> sports = new ArrayList<ESFSportType>();
List<Long> idSport = new ArrayList<Long>();
List<Phone> phones = new ArrayList<Phone>();
List<ESFShooterQualification> esfShooterQualificationsESFMatch = ESFShooterQualificationLocalServiceUtil.findByMatchId(esfMatchId);
List<ESFUser> esfUsers =  ESFUserLocalServiceUtil. findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);
sports = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

request.setAttribute( "phones.className", ESFUser.class.getName());
portletSession.setAttribute("esfMatchId", esfMatchId);

for(ESFSportType sport : sports){
	if(sport.getIsOlimpic()){
		idSport.add(sport.getEsfSportTypeId());
	}
	
}

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter( "mvcPath",templatePath + "edit_azzurri.jsp");
viewassURL.setParameter( "organizationId", String.valueOf(currentOrganizationId));
viewassURL.setParameter( "esfMatchId",String.valueOf(esfMatchId));
viewassURL.setWindowState(WindowState.NORMAL);

if (orderByType.equals("desc")) {
	orderByType = "asc";
} else {
	orderByType = "desc";
}

if (Validator.isNull(orderByType)) {
	orderByType = "desc";
}

%>

<portlet:actionURL name="addESFNationalDelegation" var="addESFNationalDelegationURL">

</portlet:actionURL>

<div class="search-container-medium-height">
	<liferay-ui:search-container  emptyResultsMessage="no-results" iteratorURL="<%=viewassURL %>" curParam="AllShooters" delta="75" id="tab1" >

			<liferay-ui:search-container-results >
<%
/*List<ESFNational> shootersTab1 = ESFNationalLocalServiceUtil.findNationalbySportId_MatchId(idSport.get(0), esfMatchId,
		searchContainer.getStart(),searchContainer.getEnd());
int totTab1 = ESFNationalLocalServiceUtil.countNationalbySportId_MatchId(idSport.get(0), esfMatchId);*/

List<ESFNational> shootersTab1 = ESFNationalLocalServiceUtil.findNationalFreeMatchIdSportId(esfMatchId, idSport.get(0), searchContainer.getStart(),searchContainer.getEnd());
int totTab1 = ESFNationalLocalServiceUtil.findNationalFreeMatchIdSportId(esfMatchId, idSport.get(0), 0, Integer.MAX_VALUE).size();

List<ESFNational> shootersOrdTab1 = new ArrayList<ESFNational>(shootersTab1);

if (Validator.isNotNull(orderByCol)) {
	BeanComparator beanComparator = new BeanComparator(orderByCol);
	
	Collections.sort(shootersOrdTab1,beanComparator);
	
	if (sortingOrder.equalsIgnoreCase("desc")) {
	
		Collections.reverse(shootersOrdTab1);
	}
}

pageContext.setAttribute("results", shootersOrdTab1);
pageContext.setAttribute("total", totTab1);

%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="it.ethica.esf.model.ESFNational" modelVar="esfNational" >
			
		<%
				
			ESFUser esfUser = ESFUserLocalServiceUtil.fetchESFUser(esfNational.getEsfUserId());
			List<ESFCard> userCards = ESFCardLocalServiceUtil.findActualUserCards(esfNational.getEsfUserId());
			
			phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, esfUser.getEsfUserId());
			
			if(0 < phones.size() && Validator.isNotNull(phones.get(0).getNumber())){
				phoneNumber = phones.get(0).getNumber();
			}
			
			if( Validator.isNotNull(userCards) && 1 == userCards.size() && Validator.isNotNull(userCards.get(0))){
				
				if(Validator.isNotNull(userCards.get(0).getEsfOrganizationId()) && Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCards.get(0).getEsfOrganizationId())) &&
						Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCards.get(0).getEsfOrganizationId()).getName())){
					orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCards.get(0).getEsfOrganizationId()).getName();
				}
			}
			
		%>		
				
				<liferay-ui:search-container-column-text value="<%=esfNational.getUserName() %>" name="first-name" orderable="true" orderableProperty="userName"/>

				<liferay-ui:search-container-column-text name="user-email">
		
						<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text value="<%=phoneNumber %>" name="phones" />

				<liferay-ui:search-container-column-text value="<%=orgName %>" name="organization-code" />

				<liferay-ui:search-container-column-text name = "shooter-qualification" >
					<aui:form action = "<%=addESFNationalDelegationURL%>">
						<aui:input name="esfPartecipantTypeId" value="<%=String.valueOf(ESFKeys.ESFNationalDelegationType.SHOOTER) %>" type="hidden"></aui:input>
						<aui:input name="esfUserId" value="<%=esfNational.getEsfUserId() %>" type="hidden"></aui:input>
						<aui:input name="isAzzurro" value="<%=String.valueOf(true) %>" type="hidden"></aui:input>
						<aui:input name="esfMatchId" value="<%=String.valueOf(esfMatchId) %>" type="hidden"></aui:input>
						<aui:input name="sportTypeId" value="<%=String.valueOf(idSport.get(0)) %>" type="hidden"></aui:input>
						<div class="btn-field-align">
							<aui:select name = "esfShooterQualificationIds" showEmptyOption="false" inlineField="true">
							<%
							for(ESFShooterQualification sq : esfShooterQualificationsESFMatch){ %>
								<aui:option value = "<%=sq.getEsfShooterQualificationId() %>" label = "<%=sq.getName() %>"></aui:option>
							<%} %>
							</aui:select>
							<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">
								<aui:button type = "submit" value = "add" align="right" ></aui:button>
							</c:if>
						</div>
					</aui:form>
				</liferay-ui:search-container-column-text>
		
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

