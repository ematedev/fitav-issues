<%@ include file="init.jsp"%>
<%
	String key = ParamUtil.getString(request, "key");
%>

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

		<aui:form action="<%=searchURL%>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="search-form">
				<span class="aui-search-bar"> <aui:input
						inlineField="<%=true%>" label="" name="key"
						placeholder="Key" size="30" title="search-entries" type="text" />
				</span>
				<aui:button type="submit" value="search" />
			</div>
		</aui:form>
		
				<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results>
			
			<% 
			List<ESFConfiguration> esfConfigurationResults =  ESFConfigurationLocalServiceUtil.findESFConfigurationTypeByKey(key);
			pageContext.setAttribute("results", esfConfigurationResults); 
			%>	
			
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFConfiguration" modelVar="esfConfiguration">
					<liferay-ui:search-container-column-text property="key" />
					<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfConfiguration_actions.jsp"%>'
				 			align="right" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>