<%@ include file="init.jsp"%>

<%

	ESFDocument esfDocument = null;

	String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
	portletDisplay.setURLBack(backToEditUrl);
	
	long esfDocumentId = ParamUtil.getLong(request, "esfDocumentId");

	if (esfDocumentId > 0) {

		esfDocument = ESFDocumentLocalServiceUtil.getESFDocument(esfDocumentId);
	}
	
	long esfUserId = ParamUtil.getLong(request, "esfUserId");

	String releaseDate = "";
	String expirationDate = "";
	String type = "";
	String code = "";
	String releasedby = "";
	String path = "";
	String dir = PortletProps.get("auto.deploy.tomcat.dest.dir");
	if (Validator.isNotNull(esfDocument)) {
		type = String.valueOf(esfDocument.getType());
		code = String.valueOf(esfDocument.getCode());
		releasedby = String.valueOf(esfDocument.getReleasedBy());
		releaseDate = ManageDate.DateToString(esfDocument.getReleaseDate());
		expirationDate = ManageDate.DateToString(esfDocument.getExpirationDate());
		path = String.valueOf(esfDocument.getPath());
	}else{
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		releaseDate=ManageDate.CalendarToString(calendar);	
		expirationDate=ManageDate.CalendarToString(calendar);	
	}
ESFUser esfUser = null;
String userName = "";

if (esfUserId > 0) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
}

if( Validator.isNotNull(esfUser) ){
	
	userName = esfUser.getFirstName()+" "+esfUser.getLastName();
	String[] shooterName = {userName};
%>	
<h4><b><liferay-ui:message key="update-shooter-x" arguments="<%= shooterName%>"/></b>
				<div class="separator"></div>
<%
}
%>

<aui:script use="aui-base,node,aui-io-request">
	$(function() {
		$("#<portlet:namespace/>ReleaseDate").datepicker();
		$("#<portlet:namespace/>ReleaseDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>ReleaseDate").datepicker("setDate",
				'<%= releaseDate %>');
	});

	$(function() {
		$("#<portlet:namespace/>ExpirationDate").datepicker();
		$("#<portlet:namespace/>ExpirationDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>ExpirationDate").datepicker("setDate",
				'<%= expirationDate %>');
	});
</aui:script>

<portlet:actionURL name="editESFdocument" var="editESFDocumentURL">
	<portlet:param name="esfDocumentId"
		value="<%=String.valueOf(esfDocumentId)%>" />
	<portlet:param name="esfUserId"
		value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFDocumentURL%>" enctype="multipart/form-data" name="fm" onSubmit="event.preventDefault();checkInputsOnSubmit(event);">
	<aui:model-context bean="<%=esfDocument%>"
		model="<%=ESFDocument.class%>" />

	<aui:fieldset>
		<aui:input type="hidden" name="esfDocumentId"
			value='<%=esfDocumentId%>' />

		<%  if(esfDocumentId==0){ %>
				<aui:select id="type" name="type" showEmptyOption="false"
					required="true" label="type" onchange="validateInputs();">
				<%
					
					List<ListType> documentAll =
						ListTypeServiceUtil.getListTypes(ESFDocument.class.getName() +ESFListType.DOCUMENT);

					List<ESFDocument> documentAssigned = 
						ESFDocumentLocalServiceUtil.findByesfUserId(esfUserId);

					List<String> typeAssigned = new ArrayList <String>();
					
					for(ESFDocument d : documentAssigned){
						typeAssigned.add(d.getType());
					}

					List<ListType> document = new ArrayList <ListType>();

					for(ListType u : documentAll){
						if(!typeAssigned.contains(u.getName())){
							document.add(u);
							}
					}
					
					for (ListType documents : document) {
				%>
						<aui:option label="<%=documents.getName()%>" value="<%=documents.getName()%>" />
				<%
					}
				%>
				</aui:select>
			<%
			}else{
				List<ListType> documents =
					ListTypeServiceUtil.getListTypes(ESFDocument.class.getName() +ESFListType.DOCUMENT);
				for (ListType document : documents) {
					if(document.getName().equalsIgnoreCase(type)){
			%>	
						<aui:input type="text" name="typet" label="type" value='<%= document.getName()%>' disabled="true" />
						<aui:input type="hidden" name="type"	value='<%=document.getName()%>' />
			<%
					}
				}
			}
			%>
	

		<aui:input name="code" type="text" label="document-number" value='<%=code%>' >
			<%--aui:validator name="required" /--%>
		</aui:input>

		<aui:input name="releasedby" type="text" label="ReleasedBy"
			value='<%=releasedby%>'>
			<!-- aui:validator name="required" /-->
		</aui:input>

		<aui:input name="releasedate" type="text" id="ReleaseDate" 
			label="ReleaseDate" value='<%=releaseDate%>'>
			<!-- aui:validator name="required" /-->
		</aui:input>

		<aui:input name="expirationDate" type="text" id="ExpirationDate" 
			label="ExpirationDate" value='<%=expirationDate%>'>
			<!-- aui:validator name="required" /-->
		</aui:input>
		<%if(Validator.isNotNull(path)) {%>
			<a href="<%= path  %>" target="_blank">Download</a>
		<% } %>
		<aui:input name="path" type="file" label="File" >
		</aui:input>

	</aui:fieldset>

	<portlet:renderURL var="backURL">
			<portlet:param name="mvcPath" value='<%=templatePath + "edit_esfShooter.jsp"%>' />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button type="submit" ></aui:button>
		<aui:button type="cancel" onClick="<%= backURL %>"></aui:button>
	</aui:button-row>

