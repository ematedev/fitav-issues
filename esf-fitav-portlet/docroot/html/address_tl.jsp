<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="it.ethica.esf.service.persistence.ESFCountryUtil"%>
<%@page import="it.ethica.esf.service.ESFCountryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCountry"%>
<%@include file="init.jsp"%>
<%
	String className = ParamUtil.getString(request, "className");
	long classPK = ParamUtil.getLong(request, "classPK");
	int iesima = ParamUtil.getInteger(request, "iesima");
	long idOwner = ParamUtil.getLong(request, "idOwner");
	boolean requiredField = ParamUtil.getBoolean(request, "requiredField");
	int listTypeId = ParamUtil.getInteger(request, "listTypeId");
	boolean readOnly = ParamUtil.getBoolean(request, "readOnly",false);
	boolean isUser = ParamUtil.getBoolean(request, "isUser",false);
	int maxAdd = ESFKeys.MinElemIncludePage.MAXADDRESSUSER;
	
	List<ESFAddress> esfAddresses = new ArrayList<ESFAddress>();
	ESFAddress esfAddress = null; 
	
	String regions;
	String provinces;
	String cities;
	
	if (idOwner > 0) {
		esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), className, classPK);

		if(iesima < esfAddresses.size())
			esfAddress = esfAddresses.get(iesima);
	}
	
	if (Validator.isNull(request.getAttribute("regions"+iesima))) {
		regions = StringPool.BLANK;
	}
	else {
		regions = request.getAttribute("regions"+iesima).toString();
	}
	if (Validator.isNull(request.getAttribute("provinces"+iesima))) {
		provinces = StringPool.BLANK;
	}
	else {
		provinces = request.getAttribute("provinces"+iesima).toString();
	}
	if (Validator.isNull(request.getAttribute("cities"+iesima))) {
		cities = StringPool.BLANK;
	}
	else {
		cities = request.getAttribute("cities"+iesima).toString();
	}
	
	boolean ckvalN = false;
	
	try{
		ckvalN = esfAddresses.get(iesima).getIsNotNational();
	}catch (Exception e){
		_log.error("errore indirizzi", e);
	}
	
%>


<portlet:resourceURL var='regionsURL' id='<%="regions"+iesima%>' escapeXml="false" />
<portlet:resourceURL var='provincesURL' id='<%="provinces"+iesima%>' escapeXml="false" />
<portlet:resourceURL var='citiesURL' id='<%="cities"+iesima%>' escapeXml="false" />



<aui:model-context bean="<%=esfAddress%>" model="<%=ESFAddress.class%>" />
	<aui:fieldset>
	
		<aui:input type="hidden" name='<%= "esfAddressId"+iesima%>'
			value='<%=esfAddress == null
						? 0 : esfAddress.getEsfAddressId()%>' ></aui:input>
