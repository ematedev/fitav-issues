<%@include file="/tooladmin/init.jsp"%>

<%
	ESFTool esfTool = null;
	
long esfToolId = ParamUtil.getLong(request, "esfToolId");

if(esfToolId > 0){
	esfTool = ESFToolLocalServiceUtil.getESFTool(esfToolId); 
}

%>

<portlet:renderURL var="viewURL" windowState="<%= WindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/tooladmin/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL
	name='<%=esfTool== null ? "addESFTool" : "updateESFTool"%>'
	var="editESFToolURL" />

<aui:form action="<%=editESFToolURL%>"
	name="<portlet:namespace />fm">
	
	<aui:model-context bean="<%= esfTool %>" model="<%= ESFTool.class %>" />
	<aui:fieldset>
		<aui:input type="hidden" name="esfToolId"
			value='<%=esfTool == null
						? "" : esfTool.getEsfToolId()%>' />
		<aui:input name="code"
			value='<%=esfTool == null
						? "" : esfTool.getCode()%>' >
		 <aui:validator name="required" errorMessage="Please enter the code." />
		</aui:input>				
		<aui:input name="name"
			value='<%=esfTool == null
						? "" : esfTool.getName()%>' >
		</aui:input>
		<aui:input name="description"
			value='<%=esfTool == null
						? "" : esfTool.getDescription()%>' >
		</aui:input>

	</aui:fieldset>

	<liferay-ui:asset-categories-error />
	<liferay-ui:asset-tags-error />
	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryCategorizationPanel" persistState="<%=true%>"
		title="categorization">
		<aui:fieldset>
			<aui:input name="categories" type="assetCategories" />

			<aui:input name="tags" type="assetTags" />
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryAssetLinksPanel" persistState="<%=true%>"
		title="related-assets">
		<aui:fieldset>
			<liferay-ui:input-asset-links
				className="<%=ESFTool.class.getName()%>" classPK="<%=esfToolId%>" />
		</aui:fieldset>
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>