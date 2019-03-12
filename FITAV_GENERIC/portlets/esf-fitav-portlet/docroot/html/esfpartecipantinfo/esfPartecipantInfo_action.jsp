<%@page import="it.ethica.esf.model.ESFPartecipantInfo"%>
<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFPartecipantInfo esfPartecipantInfo = (ESFPartecipantInfo) row.getObject();
%>

<liferay-ui:icon-menu>
	
		<portlet:renderURL var="editURL" >
			<portlet:param name="esfPartecipantInfoId"
				value="<%= String.valueOf(esfPartecipantInfo.getEsfPartecipantInfoId())%>" />
			<portlet:param name="inserted"
				value="true" />	
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfPartecipantInfo.jsp"%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit"
			url="<%=editURL.toString()%>" />
			
		<portlet:actionURL var="downloadURL" name = "downloadPDF">
			<portlet:param name="esfPartecipantInfoId"
				value="<%= String.valueOf(esfPartecipantInfo.getEsfPartecipantInfoId())%>" />
		</portlet:actionURL>
		
		<liferay-ui:icon image="download" message="download-pdf"
			url="<%=downloadURL.toString()%>" />

</liferay-ui:icon-menu>