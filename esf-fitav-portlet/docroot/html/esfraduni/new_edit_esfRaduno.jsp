<%@ include file="init.jsp"%>

<%
	ESFRaduno radunoEdit = (ESFRaduno)request.getAttribute("radunoEdit");
	ESFOrganization associazione = (ESFOrganization)request.getAttribute("associazione");
	List<KeyValuePair> listaSottoTipiDisponibili = (List<KeyValuePair>)request.getAttribute("listaSottoTipiDisponibili");
	List<KeyValuePair> listaSottoTipiScelti = (List<KeyValuePair>)request.getAttribute("listaSottoTipiScelti");
	String namespace = renderResponse.getNamespace();
 
	String dataInizio="";
	String dataFine = "";
	long tipoRadunoSelezionato = 0;
	
	if(radunoEdit != null){
		//dataInizio = DateUtilFormatter.formatDate("dd/MM/yy",radunoEdit.getData_inizio()); 
		//dataFine = DateUtilFormatter.formatDate("dd/MM/yy",radunoEdit.getData_inizio());
		//tipoRadunoSelezionato = radunoEdit.getTipo_raduno();
		
		dataInizio = ManageDate.DateToString(radunoEdit.getData_inizio());
		dataFine = ManageDate.DateToString(radunoEdit.getData_fine());
	}
	
 %>

<liferay-ui:error key="mail_error" message="mail_error" />


<portlet:actionURL var="newESFRadunoURL" name="salvaRaduno" />
<portlet:actionURL var="backURL" name="backToSearch" />

<portlet:renderURL var="chooseAssociationURL"  windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value='<%="/html/esfraduni/popup/chooseAssociation.jsp"%>'></portlet:param>
</portlet:renderURL>


<aui:script use="aui-base,node,aui-io-request,liferay-util-list-fields">
	$(function() {
		$("#<portlet:namespace/>startDate").datepicker();
		$("#<portlet:namespace/>startDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>startDate").datepicker("setDate",
		'<%= dataInizio %>');
	});
	$(function() {
		$("#<portlet:namespace/>endDate").datepicker();
		$("#<portlet:namespace/>endDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>endDate").datepicker("setDate",
		'<%= dataFine %>');
	});

	Liferay.provide(
		window,
		'<portlet:namespace/>retrieveAssociationRaduno',
		function(dataId, dataName) {
			var A = AUI();
	
			//alert(dataName);	
			A.one('#<portlet:namespace/>esfAssociationId').set('value', dataId);
			A.one('#<portlet:namespace/>esfAssociation').set('value', dataName);
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
			dialog.destroy();
		},
		['liferay-util-window']
	);

	A.one('#<portlet:namespace/>deleteAssociationTrigger').on('click', function(event){
		
		A.one('#<portlet:namespace />esfAssociation').set('value','');
		A.one('#<portlet:namespace />esfAssociationId').set('value','');
	
		});
	
	A.one('#<portlet:namespace/>fm').on('submit', function(event) {
	    var listaSottoTipiScelti = Liferay.Util.listSelect('#<portlet:namespace/>boxSottoTipiScelti');
	    A.one('#<portlet:namespace/>valoriSottoTipiScelti').val(listaSottoTipiScelti);
	    submitForm('#<portlet:namespace/>fm');
	});
	
	AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	
		A.one('#<portlet:namespace/>chooseAssociationTrigger').on('click', function(event){
		var login_popup= Liferay.Util.openWindow({
			dialog: {
				centered: true,
				destroyOnClose: true,
				cache: false,
				width: 700,
				height: 500,
				modal: true
			},
			title: 'Sedi Raduni',
			id:'<portlet:namespace/>chooseAssociationPopUp',
			uri:'<%=chooseAssociationURL.toString()%>'
			});
	
		});
	});
	
	Liferay.provide(
			window,
			'<portlet:namespace/>retrieveAssociation',
			function(dataId, dataName) {
				var A = AUI();
	
				//A.one('#<portlet:namespace/>esfAssociationId').set('value', dataId);
				//A.one('#<portlet:namespace/>esfAssociation').set('value', dataName);
				var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
				dialog.destroy();
			},
			['liferay-util-window']
	);

