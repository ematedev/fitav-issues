<%@page import="it.ethica.esf.service.ESFResultLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFResult"%>
<%@page import="it.ethica.esf.portlet.utility.NationalResultsComparator"%>
<%@page import="it.ethica.esf.service.ESFMatchResultLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFMatchResult"%>
<%@page import="it.ethica.esf.service.ESFNotOlimpicMatchResultLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFNotOlimpicMatchResult"%>
<%@page import="java.util.HashMap"%>
<%@page import="it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPersistence"%>
<%@page import="it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchUtil"%>
<%@page import="it.ethica.esf.service.ESFShooterQualificationESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterQualificationESFMatch"%>
<%@include file="init.jsp"%>


<%

long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 

PortletURL viewassURL = renderResponse.createRenderURL();
viewassURL.setParameter("mvcPath", templatePath +
	"addNationalResult.jsp");
viewassURL.setParameter(
	"organizationId", String.valueOf(currentOrganizationId));
viewassURL.setWindowState(WindowState.NORMAL);


int nationalShooterCounter = 0, externalShooterCounter = 0;
String externalIds = StringPool.BLANK;
boolean canUpdate=ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_UPDATE_RESULT);
boolean missingST = false;
ESFMatch match = new ESFMatchImpl();
List<ESFUser> esfUser = new ArrayList<ESFUser>();
List<ESFShooterQualification> sqs = new ArrayList<ESFShooterQualification>();
List<ESFShooterQualificationESFMatch> sqMs = new ArrayList<ESFShooterQualificationESFMatch>();
List<ESFNationalDelegation> nds = new ArrayList<ESFNationalDelegation>();
List<ESFSportType>st = new ArrayList<ESFSportType>();
List<Long> stMId = new ArrayList<Long>();
Long sportTypeid = 0L;
String[]stMIdS = null;
String matchInfo = "risultati tiratori italiani match ";
String selectSportType = "";
String selectQualification = "<option value='0'>-</option>";
String selectStart = "<option value='";
String selectEnd = " </option>";
String finalS ="Final S";

HashMap<Long, ArrayList<Long>> hmap = new HashMap<Long, ArrayList<Long>>();
HashMap <String, String> sportTypes = new HashMap<String, String>();

match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);

nds = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);


if(Validator.isNotNull(nds)){
	for(ESFNationalDelegation nd : nds){
		if(Validator.isNotNull(nd) && Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(nd.getEsfUserId()))){
			esfUser.add(ESFUserLocalServiceUtil.fetchESFUser(nd.getEsfUserId()));
		}
		
	}
}

sqMs = ESFShooterQualificationESFMatchLocalServiceUtil.findbyMatchId(esfMatchId);

if(Validator.isNotNull(match) && Validator.isNotNull(match.getCode())){
	matchInfo = matchInfo + match.getCode();
}

if(Validator.isNotNull(match) && Validator.isNotNull(match.getEsfNationalSportTypeId())){
	
	stMIdS = match.getEsfNationalSportTypeId().split("-");
	
}

if(Validator.isNotNull(sqMs)){
	
	for(ESFShooterQualificationESFMatch sqM : sqMs){
		if(Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqM.getEsfShooterQualificationId()))){
			sqs.add(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqM.getEsfShooterQualificationId()));
			ESFShooterQualification qualification = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqM.getEsfShooterQualificationId());
			selectQualification = selectQualification + selectStart +sqM.getEsfShooterQualificationId() + "'>"+ qualification.getName() + selectEnd;
		}
	}
}

if(Validator.isNotNull(stMIdS) && stMIdS.length > 0){
	for(int i = 1 ; i < stMIdS.length ; i++){
		stMId.add(Long.valueOf(stMIdS[i]));
		ESFSportType sportType = ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(stMIdS[i]));
		selectSportType = selectSportType + selectStart + stMIdS[i] +"'>"+sportType.getName() + selectEnd;
		sportTypes.put(stMIdS[i], sportType.getName());
	}
	
}

for(ESFNationalDelegation nd : nds){
	ArrayList<Long> a = new ArrayList <Long>();
	if(hmap.containsKey(nd.getEsfSportTypeId())){
		 a = hmap.get(nd.getEsfSportTypeId());
	}	 
	a.add(nd.getEsfUserId());
	hmap.put(nd.getEsfSportTypeId(), a );
	
}

List <ESFNationalMatchResult> esfMatchResults = ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultsByESFMatchId(esfMatchId);

