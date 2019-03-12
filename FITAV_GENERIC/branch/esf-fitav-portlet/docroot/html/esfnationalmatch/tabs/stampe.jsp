
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

<aui:form action="<%=generateDocumentsURL%>">

	<aui:input type = "checkbox" name = "generatePasses" label = "generate-pass" />
	<aui:input type = "checkbox" name = "generateLicences" label = "generate-licence" />
	<aui:input type = "checkbox" name = "generateconvocations" label = "generate-convocations" />
	<aui:input type = "checkbox" name = "convocations" label = "send-emails-for-convocations" />
	
	<aui:input type="radio" label="pre-view" name="pre-view" checked="true" value="true" />
	<aui:input type="radio" label="generate-document" name="pre-view" value="false" />
	
	<aui:button name = "submit" type="submit" value='<%=res.getString("generate-docs") %>'>
	</aui:button>
	<aui:button onClick="<%= backURL.toString() %>" value="go-back" />
	<aui:button value='<%=res.getString("generate-docs") %>' onclick="ajaxCall()"/>
</aui:form>


<aui:script use="liferay-portlet-url">

Liferay.provide(window,'ajaxCall',function(){
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('genrateMatchReport', "ok");
	resourceURL.setParameter('esfMatchId', "<%=esfMatchId%>");
	resourceURL.setParameter('generatePasses', A.one('#<portlet:namespace/>generatePasses').val());
	resourceURL.setParameter('generateLicences', A.one('#<portlet:namespace/>generateLicences').val());
	resourceURL.setParameter('generateconvocations', A.one('#<portlet:namespace/>generateconvocations').val());
	resourceURL.setParameter('convocations', A.one('#<portlet:namespace/>convocations').val());
	resourceURL.setParameter('pre-view', A.one('[name="<portlet:namespace/>pre-view"]:checked').val());
	
	window.open(resourceURL.toString());
});

</aui:script>


