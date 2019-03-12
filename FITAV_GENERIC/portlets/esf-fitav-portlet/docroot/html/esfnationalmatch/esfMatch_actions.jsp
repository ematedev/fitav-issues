<%@include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	
	ESFMatch esfMatchRow = (ESFMatch) row.getObject();
	renderRequest.setAttribute("esfMatchRow",esfMatchRow);
	
	boolean olimpicMatch = 
		GetterUtil.getBoolean(
			portletPreferences.getValue(
				"olimpicMatch", StringPool.TRUE));

	boolean nationalMatch = 
		GetterUtil.getBoolean(
			portletPreferences.getValue(
				"nationalMatch", StringPool.TRUE));

	boolean event = 
		GetterUtil.getBoolean(
			portletPreferences.getValue(
				"event", StringPool.TRUE));	

	String value="view";
	%>


<liferay-ui:icon-menu >

	<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_UPLOAD_FILE) %>">
		<portlet:renderURL var="uploadURL" >
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "uploadFileNationalMatch.jsp"%>' />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>
		<liferay-ui:icon image="<%= value %>" message="upload-file"
			url="<%=uploadURL.toString()%>" />
	</c:if>
	
	<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_VIEW_MATCH) %>">
			
		<portlet:renderURL var="editURL" >
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			<portlet:param name="associationId"
				value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "new_edit_esfMatch.jsp"%>' />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>
								
		<liferay-ui:icon image="<%= value %>" message="<%= value %>"
			url="<%=editURL.toString()%>" />
	</c:if>

	<%if(olimpicMatch || nationalMatch){ %>
	
		<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">
			<portlet:renderURL var="editStaffURL">
				<portlet:param name="organizationId"
					value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
				<portlet:param name="associationId"
					value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
				<portlet:param name="mvcPath"
					value='<%=templatePath + "edit_staff.jsp"%>' />
				<portlet:param name="op" value="updAddr" />
			</portlet:renderURL>
								
			<liferay-ui:icon image="edit" message="staff" url="<%=editStaffURL.toString()%>" />
		</c:if>
			
		
		<%} 
		
		if(olimpicMatch){ %>

			<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">
				<portlet:renderURL var="editAzzurriURL">
					<portlet:param name="organizationId"
						value="<%=String.valueOf(currentOrganizationId)%>" />
					<portlet:param name="esfMatchId"
						value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
					<portlet:param name="associationId"
						value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
					<portlet:param name="mvcPath"
						value='<%=templatePath + "edit_azzurri.jsp"%>' />
					<portlet:param name="op" value="updAddr" />
				</portlet:renderURL>
	
				<liferay-ui:icon image="edit" message="Azzurri" url="<%=editAzzurriURL.toString()%>" />
			</c:if>
		<%
		}
		if(nationalMatch || event){ 
		%>
			<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">
				<portlet:renderURL var="editShooterURL">
					<portlet:param name="organizationId"
						value="<%=String.valueOf(currentOrganizationId)%>" />
					<portlet:param name="esfMatchId"
						value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
					<portlet:param name="associationId"
						value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
					<portlet:param name="mvcPath"
						value='<%=templatePath + "edit_esfShooter.jsp"%>' />
					<portlet:param name="op" value="updAddr" />
				</portlet:renderURL>
	
	
				<liferay-ui:icon image="edit" message="shooters"
					url="<%=editShooterURL.toString()%>" />
			</c:if>
		<%}%>

		<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">
			<portlet:renderURL var="managemetURL">
				<portlet:param name="organizationId"
					value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
				<portlet:param name="associationId"
					value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
				<portlet:param name="mvcPath"
					value='<%=templatePath + "management_esfMatch.jsp"%>' />
				<portlet:param name="op" value="updAddr" />
			</portlet:renderURL>
			<liferay-ui:icon image="edit" message="management-match"
				url="<%=managemetURL.toString()%>" />
		</c:if>
<!--  
			<portlet:renderURL var="addResultURL">
				<portlet:param name="organizationId"
					value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
				<portlet:param name="associationId"
					value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
				<portlet:param name="mvcPath"
					value='<%=templatePath + "edit_esfAddResult.jsp"%>' />
				<portlet:param name="op" value="updAddr" />
			</portlet:renderURL>
	
			<liferay-ui:icon image="edit" message="add-result"
				url="<%=addResultURL.toString()%>" />
-->
		<%
		
		if(olimpicMatch){ %>
		<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">
			<portlet:renderURL var="newAddResultURL">
				<portlet:param name="organizationId"
					value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
				<portlet:param name="associationId"
					value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
				<portlet:param name="mvcPath"
					value='<%=templatePath + "addResult.jsp"%>' />
				<portlet:param name="op" value="updAddr" />
			</portlet:renderURL>
	
			<liferay-ui:icon image="edit" message="add-result"
				url="<%=newAddResultURL.toString()%>" />
		</c:if>
		
		<%} 
		
		if((isNational || event) && ! olimpicMatch){%>
		<c:if test="<%= ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(), ActionKeys.ESFNATIONALMATCH_EDIT_NATIONAL_SHOOTER_ADD) %>">
			<portlet:renderURL var="NationalAddResultURL">
				<portlet:param name="organizationId"
					value="<%=String.valueOf(currentOrganizationId)%>" />
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
				<portlet:param name="associationId"
					value="<%=String.valueOf(esfMatchRow.getEsfAssociationId())%>" />
				<portlet:param name="mvcPath"
					value='<%=templatePath + "addNationalResult.jsp"%>' />
				<portlet:param name="op" value="updAddr" />
			</portlet:renderURL>
	
			<liferay-ui:icon image="edit" message="add-result"
				url="<%=NationalAddResultURL.toString()%>" />
		</c:if>
				
		<%}%>

	<c:if
			test="<%=ESFNationalMatchPermission.contains(permissionChecker,esfMatchRow.getEsfMatchId(),
							ActionKeys.ESFNATIONALMATCH_DELETE)%>">
		<portlet:actionURL name="deleteESFMatch" var="deleteURL">
				<portlet:param name="esfMatchId"
					value="<%=String.valueOf(esfMatchRow.getEsfMatchId())%>" />
			</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation='<%="delete_confirm" %>'/> 
	</c:if>
		
		<c:if
			test="<%=ESFNationalMatchPermission.contains(permissionChecker, esfMatchRow.getEsfMatchId(),
							ActionKeys.ESFNATIONALMATCH_GENERATE_DOCUEMNT)%>">

			<form name="form" id="form">
				<aui:button icon="icon-list-alt" value="Albo d'oro" onClick='<%="printResults("+esfMatchRow.getEsfMatchId()+")"%>'/>
			</form>
		
		</c:if> 

</liferay-ui:icon-menu>

<aui:script use="node,aui-io-request,node-event-simulate,liferay-portlet-url">

Liferay.provide(window,'printResults',function(matchId){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('esfMatchId', matchId);
	resourceURL.setParameter('genrateMatchReport', "ok");
	resourceURL.setParameter('printResults', true);
	
	window.open(resourceURL.toString());
});

</aui:script>