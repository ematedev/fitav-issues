<%@include file="init.jsp" %>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");

ESFUser esfUser = null;

if(esfUserId > 0) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);	
}
%>

<h2><liferay-ui:message key="user-detail"></liferay-ui:message></h2>

<portlet:actionURL name="editESFUser" var="editESFUserURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>"/>
</portlet:actionURL>

<aui:form action="<%=editESFUserURL.toString() %>" name="<portlet:namespace />edit_esfuser_form">
	<aui:fieldset>	
		<aui:model-context bean="<%= esfUser %>" model="<%=ESFUser.class %>" />
		<aui:input name="code" label="<%=LanguageUtil.get(locale, \"code\") %>"/>			
		<aui:input name="firstName" label="<%=LanguageUtil.get(locale, \"firstName\") %>"/>
		<aui:input name="lastName" label="<%=LanguageUtil.get(locale, \"lastName\") %>"/>
		<aui:input name="screenName" label="<%=LanguageUtil.get(locale, \"screenName\") %>"/>		
		<aui:input name="userEmail" label="<%=LanguageUtil.get(locale, \"userEmail\") %>"/>
		<aui:input name="birthday" label="<%=LanguageUtil.get(locale, \"birthday\") %>"/>
		<aui:select name="male" label="<%=LanguageUtil.get(locale, \"gender\") %>">
			<aui:option value="true" label="<%=LanguageUtil.get(locale, \"male\") %>"/>
			<aui:option value="false" label="<%=LanguageUtil.get(locale, \"female\") %>"/>
		</aui:select>
		<aui:input name="jobTitle" label="<%=LanguageUtil.get(locale, \"jobTitle\") %>"/>
	</aui:fieldset>
	<% if(esfUserId <= 0) { %>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button onClick="<%= viewURL.toString() %>" type="cancel" />
	</aui:button-row>
	<% } %>
</aui:form>