</aui:form>

<aui:script>

AUI().ready(function(A){
	validateInputs();
});

/*Singleton object*/
var formValidator = "";

function checkInputsOnSubmit(e){
	AUI().use(function(A){
		if(A.one("#<portlet:namespace />type option:selected")){
			e.preventDefault();
			var selectedValue = A.one("#<portlet:namespace />type option:selected").val ();
			if(selectedValue === "Passaporto" || selectedValue === "Carta d'Identità" || selectedValue === "Porto d'Armi"){
				validateInputs(e,"submit");
			}
			else{
				if(formValidator){
					formValidator.resetAllFields();
				}
				A.one('#<portlet:namespace />fm').submit();
			}
		}
		else{
			
			
			A.one('#<portlet:namespace />fm').submit();
		}
	});
}

function validateInputs(event,submit){
	AUI().use("aui-form-validator",function(A){	
		console.log("form validator : " + formValidator);
		var selectedValue = A.one("#<portlet:namespace />type option:selected").val ();
		if( A.one("#<portlet:namespace />type option:selected")){
			var selectedValue = A.one("#<portlet:namespace />type option:selected").val ();
			if(selectedValue==="Passaporto" || selectedValue==="Carta d'Identità" || selectedValue==="Porto d'Armi"){
				console.log("inside if");
				if(!formValidator){
					console.log("other ...  if");
					 formValidator = new A.FormValidator(
								{
					                boundingBox: '#<portlet:namespace />fm',
					                rules: {
					                	<portlet:namespace />code: {
					                        required: true
					                    },
					                    <portlet:namespace />releasedby: {
					                        required: true
					                    },
					                    <portlet:namespace />releasedate: { 
					                        required: true
					                    },
					                    <portlet:namespace />expirationDate: {
					                        required: true
					                    }
					                },
					                showAllMessages: true
					            }
					);
				}
				else{
					if(submit && !formValidator.hasErrors()){
						A.one('#<portlet:namespace />fm').submit();
					}
					else{
						formValidator.eachRule(function(elem){
							console.log("### elem : " + (elem.required = true));
						});
					}
				}
			}
			else{
				if(formValidator){
					console.log("event halt");
					console.log("formValidator destroyed before: " );
					formValidator.eachRule(function(elem){
						console.log("### elem : " + (elem.required = false));
					});
					formValidator.set("destroyed",true);
					console.log("formValidator destroyed after: " + formValidator.destroyed);
					
					/*
					console.log("reset : " + formValidator.resetAllFields());
					formValidator.detachAll();
					console.log("destroy  : "  + formValidator.destroy());
					console.log("reset : " + formValidator.reset());
					formValidator.removeTarget('#<portlet:namespace />fm'); 
					
					*/
				}
			}
		}
	});
}

</aui:script>