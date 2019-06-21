<%@ include file="init.jsp"%>

<h2><liferay-ui:message key="match-type" /></h2>
<%
	ESFMatchType esfMatchType = null;

	long matchId = ParamUtil.getLong(request, "esfMatchId");
	
	long esfMatchTypeId =
		ParamUtil.getLong(request, "esfMatchTypeId");

	if (esfMatchTypeId >0) {

		esfMatchType =
			ESFMatchTypeLocalServiceUtil.getESFMatchType(esfMatchTypeId);
	}
%>


<portlet:actionURL name="editESFMatchType" var="editESFMatchTypeURL">
	<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
</portlet:actionURL>

<portlet:renderURL var="backUrl">
		<portlet:param name="mvcPath" value='<%= templatePath + "new_edit_esfMatch.jsp" %>' />
		<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
</portlet:renderURL>

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
		
		<aui:input name="isNational" value="true" type="hidden"/>
		<liferay-ui:message key="isNationalMessage"></liferay-ui:message>
		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="go-back" value="go-back" onClick="<%= backUrl %>"></aui:button>
	</aui:button-row>
</aui:form>