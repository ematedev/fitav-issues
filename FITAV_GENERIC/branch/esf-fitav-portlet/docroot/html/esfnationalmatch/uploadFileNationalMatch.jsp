<%@include file="init.jsp"%>

<%
long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
boolean  showUpload=ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_UPLOAD_FILE);
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>




<% if(showUpload){ %>

	<portlet:actionURL var="uplaodURL" name="uploadDocument">
	</portlet:actionURL>
	
	<div class="interBox">
		<h2><liferay-ui:message key="please-upload-a-document" /></h2>
	</div>
	<div class="interBox">
		<aui:form action="<%=uplaodURL%>" enctype="multipart/form-data" name="fm"  method="post"> 
			<aui:input type="file" name="uploadedFile" label="file"/> 
			<aui:input type="hidden" name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" /> 
	<% } %>
		
			<div class="interBox">
				<%
					String files[]=null;
					String path=null;
					
					if(Validator.isNotNull(request.getAttribute("filesToDownload"))){
						files = (String[])request.getAttribute("filesToDownload");
					}
					if(Validator.isNotNull(request.getAttribute("filePath"))){
						 path = (String)request.getAttribute("filePath");
					}
					if (files !=null){
				%>
						<liferay-ui:message key="file" /><br>
				<%
						for(String s : files){
							if(path!=null){
				%>	
								<a href = "<%=path + s%>" target = "_blank" ><br><%=s%></br></a>
				<%		
							}else{
				%>
								<%=s%>
				<%
							}
						}
					}
				%>
		
			</div>
			
			<aui:button-row cssClass="esfmatch-admin-buttons">
				<c:if test="<%= showUpload	%>">	
					<aui:button type = "submit" value = "add" align="right" ></aui:button>
				</c:if>
				<aui:button onClick='<%=backURL.toString() %>' value="back" />
			</aui:button-row>

<% if(showUpload){ %>
	</aui:form>
<% } %>	 
</div>


