<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@include file="/useradmin/init.jsp"%>

<%
String keywords = ParamUtil.getString(request, "keywords");
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath + "view_search.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />

	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-users" type="text" />
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
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-documents-were-found">

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" keyProperty="esfUserId"
		modelVar="esfUser" escapedModel="<%=true%>">

		<liferay-ui:search-container-column-text property="firstName" />

		<liferay-ui:search-container-column-text property="lastName" />

		<liferay-ui:search-container-column-text property="screenName" />

		<liferay-ui:search-container-column-text property="userEmail" />

		<liferay-ui:search-container-column-text name="createDate"
			value="<%=dateFormat.format(esfUser.getOriginalUser().getCreateDate())%>" />

		<liferay-ui:search-container-column-text name="birthday"
			value="<%=dateFormat.format(esfUser.getBirthday())%>" />

		<liferay-ui:search-container-column-jsp
			path="/html/esfuseradmin/user_actions.jsp" align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
	if (Validator.isNotNull(keywords)) {
		String currentURL = PortalUtil.getCurrentURL(request);
		PortalUtil.addPortletBreadcrumbEntry(
			request, LanguageUtil.get(pageContext, "search") + ": " +
				keywords, currentURL);
	}
%>

<%!private static Log _log =
		LogFactoryUtil.getLog("docroot.html.esfuseradmin.view_search_jsp");%>