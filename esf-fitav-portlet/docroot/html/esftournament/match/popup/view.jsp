<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp"%>

<%

String code = ParamUtil.getString(request, "code");

String namespace = renderResponse.getNamespace();

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter(
	"mvcPath", "/html/esftournament/match/popup/view.jsp");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='/html/esftournament/match/popup/view.jsp' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL.toString()%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
		<aui:input inlineField="<%=true%>" name="code"
			placeholder="code" size="30" title="search-entries" type="text" /> 
		<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%= portletURL%>">

	<liferay-ui:search-container-results
		results="<%= ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(
				currentOrganizationId, code, ESFKeys.ESFStateType.ENABLE,
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(
				currentOrganizationId, code, ESFKeys.ESFStateType.ENABLE).size()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganization">

		<liferay-ui:search-container-column-text name="name"/>

		<liferay-ui:search-container-column-text name="code"/>

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath +
						"match/popup/choose_association.jsp"%>'
			align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>