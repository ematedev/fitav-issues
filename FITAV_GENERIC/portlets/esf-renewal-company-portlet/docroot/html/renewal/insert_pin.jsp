<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<% 
 long esfUserId= ParamUtil.getLong(request, "esfUserId");
%>

<liferay-ui:error key="esfValidationError"
message="esfValidationError" />



<portlet:actionURL name="checkPin" var="checkPinURL">
	<portlet:param name="esfUserId" value='<%= String.valueOf(esfUserId) %>'/>
</portlet:actionURL>



<aui:form action='<%=checkPinURL %>' >
<aui:fieldset ></aui:fieldset>
	<h4> <liferay-ui:message key="insert-pin" /> </h4>
	<aui:input name="pin" label ="" inlineLabel="true" type="password" >
	<aui:validator name="digits" errorMessage= '<%= LanguageUtil.get(locale,"only-numbers") %>' ></aui:validator>
	</aui:input>
	
	<aui:button-row>
		<aui:button type="submit" value="validate"> </aui:button>
		<aui:button onClick="<%= backUrl %>" type="cancel"> </aui:button>
	</aui:button-row>
</aui:form>

