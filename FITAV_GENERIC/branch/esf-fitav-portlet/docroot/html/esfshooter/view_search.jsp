
<%@include file="init.jsp"%>

<%
	String firstname = ParamUtil.getString(request, "firstname");
	String lastname = ParamUtil.getString(request, "lastname");
	String cardCode = ParamUtil.getString(request, "card");
	Integer typestate = ParamUtil.getInteger(request, "typestate");

	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter(
		"mvcPath", "/html/esfshooter/view_search.jsp");
	viewassURL.setParameter("firstname", firstname);
	viewassURL.setParameter("lastname", lastname);
	viewassURL.setParameter("cardCode", cardCode);
	viewassURL.setParameter("typestate", String.valueOf(typestate));
/*
	List<ESFCard> cards =
		ESFCardLocalServiceUtil.findAllESFCardsByState(typestate);
	Hashtable<Long, ESFCard> allEsfCards =
		new Hashtable<Long, ESFCard>();
	for (ESFCard card : cards) {
		allEsfCards.put(card.getEsfUserId(), card);
	}*/
boolean visible = false;
ESFOrganization organization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
String organizationName ="";
String orgCode = "";

if(Validator.isNotNull(organization) && Validator.isNotNull(organization.getType()) && ESFKeys.ESFOrganizationTypeId.ASSOCIATION == organization.getType()){
	visible=true;
	organizationName = organization.getName();
	orgCode = organization.getCode();
}


String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil
		.getString(request, "orderByType");
String sortingOrder = orderByType;

if (orderByType.equals("desc")) {
	orderByType = "asc";
} else {
	orderByType = "desc";
}

if (Validator.isNull(orderByType)) {
	orderByType = "desc";
}

%>

<%if(visible){ 
	String[] orgDetails ={organizationName,orgCode};
%>
<h2><b><liferay-ui:message key="orgName-x-orgCode-x"  arguments="<%= orgDetails%>"/></b></h2>

<%} %>

	<c:if test="<%= ESFShooterModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFSHOOTER_ADD) %>">	
		<aui:button-row cssClass="esfshooter-admin-buttons">
			<portlet:renderURL var="addESFShooterURL">
				<portlet:param name="mvcPath"
					value='<%=templatePath + "edit_esfShooter.jsp"%>' />
				<portlet:param name="organizationId"
					value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="op" value="addAddr" />
			</portlet:renderURL>
	
			<aui:button onClick="<%= addESFShooterURL.toString() %>"
				value="add-shooter" />
		</aui:button-row>
	</c:if>
	

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<aui:form action="<%=searchURL%>" method="get" name="fm">

	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
	
		<span class="aui-search-bar"> 
		
		<aui:input inlineField="<%=true%>" label="" name="lastname"
				placeholder="last-name" size="30" title="search-entries" type="text" />
		<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries" type="text" />
		<aui:input inlineField="<%=true%>" label="" name="card" 
			 placeholder="card" size="30" title="search-entries" type="text" /> 
		<aui:input name="typestate" type="hidden" value="<%=ESFKeys.ESFStateType.ENABLE%>" /> 
		
		<aui:button type="submit" value="search" />
		
		</span>
		
	</div>
	
</aui:form>


<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL%>" orderByType="<%=orderByType%>">

	<liferay-ui:search-container-results>
		<%
		List<ESFUser> esfusersSE = ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S(
			firstname, lastname, cardCode, currentOrganizationId, searchContainer.getStart(),
				searchContainer.getEnd());
		
		List<ESFUser> esfusers = ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S(
			firstname, lastname, cardCode,currentOrganizationId);
		
		List<ESFUser> esfusersSESortable = new ArrayList<ESFUser>(esfusersSE);
		
		if (Validator.isNotNull(orderByCol)) {
			BeanComparator beanComparator = new BeanComparator(
					orderByCol);
			
		Collections.sort(esfusersSESortable,
				beanComparator);
		
			if (sortingOrder.equalsIgnoreCase("desc")) {
	
				Collections
						.reverse(esfusersSESortable);
			}
		}
			
			pageContext.setAttribute("results", esfusersSESortable);
			pageContext.setAttribute("total", esfusers !=null ? esfusers.size() : 0);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName" orderable="true" orderableProperty="lastName" name="last-name" />

		<liferay-ui:search-container-column-text property="firstName" name="first-name" />

		<liferay-ui:search-container-column-text value="<%=esfUser.getFiscalCode()%>" name="fiscalCode" />

		<liferay-ui:search-container-column-text name="user-email">
		
			<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
		</liferay-ui:search-container-column-text>
		<%
			ESFCard userCard= ESFCardLocalServiceUtil.findCardByUser(esfUser.getEsfUserId()).get(0);
			String userCardCode = userCard.getCode();
		%>

		<liferay-ui:search-container-column-text value="<%=userCardCode %>" name="card" />

		<%
			String orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCard.getEsfOrganizationId()).getName();
		%>

		<liferay-ui:search-container-column-text value="<%=orgName%>" name="orgName" />

		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday" value="<%=sdf.format(esfUser.getBirthday())%>" />

		<c:if test="<%= ESFShooterPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFSHOOTER_VIEW) %>">	
			<liferay-ui:search-container-column-jsp
				path='<%=templatePath + "esfShooter_action.jsp"%>' align="right" />
		</c:if>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