</aui:script>


<aui:form action="${newESFRadunoURL}" name="fm">

	<aui:input name="id_esf_raduno" type="hidden" 
		value="<%=Validator.isNotNull(radunoEdit) ? radunoEdit.getId_esf_raduno() : StringPool.BLANK %>" />
	<aui:input name="code" type="hidden" 
		value="<%=Validator.isNotNull(radunoEdit) ? radunoEdit.getCodice() : StringPool.BLANK %>" />
	
	<aui:input name="esfAssociationId" type="hidden"
		value="<%=Validator.isNotNull(associazione) ? associazione.getEsfOrganizationId() : StringPool.BLANK %>">
	</aui:input>
	
	
	
	
	<aui:input name="startDate" type="text" 
		value="<%=Validator.isNotNull(radunoEdit) ? radunoEdit.getData_inizio() : StringPool.BLANK%>">
		<aui:validator name="required" errorMessage="this-field-is-required" />
	</aui:input>

	<aui:input name="endDate" type="text">
		<aui:validator name="required" errorMessage="this-field-is-required" />
	</aui:input>

	<div>
		<aui:select name="esfTipoRaduno" id="esfTipoRaduno" inlineField="true">
			<aui:option label=" - " value="0" selected=""/>
<%
	List<ESFRadunoTipo> listaTipiRaduno = (List<ESFRadunoTipo>)request.getAttribute("listaTipiRaduno");
	for(ESFRadunoTipo raduno : listaTipiRaduno){
		Boolean selezionato = false;
		
		if(Validator.isNotNull(radunoEdit) && (radunoEdit.getTipo_raduno() == raduno.getId_esf_raduno_tipo()))
			selezionato = true;
		
%>		
			<aui:option label="<%=raduno.getDescrizione() %>" value="<%=raduno.getId_esf_raduno_tipo() %>" selected="<%=selezionato%>"/>

<%	
	} 
%>			
		</aui:select>
	</div>

	<aui:input name="valoriSottoTipiScelti" type="hidden" />
    <liferay-ui:input-move-boxes
        leftBoxName="boxSottoTipiDisponibili"
        leftList="<%=listaSottoTipiDisponibili%>"
        leftReorder="true"
        leftTitle="available"
        rightBoxName="boxSottoTipiScelti"
        rightList="<%=listaSottoTipiScelti %>"
        rightTitle="selected"
        rightReorder="true"
    />

	<aui:input name="notes" type="textarea" 
		value="<%=Validator.isNotNull(radunoEdit) ? radunoEdit.getNote() : StringPool.BLANK %>"></aui:input>


	<div class="btn-field-align">
		<div id="assotiationIt">
			<aui:input inlineField="true" name="esfAssociation" disabled="true" type="text" 
				value="<%=Validator.isNotNull(associazione) ? associazione.getName() : StringPool.BLANK %>" />


			<aui:button class="aui-icon aui-icon-large aui-iconfont-add" id='<%=namespace + "chooseAssociationTrigger"%>'
				value="add"  >
			</aui:button>

			<aui:button class="aui-icon aui-icon-large aui-iconfont-delete"
				id='<%=namespace + "deleteAssociationTrigger"%>' value="delete">
			</aui:button>

			<aui:input type="text" name="site" 
				value="<%=Validator.isNotNull(radunoEdit) ? radunoEdit.getAltra_sede_ospitante() : StringPool.BLANK %>" />
		</div>
	</div>

	<aui:button-row>
		<aui:button type="submit" value="save">
		</aui:button>

		<aui:button type="cancel" onClick='<%= backURL.toString() %>'></aui:button>
	</aui:button-row>

</aui:form>


