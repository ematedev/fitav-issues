<%@include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFNational esfUserRow = (ESFNational) row.getObject();
	String userID = request.getParameter("esfNational");
%>
<liferay-ui:icon-menu>

	<c:if
		test="<%=ESFNationalDelegationPermission.contains(permissionChecker, esfUserRow.getEsfUserId(),
							ActionKeys.ESFNATIONALDELEGATION_SHOOTER_VIEW)%>">

		<portlet:renderURL var="popupModifyURL">
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="backToGeneralUrl"
				value="<%=themeDisplay.getURLPortal() + themeDisplay.getURLCurrent()%>" />

			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfShooter.jsp"%>' />
			<portlet:param name="esfUserId"
				value='<%=String.valueOf(esfUserRow.getEsfUserId())%>' />
			<portlet:param name="op" value="updAddr" />
		</portlet:renderURL>


		<liferay-ui:icon image="edit" message="view"
			url="<%=popupModifyURL.toString()%>" />
	</c:if>

	<c:if
		test="<%=ESFNationalDelegationPermission.contains(permissionChecker, esfUserRow.getEsfUserId(),
							ActionKeys.ESFNATIONALDELEGATION_VIEW)%>">
		<portlet:renderURL var="popupURL2">
			<portlet:param name="mvcPath"
				value='<%=templatePath + "esfPopupModifyNational3.jsp"%>' />
			<portlet:param name="esfNational"
				value='<%=String.valueOf(esfUserRow.getEsfNationalId())%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="manage_nodes" message="Modify"
			url="<%=popupURL2.toString()%>" />
	</c:if>

	<c:if
		test="<%=ESFNationalDelegationPermission.contains(permissionChecker, esfUserRow.getEsfUserId(),
							ActionKeys.ESFNATIONALDELEGATION_UPDATE_START_END_DATE)%>">
		<portlet:renderURL var="popupURL3">

			<portlet:param name="mvcPath"
				value='<%=templatePath + "esfPopupModifyNational2.jsp"%>' />
			<portlet:param name="esfNational"
				value='<%=String.valueOf(esfUserRow.getEsfNationalId())%>' />
			<portlet:param name="startDate"
				value='<%=String.valueOf(esfUserRow.getStartDate())%>' />
			<portlet:param name="endDate"
				value='<%=String.valueOf(esfUserRow.getEndDate())%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="manage_nodes" message="Modify-startendDate"
			url="<%=popupURL3.toString()%>" />

	</c:if>

	<c:if
		test="<%=ESFNationalDelegationPermission.contains(permissionChecker, esfUserRow.getEsfUserId(),
							ActionKeys.ESFNATIONALDELEGATION_UPDATE_DELIBEDELIB_DATE)%>">
		<portlet:renderURL var="popupURLDelibEDelibDate">

			<portlet:param name="mvcPath"
				value='<%=templatePath + "esfPopupModifyDelibEDelibDate.jsp"%>' />
			<portlet:param name="esfNational"
				value='<%=String.valueOf(esfUserRow.getEsfNationalId())%>' />
			<portlet:param name="deliberate"
				value='<%=String.valueOf(esfUserRow.getDeliberate())%>' />
			<portlet:param name="delibDate"
				value='<%=String.valueOf(esfUserRow.getDeliberateDate())%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="manage_nodes" message="Modify-delibedelibDate"
			url="<%=popupURLDelibEDelibDate.toString()%>" />
	</c:if>
	
	<c:if
		test="<%=ESFNationalDelegationPermission.contains(permissionChecker, esfUserRow.getEsfUserId(),
							ActionKeys.ESFNATIONALDELEGATION_DELETE)%>">
		<portlet:actionURL name="deleteESFDelegation" var="deleteURL">
			<portlet:param name="esfUserId"
				value="<%=String.valueOf(esfUserRow.getEsfUserId())%>" />
			<portlet:param name="esfNationalId"
				value="<%=String.valueOf(esfUserRow.getEsfNationalId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" confirmation="delete_confirm"/>
	</c:if>
	
	<c:if
		test="<%=ESFNationalDelegationPermission.contains(permissionChecker, esfUserRow.getEsfUserId(),
							ActionKeys.ESFNATIONALDELEGATION_SHOOTER_VIEW)%>">

			<form name="form" id="form">
				<aui:button icon="icon-list-alt" value="curriculum" onClick='<%="generateCurriculum("+esfUserRow.getEsfUserId()+")"%>'/>
			</form>
		
	</c:if>
	
</liferay-ui:icon-menu>

<aui:script use="node,aui-io-request,node-event-simulate,liferay-portlet-url">

Liferay.provide(window,'generateCurriculum',function(esfUserId){
	
	var resourceURL = Liferay.PortletURL.createResourceURL();
	
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('userId', esfUserId);
	resourceURL.setParameter('generateCurriculum', true);
	
	window.open(resourceURL.toString());
});
</aui:script>
