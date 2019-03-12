<%@page import="java.util.Hashtable"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>

<%@include file="../init.jsp"%>

<%
long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
String sortingOrder = orderByType;
String phoneNumber = "";
String className = (String)request.getAttribute("phones.className");
String orgName = "Errore Società";

List<ESFUser> esfUsers =  ESFUserLocalServiceUtil. findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);
List<ESFShooterQualification> esfShooterQualificationsESFMatch = ESFShooterQualificationLocalServiceUtil.findByMatchId(esfMatchId);
List<Phone> phones = new ArrayList<Phone>();
List<ESFSportType> sports = new ArrayList<ESFSportType>();
List<Long> idSport = new ArrayList<Long>();

sports = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

request.setAttribute( "phones.className", ESFUser.class.getName());
portletSession.setAttribute("esfMatchId", esfMatchId);



PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter( "mvcPath",templatePath + "edit_azzurri.jsp");
viewassURL.setParameter( "organizationId", String.valueOf(currentOrganizationId));
viewassURL.setParameter( "esfMatchId",String.valueOf(esfMatchId));
viewassURL.setWindowState(WindowState.NORMAL);

for(ESFSportType sport : sports){
	if(sport.getIsOlimpic()){
		idSport.add(sport.getEsfSportTypeId());
	}
	
}

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
	<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=viewassURL %>" curParam="AllShooters" delta="75">

			<liferay-ui:search-container-results >
<%

List<ESFNational> shootersTab2 = ESFNationalLocalServiceUtil.findNationalFreeMatchIdSportId(esfMatchId, idSport.get(1), searchContainer.getStart(),searchContainer.getEnd());
int totTab2 = ESFNationalLocalServiceUtil.findNationalFreeMatchIdSportId(esfMatchId, idSport.get(1), 0, Integer.MAX_VALUE).size();

List<ESFNational> shootersOrdTab2 = new ArrayList<ESFNational>(shootersTab2);

if (Validator.isNotNull(orderByCol)) {
	BeanComparator beanComparator = new BeanComparator(orderByCol);
	
	Collections.sort(shootersOrdTab2,beanComparator);
	
	if (sortingOrder.equalsIgnoreCase("desc")) {
	
		Collections.reverse(shootersOrdTab2);
	}
}

pageContext.setAttribute("results", shootersOrdTab2);
pageContext.setAttribute("total", totTab2);

%>
			</liferay-ui:search-container-results>
		
			<liferay-ui:search-container-row className="it.ethica.esf.model.ESFNational" modelVar="esfNational">
			
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
						<aui:input name="sportTypeId" value="<%=String.valueOf(idSport.get(1)) %>" type="hidden"></aui:input>
						<div class="btn-field-align">
							<aui:select name = "esfShooterQualificationIds" showEmptyOption="false" inlineField="true">
							<%for(ESFShooterQualification sq : esfShooterQualificationsESFMatch){ %>
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