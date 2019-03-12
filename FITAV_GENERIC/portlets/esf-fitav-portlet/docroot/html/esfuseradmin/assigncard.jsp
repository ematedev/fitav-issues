<%@include file="init.jsp"%>

<%

long esfUserId=ParamUtil.getLong(request, "esfUserId");
String cardIdToString=StringPool.BLANK;

ESFCard esfCard = null;

String namespace = renderResponse.getNamespace();
%>


<portlet:renderURL var="chooseAssociationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value='<%="/html/esfuseradmin/popup/view.jsp"%>'></portlet:param>
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
</aui:script>



<aui:model-context bean="<%=esfCard%>" model="<%=ESFCard.class%>" />

<portlet:actionURL name="updateESFUserESFCard"
	var="updateSFUserESFCardVar" />


<aui:form action="<%=updateSFUserESFCardVar%>"
	name="<portlet:namespace />fm">	

	<aui:fieldset>
		<%
			ESFOrganization orgs=ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
			if(Validator.isNotNull(orgs) && orgs.getType()!=ESFKeys.ESFOrganizationTypeId.ASSOCIATION){
			%>
			
				<div class="btn-field-align">
					<aui:input type="text" label="associationsID" id="associations" name="esfOrganizationId" required ="required" readonly="true" inlineField="true"/>	
					<aui:input type="text" label="associationsName" id="associationsName" name="associationsName"  readonly="true" inlineField="true"/>	
					<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
							id='<%=namespace + "chooseAssociationTrigger"%>' value="add"  inlineField="true">
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
		<aui:select id="cards" name="esfCardId" showEmptyOption="true" required="true" />
			
		<aui:input type="hidden" name="esfUserId" value='<%= esfUserId%>' />
	</aui:fieldset>

	<aui:button-row>
		
		<c:if test="<%= ESFUserAdminPermission.contains(permissionChecker, esfUserId,  ActionKeys.ESFUSERADMIN_ASSIGN_CARD) %>">	
		
			<aui:button type="submit"></aui:button>
		
		</c:if>
		
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	
	</aui:button-row>

</aui:form>

