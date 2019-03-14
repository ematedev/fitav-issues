<%@include file="navigation_init.jsp"%>
<%
String className = (String)request.getAttribute("addresses.className");
long classPK = (Long)request.getAttribute("addresses.classPK");

List<ESFAddress> esfAddresses = Collections.emptyList();

int[] esfAddressesIndexes = null;

String addressesIndexesParam = ParamUtil.getString(request, "addressesIndexes");

if (Validator.isNotNull(addressesIndexesParam)) {
	esfAddresses = new ArrayList<ESFAddress>();

	esfAddressesIndexes = StringUtil.split(addressesIndexesParam, 0);

	for (int esfAddressesIndex : esfAddressesIndexes) {
		esfAddresses.add(new ESFAddressImpl());
	}
}
else {
	if (esfOrganizationId > 0) {
		esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), className, classPK);
		
		esfAddressesIndexes = new int[esfAddresses.size()];

		for (int i = 0; i < esfAddresses.size() ; i++) {
			esfAddressesIndexes[i] = i;
		}
	}

	if (esfAddresses.isEmpty()) {
		esfAddresses = new ArrayList<ESFAddress>();

		esfAddresses.add(new ESFAddressImpl());

		esfAddressesIndexes = new int[] {0};
	}

	if (esfAddressesIndexes == null) {
		esfAddressesIndexes = new int[0];
	}
}

%>

<liferay-ui:error-marker key="errorSection" value="addresses" />

<h3><liferay-ui:message key="addresses" /></h3>

<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />

<aui:fieldset cssClass="addresses">

	<%
	for (int i = 0; i < esfAddressesIndexes.length; i++) {
		int addressesIndex = esfAddressesIndexes[i];
		
		ESFAddress esfAddress = esfAddresses.get(i);
	%>

		<aui:model-context bean="<%= esfAddress %>" model="<%= ESFAddress.class %>" />

		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:col width="<%= 50 %>">
					<aui:input name='<%= "addressId" + addressesIndex %>' type="hidden" value="<%= esfAddress.getEsfAddressId() %>" />
				
					<aui:input fieldParam='<%= "addressStreet1_" + addressesIndex %>' id='<%= "addressStreet1_" + addressesIndex %>' name="street1" />
				
					<aui:input fieldParam='<%= "addressStreet2_" + addressesIndex %>' id='<%= "addressStreet2_" + addressesIndex %>' name="street2" />
				
					<aui:input fieldParam='<%= "addressStreet3_" + addressesIndex %>' id='<%= "addressStreet3_" + addressesIndex %>' name="street3" />
				</aui:col>
				
				<aui:col width="<%= 50 %>">
					<aui:input fieldParam='<%= "addressZip" + addressesIndex %>' id='<%= "addressZip" + addressesIndex %>' label="postal-code" name="zip" />

					<aui:input fieldParam='<%= "latitude" + addressesIndex %>' id='<%= "latitude" + addressesIndex %>' label="latitude" name="latitude" />

					<aui:input fieldParam='<%= "longitude" + addressesIndex %>' id='<%= "longitude" + addressesIndex %>' label="longitude" name="longitude" />

					<aui:input checked="<%= esfAddress.getEsfAddressId() == 0?false:esfAddress.getPrimary_() %>" cssClass="primary-ctrl" id='<%= "addressPrimary" + addressesIndex %>' label="primary" name="addressPrimary" type="radio" value="<%= addressesIndex %>" />
				
					<aui:input cssClass="mailing-ctrl" fieldParam='<%= "addressMailing" + addressesIndex %>' id='<%= "addressMailing" + addressesIndex %>' name="mailing" />
				</aui:col>
			</div>
		</div>

	<%
	}
	%>

	<aui:input name="addressesIndexes" type="hidden" value="<%= StringUtil.merge(esfAddressesIndexes) %>" />
</aui:fieldset>

<aui:script use="liferay-auto-fields,liferay-dynamic-select">
	Liferay.once(
		'formNavigator:reveal<portlet:namespace />addresses',
		function() {
			var addresses = new Liferay.AutoFields(
				{
					contentBox: '#<portlet:namespace />addresses > fieldset',
					fieldIndexes: '<portlet:namespace />addressesIndexes',
					namespace: '<portlet:namespace />',
					on: {
						'clone': function(event) {
							var row = event.row;
							var guid = event.guid;

							var dynamicSelects = row.one('select[data-componentType=dynamic_select]');

							if (dynamicSelects) {
								dynamicSelects.detach('change');
							}

							new Liferay.DynamicSelect(
								[
									{
										select: '<portlet:namespace />addressCountryId' + guid,
										selectData: Liferay.Address.getCountries,
										selectDesc: 'nameCurrentValue',
										selectSort: '<%= true %>',
										selectId: 'countryId',
										selectVal: '0'
									},
									{
										select: '<portlet:namespace />addressRegionId' + guid,
										selectData: Liferay.Address.getRegions,
										selectDesc: 'name',
										selectId: 'regionId',
										selectVal: '0'
									}
								]
							);
						}
					}
				}
			).render();
		}
	);
</aui:script>