<%@include file="init.jsp"%>

<%
	String namespace = renderResponse.getNamespace();
	ESFMatch esfMatch = null;
	ESFOrganization esfMatchOrganization = null;
	
	Long esfOrganizationId = null;

	if(Validator.isNotNull(currentESFOrganization) && currentESFOrganization.getType()==3){
		esfOrganizationId=currentOrganizationId;
	}

	boolean disabled=false;
	if (esfMatchId > 0) {
		
		esfMatch = ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);
		if(esfMatch.getEsfAssociationId()>0){
			esfMatchOrganization = ESFOrganizationLocalServiceUtil
				.getESFOrganization(esfMatch.getEsfAssociationId());
		}
	}
	
	Long esfMatchOrganizationId = null;
	String esfMatchOrganizationName = "";

	if(Validator.isNotNull(esfMatchOrganization)){
		esfMatchOrganizationId = esfMatchOrganization.getEsfOrganizationId();
		esfMatchOrganizationName = esfMatchOrganization.getName();
	}
	
	if( Validator.isNotNull( esfOrganizationId) && Validator.isNull(esfMatchOrganization)){
		esfMatchOrganizationId = esfOrganizationId;
		esfMatchOrganizationName = ESFOrganizationLocalServiceUtil
				.fetchESFOrganization(esfOrganizationId)
					.getName();
	}
	
	if(esfMatch!=null && !esfMatch.isIsDraft()){
		disabled=true;
	}
	
	Calendar cal = Calendar.getInstance();
	List <ESFMatch> esfMatches = ESFMatchLocalServiceUtil.
	findESFMatchesByYearIsNational(
				cal.get(cal.YEAR),isNational);
	String matchCodeValue = "";
	//matchCodeValue = String.valueOf(cal.get(cal.YEAR)) + String.valueOf(esfMatches.size() + 1);
	matchCodeValue ="";
	String esfDescription = "";
	List<ESFMatchType> esfMatchTypes = null;
	esfMatchTypes  = ESFMatchTypeLocalServiceUtil.findAllByNational(false);
	
%>

<portlet:resourceURL var="resourceURL" escapeXml="false" />

<portlet:renderURL  var="add_DescriptionURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"edit_esfDescription.jsp" %>' />
		<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId) %>' />
</portlet:renderURL>

<portlet:renderURL  var="add_MatchTypeURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"edit_esfMatchType.jsp" %>' />
		<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId) %>' />
</portlet:renderURL>

<portlet:renderURL var="chooseAssociationURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esfnormalmatch/popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="updateESFMatch" var="editESFMatchURL" />

