<%-- <%@include file="/html/esfuserrole/init.jsp"%> --%>

<%@page import="it.ethica.esf.permission.ESFUserRolePermission"%>
<%
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

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="title" placeholder="title"
					size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="name" placeholder="name"
					size="30" title="search-entries" type="text" />
			<aui:input  name="typestate"  type="hidden" value="<%= ESFKeys.ESFStateType.DISABLE%>"/>
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>


<liferay-ui:search-container orderByType="<%=orderByType%>" emptyResultsMessage="no-results">
	<liferay-ui:search-container-results>
		<%
					List<ESFUserRole> allEsfUserRolePerPage =
						ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(
							ESFKeys.ESFStateType.DISABLE,
							searchContainer.getStart(),
							searchContainer.getEnd());
				
					int totalEsfUserRole =
						ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(
							currentType, ESFKeys.ESFStateType.DISABLE).size();

					List<ESFUserRole> sortableEsfUserRole =
						new ArrayList<ESFUserRole>(allEsfUserRolePerPage);

					if (Validator.isNotNull(orderByCol)) {
						BeanComparator beanComparator =
							new BeanComparator(orderByCol);
						
						Collections.sort(
							sortableEsfUserRole, beanComparator);
						
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

		<liferay-ui:search-container-column-text property="title"
			orderable="true" orderableProperty="title" name="title" />

		<liferay-ui:search-container-column-text property="name"
			orderable="true" orderableProperty="name" name="name"/>

		<liferay-ui:search-container-column-text property="description"
			orderable="true" orderableProperty="description" name="description"/>

		<liferay-ui:search-container-column-text property="isBDO" name="is-bdo"/>

		<liferay-ui:search-container-column-text property="isLEA" name="is-lea"/>

		<liferay-ui:search-container-column-text property="isOrgAdmin" name="is-org-admin"/>
		
<c:if test="<%= ESFUserRolePermission.contains(permissionChecker,userRole.getEsfUserRoleId(), scopeGroupId, ActionKeys.ESFUSERROLE_VIEWACTION) %>">

		<liferay-ui:search-container-column-text>
			<portlet:renderURL var="stateURL">
				<portlet:param name="esfUserRoleId"
					value="<%=String.valueOf(userRole.getEsfUserRoleId())%>" />
				<portlet:param name="mvcPath"
					value="/html/esfuserrole/edit_esfUserRoleState.jsp" />
				<portlet:param name="op" value="updAddr" />
			</portlet:renderURL>
			<aui:button value="State" onClick="<%= stateURL %>"></aui:button>
		</liferay-ui:search-container-column-text>
</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
