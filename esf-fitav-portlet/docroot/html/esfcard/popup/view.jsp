

<%@include file="init.jsp"%>


<%
String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());

String code = ParamUtil.getString(request, "code");
String name = ParamUtil.getString(request, "name");

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter("mvcPath", templatePath+"popup/view.jsp");
viewassURL.setParameter("code", code);
viewassURL.setParameter("name", name);

%>

<liferay-portlet:renderURL varImpl="searchURL"  windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value='<%=templatePath+"popup/view.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL.toString()%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
		<aui:input inlineField="<%=true%>" name="name"
			placeholder="name" size="30" title="search-entries" type="text" />
		<aui:input inlineField="<%=true%>" name="code"
			placeholder="code" size="30" title="search-entries" type="text" />
		<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>


	<liferay-ui:search-container delta="5" emptyResultsMessage="no-results" iteratorURL="<%=viewassURL%>">

	<liferay-ui:search-container-results
		results="<%=ESFOrganizationLocalServiceUtil.
				findByT_C_N(ESFKeys.ESFOrganizationTypeId.ASSOCIATION, 
				code, name, currentOrganizationId,searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFOrganizationLocalServiceUtil.
				countByT_C_N(ESFKeys.ESFOrganizationTypeId.ASSOCIATION, 
						code, name, currentOrganizationId)%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganization">

		<liferay-ui:search-container-column-text name="name"/>

		<liferay-ui:search-container-column-text name="code"/>

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "popup/choose_association.jsp"%>'
			align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

