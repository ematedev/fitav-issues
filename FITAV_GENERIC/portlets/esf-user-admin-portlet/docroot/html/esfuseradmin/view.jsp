<%@include file="../init.jsp" %>

<h2><liferay-ui:message key="esf-users-list"></liferay-ui:message></h2>

<%@include file="search_user.jsp" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/esfuseradmin/view.jsp" />
</portlet:renderURL>

<% if (ESFUserPermission.contains(permissionChecker, scopeGroupId, 0, ActionKeys.ADD_ESFUSER)) { %>

<portlet:renderURL var="addESFUserURL">
	<portlet:param name="mvcPath" value="/html/esfuseradmin/edit_user.jsp"/>	
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addESFUserURL.toString() %>" value="Add User"/>	
</aui:button-row>

<% } %>

<%
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-ui:search-container
	emptyResultsMessage="no-result"
>
	<%
	List<ESFUser> res = null;
	int tot = 0;
	if(keywords != null && !keywords.isEmpty()) {
		
		SearchContext searchContext = SearchContextFactory.getInstance(request);
		
		searchContext.setKeywords(keywords);
		searchContext.setAttribute("paginationType", "more");
		searchContext.setStart(0);
		searchContext.setEnd(10);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(ESFUser.class);
		
		Hits hits = indexer.search(searchContext);
		
		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		
		for (int i = 0; i < hits.getDocs().length; i++) {
	        Document doc = hits.doc(i);
	
	        long esfUserId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
	
	        ESFUser esfUser = null;
	
	        try {
	        	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
	        } catch (PortalException pe) {
	                _log.error(pe.getLocalizedMessage());
	        } catch (SystemException se) {
	                _log.error(se.getLocalizedMessage());
	        }
	
	        esfUsers.add(esfUser);
		}
		res = esfUsers;
		tot = esfUsers.size();
	} else {
		res = ESFUserLocalServiceUtil.getESFUsers(searchContainer.getStart(), searchContainer.getEnd());
		tot = ESFUserLocalServiceUtil.getESFUsersCount();		
	}
	%>
	<liferay-ui:search-container-results
		results="<%= res %>"
		total="<%= tot %>"
	/>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser"
		modelVar="esfUser"		
	>		
		<liferay-ui:search-container-column-text property="firstName" />
		
		<liferay-ui:search-container-column-text property="lastName" />
		
		<liferay-ui:search-container-column-text property="screenName" />		
		
		<liferay-ui:search-container-column-text property="userEmail" />
		
		<liferay-ui:search-container-column-text name="createDate" value="<%= dateFormat.format(esfUser.getCreateDate()) %>" />
		
		<liferay-ui:search-container-column-text name="birthday" value="<%= dateFormat.format(esfUser.getBirthday()) %>" />
		
		<% if(ESFUserPermission.contains(permissionChecker, scopeGroupId, esfUser.getEsfUserId(), ActionKeys.UPDATE_ESFUSER) 
				|| ESFUserPermission.contains(permissionChecker, scopeGroupId, esfUser.getEsfUserId(), ActionKeys.DELETE_ESFUSER)) { %>
		
		<liferay-ui:search-container-column-jsp path="/html/esfuseradmin/user_actions.jsp" />
		
		<% } %>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.esfuseradmin.view_jsp");
%>