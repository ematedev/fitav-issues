<%@ include file="init.jsp" %>

<%
long esfUserCategoryId = ParamUtil.getLong(request, "esfUserCategoryId", -1);

ESFUserCategory esfUserCategory = null;
if (esfUserCategoryId >= 0) {
	esfUserCategory = ESFUserCategoryLocalServiceUtil.getESFUserCategory(esfUserCategoryId);
}

long esfUserId = 0;
long esfCategoryId = 0;
long esfSportTypesId = 0;
if (Validator.isNotNull(esfUserCategory)) {
	esfUserId = esfUserCategory.getEsfUserId();
	esfCategoryId = esfUserCategory.getEsfUserId();
	esfSportTypesId = esfUserCategory.getEsfSportTypeId();
}
%>
<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='/html/admin/esfusercategory/view.jsp' />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="updateESFUserCategory" var="updateESFUserCategoryURL" />

<aui:form action="<%= updateESFUserCategoryURL %>" method="post" name="fm">
	<aui:input name="esfUserCategoryId" type="hidden" value="<%= esfUserCategoryId %>" />
	<aui:fieldset>
		<aui:input name="users" inlineField="<%= true %>" value="<%= Validator.isNotNull(esfUserId)?UserLocalServiceUtil.getUserById(esfUserId).getScreenName():StringPool.BLANK %>"/>
		<aui:input name="esfUserId" type="hidden" value="<%= esfUserId %>"/>
		
		<%
		List<ESFCategory> esfCategories = ESFCategoryLocalServiceUtil.getESFCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		if (!esfCategories.isEmpty()) {
		%>
			<aui:select inlineField="<%= true %>" name="esfCategoryId" label="esf-category">
			<%
			for (ESFCategory esfCategory : esfCategories) {
			%>
				<aui:option value="<%= esfCategory.getEsfCategoryId() %>" label="<%= esfCategory.getName() %>" selected="<%= esfCategory.getEsfCategoryId() == esfCategoryId %>" />
			<%
			}
			%>
			</aui:select>
		<%
		}
		%>
		
		<%
		List<ESFSportType> esfSportTypes = ESFSportTypeLocalServiceUtil.getESFSportTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		if (!esfSportTypes.isEmpty()) {
		%>
			<aui:select inlineField="<%= true %>" name="esfSportTypeId" label="esf-sporttype">
			<%
			for (ESFSportType esfSportType : esfSportTypes) {
			%>
				<aui:option value="<%= esfSportType.getEsfSportTypeId() %>" label="<%= esfSportType.getName() %>" selected="<%= esfSportType.getEsfSportTypeId() == esfSportTypesId %>" />
			<%
			}
			%>
			</aui:select>
		<%
		}
		%>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" href="<%= backURL %>" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>
<liferay-portlet:resourceURL id="autocomplete" var="autocompleteURL" />

<aui:script use="autocomplete-list,datasource-io">
var datasource = new A.DataSource.IO({
	source: '<%=autocompleteURL%>'
});

var autoComplete = new A.AutoCompleteList({
	allowBrowserAutocomplete: false,
	activateFirstItem: true,
	inputNode: '#<portlet:namespace />users',
	maxResults: 10,
	on: {
		select: function(event) {
			var result = event.result.raw;
			A.one('#<portlet:namespace/>esfUserId').val(result.classNameId);
		}
	},
	render: true,
	source: datasource,
	requestTemplate: '&<portlet:namespace />keywords={query}',
	resultListLocator: function (response) {
		var responseData = A.JSON.parse(response[0].responseText);
		return responseData.response;
	},
	resultTextLocator: function (result) {
		return result.value;
	},
	width: 400
});
</aui:script>