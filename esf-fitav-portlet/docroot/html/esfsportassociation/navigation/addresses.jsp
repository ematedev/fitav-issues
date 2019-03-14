<%@include file="init.jsp"%>

<%

	String className = (String)request.getAttribute("addresses.className");
	long classPK = (Long)request.getAttribute("addresses.classPK");
	
	int number = (Integer)request.getAttribute("number");
	boolean  isCkisarmy = ParamUtil.getBoolean(request,"ckisarmy");
	

%>

	<!-- 	OBBLIGATORIO -->
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">	
			<liferay-util:include page='<%= jspAddressTL %>' servletContext="<%= application%>" >
				<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
				<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
				<liferay-util:param name="iesima" value="<%= Integer.toString(1) %>"></liferay-util:param>
				<liferay-util:param name="idOwner" value="<%= Long.toString(esfOrganizationId) %>"></liferay-util:param>
				<liferay-util:param name="listTypeId" value="<%= Integer.toString(ESFAddressListType.CORRESPONDENCE) %>"></liferay-util:param>
				<liferay-util:param name="requiredField" value="true"></liferay-util:param>
			</liferay-util:include>
		</div>
	</div>
	
	<!-- 	OBBLIGATORIO -->
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">	
			<liferay-util:include page='<%= jspAddressTL %>' servletContext="<%= application%>" >
				<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
				<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
				<liferay-util:param name="iesima" value="<%= Integer.toString(2) %>"></liferay-util:param>
				<liferay-util:param name="idOwner" value="<%= Long.toString(esfOrganizationId) %>"></liferay-util:param>
				<liferay-util:param name="listTypeId" value="<%= Integer.toString(ESFAddressListType.STAND) %>"></liferay-util:param>
				<liferay-util:param name="requiredField" value="<%= String.valueOf( !isSimplyOrganizzation) %>"></liferay-util:param>
			</liferay-util:include>
		</div>
	</div>
	
	<% 
	
	for (int i = ESFKeys.MinElemIncludePage.MINADDRESSORG; i < ESFKeys.MinElemIncludePage.MAXADDRESSORG; i++){ 
		
		String visible = "display:none;";
		
		if(i < number){
			
			visible = "";
		}
	%>
	
	<div class="lfr-form-row lfr-form-row-inline" style="<%= visible%>" id='<%= "cont-"+i%>'>
		<%
		int listTypeId = 0;
		
		if(esfOrganization != null && visible.equals("")){
				
				List<ESFAddress> esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(
					themeDisplay.getCompanyId(), className, classPK);
				
				ESFAddress esfAddress = esfAddresses.get(i);
				
				listTypeId = esfAddress.getListTypeId();
		}
		%>
		<div class="row-fields">	
			<liferay-util:include page='<%= jspAddressTL %>' servletContext="<%= application%>" >
				<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
				<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
				<liferay-util:param name="iesima" value="<%= Integer.toString(i) %>"></liferay-util:param>
				<liferay-util:param name="idOwner" value="<%= Long.toString(esfOrganizationId) %>"></liferay-util:param>
				<liferay-util:param name="listTypeId" value="<%= Integer.toString(listTypeId) %>"></liferay-util:param>
				<liferay-util:param name="requiredField" value="false"></liferay-util:param>
			</liferay-util:include>
		</div>
	</div>
	
	<%} %>


	<aui:input name="number" type="hidden" value="<%= number%>" />
	
	<aui:input name="typeOrg" type="hidden" value="<%= ESFKeys.ESFOrganizationTypeId.ASSOCIATION %>" />
	
	<aui:button name="btnadd" value="add-addr"></aui:button>
	<aui:button name="btnrem" value="rem-addr"></aui:button>



<aui:script use="node,aui-io-request,liferay-auto-fields">

A.one('#<portlet:namespace/>btnadd').on('click', addAddress);
A.one('#<portlet:namespace/>btnrem').on('click', removeAddress);

var maxS = '<%= ESFKeys.MinElemIncludePage.MAXADDRESSORG %>'; 
var minS = '<%= ESFKeys.MinElemIncludePage.MINADDRESSORG %>'; 

var max = parseInt(maxS);
var min = parseInt(minS);

function addAddress(event){
	var numS = A.one('#<portlet:namespace/>number').get('value');
	var num = parseInt(numS);
	
	if(max > num){
		
		A.one('#cont-'+num).setStyle('display', "");
		num++;
		A.one('#<portlet:namespace/>number').set('value', num);
	
	}
	else{
		alert('Massimo '+max+' indirizzi');
	}
}

function removeAddress(event){
	var numS = A.one('#<portlet:namespace/>number').get('value');
	var num = parseInt(numS);
	
	if(num > min){
		num--;
		A.one('#<portlet:namespace/>number').set('value', num);
		A.one('#cont-'+num).setStyle('display', "none");
	}
}


</aui:script>
