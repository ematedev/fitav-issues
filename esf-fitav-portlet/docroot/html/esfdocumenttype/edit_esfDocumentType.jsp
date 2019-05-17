<%@ include file="init.jsp"%>

<%
//Leggo il documento da modificare
long documentID = ParamUtil.getLong(request, "esfDocumentTypeId");
boolean isEditRequest = documentID > 0;
ESFDocumentType documentType = null;
String esfDocumentTypeId = null;
String descrizione = null;
String expirationMonthsNotice = null;
//Se ho passato un id maggiore di zero allora sto chiedendo la modifica
if(isEditRequest){
	documentType = ESFDocumentTypeLocalServiceUtil.getESFDocumentType(documentID);
}
//Se ho un entita da cui leggere prendo i valori di descrizione e mesi di preavviso

if(Validator.isNotNull(documentType)){
	esfDocumentTypeId = String.valueOf(documentType.getEsfDocumentTypeId());
	descrizione = documentType.getDescription();
	expirationMonthsNotice = String.valueOf(documentType.getExpirationMonthsNotice()) ;
}else{
	//Altrimenti li setto come vuoti
	esfDocumentTypeId = String.valueOf(documentID);
	descrizione = "";
	expirationMonthsNotice = "";
}
%>

<liferay-ui:error key="error-document-type-persist" message="error-document-type-persist" />

<aui:button-row>
	<!-- Bottone per tornare alla vista principale della portlet (view.jsp) -->
	<aui:button onClick="${viewURL}" value="go-back" />
</aui:button-row>
<portlet:actionURL var="editESFDocumentTypeURL" name="editESFDocumentType">
	<portlet:param name="esfDocumentTypeId" value="<%=esfDocumentTypeId%>"/>
</portlet:actionURL>

<aui:form action="${editESFDocumentTypeURL}" name="fm">
	<aui:fieldset>
		<aui:input type="text" label="document-type-desc" name="description" value="<%=descrizione%>" required="required" ></aui:input>
		<aui:input type="text" label="expirationMonthsNotice" name="expirationMonthsNotice" value="<%=expirationMonthsNotice%>" required="required"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
		<aui:button type="cancel" onClick="${viewURL}" value="back"></aui:button>
	</aui:button-row>
</aui:form>