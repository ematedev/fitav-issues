<%@include file="/tooladmin/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
%>


<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/tooladmin/html/search_esfTool.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/tooladmin/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />

	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%= true %>" label="" name="keywords" size="30"
				title="search-entries" type="text" /> <aui:button type="submit"
				value="search" />
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
// 	searchContext.setLike(true);
	Indexer indexer = IndexerRegistryUtil.getIndexer(ESFTool.class);
	Hits hits = indexer.search(searchContext);
	
	List<ESFTool> entries = new ArrayList<ESFTool>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);

		long esfToolId = GetterUtil
		.getLong(doc.get(Field.ENTRY_CLASS_PK));

		ESFTool esfTool = null;
		
		try {
			esfTool = ESFToolLocalServiceUtil.getESFTool(esfToolId);
		} catch (PortalException pe) {
				pe.getLocalizedMessage();
		} catch (SystemException se) {
				se.getLocalizedMessage();
		}
		
		entries.add(esfTool);
	}
	
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= entries %>"
		total="<%= entries.size() %>"
	/>
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFTool" keyProperty="esfToolId"
		modelVar="ESFTool" escapedModel="<%=true%>">

		<portlet:renderURL var="viewESFTool">
			<portlet:param name="mvcPath"
				value="/tooladmin/html/view_esfTool.jsp" />
			<portlet:param name="esfToolId"
				value="<%=String.valueOf(ESFTool.getEsfToolId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="code"
			href="<%=viewESFTool%>" />

		<liferay-ui:search-container-column-text property="name"
			href="<%=viewESFTool%>" />

		<liferay-ui:search-container-column-text property="description"
			href="<%=viewESFTool%>" />

		<liferay-ui:search-container-column-jsp
			path="/tooladmin/html/esfTool_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>