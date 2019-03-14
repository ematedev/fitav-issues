<%@include file="init.jsp"%>



<c:if test='<%=  ESFSportAssociationModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFSPORTASSOCIATOIN_ADD)%>'>
	
		<aui:button-row cssClass="esfsportassociation-buttons">
		
			<portlet:renderURL var="addESFOrganizationURL">
				<portlet:param name="mvcPath" value='<%=templatePath + "edit_esforganization.jsp"%>' />
				<portlet:param name="op" value='addAddr' />
				<portlet:param name="ckisarmy" value='false' />
			</portlet:renderURL>
	
			<aui:button onClick="<%= addESFOrganizationURL.toString() %>" value="add-association" />
		</aui:button-row>
		
		
		<aui:button-row cssClass="esfsportassociation-buttons">
		
			<portlet:renderURL var="addESFOrganizationURL">
				<portlet:param name="mvcPath" value='<%=templatePath + "edit_esforganization.jsp"%>' />
				<portlet:param name="op" value='addAddr' />
				<portlet:param name="ckisarmy" value='true' />
			</portlet:renderURL>
	
			<aui:button onClick="<%= addESFOrganizationURL.toString() %>" value="ckisarmy" />
		</aui:button-row>

	</c:if>