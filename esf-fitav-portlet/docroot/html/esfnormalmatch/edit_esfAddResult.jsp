<%@page import="it.ethica.esf.model.impl.ESFMatchImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFOrganizationImpl"%>
<%@include file="init.jsp"%>

<% 	

	ESFOrganization org = new ESFOrganizationImpl();
	ESFMatch match = new ESFMatchImpl();
	
	boolean notAss = false;
	long associationId = ParamUtil.getLong(request, "associationId");
	long sptId = 0 ;
	
	String notAssError = "Select-Association-For-This-Match";
	String successMessage = "";
	String errorMessage = "";
	String assCode = "";
	String stCode = "";
	String matchCode = "";
	String matchNumberS = "";
	String title = "";
	
	if(Validator.isNotNull(request.getAttribute("errorMessage")))
		errorMessage = request.getAttribute("errorMessage").toString();

	if(Validator.isNotNull(request.getAttribute("successMessage")))
		successMessage = request.getAttribute("successMessage").toString();
	
	if(0 == associationId){
		notAss = true;
	}else{
		if(Validator.isNotNull(associationId) && Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(associationId)) && Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(associationId).getCode()) ){
			assCode = ESFOrganizationLocalServiceUtil.fetchESFOrganization(associationId).getCode();
		}
	}
	
	
	if(0 < esfMatchId && Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId)) && Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId).getCode())){
		matchCode = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId).getCode();
		if(4 < matchCode.length()){
			matchNumberS =  matchCode.substring(4);
		}
	}
	
	if(0 < esfMatchId && Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId)) && Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId).getEsfSportTypeId()) &&
			Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId).getEsfSportTypeId())) 
				&& Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId).getEsfSportTypeId()).getCode())){
		sptId = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId).getEsfSportTypeId();
		stCode = ESFSportTypeLocalServiceUtil.fetchESFSportType(ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId).getEsfSportTypeId()).getCode();
	}
	
	title = assCode+stCode+matchNumberS;
	
%>


<h3><%= title%></h3>

<liferay-ui:error key="errorMessage" message="<%=errorMessage%>"/>
<liferay-ui:success key="successMessage" message="<%=successMessage %>"/>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<portlet:actionURL var="editCaseURL" name="uploadCase">
	<portlet:param name="mvcPath" value="/html/esfnormalmatch/view.jsp" />
	<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
	<portlet:param name="associationId" value="<%=String.valueOf(associationId)%>" />
	<portlet:param name="sptId" value="<%=String.valueOf(sptId)%>" />
	<portlet:param name="title" value="<%=title%>" />
</portlet:actionURL>

<c:choose>
	<c:when test="<%=ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPLOAD_RESULT) && !notAss%>">

		<aui:form action="<%= editCaseURL %>"  method="post" enctype="multipart/form-data" >
			<aui:input type="file" name="fileName" size="75"/>
			<input name = "submitFile" type="submit" />
		</aui:form>
		
	</c:when>
	<c:when test="<%=notAss%>">
		<h1>
			<liferay-ui:message key="<%=notAssError %>" />
		</h1>
		<br>
	</c:when>
	
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message
				key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>

<aui:button type="cancel" onClick="<%=backURL%>"></aui:button>

