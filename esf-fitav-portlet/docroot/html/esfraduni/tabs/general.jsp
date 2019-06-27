<%@ include file="../init.jsp"%>

<%
	long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno"); 
	String code = ParamUtil.getString(request, "code"); 

	Object oggetto = request.getAttribute("listaAzzurri");
	List<VW_Azzurri> listaAzzurri = new ArrayList<VW_Azzurri>();
	int nAzzurri = 0;
	if(oggetto != null){
		listaAzzurri = (List<VW_Azzurri>)oggetto;
		nAzzurri = listaAzzurri.size();
	}
	
	oggetto = null;
	oggetto = request.getAttribute("listaStaff");
	List<VW_Staff> listaStaff = new ArrayList<VW_Staff>();
	int nStaff = 0;
	if(oggetto != null){
		listaStaff = (List<VW_Staff>)oggetto;
		nStaff = listaStaff.size();
	}

	oggetto = null;
	oggetto = request.getAttribute("listaShooters");
	List<VW_Shooters> listaShooters = new ArrayList<VW_Shooters>();
	int nShooters = 0;
	if(oggetto != null){
		listaShooters = (List<VW_Shooters>)oggetto;
		nShooters = listaShooters.size();
	}

	oggetto = null;
	oggetto = request.getAttribute("listaFiles");
	List<ESFRadunoFiles> listaFiles = new ArrayList<ESFRadunoFiles>();
	int nFiles = 0;
	if(oggetto != null){
		listaFiles = (List<ESFRadunoFiles>)oggetto;
		nFiles = listaFiles.size();
	}
		
	
	PortletURL ManagementRadunoViewURL = renderResponse.createActionURL();
	ManagementRadunoViewURL.setParameter(
		"mvcPath", "/html/esfraduni/managementRaduno.jsp");
	ManagementRadunoViewURL.setParameter("javax.portlet.action", "managementRaduno");
	ManagementRadunoViewURL.setParameter("id_esf_raduno", String.valueOf(id_esf_raduno));
	ManagementRadunoViewURL.setParameter("code", code);
	
%>

<portlet:renderURL var="uploadURL">
	<portlet:param name="id_esf_raduno" value="<%=String.valueOf(id_esf_raduno)%>"/>	
	<portlet:param name="code" value="<%=code%>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/upload/uploadFileRaduno.jsp" />	
</portlet:renderURL>

<portlet:renderURL var="editAzzurriURL">
	<portlet:param name="id_esf_raduno" value="<%=String.valueOf(id_esf_raduno)%>"/>	
	<portlet:param name="code" value="<%=code%>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/managementAzzurri.jsp" />	
</portlet:renderURL>

<portlet:renderURL var="editShooterURL">
	<portlet:param name="id_esf_raduno" value="<%=String.valueOf(id_esf_raduno)%>"/>	
	<portlet:param name="code" value="<%=code%>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/managementShooters.jsp" />	
</portlet:renderURL>

<portlet:renderURL var="editStaffURL">
	<portlet:param name="id_esf_raduno" value="<%=String.valueOf(id_esf_raduno)%>"/>	
	<portlet:param name="code" value="<%=code%>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/managementStaff.jsp" />	
</portlet:renderURL>


<b>INVITATI AL RADUNO CON CODICE <%=code%></b><br/>

<b>AZZURRI INVITATI <%=nAzzurri%></b><br/>
<liferay-ui:search-container delta="20" emptyResultsMessage="no-result" total="<%=nAzzurri%>" iteratorURL="<%=ManagementRadunoViewURL%>" >
<%
	List<VW_Azzurri> sottoListaAzzurri = ListUtil.subList(listaAzzurri, searchContainer.getStart(), searchContainer.getEnd());
	request.setAttribute("sottoListaAzzurri", sottoListaAzzurri);
	int contatore=0;

%>
	<liferay-ui:search-container-results  
		results="<%=sottoListaAzzurri%>"  />
		<liferay-ui:search-container-row className="it.ethica.esf.model.VW_Azzurri" modelVar="azzurro">
<%
			String startDate = DateUtilFormatter.formatDate(azzurro.getStartDate());
			String endFine = DateUtilFormatter.formatDate(azzurro.getEndDate());
