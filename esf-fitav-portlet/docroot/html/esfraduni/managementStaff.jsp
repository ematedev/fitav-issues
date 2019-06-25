<%@ include file="init.jsp"%>

<%
	
	String id_esf_raduno = ParamUtil.getString(request, "id_esf_raduno");
	String codice = ParamUtil.getString(request, "code");
	String name = ParamUtil.getString(request, "name");
	String namespace = renderResponse.getNamespace();
	String dataInizio = ParamUtil.getString(request, "startDate");
	String esfShootingDirectorQualificationId = ParamUtil.getString(request, "esfShootingDirectorQualification");
	long esfSportType = ParamUtil.getLong(request, "esfSportType",0);
	long esfListaInvitati = ParamUtil.getLong(request, "esfListaInvitati",0);
	int nStaff = 0;
	String idColl = "";
	
	
	
	Object oggetto = request.getAttribute("listaStaff");
	List<VW_Staff> listaStaff = new ArrayList<VW_Staff>();
	if(oggetto != null){
		listaStaff = (List<VW_Staff>)oggetto;
		nStaff = listaStaff.size();
	}
	
	List<ESFShootingDirectorQualification> listaQualifiche = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	List<ESFSportType> listaSport = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
	List<KeyValuePair> listaInvitati = new ArrayList<KeyValuePair>();
	listaInvitati.add(new KeyValuePair("0", " - "));
	listaInvitati.add(new KeyValuePair("1", "Non Invitato"));
	listaInvitati.add(new KeyValuePair("2", "Invitato"));
	
	
	PortletURL StaffViewURL = renderResponse.createActionURL();
	StaffViewURL.setParameter(
		"mvcPath", "/html/esfraduni/managementStaff.jsp");
	StaffViewURL.setParameter("javax.portlet.action", "ricercaStaff");
	StaffViewURL.setParameter("id_esf_raduno", id_esf_raduno);
	StaffViewURL.setParameter("code", codice);
	StaffViewURL.setParameter("name", name);
	StaffViewURL.setParameter("esfShootingDirectorQualification", esfShootingDirectorQualificationId);
	StaffViewURL.setParameter("esfSportType", String.valueOf(esfSportType));
	StaffViewURL.setParameter("startDate", dataInizio);
	StaffViewURL.setParameter("esfListaInvitati", String.valueOf(esfListaInvitati));

%>

<aui:script use="aui-base,node,aui-io-request">
		$(function() {
			$("#<portlet:namespace/>startDate").datepicker();
			$("#<portlet:namespace/>startDate").datepicker("option",
					"dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>startDate").datepicker("setDate",
			'<%= dataInizio %>');
		});
</aui:script>



<portlet:actionURL var="backURL" name="backToSearch" />

<portlet:actionURL var="searchStaffURL" name="ricercaStaff">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(id_esf_raduno) %>"/>	
	<portlet:param name="codice" value="<%= codice %>"/>	
	<portlet:param name="mvcPath" value='<%="/html/esfraduni/managementStaff.jsp"%>'/>
</portlet:actionURL>

<portlet:actionURL var="salvaStaffRadunoURL" name="salvaStaffRaduno">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(id_esf_raduno) %>"/>	
	<portlet:param name="code" value="<%= codice %>"/>	
</portlet:actionURL>

<liferay-ui:success key="addSuccess" message="${successMessage}" />

<b>RICERCA STAFF ASSOCIATO AL RADUNO CON CODICE <%=codice %></b>

<aui:form action="<%=searchStaffURL%>" method="POST">

	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input name="id_esf_raduno" type="hidden" value="<%=id_esf_raduno %>" />
			<aui:input name="code" type="hidden" value="<%=codice %>" />
		
		
		<aui:input inlineField="true" label="name" name="name" placeholder="name" 
				type="text" value="<%=name %>"/> 
		<aui:input inlineField="true" label="start-date" name="startDate" placeholder="start-date" size="" title="search-entries" type="text" />
			<aui:select name="esfShootingDirectorQualification" id="esfShootingDirectorQualification"
				inlineField="true">
				<aui:option label=" - " value="" />
