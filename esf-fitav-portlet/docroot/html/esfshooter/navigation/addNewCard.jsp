<%@include file="init.jsp"%>

<%
long userId = ParamUtil.getLong(request, "esfUserId");

String cardIdToString = StringPool.BLANK;
String namespace = renderResponse.getNamespace();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = "";
currDate = ManageDate.CalendarToString(calendar);	

%>

<portlet:renderURL var="chooseAssociationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esfshooter/popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>



<portlet:actionURL name="assignCard" var="assignCardURL">
	
		<portlet:param name="organizationId"
			value="<%=String.valueOf(currentOrganizationId)%>" />
		<portlet:param name="mvcPath" value="edit_esfShooter.jsp" />
		<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>"/>
	</portlet:actionURL>
	
	<aui:form action="<%=assignCardURL.toString()%>" name="<portlet:namespace />fm" >
		
		<div class="btn-field-align">
	
		<aui:input type="text" label="associationsID" id="associations"
			name="associations" required="required" readonly="true" inlineField="true" />
			
		<aui:input type="text" label="associationsName" id="associationsName"
			name="associationsName" readonly="true" inlineField="true" />
		<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
			id='<%=namespace + "chooseAssociationTrigger"%>' value="selectCompany" inlineField="true">
		</aui:button>
		</div>
		
		<div class="btn-field-align">
		
		<aui:select id="cards" name="esfCardId" showEmptyOption="true" required="true" inlineField="true"/>
		<aui:input name="startDate" type="text" id="startDate" label="date-change" inlineField="true">
				<aui:validator name="required" errorMessage="this-field-is-required" />
		</aui:input>
		
		</div>
		
		<aui:button type="submit" value="assign-card" inlineField="true" />
	</aui:form>
	
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
	$("#<portlet:namespace/>startDate").datepicker("setDate", "<%= currDate %>" );
	
});

</aui:script>