<%-- <%@include file="/html/esfuserrole/init.jsp"%> --%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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
			<aui:input  name="typestate"  type="hidden" value="<%= ESFKeys.ESFStateType.ENABLE%>"/>
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container orderByType="<%=orderByType%>" emptyResultsMessage="no-results">
	<liferay-ui:search-container-results>

		<%
			List<ESFUserRole> allEsfUserRolePerPage =
						ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(
							ESFKeys.ESFStateType.ENABLE,
							searchContainer.getStart(),
							searchContainer.getEnd());

					int totalEsfUserRole =
						ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(
							currentType, ESFKeys.ESFStateType.ENABLE).size();

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
String title = "";
String name = "";
String description = "";
if(Validator.isNotNull(userRole) && Validator.isNotNull(userRole.getTitle())){
	title = userRole.getTitle();
}
if(Validator.isNotNull(userRole) && Validator.isNotNull(userRole.getName())){
	name = userRole.getName();
}
if(Validator.isNotNull(userRole) && Validator.isNotNull(userRole.getDescription())){
	description = userRole.getDescription();
}
%>
		<liferay-ui:search-container-column-text value="<%=title %>"
			orderable="true" orderableProperty="title" name="title" />

		<liferay-ui:search-container-column-text value="<%=name %>"
			orderable="true" orderableProperty="name" name="name" />

		<liferay-ui:search-container-column-text value="<%=description %>"
			orderable="true" orderableProperty="description" name="description" />

		<liferay-ui:search-container-column-text property="isBDO" name="is-bdo"/>

		<liferay-ui:search-container-column-text property="isLEA" name="is-lea"/>
		
		<liferay-ui:search-container-column-text property="isOrgAdmin" name="is-org-admin"/>

		<liferay-ui:search-container-column-jsp
			path="/html/esfuserrole/esfUserRole_action.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
