<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="java.util.List"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDocument"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/init.jsp" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/esfdocuments/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addESFDocument" var="addESFDocumentURL" />

<%
long esfDocumentId = ParamUtil.getLong(request, "esfDocumentId");

ESFDocument esfDocument = null;

if(esfDocumentId > 0) {
	esfDocument = ESFDocumentLocalServiceUtil.getESFDocument(esfDocumentId);
}
%>

<aui:form action="<%= addESFDocumentURL %>" name="<portlet:namespace />fm">
<aui:model-context bean="<%= esfDocument %>" model="<%= ESFDocument.class %>" />

<aui:fieldset>
	<aui:input name="type" />
	<aui:input name="name" />
	<aui:input name="number" />
	<aui:input name="issuer" label="Issuer" />
	<aui:input name="locationReference" label="Location Reference" />
	<c:if test="<%= ESFUserLocalServiceUtil.getESFUsersCount() > 0 %>">
		<aui:select cssClass="user-select" name="userId">
		<% 
		List<ESFUser> esfUsers = ESFUserLocalServiceUtil.getESFUsers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		for(ESFUser esfUser : esfUsers) {
			boolean selected = false;
			if(esfDocument != null && esfUser.getEsfUserId() == esfDocument.getOwnerId()){
				selected = true;
			} 
		%>	
			<aui:option value="<%= esfUser.getEsfUserId() %>" label="<%= esfUser.getFirstName() %>" selected="<%= selected %>" />
		<%
		}
		%>
		</aui:select>
	</c:if>

	<aui:input name="esfDocumentId" type="hidden" />
</aui:fieldset>

<aui:button-row>
	<aui:button type="submit"></aui:button>
	<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
</aui:button-row>
</aui:form>