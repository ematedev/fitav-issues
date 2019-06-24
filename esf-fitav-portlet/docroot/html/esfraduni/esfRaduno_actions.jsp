<%@include file="init.jsp"%>
<%
	String value="view";

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ESFRaduno raduno = (ESFRaduno) row.getObject();
	
	String idAssociazione = "";
	if (raduno.getId_associazione_ospitante()!=0)
		idAssociazione = String.valueOf(raduno.getId_associazione_ospitante());

%>
<portlet:renderURL var="uploadURL">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(raduno.getId_esf_raduno()) %>"/>	
	<portlet:param name="code" value="<%= raduno.getCodice() %>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/upload/uploadFileRaduno.jsp" />	
</portlet:renderURL>

<portlet:renderURL var="editAzzurriURL">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(raduno.getId_esf_raduno()) %>"/>	
	<portlet:param name="code" value="<%= raduno.getCodice() %>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/managementAzzurri.jsp" />	
</portlet:renderURL>

<portlet:renderURL var="editShooterURL">
</portlet:renderURL>

<portlet:renderURL var="editStaffURL">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(raduno.getId_esf_raduno()) %>"/>	
	<portlet:param name="code" value="<%= raduno.getCodice() %>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/managementStaff.jsp" />	
</portlet:renderURL>

<portlet:actionURL var="viewURL"  name="viewRaduno">
	<portlet:param name="idRaduno" value="<%= String.valueOf(raduno.getId_esf_raduno()) %>"/>	
	<portlet:param name="code" value="<%= raduno.getCodice() %>"/>	
	<portlet:param name="startDate" value="<%= ManageDate.DateToString(raduno.getData_inizio()) %>"/>	
	<portlet:param name="endDate" value="<%= ManageDate.DateToString(raduno.getData_fine()) %>"/>	
	<portlet:param name="idTipoRaduno" value="<%= String.valueOf(raduno.getTipo_raduno()) %>"/>	
	<portlet:param name="notes" value="<%= raduno.getNote() %>"/>	
	<portlet:param name="esfAssociationId" value="<%=idAssociazione%>"/>
	<portlet:param name="site" value="<%= raduno.getAltra_sede_ospitante() %>"/>	
</portlet:actionURL>

<portlet:renderURL var="managementURL">
	<portlet:param name="id_esf_raduno" value="<%= String.valueOf(raduno.getId_esf_raduno()) %>"/>	
	<portlet:param name="code" value="<%= raduno.getCodice() %>"/>	
	<portlet:param name="mvcPath" value="/html/esfraduni/managementRaduno.jsp" />	
</portlet:renderURL>

<portlet:actionURL var="deleteURL" name="deleteRaduno">
	<portlet:param name="idRaduno" value="<%= String.valueOf(raduno.getId_esf_raduno()) %>"/>	
</portlet:actionURL>	

<liferay-ui:icon-menu>
	<liferay-ui:icon image="<%= value %>" message="upload-file" url="<%=uploadURL.toString()%>" />
	<liferay-ui:icon image="<%= value %>" message="view" url="<%=viewURL.toString()%>" />
	<liferay-ui:icon image="edit" message="Azzurri" url="<%=editAzzurriURL.toString()%>" />
	<liferay-ui:icon image="edit" message="shooters" url="<%=editShooterURL.toString()%>" />
	<liferay-ui:icon image="edit" message="staff" url="<%=editStaffURL.toString()%>" />
	<liferay-ui:icon image="edit" message="management-raduno" url="<%=managementURL.toString()%>" />
	<liferay-ui:icon-delete image="delete" message="delete" url="<%=deleteURL.toString()%>" />
</liferay-ui:icon-menu>