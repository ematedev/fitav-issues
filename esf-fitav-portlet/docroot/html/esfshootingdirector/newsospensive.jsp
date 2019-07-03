<%@page import="it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveShootingDirector"%> 
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFMatchType"%>
<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFInstructsShootingDirector"%>
<%@page import="it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveCode"%>
<%@include file="init.jsp"%>

<%


String userName  =""; 
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfSuspensionId = ParamUtil.getLong(request, "esfSuspensionId");
ESFUser userRaised = new ESFUserImpl();

//Se il tiratore ha un id valido...
if(0 < esfUserId){
	//Prendo l'istanza corrispondente
	userRaised = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);
	//Prendo nome e cognome
	userName = userRaised.getFirstName() + " " + userRaised.getLastName(); 
}

//Inizializzazione variabili
List<ESFSuspensiveCode> suspensiveCodes = new ArrayList<ESFSuspensiveCode>();
List<ESFInstructsShootingDirector> insShDrs = new ArrayList<ESFInstructsShootingDirector>();
List<ESFMatchType> matchTypes = new ArrayList<ESFMatchType>();

//Trova tutte le sospensioni
suspensiveCodes = ESFSuspensiveCodeLocalServiceUtil.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

//Trova tutti gli incarichi
insShDrs = ESFInstructsShootingDirectorLocalServiceUtil.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

//Trova tutti i tipi di gare
matchTypes = ESFMatchTypeLocalServiceUtil.findAll();

//Definisci il formato della data
SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");

//Prendi un oggetto calendar e ricava il data di oggi
Calendar calendar = CalendarFactoryUtil.getCalendar();
calendar.setTime(new Date());
String	startDate = calendar.toString() ;
String endDate = calendar.toString();

%>

<h3>Aggiunta sospensione per tiratore <%= userName%></h3>

<!-- Definisce l'azione di aggiornamento della sospensione -->
<portlet:actionURL name="updateSuspensive" var="updateSuspensiveURL">
	<portlet:param name="esfUserId"
		value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="esfSuspensionId"
		value="<%=String.valueOf(esfSuspensionId)%>" />
	<portlet:param name="mvcPath"
		value='<%=templatePath + "shootingDirectorInfo.jsp"%>'/>
</portlet:actionURL>

