<%@ include file="init.jsp"%>

<%
	
	String id_esf_raduno = ParamUtil.getString(request, "id_esf_raduno");
	String codice = ParamUtil.getString(request, "code");
	String name = ParamUtil.getString(request, "name");
	String surname = ParamUtil.getString(request, "surname");
	String numero_tessera = ParamUtil.getString(request, "numero_tessera");
	String namespace = renderResponse.getNamespace();
	//String dataNascita = ParamUtil.getString(request, "birth-date");
	long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId",0);
	long esfListaInvitati = ParamUtil.getLong(request, "esfListaInvitati",0);
	
	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
	long currentOrganizationId = group.getOrganizationId();
	

	int nShooters = 0;
	String idColl = "";
	
	
	List<KeyValuePair> listaInvitati = new ArrayList<KeyValuePair>();
	listaInvitati.add(new KeyValuePair("0", " - "));
	listaInvitati.add(new KeyValuePair("1", "Non Invitato"));
	listaInvitati.add(new KeyValuePair("2", "Invitato"));
	
	Object oggetto = request.getAttribute("listaShooters");
	List<VW_Shooters> listaShooters = new ArrayList<VW_Shooters>();
	if(oggetto != null){
		listaShooters = (List<VW_Shooters>)oggetto;
		nShooters = listaShooters.size();
	}
	
	
	List<ESFOrganization> listaAssociazioni = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId,"","");
	
	PortletURL ShootersViewURL = renderResponse.createActionURL();
	ShootersViewURL.setParameter(
			"mvcPath", "/html/esfraduni/managementShooters.jsp");
	ShootersViewURL.setParameter("javax.portlet.action", "ricercaShooters");
	ShootersViewURL.setParameter("id_esf_raduno", id_esf_raduno);
	ShootersViewURL.setParameter("code", codice);
	ShootersViewURL.setParameter("name", name);
	ShootersViewURL.setParameter("surname", surname);
	ShootersViewURL.setParameter("esfListaInvitati", String.valueOf(esfListaInvitati));
	
%>

<%-- <aui:script use="aui-base,node,aui-io-request">
		$(function() {
			$("#<portlet:namespace/>birth-date").datepicker();
			$("#<portlet:namespace/>birth-date").datepicker("option",
					"dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>birth-date").datepicker("setDate",
			'<%= dataNascita %>');
		});
</aui:script> --%>


<portlet:actionURL var="backURL" name="backToSearch" />

<portlet:actionURL var="searchShootersURL" name="ricercaShooters">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(id_esf_raduno) %>"/>	
	<portlet:param name="codice" value="<%= codice %>"/>	
	<portlet:param name="mvcPath" value='<%="/html/esfraduni/managementShooters.jsp"%>'/>
</portlet:actionURL>

<portlet:actionURL var="salvaShootersRadunoURL" name="salvaShootersRaduno">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(id_esf_raduno) %>"/>	
	<portlet:param name="code" value="<%= codice %>"/>	
</portlet:actionURL>

<liferay-ui:success key="addSuccess" message="${successMessage}" />

<b>RICERCA TIRATORI ASSOCIATI AL RADUNO CON CODICE <%=codice %></b>

<aui:form action="<%=searchShootersURL%>" method="POST">

	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input name="id_esf_raduno" type="hidden" value="<%=id_esf_raduno %>" />
			<aui:input name="code" type="hidden" value="<%=codice %>" />
		
			<aui:input inlineField="true" label="name" name="name" placeholder="name" 
					type="text" value="<%=name %>"/> 
			<aui:input inlineField="true" label="surname" name="surname" placeholder="surname" 
					type="text" value="<%=surname %>"/> 
<%-- 			<aui:input inlineField="true" label="birth-date" name="birth-date" placeholder="birth-date" 
					type="text" />  --%>
			<aui:input inlineField="true" label="Numero Tessera" name="numero_tessera" placeholder="Numero Tessera" type="text" 
				value="<%=Validator.isNotNull(numero_tessera) ? numero_tessera : StringPool.BLANK %>"/> 
			<aui:select name="esfAssociation" id="esfAssociation"
				inlineField="true">
				<aui:option label=" - " value="0" />
 				<%				
					for (ESFOrganization associazione : listaAssociazioni) {
						Boolean selezionato = false;
						if(associazione.getEsfOrganizationId() == esfOrganizationId)
							selezionato = true;
				%>
					<aui:option label="<%=associazione.getName()%>" value="<%=associazione.getEsfOrganizationId()%>" selected="<%=selezionato %>"/>
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

<aui:form method="POST" action="<%=salvaShootersRadunoURL%>">
	<liferay-ui:search-container delta="5" emptyResultsMessage="no-result" total="<%=nShooters%>" iteratorURL="<%=ShootersViewURL%>" >
<%
	List<VW_Shooters> sottoListaShooters = ListUtil.subList(listaShooters, searchContainer.getStart(), searchContainer.getEnd());
%>
		<liferay-ui:search-container-results results="<%=sottoListaShooters%>"  />
			<liferay-ui:search-container-row className="it.ethica.esf.model.VW_Shooters" modelVar="shooter">
<%
	//String birthDate = DateUtilFormatter.formatDate(shooter.getD);
	idColl += String.valueOf(shooter.getUserId()) +"|";
	String associazione = StringPool.BLANK;
	ESFOrganization organizzazione = null;
	if (Validator.isNotNull(shooter.getOrganizationId())){
		associazione = String.valueOf(shooter.getOrganizationId());
	}
%>
			<liferay-ui:search-container-column-text name="id Utente"
				value="<%=(shooter.getUserId()!=0) ? String.valueOf(shooter.getUserId()) : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="name"
				value="<%=(Validator.isNotNull(shooter.getNome())) ? shooter.getNome() : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="surname"
				value="<%=(Validator.isNotNull(shooter.getCognome())) ? shooter.getCognome() : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="Numero Tessera"
					value="<%=(Validator.isNotNull(shooter.getCodiceTessera())) ? shooter.getCodiceTessera() : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="Associazione" value="<%=associazione%>" />

<%
	String checked = "";
	//String valore = azzurro.getEsfNationalId();

	if(shooter.getInvitato()!=0)
		checked = "checked=\"true\"";
%>					
			<liferay-ui:search-container-column-text name="invitato">
				<input name="<portlet:namespace/>invitato" value="<%=shooter.getUserId()%>" type="checkbox" <%=checked%> />
			</liferay-ui:search-container-column-text>
			
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

<% 
	if(nShooters != 0){
%>
	<aui:input type="hidden" name="idListaMostrataShooters" value="<%=idColl %>" />
	
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
		
	</aui:script>
<%
	}
%>
	
</aui:form>


