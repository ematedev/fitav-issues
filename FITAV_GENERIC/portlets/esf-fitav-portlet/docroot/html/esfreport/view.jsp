<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="init.jsp"%>


<%

String tabs = "Associazioni,Stand e Specialità,Consiglio Direttivo,Tiratori,Gare,Report Coni";

%>

<portlet:defineObjects />
	<portlet:resourceURL var='actResourceURL' id='actResource' escapeXml="false" >
</portlet:resourceURL>

<portlet:renderURL var="tabURL" />

<liferay-ui:tabs names="<%=tabs%>" url="<%=tabURL.toString()%>" param="myParam" refresh="false">

	<liferay-ui:section>
		<jsp:include page="tabs/association.jsp" flush="true" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="tabs/standAndService.jsp" flush="true" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="tabs/bdo.jsp" flush="true" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="tabs/shooter.jsp" flush="true" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="tabs/match.jsp" flush="true" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="tabs/reportConi.jsp" flush="true" />
	</liferay-ui:section>

</liferay-ui:tabs>
