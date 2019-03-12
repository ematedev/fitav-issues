<%@include file="init.jsp"%>

<h3>
	<liferay-ui:message key="addresses" />
</h3>

<c:if test="<%=esfAddressesToPrint.length < 2%>">
	<div class="alert alert-info">
		<liferay-ui:message key="no-address"></liferay-ui:message>
	</div>
</c:if>

<%
for (int j = 0; j < esfAddressesToPrint.length; j++) {
	
	if(j!=ESFKeys.ESFAddressType.TYPES_POSITION_FIELD && Validator.isNotNull(esfAddressesToPrint[j])){
		ListType addressType = null;
		if ( Validator.isNull(esfAddressesToPrint[j]) || Validator.isNull(esfAddressesToPrint[j].getListTypeId())){
			addressType = ListTypeServiceUtil.getListType(ESFAddressListType.OTHER);
		}
		else{
			addressType = ListTypeServiceUtil.getListType(esfAddressesToPrint[j].getListTypeId());
		}
%>
<h3>
<liferay-ui:message key="<%=addressType.getName()%>" />
</h3>
<div class = "row detail">
	<div class = "span6">
		<h4><liferay-ui:message key="street1" /></h4>
		<p><%=esfAddressesToPrint[j].getStreet1()%></p>
		<h4><liferay-ui:message key="zip" /></h4>
		<p><%=esfAddressesToPrint[j].getZip()%></p>
	</div>
	<div class = "span6">
		<%
		long idCity = esfAddressesToPrint[j].getEsfCityId();
		String idCountry = esfAddressesToPrint[j].getEsfCountryId();
		String idProvince = esfAddressesToPrint[j].getEsfProvinceId();
		String idRegion = esfAddressesToPrint[j].getEsfRegionId();
		
		String city="";
		String province="";
		String region="";
		if(idCity>0){
			ESFCityPK cityPk = new ESFCityPK();
			cityPk.setIdCity(idCity);
			cityPk.setIdCountry(idCountry);
			cityPk.setIdProvince(idProvince);
			cityPk.setIdRegion(idRegion);
			
			if ( Validator.isNotNull(ESFCityLocalServiceUtil.fetchESFCity(cityPk))){
			city=ESFCityLocalServiceUtil.fetchESFCity(cityPk).getName();
			}
		}
		
			
		%>
		<h4><liferay-ui:message key="city" /></h4>
		<p><%=city%></p>

		<h4><liferay-ui:message key="province" /></h4>
		<p><%=esfAddressesToPrint[j].getEsfProvinceId()%></p>
	
	</div>
</div>
<div class="separator"></div>

<%
	}
}		
%>
