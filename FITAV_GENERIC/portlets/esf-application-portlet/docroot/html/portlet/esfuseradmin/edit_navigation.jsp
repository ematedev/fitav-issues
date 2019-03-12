<%@include file="init.jsp" %>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");

ESFUser esfUser = null;

if(esfUserId > 0) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);	
}
%>

<portlet:actionURL name="saveAll" var="saveAllURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>"/>
</portlet:actionURL>

<aui:form action="<%=saveAllURL.toString() %>" name="<portlet:namespace />ESFUser_form">
	<liferay-ui:form-navigator
		backURL="<%= viewURL %>"
		categoryNames="<%= categoryNames %>"
		categorySections="<%= categorySections %>"		
		jspPath="/html/portlet/esfuseradmin/"
		showButtons="true"						
	/>
</aui:form>

<%!
private static final String[] categoryNames = {"user-information"};
private static final String[][] categorySections = {{"edit_user","view_user_documents"}};
%>
