<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.model.impl.ESFOrganizationImpl"%>
<%@ include file="init.jsp" %>

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

Calendar calendar = GregorianCalendar.getInstance();
int year = ParamUtil.getInteger(request, "selectedYear", calendar.get( Calendar.YEAR ));
String organizationName = "";
String orgCode = "";

String assCardYear = "assegna tessere anno:"+year;

long esfOrganizationId = group.getOrganizationId();
long esfUserId = themeDisplay.getUserId();

int totCards = ESFCardLocalServiceUtil.findAllFreeCardInt();

long esfOrganizationIdToFind = ParamUtil.getLong(request, "esfOrganizationIdToFind",0);
if(Validator.isNotNull(esfOrganizationIdToFind)){
	esfOrganizationId=esfOrganizationIdToFind;
}

long esfOrganizationType = ParamUtil.getLong(request, "esfOrganizationType",0);

if(0 < esfOrganizationIdToFind){
	if(Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationIdToFind)) && 
			Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationIdToFind).getName()) &&
			Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationIdToFind).getCode())){
		organizationName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationIdToFind).getName();
		orgCode = ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationIdToFind).getCode();
	}
	
	
	
}
String[] orgDetails ={organizationName,orgCode};
String[] cardYear ={String.valueOf(year)};
%>

<liferay-ui:success key="created-Card" message="created-Card" />
<liferay-ui:success key="esfcard-add-success" message="esfcard-add-success" />
<liferay-ui:success key="esfcard-partialadd-success" message="esfcard-partialadd-success" />
<liferay-ui:error key="numberCard-reference-error" message="numberCard-reference-error"/>
<liferay-ui:error key="format-alfa-card-reference-error" message="format-alfa-card-reference-error"/>
<liferay-ui:error key="format-num-card-reference-error" message="format-num-card-reference-error"/>
<liferay-ui:error key="begin-card-reference-error" message="begin-card-reference-error"/>
<liferay-ui:error key="error-find-ass" message="error-find-ass"/>


<c:if test="<%= 0 < esfOrganizationIdToFind %>">
	<h3><b><liferay-ui:message key="orgName-x-orgCode-x"  arguments="<%= orgDetails%>"/></b></h3>
	
</c:if>


<aui:button-row cssClass="esfcard-admin-buttons">

		<c:if test="<%= ESFCardModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFCARD_CREATE) %>">	
			<portlet:renderURL var="createESFCardURL">
				<portlet:param name="mvcPath" value= '<%= templatePath + "create_esfcard.jsp"%>' />
			</portlet:renderURL>
			<aui:button onClick="<%= createESFCardURL.toString() %>" value="add-multi-card" />
		</c:if>
		
		<c:if test="<%= ESFCardModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFCARD_ASSIGN) %>">	
			<portlet:renderURL var="assignESFCardURL">
				<portlet:param name="mvcPath" value= '<%= templatePath + "assign_esfcard.jsp"%>' />
				<portlet:param name="totCards" value= '<%= String.valueOf(totCards)%>' />
			</portlet:renderURL>
			<aui:button onClick="<%= assignESFCardURL.toString() %>" value="assign-cards"  />
		</c:if>
		
		<c:if test="<%= ESFCardModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFCARD_SELECT) %>">	
			<portlet:renderURL var="selectESFCardURL">
				<portlet:param name="mvcPath" value= '<%= templatePath + "selectcard.jsp"%>' />
				<portlet:param name="esfUserId" value= '<%= String.valueOf(esfUserId)%>' />
			</portlet:renderURL>
			<aui:button onClick="<%= selectESFCardURL.toString() %>" value='<%=assCardYear %>' />
		</c:if>
		
</aui:button-row>

<portlet:renderURL var="currentPageURL">
	<portlet:param name="mvcPath" value= '<%= templatePath + "view.jsp"%>' />
</portlet:renderURL>
<aui:form action="${currentPageURL}">
	<aui:input name="esfOrganizationType" value="<%= esfOrganizationType %>" disabled="true"></aui:input>
	<aui:input name="numTotCards" value="<%= totCards%>" disabled="true"></aui:input>
	<aui:input name="selectedYear" value="<%= year %>" label="selected-year"/>
	<aui:button type="submit" value="search" />
</aui:form>


<liferay-ui:search-container emptyResultsMessage="no-results">
		<liferay-ui:search-container-results>
		<%
		List<ESFOrganization> organizations = null;
		total = 0;
		List<ESFOrganization> organizationsTot = null;
		
		if(Validator.isNull(esfOrganizationType) || esfOrganizationType < ESFKeys.ESFOrganizationTypeId.PROVINCE){
			organizations = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(esfOrganizationId, ESFKeys.ESFStateType.ENABLE,
					searchContainer.getStart(), searchContainer.getEnd());
			organizationsTot = ESFOrganizationLocalServiceUtil.findAllChildOrganizations(esfOrganizationId, ESFKeys.ESFStateType.ENABLE);
			total = organizationsTot.size();
		}else{
			organizations = ESFOrganizationLocalServiceUtil.findByPaymentYear(year,
					searchContainer.getStart(), searchContainer.getEnd());
			
			total = ESFOrganizationLocalServiceUtil.countByPaymentYear(year);
		
		}
		pageContext.setAttribute("results", organizations);
		pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganization">
		<%
		int totRegionCards = ESFCardLocalServiceUtil.findAllESFCardsChildOrg(esfOrganization.getEsfOrganizationId());
		int freeRegionCards = ESFCardLocalServiceUtil.findAllESFCardsReg_Prov(esfOrganization.getEsfOrganizationId());
		%>
		
		<liferay-ui:search-container-column-text name="year" value="<%= String.valueOf(year) %>" />
		<liferay-ui:search-container-column-text property="code" />
		<liferay-ui:search-container-column-text property="name" />		
		<liferay-ui:search-container-column-text name="num-tot-cards" value="<%=String.valueOf(totRegionCards)  %>"/>
		<liferay-ui:search-container-column-text name="num-free-tot-cards" value="<%=String.valueOf(freeRegionCards)  %>"/>
		
		<c:if test="<%= ESFCardPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.ESFCARD_VIEW)  
						&& (Validator.isNull(esfOrganizationType) || esfOrganizationType < ESFKeys.ESFOrganizationTypeId.PROVINCE)
					%>">	
		
			<liferay-ui:search-container-column-jsp path='<%= templatePath + "esfcardorganization_actions.jsp"%>' align="right" />
		
		</c:if>
				
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>		
