<%@include file="init.jsp" %>
<% 
	String path = "/html/esfnationalmatch/edit_esfDeparture.jsp";
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	esfMatchId = ParamUtil.getLong(renderRequest, "esfMatchId");
	String code = ParamUtil.getString(renderRequest, "code");
	long esfDepartureId = ParamUtil.getLong(request, "esfDepartureId"); 
	

%>

<portlet:actionURL name="addESFAirportNow" var="addESFAirportNow">
	<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" />
	<portlet:param name="mvcPath" value="<%=path %>" />
	<portlet:param name="esfDepartureId"
		value="<%=String.valueOf(esfDepartureId)%>" />
</portlet:actionURL>

<portlet:renderURL var="addESFDepartureURL">
	<portlet:param name="mvcPath"
		value="/html/esfnationalmatch/edit_esfDeparture.jsp" />
	<portlet:param name="esfMatchId"
		value="<%=String.valueOf(esfMatchId)%>" />
	<portlet:param name="esfDepartureId"
		value="<%=String.valueOf(esfDepartureId)%>" />
</portlet:renderURL>
<aui:form action="<%= addESFAirportNow %>" name="addESFAirport">
			
			<aui:input id="name" label="airport" name="name" type="text"  required="true" />
			<aui:input id="city" name="city" type="text" required="true"/>
			<aui:input id="country" name="country"  type="text" required="true"/>
			<aui:button-row>
				<aui:button id="submit" name="submit" type="submit"></aui:button>
				<aui:button type="cancel" onClick="<%= addESFDepartureURL.toString() %>"></aui:button>
			</aui:button-row>
</aui:form>
