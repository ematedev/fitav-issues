<%@ include file="init.jsp"%>


<h1>Nuovo Tipo Gara</h1>

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
	<portlet:param name="esfMatchId" value="<%= String.valueOf(esfMatchId) %>" />
</portlet:actionURL>

<portlet:renderURL var="backUrl">
		<portlet:param name="mvcPath" value='<%= templatePath + "new_edit_esfMatch.jsp" %>' />
		<portlet:param name="esfMatchId" value="<%= String.valueOf(esfMatchId) %>" />
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
		
		<aui:input name="isNational" label="isNational" type="checkbox"/>
		
	</aui:fieldset>

	<aui:button-row>
		<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_MATCHTYPE_ADD) %>">	
			<aui:button type="submit"></aui:button>
		</c:if>
		<aui:button type="cancel" onClick="<%= backUrl %>" value="cancel"></aui:button>
	</aui:button-row>
</aui:form>