
<%@include file="init.jsp"%>

<h3> <liferay-ui:message key="change-card"/></h3>	

<%
	List<ESFCard> esfCards = Collections.emptyList();
	ESFCard esfCard = null;
	ESFUser esfUser = null;
	String userName = "";
	String namespace = renderResponse.getNamespace();
	String renawal="RINNOVO";
	String associations;
	Long esfUserId = Long.parseLong(request.getParameter("esfUserId"));
	String cardIdToString=StringPool.BLANK;
	if (esfUserId > 0) {
		esfCards = ESFCardLocalServiceUtil.findAllESFCardsByU_S(esfUserId, ESFKeys.ESFStateType.ENABLE);
		if (esfCards.size() > 0){
			esfCard = esfCards.get(0);
			cardIdToString=Long.toString(esfCard.getEsfCardId());
		}
	}
	SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	calendar.setTime(new Date());
	String	startDate = calendar.toString() ;
	startDate= format1.format(new Date());


if (esfUserId > 0) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
}

if(Validator.isNotNull(esfUser) ){
	userName = esfUser.getFirstName()+" "+esfUser.getLastName();
	String[] shooterName = {userName};
%>	
<h4><b><liferay-ui:message key="update-shooter-x" arguments="<%= shooterName%>"/></b>
				<div class="separator"></div>
<%
}else{

%>
<h4><b><liferay-ui:message key="add-new-shooter" /></b>
				<div class="separator"></div>
<%
}
%>
<portlet:renderURL var="chooseAssociationURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esfshooter/popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>

<portlet:resourceURL var="associationsURL" id="associations" escapeXml="false" />

<aui:script use="node,aui-io-request">
var cardsOptions = '<option value="">-</option>';
var cardId = '<%= cardIdToString %>';

A.one('#<portlet:namespace/>cards').html(cardsOptions);
A.one("#<portlet:namespace />associations").on('focus',changeSelect);


function changeSelect(event) {
	var element = event.currentTarget;
	var type = element.get('id').replace('<portlet:namespace/>', '');
	var idAssociation = A.one('#<portlet:namespace/>associations').get('value');
	var resourceURL = '<%= associationsURL %>';
	callAction(resourceURL, idAssociation, type);
	
}

function callAction(resourceURL, idAssociation, type) {
	A.io
			.request(
					resourceURL,
					{
						method : 'POST',
						contentType : "application/json; charset=utf-8",
						data : {
							param : '',
							idAssociation : idAssociation,
							esfUserId : '<%= esfUserId%>'
						},
						on : {
							success : function() {
								var results = JSON.parse(this
										.get('responseData'));
								var resultsOption = '<option value="">-</option>';
								if (type == 'associations') {
									if (results.length > 0)
										resultsOption = '';
									for (index in results) {
										if (results[index][0] == cardId)
											resultsOption += '<option selected="selected" value="'+ results[index][0] +'">'
													+ results[index][1]
													+ '</option>';
										else
											resultsOption += '<option value="'+ results[index][0] +'">'
													+ results[index][1]
													+ '</option>';
									}
									A.one('#<portlet:namespace/>cards')
											.html(resultsOption);
								}
							}
						}
					});
}
if(A.one('#<portlet:namespace/>esfOrganizationId')){
	idAssociation = A.one('#<portlet:namespace/>esfOrganizationId').get('value');
	callAction('<%= associationsURL %>',idAssociation,'associations');
}
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
		title: 'Scegli organizzazione',
		id:'<portlet:namespace/>chooseAssociationPopUp',
		uri:'<%=chooseAssociationURL.toString()%>'
		});

	});
});
Liferay.provide(
		window,
		'<portlet:namespace/>retrieveAssociation',
		function(dataId, dataName) {
			var A = AUI();

			//A.one('#<portlet:namespace/>esfAssociationId').set('value', dataId);
			A.one('#<portlet:namespace/>associations').set('value', dataId);
			A.one('#<portlet:namespace/>associationsName').set('value',dataName);
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
			dialog.destroy();
			A.one('#<portlet:namespace/>associations').focus();
		},
		['liferay-util-window']
	);

$(function() {
	
	$("#<portlet:namespace/>startDate").datepicker();
	$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat", "dd/mm/yy");
	$("#<portlet:namespace/>startDate").datepicker("setDate", "<%= startDate %>");
	
	
});
</aui:script>
	

<!-- Action della portlet -->
<portlet:actionURL name="changeCard" var="changeCard">
		<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
		<%if(Validator.isNotNull(esfCard)){ %>
		<portlet:param name="cardUserId" value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
		<% }%>
		<portlet:param name="organizationId"
				value="<%= String.valueOf(currentOrganizationId)%>" />
		<portlet:param name="mvcPath"
					value="edit_esfShooter.jsp"/>
		<portlet:param name="op" value="updAddr" />
</portlet:actionURL>
<portlet:renderURL var="backURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<%if(Validator.isNotNull(esfCard)){ %>
	<portlet:param name="cardUserId" value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
	<% }%>
	<portlet:param name="organizationId"
			value="<%= String.valueOf(currentOrganizationId)%>" />
	<portlet:param name="mvcPath"
			value='<%=templatePath+"edit_esfShooter.jsp" %>'/>
	<portlet:param name="op" value="updAddr" />
</portlet:renderURL>

<aui:model-context bean="<%=esfCard%>" model="<%=ESFCard.class%>" />
<aui:form action="<%= changeCard %>">
<aui:fieldset>
	<%
		List<ESFOrganization> orgs=ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId);
		
		if(orgs.size()>1){
			long  associationId =  esfUserId > 0? esfCard.getEsfOrganizationId():0;
			if(Validator.isNotNull(esfCard)){
		%>
			<div id="actualCard" >
				<aui:input label="actualCard" name="actualCard" type="text" readonly="true" value="<%= esfCard.getCode()%>" />
			</div>
			<%} %>
			<div class="btn-field-align">
				<aui:input type="text" label="associationsID" id="associations" name="associations" required ="required" readonly="true" inlineField="true"/>	
				<aui:input type="text" label="associationsName" id="associationsName" name="associationsName"  readonly="true" inlineField="true"/>	
				<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
						id='<%=namespace + "chooseAssociationTrigger"%>' value="add" inlineField="true">
				</aui:button>
			</div>	
		<%
			}
			else {
			%>
				<aui:input type="hidden" name="esfOrganizationId"  value='<%=currentOrganizationId%>' />
			<%
			}
		%>

	<div>
			<aui:select id="cards" name="esfCardId" showEmptyOption="true" required="true" inlineField="true"/>
			
			<aui:input name="startDate" type="text" id="startDate" label="date-change" inlineField="true">
				<aui:validator name="required" errorMessage="this-field-is-required" />
			</aui:input>
	</div>	
</aui:fieldset>
<aui:fieldset>
	<div id="operation_type">
		<aui:input name="typeOperation" type="hidden" id="typeOperation" label="typeOperation" inlineField="true" value="<%=renawal %>"/>
	</div>
</aui:fieldset>
<aui:button type="submit" value="change-card"/>
<aui:button type="button" value="back" onClick="<%= backURL.toString()%>" />
<%if(Validator.isNotNull(esfCard)){ %>
	<portlet:param name="cardUserId" value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
<%} %>
	<portlet:param name="organizationId"
			value="<%= String.valueOf(currentOrganizationId)%>" />
	<portlet:param name="mvcPath"
				value="edit_esfShooter.jsp"/>
	<portlet:param name="op" value="updAddr" />
</aui:form>