%>
			<liferay-ui:search-container-column-text name="name"
					value="<%=Validator.isNotNull(azzurro.getUserName()) ? azzurro.getUserName() : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="codice"
					value="<%=Validator.isNotNull(azzurro.getEsfNationalId()) ? String.valueOf(azzurro.getEsfNationalId()) : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="start-date" value="<%=startDate%>" />					
			<liferay-ui:search-container-column-text name="end-date" value="<%=endFine%>" />					
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	

<aui:button-row cssClass="esfmatch-admin-buttons">
	<aui:button onClick="<%=editAzzurriURL.toString() %>" value="Associa Azzurri" />
</aui:button-row>


<b>STAFF INVITATI <%=nStaff%></b><br/>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-result" total="<%=nStaff%>" iteratorURL="<%=ManagementRadunoViewURL%>" >
<%
	List<VW_Staff> sottoListaStaff = ListUtil.subList(listaStaff, searchContainer.getStart(), searchContainer.getEnd());
%>
		<liferay-ui:search-container-results results="<%=sottoListaStaff %>"  />
			<liferay-ui:search-container-row className="it.ethica.esf.model.VW_Staff" modelVar="staff">
<%
	String startDate = DateUtilFormatter.formatDate(staff.getEsfStartData());
%>
				<liferay-ui:search-container-column-text name="name"
						value="<%=(Validator.isNotNull(staff.getFirstName()) && Validator.isNotNull(staff.getLastName())) ? 
								staff.getFirstName() + StringPool.SPACE + staff.getLastName() : StringPool.BLANK%>" />
				<liferay-ui:search-container-column-text name="surname"
						value="<%=(Validator.isNotNull(staff.getFirstName()) && Validator.isNotNull(staff.getLastName())) ? 
								staff.getFirstName() + StringPool.SPACE + staff.getLastName() : StringPool.BLANK%>" />
				<liferay-ui:search-container-column-text name="UserId"
						value="<%=Validator.isNotNull(staff.getUserId()) ? String.valueOf(staff.getUserId()) : StringPool.BLANK%>" />
				<liferay-ui:search-container-column-text name="qualifica" 
				value="<%=Validator.isNotNull(staff.getEsfShootingDirectorQualificationDesc()) ? staff.getEsfShootingDirectorQualificationDesc() : StringPool.BLANK%>" />					
				<liferay-ui:search-container-column-text name="start-date" value="<%=startDate%>" />					
				<liferay-ui:search-container-column-text name="specialita'" 
					value="<%=Validator.isNotNull(staff.getName()) ? staff.getName() : StringPool.BLANK%>" />					
				<liferay-ui:search-container-column-text name="regione/provincia" 
					value="<%= (Validator.isNotNull(staff.getRegionId()) || Validator.isNotNull(staff.getProvinceId())) ?
					staff.getRegionId() + StringPool.SPACE + StringPool.SLASH + StringPool.SPACE + staff.getProvinceId() : StringPool.BLANK%>" />					
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

<aui:button-row cssClass="esfmatch-admin-buttons">
	<aui:button onClick="<%=editStaffURL.toString() %>" value="Associa Staff" />
</aui:button-row>
<b>TIRATORI INVITATI <%=nShooters%></b><br/>
<aui:button-row cssClass="esfmatch-admin-buttons">
	<aui:button onClick="<%=editShooterURL.toString() %>" value="Associa Tiratori" />
</aui:button-row>

<b>FILE ALLEGATI <%=nFiles%></b><br/>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-result" total="<%=nFiles%>" iteratorURL="<%=ManagementRadunoViewURL%>" >
	<liferay-ui:search-container-results  results="<%=listaFiles%>"  />
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFRadunoFiles" modelVar="radunoFiles">
			<liferay-ui:search-container-column-text name="name"
					value="<%=Validator.isNotNull(radunoFiles.getNome()) ? radunoFiles.getNome() : StringPool.BLANK%>" />
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button-row cssClass="esfmatch-admin-buttons">
	<aui:button onClick="<%=uploadURL.toString() %>" value="Associa File" />
</aui:button-row>