List <ESFResult> resultNew = ESFResultLocalServiceUtil.findByESFMatchid(esfMatchId);

List <ESFNationalMatchResult> esfExternalShooterResults = new ArrayList<ESFNationalMatchResult>();;

if(Validator.isNotNull(esfMatchResults)){
	for(ESFNationalMatchResult extRes : esfMatchResults){
		if(extRes.getExternalShooter()){
			esfExternalShooterResults.add(extRes);
		}	
	}	
}

if(0 >= sportTypes.size()){
	missingST = true;
}
%>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" 
			value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>
<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>

<portlet:actionURL var="addNationalMatchResNewURL" name="addNotOlimpicMatchRes">
		<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="companyId"
				value="<%=String.valueOf(company.getCompanyId())%>" />
		<portlet:param name="groupId"
				value="<%=String.valueOf(group.getGroupId())%>" />
		<portlet:param name="userId"
				value="<%=String.valueOf(user.getUserId())%>" />
		<portlet:param name="mvcPath"
				value="/esfnationalmatch/addNationalResult.jsp"/>
</portlet:actionURL>

<div class="alert alert-error hide" id="<portlet:namespace />submit-error">
	<liferay-ui:message key="insert-first-three-position" />
</div>

<portlet:resourceURL id="deleteExternalShooter" var="deleteExternalShooterVar">
	<portlet:param name="esfMatchId" value="<%= String.valueOf(esfMatchId) %>"/>
</portlet:resourceURL>

<h3><%=matchInfo %></h3>

<aui:form action="<%=addNationalMatchResNewURL%>" cssClass="form-table" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitNationalMatchRes();" %>' name="fm">

