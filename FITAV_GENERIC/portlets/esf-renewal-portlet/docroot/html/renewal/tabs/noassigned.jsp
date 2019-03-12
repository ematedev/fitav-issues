<%@page import="com.ethica.esf.util.ESFKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@page import="com.ethica.esf.util.EsfActionKeys"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%><%@
page import="java.util.ArrayList"%><%@
page import="java.util.List"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<% 
	String esfUserIdsString = ParamUtil.getString(request, "esfUserIds");
	
	String esfUserIdsWithoutBrackets = "";
	
	for(int i = 0; i < esfUserIdsString.length(); i ++){
		char charIndex = esfUserIdsString.charAt(i);
		if(charIndex != '[' && charIndex != ']' && charIndex != ' '){
			esfUserIdsWithoutBrackets += charIndex;
		}
	}
	
	esfUserIdsWithoutBrackets += ','; 
	
	List<Long> userIds = new ArrayList<Long>();
	
	int firstIndex = 0;
	for(int j = 0; j < esfUserIdsWithoutBrackets.length(); j++){
		if(esfUserIdsWithoutBrackets.charAt(j) == ','){
			if(!esfUserIdsWithoutBrackets.substring(firstIndex, j).equals("")){
				userIds.add(Long.valueOf(esfUserIdsWithoutBrackets.substring(firstIndex, j)));
				if(Validator.isNotNull(firstIndex) && Validator.isNotNull(j)){
					firstIndex = j + 1;
				}
			}	
		}
	}
	
	portletURL.setParameter("esfUserIds", String.valueOf(esfUserIdsString));
	
%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "renewal_form.jsp"%>'></portlet:param>
</portlet:renderURL>

<c:if
	test='<%=permissionChecker.hasPermission(
			scopeGroupId,"it.ethica.esf.model",
			scopeGroupId,EsfActionKeys.ADD_ESFUSER)%>'>

</c:if>

<portlet:actionURL name="updateAddESFUserESFRole"
	var="updateAddESFUserESFRoleVar" />

<aui:form action="<%=updateAddESFUserESFRoleVar%>"
	name="<portlet:namespace />fm">

	<aui:button-row>
		<aui:button type="submit" value="Associa"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-results"  iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
			List<ESFUser> allEsfUser =
							ESFUserLocalServiceUtil.findAllShootersByLeafOrg(
								currentOrganizationId,
								ESFKeys.ESFStateType.ENABLE,
								ESFKeys.ESFStateType.ENABLE,
								searchContainer.getStart(),
								searchContainer.getEnd());

						int totalEsfUser =
							ESFUserLocalServiceUtil.findAllShootersByLeafOrg(
								currentOrganizationId,
								ESFKeys.ESFStateType.ENABLE,
								ESFKeys.ESFStateType.ENABLE).size();

						pageContext.setAttribute("results", allEsfUser);
						pageContext.setAttribute("total", totalEsfUser);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			<%//finder con idorganization in pi�
			ESFUserESFUserRole esfUserESFUserRole = null;
						esfUserESFUserRole =
							ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByU_R_O(
								esfUser.getEsfUserId(), esfUserRoleId, esfOrganizationId);
			%>
			
			<% 
			if(esfUserESFUserRole == null){
			%>
				<liferay-ui:search-container-column-text>
				<%
					boolean disabled = true;
					if(!userIds.contains(esfUser.getEsfUserId())){
						disabled = false;
					}
				
				%>
					<aui:input name="choose" label="" type="checkbox"
						id='<%="choose_" + esfUser.getEsfUserId()%>' disabled = "<%=disabled%>">
					</aui:input>
	
					<aui:input type="hidden" name="esfUserIds"
						id='<%="esfUserIds_" + esfUser.getEsfUserId()%>'
						value='<%=esfUser.getEsfUserId()%>' />
				
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text property="lastName" name="last-name"/>
				
				<liferay-ui:search-container-column-text property="firstName" name="first-name"/>
	
				<liferay-ui:search-container-column-text property="userEmail" name="user-email"/>
			<% 
			}
			%>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<aui:input type="hidden" name="type"
		value='NA' />
	<aui:input type="hidden" name="esfUserRoleId"
		value='<%= esfUserRoleId%>' />
	<aui:input type="hidden" name="esfOrganizationId"
		value='<%= esfOrganizationId%>' />
</aui:form>