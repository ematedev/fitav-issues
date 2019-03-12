<%@include file="init.jsp"%>

<%

List<ESFDocument> esfUserDocuments =
	ESFDocumentLocalServiceUtil.findByesfUserId(esfUser.getEsfUserId());

String backUrlEdit = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
portletSession.setAttribute("backUrlEdit", backUrlEdit);
%>

<portlet:renderURL var="addESFDocumentURL">
	<portlet:param name="mvcPath"
		value="/html/esfnationalmatch/edit_esfDocument.jsp" />
	<portlet:param name="esfUserId"
		value="<%=String.valueOf(esfUser.getEsfUserId())%>" />
	<portlet:param name="organizationId"
		value="<%= String.valueOf(currentOrganizationId)%>" />
	<portlet:param name="esfMatchId" 
		value="<%=String.valueOf(esfMatchId)%>" />
	
</portlet:renderURL>

<liferay-ui:error key="esfDocument-reference-error"
	message="esfDocument-reference-error" />
<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_SHOOTER_ADD_DOC) %>">	
		
	<aui:button onClick="<%= addESFDocumentURL.toString()%>"
		value="add-Document" />
</c:if>
<h4>
	<liferay-ui:message key="documents-info" />
</h4>
(<liferay-ui:message  key="expiration-date-info" />) : 
<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%=esfUserDocuments%>"
		total="<%=esfUserDocuments.size()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFDocument" modelVar="esfDocument">
	<%
		String allertCssStyle = "";
		int days = Days.daysBetween(
				new DateTime(new Date()),
				new DateTime(esfDocument.getExpirationDate())).getDays();
		if(days <= 30){
			allertCssStyle = "soonExpiration";
		}

		if(Validator.isNotNull(esfDocument.getPath())){
			String dir = PortletProps.get("auto.deploy.tomcat.dest.dir");
			String path = String.valueOf(esfDocument.getPath());
%>

			<liferay-ui:search-container-column-text href="<%=path%>" property="type" name="Type" target="_blank"/>
	
			<liferay-ui:search-container-column-text href="<%=path%>" property="code" name="Code"  target="_blank"/>
	
			<liferay-ui:search-container-column-text href="<%=path%>" property="releasedBy" name="ReleasedBy" target="_blank" />
	
			<liferay-ui:search-container-column-text href="<%=path%>" name="ReleaseDate" value="<%=ManageDate.DateToString(esfDocument.getReleaseDate())%>"  target="_blank"/>
			
			<liferay-ui:search-container-column-text href="<%=path%>" name="ExpirationDate" cssClass="<%=allertCssStyle%>"
				value="<%=ManageDate.DateToString(esfDocument.getExpirationDate())%>"  target="_blank"/>
	
		<%} else{ %>
			<liferay-ui:search-container-column-text property="type" name="Type" />
	
			<liferay-ui:search-container-column-text property="code" name="Code" />
	
			<liferay-ui:search-container-column-text property="releasedBy" name="ReleasedBy"  />
	
			<liferay-ui:search-container-column-text name="ReleaseDate" value="<%=ManageDate.DateToString(esfDocument.getReleaseDate())%>" />
			
			<liferay-ui:search-container-column-text name="ExpirationDate" cssClass="<%=allertCssStyle%>"
				value="<%=ManageDate.DateToString(esfDocument.getExpirationDate())%>"  />
		
		<%}  %>

		<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_DOC_UPDATE) %>">	
			<liferay-ui:search-container-column-jsp
				path='<%=templatePath + "/tabs/navigation/esfDocument_action.jsp"%>' align="right" />
		</c:if>	

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>