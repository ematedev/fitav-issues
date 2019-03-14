<%@include file="../init.jsp"%>

<liferay-ui:error key="error-Coni-Report" message="error-Coni-Report" />

<div>
	
	<div>
		<aui:input type="radio" name="notNewAssociation" id="notNewAssociation" inlineField="true" value="true" label="justAffiliation" checked="<%= true %>"/>
		<aui:input type="radio" name="notNewAssociation" inlineField="true" value="false" label="newAffilation" checked="<%= false %>"/>
	</div>
	
</div>

<aui:button  value='Report Coni' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"ConiReport();" %>' />

<aui:script use="node,aui-io-request,node-event-simulate">

Liferay.provide(window,'<portlet:namespace/>ConiReport',function(){
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateConiReport = true;
	var notNewAssociation= A.one("input[name=<portlet:namespace/>notNewAssociation]:checked").get("value");
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateConiReport', genrateConiReport);
	resourceURL.setParameter('notNewAssociation', notNewAssociation);
	
	window.open(resourceURL.toString());
});
</aui:script>