<%@page import="it.ethica.esf.service.persistence.ESFShootingDirectorQualificationUtil"%>
<%@include file="init.jsp"%>

<%
long shDrqId = ParamUtil.getLong(request, "shDrqId");

String descQual = "";  
String buttonLabel = "add";

if(0 < shDrqId){
	descQual = ESFShootingDirectorQualificationUtil.fetchByPrimaryKey(shDrqId).getEsfShootingDirectorQualificationDesc();
	buttonLabel = "Edit";
}
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<portlet:actionURL name="addShooterDirectorQualifications" var="addShooterDirectorQualificationsURL">
	<portlet:param name="shDrqId"
		value="<%=String.valueOf(shDrqId)%>" />
</portlet:actionURL>

<aui:form action="<%=addShooterDirectorQualificationsURL%>" name="<portlet:namespace />fm" >

	<aui:input name="shDrqDesc" type="text" label="description" value="<%=descQual %>"/>
	<aui:button type="<%=buttonLabel %>" value="<%=buttonLabel%>" />
	<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>
</aui:form>