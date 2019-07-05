<%@ include file="init.jsp"%>
<%
	ESFMatchType esfMatchType = null;
	long matchId = ParamUtil.getLong(request, "esfMatchId");
	long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");
	long esfDescription = ParamUtil.getLong(request, "esfDescription", 0);
%>
<h1>Aggiungi Tipo Gara</h1>
<portlet:actionURL name="editESFMatchType" var="editESFMatchTypeURL">
	<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
	<portlet:param name="esfDescription" value="<%=String.valueOf(esfDescription)%>" />
</portlet:actionURL>
<portlet:renderURL var="backUrl">
		<portlet:param name="mvcPath" value='<%= templatePath + "new_edit_esfMatch.jsp" %>' />
		<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
		<portlet:param name="esfDescription" value="<%=String.valueOf(esfDescription)%>" />
		<portlet:param name="esfMatchTypeId" value="<%=String.valueOf(esfMatchTypeId)%>" />
</portlet:renderURL>

<aui:form action="<%=editESFMatchTypeURL%>" name="fm">
	<aui:model-context bean="<%= esfMatchType%>" model="<%=ESFMatchType.class%>" />
	<aui:fieldset>
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>		
		<aui:input name="isCategoryQualification" label="isCategoryQualification" type="checkbox"/>		
		<aui:input name="isNational" label="isNational" type="checkbox"/>		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" value="go-back" onClick="<%= backUrl %>"></aui:button>
	</aui:button-row>
</aui:form>