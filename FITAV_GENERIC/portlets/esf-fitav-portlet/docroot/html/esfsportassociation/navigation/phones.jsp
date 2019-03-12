<%@include file="init.jsp"%>

<%

String className = (String)request.getAttribute("phones.className");
long classPK = (Long)request.getAttribute("phones.classPK");
	
int numberOfPhones = (Integer)request.getAttribute("numberOfPhones");

%>

	<h3><liferay-ui:message key="phone-numbers" /></h3>

	<!-- 	OBBLIGATORIO -->
	
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">	
			<liferay-util:include page='<%= jspPhoneTL %>' servletContext="<%= application%>" >
				<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
				<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
				<liferay-util:param name="iesima" value="<%= Integer.toString(0) %>"></liferay-util:param>
				<liferay-util:param name="idOwner" value="<%= Long.toString(esfOrganizationId) %>"></liferay-util:param>
			</liferay-util:include>
		</div>
	</div>
	
	<% 
	
	for (int i = ESFKeys.MinElemIncludePage.MINPHONEORG; i < ESFKeys.MinElemIncludePage.MAXPHONEORG; i++){ 
		
		String visible = "display:none;";
		
		if(i < numberOfPhones){
			
			visible = "";
		}
	%>
	
	<div class="lfr-form-row lfr-form-row-inline" style="<%= visible%>" id='<%= "contPhone-"+i%>'>
		<div class="row-fields">	
			<liferay-util:include page='<%= jspPhoneTL %>' servletContext="<%= application%>" >
				<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
				<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
				<liferay-util:param name="iesima" value="<%= Integer.toString(i) %>"></liferay-util:param>
				<liferay-util:param name="idOwner" value="<%= Long.toString(esfOrganizationId) %>"></liferay-util:param>
			</liferay-util:include>
		</div>
	</div>
	
	<%} %>


	<aui:input name="numberOfPhones" type="hidden" value="<%= numberOfPhones %>"></aui:input>
	
	<aui:button name="btnaddphone" value="add-pho"></aui:button>
	<aui:button name="btnremphone" value="rem-pho"></aui:button>



<aui:script use="node,aui-io-request,liferay-auto-fields">

A.one('#<portlet:namespace/>btnaddphone').on('click', addPhones);
A.one('#<portlet:namespace/>btnremphone').on('click', removePhones);

var maxS = '<%= ESFKeys.MinElemIncludePage.MAXPHONEORG %>'; 
var minS = '<%= ESFKeys.MinElemIncludePage.MINPHONEORG %>'; 

var max = parseInt(maxS);
var min = parseInt(minS);

function addPhones(event){
	var numS = A.one('#<portlet:namespace/>numberOfPhones').get('value');
	var num = parseInt(numS);
	
	if(max > num){
		
		A.one('#contPhone-'+num).setStyle('display', "");
		num++;
		A.one('#<portlet:namespace/>numberOfPhones').set('value', num);
	
	}
	else{
		alert('Massimo '+max+' numeri telefonici');
	}
}

function removePhones(event){
	var numS = A.one('#<portlet:namespace/>numberOfPhones').get('value');
	var num = parseInt(numS);
	
	if(num > min){
		num--;
		A.one('#<portlet:namespace/>numberOfPhones').set('value', num);
		A.one('#contPhone-'+num).setStyle('display', "none");
	}
}


</aui:script>
