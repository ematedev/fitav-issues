<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@include file="init.jsp"%>
<%

	if (currentOrganizationId == 0) {
%>
<liferay-ui:error key="error-insert-association" message="error-insert-association"
/>
<div class="alert alert-error">
	<liferay-ui:message
		key="place-this-portlet-inside-an-esforganization-site">
	</liferay-ui:message>
</div>

<%
	} else {

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

		Organization organization = OrganizationLocalServiceUtil.getOrganization(currentOrganizationId);
%>

<h3>
	<liferay-ui:message key="esf-sport-association" />
</h3>

<liferay-ui:success key="esfOrganizationAdded" message="organization-added" />

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"	value="/html/esfsportassociation/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%=true%>"  name="name" placeholder="name" size="30" title="search-entries" type="text" /> 
			<aui:input inlineField="<%=true%>"  name="code" placeholder="code"	size="30" title="search-entries" type="text" /> 
			<aui:select  name="searchOrgId" inlineField="<%=true%>">
				<%
					if (currentType == ESFKeys.ESFOrganizationTypeId.PROVINCE) {
				%>
						<aui:option value="<%=currentESFOrganization.getEsfOrganizationId()%>" selected="true" label="<%=currentESFOrganization.getName()%>"></aui:option>
				<%
					} else {
				%>

						<aui:option value="0" label="-"></aui:option>
				<%
						List<ESFOrganization> esfOrgsForSearch = ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T(currentOrganizationId,ESFKeys.ESFOrganizationTypeId.PROVINCE);
						for (ESFOrganization esfOrgForSearch : esfOrgsForSearch) {
				%>

							<aui:option	value="<%=esfOrgForSearch.getEsfOrganizationId()%>" label="<%=esfOrgForSearch.getName()%>"></aui:option>

				<%
						}
					}
				%>
			</aui:select> <aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>


<c:if test='<%=  ESFSportAssociationModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFSPORTASSOCIATOIN_ADD)%>'>
	
	<aui:button-row cssClass="esfsportassociation-buttons">
		
			<portlet:renderURL var="addESFOrganizationURL" windowState='<%=WindowState.MAXIMIZED.toString() %>'>
				<portlet:param name="mvcPath" value='<%=templatePath + "edit_esforganization.jsp"%>' />
				<portlet:param name="op" value='addAddr' />
				<portlet:param name="ckisarmy" value='false' />
				<portlet:param name="isSimplyOrganizzation" value="false" />
			</portlet:renderURL>
	
			<aui:button onClick="<%= addESFOrganizationURL.toString() %>" value="add-association" />
		
		
			<portlet:renderURL var="addESFOrganizationURL" windowState='<%=WindowState.MAXIMIZED.toString()%>' >
				<portlet:param name="mvcPath" value='<%=templatePath + "edit_esforganization.jsp"%>' />
				<portlet:param name="op" value='addAddr' />
				<portlet:param name="ckisarmy" value='true' />
				<portlet:param name="isSimplyOrganizzation" value="true" />
			</portlet:renderURL>
	
			<aui:button onClick="<%= addESFOrganizationURL.toString() %>" value="add-association-army" />
		</aui:button-row>

</c:if>

<liferay-ui:search-container emptyResultsMessage="no-result" orderByType="<%=orderByType%>">
	<liferay-ui:search-container-results>
		<%
			List<ESFOrganization> associations =  ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId,searchContainer.getStart(), searchContainer.getEnd());
			int tot = associations.size();
			List<ESFOrganization> sortableESFOrganization = new ArrayList<ESFOrganization>(associations);

			if (Validator.isNotNull(orderByCol)) {
					BeanComparator beanComparator = new BeanComparator(orderByCol);
					Collections.sort(sortableESFOrganization, beanComparator);

					if (sortingOrder.equalsIgnoreCase("desc")) {
							Collections.reverse(sortableESFOrganization);
					}
			}
			
			

			pageContext.setAttribute("results", sortableESFOrganization);
			pageContext.setAttribute("total", tot);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganizationTab">


		<liferay-ui:search-container-column-text property="name" orderable="true" orderableProperty="name"/>
		<liferay-ui:search-container-column-text property="code" orderable="true" orderableProperty="code"/>
		<c:if test="<%= ESFSportAssociationPermission.contains(permissionChecker, esfOrganizationTab.getEsfOrganizationId(), ActionKeys.ESFSPORTASSOCIATOIN_VIEW) %>">	
			
			<liferay-ui:search-container-column-jsp path='<%=templatePath + "esfsportassociation_actions.jsp"%>' align="right"/>
		
		</c:if>
			
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<%
	}
%>