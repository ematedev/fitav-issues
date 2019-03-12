<%@include file="../init.jsp" %>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/esfuseradmin/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	    
	<div class="search-form">
		<span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-users" type="text" />

            <aui:button type="submit" value="search" />
        </span>
	</div>
</aui:form>