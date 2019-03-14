<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@page import="com.ethica.esf.util.EsfActionKeys"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%><%@
page import="java.util.ArrayList"%><%@
page import="java.util.List"%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "renewal_form.jsp"%>'></portlet:param>
</portlet:renderURL>

<c:if
	test='<%= permissionChecker.hasPermission(
			scopeGroupId,"it.ethica.esf.model",
			scopeGroupId,EsfActionKeys.ADD_ESFUSER)%>'>
</c:if>

<portlet:actionURL name="updateAddESFUserESFRole"
	var="updateAddESFUserESFRoleVar" />

<aui:form action="<%=updateAddESFUserESFRoleVar%>"
	name="<portlet:namespace />fm">

	<aui:button-row>
		<aui:button type="submit" value="Revoca Incarico" ></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-results"  iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
			/*	List<ESFUser> allEsfUser = ESFUserLocalServiceUtil
									.findAllShootersByLeafOrgAssigned(
											esfOrganizationId,
											ESFKeys.ESFStateType.ENABLE,
											esfUserRoleId,
											ESFKeys.ESFStateType.ENABLE,
											searchContainer.getStart(),
											searchContainer.getEnd());

							int totalEsfUser = ESFUserLocalServiceUtil
									.findAllShootersByLeafOrgAssigned(
											esfOrganizationId,
											ESFKeys.ESFStateType.ENABLE,
											esfUserRoleId,
											ESFKeys.ESFStateType.ENABLE).size();*/
											
				List<ESFUser> allEsfUser = 	ESFUserLocalServiceUtil.findAllUserByRolenoNull(esfUserRoleId, esfOrganizationId);
				int totalEsfUser = ESFUserLocalServiceUtil.findAllUserByRolenoNull(esfUserRoleId, esfOrganizationId).size();

							pageContext.setAttribute("results", allEsfUser);
							pageContext.setAttribute("total", totalEsfUser);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			
				<liferay-ui:search-container-column-text>

					<aui:input name="choose" label="" type="checkbox"
						id='<%="choose_" + esfUser.getEsfUserId()%>'>
					</aui:input>
	
					<aui:input type="hidden" name="esfUserIds"
						id='<%="esfUserIds_" + esfUser.getEsfUserId()%>'
						value='<%=esfUser.getEsfUserId()%>' />
				
				</liferay-ui:search-container-column-text>
	
				<liferay-ui:search-container-column-text property="lastName" name="last-name"/>
				
				<liferay-ui:search-container-column-text property="firstName" name="first-name"/>
	
				<liferay-ui:search-container-column-text property="userEmail" name="user-email"/>
			

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<aui:input type="hidden" name="type"
		value='A' />
	<aui:input type="hidden" name="esfUserRoleId"
		value='<%= esfUserRoleId%>' />
	<aui:input type="hidden" name="esfOrganizationId"
		value='<%= esfOrganizationId%>' />
</aui:form>