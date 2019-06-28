<%@include file="../init.jsp"%>

<%
	String id_esf_raduno = ParamUtil.getString(request, "id_esf_raduno");
	String codice = ParamUtil.getString(request, "code");
	
	List<ESFRadunoFiles> listaRadunoFiles = ESFRadunoFilesLocalServiceUtil.findByRaduno(Long.parseLong(id_esf_raduno));
	//List<ESFRadunoFiles> listaRadunoFiles = new ArrayList<ESFRadunoFiles>();
	int nFiles = listaRadunoFiles.size();
	
	PortletURL uploadViewURL = renderResponse.createRenderURL();

	uploadViewURL.setParameter(
		"mvcPath", "/html/esfraduni/uploadFileRaduno.jsp");
	uploadViewURL.setParameter("id_esf_raduno", id_esf_raduno);
	uploadViewURL.setParameter("code", codice);
	
%>

<portlet:actionURL var="uploadURL" name="uploadDocument" />
<portlet:actionURL var="backURL" name="backToSearch" />

<liferay-ui:success key="addSuccess" message="${successMessage}" />


<div class="interBox">
	<h2><liferay-ui:message key="please-upload-a-document" /></h2>
</div>
<div class="interBox">
	<aui:form action="<%=uploadURL.toString()%>" enctype="multipart/form-data" name="fm"  method="post"> 
		<aui:input type="hidden" name="id_esf_raduno" value="<%=id_esf_raduno%>" /> 
		<aui:input type="hidden" name="code" value="<%=codice%>" /> 
		<aui:input type="file" name="uploadedFile" label="file"/> 
		<aui:button-row>
			<aui:button type="submit" value="save" />
		
			<aui:button type="cancel" onClick='<%= backURL.toString() %>' />
		</aui:button-row>
	</aui:form>
</div>	


<liferay-ui:search-container delta="5" emptyResultsMessage="no-result" total="<%=nFiles%>" iteratorURL="<%=uploadViewURL%>" >
	<liferay-ui:search-container-results  results="<%=listaRadunoFiles%>"  />
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFRadunoFiles" modelVar="radunoFiles">
			<liferay-ui:search-container-column-text name="name"
					value="<%=Validator.isNotNull(radunoFiles.getNome()) ? radunoFiles.getNome() : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-jsp path='<%="/html/esfraduni/upload/menuFileUploadRaduno.jsp"%>' align="right" />
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	
	

