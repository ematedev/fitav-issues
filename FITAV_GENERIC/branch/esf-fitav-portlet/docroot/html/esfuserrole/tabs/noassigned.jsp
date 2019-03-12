<%-- <%@include file="/html/esfuserrole/init.jsp"%> --%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
String lastname = "";
String firstname = "";
%>

<portlet:renderURL var="viewURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "choose_organization.jsp"%>'></portlet:param>
	<portlet:param name="op" value="chooseorg" />
	<portlet:param name="organizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
	<portlet:param name="esfUserRoleId"
		value="<%=String.valueOf(esfUserRoleId)%>" />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURLNA">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view_searchNA.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">

	<liferay-portlet:renderURLParams varImpl="searchURLNA" />
	<div class="search-form">
	
		<span class="aui-search-bar"> 
		
		<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries" type="text" />
		<aui:input inlineField="<%=true%>" label="" name="lastname"
				placeholder="last-name" size="30" title="search-entries" type="text" />
		<aui:input name="esfOrganizationIdNA" type="hidden" value="<%=esfOrganizationId%>" /> 
		<aui:input name="esfUserRoleIdNA" type="hidden" value="<%=esfUserRoleId%>" />
		<aui:button type="submit" value="search" />
		
		</span>
		
	</div>
	
</aui:form>


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
							ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssignedName(firstname, lastname, esfOrganizationId,
								ESFKeys.ESFStateType.ENABLE, esfUserRoleId,  ESFKeys.ESFStateType.ENABLE,
								searchContainer.getStart(),
								searchContainer.getEnd());

						int totalEsfUser =
							ESFUserLocalServiceUtil.countAllShootersByLeafOrgAssignedName(firstname, lastname, esfOrganizationId,
									ESFKeys.ESFStateType.ENABLE, esfUserRoleId,  ESFKeys.ESFStateType.ENABLE);
						pageContext.setAttribute("results", allEsfUser);
						pageContext.setAttribute("total", totalEsfUser);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			<%
			ESFUserESFUserRole esfUserESFUserRole = null;
						esfUserESFUserRole =
							ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByU_R_O(
								esfUser.getEsfUserId(), esfUserRoleId ,  esfOrganizationId);
			String mail = "";
			if(Validator.isNotNull(esfUser.getUserEmail())){
				mail = esfUser.getUserEmail();
			}
			if(esfUserESFUserRole == null){
				
			%>
				<liferay-ui:search-container-column-text>
				
					<aui:input name="choose" label="" type="checkbox"
						id='<%="choose_" + esfUser.getEsfUserId()%>'>
					</aui:input>
	
					<aui:input type="hidden" name="esfUserIds"
						id='<%="esfUserIds_" + esfUser.getEsfUserId()%>'
						value='<%=esfUser.getEsfUserId()%>' />
				
				</liferay-ui:search-container-column-text>
	
				<liferay-ui:search-container-column-text property="firstName" name="first-name"/>
	
				<liferay-ui:search-container-column-text property="lastName" name="last-name"/>
	
				<liferay-ui:search-container-column-text property="screenName" name="screen-name"/>
	
				<liferay-ui:search-container-column-text name="user-email">
					<a href="mailto:<%=mail%>" target="_top"><p><%=mail%></p></a>
				</liferay-ui:search-container-column-text>
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