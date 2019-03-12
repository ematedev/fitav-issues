<%@include file="init.jsp" %>

<portlet:renderURL var="addESFTypeURL">
	<portlet:param name="mvcPath" value="/html/portlet/esftypeadmin/edit_type.jsp"/>
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addESFTypeURL.toString() %>" value="add-type"/>
</aui:button-row>  

<%
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-ui:search-container
	emptyResultsMessage="no-result"
>
	<%
	List<ESFType> res = null;
	int tot = 0;
	if(keywords != null && !keywords.isEmpty()) {
		
		SearchContext searchContext = SearchContextFactory.getInstance(request);
		
		searchContext.setKeywords(keywords);
		searchContext.setAttribute("paginationType", "more");
		searchContext.setStart(0);
		searchContext.setEnd(10);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(ESFType.class);
		
		Hits hits = indexer.search(searchContext);
		
		List<ESFType> esfTypes = new ArrayList<ESFType>();
		
		for (int i = 0; i < hits.getDocs().length; i++) {
	        Document doc = hits.doc(i);
	
	        long esfTypeId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
	
	        ESFType esfType = null;
	
	        try {
	        	esfType = ESFTypeLocalServiceUtil.getESFType(esfTypeId);
	        } catch (PortalException pe) {
	                _log.error(pe.getLocalizedMessage());
	        } catch (SystemException se) {
	                _log.error(se.getLocalizedMessage());
	        }
	
	        esfTypes.add(esfType);
		}
		res = esfTypes;
		tot = esfTypes.size();
	} else {
		res = ESFTypeLocalServiceUtil.getESFTypes(searchContainer.getStart(), searchContainer.getEnd());
		tot = ESFTypeLocalServiceUtil.getESFTypesCount();	
	}
	%>
	<liferay-ui:search-container-results
		results="<%= res %>"
		total="<%= tot %>"
	/>
	
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFType"
		modelVar="esfType"		
	>	
	
		<liferay-ui:search-container-column-text property="esfTypeId" />
		
		<liferay-ui:search-container-column-text property="name" />
		
		<liferay-ui:search-container-column-text property="status" />
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.esfuseradmin.view_jsp");
%>
