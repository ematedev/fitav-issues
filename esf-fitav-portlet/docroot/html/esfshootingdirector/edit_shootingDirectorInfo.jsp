<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFMatchTypeImpl"%>
<%@page import="it.ethica.esf.model.ESFMatchType"%>
<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFInstructsShootingDirectorImpl"%>
<%@page import="it.ethica.esf.model.ESFInstructsShootingDirector"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveCode"%>
<%@page import="it.ethica.esf.model.impl.ESFSuspensiveCodeImpl"%>
<%@page import="it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSuspensiveShootingDirector"%>
<%@page import="it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="init.jsp"%>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = "";
String shDrName = "";
currDate = ManageDate.CalendarToString(calendar);
// List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
// List<ESFSportType> sportTypes = new ArrayList<ESFSportType>();
ESFUser shDr = new ESFUserImpl();
shDr = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);
if(Validator.isNotNull(shDr)){
	shDrName = shDr.getFirstName() + " " + shDr.getLastName();
	
}



long esfShootingDirectorId = ParamUtil.getLong(request, "esfShootingDirectorId");
<<<<<<< HEAD
//ESFShootingDirector direttoreDiTiro = ESFShootingDirectorLocalServiceUtil.fetchESFShootingDirector(esfShootingDirectorId);
=======
ESFShootingDirector direttoreDiTiro = ESFShootingDirectorLocalServiceUtil.fetchESFShootingDirector(esfShootingDirectorId);
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6

// shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
// sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<<<<<<< HEAD
<portlet:actionURL name="editESFShootingDirector" var="editESFShootingDirectorURL">
	<portlet:param name="esfStartData"
		value="<%=String.valueOf(esfShootingDirectorId)%>" />
=======
<portlet:actionURL name="updateShooterDirector" var="updateShooterDirectorURL">
	<portlet:param name="esfStartData"
		value="<%=String.valueOf(esfShootingDirectorId)%>" />
	<portlet:param name="mvcPath"
		value='<%=templatePath + "shootingDirectorInfo.jsp"%>'/>
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
</portlet:actionURL>

<liferay-ui:search-container emptyResultsMessage="no-result" curParam="ShootingDirector">

	<liferay-ui:search-container-results
	
		results="<%=ESFShootingDirectorLocalServiceUtil.findByUserId(esfUserId, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFShootingDirectorLocalServiceUtil.countByUserId(esfUserId)%>"/>
	
	
	
		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFShootingDirector" modelVar="shDt">
		
		<%
			ESFUser shDtInfo = new ESFUserImpl();
			ESFCard userCard= null;
			List<ESFCard> cardstest = new ArrayList<ESFCard>();
			String name = "";
			String cardCode = "";
			String qualification ="";
			String stName= "";
			
			if(Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()))){
				name = ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getFirstName();
				
				name = name + " " + ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getLastName();
				
				try{
					cardstest = ESFCardLocalServiceUtil.findActualUserCards(shDt.getEsfUserId());
					
					if(Validator.isNotNull(cardstest) && 0 < cardstest.size()){
						cardCode = cardstest.get(0).getCode();
					}
					
				}
				catch(Exception e){
					
				}
			}
			
			if(Validator.isNotNull(ESFShootingDirectorQualificationLocalServiceUtil.fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()))){
				qualification = ESFShootingDirectorQualificationLocalServiceUtil.
						fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()).getEsfShootingDirectorQualificationDesc();
			}
			
			if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()))){
				stName = ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()).getName();
			}
			
		%>
		
		<liferay-ui:search-container-column-text name="name" value="<%=name %>" />
		<liferay-ui:search-container-column-text name="card" value="<%=cardCode %>"/>
		<liferay-ui:search-container-column-text name="region-code" value="<%=shDt.getRegionId() %>" />
		<liferay-ui:search-container-column-text name="qualification" value="<%=qualification %>" />
		<liferay-ui:search-container-column-text name="sport-type" value="<%=stName %>" />
		<aui:input name="esf-date-assign" value="<%=sdf.format(shDt.getEsfStartData()) %>">
			<aui:validator name="required"/> 
		</aui:input>
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<<<<<<< HEAD
<aui:button onClick='<%=editESFShootingDirectorURL.toString() %>' value="Edit" inlineField="true"/>
=======
<aui:button onClick='<%=updateShooterDirectorURL.toString() %>' value="Edit" inlineField="true"/>
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6

<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>


