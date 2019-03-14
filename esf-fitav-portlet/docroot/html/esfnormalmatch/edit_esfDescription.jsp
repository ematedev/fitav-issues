<%@ include file="init.jsp"%>

<%
	ESFDescription esfDescription = null;

	long esfDescriptionId = ParamUtil.getLong(request, "esfDescriptionId");
	long matchId = ParamUtil.getLong(request, "esfMatchId");
	String returnPath = ParamUtil.getString(request, "mvcPath");
	if (esfDescriptionId >0) {

		esfDescription =
			ESFDescriptionLocalServiceUtil.getESFDescription(esfDescriptionId);
	}
%>

<portlet:actionURL name="editESFdescription" var="editESFDescriptionURL">
	<portlet:param name="esfDescriptionId" value="<%=String.valueOf(esfDescriptionId)%>" />
	<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
</portlet:actionURL>

<portlet:renderURL var="backUrl">
		<portlet:param name="mvcPath" value='<%= templatePath + "new_edit_esfMatch.jsp" %>' />
		<portlet:param name="esfMatchId" value="<%=String.valueOf(matchId)%>" />
</portlet:renderURL>

<aui:form action="<%=editESFDescriptionURL%>" name="fm">
	<aui:model-context bean="<%= esfDescription%>" model="<%=ESFDescription.class%>" />

	<aui:fieldset>
	
		<aui:input type="hidden" name="esfDescriptionId"
			value='<%= esfDescriptionId %>' />
			
		<aui:input name="name"></aui:input>

		<aui:input name="isNational"
			label="isNational" type="checkbox"
			value='<%=esfDescription != null
							? esfDescription.getIsNational()
							: StringPool.BLANK%>'></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_DESCRIPTION_ADD) %>">	
			<aui:button type="submit"></aui:button>
		</c:if>
		<aui:button type="cancel" value="go-back" onClick="<%= backUrl %>"></aui:button>
	</aui:button-row>
</aui:form>