<aui:form action="<%=editESFMatchURL%>" name="fm">

	<aui:model-context bean="<%=esfMatch%>" model="<%=ESFMatch.class%>" />

	<aui:fieldset>

		<aui:input type="hidden" name="esfMatchId" value='<%=esfMatchId%>' />

		<%
				Calendar calendar = CalendarFactoryUtil.getCalendar();
				String	startDate = ManageDate.CalendarToString(calendar);
				String endDate = ManageDate.CalendarToString(calendar);

				SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
				if(esfMatchId>0){
					startDate = format1.format(esfMatch.getStartDate());
					endDate = format1.format(esfMatch.getEndDate());
				}
				else{
					startDate= format1.format(new Date());
					endDate= format1.format(new Date());
				}
		%> 
		
	 	<aui:script>
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
	
		
		$(function() {
			$('input[name="<portlet:namespace/>startHour"]').ptTimeSelect({
					containerClass: undefined,
					containerWidth: undefined,
					hoursLabel:     'Ore',
					minutesLabel:   'Minuti',
					setButtonLabel: 'Set',
					popupImage:     undefined,
					onFocusDisplay: true,
					zIndex:         10,
					onBeforeShow:   undefined,
					onClose:        undefined
			});
		});	
		</aui:script> 
		

	   	<aui:input name="code" value = "<%=matchCodeValue%>" disabled="true">			
		</aui:input> 

		<aui:input name="startDate" type="text">			
		<aui:validator name="required" errorMessage="this-field-is-required" />			                        
                        <aui:validator name="custom"
                            errorMessage="La Data non ha un formato corretto.Inserire gg/mm/aaaa">
                            		function (val, fieldNode, ruleValue)
                       {
                         var result = true;
                         var pattern=/^(0?[1-9]|1\d|2\d|3[01])\/(0?[1-9]|1[0-2])\/(19|20)\d{2}$/;        
                         var check = pattern.test(val);
                         var checkValue = $("#<portlet:namespace />startDate").val();                         
                                                 
                         if(check == false && checkValue)
                          {
                           result=false;
                          }
                         val=$.trim(val);
                         $("#<portlet:namespace />startDate").val(val);
                         return result;
                        }
                      						
		</aui:validator>
		</aui:input>

		<aui:input name="endDate" type="text">			
		<aui:validator name="required" errorMessage="this-field-is-required" />
		      
			<aui:validator name="custom" errorMessage="La Data Fine deve essere maggiore o uguale alla Data Inizio.">                                                              
                        	function(val, fieldNode, ruleValue) 
                        {                         
                        	var startDateObj = document.getElementById("<portlet:namespace />startDate");
                            var startDate;
                            var result=false;
                           
                            if(val == ""){
                                return true;
                            }
                            if(startDateObj) {
                                startDate = new Date(Date.parse(startDateObj.value,"dd MM yyyy"));
                            }else{
                                result = false;
                            }
                            var endDate = new Date(Date.parse(val,"dd MM yyyy"));                                                        
                            
                            if(startDate && endDate){
                            	if (endDate.getTime() >= startDate.getTime()) {
                                	result = true;
                                }
                            }else{
                                result = false;
                            } 
                            
                            return result;
                        }
                        </aui:validator>
                        
                        <aui:validator name="custom"
                            errorMessage="La Data non ha un formato corretto. Inserire gg/mm/aaaa">
                            		function (val, fieldNode, ruleValue)
                       {
                         var result = true;
                                 
                         var pattern=/^(0?[1-9]|1\d|2\d|3[01])\/(0?[1-9]|1[0-2])\/(19|20)\d{2}$/;               
                         var check = pattern.test(val);
                         var checkValue = $("#<portlet:namespace />endDate").val();
                                                                    
                         if(check == false && checkValue)
                          {
                           result=false;
                          }
                         val=$.trim(val);
                         $("#<portlet:namespace />endDate").val(val);
                         return result;
                        }                                          						
						</aui:validator>
		</aui:input>

		<aui:input name="startHour" type="text"> 
		<aui:validator name="required" errorMessage="this-field-is-required" />		
			<aui:validator name="custom"
                                  errorMessage="L'ora non ha un formato corretto. Inserire hh/mm">
                       function (val, fieldNode, ruleValue)
                       {
                         var result = true;
                         var pattern=/^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;
                         var check = pattern.test(val);
                         var checkValue = $("#<portlet:namespace />startHour").val();
                         if(check == false && checkValue)
                          {
                           result=false;
                          }
                         val=$.trim(val);
                         $("#<portlet:namespace />startHour").val(val);
                         return result;
                        }
                       </aui:validator>		
		</aui:input>

		
	<div  class="btn-field-align">	
		<aui:select name="esfMatchTypeId" lable="esfMatchTypeId" id="esfMatchTypeId" inlineField="true">
		<%-- 	<aui:option label="-" value="0" />   --%>
			<%
				boolean select = false;
			
				for(ESFMatchType esfMatchType : esfMatchTypes){
					if(Validator.isNotNull(esfMatch) && Validator.isNotNull(esfMatch.getEsfMatchTypeId())
							&& esfMatch.getEsfMatchTypeId() == esfMatchType.getEsfMatchTypeId()){
						select = true;
					}
			%>
						<aui:option label="<%=esfMatchType.getName()%>" value="<%=esfMatchType.getEsfMatchTypeId()%>"
							selected="<%=select %>" />
			<%
				}
			%>
		</aui:select>
		<%if(esfMatchId > 0){ %>
			<c:if test="<%=ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_MATCHTYPE_ADD) %>">
		
				<aui:button onClick="<%= add_MatchTypeURL.toString() %>" value="add-addr" />
			
			</c:if>
		<%}else{ %>
			<c:if test="<%=ESFNormalMatchModelPermission.contains(permissionChecker,portletGroupId, ActionKeys.ESFNORMALMATCH_MATCHTYPE_ADD)%>">	

				<aui:button onClick="<%= add_MatchTypeURL.toString() %>" value="add-addr" />
		
			</c:if>
		<% }%>
</div>
<div  class="btn-field-align">
		<aui:select name="description" inlineField="true">
			<aui:option label="-" value="0" />
			<%
				List<ESFDescription> esfDescriptions = ESFDescriptionLocalServiceUtil.findAllByNational(isNational);
					for (ESFDescription esfDescriptio : esfDescriptions) {
			%>
			<aui:option label="<%=esfDescriptio.getName()%>"
				value="<%=esfDescriptio.getEsfDescriptionId()%>"></aui:option>
			<%
				}
			%>
		</aui:select>

		<%
		if(esfMatchId > 0){ %>
			<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_DESCRIPTION_ADD) %>">	
				<aui:button onClick="<%= add_DescriptionURL.toString() %>" value="add-addr" />
			</c:if>
		<%}else{ %>
			<c:if test="<%=ESFNormalMatchModelPermission.contains(permissionChecker,portletGroupId, ActionKeys.ESFNORMALMATCH_DESCRIPTION_ADD) %>">	

				<aui:button onClick="<%= add_DescriptionURL.toString() %>" value="add-addr" />
		
			</c:if>
		<%}%>

