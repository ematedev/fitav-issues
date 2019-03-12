<%@include file="init.jsp"%>

<%
	int numberOfPhones = 3;

	String[] _CATEGORY_NAMES = new String[] { "Main" };
	String[][] categorySections = new String[][] { { "delegationdetails", "delegationaddresses", "phones" } };
	
	
	boolean showBottons = false;
			
	if(esfOrganizationId > 0){
		showBottons = ESFOrganizationPermission.contains(permissionChecker, esfOrganizationId, ActionKeys.ESFORGANIZATIONADMIN_UPDATE_INFO); 
	}else{
		showBottons = ESFOrganizationModelPermission.contains(permissionChecker, group.getGroupId(), ActionKeys.ESFORGANIZATIONADMIN_ADD); 
	}
		
			
	
%>

	<portlet:actionURL name="editESFOrganization"  var="editESFOrganizationURL">
		<portlet:param name="esfOrganizationId" value="<%=String.valueOf(esfOrganizationId)%>" />
		<portlet:param name="isSimplyOrganizzation" value="false" />
	</portlet:actionURL>
	
	<div class="fitav-navigator">
		<aui:form action="<%=editESFOrganizationURL.toString()%>" name="fmd">
	
			<%
				request.setAttribute("addresses.className", Organization.class.getName());
				request.setAttribute("addresses.classPK", esfOrganizationId);
				request.setAttribute("emailAddresses.className", ESFOrganization.class.getName());
				request.setAttribute("emailAddresses.classPK", esfOrganizationId);
				request.setAttribute("phones.className", Organization.class.getName());
				request.setAttribute("phones.classPK", esfOrganizationId);
				request.setAttribute("phones.number", numberOfPhones);
				request.setAttribute("websites.className", ESFOrganization.class.getName());
				request.setAttribute("websites.classPK", esfOrganizationId);
				request.setAttribute("websites.classPK", esfOrganizationId);				
			%>
	
			<liferay-ui:form-navigator backURL="<%=viewURL%>"
				categoryNames="<%=_CATEGORY_NAMES%>"
				categorySections="<%=categorySections%>" formName="fmd"
				jspPath='<%=templatePath + "navigation/"%>' 
				showButtons="<%=showBottons %>"
				/>
				
				
				<aui:button-row cssClass="esforganization-admin-buttons">
			
					<aui:button onClick="<%= viewURL.toString() %>"	value='cancel'  />
				
				</aui:button-row>
				
		</aui:form>
	</div>
