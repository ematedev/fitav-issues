<%@include file="/useradmin/init.jsp"%>


<liferay-ui:form-navigator
	backURL="<%= viewURL %>"
	categoryNames="<%= categoryNames %>"
	categorySections="<%= categorySections %>"		
	jspPath="/html/esfuseradmin/"
	showButtons="false"
/>


<%!
private static final String[] categoryNames = {"user-information"};
private static final String[][] categorySections = {{"edit_user","edit_documents"}}; 
%>