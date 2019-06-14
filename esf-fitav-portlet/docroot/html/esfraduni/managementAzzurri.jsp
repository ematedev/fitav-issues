<%@page import="it.ethica.esf.model.ESFNational"%>
<%@ include file="init.jsp"%>

<%
	String id_esf_raduno = ParamUtil.getString(request, "id_esf_raduno");
	String codice = ParamUtil.getString(request, "code");
	
	List<ESFRadunoAzzurri> listaRadunoAzzurri = new ArrayList<ESFRadunoAzzurri>();
	int nFiles = listaRadunoAzzurri.size();
	
	List<ESFSportType> listaSport = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
	List<KeyValuePair> listaInvitati = new ArrayList<KeyValuePair>();
	listaInvitati.add(new KeyValuePair("0", " - "));
	listaInvitati.add(new KeyValuePair("1", "Non Invitato"));
	listaInvitati.add(new KeyValuePair("2", "Invitato"));
	
	
/* 	String self = request.getParameter("self");
	if (self == null)
		self = "";

	List<ESFNational> listaNazionali = new ArrayList<ESFNational>();
	// CREO la DynamicQuery aggiungendo condizioni a seconda se i campi sono vuoti o sono valorizzati
	DynamicQuery dq = DynamicQueryFactoryUtil.forClass(ESFNational.class, "Azzurri", PortletClassLoaderUtil.getClassLoader());

	if (!self.equals("self")){
		String name = ParamUtil.getString(request, "code","");	
		String startDate = ParamUtil.getString(request, "name","");
		long esfSportType = ParamUtil.getLong(request, "esfSportType");
		
		if (!name.isEmpty())
			dq.add(RestrictionsFactoryUtil.like("Azzurri.userName", name));
		
		if(startDate != null)
			dq.add(RestrictionsFactoryUtil.ge("Azzurri.userstartDate", startDate));
			
		if(esfSportType!=0)
			dq.add(RestrictionsFactoryUtil.eq("Azzurri.esfSportTypeId", esfSportType));
	}
	
	listaNazionali = (List<ESFNational>)ESFNationalLocalServiceUtil.dynamicQuery(dq);
	int nNazionali = listaNazionali.size();
 */
 	
	Object oggetto = request.getAttribute("listaNazionali");
	List<ESFNational> listaNazionali = new ArrayList<ESFNational>();
	int nNazionali = 0;
	if(oggetto != null){
		listaNazionali = (List<ESFNational>)oggetto;
		nNazionali = listaNazionali.size();
	}
	
	
/* 	
	PortletURL AzzurriViewURL = renderResponse.createRenderURL();
	AzzurriViewURL.setParameter(
		"mvcPath", "/html/esfraduni/managementAzzurri.jsp");
	AzzurriViewURL.setParameter("id_esf_raduno", id_esf_raduno);
	AzzurriViewURL.setParameter("code", codice);
	
 */
	
	PortletURL AzzurriViewURL = renderResponse.createActionURL();
	AzzurriViewURL.setParameter(
		"mvcPath", "/html/esfraduni/managementAzzurri.jsp");
	AzzurriViewURL.setParameter("javax.portlet.action", "ricercaAzzurri");
	AzzurriViewURL.setParameter("id_esf_raduno", id_esf_raduno);
	AzzurriViewURL.setParameter("code", codice);
	
%>

<aui:script use="aui-base,node,aui-io-request">
		$(function() {
			$("#<portlet:namespace/>startDate").datepicker();
			$("#<portlet:namespace/>startDate").datepicker("option",
					"dateFormat", "dd/mm/yy");
		});
</aui:script>

<portlet:actionURL var="backURL" name="backToSearch" />
<portlet:actionURL var="searchAzzurriURL" name="ricercaAzzurri">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(id_esf_raduno) %>"/>	
	<portlet:param name="codice" value="<%= codice %>"/>	
</portlet:actionURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%="/html/esfraduni/managementAzzurri.jsp"%>'/>
	<portlet:param name="self" value='self' />
</liferay-portlet:renderURL>


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

<aui:form action="<%=AzzurriViewURL%>" method="POST">

	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input name="id_esf_raduno" type="hidden" value="<%=id_esf_raduno %>" />
			<aui:input name="code" type="hidden" value="<%=codice %>" />
			<aui:input inlineField="true" label="name" name="name" placeholder="name" size="" title="search-entries" type="text" /> 
			<aui:input inlineField="true" label="start-date" name="startDate" placeholder="start-date" size="" title="search-entries" type="text" />
			<aui:select name="esfSportType" id="esfSportType"
				inlineField="true">
				<aui:option label=" - " value="0" />
 				<%				
					for (ESFSportType tipoSport : listaSport) {
				%>
					<aui:option label="<%=tipoSport.getName()%>" value="<%=tipoSport.getEsfSportTypeId()%>" />
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

<liferay-ui:search-container delta="5" emptyResultsMessage="no-result" total="<%=nNazionali%>" iteratorURL="<%=AzzurriViewURL%>" >
	<liferay-ui:search-container-results  
		results="<%=ListUtil.subList(listaNazionali, searchContainer.getStart(), searchContainer.getEnd())%>"  />
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFNational" modelVar="nazionale">
			<liferay-ui:search-container-column-text name="name"
					value="<%=Validator.isNotNull(nazionale.getUserName()) ? nazionale.getUserName() : StringPool.BLANK%>" />
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	

