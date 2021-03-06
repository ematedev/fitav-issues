<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp"%>

<%
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	Calendar calendar = GregorianCalendar.getInstance();
	String year = String.valueOf(calendar.get( Calendar.YEAR ));
	String[] cardYear ={year};

	String namespace = renderResponse.getNamespace();
	

%>

<liferay-ui:error key="error-create-card" message="error-create-card"/>

<portlet:defineObjects />
	<portlet:resourceURL var='actResourceURL' id='actResource' escapeXml="false" >
</portlet:resourceURL>

<h3><b><liferay-ui:message key="assign-card-year-x"  arguments="<%= cardYear%>"/></b></h3>

<portlet:renderURL var="chooseAssociationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value='<%=templatePath + "popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="viewURL" >
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp" %>'></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="associateCard" var="associateCardURL" />

<portlet:actionURL name="updateRegionCard" var="updateRegionCardURL" />

<div class="row">
	<div class="span6">
				<aui:input name="esfUserId" value="<%=esfUserId%>" type="hidden">
				</aui:input>
	
				<aui:fieldset cssClass="btn-field-align">
	
					<aui:input name="esfOrganizationId" type="hidden">
					</aui:input>
					<aui:input inlineField="true" name="esfAssociation" disabled="true"
						type="text" label="association-to-assign-card">
					</aui:input>
					<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
						id='<%=namespace + "chooseAssociationTrigger"%>' value="search">
					</aui:button>
	
				</aui:fieldset>
				
				<aui:input label="number-of-card" name="numCard" inlineField="true">
						<aui:validator name="required " errorMessage="Field_is_required" />
						<aui:validator name="digits " errorMessage="enter-integer-positive-number" />
				</aui:input>
					
				<aui:button-row>
						<aui:button value="submit" onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"FreeCard();"%>'> </aui:button>
						<aui:button type="cancel" onClick="<%= viewURL.toString() %>" value="cancel"></aui:button>
				</aui:button-row>
				
	</div>

	<div class="span6">

		<h4>
			<liferay-ui:message key="maxCard" />
		</h4>
		<aui:form action="<%=updateRegionCardURL%>"
			name="<portlet:namespace />fm" cssClass="regions-last-card">
			<%
				ESFConfiguration conf = new ESFConfigurationImpl();
			%>

			<%
				conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_ABR");
			%>
			<div>

				<aui:input name="regions" value="ABRUZZO" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardABR" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<%
				conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_BAS");
			%>
			<div>

				<aui:input name="regions" value="BASILICATA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardBAS" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<%
				conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAL");
			%>
			<div>

				<aui:input name="regions" value="CALABRIA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardCAL" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAM");
				%>

				<aui:input name="regions" value="CAMPANIA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardCAM" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_EMR");
				%>

				<aui:input name="regions" value="EMILIA-ROMAGNA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardEMR" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_FVG");
				%>

				<aui:input name="regions" value="FRIULI-VENEZIA GIULIA"
					inlineField="true" disabled="true" label=""></aui:input>
				<aui:input name="maxCardFVG" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LAZ");
				%>

				<aui:input name="regions" value="LAZIO" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardLAZ" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LIG");
				%>

				<aui:input name="regions" value="lIGURIA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardLIG" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LOM");
				%>

				<aui:input name="regions" value="LOMBARDIA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardLOM" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MAR");
				%>

				<aui:input name="regions" value="MARCHE" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardMAR" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MOL");
				%>

				<aui:input name="regions" value="MOLISE" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardMOL" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PIE");
				%>

				<aui:input name="regions" value="PIEMONTE" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardPIE" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PUG");
				%>

				<aui:input name="regions" value="PUGLIA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardPUG" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SAR");
				%>

				<aui:input name="regions" value="SARDEGNA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardSAR" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SIC");
				%>

				<aui:input name="regions" value="SICILIA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardSIC" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TOS");
				%>

				<aui:input name="regions" value="TOSCANA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardTOS" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TAA");
				%>

				<aui:input name="regions" value="TRENTINO ALTO ADIGE"
					inlineField="true" disabled="true" label=""></aui:input>
				<aui:input name="maxCardTAA" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_UMB");
				%>

				<aui:input name="regions" value="UMBRIA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardUMB" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_AOS");
				%>

				<aui:input name="regions" value="VALLE d' AOSTA" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardAOS" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<div>
				<%
					conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_VEN");
				%>

				<aui:input name="regions" value="VENETO" inlineField="true"
					disabled="true" label=""></aui:input>
				<aui:input name="maxCardVEN" value="<%=conf.getValue()%>" label=""
					inlineField="true"></aui:input>

			</div>

			<aui:button-row>
				<aui:button type="submit" value="Update"></aui:button>
			</aui:button-row>

		</aui:form>
	</div>

</div>

<aui:script use="aui-base,node,aui-io-request,node-event-simulate">

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
		title: 'Societ�',
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

<aui:script use="node,aui-io-request,node-event-simulate,liferay-portlet-url">

Liferay.provide(window,'<portlet:namespace/>FreeCard',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var genrateFreeCard = true;
	var esfUserId = A.one('#<portlet:namespace/>esfUserId').val();
	var esfOrganizationId = A.one('#<portlet:namespace/>esfOrganizationId').val();
	var numCard = A.one('#<portlet:namespace/>numCard').val();
	
	console.log("genrateFreeCard="+genrateFreeCard);
	console.log("esfUserId="+esfUserId);
	console.log("esfOrganizationId="+esfOrganizationId);
	console.log("numCard="+numCard);
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateFreeCard', genrateFreeCard);
	resourceURL.setParameter('esfUserId', esfUserId);
	resourceURL.setParameter('esfOrganizationId', esfOrganizationId);
	resourceURL.setParameter('numCard', numCard);

	window.open(resourceURL.toString());
	
	location.reload();
});


</aui:script>