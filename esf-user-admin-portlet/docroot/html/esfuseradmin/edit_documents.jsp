<%@page import="it.ethica.esf.service.ESFDocumentLocalServiceUtil"%>
<%@include file="../init.jsp" %>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");

ESFUser esfUser = null;

String span = "";

if(esfUserId > 0) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);	
	span = "span8";
}
%>

<portlet:actionURL name="editESFUser" var="editESFUserURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>"/>
</portlet:actionURL>

<div class="<%=span %>">
	<aui:form action="<%=editESFUserURL.toString() %>" name="<portlet:namespace />fm">
		<aui:fieldset>	
			<aui:model-context bean="<%= esfUser %>" model="<%=ESFUser.class %>" />			
			<aui:input name="firstName" label="<%=LanguageUtil.get(locale, \"firstName\") %>"/>
			<aui:input name="lastName" label="<%=LanguageUtil.get(locale, \"lastName\") %>"/>
			<aui:input name="screenName" label="<%=LanguageUtil.get(locale, \"screenName\") %>"/>		
			<aui:input name="userEmail" label="<%=LanguageUtil.get(locale, \"userEmail\") %>"/>
			<aui:input name="birthday" label="<%=LanguageUtil.get(locale, \"birthday\") %>"/>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button onClick="<%= viewURL.toString() %>" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