<% if(isUser ){%>
		<aui:input name='<%="international-place"+iesima%>' label='internationaAddress' type="checkbox" onChange='<%="showNation("+iesima+")"%>' checked="<%= ckvalN %>"></aui:input>

		<div id ='<%="nation-content"+iesima%>' >
		
		<%
			List<ESFCountry> countrys = new ArrayList<ESFCountry>();
			int totCountry = ESFCountryLocalServiceUtil.getESFCountriesCount();
			countrys = ESFCountryLocalServiceUtil.getESFCountries(0, totCountry);
			%>
			<aui:select name='<%="countryId"+iesima %>' label = "match-country ">
			<%
			for(ESFCountry country : countrys){ 
				boolean selected = false;
				if(Validator.isNotNull(esfAddress ) && Validator.isNotNull(esfAddress.getEsfCountryId()) && country.getIdCountry().equals(esfAddress.getEsfCountryId())){
					selected = true;
				}
			%>
				<aui:option value="<%= country.getIdCountry()%>"
						label="<%= country.getName()%>" selected="<%=selected %>"></aui:option>
			
			<%} %>
			</aui:select> 
		</div>
		<%} %>
		
		<div class="row-fields">
		
			<aui:col width="<%= 50 %>">
				<aui:select name='<%= "listTypeIdAddr"+iesima%>' label="list-type-id-addr">
					<%
					if(requiredField){
						ListType addressType = ListTypeServiceUtil.getListType(listTypeId);
						
					%>
						<aui:option label="<%= addressType.getName()%>" 
							value="<%= addressType.getListTypeId()%>" />
					<% 
					}
					else{
						List<ListType> addressTypes = ListTypeServiceUtil.getListTypes(
							ESFAddress.class.getName() + ESFListType.TYPEADDRESSES);
						
						for (ListType addressType : addressTypes) {
							
							String label = addressType.getName();
							
							if(addressType.getListTypeId() == listTypeId){
					%>
							<aui:option label="<%= label %>" 
								value="<%= addressType.getListTypeId() %>" selected="true"/>
					<%
							}
							else{
					%>
							<aui:option label="<%= label %>" 
								value="<%= addressType.getListTypeId() %>" />
								
					<%		}
						}
					}
					%>
				</aui:select>
			
			<%
			if( readOnly){
			%>	
				<aui:input 
					name='<%= "streetl1"+iesima%>'
					label="street"
					type="text"
					value='<%=esfAddress == null ? "" : HtmlUtil.escape(esfAddress.getStreet1()) %>'
					disabled="true" ></aui:input>
					
				<aui:input 
					name='<%= "street1"+iesima%>'
					type="hidden"
					value='<%=esfAddress == null ? "" : HtmlUtil.escape(esfAddress.getStreet1()) %>' ></aui:input>
				
				
				<aui:input name='<%= "zip"+iesima%>' label="zip" type="text"
					value='<%=esfAddress == null ? "" : esfAddress.getZip()%>' disabled="true" ></aui:input>
				<aui:input name='<%= "zip"+iesima%>' type="hidden"
					value='<%=esfAddress == null ? 00000 : esfAddress.getZip()%>' ></aui:input>
			<%}else{%>	
		
			<aui:input 
					name='<%= "street1"+iesima%>'
					label="street"
					type="text"
					value='<%=esfAddress == null ? "" : HtmlUtil.escape(esfAddress.getStreet1()) %>'
				> 
				<c:if test="<%= requiredField %>">
						<aui:validator name="required" errorMessage="please-enter-a-street" />
				</c:if>	
				
				</aui:input>
				
				<aui:input name='<%= "zip"+iesima%>' label="zip" type="text"
					value='<%=esfAddress == null ? "" : esfAddress.getZip()%>' >
					
					<c:if test="<%= requiredField %>">
						<aui:validator name="required"	errorMessage="please-enter-a-zip" />
					</c:if>
					
					<aui:validator name="number"	errorMessage="please-enter-number" />
					<aui:validator name="minLength"	errorMessage="please-enter-5-numbers">5</aui:validator>
					<aui:validator name="maxLength"	errorMessage="please-enter-5-numbers">5</aui:validator>
										
				</aui:input>
			<%}%>
		</aui:col>
