
<%
String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
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
<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="lastname" placeholder="last-name"  size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="firstname" placeholder="first-name"	size="30" title="search-entries" type="text" />
			<aui:input  name="typestate"  type="hidden" value="<%= ESFKeys.ESFStateType.ENABLE%>"/>
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result" orderByType="<%=orderByType%>">
	<liferay-ui:search-container-results>
		<%
// 			String firstname="";
// 			String lastname="";
// 			int typestate=ESFKeys.ESFStateType.ENABLE;
				
// 			total =
// 				ESFUserLocalServiceUtil.countAllUserByLikeF_L(firstname, lastname, "");
			
// 			List<ESFUser> esfusers = 
// 				ESFUserLocalServiceUtil.getAllUserByLikeF_L(firstname, lastname, "", searchContainer.getStart(), searchContainer.getEnd());

// 			List<ESFUser> ordableEsfusers = new ArrayList<ESFUser>(esfusers);

// 			if (Validator.isNotNull(orderByCol)) {
// 				BeanComparator beanComparator = new BeanComparator(orderByCol);

// 				Collections.sort(ordableEsfusers, beanComparator);

// 				if (sortingOrder.equalsIgnoreCase("desc")) {

// 						Collections.reverse(ordableEsfusers);
// 				}
// 			}

// 			pageContext.setAttribute("results", ordableEsfusers);
// 			pageContext.setAttribute("total", esfusers.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName" orderable="true" orderableProperty="lastName"/>
		
		<liferay-ui:search-container-column-text property="firstName" />

		<liferay-ui:search-container-column-text property="screenName" />

		<liferay-ui:search-container-column-text name="user-email">
		
			<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
		</liferay-ui:search-container-column-text>

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