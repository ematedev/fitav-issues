<%@include file="init.jsp"%>


<%

long roleId = ParamUtil.getLong(request, "roleId");
long esfUserIdR = ParamUtil.getLong(request, "esfUserId");

	List<ESFOrganization> esfOrganizations= Collections.emptyList();
	ESFOrganization esfOrganization = null; 
	
	String liv1;
	String liv2;
	String liv3;
	

	if (Validator.isNull(request.getAttribute("liv1"))) {
		liv1 = StringPool.BLANK;
	}
	else {
		liv1 = request.getAttribute("liv1").toString();
	}
	if (Validator.isNull(request.getAttribute("liv2"))) {
		liv2 = StringPool.BLANK;
	}
	else {
		liv2 = request.getAttribute("liv2").toString();
	}
	if (Validator.isNull(request.getAttribute("liv3"))) {
		liv3 = StringPool.BLANK;
	}
	else {
		liv3 = request.getAttribute("liv3").toString();
	}
%>


<portlet:resourceURL var="liv1URL" id="liv1" escapeXml="false" />
<portlet:resourceURL var="liv2URL" id="liv2" escapeXml="false" />
<portlet:resourceURL var="liv3URL" id="liv3" escapeXml="false" />

<aui:script use="node,aui-io-request,node-event-simulate">

var liv1 = JSON.parse('<%= liv1.equals("")?null:HtmlUtil.escapeJS(liv1) %>');
var liv2 = JSON.parse('<%= liv2.equals("")?null:HtmlUtil.escapeJS(liv2) %>');
var liv3 = JSON.parse('<%= liv3.equals("")?null:HtmlUtil.escapeJS(liv3) %>');

var liv1Options = '<option value="">-</option>';

for(liv1Index in liv1) {
	liv1Options += '<option value="'+ liv1[liv1Index][0] +'">' + liv1[liv1Index][1] + '</option>';
}

var liv2Options = '<option value="">-</option>';
for(liv2Index in liv2) {
	liv2Options += '<option value="'+ liv2[liv2Index][0] +'">' + liv2[liv2Index][1] + '</option>';
}

var liv3Options = '<option value="">-</option>';
for(liv3Index in liv3) {
	liv3Options += '<option value="'+ liv3[liv3Index][0] +'">' + liv3[liv3Index][1] + '</option>';
}

A.one('#<portlet:namespace/>liv1').html(liv1Options);
A.one('#<portlet:namespace/>liv2').html(liv2Options);
A.one('#<portlet:namespace/>liv3').html(liv3Options);

A.one('#<portlet:namespace/>liv1').on('change', changeSelect);
A.one('#<portlet:namespace/>liv2').on('change', changeSelect);
A.one('#<portlet:namespace/>liv3').on('change', changeSelect);
console.log("1");
console.log("1 jdxònjzdklx");
A.one('#<portlet:namespace/>liv1').simulate('change');
function changeSelect(event) {

console.log("entro");
	var element = event.currentTarget;
	var type = element.get('id').replace('<portlet:namespace/>', '');
	var param = '';
	var id = ''; 
	if(type == 'liv1') {
		id = A.one('#<portlet:namespace/>liv1').get('value');
	}
	else if(type == 'liv2'){
		id= A.one('#<portlet:namespace/>liv2').get('value');
	}
	
	var resourceURL = '';
	if (type == 'liv1') {
		resourceURL = '<%= liv1URL %>';
	}
	else if (type == 'liv2') {
		resourceURL = '<%= liv2URL %>';
	}
	else if (type == 'liv3') {
		resourceURL = '<%= liv3URL %>';
	}
	A.io.request(
		resourceURL,
		{
			
			method: 'POST',
			contentType: "application/json; charset=utf-8",
			data: {
				
				param:param,
				esfOrganizationId:id
			},
			on: {
				success: function() {
					
					var results = JSON.parse(this.get('responseData'));
					var resultsOption = '<option value="">-</option>';
					console.log("resultsOption="+resultsOption);
					if(type == 'liv1'){
						A.one('#<portlet:namespace/>liv2').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>liv2').html(resultsOption);
						}
						A.one('#<portlet:namespace/>liv3').html('<option value="0">-</option>');
					}
					else if(type == 'liv2') {
						A.one('#<portlet:namespace/>liv3').html('<option value="0">-</option>');
						for(index in results) {
							resultsOption += '<option value='+ results[index][0] +'>' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>liv3').html(resultsOption);
						}
					}
				}
		}
	});
}
</aui:script>


<portlet:actionURL  name="assignMember" var="assignMemberURL">
</portlet:actionURL>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%="/html/esfnationalmatch/tabs/edit_esfShooter.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserIdR)%>' />
			<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId)%>' />
	</portlet:renderURL>
	
<aui:form action="<%= assignMemberURL %>"
	name="<portlet:namespace />fm">
	<aui:fieldset>
	
		<aui:input type="hidden" name="esfUserRoleId" value='<%= roleId%>' />
		<aui:input type="hidden" name="esfUserId" value='<%= esfUserIdR%>' />
		
		<aui:select id="liv0" name="esfLiv0Id" >
			<aui:option value="<%= currentOrganizationId%>">FITAV</aui:option>
		</aui:select>
		<aui:select id="liv1" name="esfLiv1Id" showEmptyOption="true"></aui:select>
		<aui:select id="liv2" name="esfLiv2Id" showEmptyOption="true"></aui:select>
		<aui:select id="liv3" name="esfLiv3Id" showEmptyOption="true"></aui:select>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="assign-role"></aui:button>
		<aui:button type="cancel" onClick="<%= backUrl %>"></aui:button>
	</aui:button-row>

</aui:form>
		