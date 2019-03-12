<%@include file="init.jsp"%>

<%
	String firstname = ParamUtil.getString(request, "firstname");
	String lastname = ParamUtil.getString(request, "lastname");
	Integer typestate = ParamUtil.getInteger(request, "typestate");
	
	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter("mvcPath", "/html/esfuseradmin/view_search.jsp");
	viewassURL.setParameter("firstname", firstname);
	viewassURL.setParameter("lastname", lastname);
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

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<c:if test="<%= ESFUserAdminModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFUSERADMIN_ADD) %>">	
		
			<aui:button-row cssClass="esfuser-admin-buttons">
	
				<portlet:renderURL var="addESFUserURL">
					<portlet:param name="mvcPath" value="/html/esfuseradmin/edit_esfUser.jsp" />
					<portlet:param name="op" value="addAddr" />
				</portlet:renderURL>
				<aui:button onClick="<%= addESFUserURL.toString() %>" value="add-user" />
	
			</aui:button-row>
		
		</c:if>	



<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="lastname" placeholder="last-name"  size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="firstname" placeholder="first-name"	size="30" title="search-entries" type="text" />
			<aui:input  name="typestate"  type="hidden" value="<%=typestate %>"/>
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>


<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%= viewassURL%>" orderByType="<%=orderByType%>">
	<liferay-ui:search-container-results>
		<%
			List<ESFUser> esfusers =
						ESFUserLocalServiceUtil.getAllUserByLikeF_L_S(
							firstname, lastname, "", typestate);
			List<ESFUser> esfusersSE =
						ESFUserLocalServiceUtil.getAllUserByLikeF_L_S(
							firstname, lastname, "", typestate,
							searchContainer.getStart(),
							searchContainer.getEnd());
			
			List<ESFUser> ordableEsfusersSE =  new ArrayList<ESFUser>(esfusersSE);
			
			
			pageContext.setAttribute("results", ordableEsfusersSE);
			pageContext.setAttribute("total", esfusers.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="firstName" />

		<liferay-ui:search-container-column-text property="lastName"  orderable="true" orderableProperty="lastName" />

		<liferay-ui:search-container-column-text property="screenName" />

		<liferay-ui:search-container-column-text property="userEmail" />

		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value='<%=esfUser.getBirthday()!=null ? sdf.format(esfUser.getBirthday()) : StringPool.BLANK%>' />

		<c:if test="<%= ESFUserAdminPermission.contains(permissionChecker, esfUser.getEsfUserId(),  ActionKeys.ESFUSERADMIN_VIEW) %>">	
		
			<liferay-ui:search-container-column-jsp
				path="/html/esfuseradmin/esfUser_action.jsp" align="right" />
		
		</c:if>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