<%				
					for (ESFShootingDirectorQualification tipoQualifica : listaQualifiche) {
						Boolean selezionato = false;
						if(tipoQualifica.getEsfShootingDirectorQualificationDesc() == esfShootingDirectorQualificationId)
							selezionato = true;
				%>
					<aui:option label="<%=tipoQualifica.getEsfShootingDirectorQualificationDesc()%>" 
						value="<%=tipoQualifica.getEsfShootingDirectorQualificationDesc()%>" selected="<%=selezionato %>"/>
				<%
					}
				%>

 			</aui:select> 
			<aui:select name="esfSportType" id="esfSportType"
				inlineField="true">
				<aui:option label=" - " value="0" />
 				<%				
					for (ESFSportType tipoSport : listaSport) {
						Boolean selezionato = false;
						if(tipoSport.getEsfSportTypeId() == esfSportType)
							selezionato = true;
				%>
					<aui:option label="<%=tipoSport.getName()%>" value="<%=tipoSport.getEsfSportTypeId()%>" selected="<%=selezionato %>"/>
				<%
					}
				%>

 			</aui:select> 		
			<aui:select name="esfListaInvitati" id="esfListaInvitati"
				inlineField="true">
 				<%				
					for (KeyValuePair invitato : listaInvitati) {
				%>
					<aui:option label="<%=invitato.getValue()%>" value="<%=invitato.getKey()%>" />
				<%
					}
				%>

 			</aui:select> 
			
		<aui:button-row>
			<aui:button type="submit" value="search" />
			<aui:button type="cancel" onClick='<%= backURL.toString() %>' />
		</aui:button-row>
 			
		</span>
	</div>
</aui:form>


<aui:form method="POST" action="<%=salvaStaffRadunoURL%>">
	<liferay-ui:search-container delta="5" emptyResultsMessage="no-result" total="<%=nStaff%>" iteratorURL="<%=StaffViewURL%>" >
<%
	List<VW_Staff> sottoListaStaff = ListUtil.subList(listaStaff, searchContainer.getStart(), searchContainer.getEnd());
%>
		<liferay-ui:search-container-results results="<%=sottoListaStaff %>"  />
			<liferay-ui:search-container-row className="it.ethica.esf.model.VW_Staff" modelVar="staff">
<%
	String startDate = DateUtilFormatter.formatDate(staff.getEsfStartData());
	idColl += String.valueOf(staff.getUserId()) +"|";
%>
				<liferay-ui:search-container-column-text name="name"
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
<%
	String checked = "";
	//String valore = azzurro.getEsfNationalId();
	if(staff.getInvitato()!=0)
		checked = "checked=\"true\"";
%>					
			<liferay-ui:search-container-column-text name="invitato">
				<input name="<portlet:namespace/>invitato" value="<%=staff.getUserId()%>" type="checkbox" <%=checked%> />
			</liferay-ui:search-container-column-text>
			
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

<% 
	if(nStaff != 0){
%>
	<aui:input type="hidden" name="idListaMostrataStaff" value="<%=idColl %>" />
	
	<aui:button-row>
		<aui:button type="cancel" id='<%=namespace + "check_all"%>' value="select all" />
		<aui:button type="cancel" id='<%=namespace + "uncheck_all"%>' value="unselect all"/>
	</aui:button-row>
	<aui:button-row>
		<aui:button type="submit" id='<%=namespace + "save_all"%>' value="save all" />
	</aui:button-row>

	<aui:script use="aui-base,node,aui-io-request,liferay-util-list-fields">
		A.one('#<portlet:namespace/>check_all').on('click', function(event){
			A.all('input[type=checkbox]').each(function(item, index, list) {
				item.set('checked', true);	
			});
		});
		
		A.one('#<portlet:namespace/>uncheck_all').on('click', function(event){
			//alert("UNCHECK ALL");
			A.all('input[type=checkbox]').each(function(item, index, list) {
				var checked = item.attr('checked');
				//console.log(index +">>>>>>>>>>>>>>>" + checked); 
				item.removeAttribute('checked');
				item.set('checked', false);	
				});
		});
		
/* 		A.one('#<portlet:namespace/>save_all').on('click', function(event){
			alert("SAVE ALL");
		});
 */
	</aui:script>
<%
	}
%>
	
</aui:form>