<div class="nationalMatchResultWrapper">

	<table class="aui" name="fmNationalResult" id ="resultTable">
	<thead>
		<tr>

			<th><%=res.getString("shooter")%></th>
			<th><%=res.getString("speciality")%></th>
			<th><%=res.getString("shooter-qualification")%></th>
			<th><%=res.getString("position")%></th>
			<th><%=res.getString("Results1")%></th>
			<th><%=res.getString("Results2")%></th>
			<th><%=res.getString("Results3")%></th>
			<th><%=res.getString("Results4")%></th>
			<th><%=res.getString("Results5")%></th>
			<th><%=res.getString("Results6")%></th>
			<th><%=res.getString("Results7")%></th>
			<th><%=res.getString("Results8")%></th>
			<th><%=res.getString("TotalS")%></th>
			<th><%=finalS%></th>
			<th><%=res.getString("finalTotal")%></th>
			<th><%=res.getString("user-nationality")%></th>

		</tr>
	</thead>
	<tbody>
	
	<aui:input type = "hidden" name = "nationalShooterCounter" id = "nationalShooterCounter" value="0"/>
		
	<aui:input type = "hidden" name = "externalShooterCounter" id = "externalShooterCounter" value="0"/>
	
	<%
	int i = 0;
	
	for(ESFNationalDelegation del : nds){
		
		ESFUser shooter = new ESFUserImpl();
		ESFSportType sportType = new ESFSportTypeImpl();
		String shooterName = "";
		String sportName = "";
		
		if(Validator.isNotNull(del) && Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId())) ){
			
			shooter = ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId());
			sportType = ESFSportTypeLocalServiceUtil.fetchESFSportType(del.getEsfSportTypeId());
			
			shooterName = shooter.getFirstName()+" "+shooter.getLastName();
			
			//ESFNotOlimpicMatchResult esfNationalMatchResult = ESFNotOlimpicMatchResultLocalServiceUtil.
				//													getESFNationalMatchResultByESFMatchId_ESFUserId(esfMatchId, del.getEsfUserId());
			
		
			ESFNationalMatchResult esfNationalMatchResult = ESFNationalMatchResultLocalServiceUtil.
																	getESFNationalMatchResultByESFMatchId_ESFUserId(esfMatchId, del.getEsfUserId());
			
			int qualificationOldVal = 0;
			if(Validator.isNotNull(esfNationalMatchResult) && Validator.isNotNull(esfNationalMatchResult.getQualification())){
				qualificationOldVal = esfNationalMatchResult.getQualification();
			}
			
	%>
	<tr>
	
		<aui:input style = "display : none;" label = "" 
						type = "text" name = '<%="ESFShooterId" + i %>'
						value='<%=String.valueOf(del.getEsfUserId())%>'/>
		
		
		<td>
			<aui:input name='<%= "shooterName" + i%>' readonly='true'
				value='<%=shooterName%>' label="" inlineField="true" class="italianShooter"></aui:input>
		</td>

		<td>
			<div>
				<aui:select label="" cssClass="sportTypeId-input external" name='<%= "shooterSportType" + i%>' >
					<%for(String sq : sportTypes.keySet()){
						
						boolean find = false;
						if(Validator.isNotNull(esfNationalMatchResult) && Validator.isNotNull(esfNationalMatchResult.getEsfSportTypeId()) &&
								String.valueOf( esfNationalMatchResult.getEsfSportTypeId()).equals(sq)){
							find = true;
						}
						%>
						<aui:option label="<%=sportTypes.get(sq)%>"  value="<%=sq%>" selected="<%=find %>"/>
					<%}%>
				</aui:select>
			</div>
		</td>
		<td>
			<aui:select id="type" name='<%="shooterQualification"+ i%>' 
						required="true" label="" width="15%" cssClass="qualificationId-input">
					<aui:option label="-" value="0" selected='<%=Validator.isNotNull(esfNationalMatchResult)&&esfNationalMatchResult.getQualification()==0?true:false %>' />
				<%for(ESFShooterQualification sq : sqs){ %>
					<aui:option label="<%=sq.getName()%>" selected='<%=Validator.isNotNull(esfNationalMatchResult)&&esfNationalMatchResult.getEsfUserQualification()==sq.getEsfShooterQualificationId()?true:false%>' value="<%=sq.getEsfShooterQualificationId()%>" />
				<%} %>
			</aui:select>
		</td>
		<td>
			<aui:input type="number" cssClass="position-input" value='<%=Validator.isNotNull(esfNationalMatchResult)?esfNationalMatchResult.getPosition():"" %>' name='<%= "position" + i%>' label=" " min="0" ></aui:input>
		</td>
		<td>
			<aui:input type="number" cssClass="nationaMatchResultSmall" value='<%= qualificationOldVal %>' name='<%= "qualification" + i%>' label=" " min="0" ></aui:input>
		</td>
		<td>
			<aui:input type="number" cssClass="nationaMatchResultSmall" value='<%=Validator.isNotNull(esfNationalMatchResult)?esfNationalMatchResult.getShootOff():"" %>' name='<%= "shoot-off" + i%>' label=" " min="0"></aui:input>
		</td>
		<td>
			<aui:input type="number" cssClass="nationaMatchResultSmall"  value='<%=Validator.isNotNull(esfNationalMatchResult)?esfNationalMatchResult.getClayPigeonTotal():"" %>' name='<%= "clay-pigeon-total" + i%>' label=" " min="0"></aui:input>
		</td>
		<td>
			<aui:input type="number" cssClass="nationaMatchResultSmall" value='<%=Validator.isNotNull(esfNationalMatchResult)?esfNationalMatchResult.getFinalResult():"" %>' name='<%= "final-result" + i%>' label=" " min="0"></aui:input>
		</td>
		<td>
			<aui:input type="number" cssClass="nationaMatchResultSmall" value='<%=Validator.isNotNull(esfNationalMatchResult)?esfNationalMatchResult.getShootOffFinal():"" %>' name='<%= "shoot-off-final" + i%>' label=" " min="0"></aui:input>
		</td>
		<td>
			<aui:input type="text" cssClass="nationaMatchResultMedium" name='<%= "user-nationality" + i%>' label=" "  readonly='true' value="Italia"></aui:input>
		</td>
	</tr>
	<%
	
		}
		i++;
	}%>
	
	<%
	for(ESFNationalMatchResult result : esfExternalShooterResults){
	
	%>
	<tr>
		<td>

			<div class="control-group shooter-name">
				
				<aui:input style="display:none;" type="text" label="" name='<%="esfNationalMatchResultId_ext_"+i%>' value="<%=result.getEsfNationalMatchResultId()%>" />
				
				<aui:input label="" type="text" name='<%="shooterName_ext_"+i%>' value="<%=result.getExternalName()%>" /><div class="delete-icon" onClick="<portlet:namespace />deleteExternalShooter(event.target);" data-value="<%=result.getEsfNationalMatchResultId()%>" data-index="<%=i%>"></div>
			</div>
		</td>
		<td>
			<div>
				<aui:select label="" cssClass="sportTypeId-input external" name='<%="sportTypeName_ext_"+i%>' showEmptyOption="true">
					<%for(String sq : sportTypes.keySet()){ %>
						<aui:option label="<%=sportTypes.get(sq)%>" selected='<%=sq.equals(String.valueOf(result.getEsfSportTypeId()))?true:false%>' value="<%=sq%>" />
					<%}%>
				</aui:select>
			</div>
		</td>
		<td>
			<div>
				
				<aui:select label="" cssClass="qualificationId-input" name='<%="shooterQualification_ext_"+i%>'>
					<aui:option label="-" value="0" selected='<%=result.getQualification()==0?true:false %>' />
					<%for(ESFShooterQualification sq : sqs){ %>
						<aui:option label="<%=sq.getName()%>" selected='<%=result.getEsfUserQualification()==sq.getEsfShooterQualificationId()?true:false%>' value="<%=sq.getEsfShooterQualificationId()%>" />
					<%}%>
				</aui:select>
			</div> 
			
		</td>
		<td>
			<aui:input label="" type="number" cssClass="position-input" min="0" name='<%="position_ext_"+i%>' value="<%=result.getPosition()%>" />
		</td>
		<td>
			<aui:input label="" type="number" min="0" name='<%="qualification_ext_"+i%>' value="<%=result.getQualification()%>" />
		</td>
		<td>
			<aui:input label="" type="number" min="0" name='<%="shoot-off_ext_"+i%>' value="<%=result.getShootOff()%>" />
		</td>
		<td>
			<aui:input label="" type="number" min="0" name='<%="clay-pigeon-total_ext_"+i%>' value="<%=result.getClayPigeonTotal()%>" />
		</td>
		<td>
			<aui:input label="" type="number" min="0" name='<%="final-result_ext_"+i%>' value="<%=result.getFinalResult()%>" />
		</td>
		<td>
			<aui:input label="" type="number" min="0" name='<%="shoot-off-final_ext_"+i%>' value="<%=result.getShootOffFinal()%>" />
		</td>
		<td>
			<aui:input label="" type="text" name='<%="user-nationality_ext_"+i%>' value="<%=result.getUserNationality()%>" cssClass="extNation_class"/>
		</td>
	</tr>

	<%
		i++;
	}%>
	
	</tbody>
		
	</table>
