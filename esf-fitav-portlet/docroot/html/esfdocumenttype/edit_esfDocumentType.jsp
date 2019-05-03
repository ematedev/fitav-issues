<%@ include file="init.jsp"%>

<%
//Leggo il documento da modificare
long documentID = ParamUtil.getLong(request, "esfDocumentTypeId");
boolean isEditRequest = documentID > 0;
ESFDocumentType documentType = null;
String descrizione = null;
String expirationMonthsNotice = null;
//Se ho passato un id maggiore di zero allora sto chiedendo la modifica
if(isEditRequest){
	//Leggo l'entita da modificare dal DB
	documentType = ESFDocumentTypeLocalServiceUtil.getESFDocumentType(documentID);	
}
//Se ho un entita da cui leggere prendo i valori di descrizione e mesi di preavviso
if(Validator.isNotNull(documentType)){
	descrizione = documentType.getDescription();
	expirationMonthsNotice = String.valueOf(documentType.getExpirationMonthsNotice()) ;
}else{
	//Altrimenti li setto come vuoti
	descrizione = "";
	expirationMonthsNotice = "";
}
%>

<aui:button-row>
	<!-- Bottone per tornare alla vista principale della portlet (view.jsp) -->
	<aui:button onClick="${viewURL}" value="go-back" />
</aui:button-row>

<portlet:actionURL var="editESFDocumentTypeURL" name="editESFDocumentType">
	<portlet:param name="esfDocumentTypeId" value="${documentID}"/>
</portlet:actionURL>

<aui:form action="${editESFDocumentTypeURL}" enctype="multipart/form-data" name="fm">
	<aui:fieldset>
		<aui:input type="text" label="" name="description" value="${descrizione}" ></aui:input>
		<aui:input type="text" labe="" name="expirationMonthsNotice" value="${expirationMonthsNotice}"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="${viewURL}"></aui:button>
	</aui:button-row>
</aui:form>