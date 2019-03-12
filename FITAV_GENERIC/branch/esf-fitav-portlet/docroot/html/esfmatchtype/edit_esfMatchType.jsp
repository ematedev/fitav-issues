<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@ include file="init.jsp"%>

<%
	ESFMatchType esfMatchType = null;

	long esfMatchTypeId =
		ParamUtil.getLong(request, "esfMatchTypeId");

	if (esfMatchTypeId >0) {

		esfMatchType =
			ESFMatchTypeLocalServiceUtil.getESFMatchType(esfMatchTypeId);
	}
%>


<portlet:actionURL name="editESFMatchType" var="editESFMatchTypeURL">
</portlet:actionURL>

<aui:form action="<%=editESFMatchTypeURL%>" name="fm">
	<aui:model-context bean="<%= esfMatchType%>"
		model="<%=ESFMatchType.class%>" />

	<aui:fieldset>
		<aui:input type="hidden" name="esfMatchTypeId"
			value='<%= esfMatchTypeId %>' />
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="isCategoryQualification" label="isCategoryQualification" type="checkbox"/>
		
		<aui:input name="isNational" label="isNational" type="checkbox"/>
		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>
