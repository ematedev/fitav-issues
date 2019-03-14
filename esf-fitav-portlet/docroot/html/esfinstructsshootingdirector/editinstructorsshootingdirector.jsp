<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@include file="init.jsp"%>

<%
long ishDrId = ParamUtil.getLong(request, "ishDrId");

String descIstr = "";
String codeIstr = "";
String buttonLabel = "add";

if(0 < ishDrId){
	descIstr = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(ishDrId).getEsfInstructsShootingDirectorDesc();
	codeIstr =  ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(ishDrId).getEsfInstructsShootingDirectorCode();
	buttonLabel = "Edit";
}

%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<portlet:actionURL name="addIstrShooterDirector" var="addIstrShooterDirectorURL">
	<portlet:param name="ishDrId"
		value="<%=String.valueOf(ishDrId)%>" />
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:actionURL>

<aui:form action="<%=addIstrShooterDirectorURL%>" name="<portlet:namespace />fm" >

	<aui:input name="codeIstr" type="text" label="code" value="<%=codeIstr %>"/>
	<aui:input name="descIstr" type="text" label="description" value="<%=descIstr %>"/>

	<aui:button type="<%=buttonLabel %>" value="<%=buttonLabel%>" />
	<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>
</aui:form>

