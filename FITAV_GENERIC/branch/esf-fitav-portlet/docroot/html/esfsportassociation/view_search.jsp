<%@include file="init.jsp"%>
<%
if (currentOrganizationId == 0) { %>

	<div class="alert alert-error">
		<liferay-ui:message key="place-this-portlet-inside-an-esforganization-site" >
		</liferay-ui:message>
	</div>

<%	
}
else {
	
	String name = ParamUtil.getString(request, "name");

	String code = ParamUtil.getString(request, "code");
	
	long searchOrgId = ParamUtil.getLong(request, "searchOrgId");

	Organization organization = OrganizationLocalServiceUtil.getOrganization(currentOrganizationId);

	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter("mvcPath", "/html/esfsportassociation/view_search.jsp");
	viewassURL.setParameter("name", name);
	viewassURL.setParameter("code", code);
		
	%>
	
	<h3><%= organization.getName() %></h3>
	
	<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />
	
	<liferay-portlet:renderURL varImpl="searchURL">
		<portlet:param name="mvcPath"	value="/html/esfsportassociation/view_search.jsp" />
	</liferay-portlet:renderURL>

	<aui:form action="<%=searchURL%>" method="get" name="fm">
		<liferay-portlet:renderURLParams varImpl="searchURL" />
		<div class="search-form">
			<span class="aui-search-bar">
				<aui:input inlineField="<%=true%>" label="" name="name" placeholder="name" size="30" title="search-entries" type="text" /> 
				<aui:input inlineField="<%=true%>" label="" name="code" placeholder="code"	size="30" title="search-entries" type="text" /> 
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
					%>
					<%
						}
					%>
				</aui:select> <aui:button type="submit" value="search" />
			</span>
		</div>
	</aui:form>
	
	<c:if test='<%=  ESFSportAssociationModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFSPORTASSOCIATOIN_ADD)%>'>
	
		<aui:button-row cssClass="esfsportassociation-buttons">
		
			<portlet:renderURL var="addESFOrganizationURL">
				<portlet:param name="mvcPath" value='<%=templatePath + "edit_esforganization.jsp"%>' />
				<portlet:param name="op" value='addAddr' />
			</portlet:renderURL>
	
			<aui:button onClick="<%= addESFOrganizationURL.toString() %>" value="add-association" />
		</aui:button-row>

	</c:if>

	<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%= viewassURL %>"> 
		<liferay-ui:search-container-results
					results="<%= ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C(
						name, code, searchOrgId, currentOrganizationId,searchContainer.getStart(), searchContainer.getEnd()) %>"
					total="<%= ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C(
						name, code, searchOrgId, currentOrganizationId).size() %>" />
	
				<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganizationTab">
	
				<liferay-ui:search-container-column-text property="name" />
				<liferay-ui:search-container-column-text property="code" />
				<c:if test="<%= ESFSportAssociationPermission.contains(permissionChecker, esfOrganizationTab.getEsfOrganizationId(), ActionKeys.ESFSPORTASSOCIATOIN_VIEW) %>">	
						
					<liferay-ui:search-container-column-jsp path='<%=templatePath + "esfsportassociation_actions.jsp"%>' align="right"/>
					
				</c:if>
	
				</liferay-ui:search-container-row>
	
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
	
<%
	}
%>