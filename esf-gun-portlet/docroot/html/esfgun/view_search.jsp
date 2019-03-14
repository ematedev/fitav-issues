<%@include file="init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/esfgun/view_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/html/esfgun/view.jsp" />
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
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(ESFGun.class);

	Hits hits = indexer.search(searchContext);
	
	List<ESFGun> entries = new ArrayList<ESFGun>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);

		long esfGunId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

		ESFGun esfGun = null;
		
		try {
			esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		entries.add(esfGun);
	}
	
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= entries %>"
		total="<%= entries.size() %>"
	/>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFGun"
		keyProperty="esfGunId" modelVar="esfGun" escapedModel="<%=true%>">

		<liferay-ui:search-container-column-text name="name" value="<%= ESFGunLocalServiceUtil.getFullName(esfGun)  %>" />
		<liferay-ui:search-container-column-text name="owner" value="<%= UserLocalServiceUtil.getUser(esfGun.getEsfUserId()).getFullName() %>"/>
		<liferay-ui:search-container-column-text property="code" />

		<liferay-ui:search-container-column-jsp
			path="/html/esfgun/esfGun_actions.jsp" align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
	if (Validator.isNotNull(keywords)) {
		String currentURL = PortalUtil.getCurrentURL(request);
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(
				pageContext, "search") + ": " + keywords, currentURL);
	}
%>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.esfgun.view_search_jsp");
%>
