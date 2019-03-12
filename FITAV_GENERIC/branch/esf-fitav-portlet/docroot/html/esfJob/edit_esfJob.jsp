<%@ include file="init.jsp"%>

<%
	ESFJob esfJob = null;

	long esfJobId =
		ParamUtil.getLong(request, "esfJobId");

	if (esfJobId >0) {

		esfJob =
			ESFJobLocalServiceUtil.getESFJob(esfJobId);
	}
%>

<portlet:actionURL name="editESFjob" var="editESFJobURL">
	<portlet:param name="esfJobId"
		value="<%=String.valueOf(esfJobId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFJobURL%>"
	name="fm">
	<aui:model-context bean="<%= esfJob%>"
		model="<%=ESFJob.class%>" />

	<aui:fieldset>
		<aui:input type="hidden" name="esfJobId"
			value='<%= esfJobId %>' />
		
		<aui:input name="job" type="text"></aui:input>

	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>