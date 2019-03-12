<%@ include file="init.jsp" %>

<%
long esfShooterCategoryId = ParamUtil.getLong(request, "esfShooterCategoryId");

ESFShooterCategory esfShooterCategory = null;

if (esfShooterCategoryId > 0) {

	esfShooterCategory = ESFShooterCategoryLocalServiceUtil
			.getESFShooterCategory(esfShooterCategoryId);
}
%>

<portlet:actionURL name="editESFShooterCategory" var="editESFShooterCategoryURL" />

<aui:form method="post" action="<%= editESFShooterCategoryURL %>">

	<aui:model-context bean="<%= esfShooterCategory %>" model="<%= ESFShooterCategory.class %>" />

	<aui:input name="esfShooterCategoryId" type="hidden"></aui:input>
	<aui:input name="code"></aui:input>
	<aui:input name="name"></aui:input>
	<aui:input name="description"></aui:input>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>" ></aui:button>
	</aui:button-row>

</aui:form>