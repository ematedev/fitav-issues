<%@include file="init.jsp"%>

<%
	String firstname = ParamUtil.getString(request, "firstname");
	String lastname = ParamUtil.getString(request, "lastname");
	String cardCode = ParamUtil.getString(request, "card");
	Integer typestate = ParamUtil.getInteger(request, "typestate");
	String  esfFornitureId = ParamUtil.getString(request, "esfFornitureId");
	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter(
		"mvcPath", "/html/esfforniture/view_search.jsp");
	viewassURL.setParameter("firstname", firstname);
	viewassURL.setParameter("lastname", lastname);
	viewassURL.setParameter("cardCode", cardCode);
	viewassURL.setParameter("esfFornitureId", esfFornitureId);
	viewassURL.setParameter("typestate", String.valueOf(typestate));

	List<ESFCard> cards =
		ESFCardLocalServiceUtil.findAllESFCardsByState(typestate);
	Hashtable<Long, ESFCard> allEsfCards =
		new Hashtable<Long, ESFCard>();
	for (ESFCard card : cards) {
		allEsfCards.put(card.getEsfUserId(), card);
	}

%>

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%=true%>" label="" name="lastname"
				placeholder="last-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries"
				type="text" /> <aui:input inlineField="<%=true%>" label=""
				name="card" placeholder="card" size="30" title="search-entries"
				type="text" /> <aui:input name="typestate" type="hidden"
				value="<%=ESFKeys.ESFStateType.ENABLE%>" /> <aui:button
				type="submit" value="search" />
		</span>
	</div> 
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result"
	iteratorURL="<%=viewassURL%>">
	<liferay-ui:search-container-results>
		<%
		List<ESFUser> esfusersSE =
		ESFUserLocalServiceUtil.getAllUserByLikeF_C_S(
			firstname, lastname, cardCode, typestate,
				currentOrganizationId, searchContainer.getStart(),
				searchContainer.getEnd());
		
		List<ESFUser> esfusers =
		ESFUserLocalServiceUtil.getAllUserByLikeF_C_S(
			firstname, lastname, cardCode, typestate,
			currentOrganizationId);
		
			
			pageContext.setAttribute("results", esfusersSE);
			pageContext.setAttribute("total", esfusers !=null ? esfusers.size() : 0);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName"
			name="last-name" />

		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />

		<liferay-ui:search-container-column-text
			value="<%=esfUser.getFiscalCode()%>" name="fiscalCode" />

		<%
			String userCard =
						allEsfCards.get(esfUser.getEsfUserId()).getCode();
		%>

		<liferay-ui:search-container-column-text value="<%=userCard%>"
			name="card" />

		<%
			String orgName =
						ESFOrganizationLocalServiceUtil.fetchESFOrganization(
							allEsfCards.get(esfUser.getEsfUserId()).getEsfOrganizationId()).getName();
		%>

		<liferay-ui:search-container-column-text value="<%=orgName%>"
			name="orgName" />

		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(esfUser.getBirthday())%>" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfAssign_action.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>