<%if(isUser){%>
<div id ='<%="region-content"+iesima%>' >
		<aui:col width="<%= 50 %>">
		<c:choose>
		
			<c:when test="<%= readOnly%>">
				<aui:input name='<%= "regions"+iesima%>' label="regions" type="text"
					value='<%=esfAddress == null ? "" : esfAddress.getStreet1()%>' disabled="true" ></aui:input>
				<aui:input name='<%= "provinces"+iesima%>' label="provinces" type="text"
					value='<%=esfAddress == null ? "" : esfAddress.getStreet1()%>' disabled="true" ></aui:input>
				<aui:input name='<%= "cities"+iesima%>' label="cities" type="text"
					value='<%=esfAddress == null ? "" : esfAddress.getStreet1()%>' disabled="true" ></aui:input>
				
				<aui:input name='<%= "regions"+iesima%>' type="hidden"
					value='<%=esfAddress == null ? "" : esfAddress.getEsfRegionId() %>'  ></aui:input>
				<aui:input name='<%= "provinces"+iesima%>' type="hidden"
					value='<%=esfAddress == null ? "" : esfAddress.getEsfProvinceId() %>'  ></aui:input>
				<aui:input name='<%= "cities"+iesima%>' type="hidden"
					value='<%=esfAddress == null ? "" : esfAddress.getEsfCityId() %>' ></aui:input>

			</c:when>

			<c:otherwise>
				<%if(!requiredField){ %>
					<aui:select id='<%= "regions"+iesima%>' name='<%="esfRegionId"+iesima%>' label="regions" ></aui:select>
					<aui:select id='<%= "provinces"+iesima%>' name='<%= "esfProvinceId"+iesima%>' label="provinces" ></aui:select>
					<aui:select id='<%= "cities"+iesima%>' name='<%= "esfCityId"+iesima%>' label="cities" ></aui:select>
				<%}else{%>
					<aui:select id='<%= "regions"+iesima%>' name='<%="esfRegionId"+iesima%>' label="regions" required="true"></aui:select>
					<aui:select id='<%= "provinces"+iesima%>' name='<%= "esfProvinceId"+iesima%>' label="provinces" required="true"></aui:select>
					<aui:select id='<%= "cities"+iesima%>' name='<%= "esfCityId"+iesima%>' label="cities" required="true"></aui:select>
				<%} %>
			</c:otherwise>
		
		</c:choose>
			
		</aui:col>
		</div>
<%}else{%>
		<aui:col width="<%= 50 %>">
			<c:choose>
			
				<c:when test="<%= readOnly%>">
					<aui:input name='<%= "regions"+iesima%>' label="regions" type="text"
						value='<%=esfAddress == null ? "" : esfAddress.getStreet1()%>' disabled="true" ></aui:input>
					<aui:input name='<%= "provinces"+iesima%>' label="provinces" type="text"
						value='<%=esfAddress == null ? "" : esfAddress.getStreet1()%>' disabled="true" ></aui:input>
					<aui:input name='<%= "cities"+iesima%>' label="cities" type="text"
						value='<%=esfAddress == null ? "" : esfAddress.getStreet1()%>' disabled="true" ></aui:input>
					
					<aui:input name='<%= "regions"+iesima%>' type="hidden"
						value='<%=esfAddress == null ? "" : esfAddress.getEsfRegionId() %>'  ></aui:input>
					<aui:input name='<%= "provinces"+iesima%>' type="hidden"
						value='<%=esfAddress == null ? "" : esfAddress.getEsfProvinceId() %>'  ></aui:input>
					<aui:input name='<%= "cities"+iesima%>' type="hidden"
						value='<%=esfAddress == null ? "" : esfAddress.getEsfCityId() %>' ></aui:input>
	
				</c:when>
	
				<c:otherwise>
					<%if(!requiredField){ %>
						<aui:select id='<%= "regions"+iesima%>' name='<%="esfRegionId"+iesima%>' label="regions" ></aui:select>
						<aui:select id='<%= "provinces"+iesima%>' name='<%= "esfProvinceId"+iesima%>' label="provinces" ></aui:select>
						<aui:select id='<%= "cities"+iesima%>' name='<%= "esfCityId"+iesima%>' label="cities" ></aui:select>
					<%}else{%>
						<aui:select id='<%= "regions"+iesima%>' name='<%="esfRegionId"+iesima%>' label="regions" required="true"></aui:select>
						<aui:select id='<%= "provinces"+iesima%>' name='<%= "esfProvinceId"+iesima%>' label="provinces" required="true"></aui:select>
						<aui:select id='<%= "cities"+iesima%>' name='<%= "esfCityId"+iesima%>' label="cities" required="true"></aui:select>
					<%} %>
				</c:otherwise>
			
			</c:choose>
			
		</aui:col>

<%}
if(isUser){ %>
		<div id ='<%="regionExt-content"+iesima%>' >
			
			<aui:input name='<%= "esfProvinceIdNaz"+iesima%>' label="provinces" type="text"
					value='<%=esfAddress == null ? "" : esfAddress.getEsfProvinceId()%>'  ></aui:input>
			<aui:input name='<%= "esfCityIdNaz"+iesima%>' label="cities" type="text"
					value='<%=esfAddress == null ? "" : esfAddress.getEsfRegionId()%>' ></aui:input>
		</div>
<%} %>
	</div>
	
	</aui:fieldset>
	
	
	
<aui:script use="aui-base,node,aui-io-request">

var readOnly=<%= readOnly %>;
var regions = JSON.parse('<%= regions.equals("")?null:HtmlUtil.escapeJS(regions) %>');
var provinces = JSON.parse('<%= provinces.equals("")?null:HtmlUtil.escapeJS(provinces) %>');
var cities = JSON.parse('<%= cities.equals("")?null:HtmlUtil.escapeJS(cities) %>');

var regionId = '<%= esfAddress != null?esfAddress.getEsfRegionId():ESFKeys.ESFAddressConstant.DEFAULT_STRING%>';
var provinceId = '<%= esfAddress != null?esfAddress.getEsfProvinceId():ESFKeys.ESFAddressConstant.DEFAULT_STRING%>';
var cityId = '<%= esfAddress != null?esfAddress.getEsfCityId():ESFKeys.ESFAddressConstant.DEFAULT_NUMBER%>';

var regionName = '';
var provinceName = '';
var cityName = '';


var regionsOptions = '<option value="">-</option>';

for(regIndex in regions) {
	if(regions[regIndex][0] == regionId){
		regionsOptions += '<option selected="selected" value="'+ regions[regIndex][0] +'">' + regions[regIndex][1] + '</option>';
		regionName =regions[regIndex][1];
	}
	else {
		regionsOptions += '<option value="'+ regions[regIndex][0] +'">' + regions[regIndex][1] + '</option>';
	}
}

