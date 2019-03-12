<%@include file="init.jsp"%>
<h3>Scegli il tipo di viaggio</h3>
<%
long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
String esfDepartureId = ParamUtil.getString(request, "esfDepartureId");
renderRequest.setAttribute("esfDepartureId", esfDepartureId);
%>
<portlet:renderURL var="addESFDepartureURL">
	<portlet:param name="mvcPath"
		value="/html/esfnationalmatch/edit_esfDeparture.jsp" />
	<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" />
</portlet:renderURL>
<portlet:renderURL var="addESFDepartureURLB">
	<portlet:param name="mvcPath"
		value="/html/esfnationalmatch/edit_esfDepartureB.jsp" />
	<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" />
</portlet:renderURL>
<aui:button name="airplane" value="airplane" onClick="<%= addESFDepartureURL.toString()%>" />
<aui:button name="bus" value="bus" onClick="<%= addESFDepartureURLB.toString()%>"/>