</div>
<br></br>
<%if(!missingST){ %>
	<aui:button name="submit" type="submit" inlineField="true" ></aui:button>
	<aui:button name="add" value="add"  onClick='<%= renderResponse.getNamespace() + "addNationalMatchRes();" %>' />
<% }%>	
	<aui:input name="externalIds" type="hidden" value="<%= externalIds %>"/>
</aui:form>

<script>
function <portlet:namespace />submitNationalMatchRes(){
	AUI().use(function(A){
			var sportTypes = [],
			qualifications = [],
			tr,
			sportType,
			qualificationValue,
			i, 
			j,
			h,
			selector,
			error = false,
			errorMessage,
			nationalShooterCounter,
			externalShooterCounter ;
	
		A.all('.sportTypeId-input').each(function(e){
			
			if(A.one(e)._node.nodeName === "SELECT"){
				sportType = A.one(e).one('option:checked').text();
				if(A.one(e).hasClass('external') && !A.one(e).hasClass('dynamicValue')){
					
					tr = A.one(e).get('parentNode').get('parentNode').get('parentNode').get('parentNode');
				}
				else{
					tr = A.one(e).get('parentNode').get('parentNode').get('parentNode');
				}
				/*alert( A.one(e).html());*/
			}
			else{
				sportType = e.val();
				tr = A.one(e).get('parentNode').get('parentNode').get('parentNode');
			}
			
			qualificationValue = A.one(tr).one('.qualificationId-input').one('option:checked').text();
			var positionValue = A.one(tr).one('.position-input').val();
			if(!positionValue){
				positionValue = 0;
			}
			var result = sportType + "%" + qualificationValue + "%" + positionValue;
			A.one(tr).attr('resultTest',result.replace(/\s/g, ""));
	
			sportTypes.push(sportType);
		});
	
		A.all('.qualificationId-input option:checked').each(function(e){
	
			qualifications.push(e.text());
		});
	
		sportTypes = sportTypes.unique();
		qualifications = qualifications.unique();
	
		for(i = 0; i < sportTypes.length; i++){
			
			for(j = 0; j < qualifications.length; j++){
				
				for(h = 1; h <= 3; h++){
				
					selector = "tr[resultTest=" + sportTypes[i].replace(/\s/g, "") + "%" + qualifications[j].replace(/\s/g, "") + "%" + h + "]";
					/*alert(selector);*/
					
					if(!A.one(selector)){
						error = true;
						errorMessage = "inserire i primi tre risultati per specialità " + sportTypes[i];
						if(qualifications[j].replace(/\s/g, "") !== '-'){
							errorMessage += " e qualifica " + qualifications[j];
						}
						break;
					}
				}
				if(error){
					alert(errorMessage);
					break;
				}
			}
			if(error){
				break;
			}
		}
		
		if(!error){
			
			nationalShooterCounter = <%=nds.size()%>;
			externalShooterCounter = A.all(".external").size();
			
			A.one('#<portlet:namespace />nationalShooterCounter').val(nationalShooterCounter);
			A.one('#<portlet:namespace />externalShooterCounter').val(externalShooterCounter);
			
			submitForm(document.<portlet:namespace />fm);
		}
	});
}
</script>

