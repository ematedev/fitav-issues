<%@page import="it.ethica.esf.model.VW_Azzurri"%>
<%@page import="it.ethica.esf.model.ESFNational"%>
<%@ include file="init.jsp"%>

<%
	String id_esf_raduno = ParamUtil.getString(request, "id_esf_raduno");
	String codice = ParamUtil.getString(request, "code");
	String name = ParamUtil.getString(request, "name");
	String namespace = renderResponse.getNamespace();
	
	long esfSportType = ParamUtil.getLong(request, "esfSportType",0);
	String dataInizio = ParamUtil.getString(request, "startDate");
	long esfListaInvitati = ParamUtil.getLong(request, "esfListaInvitati",0);

	
	List<ESFSportType> listaSport = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
	List<KeyValuePair> listaInvitati = new ArrayList<KeyValuePair>();
	listaInvitati.add(new KeyValuePair("0", " - "));
	listaInvitati.add(new KeyValuePair("1", "Non Invitato"));
	listaInvitati.add(new KeyValuePair("2", "Invitato"));
	
	Object oggetto = request.getAttribute("listaNazionali");
	List<VW_Azzurri> listaNazionali = new ArrayList<VW_Azzurri>();
	int nNazionali = 0;
	if(oggetto != null){
		listaNazionali = (List<VW_Azzurri>)oggetto;
		nNazionali = listaNazionali.size();
	}
	
	
	PortletURL AzzurriViewURL = renderResponse.createActionURL();
	AzzurriViewURL.setParameter(
		"mvcPath", "/html/esfraduni/managementAzzurri.jsp");
	AzzurriViewURL.setParameter("javax.portlet.action", "ricercaAzzurri");
	AzzurriViewURL.setParameter("id_esf_raduno", id_esf_raduno);
	AzzurriViewURL.setParameter("code", codice);
	AzzurriViewURL.setParameter("name", name);
	AzzurriViewURL.setParameter("esfSportType", String.valueOf(esfSportType));
	AzzurriViewURL.setParameter("startDate", dataInizio);
	AzzurriViewURL.setParameter("esfListaInvitati", String.valueOf(esfListaInvitati));
	
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
<portlet:actionURL var="searchAzzurriURL" name="ricercaAzzurri">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(id_esf_raduno) %>"/>	
	<portlet:param name="codice" value="<%= codice %>"/>	
</portlet:actionURL>

<portlet:actionURL var="salvaAzzurriRadunoURL" name="salvaAzzurriRaduno">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(id_esf_raduno) %>"/>	
	<portlet:param name="codice" value="<%= codice %>"/>	
</portlet:actionURL>



<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%="/html/esfraduni/managementAzzurri.jsp"%>'/>
	<portlet:param name="self" value='self' />
</liferay-portlet:renderURL>

<liferay-ui:success key="addSuccess" message="${successMessage}" />

<%-- 
<b>AZZURRI ASSOCIATI <%=nFiles %></b>

<portlet:actionURL var="associaAzzurroURL" name="associaAzzurro" />
<portlet:actionURL var="backURL" name="backToSearch" />

<liferay-ui:search-container delta="10" emptyResultsMessage="no-result" total="<%=nFiles%>" iteratorURL="<%=AzzurriViewURL%>" >
	<liferay-ui:search-container-results  results="<%=listaRadunoAzzurri%>"  />
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFRadunoAzzurri" modelVar="radunoAzzurri">
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	
 --%>
<b>RICERCA AZZURRI</b>

<aui:form action="<%=searchAzzurriURL%>" method="POST">

	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input name="id_esf_raduno" type="hidden" value="<%=id_esf_raduno %>" />
			<aui:input name="code" type="hidden" value="<%=codice %>" />
			<aui:input inlineField="true" label="name" name="name" placeholder="name" size="" 
				title="search-entries" type="text" value="<%=name %>"/> 
			<aui:input inlineField="true" label="start-date" name="startDate" placeholder="start-date" size="" title="search-entries" type="text" />
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


<aui:form method="POST" action="<%=salvaAzzurriRadunoURL%>">
<liferay-ui:search-container delta="5" emptyResultsMessage="no-result" total="<%=nNazionali%>" iteratorURL="<%=AzzurriViewURL%>" >
	<liferay-ui:search-container-results  
		results="<%=ListUtil.subList(listaNazionali, searchContainer.getStart(), searchContainer.getEnd())%>"  />
		<liferay-ui:search-container-row className="it.ethica.esf.model.VW_Azzurri" modelVar="azzurro">
			<liferay-ui:search-container-column-text name="name"
					value="<%=Validator.isNotNull(azzurro.getUserName()) ? azzurro.getUserName() : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="codice"
					value="<%=Validator.isNotNull(azzurro.getEsfNationalId()) ? String.valueOf(azzurro.getEsfNationalId()) : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="chissa"
					value="<%=String.valueOf(azzurro.getInvitato())%>" />
<%
	String nome = namespace + "invitato_";// + String.valueOf(azzurro.getInvitato());
	String checked = "";
	if(azzurro.getInvitato()!=0)
		checked = "checked=\"true\"";
%>					
			<liferay-ui:search-container-column-text name="invitato">
				<input name="invitato" id="<%=azzurro.getUserId()%>" type="checkbox" <%=checked%> />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	

<% 
	if(nNazionali != 0){
%>
	<b><%=nNazionali %></b>
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
				var checked = item.attr('checked'); 
				if (!checked)
					item.setAttribute('checked', 'true');	
			});
		});
		
		A.one('#<portlet:namespace/>uncheck_all').on('click', function(event){
			//alert("UNCHECK ALL");
			A.all('input[type=checkbox]').each(function(item, index, list) {
				var checked = item.attr('checked'); 
				if (checked)
					item.removeAttribute('checked');
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

