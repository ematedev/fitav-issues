<%@include file="/cardadmin/init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/cardadmin/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%= viewURL %>" title="esfCard" />

<%
	long esfCardId= ParamUtil.getLong(renderRequest, "esfCardId");
	ESFCard esfCard = ESFCardLocalServiceUtil.getESFCard(esfCardId);
	esfCard  = esfCard.toEscapedModel();

	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
		ESFCard.class.getName(), esfCard.getEsfCardId());
	
	String currentURL = PortalUtil.getCurrentURL(request);

%>

<dl>
	<dt>Codice</dt>
	<dd><%= esfCard.getCode() %></dd>
	<dt>Start Date</dt>
	<dd><%=ConvertDateCal.DateToString(esfCard.getStartDate())%></dd>
	<dt>End Date</dt>
	<dd><%=ConvertDateCal.DateToString(esfCard.getEndDate())%></dd>
</dl>