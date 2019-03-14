<%@ include file="init.jsp" %>

<% String tabs1 = ParamUtil.getString(request, "tabs1", "candidates"); %>

<portlet:renderURL var="tabURL">
	<portlet:param name="tabs1" value="<%= tabs1 %>"/>
</portlet:renderURL>

<portlet:renderURL var="searchURL">
	<portlet:param name="tabs1" value="all-shooters"/>
</portlet:renderURL>

<portlet:actionURL name="chooseCandidate" var="chooseCandidateURL"/>

<liferay-ui:tabs
	names="candidates,all-shooters"
	refresh="<%= true %>"
	url="<%= tabURL %>"
>
	<liferay-ui:section>
		<%@ include file="view_candidate.jsp" %>
	</liferay-ui:section>

	<liferay-ui:section>
		<h3>
			<liferay-ui:message key="available-shooters"></liferay-ui:message>
		</h3>
		
		<aui:form method="post" action="<%= searchURL %>" name="fmSearch">
			<aui:input inlineField="true" name="search" label="shooter-name-or-surname" />
			<aui:button type="submit"></aui:button>
		</aui:form>
		
		<aui:form method="post" action="<%= chooseCandidateURL %>" name="fmChoose">
			<p class="lead">
				<liferay-ui:message key="man"></liferay-ui:message>
			</p>
			<%@ include file="view_man.jsp" %>
			<div class="separator"></div>

			<p class="lead">
				<liferay-ui:message key="man-junior"></liferay-ui:message>
			</p>
			<%@ include file="view_man_junior.jsp" %>
			<div class="separator"></div>

			<p class="lead">
				<liferay-ui:message key="lady"></liferay-ui:message>
			</p>
			<%@ include file="view_lady.jsp" %>
			<div class="separator"></div>

			<p class="lead">
				<liferay-ui:message key="lady-junior"></liferay-ui:message>
			</p>
			<%@ include file="view_lady_junior.jsp" %>
			<div class="separator"></div>

			<aui:button type="submit"></aui:button>
		</aui:form>

	</liferay-ui:section>

</liferay-ui:tabs>

