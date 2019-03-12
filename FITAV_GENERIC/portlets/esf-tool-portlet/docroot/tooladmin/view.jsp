<%@include file="/tooladmin/init.jsp"%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/tooladmin/html/search_esfTool.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%=true%>" label="" name="keywords" size="30"
				title="search-entries" type="text" /> <aui:button type="submit"
				value="search" />
		</span>
	</div>
</aui:form>
<liferay-ui:success key="addESFToolMess" message="message-add-tool"/>
<c:if
	test='<%=ESFToolModelPermission.contains(
					permissionChecker, scopeGroupId, ESFToolActionKeys.ADD_ESFTOOL)%>'>
	<aui:button-row cssClass="esfTool-admin-buttons">
		<portlet:renderURL var="addESFToolURL" windowState="<%=WindowState.MAXIMIZED.toString()%>">
			<portlet:param name="mvcPath" value="/tooladmin/html/edit_esfTool.jsp" />
		</portlet:renderURL>
	
		<aui:button onClick="<%= addESFToolURL.toString()%>" value="Add Tool" />
	</aui:button-row>
</c:if>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
			results="<%= ESFToolLocalServiceUtil.getESFTools(
							searchContainer.getStart(),
							searchContainer.getEnd()) %>"
			total="<%= ESFToolLocalServiceUtil.getESFToolsCount() %>" />
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFTool" modelVar="esfTool">

		<portlet:renderURL var="viewESFTool">
			<portlet:param name="mvcPath"
				value="/tooladmin/html/view_esfTool.jsp" />
			<portlet:param name="esfToolId"
				value="<%=String.valueOf(esfTool.getEsfToolId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="code"
			href="<%=viewESFTool%>" />

		<liferay-ui:search-container-column-text property="name"
			href="<%=viewESFTool%>" />

		<liferay-ui:search-container-column-text property="description"
			href="<%=viewESFTool%>" />

		<liferay-ui:search-container-column-jsp
			path="/tooladmin/html/esfTool_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>