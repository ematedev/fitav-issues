<%@include file="init.jsp"%>
<%
	String name = ParamUtil.getString(request, "name");
%>

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

		<aui:form action="<%=searchURL%>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="search-form">
				<span class="aui-search-bar"> <aui:input
						inlineField="<%=true%>" label="" name="name"
						placeholder="title" size="30" title="search-entries" type="text" />
				</span>
				<aui:button type="submit" value="search" />
			</div>
		</aui:form>
		
				<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results>
			
			<% 
			List<ESFSportType> esfSportTypeResults =  ESFSportTypeLocalServiceUtil.findESFSportTypeByName(name);
			pageContext.setAttribute("results", esfSportTypeResults); 
			%>	
			
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFSportType" modelVar="esfSportType">

					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="code" />
					<liferay-ui:search-container-column-text property="description" />
					<%
						String National = "";
											if (esfSportType.getNational()) {
												National = "yes";
											} else {
												National = "no";
											}
					%>
					<liferay-ui:search-container-column-text name="national" value="<%=res.getString(National) %>"/>
										<%
						String isOlimpic = "";
											if (esfSportType.getIsOlimpic()) {
												isOlimpic = "yes";
											} else {
												isOlimpic = "no";
											}
					%>
					<liferay-ui:search-container-column-text name="olimpicSport" value="<%=res.getString(isOlimpic) %>"/>

<c:if test="<%= ESFSportTypePermission.contains(permissionChecker,esfSportType.getEsfSportTypeId(), scopeGroupId, ActionKeys.ESFSPORTTYPE_VIEW_ACTION) %>">

					<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfSportType_actions.jsp"%>'
				 			align="right" />
</c:if>
			
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>