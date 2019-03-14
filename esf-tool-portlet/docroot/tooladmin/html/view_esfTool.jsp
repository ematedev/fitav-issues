<%@include file="/tooladmin/init.jsp"%>


<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/tooladmin/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%= viewURL %>" title="esfTool" />

<%
	long esfToolId = ParamUtil.getLong(renderRequest, "esfToolId");
	ESFTool esfTool = ESFToolLocalServiceUtil.getESFTool(esfToolId);
	esfTool = esfTool.toEscapedModel();
	
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
		ESFTool.class.getName(), esfTool.getEsfToolId());
	
	String currentURL = PortalUtil.getCurrentURL(request);

%>

<dl>
	<dt>Codice</dt>
	<dd><%= esfTool.getCode() %></dd>
	<dt>Nome</dt>
	<dd><%= esfTool.getName()%></dd>
	<dt>Descrizione</dt>
	<dd><%= esfTool.getDescription() %></dd>
</dl>