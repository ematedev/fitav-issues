<%@ include file="init.jsp" %>
<%
int totCards = ParamUtil.getInteger(request, "totCards");

String namespace = renderResponse.getNamespace();

%>

<portlet:renderURL var="chooseAssociationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value='<%=templatePath + "popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>



<portlet:renderURL var="viewURL" >
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp" %>'></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="assignCard" var="assignCardURL" />

		<aui:form action="<%= assignCardURL %>" name="<portlet:namespace />fm">
		
				<aui:input name="numTotCards" value="<%=totCards%>" readonly="true" ></aui:input>
				
				<aui:fieldset cssClass="btn-field-align">
					
					<aui:input name="esfOrganizationId" type="hidden"> </aui:input>
					
					<aui:input inlineField="true" name="esfAssociation" disabled="true" type="text" label="association-to-assign-card"> </aui:input>
					
					<aui:button class="aui-icon aui-icon-large aui-iconfont-add" id='<%= namespace + "chooseAssociationTrigger" %>' value="add">
					</aui:button>
				
				</aui:fieldset>
				
		
				<aui:input name="numberOfCard" >
					<aui:validator  name="required " errorMessage="Field_is_required" />
					<aui:validator name="number"></aui:validator>
				</aui:input>
				
				<aui:button-row>
					<aui:button type="submit"></aui:button>
					<aui:button type="cancel" onClick="<%= viewURL.toString() %>" value="cancel"></aui:button>
				</aui:button-row>
		</aui:form>


<aui:script use="aui-base,node">

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
		title: 'Società',
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

		A.one('#<portlet:namespace/>esfOrganizationId').set('value', dataId);
		A.one('#<portlet:namespace/>esfAssociation').set('value', dataName);
		
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
		dialog.destroy();
	},
	['liferay-util-window']
);

</aui:script>