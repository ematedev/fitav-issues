<%@page import="it.ethica.esf.util.DateUtilFormatter"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFMatchTypeImpl"%>
<%@page import="it.ethica.esf.model.ESFMatchType"%>
<%@page
	import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@page
	import="it.ethica.esf.model.impl.ESFInstructsShootingDirectorImpl"%>
<%@page import="it.ethica.esf.model.ESFInstructsShootingDirector"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveCode"%>
<%@page import="it.ethica.esf.model.impl.ESFSuspensiveCodeImpl"%>
<%@page
	import="it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveShootingDirector"%>
<%@page import="it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="init.jsp"%>

<%
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	String currDate = "";
	String shDrName = "";
	String tableType = ParamUtil.getString(request, "tableType", "view");
	String backPage = null;
	
	if("view".equals(tableType)){
		backPage = "view.jsp";
	}else if("newView".equals(tableType)){
		backPage = "newShootingDirector.jsp";
	}else if("info".equals(tableType)){
		backPage = "shootingDirectorInfo.jsp";
	}else{
		backPage = "view.jsp";
	}
	ESFUser shDr = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);

	// Ottieni Id assegnazione dal parametro ricevuto
	long idAssegnazioneDirettoreDiTiro = ParamUtil.getLong(request, "esfShootingDirectorId");

	//Ottieni le informazioni relative all'assegnazione con id uguale esfShootingDirectorId del direttore di tiro
	ESFShootingDirector assegnazioneDirettoreDiTiro = ESFShootingDirectorLocalServiceUtil
			.fetchESFShootingDirector(idAssegnazioneDirettoreDiTiro);

	String qualifica = "";
	String sportTypeName = "";
	List<ESFCard> cardstest = new ArrayList<ESFCard>();
	String cardCode = "";
	try {
		cardstest = ESFCardLocalServiceUtil.findActualUserCards(assegnazioneDirettoreDiTiro.getEsfUserId());

		if (Validator.isNotNull(cardstest) && 0 < cardstest.size()) {
			cardCode = cardstest.get(0).getCode();
		}

	} catch (Exception e) {

	}
	if (Validator
			.isNotNull(ESFShootingDirectorQualificationLocalServiceUtil.fetchESFShootingDirectorQualification(
					assegnazioneDirettoreDiTiro.getShootingDirectorQualificationId()))) {
		qualifica = ESFShootingDirectorQualificationLocalServiceUtil
				.fetchESFShootingDirectorQualification(
						assegnazioneDirettoreDiTiro.getShootingDirectorQualificationId())
				.getEsfShootingDirectorQualificationDesc();
	}
	if (Validator.isNotNull(
			ESFSportTypeLocalServiceUtil.fetchESFSportType(assegnazioneDirettoreDiTiro.getSportTypeId()))) {
		sportTypeName = ESFSportTypeLocalServiceUtil
				.fetchESFSportType(assegnazioneDirettoreDiTiro.getSportTypeId()).getName();
	}
	
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + backPage %>' />
	<portlet:param name="esfUserId" value="<%= String.valueOf(esfUserId)%>" />
</portlet:renderURL>

<portlet:actionURL name="updateShooterDirector"
	var="updateShooterDirectorURL">
	<portlet:param name="esfStartData"
		value="<%=sdf.format(assegnazioneDirettoreDiTiro.getEsfStartData())%>" />
	<portlet:param name="esfShootingDirectorId"
		value="<%=String.valueOf(idAssegnazioneDirettoreDiTiro)%>" />
	<portlet:param name="mvcPath" value='<%=templatePath + backPage%>' />
	<portlet:param name="mvcPathErr" value='<%=templatePath + "edit_shootingDirectorInfo.jsp"%>' />
	<portlet:param name="esfUserId" value="<%= String.valueOf(esfUserId)%>" />
</portlet:actionURL>

<liferay-ui:error key="error-shooting-director-update" message="error-shooting-director-update" />

<aui:form action="<%=updateShooterDirectorURL%>" name="<portlet:namespace />fm">
		<aui:fieldset>
		<% String startDate = DateUtilFormatter.formatDate( DateUtilFormatter.DEFAULT_DATE_FORMAT_ENG, assegnazioneDirettoreDiTiro.getEsfStartData() ); %>
		<aui:script>
		$(function() {
			$("#<portlet:namespace/>startDate").datepicker();
			
			$("#<portlet:namespace/>startDate").datepicker("setDate", '<%= startDate %>');
			$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat", 'dd/mm/yy');
			
		});
		</aui:script>

	<aui:input name="name" value="<%=shDr.getFirstName()%>" readonly="true"/>
	<aui:input name="Cognome" value="<%=shDr.getLastName()%>" readonly="true"/>
	<aui:input name="card" value="<%=cardCode%>" readonly="true"/>
	<aui:input name="region-code" value="<%=assegnazioneDirettoreDiTiro.getRegionId()%>" readonly="true"/>
	<aui:input name="qualification" value="<%=qualifica%>" readonly="true"/>
	<aui:input name="sport-type" value="<%=sportTypeName%>" readonly="true"/>
	<aui:input type="text" name="startDate">
		<aui:validator name="required" />
	</aui:input>

	<aui:button type="submit" value="Edit" inlineField="true" />

	<aui:button onClick='<%=backURL.toString() %>' value="back"
		inlineField="true" />

</aui:fieldset>
</aui:form>