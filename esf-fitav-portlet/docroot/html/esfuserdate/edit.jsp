<%@page import="it.ethica.esf.util.PropertiesServiceRead"%>
<%@page import="it.ethica.esf.util.PropertiesServiceFactory"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@include file="init.jsp"%>

<% 
PropertiesServiceRead propertiesServiceReadStartDate =(PropertiesServiceRead) PropertiesServiceFactory.getInstance("userDate.properties","startDate");
PropertiesServiceRead propertiesServiceReadEndDate =(PropertiesServiceRead) PropertiesServiceFactory.getInstance("userDate.properties","endDate");
String startDate = propertiesServiceReadStartDate.toString();
String endDate = propertiesServiceReadEndDate.toString();
%>

<portlet:renderURL var="viewEditDateURL">
    <portlet:param name="mvcPath" value="/html/esfuserdate/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="editDate" var="editDateURL"></portlet:actionURL>

<aui:form action="<%= editDateURL %>" name="<portlet:namespace />fm">

        <aui:fieldset>
			<aui:input name="startDate" type="text" label="startDate" value="<%=startDate %>">
				<aui:validator name="required" errorMessage=""></aui:validator>
			</aui:input>
			
			<aui:input name="endDate" type="text" label="endDate" value="<%=endDate %>">
				<aui:validator name="required" errorMessage=""></aui:validator>
			</aui:input>
			
        </aui:fieldset>
        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewEditDateURL.toString() %>"></aui:button>
        </aui:button-row>
</aui:form>
			
<aui:script use='aui-datepicker,aui-form-validator'>
               var startDatePicker = new A.DatePicker({
                              trigger: '#<portlet:namespace />birthday',
                              popover: {
                                 zIndex: 100
                              },
                              popoverCssClass: 'fast-quotation-date-picker',
                              mask:'%d/%m/%Y'
               });
</aui:script>