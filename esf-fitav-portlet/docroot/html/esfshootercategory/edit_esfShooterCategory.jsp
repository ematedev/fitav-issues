<%@ include file="init.jsp" %>

<%
long esfShooterCategoryId = ParamUtil.getLong(request, "esfShooterCategoryId");

ESFShooterCategory esfShooterCategory = null;

if (esfShooterCategoryId > 0) {

	esfShooterCategory = ESFShooterCategoryLocalServiceUtil
			.getESFShooterCategory(esfShooterCategoryId);
}

if(Validator.isNotNull(esfShooterCategory)){
	String shooterCategory = esfShooterCategory.getName();
	String[] shooterCategoryName = {shooterCategory};
%>
<h4><b><liferay-ui:message key="update-shooterCategory-x" arguments="<%= shooterCategoryName%>"/></b>
				<div class="separator"></div>
<%	
}else{
%>	
<h4><b><liferay-ui:message key="add-new-shooterCategory" /></b>
				<div class="separator"></div>
<%
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