<%@page import="it.ethica.esf.service.ESFTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFType"%>
<%@include file="init.jsp" %>

<%
long esfTypeId = ParamUtil.getLong(request, "esfTypeId");

ESFType esfType = null;

if(esfTypeId > 0) {
	esfType = ESFTypeLocalServiceUtil.getESFType(esfTypeId);	
}
%>

<portlet:actionURL name="editESFType" var="editESFTypeURL">
	<portlet:param name="esfTypeId" value="<%=String.valueOf(esfTypeId) %>"/>
</portlet:actionURL>

<aui:form action="<%=editESFTypeURL.toString() %>" name="<portlet:namespace />edit_esftype_form">
	<aui:fieldset>
		<aui:model-context bean="<%= esfType %>" model="<%=ESFType.class %>" />
		<aui:input name="code" label="<%=LanguageUtil.get(locale, \"code\") %>"/>
		<aui:input name="name" label="<%=LanguageUtil.get(locale, \"name\") %>"/>
		<aui:input name="description" label="<%=LanguageUtil.get(locale, \"description\") %>"/>
		<aui:select name="className" label="<%=LanguageUtil.get(locale, \"className\") %>">
			<aui:option value="it.ethica.esf.model.ESFDocument" label="<%=LanguageUtil.get(locale, \"document\") %>" />
			<aui:option value="it.ethica.esf.model.ESFUser" label="<%=LanguageUtil.get(locale, \"user\") %>" />
			<aui:option value="it.ethica.esf.model.ESFOrganization" label="<%=LanguageUtil.get(locale, \"organization\") %>" />
		</aui:select>
		<aui:input name="status" label="<%=LanguageUtil.get(locale, \"status\") %>"/>
		<aui:select name="parent" label="parent">
			<aui:option value="0" label="-" />
			<%
			for(ESFType esfTypeObj : ESFTypeLocalServiceUtil.getESFTypes(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS)){
				%>
				<aui:option value="<%= esfTypeObj.getEsfTypeId() %>" label="<%= esfTypeObj.getName() %>" />
				<%
			}
			%>
		</aui:select>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" /> 
		<aui:button onClick="<%= viewURL.toString() %>" type="cancel" />
	</aui:button-row>
</aui:form>