var provincesOptions = '<option value="">-</option>';

for(provIndex in provinces) {
	if(provinces[provIndex][0] == provinceId){
		provincesOptions += '<option selected="selected" value="'+ provinces[provIndex][0] +'">' + provinces[provIndex][1] + '</option>';
		provinceName =provinces[provIndex][1];

	}
	else {
		provincesOptions += '<option value="'+ provinces[provIndex][0] +'">' + provinces[provIndex][1] + '</option>';
	}
}

var citiesOptions = '<option value="0">-</option>';

for(cityIndex in cities) {
	if(cities[cityIndex][0] == cityId){
		citiesOptions += '<option selected="selected" value='+ cities[cityIndex][0] +'>' + cities[cityIndex][1] + '</option>';
		cityName=cities[cityIndex][1];
	}
	else {
		citiesOptions += '<option value='+ cities[cityIndex][0] +'>' + cities[cityIndex][1] + '</option>';
	}
}

if(readOnly){
	A.one('#<portlet:namespace/>regions<%= iesima%>').html(regionName);
	A.one('#<portlet:namespace/>provinces<%= iesima%>').html(provinceName);
	A.one('#<portlet:namespace/>cities<%= iesima%>').html(cityName);
	
}else{

	A.one('#<portlet:namespace/>regions<%= iesima%>').html(regionsOptions);
	A.one('#<portlet:namespace/>provinces<%= iesima%>').html(provincesOptions);
	A.one('#<portlet:namespace/>cities<%= iesima%>').html(citiesOptions);
	
	A.one('#<portlet:namespace/>regions<%= iesima%>').on('change', changeSelect);
	A.one('#<portlet:namespace/>provinces<%= iesima%>').on('change', changeSelect);
	A.one('#<portlet:namespace/>cities<%= iesima%>').on('change', changeSelect);
	
}

function changeSelect(event) {
	var element = event.currentTarget;
	var type = element.get('id').replace('<portlet:namespace/>', '');
	var param = '';
	var idRegion = ''; 
	var idProvince = '';
	if(type == 'regions<%= iesima%>') {
		idRegion = A.one('#<portlet:namespace/>regions<%= iesima%>').get('value');
	}
	else if(type == 'provinces<%= iesima%>'){
		idRegion = A.one('#<portlet:namespace/>regions<%= iesima%>').get('value');
		idProvince = A.one('#<portlet:namespace/>provinces<%= iesima%>').get('value');
	}
	
	var resourceURL = '';
	if (type == 'regions<%= iesima%>') {
		resourceURL = '<%= regionsURL%>';
	}
	else if (type == 'provinces<%= iesima%>') {
		resourceURL = '<%= provincesURL %>';
	}
	else if (type == 'cities<%= iesima%>') {
		resourceURL = '<%= citiesURL %>';
	}
	A.io.request(
		resourceURL,
		{
			method: 'POST',
			contentType: "application/json; charset=utf-8",
			data: {
				param:param,
				idRegion:idRegion,
				idProvince:idProvince
			},
			on: {
				success: function() {
					var results = JSON.parse(this.get('responseData'));
					var resultsOption = '<option value="">-</option>';
					if(type == 'regions<%= iesima%>'){
						A.one('#<portlet:namespace/>provinces<%= iesima%>').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>provinces<%= iesima%>').html(resultsOption);
						}
						A.one('#<portlet:namespace/>cities<%= iesima%>').html('<option value="0">-</option>');
					}
					else if(type == 'provinces<%= iesima%>') {
						A.one('#<portlet:namespace/>cities<%= iesima%>').html('<option value="0">-</option>');
						for(index in results) {
							resultsOption += '<option value='+ results[index][0] +'>' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>cities<%= iesima%>').html(resultsOption);
						}
					}
				}
		}
	});
}

var statusN = '<%=ckvalN %>';

window.showNation = function(id) {
	if(A.one('#<portlet:namespace/>international-place'+id)){
		statusN = A.one('#<portlet:namespace/>international-place'+id).val();
		
		if (statusN == 'true') {
			A.one('#nation-content'+id).show();
			A.one('#regionExt-content'+id).show();
			A.one('#region-content'+id).hide();
			
		} else {
			A.one('#nation-content'+id).hide();
			A.one('#regionExt-content'+id).hide();
			A.one('#region-content'+id).show();
		}
	}
}

$(document).ready(function(){
	for( i = 0 ; i <= <%=iesima%> ; i++){
		window.showNation(i);
	};

});

</aui:script>
	