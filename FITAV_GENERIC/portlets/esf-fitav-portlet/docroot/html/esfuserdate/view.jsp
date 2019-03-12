<%@page import="it.ethica.esf.util.PropertiesServiceRead"%>
<%@page import="it.ethica.esf.util.PropertiesServiceFactory"%>
<%@page import="it.ethica.esf.util.PropertiesServiceFactory"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@include file="init.jsp"%>

<% 
PropertiesServiceRead propertiesServiceReadStartDate =(PropertiesServiceRead) PropertiesServiceFactory.getInstance("userDate.properties","startDate");
PropertiesServiceRead propertiesServiceReadEndDate =(PropertiesServiceRead) PropertiesServiceFactory.getInstance("userDate.properties","endDate"); %>

<aui:button-row>
		<portlet:renderURL var="editESFUserDateURL">
			<portlet:param name="mvcPath"
				value="/html/esfuserdate/edit.jsp" />
			</portlet:renderURL>
		<aui:button onClick="<%= editESFUserDateURL.toString() %>"
			value="Aggiorna Data" />
</aui:button-row>

<table class="table">
<thead>
	<tr>
		<th>StartDate</th>
		<th>EndDate</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td><%=propertiesServiceReadStartDate.toString()%></td>
		<td><%=propertiesServiceReadEndDate.toString()%></td>
	</tr>
</tbody>
</table>