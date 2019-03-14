
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@include file="../init.jsp"%>

<%long esfMatchId = ParamUtil.getLong(request, "esfMatchId");  %>

<portlet:renderURL var="backURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>'></portlet:param>
	<portlet:param name="organizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
</portlet:renderURL>

<portlet:actionURL name="generateDocumets" var="generateDocumentsURL">
	<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId) %>"/>
</portlet:actionURL>


	<aui:input type = "checkbox" name = "convocations" label = "send-emails-for-convocations" />
	
	<aui:input type="radio" label="pre-view" name="pre-view" checked="true" value="true" />
	<aui:input type="radio" label="generate-document" name="pre-view" value="false" />
<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_GENERATE_DOCUEMNT) %>">	
	<aui:button value='<%=res.getString("generatePasses") %>' onclick="generatePasses()"/>
	<aui:button value='<%=res.getString("generateLicences") %>' onclick="generateLicences()"/>
	<aui:button value='<%=res.getString("generateconvocations") %>' onclick="generateconvocations()"/>
</c:if>	
	<aui:button onClick="<%= backURL.toString() %>" value="go-back" />
	



<aui:script use="liferay-portlet-url">

Liferay.provide(window,'generatePasses',function(){
	
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateMatchReport', "ok");
	resourceURL.setParameter('esfMatchId', "<%=esfMatchId%>");
	resourceURL.setParameter('generatePasses', true);
	
	window.open(resourceURL.toString());
});

Liferay.provide(window,'generateconvocations',function(){
	
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateMatchReport', "ok");
	resourceURL.setParameter('esfMatchId', "<%=esfMatchId%>");
	resourceURL.setParameter('generateconvocations', true);
	
	
	window.open(resourceURL.toString());
});

Liferay.provide(window,'generateLicences',function(){
	
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateMatchReport', "ok");
	resourceURL.setParameter('esfMatchId', "<%=esfMatchId%>");
	resourceURL.setParameter('generateLicences', true);
	
	window.open(resourceURL.toString());
});
</aui:script>


