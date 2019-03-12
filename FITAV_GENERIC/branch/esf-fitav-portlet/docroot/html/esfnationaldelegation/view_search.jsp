<%@include file="init.jsp"%>

<%
	String firstname = ParamUtil.getString(request, "firstname");
	String lastname = ParamUtil.getString(request, "lastname");
	String cardCode = ParamUtil.getString(request, "card");
	Integer typestate = ParamUtil.getInteger(request, "typestate");

	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter(
		"mvcPath", "/html/esfnationaldelegation/view_search.jsp");
	viewassURL.setParameter("firstname", firstname);
	viewassURL.setParameter("lastname", lastname);
	viewassURL.setParameter("cardCode", cardCode);
	viewassURL.setParameter("typestate", String.valueOf(typestate));

%>

<c:if test="<%= ESFNationalDelegationModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFNATIONALDELEGATION_ADD) %>">	
	<aui:button-row cssClass="esfnationaldelegation-admin-buttons">
	
		<portlet:renderURL var="renderURL">
			<portlet:param name="mvcPath" value='<%=templatePath+"shooterCandidate.jsp"%>' />
		</portlet:renderURL>
		
		<aui:button onClick="<%= renderURL.toString() %>" value="add-to-national" />
	</aui:button-row>
</c:if>



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
			<aui:button	type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL%>">
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
			pageContext.setAttribute("total", esfusers.size());
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
		
		ESFCard card =
				ESFCardLocalServiceUtil.findAllESFCardsByU_S(
					esfUser.getEsfUserId(), ESFKeys.ESFStateType.ENABLE).get(0);
		%>

		<liferay-ui:search-container-column-text value="<%= card.getCode() %>"
			name="card" />

		<%
			String orgName =
				ESFOrganizationLocalServiceUtil.fetchESFOrganization(card.getEsfOrganizationId()).getName();
		%>

		<liferay-ui:search-container-column-text value="<%=orgName%>" name="orgName" />

		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(esfUser.getBirthday())%>" />
		
		<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFNATIONALDELEGATION_VIEW_ACTION) %>">	
	
			<liferay-ui:search-container-column-jsp
					path='<%=templatePath + "esfPopupNational_actions.jsp"%>' align="right" />
		</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>