</div>		
		<aui:select name="esfSportTypeid">
		<%--  	<aui:option label="-" value="0" /> --%>
			<%
			List<ESFSportType> esfSportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
			for (ESFSportType esfSportType : esfSportTypes) {
				boolean selected=false;
				if(esfMatch!=null && esfSportType.getEsfSportTypeId()==esfMatch.getEsfSportTypeId()){
					selected=true;
				}
			%>

			<aui:option value="<%=esfSportType.getEsfSportTypeId()%>" 
				selected="<%=selected%>"><%=esfSportType.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>

		<aui:input name="notes"></aui:input>

		<aui:input name="isDraft" type="checkbox"
			checked="<%=esfMatch == null ? true : esfMatch.isIsDraft()%>" />

		<aui:input name="numDisk">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="min">0</aui:validator>
		</aui:input>
		
		<aui:input leable="num-disk-team" name="numDiskTeam">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="min">0</aui:validator>
		</aui:input>



<div class="btn-field-align">
		<aui:input name="esfAssociationId" type="hidden"
			value="<%=(esfMatchOrganization == null && Validator.isNull( esfOrganizationId)) ? StringPool.BLANK : esfMatchOrganizationId%>">
		</aui:input>
		<aui:input inlineField="true" readonly="true" name="esfAssociation" disabled="true"
			type="text"
			value="<%=(esfMatchOrganization == null && Validator.isNull( esfOrganizationId))? StringPool.BLANK : esfMatchOrganizationName%>">

		</aui:input>
		 <%
		 if(Validator.isNull(esfOrganizationId)){
			 if(esfMatchId > 0){
		 %> 
				<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPDATE) %>">	
					<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
						id='<%=namespace + "chooseAssociationTrigger"%>' value="add">
					</aui:button>
					<aui:button class="aui-icon aui-icon-large aui-iconfont-delete"
						id='<%=namespace + "deleteAssociationTrigger"%>' value="delete">
					</aui:button>
				</c:if>
		<% 
			 }else{%>
				 <c:if test="<%= ESFNormalMatchModelPermission.contains(permissionChecker,portletGroupId, ActionKeys.ESFNORMALMATCH_UPDATE) %>">	
					<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
						id='<%=namespace + "chooseAssociationTrigger"%>' value="add">
					</aui:button>
					<aui:button class="aui-icon aui-icon-large aui-iconfont-delete"
						id='<%=namespace + "deleteAssociationTrigger"%>' value="delete">
					</aui:button>
				</c:if>
				 
		<%	 }
		}
		 %>
</div>	
		<aui:input id="numFields" name="numFields">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="min">1</aui:validator>
		</aui:input>

		<div class="separator" ></div>

		<liferay-ui:message key="matches-options" />
		<br />

		<aui:input name="isChangeCategoryMatch" inlineField="true" type="checkbox"
			checked="<%=esfMatch != null
				? esfMatch.getIsChangeCategoryMatch() : false%>" inlineLabel="true"/>
		
		
		<aui:input name="isIndividualMatch" inlineField="true" type="checkbox"
			checked="<%=esfMatch != null
				? esfMatch.getIsIndividualMatch() : false%>" inlineLabel="true"/>

		<aui:input name="isTeamMatch" inlineField="true" type="checkbox"
			checked="<%=esfMatch != null
				? esfMatch.getIsTeamMatch() : false%>" inlineLabel="true"/>

		<aui:input name="isJuniorMatch" inlineField="true" type="checkbox"
			checked="<%=esfMatch != null
				? esfMatch.getIsJuniorMatch() : false%>" inlineLabel="true"/>

		<aui:input name="hasPenality"  type="checkbox"
			checked="<%=esfMatch != null
				? esfMatch.getHasPenality() : false%>" inlineLabel="true"/>
				
		
<%
List<ESFShooterCategory> esfShooterCategories = ESFShooterCategoryLocalServiceUtil.getESFShooterCategories();
List<ESFShooterCategory> esfShooterCategoriesESFMatch = ESFShooterCategoryLocalServiceUtil.findByMatchId(esfMatchId);

List<KeyValuePair> leftListCategories = new ArrayList<KeyValuePair>();
List<KeyValuePair> rightListCategories  = new ArrayList<KeyValuePair>();

if(Validator.isNotNull(esfShooterCategoriesESFMatch)){
	for(ESFShooterCategory scm : esfShooterCategoriesESFMatch){
		rightListCategories.add(new KeyValuePair(String.valueOf(scm.getEsfShooterCategoryId()) , scm.getName()));
	}
}

for(ESFShooterCategory sc : esfShooterCategories){
	if(!esfShooterCategoriesESFMatch.contains(sc)){
		leftListCategories.add(new KeyValuePair(String.valueOf(sc.getEsfShooterCategoryId()) , sc.getName()));
	}
}