<!-- Definisce il form per  -->
<aui:form action="<%=updateSuspensiveURL%>" name="<portlet:namespace />fm" >
		<div>
			<aui:select name="suspensiveCode" label="suspensionCode" inlineField="true">
					<aui:option label="-" value="0" />
				<%
				for(ESFSuspensiveCode sc : suspensiveCodes){
				%>
					<aui:option label="<%=sc.getCode()%>"	 value="<%=sc.getEsfSuspensiveCodeId()%>" />
				<%
				}
				%>
			</aui:select>
			
			<aui:input name="startDate" type="text" inlineField="true">
				<aui:validator name="required" errorMessage="this-field-is-required" />
			</aui:input>
		
			<aui:input name="endDate" type="text" inlineField="true">
				<aui:validator name="required" errorMessage="this-field-is-required" />
			</aui:input>
			
			<aui:input name="note" type="textarea" inlineField="true" />
			
		</div>
			
		<%
		List<KeyValuePair> leftListeInstructs = new ArrayList<KeyValuePair>();
		List<KeyValuePair> rightListeInstructs  = new ArrayList<KeyValuePair>();
		
		if(0 < esfSuspensionId){
			List<Long> splits = new ArrayList<Long>();
			
			ESFSuspensiveShootingDirector suspensive = ESFSuspensiveShootingDirectorLocalServiceUtil.fetchESFSuspensiveShootingDirector(esfSuspensionId);
			
			if(0 < suspensive.getQualif1_Utiliz()){
				splits.add(suspensive.getQualif1_Utiliz());
			}
			if(0 < suspensive.getQualif2_Utiliz()){
				splits.add(suspensive.getQualif2_Utiliz());
			}
			if(0 < suspensive.getQualif2_Utiliz()){
				splits.add(suspensive.getQualif3_Utiliz());
			}
			
			for(ESFInstructsShootingDirector insShDr : insShDrs){
				if(!splits.contains(insShDr.getEsfInstructsShootingDirectorId())){
					leftListeInstructs.add(new KeyValuePair(String.valueOf(insShDr.getEsfInstructsShootingDirectorId()) , insShDr.getEsfInstructsShootingDirectorCode()));
				}
			}
			
			for(Long id : splits){
				ESFInstructsShootingDirector inShDr  = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(id);
				rightListeInstructs.add(new KeyValuePair(String.valueOf(inShDr.getEsfInstructsShootingDirectorId()) , inShDr.getEsfInstructsShootingDirectorCode()));
			}
			
		}else{
			for(ESFInstructsShootingDirector insShDr : insShDrs){
				leftListeInstructs.add(new KeyValuePair(String.valueOf(insShDr.getEsfInstructsShootingDirectorId()) , insShDr.getEsfInstructsShootingDirectorCode()));
			}
		}
		
		%>
		
			<liferay-ui:message key="InstructsSospensions">InstructsSospensions</liferay-ui:message>
			
			<aui:input name="valuesInstructsSospensions" type="hidden" />
			<liferay-ui:input-move-boxes
				leftBoxName="availableValuesInstructs"
				leftList="<%= leftListeInstructs%>"
				leftReorder="true"
				leftTitle="available"
				rightBoxName="selectedValuesInstructs"
				rightList="<%=rightListeInstructs%>"
				rightTitle="selected"
			/>
		
		<%
		
		List<KeyValuePair> leftListeMatchTypes = new ArrayList<KeyValuePair>();
		List<KeyValuePair> rightListeMatchTypes  = new ArrayList<KeyValuePair>();
		
		if(0 < esfSuspensionId){
			List<Long> splits = new ArrayList<Long>();
			
			ESFSuspensiveShootingDirector suspensive = ESFSuspensiveShootingDirectorLocalServiceUtil.fetchESFSuspensiveShootingDirector(esfSuspensionId);
			
			if(0 < suspensive.getTipo_Gara1_noUtil()){
				splits.add(suspensive.getTipo_Gara1_noUtil());
			}
			if(0 < suspensive.getTipo_Gara2_noUtil()){
				splits.add(suspensive.getTipo_Gara2_noUtil());
			}
			if(0 < suspensive.getTipo_Gara3_noUtil()){
				splits.add(suspensive.getTipo_Gara3_noUtil());
			}
			if(0 < suspensive.getTipo_Gara4_noUtil()){
				splits.add(suspensive.getTipo_Gara4_noUtil());
			}
			if(0 < suspensive.getTipo_Gara5_noUtil()){
				splits.add(suspensive.getTipo_Gara5_noUtil());
			}
			if(0 < suspensive.getTipo_Gara6_noUtil()){
				splits.add(suspensive.getTipo_Gara6_noUtil());
			}
			if(0 < suspensive.getTipo_Gara7_noUtil()){
				splits.add(suspensive.getTipo_Gara7_noUtil());
			}
			if(0 < suspensive.getTipo_Gara8_noUtil()){
				splits.add(suspensive.getTipo_Gara8_noUtil());
			}
			if(0 < suspensive.getTipo_Gara9_noUtil()){
				splits.add(suspensive.getTipo_Gara9_noUtil());
			}
			if(0 < suspensive.getTipo_Gara10_noUtil()){
				splits.add(suspensive.getTipo_Gara10_noUtil());
			}
			
			for(Long id : splits){
				ESFMatchType mt  = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(id);
				rightListeInstructs.add(new KeyValuePair(String.valueOf(mt.getEsfMatchTypeId()) , mt.getName()));
			}
			
		}else{
			for(ESFMatchType matchType : matchTypes){
				leftListeMatchTypes.add(new KeyValuePair(String.valueOf(matchType.getEsfMatchTypeId()) , matchType.getName()));
			}
			
		}
		
		%>
		
			<liferay-ui:message key="esfMatchTypeId">esfMatchTypeId</liferay-ui:message>
			
			<aui:input name="valuesMatchSospensions" type="hidden" />
			<liferay-ui:input-move-boxes
				leftBoxName="availableValuesMatchType"
				leftList="<%= leftListeMatchTypes%>"
				leftReorder="true"
				leftTitle="available"
				rightBoxName="selectedValuesMatchType"
				rightList="<%=rightListeMatchTypes%>"
				rightTitle="selected"
			/>
			
	<aui:button type="submit" value="add-suspensive" onclick="submitForms()"/>
</aui:form>

<aui:script use="aui-base,node,aui-io-request,liferay-util-list-fields">
$(function() {
	$("#<portlet:namespace/>startDate").datepicker();
	$("#<portlet:namespace/>startDate").datepicker("setDate", '<%= startDate %>');
	$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat", 'dd/mm/yy');
	
});

$(function() {
	$("#<portlet:namespace/>endDate").datepicker();
	$("#<portlet:namespace/>endDate").datepicker("setDate", '<%= endDate %>');
	$("#<portlet:namespace/>endDate").datepicker("option", "dateFormat", 'dd/mm/yy');
});

submitForms = function(){
var selectedValuesInstructs = Liferay.Util.listSelect('#<portlet:namespace/>selectedValuesInstructs');
var selectedValuesMatchType = Liferay.Util.listSelect('#<portlet:namespace/>selectedValuesMatchType');

console.log("selectedValuesInstructs="+selectedValuesInstructs);
console.log("selectedValuesMatchType="+selectedValuesMatchType);

A.one('#<portlet:namespace/>valuesInstructsSospensions').val(selectedValuesInstructs);
A.one('#<portlet:namespace/>valuesMatchSospensions').val(selectedValuesMatchType);

}
</aui:script>
