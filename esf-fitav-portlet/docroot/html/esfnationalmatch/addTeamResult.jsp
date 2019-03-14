<%@page import="it.ethica.esf.model.impl.ESFResultImpl"%>
<%@page import="it.ethica.esf.service.ESFResultLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFResult"%>
<%@page import="it.ethica.esf.service.ESFShooterQualificationESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterQualificationESFMatch"%>
<%@include file="init.jsp"%>


<%
long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

List<ESFShooterQualification> sqs = new ArrayList<ESFShooterQualification>();
List<ESFSportType>st = new ArrayList<ESFSportType>();
List<ESFShooterQualificationESFMatch> sqMs = new ArrayList<ESFShooterQualificationESFMatch>();
List<ESFNationalDelegation> nds = new ArrayList<ESFNationalDelegation>();
List<ESFResult> teamResult = new ArrayList<ESFResult>();
String[]stMIdS = null;

ESFMatch match = new ESFMatchImpl();

sqMs = ESFShooterQualificationESFMatchLocalServiceUtil.findbyMatchId(esfMatchId);

match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);

if(Validator.isNotNull(match) && Validator.isNotNull(match.getEsfNationalSportTypeId())){
	
	stMIdS = match.getEsfNationalSportTypeId().split("-");
	
}
%>

<portlet:actionURL var="addNationalTeamResNewURL" name="addNationalTeamResNew">
		<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="companyId"
				value="<%=String.valueOf(company.getCompanyId())%>" />
		<portlet:param name="groupId"
				value="<%=String.valueOf(group.getGroupId())%>" />
		<portlet:param name="userId"
				value="<%=String.valueOf(user.getUserId())%>" />
		<portlet:param name="mvcPath"
				value="/esfnationalmatch/edit_esfAddResult.jsp"/>
</portlet:actionURL>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>


<aui:form action="<%=addNationalTeamResNewURL%>" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitNationalMatchTeamRes();" %>'>
<%
int numTeam = 0;

for(ESFShooterQualificationESFMatch sq : sqMs){
	for(String stId : stMIdS){
		
	String sportTypeName = "";
	String qualificationName = "";
	
		if(StringPool.BLANK.equals(stId)){
			stId = "0";
		}
		
		if(Validator.isNotNull(stId) && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId))) &&
				Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId)).getName())){
			sportTypeName = ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stId)).getName();
		}
		
		if(Validator.isNotNull(sq) && Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sq.getEsfShooterQualificationId())) &&
				Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sq.getEsfShooterQualificationId()).getName())){
			qualificationName = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sq.getEsfShooterQualificationId()).getName();
		}
		
		nds = ESFNationalDelegationLocalServiceUtil.getMatchId_SportTypeId_QualificationId(esfMatchId, Long.valueOf(stId), sq.getEsfShooterQualificationId());

		if(2 < nds.size()){
			
			int position = 0;
			teamResult = ESFResultLocalServiceUtil.findByESFMId_STId_SQId_TEAM(esfMatchId, Long.valueOf(stId), sq.getEsfShooterQualificationId());
			
			if(0 < teamResult.size()){
				position = teamResult.get(0).getResultClassTeam();
			}
			
		
%>
<h3>Seleziona squadra per la qualifica <%= qualificationName%>, specialità <%= sportTypeName%></h3>

<aui:input name='<%= "position"+sq.getEsfShooterQualificationId()+stId%>' 
	label="position" inlineField="true" type="number" cssClass="TeamResult_class" value="<%=position %>"></aui:input>

<%

			for(ESFNationalDelegation nd : nds){
				ESFUser shooter = new ESFUserImpl();
				String shooterName = "";
				
				boolean checked = false;
				
				ESFResult shooterResult = new ESFResultImpl();
				shooterResult = ESFResultLocalServiceUtil.
						getESFResultByESFMatchId_ESFUserId_SportTypeId_QualificationId_Team(esfMatchId, nd.getEsfUserId(), Long.valueOf(stId), sq.getEsfShooterQualificationId());
				
				if(3 == nds.size()){
					checked = true;
				}
				
				
				if(Validator.isNotNull(shooterResult)){
					checked = true;
				}
				
				if(Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(nd.getEsfUserId()))){
					shooterName = ESFUserLocalServiceUtil.fetchESFUser(nd.getEsfUserId()).getFirstName() + " " + ESFUserLocalServiceUtil.fetchESFUser(nd.getEsfUserId()).getLastName();
				}

%>	
<div>
	<aui:input name='<%= "selected" + numTeam%>'  label="" inlineField="true"  type="checkbox" inlinefield="true" checked="<%=checked %>"></aui:input>
	<aui:input value='<%= shooterName%>' name='<%="shooter" + nd.getEsfUserId() %>' label="shooterName" inlineField="true"  type="text" readonly="true" inlinefield="true"></aui:input>
	<aui:input name='<%="shooterQualificationId"+numTeam %>'  label="" inlineField="true"  type="hidden" value="<%=sq.getEsfShooterQualificationId() %>"></aui:input>
	<aui:input name='<%="shooterSportTypeIdId"+numTeam %>'  label="" inlineField="true"  type="hidden" value="<%=stId %>"></aui:input>
	<aui:input name='<%="shooterId"+numTeam %>'  label="" inlineField="true"  type="hidden" value="<%=nd.getEsfUserId() %>"></aui:input>
</div>
<%	
				numTeam = numTeam + 1 ;
			}
		}
	}
}
%>
	<aui:input name='numTeam'  label="" inlineField="true"  type="hidden" value="<%=numTeam %>"></aui:input>
	<aui:button name="submit" type="submit" inlineField="true" ></aui:button>
	<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>
</aui:form>

<script>
var A = AUI();
function <portlet:namespace />submitNationalMatchTeamRes(){
	var error = false
	
	var numTeam = A.one('#<portlet:namespace />numTeam').val();
	var checked = 0;
	
	for(var i = 0 ; i < numTeam ; i++){
		
		if( A.one('#<portlet:namespace />selected'+i).val() == 'true'){
			checked = checked +1;
		}
	}
	
	var result = checked%3;
	
	if(0 == result ){
		submitForm(document.<portlet:namespace />fm);
	} else{
		alert("Verificare gli atleti selezionati");
	}
	
}
</script>
