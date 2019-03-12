<%@include file="/addressadmin/init.jsp"%>

<%
	ESFAddress esfAdrress = null;

	String regions;
	String provinces;
	String cities;
	
	long esfAddressId = ParamUtil.getLong(request, "esfAddressId");

	if (esfAddressId > 0) {
		esfAdrress =
	ESFAddressLocalServiceUtil.getESFAddress(esfAddressId);
	}

	if (Validator.isNull(request.getAttribute("regions"))) {
		regions = StringPool.BLANK;
	}
	else {
		regions = request.getAttribute("regions").toString();
	}
	if (Validator.isNull(request.getAttribute("provinces"))) {
		provinces = StringPool.BLANK;
	}
	else {
		provinces = request.getAttribute("provinces").toString();
	}
	if (Validator.isNull(request.getAttribute("cities"))) {
		cities = StringPool.BLANK;
	}
	else {
		cities = request.getAttribute("cities").toString();
	}
	
%>


<portlet:resourceURL var="regionsURL" id="regions" escapeXml="false" />
<portlet:resourceURL var="provincesURL" id="provinces" escapeXml="false" />
<portlet:resourceURL var="citiesURL" id="cities" escapeXml="false" />

<aui:script use="node,aui-io-request">

var regions = JSON.parse('<%= regions.equals("")?null:HtmlUtil.escapeJS(regions) %>');
var provinces = JSON.parse('<%= provinces.equals("")?null:HtmlUtil.escapeJS(provinces) %>');
var cities = JSON.parse('<%= cities.equals("")?null:HtmlUtil.escapeJS(cities) %>');

var regionId = '<%= esfAddressId > 0?esfAdrress.getEsfRegionId():ESFConstant.DEFAULT_STRING%>';
var provinceId = '<%= esfAddressId > 0?esfAdrress.getEsfProvinceId():ESFConstant.DEFAULT_STRING%>';
var cityId = '<%= esfAddressId > 0?esfAdrress.getEsfCityId():ESFConstant.DEFAULT_NUMBER%>';

var regionsOptions = '<option value="">-</option>';
for(regIndex in regions) {
	if(regions[regIndex][0] == regionId)
		regionsOptions += '<option selected="selected" value="'+ regions[regIndex][0] +'">' + regions[regIndex][1] + '</option>';
	else 
		regionsOptions += '<option value="'+ regions[regIndex][0] +'">' + regions[regIndex][1] + '</option>';
}

var provincesOptions = '<option value="">-</option>';
for(provIndex in provinces) {
	if(provinces[provIndex][0] == provinceId)
		provincesOptions += '<option selected="selected" value="'+ provinces[provIndex][0] +'">' + provinces[provIndex][1] + '</option>';
	else	
		provincesOptions += '<option value="'+ provinces[provIndex][0] +'">' + provinces[provIndex][1] + '</option>';
}

var citiesOptions = '<option value="0">-</option>';
for(cityIndex in cities) {
	if(cities[cityIndex][0] == cityId)
		citiesOptions += '<option selected="selected" value='+ cities[cityIndex][0] +'>' + cities[cityIndex][1] + '</option>';
	else
		citiesOptions += '<option value='+ cities[cityIndex][0] +'>' + cities[cityIndex][1] + '</option>';
}

A.one('#<portlet:namespace/>regions').html(regionsOptions);
A.one('#<portlet:namespace/>provinces').html(provincesOptions);
A.one('#<portlet:namespace/>cities').html(citiesOptions);

A.one('#<portlet:namespace/>regions').on('change', changeSelect);
A.one('#<portlet:namespace/>provinces').on('change', changeSelect);
A.one('#<portlet:namespace/>cities').on('change', changeSelect);

function changeSelect(event) {
	var element = event.currentTarget;
	var type = element.get('id').replace('<portlet:namespace/>', '');
	var param = '';
	var idRegion = ''; 
	var idProvince = '';
	if(type == 'regions') {
		idRegion = A.one('#<portlet:namespace/>regions').get('value');
	}
	else if(type == 'provinces'){
		idRegion = A.one('#<portlet:namespace/>regions').get('value');
		idProvince = A.one('#<portlet:namespace/>provinces').get('value');
	}
	
	var resourceURL = '';
	if (type == 'regions') {
		resourceURL = '<%= regionsURL %>';
	}
	else if (type == 'provinces') {
		resourceURL = '<%= provincesURL %>';
	}
	else if (type == 'cities') {
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
					console.log(results);
					var resultsOption = '<option value="">-</option>';
					if(type == 'regions'){
						A.one('#<portlet:namespace/>provinces').html('<option value="">-</option>');
						for(index in results) {
							resultsOption += '<option value="'+ results[index][0] +'">' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>provinces').html(resultsOption);
						}
						A.one('#<portlet:namespace/>cities').html('<option value="0">-</option>');
					}
					else if(type == 'provinces') {
						A.one('#<portlet:namespace/>cities').html('<option value="0">-</option>');
						for(index in results) {
							resultsOption += '<option value='+ results[index][0] +'>' + results[index][1] + '</option>';
							A.one('#<portlet:namespace/>cities').html(resultsOption);
						}
					}
				}
		}
	});
}
</aui:script>
	





<portlet:renderURL var="viewURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value="/addressadmin/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL
	name='<%=esfAdrress == null ? "addESFAddress" : "updateESFAddress"%>'
	var="editESFAddressURL" />

<aui:form action="<%=editESFAddressURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=esfAdrress%>" model="<%=ESFAddress.class%>" />
	<aui:fieldset>
		<aui:input type="hidden" name="esfAddressId"
			value='<%=esfAdrress == null
						? "" : esfAdrress.getEsfAddressId()%>' />
		<aui:input name="street1"
			value='<%=esfAdrress == null
							? "" : esfAdrress.getStreet1()%>'>
		</aui:input>
		<aui:input name="longitude"
			value='<%=esfAdrress == null
						? "" : esfAdrress.getLongitude() + ""%>' />
		<aui:input name="latitude"
			value='<%=esfAdrress == null
						? "" : esfAdrress.getLatitude() + ""%>' />

		<aui:select id="regions" name="esfRegionId" showEmptyOption="true"></aui:select>
		<aui:select id="provinces" name="esfProvinceId" showEmptyOption="true"></aui:select>
		<aui:select id="cities" name="esfCityId" showEmptyOption="true"></aui:select>

	</aui:fieldset>

	<liferay-ui:asset-categories-error />
	<liferay-ui:asset-tags-error />
	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryCategorizationPanel" persistState="<%=true%>"
		title="categorization">
		<aui:fieldset>
			<aui:input name="categories" type="assetCategories" />

			<aui:input name="tags" type="assetTags" />
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryAssetLinksPanel" persistState="<%=true%>"
		title="related-assets">
		<aui:fieldset>
			<liferay-ui:input-asset-links
				className="<%=ESFAddress.class.getName()%>"
				classPK="<%=esfAddressId%>" />
		</aui:fieldset>
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>
