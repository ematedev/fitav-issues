
<%@include file="init.jsp"%>

<%
	String firstname = ParamUtil.getString(request, "firstname");
	String lastname = ParamUtil.getString(request, "lastname");
	String cardCode = ParamUtil.getString(request, "card");
	Integer typestate = ParamUtil.getInteger(request, "typestate");
	boolean viewRegional = ParamUtil.getBoolean(request, "viewRegional");
	boolean isRegional = ParamUtil.getBoolean(request, "isRegional");
	boolean isAss = ParamUtil.getBoolean(request, "isAss");
	
	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter(
		"mvcPath", "/html/esfshooter/view_search.jsp");
	viewassURL.setParameter("firstname", firstname);
	viewassURL.setParameter("lastname", lastname);
	viewassURL.setParameter("cardCode", cardCode);
	viewassURL.setParameter("typestate", String.valueOf(typestate));
	viewassURL.setParameter("isRegional", String.valueOf(isRegional));
	viewassURL.setParameter("isAss", String.valueOf(isAss));
	viewassURL.setParameter("viewRegional", String.valueOf(viewRegional));
	
	
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


String orderByCol = ParamUtil.getString(request, "orderByCol","lastName");
String orderByType = ParamUtil
		.getString(request, "orderByType","asc");
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
		<aui:input name="viewRegional" type="hidden" value="<%=viewRegional%>" inlineField="<%=true%>" />
		<aui:input name="isAss" type="hidden" value="<%=isAss%>" inlineField="<%=true%>" />
		<aui:input name="typestate" type="hidden" value="<%=ESFKeys.ESFStateType.ENABLE%>" inlineField="<%=true%>"/> 
	<%if(viewRegional){ %>	
		<div class="control-group control-group-inline">
				<aui:input name="isRegional" type="checkbox" checked="<%=isRegional%>" label="regional"/>
		</div><br />
	<%} %>	
		<aui:button type="submit" value="search" />
		
		</span>
		
	</div>
	
</aui:form>


<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL%>" orderByType="<%=orderByType%>">

	<liferay-ui:search-container-results>
		<%
		List<ESFUser> esfusersSE = new ArrayList<ESFUser>();
		List<ESFUser> esfusers = new ArrayList<ESFUser>();
		int esfusersTot = 0 ;

		System.out.println("isAss = "+isAss+" isRegional = "+isRegional);

		if(isAss){
			
			esfusersSE = ESFUserLocalServiceUtil.findAssociatedShooterOrganization(
					firstname, lastname, cardCode, currentOrganizationId, searchContainer.getStart(),
					searchContainer.getEnd());
			
			esfusersTot = ESFUserLocalServiceUtil.countAssociatedShooterOrganization(
					firstname, lastname, cardCode,currentOrganizationId);
			
			if(0 < esfusersTot){
				pageContext.setAttribute("total",  esfusersTot);
			}else{
				pageContext.setAttribute("total", 0);
			}
			
			
		}else{
			if(isRegional){
				esfusersSE = ESFUserLocalServiceUtil.findShooterByAss(
						firstname, lastname, cardCode, currentOrganizationId, searchContainer.getStart(),
							searchContainer.getEnd());
				esfusersTot = ESFUserLocalServiceUtil.countShooterByAss(
						firstname, lastname, cardCode,currentOrganizationId);
				
				if(0 < esfusersTot){
					pageContext.setAttribute("total",  esfusersTot);
				}else{
					pageContext.setAttribute("total", 0);
				}
				
				
				
			}else{
				esfusersSE = ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S(
						firstname, lastname, cardCode, currentOrganizationId, searchContainer.getStart(),
							searchContainer.getEnd());
					
				esfusers = ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S(
						firstname, lastname, cardCode,currentOrganizationId);
				
				pageContext.setAttribute("total", esfusers !=null ? esfusers.size() : 0);
			}
		}
		
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
			
			/*if(Validator.isNotNull(organization) && Validator.isNotNull(organization.getType())){
				pageContext.setAttribute("total", esfusersTot);
			}else{*/
			
			//}
			
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
		
			ESFCard userCard= null;
			String userCardCode ="";
			List<ESFCard> cardstest = new ArrayList<ESFCard>();
			/*try{
				userCard=ESFCardLocalServiceUtil.findAllESFCardsByU_S(esfUser.getEsfUserId(),1).get(0);
				userCardCode = userCard.getCode();
			}
			catch(Exception e){
				
			}*/
			
			try{
				cardstest = ESFCardLocalServiceUtil.findActualUserCards(esfUser.getEsfUserId());
				
				if(Validator.isNotNull(cardstest) && 0 < cardstest.size()){
					userCardCode = cardstest.get(0).getCode();
				}
				
			}
			catch(Exception e){
				
			}
		%>

		<liferay-ui:search-container-column-text value="<%=userCardCode %>" name="card" />

		<%
			String orgName = "";
		/*	if(userCard!=null){
				orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCard.getEsfOrganizationId()).getName();
			}*/
			
			if(Validator.isNotNull(cardstest) && 0 < cardstest.size() && 
					Validator.isNotNull(cardstest.get(0)) && Validator.isNotNull( ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardstest.get(0).getEsfOrganizationId())) &&
						Validator.isNotNull( ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardstest.get(0).getEsfOrganizationId()).getCode())){
				orgName =  ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardstest.get(0).getEsfOrganizationId()).getCode();
			}
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
