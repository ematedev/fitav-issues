<%@ include file="init.jsp"%>

<%
	List<ESFRadunoTipo> listaTipiRaduno = ESFRadunoTipoLocalServiceUtil.findAllTipi();

	//List<Country> countries = CountryServiceUtil.getCountries();
	
 	Object listaRaduniObject = request.getAttribute("listaRaduno");
	List<ESFRaduno> listaRaduni = new ArrayList<ESFRaduno>();
	
	if (listaRaduniObject != null){
		listaRaduni = (List<ESFRaduno>)listaRaduniObject;
	}
/*	
	List<ESFRaduno> listaRaduni = (List<ESFRaduno>)request.getAttribute("listaRaduno");
	if (listaRaduni == null){
		listaRaduni = new ArrayList<ESFRaduno>();
	}
*/	
	
%>

<portlet:actionURL var="searchURL" name="ricercaRaduni"></portlet:actionURL>
<portlet:actionURL var="newRadunoURL" name="creaNuovoRaduno"></portlet:actionURL>


<aui:script use="aui-base,node,aui-io-request">
		$(function() {
			$("#<portlet:namespace/>startDate").datepicker();
			$("#<portlet:namespace/>startDate").datepicker("option",
					"dateFormat", "dd/mm/yy");
		});
</aui:script>
	
<liferay-ui:success key="addSuccess" message="${successMessage}" />
<liferay-ui:error key="errorDate" message="${errorDateMessage}" />
<liferay-ui:error key="errorMsg" message="${errorMessage}" />


<aui:button-row cssClass="esfmatch-admin-buttons">
	<portlet:renderURL var="addEsfRadunoURL">
	</portlet:renderURL>
	<aui:button onClick="<%= newRadunoURL.toString() %>"
		value="MSG-aggiungi-raduno" />

</aui:button-row>

<aui:form action="${searchURL}" method="POST">

	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input inlineField="true" label="code" name="code" placeholder="code" size="" title="search-entries" type="text" /> 
			<aui:input inlineField="true" label="start-date" name="startDate" placeholder="start-date" size="" title="search-entries" type="text" />
			<aui:select name="esfTipoRaduno" id="esfTipoRaduno"
				inlineField="true">
				<aui:option label=" - " value="0" />
				<%				
					for (ESFRadunoTipo tipoRaduno : listaTipiRaduno) {
				%>
					<aui:option label="<%=tipoRaduno.getDescrizione()%>" value="<%=tipoRaduno.getId_esf_raduno_tipo()%>" />
				<%
					}
				%>
			</aui:select> 
			
			
<%-- 			<aui:select name="esfCountryId" label="esfCountryId">
				<aui:option label=" - " value="0" />
				<%
					for (Country country : countries) {
				%>
				<aui:option label="<%=country.getName()%>"
					value="<%=country.getCountryId()%>"></aui:option>
				<%
					}
				%> 
			</aui:select>--%>
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>



<liferay-ui:search-container emptyResultsMessage="no-result" total="<%=listaRaduni.size()%>">
<%
	
%>
	<liferay-ui:search-container-results  results="<%=listaRaduni%>"  />
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFRaduno" modelVar="raduno">
			<%
			String dataInizio = DateUtilFormatter.formatDate(raduno.getData_inizio());
			String dataFine = DateUtilFormatter.formatDate(raduno.getData_fine());
			%>
			<liferay-ui:search-container-column-text name="code"
					value="<%=Validator.isNotNull(raduno.getCodice())
								? raduno.getCodice() : StringPool.BLANK%>" />
			<liferay-ui:search-container-column-text name="start-date" value="<%=dataInizio%>" />
			<liferay-ui:search-container-column-text name="end-date" value="<%=dataFine%>" />
			<liferay-ui:search-container-column-text name="description" value='<%=raduno.getNote()%>' />
			<liferay-ui:search-container-column-jsp
				path='<%="/html/esfraduni/esfRaduno_actions.jsp"%>' align="right" />
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	
	