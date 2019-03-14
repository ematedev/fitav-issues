<%@include file="/html/init.jsp"%>

<%
    String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/esfdocuments/view_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/esfdocuments/view.jsp" />
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
	SearchContext searchContext = SearchContextFactory.getInstance(request);
	
	searchContext.setKeywords(keywords);
	searchContext.setAttribute("paginationType", "more");
	searchContext.setStart(0);
	searchContext.setEnd(10);
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(ESFDocument.class);
	
	Hits hits = indexer.search(searchContext);
	
	List<ESFDocument> esfDocuments = new ArrayList<ESFDocument>();
	
	for (int i = 0; i < hits.getDocs().length; i++) {
	        Document doc = hits.doc(i);
	
	        long esfDocumentId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
	
	        ESFDocument esfDocument = null;
	
	        try {
	        	esfDocument = ESFDocumentLocalServiceUtil.getESFDocument(esfDocumentId);
	        } catch (PortalException pe) {
	                _log.error(pe.getLocalizedMessage());
	        } catch (SystemException se) {
	                _log.error(se.getLocalizedMessage());
	        }
	
	        esfDocuments.add(esfDocument);
	}
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-documents-were-found">
        <liferay-ui:search-container-results
                results="<%= esfDocuments %>"
                total="<%= esfDocuments.size() %>"
        />

        <liferay-ui:search-container-row
                className="it.ethica.esf.model.ESFDocument"
                keyProperty="esfDocumentId" modelVar="esfDocument" escapedModel="<%=true%>">

                <liferay-ui:search-container-column-text property="name" />

                <liferay-ui:search-container-column-text property="number" />
                
                <liferay-ui:search-container-column-text property="userEmail" />
                
                <liferay-ui:search-container-column-jsp
            path="/html/esfdocuments/esfdocument_actions.jsp"
            align="right" />
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
        if (Validator.isNotNull(keywords)) {
                String currentURL = PortalUtil.getCurrentURL(request);
                PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
        }
%>

<%!
        private static Log _log = LogFactoryUtil.getLog("docroot.html.esfdocuments.view_search_jsp");
%>