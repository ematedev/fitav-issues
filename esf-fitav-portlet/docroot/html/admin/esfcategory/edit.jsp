<%@ include file="init.jsp" %>

<%
long esfCategoryId = ParamUtil.getLong(request, "esfCategoryId", -1);

ESFCategory esfCategory = null;
if (esfCategoryId >= 0) {
	esfCategory = ESFCategoryLocalServiceUtil.getESFCategory(esfCategoryId);
}
%>
<liferay-portlet:renderURL var="homeURL"></liferay-portlet:renderURL>
<liferay-ui:header
	backURL="<%= homeURL %>"
	title='<%= (esfCategory == null) ? "new-article" : esfCategory.getName() %>'
/>

<liferay-portlet:actionURL name="updateESFCategory" var="updateESFCategoryURL" />

<aui:form action="<%= updateESFCategoryURL %>" method="post" name="fm">
	<aui:input name="esfCategoryId" type="hidden" value="<%= esfCategoryId %>" />
	<aui:fieldset>
		<aui:input name="name" value="<%= (esfCategory == null)?StringPool.BLANK:esfCategory.getName() %>" />
		<aui:input name="description" value="<%= (esfCategory == null)?StringPool.BLANK:esfCategory.getDescription() %>" />
		
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" href="<%= redirect %>" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>