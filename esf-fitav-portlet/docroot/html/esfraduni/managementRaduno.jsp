<%@ include file="init.jsp"%>

<%
	long id_esf_raduno = ParamUtil.getLong(request, "id_esf_raduno"); 

	PortletURL tabURL = renderResponse.createRenderURL();
	String tab = ParamUtil.getString(request, "myParam", "Generale");
	tabURL.setParameter("mvcPath", "/html/esfraduni/managementRaduno.jsp");
	tabURL.setParameter("tab", tab);
	tabURL.setParameter("id_esf_raduno", String.valueOf(id_esf_raduno));	

%>

<portlet:actionURL var="backURL" name="backToSearch" />

<liferay-ui:tabs
		names="Generale,Itinerari,Stampe"
		url="<%=tabURL.toString()%>" param="myParam" refresh="true">

	<c:if test='<%=tab.equalsIgnoreCase("Generale")%>'>
		<jsp:include page="tabs/general.jsp" flush="true" />
	</c:if>
	
	<c:if test='<%=tab.equalsIgnoreCase("Itinerari")%>'>
		<jsp:include page="tabs/itinerari.jsp" flush="true" />
	</c:if>
	
	<c:if test='<%=tab.equalsIgnoreCase("Stampe")%>'>
		<jsp:include page="tabs/stampe.jsp" flush="true" />
	</c:if>
	
</liferay-ui:tabs>

<aui:button-row>
	<aui:button type="cancel" onClick='<%= backURL.toString() %>'></aui:button>
</aui:button-row>
