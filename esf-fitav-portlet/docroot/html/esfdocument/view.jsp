<%@ include file="init.jsp"%>

<% 
	List<ESFDocument> esfUserDocuments = ESFDocumentLocalServiceUtil.
													findByesfUserId(esfUserId);
	
%>

<portlet:renderURL var="addESFDocumentURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "edit_esfDocument.jsp"%>' />
</portlet:renderURL>

<liferay-ui:error key="esfDocument-reference-error"
	message="esfDocument-reference-error" />

<aui:button onClick="<%= addESFDocumentURL.toString()%>"
	value="add-Document" />

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%=esfUserDocuments%>"
		total="<%=esfUserDocuments.size()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFDocument" modelVar="esfDocument">

		<liferay-ui:search-container-column-text property="type" name="Type" />

		<liferay-ui:search-container-column-text property="code" name="Code" />

		<liferay-ui:search-container-column-text property="releasedBy"
			name="ReleasedBy" />

		<liferay-ui:search-container-column-text name="ReleaseDate"
			value="<%=ManageDate.DateToString(esfDocument.getReleaseDate())%>" />

		<liferay-ui:search-container-column-text name="ExpirationDate"
			value="<%=ManageDate.DateToString(esfDocument.getExpirationDate())%>" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfDocument_action.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>