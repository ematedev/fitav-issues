<%@ include file="/html/init.jsp" %>

<portlet:renderURL var="addESFDocumentURL">
	<portlet:param name="mvcPath" value="/html/esfdocuments/edit_esfdocument.jsp"/>
</portlet:renderURL>

<aui:button onClick="<%= addESFDocumentURL.toString() %>" value="Add Document" />

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/esfdocuments/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="<portlet:namespace/>fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input name="keywords" inlineField="<%= true %>" label="" size="30" title="search-documents" type="text" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= ESFDocumentLocalServiceUtil.getESFDocuments(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFDocumentLocalServiceUtil.getESFDocumentsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFDocument"
		modelVar="esfDocument"
	>
	
		<liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-text property="number" />
		
		<liferay-ui:search-container-column-text property="userEmail" />

		<liferay-ui:search-container-column-jsp path="/html/esfdocuments/esfdocument_actions.jsp" />
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>