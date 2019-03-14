<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@ include file="init.jsp"%>

<%
	ESFMatchType esfMatchType = null;

	long esfMatchTypeId =
		ParamUtil.getLong(request, "esfMatchTypeId");
	
	boolean isCategoryQualification = false;
	boolean isNational = false;

	if (esfMatchTypeId >0) {

		esfMatchType =
			ESFMatchTypeLocalServiceUtil.getESFMatchType(esfMatchTypeId);
		
		isCategoryQualification = esfMatchType.getIsCategoryQualification();
		isNational = esfMatchType.getIsNational();
	}
	
	
	if(Validator.isNotNull(esfMatchType)){
		String matchType = esfMatchType.getName();
		String[] matchTypeName = {matchType};
	%>
	<h4><b><liferay-ui:message key="update-matchType-x" arguments="<%= matchTypeName%>"/></b>
				<div class="separator"></div>
	<% 
		
	}else{
	%>
	<h4><b><liferay-ui:message key="add-new-matchType" /></b>
				<div class="separator"></div>
<%
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
		<aui:input name="isCategoryQualification" label="isCategoryQualification" type="checkbox" checked="<%=isCategoryQualification %>"/>
		
		<aui:input name="isNational" label="isNational" type="checkbox" checked="<%=isNational %>"/>
		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>
