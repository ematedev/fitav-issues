<%@include file="init.jsp"%>

<%
	String firstname = ParamUtil.getString(request, "firstname");
	String lastname = ParamUtil.getString(request, "lastname");
	String cardCode = ParamUtil.getString(request, "card");
	Integer typestate = ParamUtil.getInteger(request, "typestate");
	String stId = ParamUtil.getString(request, "stId");
	String stName = "";
	
	if(Validator.isNotNull(stId)){
		if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId))) && 
				Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId)).getName())){
			stName = ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId)).getName();
		}
	}

	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter(
		"mvcPath", "/html/esfnationaldelegation/view_search.jsp");
	viewassURL.setParameter("firstname", firstname);
	viewassURL.setParameter("lastname", lastname);
	viewassURL.setParameter("cardCode", cardCode);
	viewassURL.setParameter("typestate", String.valueOf(typestate));
	
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
<h3>Assegnazione Tiratore alla specialità <%=stName %></h3>
	<portlet:renderURL var="renderURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
	</portlet:renderURL>
	
	<aui:button-row cssClass="esfshooter-admin-buttons">
	
		<aui:button onClick="<%= renderURL.toString() %>" value="back" />
	</aui:button-row>



<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input
					inlineField="<%=true%>" label="" name="lastname"
					placeholder="last-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="firstname"
					placeholder="first-name" size="30" title="search-entries"
					type="text" /> 
			<aui:input inlineField="<%=true%>" label=""
					name="card" placeholder="card" size="30" title="search-entries"
					type="text" /> 
			<aui:input name="typestate" type="hidden"
					value="<%=ESFKeys.ESFStateType.ENABLE%>" /> 
			<aui:input name="stId" type="hidden" 
				value="<%=stId%>" />
			<aui:button	type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL%>">
	<liferay-ui:search-container-results>
		<%
		/*List<ESFUser> esfusersSE = ESFUserLocalServiceUtil.findShooterNotAssociated(
				firstname, lastname, cardCode, Long.valueOf(stId), searchContainer.getStart(),
					searchContainer.getEnd());
			
			/*List<ESFUser> esfusers = ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S(
				firstname, lastname, cardCode,currentOrganizationId);*/
		List<ESFUser> esfusersSE = ESFUserLocalServiceUtil.findALLShooterNotAssociated(
						firstname, lastname, cardCode, Long.valueOf(stId), searchContainer.getStart(),
							searchContainer.getEnd());
			
			/*int tot = ESFUserLocalServiceUtil.countNotNationalShooterBySPT(
					firstname, lastname, cardCode, Long.valueOf(stId));*/
		int tot = ESFUserLocalServiceUtil.countALLNotNationalShooterBySPT(
			firstname, lastname, cardCode, Long.valueOf(stId));
				
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
				pageContext.setAttribute("total", tot);
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
		String userCardCode = "";
		String orgName ="";
		if(!ESFCardLocalServiceUtil.findCardByUser(esfUser.getEsfUserId()).isEmpty() && Validator.isNotNull(ESFCardLocalServiceUtil.findCardByUser(esfUser.getEsfUserId()).get(0))){
			ESFCard userCard = ESFCardLocalServiceUtil.findCardByUser(esfUser.getEsfUserId()).get(0);
			userCardCode = userCard.getCode();
			if(Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCard.getEsfOrganizationId()))){
				orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(userCard.getEsfOrganizationId()).getName();
			}
			
		}
			
		%>

		<liferay-ui:search-container-column-text value="<%=userCardCode %>" name="card" />

		<liferay-ui:search-container-column-text value="<%=orgName%>" name="orgName" />

		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday" value="<%=sdf.format(esfUser.getBirthday())%>" />
		<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFNATIONALDELEGATION_VIEW_ACTION) %>">	
	
			<liferay-ui:search-container-column-jsp
					path='<%=templatePath + "esfPopupNational_actions.jsp"%>' align="right" />
		</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>