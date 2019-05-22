<%@ include file="init.jsp"%>

<%
//Leggo il documento da modificare
long entityID = ParamUtil.getLong(request, "esfPublicAuthorityId");
boolean isEditRequest = entityID > 0;
ESFPublicAuthority entity = null;
String esfPublicAuthorityId = null;
String descrizione = null;
//Se ho passato un id maggiore di zero allora sto chiedendo la modifica
if(isEditRequest){
	entity = ESFPublicAuthorityLocalServiceUtil.getESFPublicAuthority(entityID);
}
//Se ho un entita da cui leggere prendo i valori di descrizione e mesi di preavviso

if(Validator.isNotNull(entity)){
	esfPublicAuthorityId = String.valueOf(entity.getEsfPublicAuthorityId());
	descrizione = entity.getDescription();
}else{
	//Altrimenti li setto come vuoti
	esfPublicAuthorityId = String.valueOf(entityID);
	descrizione = "";
}
%>

<liferay-ui:error key="error-public-authority-persist" message="error-public-authority-persist" />

<aui:button-row>
	<!-- Bottone per tornare alla vista principale della portlet (view.jsp) -->
	<aui:button onClick="${viewURL}" value="go-back" />
</aui:button-row>
<portlet:actionURL var="editESFPublicAuthorityURL" name="editESFPublicAuthority">
	<portlet:param name="esfPublicAuthorityId" value="<%=esfPublicAuthorityId%>"/>
</portlet:actionURL>

<aui:form action="${editESFPublicAuthorityURL}" name="fm">
	<aui:fieldset>
		<aui:input type="text" label="public-authority-desc" name="description" value="<%=descrizione%>" required="required" ></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
		<aui:button type="cancel" onClick="${viewURL}" value="back"></aui:button>
	</aui:button-row>
</aui:form>