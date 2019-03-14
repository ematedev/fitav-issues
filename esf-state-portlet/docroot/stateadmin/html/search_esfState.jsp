<%@include file="/stateadmin/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
%>


<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/stateadmin/html/search_esfState.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/stateadmin/view.jsp" />
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
	searchContext.setLike(true);
	Indexer indexer = IndexerRegistryUtil.getIndexer(ESFState.class);
	Hits hits = indexer.search(searchContext);
	
	List<ESFState> entries = new ArrayList<ESFState>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);

		long esfStateId = GetterUtil
		.getLong(doc.get(Field.ENTRY_CLASS_PK));

		ESFState esfState = null;
		
		try {
			esfState = ESFStateLocalServiceUtil.getESFState(esfStateId);
		} catch (PortalException pe) {
				pe.getLocalizedMessage();
		} catch (SystemException se) {
				se.getLocalizedMessage();
		}
		
		entries.add(esfState);
	}
	
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= entries %>"
		total="<%= entries.size() %>"
	/>
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFState" keyProperty="esfStateId"
		modelVar="ESFState" escapedModel="<%=true%>">

		<portlet:renderURL var="viewESFState">
			<portlet:param name="mvcPath"
				value="/stateadmin/html/view_esfState.jsp" />
			<portlet:param name="esfStateId"
				value="<%=String.valueOf(ESFState.getEsfStateId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="esfName"
			href="<%=viewESFState%>" />

		<liferay-ui:search-container-column-text property="esfDescription"
			href="<%=viewESFState%>" />

		<liferay-ui:search-container-column-jsp
			path="/stateadmin/html/esfState_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>