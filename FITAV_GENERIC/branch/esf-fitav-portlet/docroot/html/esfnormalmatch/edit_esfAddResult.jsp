<%@include file="init.jsp"%>
<% 	
	String errorMessage = "";
	if(Validator.isNotNull(request.getAttribute("errorMessage")))
		errorMessage = request.getAttribute("errorMessage").toString();
	
	String successMessage = "";
	if(Validator.isNotNull(request.getAttribute("successMessage")))
		successMessage = request.getAttribute("successMessage").toString();
%>
<liferay-ui:error key="errorMessage" message="<%=errorMessage%>"/>
<liferay-ui:success key="successMessage" message="<%=successMessage %>"/>
<%
	if(esfMatchId == 0){
		if(Validator.isNotNull(request.getAttribute("esfMatchId"))){
			esfMatchId = (Long)request.getAttribute("esfMatchId");
		}
	}	
	
%>


<c:choose>
	<c:when test="<%=!Validator.isBlank(successMessage)%>">
		<% String uploadedFilePath = (String)request.getAttribute("file");
		%>
		
		<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPLOAD_RESULT) %>">	
			<portlet:actionURL var="uploadAllDataURL" name="uploadAllData">
				<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
				<portlet:param name = "file" value = "<%=uploadedFilePath%>"/>
			</portlet:actionURL>
			
			<aui:form action="<%= uploadAllDataURL %>">
				<aui:input name = "submit" type="submit" value="submit" />
			</aui:form>
		</c:if>	
		
	</c:when>
	<c:when test="<%=ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPLOAD_RESULT) %>">
						
		<portlet:actionURL var="editCaseURL" name="uploadCase">
			<portlet:param name="mvcPath" value="/html/esfnormalmatch/edit_esfAddResult.jsp" />
			<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
		</portlet:actionURL>
		
		<aui:form action="<%= editCaseURL %>"  method="post" enctype="multipart/form-data" >
			<aui:input type="file" name="fileName" size="75"/>
			<input name = "submitFile" type="submit" />
		</aui:form>
		
	</c:when>
	
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message
				key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>
<aui:button type="cancel" onClick="<%=backURL%>"></aui:button>

