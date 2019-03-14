<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletParameterUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.bi.rules.Query"%>
<%@page import="it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@include file="init.jsp"%>

<portlet:actionURL var="uploadAffiliationURL" name="uploadAffiliation">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'/>
</portlet:actionURL>

<portlet:defineObjects />
	<portlet:resourceURL var='actResourceURL' id='actResource' escapeXml="false" >
</portlet:resourceURL>

<h4><b><liferay-ui:message key="upload-file" /></b>
				

				
<aui:form action="<%= uploadAffiliationURL %>"  method="post" enctype="multipart/form-data" name="fm">
	<aui:input name="creditDate" type="text" label="creditDate" inlineField="true">
				<aui:validator name="required" />
			 </aui:input>
	<aui:input type="file" name="fileName" size="75"/>
	<input name = "submitFile" type="submit" />
</aui:form>
<div class="separator"></div>
<%
int errorLine= 0;
if(Validator.isNotNull(renderRequest.getParameter("numberLineError")) && 0 < Integer.valueOf(renderRequest.getParameter("numberLineError"))){
	errorLine = Integer.valueOf(renderRequest.getParameter("numberLineError"));
	String[] lineNumber = {String.valueOf(errorLine)};
%>
<h2><b><liferay-ui:message key="error-Shooter-Affiliation-x" arguments="<%= lineNumber%>"/></b></h2>
<%
}

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = "";
currDate = ManageDate.CalendarToString(calendar);

String affiliationDate = ParamUtil.getString(request, "affiliationDate",currDate);

PortletURL viewassURL = renderResponse.createRenderURL();
viewassURL.setParameter("mvcPath", templatePath+"view.jsp");
viewassURL.setParameter("affiliationDate",String.valueOf(affiliationDate) );

%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		<span class="aui-search-bar"> 
			<aui:input name="affiliationDate" type="text" label="insertData" inlineField="true"/>
			<aui:button type="submit" value="search" />
			<aui:button  value='SummaryShooterReport' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"AffiliationShooterReport();" %>' inlineField="true"/>
			<aui:button  value='SummaryShooterReportYear' onclick='<%="event.preventDefault();"+renderResponse.getNamespace()+"AffiliationShooterReportYear();" %>' inlineField="true" />
		</span>
</aui:form>

<h4><b><liferay-ui:message key="SummaryShooterReport" /></b>
				<div class="separator"></div>
				
<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL%>" >
	<liferay-ui:search-container-results
		results = "<%=ESFShooterAffiliationChronoLocalServiceUtil.findChronobyDate(affiliationDate,searchContainer.getStart(), searchContainer.getEnd())%>"
		total = "<%= ESFShooterAffiliationChronoLocalServiceUtil.countChronoByDate(affiliationDate) %>"/>
		
			<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFShooterAffiliationChrono" modelVar="chrono">
					
<%

ESFUser shooter = new ESFUserImpl();
String shooterName = "";
if(0 < chrono.getEsfuserId() && Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(chrono.getEsfuserId()))){
	shooter = ESFUserLocalServiceUtil.fetchESFUser(chrono.getEsfuserId());
	
	shooterName = shooter.getFirstName();
	shooterName = shooterName +" "+shooter.getLastName();
	
}

%>
					<liferay-ui:search-container-column-text name="shooterName" value="<%=shooterName%>" />
					<liferay-ui:search-container-column-text name="date" value="<%=sdf.format(chrono.getAffiliationDate()) %>" />
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	

</liferay-ui:search-container>

<aui:script use="aui-base,node,aui-io-request,node-event-simulate,liferay-portlet-url">
$(function() {
	$("#<portlet:namespace/>affiliationDate").datepicker();
	$("#<portlet:namespace/>affiliationDate").datepicker("option", "dateFormat",
			"dd/mm/yy");
	$("#<portlet:namespace/>affiliationDate").datepicker("setDate",
			'<%= currDate %>');
});

Liferay.provide(window,'<portlet:namespace/>AffiliationShooterReport',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generateAffiliationShooterReport = true;
	var affiliationDate = A.one('#<portlet:namespace/>affiliationDate').val();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generateAffiliationShooterReport', generateAffiliationShooterReport);
	resourceURL.setParameter('affiliationDate', affiliationDate);

	window.open(resourceURL.toString());
});

Liferay.provide(window,'<portlet:namespace/>AffiliationShooterReportYear',function(){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	var generateAffiliationShooterReportYear = true;
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('generateAffiliationShooterReportYear', generateAffiliationShooterReportYear);

	window.open(resourceURL.toString());
});
</aui:script>