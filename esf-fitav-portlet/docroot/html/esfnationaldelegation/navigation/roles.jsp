
<%@include file="init.jsp"%>

<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", "/html/esfnationaldelegation/navigation/roles.jsp");

String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
String sortingOrder = orderByType;

if (orderByType.equals("desc")) {
	orderByType = "asc";
}
else {
	orderByType = "desc";
}

if (Validator.isNull(orderByType)) {
	orderByType = "desc";
}
%>

<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL %>">
	<liferay-ui:search-container-results>
	<%
		List<ESFUserESFUserRole> allESFUserESFUserRole=
			ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleByESFUserId(
				esfUserId,
				searchContainer.getStart(),
				searchContainer.getEnd());

		int totalESFUserESFUserRole =
			ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleCountByESFUserId(esfUserId);

		pageContext.setAttribute("results", allESFUserESFUserRole);
		pageContext.setAttribute("total", totalESFUserESFUserRole);
						
	%>
	</liferay-ui:search-container-results>


	<liferay-ui:search-container-row 
		className="it.ethica.esf.model.ESFUserESFUserRole" modelVar="esfUserESFUserRole">

		<%
			ESFUserRole esfUserRole = ESFUserRoleLocalServiceUtil.getESFUserRole(
				esfUserESFUserRole.getEsfUserRoleId());
		
		Organization org = null;
		String orgName = "";
		if(Validator.isNotNull(esfUserESFUserRole.getEsfOrganizationId()) && 
				Validator.isNotNull(OrganizationLocalServiceUtil.fetchOrganization(esfUserESFUserRole.getEsfOrganizationId())) && 
				Validator.isNotNull(OrganizationLocalServiceUtil.fetchOrganization(esfUserESFUserRole.getEsfOrganizationId()).getName())){
			
			orgName = OrganizationLocalServiceUtil.fetchOrganization(esfUserESFUserRole.getEsfOrganizationId()).getName();
			
		}
	
	
	%>
		
		
		<liferay-ui:search-container-column-text name="title" 
		value='<%= esfUserRole.getTitle() %>' />

		<liferay-ui:search-container-column-text name="name" 
		value='<%= esfUserRole.getName() %>' />

		<liferay-ui:search-container-column-text name="description" 
		value='<%= esfUserRole.getDescription() %>' />
		
		<liferay-ui:search-container-column-text name="start-date" 
			value="<%= sdf.format(esfUserESFUserRole.getStartDate())%>"/>

		<liferay-ui:search-container-column-text name="organization" 
		value='<%= orgName %>' />

		<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFNATIONALDELEGATION_ROLE_DELETE) %>">	
			<liferay-ui:search-container-column-jsp
					path='<%="/html/esfnationaldelegation/navigation/roleRemove_actions.jsp"%>' align="right" />
		</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFNATIONALDELEGATION_ROLE_VIEW_ACTION) %>">	
		
<h3> <liferay-ui:message key="roles" /> </h3>


<liferay-ui:search-container orderByType="<%=orderByType%>" emptyResultsMessage="no-results"  curParam= "sc2">
	<liferay-ui:search-container-results>

		<%
			List<ESFUserRole> allEsfUserRolePerPage =
						ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByStateNoAssign( esfUserId,
							searchContainer.getStart(), searchContainer.getEnd());

					int totalEsfUserRole =
						ESFUserRoleLocalServiceUtil.countAllEsfUserRoleByStateNoAssign( esfUserId);

					List<ESFUserRole> sortableEsfUserRole =
						new ArrayList<ESFUserRole>(allEsfUserRolePerPage);

					if (Validator.isNotNull(orderByCol)) {
						BeanComparator beanComparator =
							new BeanComparator(orderByCol);

						Collections.sort(sortableEsfUserRole, beanComparator);

						if (sortingOrder.equalsIgnoreCase("desc")) {

							Collections.reverse(sortableEsfUserRole);
						}
					}
					pageContext.setAttribute("results", sortableEsfUserRole);
					pageContext.setAttribute("total", totalEsfUserRole);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUserRole" modelVar="userRole">
		
		<%
		boolean isBDO = false;
		boolean isLEA = false;
		boolean isOrgAdmin = false;
		
		if(Validator.isNotNull(userRole.getIsBDO())){
			isBDO = userRole.getIsBDO();
		}
		if(Validator.isNotNull(Validator.isNotNull(userRole.getIsLEA()))){
			isLEA = userRole.getIsLEA();
		}
		if(Validator.isNotNull(Validator.isNotNull(userRole.getIsOrgAdmin()))){
			isOrgAdmin = userRole.getIsOrgAdmin();
		}
		
		%>

		<liferay-ui:search-container-column-text property="title"
			orderable="true" orderableProperty="title" name="title" />

		<liferay-ui:search-container-column-text property="name"
			orderable="true" orderableProperty="name" name="name" />

		<liferay-ui:search-container-column-text property="description"
			orderable="true" orderableProperty="description" name="description" />

			<liferay-ui:search-container-column-jsp
					path='<%="/html/esfnationaldelegation/navigation/esfUserRole_action.jsp"%>' align="right" />
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</c:if>	
