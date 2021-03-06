<%@page import="com.ethica.esf.permission.ESFUserRolePermission"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="com.ethica.esf.util.ESFKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row =
		(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	ESFUserRole esfUserRoleRow = (ESFUserRole) row.getObject();
	
	
	List<ESFUserRole> allESFUserRoles = ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(
											currentType, ESFKeys.ESFStateType.ENABLE, true);
	
	List<Long> esfUserIds = new ArrayList<Long>();
	for(ESFUserRole r : allESFUserRoles){
	
		List<ESFUserESFUserRole> esfUserESFUserRoles =
					ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
						currentOrganizationId, r.getEsfUserRoleId());

		String usersAssigned = "";
		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
				ESFUser esfUser =
					ESFUserLocalServiceUtil.fetchESFUser(esfUserESFUserRole.getEsfUserId());
				if(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getFirstName()) && Validator.isNotNull(esfUser.getLastName())){
					esfUserIds.add(esfUser.getEsfUserId());
				}
		}
	}
	
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%=ESFUserRolePermission.contains(
						permissionChecker, esfUserRoleRow.getEsfUserRoleId(),
						ActionKeys.UPDATE)%>">
		
		<portlet:renderURL var="membersURL">
			<portlet:param name="esfUserRoleId"
				value="<%=String.valueOf(esfUserRoleRow.getEsfUserRoleId())%>" />
			<portlet:param name="esfOrganizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />
			
			<portlet:param name="esfUserIds"
				value="<%=String.valueOf(esfUserIds)%>" />
			
			<portlet:param name="mvcPath"
				value='<%= templatePath + "assignMembers_esfUserRole.jsp"%>'/>
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" message="assign-members"
			url="<%=membersURL.toString()%>" />

<%-- 		<liferay-ui:icon image="edit" message="Define Permission" --%>
<%-- 			url="<%=urlPermission.toString()%>" /> --%>
		
	</c:if>
	
</liferay-ui:icon-menu>