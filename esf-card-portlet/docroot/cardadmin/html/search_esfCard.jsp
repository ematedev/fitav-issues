<%@include file="/cardadmin/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/cardadmin/html/search_esfCard.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/cardadmin/view.jsp" />
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
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(ESFCard.class);
	System.out.println(indexer);
	Hits hits = indexer.search(searchContext);
	
	List<ESFCard> entries = new ArrayList<ESFCard>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);

		long esfCardId = GetterUtil
		.getLong(doc.get(Field.ENTRY_CLASS_PK));

		ESFCard esfCard = null;
		
		try {
			esfCard = ESFCardLocalServiceUtil.getESFCard(esfCardId);
		} catch (PortalException pe) {
				pe.getLocalizedMessage();
		} catch (SystemException se) {
				se.getLocalizedMessage();
		}
		
		entries.add(esfCard);
	}
	
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= entries %>"
		total="<%= entries.size() %>"
	/>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFCard"
		keyProperty="esfCardId" modelVar="ESFCard" escapedModel="<%=true%>">

		<portlet:renderURL var="viewESFCard">
			<portlet:param name="mvcPath"
				value="/cardadmin/html/view_esfCard.jsp" />
			<portlet:param name="esfCardId"
				value="<%=String.valueOf(ESFCard.getEsfCardId())%>" />
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-text property="code"
			href="<%=viewESFCard%>" />

		<liferay-ui:search-container-column-text name="startDate"
			value="<%=ConvertDateCal.DateToString(ESFCard.getStartDate())%>"
			href="<%=viewESFCard%>" />

		<liferay-ui:search-container-column-text name="endDate"
			value="<%=ConvertDateCal.DateToString(ESFCard.getEndDate())%>"
			href="<%=viewESFCard%>" />

		<liferay-ui:search-container-column-jsp
			path="/cardadmin/html/esfCard_actions.jsp" align="right" />
			
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
