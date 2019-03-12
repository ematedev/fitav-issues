<%@ include file="init.jsp" %>

<%
long esfShooterQualificationId = ParamUtil.getLong(request, "esfShooterQualificationId");

ESFShooterQualification esfShooterQualification = null;

if (esfShooterQualificationId > 0) {

	esfShooterQualification = ESFShooterQualificationLocalServiceUtil
			.getESFShooterQualification(esfShooterQualificationId);
}

if(Validator.isNotNull(esfShooterQualification)){
	String qualification = esfShooterQualification.getName();
	String[] qualificationName = {qualification};
%>
<h4><b><liferay-ui:message key="update-qualification-x" arguments="<%= qualificationName%>"/></b>
			<div class="separator"></div>
<% 
	
}else{
%>
<h4><b><liferay-ui:message key="add-new-qualification" /></b>
			<div class="separator"></div>
<%
}
%>


<portlet:actionURL name="editESFShooterQualification" var="editESFShooterQualificationURL" />

<aui:form method="post" action="<%= editESFShooterQualificationURL %>">

	<aui:model-context bean="<%= esfShooterQualification %>" model="<%= ESFShooterQualification.class %>" />

	<aui:input name="esfShooterQualificationId" type="hidden"></aui:input>
	<aui:input name="code"></aui:input>
	<aui:input name="name"></aui:input>
	<aui:input name="description"></aui:input>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>" ></aui:button>
	</aui:button-row>

</aui:form>