%>
	
<liferay-ui:message key="shooter-categories">shooter-categories</liferay-ui:message>		
	
<aui:input name="valuesSC" type="hidden" />
    <liferay-ui:input-move-boxes
        leftBoxName="availableValuesSC"
        leftList="<%= leftListCategories%>"
        leftReorder="true"
        leftTitle="available"
        rightBoxName="selectedValuesSC"
        rightList="<%=rightListCategories%>"
        rightTitle="selected"
    />
		
<%
List<ESFShooterQualification> esfShooterQualifications =
ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications();
	
List<ESFShooterQualification> esfShooterQualificationsESFMatch =
	ESFShooterQualificationLocalServiceUtil.findByMatchId(esfMatchId);


List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();
List<KeyValuePair> rightList  = new ArrayList<KeyValuePair>();

for(ESFShooterQualification qm : esfShooterQualificationsESFMatch){
	rightList.add(new KeyValuePair(String.valueOf(qm.getEsfShooterQualificationId()) , qm.getName()));
}

for(ESFShooterQualification q : esfShooterQualifications){

	if(Validator.isNotNull(rightList) && !esfShooterQualificationsESFMatch.contains(q)){
		leftList.add(new KeyValuePair(String.valueOf(q.getEsfShooterQualificationId()) , q.getName()));
	}
}

%>

<liferay-ui:message key="shooter-qualification">shooter-qualification</liferay-ui:message>	
	<aui:input name="values" type="hidden" />
    <liferay-ui:input-move-boxes
        leftBoxName="availableValues"
        leftList="<%= leftList%>"
        leftReorder="true"
        leftTitle="available"
        rightBoxName="selectedValues"
        rightList="<%=rightList%>"
        rightTitle="selected"
    />

	</aui:fieldset>


<%if(esfMatchId > 0){ %>
	<aui:button-row>
		<c:if test="<%= ESFNormalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNORMALMATCH_UPDATE) %>">	
			<aui:button type="button" value="save"
				id='<%=renderResponse.getNamespace()+"checkDraft"%>'>
			</aui:button>
		</c:if>
		
		<aui:button type="cancel" onClick="<%=viewURL%>"></aui:button>
	</aui:button-row>
<%}else{ %>
	<aui:button-row>
				<c:if test="<%= ESFNormalMatchModelPermission.contains(permissionChecker,portletGroupId, ActionKeys.ESFNORMALMATCH_UPDATE) %>">	
			<aui:button type="button" value="save"
				id='<%=renderResponse.getNamespace()+"checkDraft"%>'>
			</aui:button>
		</c:if>
		
		<aui:button type="cancel" onClick="<%=viewURL%>"></aui:button>
	</aui:button-row>

<%} %>
</aui:form>

<aui:script use="aui-base,node,liferay-util-list-fields">

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
		title: 'Sedi Gara',
		id:'<portlet:namespace/>chooseAssociationPopUp',
		uri:'<%=chooseAssociationURL.toString()%>'
		});

	});
	A.one('#<portlet:namespace/>deleteAssociationTrigger').on('click', function(event){
		
		A.one('#<portlet:namespace />esfAssociation').set('value','');
		A.one('#<portlet:namespace />esfAssociationId').set('value','');
	

		});
});

Liferay.provide(
	window,
	'<portlet:namespace/>retrieveAssociation',
	function(dataId, dataName) {
		var A = AUI();

		A.one('#<portlet:namespace/>esfAssociationId').set('value', dataId);
		A.one('#<portlet:namespace/>esfAssociation').set('value', dataName);
		
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
		dialog.destroy();
	},
	['liferay-util-window']
);

A.one("#<portlet:namespace/>checkDraft").on('click',function() {
	
	var selectedValues = Liferay.Util.listSelect('#<portlet:namespace/>selectedValues');
	var selectedValuesSC = Liferay.Util.listSelect('#<portlet:namespace/>selectedValuesSC');
	
	A.one('#<portlet:namespace/>values').val(selectedValues);
	A.one('#<portlet:namespace/>valuesSC').val(selectedValuesSC);
	
	if (A.one('#<portlet:namespace/>isDraft').get('value') == 'true') {
		A.one('#<portlet:namespace/>fm').submit();
	}
	else {
			A.one('#<portlet:namespace/>fm').submit();
	}
});

$('#<portlet:namespace/>startDate').on('change', function(){
	$('#<portlet:namespace/>endDate').val($(this).val());
});

$('#<portlet:namespace/>startDate').on('change', function(){
	$('#<portlet:namespace/>startDate').show();
});

$('#<portlet:namespace/>endDate').on('change', function(){
	$('#<portlet:namespace/>endDate').show();
});  
</aui:script>