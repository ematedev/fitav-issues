<%@page import="it.ethica.esf.service.impl.ESFUserLocalServiceImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@ include file="init.jsp"%>

<h1>Modifica Dati</h1>
<%
String userFC = "";
String shooterFirstName = "";
String shooterLastName = "";

String lastname = ParamUtil.getString(request, "lastname");
String firstname = ParamUtil.getString(request, "firstname");
String backPage = ParamUtil.getString(request, "backPage");
String tabs1 = ParamUtil.getString(request, "tabs1");
long userId = ParamUtil.getLong(request, "esfUserId");
long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
long esfRoleId = ParamUtil.getLong(request, "esfUserRoleId");

ESFUser esfUser = new ESFUserImpl();

if(Validator.isNotNull(userId) && userId > 0){
	esfUser = ESFUserLocalServiceUtil.fetchESFUser(userId);
	userFC = esfUser.getFiscalCode();
	shooterFirstName = esfUser.getFirstName();
	shooterLastName = esfUser.getLastName();
}

System.out.println("userFC="+userFC);
%>

<portlet:actionURL name="updateShooter"
	var="updateShooterURL" />
	
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath"
		value='<%=backPage%>'></portlet:param>
	<portlet:param name="tabs1"
		value='<%=tabs1%>'></portlet:param>
	<portlet:param name="lastname"
		value='<%=lastname%>'></portlet:param>
	<portlet:param name="firstname"
		value='<%=firstname%>'></portlet:param>
	
</portlet:renderURL>

<aui:form action="<%=updateShooterURL%>"
	name="<portlet:namespace />fmn">
	
	<aui:input type="hidden" name="esfUserIds" 	value='<%=userId%>' />
	<aui:input type="hidden" name="lastnameB" 	value='<%=lastname%>' />
	<aui:input type="hidden" name="firstnameB" 	value='<%=firstname%>' />
	<aui:input type="hidden" name="backPage" 	value='<%=backPage%>' />
	<aui:input type="hidden" name="tabs1" 	value='<%=tabs1%>' />
	<aui:input type="hidden" name="esfOrganizationId" 	value='<%=esfOrganizationId%>' />
	<aui:input type="hidden" name="esfRoleId" 	value='<%=esfRoleId%>' />
	
	<aui:input name="lastName" value='<%=shooterLastName%>' inlineField="true"/>
	<aui:input name="firstName" value='<%=shooterFirstName%>' inlineField="true"/>
	<aui:input name="fiscalCode " value='<%=userFC%>' inlineField="true"/>
	
	<aui:button-row>
		<aui:button type="submit" value="Update"></aui:button>
		<aui:button type="cancel" onClick="<%= backURL %>"></aui:button>
	</aui:button-row>
	
</aui:form>
