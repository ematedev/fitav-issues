<%@ include file="init.jsp" %>

<%
String namespace = renderResponse.getNamespace();

long esfFieldId = ParamUtil.getLong(request, "esfFieldId");

%>

<portlet:renderURL var="chooseAssociationURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath" value='<%=templatePath + "popup/view.jsp" %>'></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="giveWayESFField" var="giveWayESFFieldURL" />

<aui:form action="<%= giveWayESFFieldURL %>" name="<portlet:namespace />fm">
	<div class="btn-field-align">		
		<aui:fieldset>
			<aui:input type="hidden" name="esfFieldId" value='<%= esfFieldId %>' />
			
			<aui:input name="esfOrganizationId" type="hidden"> </aui:input>
			<aui:input inlineField="true" name="esfAssociation" disabled="true" type="text" label="give-away-ass"> </aui:input>
			<aui:button class="aui-icon aui-icon-large aui-iconfont-add" id='<%= namespace + "chooseAssociationTrigger" %>' value="add">
			</aui:button>
		</aui:fieldset>
	</div>		
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>" value="cancel"></aui:button>
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
		title: 'Sedi Gara',
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
