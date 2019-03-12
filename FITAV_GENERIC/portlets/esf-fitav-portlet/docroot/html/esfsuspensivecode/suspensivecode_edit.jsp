<%@page import="it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil"%>
<%@include file="init.jsp"%>

<%
long suCodeId = ParamUtil.getLong(request, "suCodeId");

String codeSusp="";
String descSusp = "";
String buttonLabel = "add";

if(0 < suCodeId){
	codeSusp = ESFSuspensiveCodeLocalServiceUtil.fetchESFSuspensiveCode(suCodeId).getCode();
	 descSusp =  ESFSuspensiveCodeLocalServiceUtil.fetchESFSuspensiveCode(suCodeId).getDescription();
	buttonLabel = "Edit";
}

%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<portlet:actionURL name="addSuspensiveCode" var="addSuspensiveCodeURL">
	<portlet:param name="suCodeId"
		value="<%=String.valueOf(suCodeId)%>" />
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view.jsp"%>' />
</portlet:actionURL>

<aui:form action="<%=addSuspensiveCodeURL%>" name="<portlet:namespace />fm" >

	<aui:input name="codeSusp" type="text" label="code" value="<%=codeSusp %>"/>
	<aui:input name="descSusp" type="text" label="description" value="<%=descSusp %>"/>
	
	<aui:button type="<%=buttonLabel %>" value="<%=buttonLabel%>" />
	<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>
</aui:form>