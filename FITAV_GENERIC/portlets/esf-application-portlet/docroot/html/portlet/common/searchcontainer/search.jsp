<%@include file="/html/portlet/init.jsp" %>
<%--

NB. Provide a valid portletURL in the caller JSP named 'searchURL'

 --%>

<aui:form action="<%= searchURL %>" method="get" name="<portlet:namespace />search_form">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	    
	<div class="search-form">
		<span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search" type="text" />

            <aui:button type="submit" value="search" />
            <aui:button onClick="<%= searchURL.toString() %>" value="show-all" />
        </span>
	</div>
</aui:form>
