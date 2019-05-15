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

List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
List<ESFSportType> sportTypes = new ArrayList<ESFSportType>();

ESFUser shDr = new ESFUserImpl();

shDr = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);

if(Validator.isNotNull(shDr)){
	shDrName = shDr.getFirstName() + " " + shDr.getLastName();
	
}

shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();


%>

<h3><liferay-ui:message key="infromation-shDR-x" arguments="<%=shDrName %>" /></h3>
<liferay-ui:error key="findingOld" message="findingOld" />
<liferay-ui:error key="error-delete-shDr" message="error-delete-shDr" />


<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<portlet:actionURL name="deleteESFShdr" var="deleteURL">
			<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
			<portlet:param name="mvcPath" value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
</portlet:actionURL>

<portlet:renderURL var="convocationsURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "convocations.jsp"%>' />
	<portlet:param name="esfUserId"
		value="<%=String.valueOf(esfUserId)%>" />
</portlet:renderURL>

<portlet:actionURL name="addShooterDirector" var="addShooterDirectorURL">
	<portlet:param name="esfUserId"
		value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="mvcPath"
		value='<%=templatePath + "shootingDirectorInfo.jsp"%>'/>
</portlet:actionURL>

<aui:form action="<%=addShooterDirectorURL%>" name="<portlet:namespace />fm" >
	<div class="btn-field-align">
	
		<aui:select  name="shDtId" inlineField="<%=true%>" label="qualification" >
			<aui:option value="0" label="-"></aui:option>
				<%for(ESFShootingDirectorQualification s : shDts){%>
			<aui:option value="<%=s.getEsfShootingDirectorQualificationId()%>"  label="<%=s.getEsfShootingDirectorQualificationDesc()%>"></aui:option>
				<%}%>
		</aui:select>
		<aui:select  name="stId" inlineField="<%=true%>" label="sport-type" >
			<aui:option value="0"  label="-"></aui:option>
				<%for(ESFSportType st : sportTypes){%>
			<aui:option value="<%=st.getEsfSportTypeId()%>"  label="<%=st.getName()%>"></aui:option>
				<%} %>
		</aui:select>
		
		<aui:input name="startDate" type="text" label="start-date" inlineField="<%=true%>"/>

		<aui:button type="submit" value="add" />
		<aui:button onClick='<%=convocationsURL.toString() %>' value="convocations" inlineField="true"/>
	</div>
</aui:form>

<h4><b><liferay-ui:message key="assignment" /></b>
				<div class="separator"></div>

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
		<liferay-ui:search-container-column-text name="esf-date-assign" value="<%=sdf.format(shDt.getEsfStartData()) %>" />
		<liferay-ui:search-container-column-text name = "delete" >
			<aui:form action = "<%=deleteURL%>">
				<aui:input name="shDrId" value="<%=String.valueOf(shDt.getEsfShootingDirectorId()) %>" type="hidden"></aui:input>
				<aui:button type = "delete" value = "delete" align="right"  confirmation="delete_confirm"></aui:button>
			</aui:form>
		
		</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<h4><b><liferay-ui:message key="suspensive" /></b>
				<div class="separator"></div>

<liferay-ui:search-container emptyResultsMessage="no-result" curParam="suspensive">

		
	<liferay-ui:search-container-results
		results="<%=ESFSuspensiveShootingDirectorLocalServiceUtil.findByUserId(esfUserId, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFSuspensiveShootingDirectorLocalServiceUtil.countByUserId(esfUserId)%>" />
		
		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFSuspensiveShootingDirector" modelVar="suspensive">
				
		<%
		String suspcode = "";
		String instructsName = "";
		String suspendedMatch = "";
		
		ESFSuspensiveCode codeSusp = new ESFSuspensiveCodeImpl();
		ESFInstructsShootingDirector ins = new ESFInstructsShootingDirectorImpl();
		ESFMatchType matchType =new ESFMatchTypeImpl();
		
		if(0 < suspensive.getCodice_Sosp()){
			codeSusp = ESFSuspensiveCodeLocalServiceUtil.fetchESFSuspensiveCode(suspensive.getCodice_Sosp());
			if(Validator.isNotNull(codeSusp)){
				suspcode = codeSusp.getCode();
			}
		}
		//prendo gli incarichi sospesi
		if(0 < suspensive.getQualif1_Utiliz()){
			ins = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(suspensive.getQualif1_Utiliz());
			if(Validator.isNotNull(ins)){
				instructsName = ins.getEsfInstructsShootingDirectorCode();
			}
		}
		if(0 < suspensive.getQualif2_Utiliz()){
			ins = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(suspensive.getQualif2_Utiliz());
			if(Validator.isNotNull(ins)){
				instructsName = instructsName + "-" + ins.getEsfInstructsShootingDirectorCode();
			}
		}
		if(0 < suspensive.getQualif3_Utiliz()){
			ins = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(suspensive.getQualif3_Utiliz());
			if(Validator.isNotNull(ins)){
				instructsName = instructsName + "-" + ins.getEsfInstructsShootingDirectorCode();
			}
		}
		//prendo i matchType sospesi
		if(0 < suspensive.getTipo_Gara1_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara1_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara2_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara2_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara2_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara2_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara3_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara3_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara4_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara4_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara5_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara5_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara6_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara6_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara7_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara7_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara8_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara8_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara9_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara9_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		if(0 < suspensive.getTipo_Gara10_noUtil()){
			matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(suspensive.getTipo_Gara10_noUtil());
			if(Validator.isNotNull(matchType)){
				suspendedMatch = suspendedMatch + "-"+matchType.getName();
			}
		}
		
		%>

			<liferay-ui:search-container-column-text name="suspensionCode" value="<%=suspcode %>" />
			<liferay-ui:search-container-column-text name="suspensiveInstructorsshDirector" value="<%=instructsName %>" />
			<liferay-ui:search-container-column-text name="esfMatchTypeId" value="<%=suspendedMatch %>" />
			<liferay-ui:search-container-column-text name="note" value="<%=suspensive.getNote() %>" />
			<liferay-ui:search-container-column-text name="start-date" value="<%=sdf.format(suspensive.getEsfStartData()) %>" />
			<liferay-ui:search-container-column-text name="end-date" value="<%=sdf.format(suspensive.getEsfEndData()) %>" />
			<liferay-ui:search-container-column-jsp
				path='<%=templatePath + "modifySuspensionAction.jsp"%>' align="right" />
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>

<aui:script use="aui-base,node,aui-io-request">

$(function() {
	$("#<portlet:namespace/>startDate").datepicker();
	$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat",
			"dd/mm/yy");
	$("#<portlet:namespace/>startDate").datepicker("setDate",
			'<%= currDate %>');

});

</aui:script>