<aui:script use="aui-base">
var counter ="<%= nds.size() + esfExternalShooterResults.size()%>";
var addAct="<%= canUpdate %>";
var st ="<%=selectSportType%>";
var qm ="<%=selectQualification%>";

/*Liferay.provide(
		window,
		'<portlet:namespace />submitNationalMatchRes()',
		function(){
	

		});*/

Liferay.provide(
		window,
		'<portlet:namespace />addNationalMatchRes',
		function() {
			
			var act='';
			var table =$( "table[name*= \'fmNationalResult\']" );
			if(addAct){
				act='<div class="delete-icon" onClick="<portlet:namespace />deleteExternalShooter(event.target);" data-value="-1" data-index="' + counter + '"></div>';
			}
				var row = '<tr>' +
				'<td><div class="control-group shooter-name"><input type="text" class="italianShooter" name="<portlet:namespace />shooterName_ext_' + counter + '" required/>' +act+'</div></td>' +
				'<td><div><select class="sportTypeId-input external dynamicValue" name="<portlet:namespace />sportTypeName_ext_' + counter + '" >'+st+'</div></td>' +
				'<td><div><select class="qualificationId-input" name="<portlet:namespace />shooterQualification_ext_' + counter + '" >'+qm +'</div><select></td>' +
				'<td><input type="number" class="position-input" min="0" name="<portlet:namespace />position_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />qualification_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />shoot-off_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />clay-pigeon-total_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />final-result_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />shoot-off-final_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="text" 		  name="<portlet:namespace />user-nationality_ext_' + counter + '" value="" class="extNation_class"/></td>' +
				'</tr>';
			table.one('tbody').append(row);
			A.one('#<portlet:namespace />externalIds').val(A.one('#<portlet:namespace />externalIds').val() + counter + ",");
			A.one('#<portlet:namespace />submit-error').hide();
			counter++;
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace />deleteExternalShooter',
		function(element) {
			var el = A.one(element);
			var val = parseInt(el.getAttribute('data-value'));
			var index = parseInt(el.getAttribute('data-index'));
			var extIds = A.one('#<portlet:namespace />externalIds').val();
			extIds = extIds.replace(index + ',', '');
			A.one('#<portlet:namespace />externalIds').val(extIds);
			var tr = el.ancestor('tr');
			
			if (confirm("Sei sicuro di voler cancellare definitivamente questo elemento?") == true) {
				counter = counter - 1;
				if (val == -1) {
					tr.remove();
					return;
				}
				
				A.io.request(
					'<%= deleteExternalShooterVar %>',
					{
						dataType: 'json',
						method: 'post',
						data: {
							<portlet:namespace />esfNationalMatchResultId: val
						},
						on: {
							complete: function() {
								tr.remove();
							}
						}
					}
				);
			}
		}
	);
	
	Array.prototype.contains = function(v) {

		for(var i = 0; i < this.length; i++) {
			if(this[i] === v) return true;
		}
		return false;
	};

	Array.prototype.unique = function() {

		var arr = [];
		for(var i = 0; i < this.length; i++) {
			if(!arr.contains(this[i])) {
				arr.push(this[i]);
			}
		}
		return arr; 
	}
	
	
	$(document).ready(function(){
		if(<%=missingST%>){
			alert("Inserire le specialità per questa gara prima di inserire i risultati");
		}
		
	});
	
</aui:script>

