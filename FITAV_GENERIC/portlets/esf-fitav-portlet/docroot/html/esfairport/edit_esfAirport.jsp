<%@ include file="init.jsp" %>
<portlet:actionURL name="addESFAirport" var="addESFAirport">
</portlet:actionURL>

<aui:form action="<%= addESFAirport %>" name="addESFAirport">
			
			<aui:input name="name" type="text"  required="true" />
			<aui:input name="city" type="text" required="true"/>
			<aui:input name="country"  type="text" required="true"/>
			<aui:button-row>
				<aui:button type="submit"></aui:button>
				<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
			</aui:button-row>
</aui:form>