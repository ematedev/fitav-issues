<%@include file="/stateadmin/init.jsp"%>


<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/stateadmin/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%= viewURL %>" title="esfState" />

<%
	long esfStateId = ParamUtil.getLong(renderRequest, "esfStateId");
	ESFState esfState = ESFStateLocalServiceUtil.getESFState(esfStateId);
	esfState = esfState.toEscapedModel();
	
	String currentURL = PortalUtil.getCurrentURL(request);

%>

<dl>
	<dt>Nome</dt>
	<dd><%= esfState.getEsfName()%></dd>
	<dt>Descrizione</dt>
	<dd><%= esfState.getEsfDescription() %></dd>
</dl>