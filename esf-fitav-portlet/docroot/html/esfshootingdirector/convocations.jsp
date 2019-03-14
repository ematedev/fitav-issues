<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFMatchImpl"%>
<%@page import="it.ethica.esf.model.ESFMatch"%>
<%@page import="it.ethica.esf.model.ESFNationalDelegation"%>
<%@page import="it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil"%>
<%@include file="init.jsp"%>

<liferay-ui:error key="find-Suspensive" message="find-Suspensive" />
<liferay-ui:error key="error-assign-director" message="error-assign-director" />

<%
long directorId = ParamUtil.getLong(request, "esfUserId");
long partecipantType = ESFKeys.ESFNationalDelegationType.REFEREE;

ESFUser shDr = new ESFUserImpl();

String shDrName = "";

shDr = ESFUserLocalServiceUtil.fetchESFUser(directorId);

if(Validator.isNotNull(shDr)){
	shDrName = shDr.getFirstName() + " " + shDr.getLastName();
	
}

%>

<portlet:renderURL var="addConvocationURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "addConvocation.jsp"%>' />
		<portlet:param name="directorId"
		value="<%=String.valueOf(directorId)%>" />
</portlet:renderURL>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
	<portlet:param name="esfUserId" value="<%=String.valueOf(directorId)%>" />
</portlet:renderURL>

<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>

<h3><liferay-ui:message key="infromation-shDR-x" arguments="<%=shDrName %>" /></h3>
<br>

<aui:button onClick='<%=addConvocationURL.toString() %>' value="generateconvocations" />

<liferay-ui:search-container emptyResultsMessage="no-result" curParam="ShootingDirector">

	<liferay-ui:search-container-results 
	
		results = "<%=ESFNationalDelegationLocalServiceUtil.findByPartecipantType_EsfUserId(directorId, partecipantType, 
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total = "<%=ESFNationalDelegationLocalServiceUtil.countPartecipantType_EsfUserId(directorId, partecipantType)%>"/>
	
	<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFNationalDelegation" modelVar="del">
	<%
	
	String description = "";
	String refusalName = "";
	String refusalDate = "";
	String instrictCode = "";
	String dateAssign = "";
	
	ESFMatch match = new ESFMatchImpl();
	match = ESFMatchLocalServiceUtil.fetchESFMatch(del.getEsfMatchId());
	
	if(0 < del.getTaskId()){
		refusalName = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(del.getTaskId()).getEsfInstructsShootingDirectorCode();
	}
	
	if(Validator.isNotNull(del.getRefusalDate())){
		refusalDate = sdf.format(del.getRefusalDate());
	}

	
	if(0 < del.getTaskId() ){
		instrictCode = ESFInstructsShootingDirectorLocalServiceUtil .fetchESFInstructsShootingDirector(del.getTaskId()).getEsfInstructsShootingDirectorDesc();
	}
	
	if(Validator.isNotNull(del.getNominationDate())){
		dateAssign = sdf.format(del.getNominationDate());
	}
	if(Validator.isNotNull(del.getRefusal())){
		refusalName = del.getRefusal() ;
	}
	

	if(Validator.isNotNull(match) && Validator.isNotNull(match.getDescription()) && (match.getDescription() != 0)){
		description = ESFDescriptionLocalServiceUtil.fetchESFDescription(
				match.getDescription()).getName();
	}
	
	%>
		<liferay-ui:search-container-column-text name="match-desc" value="<%=description %>" />
		
		<liferay-ui:search-container-column-text name="esf-date-assign" value="<%=dateAssign %>" />
		
		<liferay-ui:search-container-column-text name="instructors" value="<%= instrictCode%>"/>
		
		<liferay-ui:search-container-column-text name="refusalDate" value="<%=refusalDate%>" />
		
		<liferay-ui:search-container-column-text name="refusalMotivation" value="<%=refusalName%>" />
	
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>