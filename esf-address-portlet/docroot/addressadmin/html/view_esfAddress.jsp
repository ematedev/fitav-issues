<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@include file="/addressadmin/init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/addressadmin/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%= viewURL %>" title="esfAddress" />

<%
	long esfAddressId = ParamUtil.getLong(renderRequest, "esfAddressId");
	ESFAddress esfAddress = ESFAddressLocalServiceUtil.getESFAddress(esfAddressId);
	esfAddress = esfAddress.toEscapedModel();
	
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
		ESFAddress.class.getName(), esfAddress.getEsfAddressId());
	
	String currentURL = PortalUtil.getCurrentURL(request);

%>

<dl>
	<dt>Street</dt>
	<dd><%= esfAddress.getStreet1() %></dd>
	<dt>Longitude</dt>
	<dd><%= esfAddress.getLongitude() %></dd>
	<dt>Latitude</dt>
	<dd><%= esfAddress.getLatitude() %></dd>
</dl>