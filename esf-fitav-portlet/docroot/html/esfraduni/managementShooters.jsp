<%@ include file="init.jsp"%>

<%
	
	String id_esf_raduno = ParamUtil.getString(request, "id_esf_raduno");
	String codice = ParamUtil.getString(request, "code");
	String name = ParamUtil.getString(request, "name");
	String namespace = renderResponse.getNamespace();
	String dataNascita = ParamUtil.getString(request, "birth-date");

	long esfSportType = ParamUtil.getLong(request, "esfSportType",0);
	long esfListaInvitati = ParamUtil.getLong(request, "esfListaInvitati",0);
	
	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
	long currentOrganizationId = group.getOrganizationId();
	
	long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId",0);

	int nStaff = 0;
	String idColl = "";
	
	
	List<KeyValuePair> listaInvitati = new ArrayList<KeyValuePair>();
	listaInvitati.add(new KeyValuePair("0", " - "));
	listaInvitati.add(new KeyValuePair("1", "Non Invitato"));
	listaInvitati.add(new KeyValuePair("2", "Invitato"));
	
	List<ESFOrganization> listaAssociazioni = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId,"","");
	
	PortletURL ShootersViewURL = renderResponse.createActionURL();
	ShootersViewURL.setParameter(
			"mvcPath", "/html/esfraduni/managementShooters.jsp");
	ShootersViewURL.setParameter("javax.portlet.action", "ricercaShooters");
	ShootersViewURL.setParameter("id_esf_raduno", id_esf_raduno);
	ShootersViewURL.setParameter("code", codice);
	ShootersViewURL.setParameter("name", name);
	ShootersViewURL.setParameter("esfListaInvitati", String.valueOf(esfListaInvitati));
	
%>

<aui:script use="aui-base,node,aui-io-request">
		$(function() {
			$("#<portlet:namespace/>birth-date").datepicker();
			$("#<portlet:namespace/>birth-date").datepicker("option",
					"dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>birth-date").datepicker("setDate",
			'<%= dataNascita %>');
		});
</aui:script>


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
			<aui:input inlineField="true" label="birth-date" name="birth-date" placeholder="birth-date" 
					type="text" value="<%=name %>"/> 
			<aui:input inlineField="true" label="Numero Tessera" name="numero_tessera" placeholder="Numero Tessera" 
					type="text" value="<%=name %>"/> 
			<aui:select name="esfAssociation" id="esfAssociation"
				inlineField="true">
				<aui:option label=" - " value="0" />
 				<%				
					for (ESFOrganization associzione: listaAssociazioni) {
						Boolean selezionato = false;
						if(associzione.getEsfOrganizationId() == esfOrganizationId)
							selezionato = true;
				%>
					<aui:option label="<%=associzione.getEsfOrganizationId()%>" value="<%=associzione.getDescription()%>" selected="<%=selezionato %>"/>
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


