<%@include file="/addressadmin/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/addressadmin/html/search_esfAddress.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/addressadmin/view.jsp" />
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
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(ESFAddress.class);
	Hits hits = indexer.search(searchContext);
	
	List<ESFAddress> entries = new ArrayList<ESFAddress>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);

		long esfAddressId = GetterUtil
		.getLong(doc.get(Field.ENTRY_CLASS_PK));

		ESFAddress esfAddress = null;
		
		try {
			esfAddress = ESFAddressLocalServiceUtil.getESFAddress(esfAddressId);
		} catch (PortalException pe) {
				pe.getLocalizedMessage();
		} catch (SystemException se) {
				se.getLocalizedMessage();
		}
		
		entries.add(esfAddress);
	}
	
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= entries %>"
		total="<%= entries.size() %>"
	/>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFAddress"
		keyProperty="esfAddressId" modelVar="ESFAddress" escapedModel="<%=true%>">

		<portlet:renderURL var="viewESFAddress">
			<portlet:param name="mvcPath"
				value="/addressadmin/html/view_esfAddress.jsp" />
			<portlet:param name="esfAddressId"
				value="<%=String.valueOf(ESFAddress.getEsfAddressId())%>" />
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-text property="longitude"
			href="<%=viewESFAddress%>" />

		<liferay-ui:search-container-column-text property="latitude"
			href="<%=viewESFAddress%>" />

		<liferay-ui:search-container-column-text name="region"
			value="<%=ESFAddressLocalServiceUtil.getNameRegion(ESFAddress.getEsfRegionId())%>"
			href="<%=viewESFAddress%>" />
		
		<input name="esfRegionId" type="hidden"
			value="<%=ESFAddressLocalServiceUtil.getNameRegion(ESFAddress.getEsfRegionId())%>" />
		
		<liferay-ui:search-container-column-text name="province"
			value="<%=ESFAddressLocalServiceUtil.getNameProvince(
						ESFAddress.getEsfRegionId(),
						ESFAddress.getEsfProvinceId())%>"
			href="<%=viewESFAddress%>" />
		
		<input name="esfProvinceId" type="hidden"
			value="<%=ESFAddressLocalServiceUtil.getNameProvince(
						ESFAddress.getEsfRegionId(),
						ESFAddress.getEsfProvinceId())%>" />
		
		<liferay-ui:search-container-column-text name="city"
			value="<%=ESFAddressLocalServiceUtil.getNameCity(
						ESFAddress.getEsfRegionId(),
						ESFAddress.getEsfProvinceId(),
						ESFAddress.getEsfCityId())%>"
			href="<%=viewESFAddress%>" />
		
		<input name="esfCityId" type="hidden"
			value="<%=ESFAddressLocalServiceUtil.getNameCity(
						ESFAddress.getEsfRegionId(),
						ESFAddress.getEsfProvinceId(),
						ESFAddress.getEsfCityId())%>" />

		<liferay-ui:search-container-column-jsp
			path="/addressadmin/html/esfAddress_actions.jsp" align="right" />
			
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
