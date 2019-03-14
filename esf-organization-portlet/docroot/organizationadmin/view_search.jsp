<%@include file="/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view_search.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-ui:header
		backURL="<%= viewURL.toString() %>"
		title="search"
	/>
	
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />
		
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<%
	SearchContext searchContext = SearchContextFactory
		.getInstance(request);

	searchContext.setKeywords(keywords);
	searchContext.setAttribute("paginationType", "more");
	searchContext.setStart(0);
	searchContext.setEnd(10);
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(ESFOrganization.class);

	Hits hits = indexer.search(searchContext);
	
	List<ESFOrganization> entries = new ArrayList<ESFOrganization>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);

		long esfOrganizationIdDoc = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

		ESFOrganization esfOrganizationDoc = null;
		
		try {
			esfOrganizationDoc = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationIdDoc);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		entries.add(esfOrganizationDoc);
	}
	
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= entries %>"
		total="<%= entries.size() %>"
	/>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFOrganization"
		modelVar="esfOrganizationSC">

		<portlet:renderURL var="viewESFOrganization">
			<portlet:param name="mvcPath"
				value="/organizationadmin/view_esforganization.jsp" />
			<portlet:param name="esfOrganizationId"
				value="<%=String.valueOf(esfOrganizationSC.getEsfOrganizationId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="name"
			href="<%=viewESFOrganization%>" />

		<liferay-ui:search-container-column-text property="code" />

		<liferay-ui:search-container-column-text property="vat" />

		<liferay-ui:search-container-column-text property="fiscalCode" />

		<liferay-ui:search-container-column-jsp
			path="/organizationadmin/esforganization_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
	if (Validator.isNotNull(keywords)) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(
				pageContext, "search") + ": " + keywords, currentURL);
	}
%>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.esforganization.view_search_jsp");
%>
