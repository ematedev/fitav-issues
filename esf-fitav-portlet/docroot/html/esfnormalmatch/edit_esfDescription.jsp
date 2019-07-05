<%@ include file="init.jsp"%>
<%
	ESFDescription description = null;
	long esfDescription = ParamUtil.getLong(request, "esfDescription");
	long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId", 0);
	long matchId = ParamUtil.getLong(request, "esfMatchId");
	String returnPath = ParamUtil.getString(request, "mvcPath");
%>
<h1>Gestione Descrizione Gara</h1>
<portlet:actionURL name="editESFdescription" var="editESFDescriptionURL">
	<portlet:param name="esfMatchTypeId" value="<%=String.valueOf(esfMatchTypeId)%>" />
	<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
</portlet:actionURL>

<portlet:renderURL var="backUrl">
		<portlet:param name="mvcPath" value='<%= templatePath + "new_edit_esfMatch.jsp" %>' />
		<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
		<portlet:param name="esfDescription" value="<%=String.valueOf(esfDescription)%>" />
		<portlet:param name="esfMatchTypeId" value="<%=String.valueOf(esfMatchTypeId)%>" />
</portlet:renderURL>

<aui:form action="<%=editESFDescriptionURL%>" name="fm">
	<aui:model-context bean="<%= description%>" model="<%=ESFDescription.class%>" />
	<aui:fieldset>				
		<aui:input name="name"></aui:input>
		<aui:input name="isNational"
			label="isNational" type="checkbox"
			value='<%=esfDescription != null
							? esfDescription.getIsNational()
							: StringPool.BLANK%>'></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" value="go-back" onClick="<%= backUrl %>"></aui:button>
	</aui:button-row>
</aui:form>