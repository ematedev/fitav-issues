<%@include file="init.jsp" %>

<h2><liferay-ui:message key="esf-organization-list"></liferay-ui:message></h2>

<% if (ESFModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFORGANIZATION)) { %>

<portlet:renderURL var="addESFOrganizationURL">
	<portlet:param name="mvcPath" value="/html/portlet/esforganizationadmin/edit_organization.jsp"/>
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addESFOrganizationURL.toString() %>" value="add-organization"/>
</aui:button-row>

<% } 

DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
String keywords = ParamUtil.getString(request, "keywords");

%>

<liferay-ui:search-container
	emptyResultsMessage="no-result"
>
	<%
	List<ESFOrganization> res = null;
	int tot = 0;
	if(keywords != null && !keywords.isEmpty()) {
		
		SearchContext searchContext = SearchContextFactory.getInstance(request);
		
		searchContext.setKeywords(keywords);
		searchContext.setAttribute("paginationType", "more");
		searchContext.setStart(0);
		searchContext.setEnd(10);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(ESFOrganization.class);
		
		Hits hits = indexer.search(searchContext);
		
		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();
		
		for (int i = 0; i < hits.getDocs().length; i++) {
	        Document doc = hits.doc(i);
	
	        long esfOrganizationId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
	
	        ESFOrganization esfOrganization = null;
	
	        try {
	        	esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
	        } catch (PortalException pe) {
	                _log.error(pe.getLocalizedMessage());
	        } catch (SystemException se) {
	                _log.error(se.getLocalizedMessage());
	        }
	
	        esfOrganizations.add(esfOrganization);
		}
		res = esfOrganizations;
		tot = esfOrganizations.size();
	} else {
		res = ESFOrganizationLocalServiceUtil.getESFOrganizations(searchContainer.getStart(), searchContainer.getEnd());
		tot = ESFOrganizationLocalServiceUtil.getESFOrganizationsCount();	
	}
	%>
	<liferay-ui:search-container-results
		results="<%= res %>"
		total="<%= tot %>"
	/>
	
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFOrganization"
		modelVar="esfOrganization"		
	>	
	<% if(ESFOrganizationPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.VIEW)) { %>
		
		<liferay-ui:search-container-column-text property="esfOrganizationId" />
		
		<liferay-ui:search-container-column-text property="name" />
		
		<liferay-ui:search-container-column-jsp 
			name="<liferay:message key='type'/>" 
			path="/html/portlet/esforganizationadmin/organization_type.jsp" 
		/>
		
		<% if(ESFOrganizationPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.UPDATE)
				|| ESFOrganizationPermission.contains(permissionChecker, esfOrganization.getEsfOrganizationId(), ActionKeys.DELETE)) { %>
		
		<liferay-ui:search-container-column-jsp path="/html/portlet/esforganizationadmin/organization_actions.jsp" />
		
		<% } 
	
	} %>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.esfuseradmin.view_jsp");
%>

