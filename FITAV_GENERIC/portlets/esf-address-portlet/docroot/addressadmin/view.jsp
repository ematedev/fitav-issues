<%@include file="/addressadmin/init.jsp"%>


<%
	// 	long esfAddressId = Long.valueOf((Long) renderRequest
	// 			.getAttribute("esfAddressId"));
%> 

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/addressadmin/html/search_esfAddress.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%=true%>" label="" name="keywords" size="30"
				title="search-entries" type="text" /> <aui:button type="submit"
				value="search" />
		</span>
	</div>
</aui:form>

<c:if
	test='<%=ESFAddressModelPermission.contains(
					permissionChecker, scopeGroupId,
					ESFAddressActionKeys.ADD_ESFADDRESS)%>'>
	<aui:button-row cssClass="esfAddress-admin-buttons">
		<portlet:renderURL var="addESFAddressURL"
			windowState="<%=WindowState.MAXIMIZED.toString()%>">
			<portlet:param name="mvcPath"
				value="/addressadmin/html/edit_esfAddress.jsp" />
			<portlet:param name="op" value="addAddr" />
		</portlet:renderURL>

		<aui:button onClick="<%= addESFAddressURL.toString() %>"
			value="Add Address" />
	</aui:button-row>
</c:if>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%=ESFAddressLocalServiceUtil.getESFAddresses(
					searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%= ESFAddressLocalServiceUtil.getESFAddressesCount() %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFAddress" modelVar="esfAddress">

		<portlet:renderURL var="viewESFAddress">
			<portlet:param name="mvcPath"
				value="/addressadmin/html/view_esfAddress.jsp" />
			<portlet:param name="esfAddressId"
				value="<%=String.valueOf(esfAddress.getEsfAddressId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="street1"
			href="<%=viewESFAddress%>" />

		<liferay-ui:search-container-column-text property="longitude"
			href="<%=viewESFAddress%>" />

		<liferay-ui:search-container-column-text property="latitude"
			href="<%=viewESFAddress%>" />

		<liferay-ui:search-container-column-text name="region"
			value="<%=ESFAddressLocalServiceUtil.getNameRegion(esfAddress.getEsfRegionId())%>"
			href="<%=viewESFAddress%>" />
		
		<input name="esfRegionId" type="hidden"
			value="<%=ESFAddressLocalServiceUtil.getNameRegion(esfAddress.getEsfRegionId())%>" />
		
		<liferay-ui:search-container-column-text name="province"
			value="<%=ESFAddressLocalServiceUtil.getNameProvince(
						esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId())%>"
			href="<%=viewESFAddress%>" />
		
		<input name="esfProvinceId" type="hidden"
			value="<%=ESFAddressLocalServiceUtil.getNameProvince(
						esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId())%>" />
		
		<liferay-ui:search-container-column-text name="city"
			value="<%=ESFAddressLocalServiceUtil.getNameCity(
						esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId(),
						esfAddress.getEsfCityId())%>"
			href="<%=viewESFAddress%>" />
		
		<input name="esfCityId" type="hidden"
			value="<%=ESFAddressLocalServiceUtil.getNameCity(
						esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId(),
						esfAddress.getEsfCityId())%>" />
		
		<liferay-ui:search-container-column-jsp
			path="/addressadmin/html/esfAddress_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
