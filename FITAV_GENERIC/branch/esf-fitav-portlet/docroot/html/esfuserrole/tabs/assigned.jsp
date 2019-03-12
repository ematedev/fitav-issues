<%-- <%@include file="/html/esfuserrole/init.jsp"%> --%>


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

<portlet:renderURL var="backURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view.jsp"%>'></portlet:param>

</portlet:renderURL>


<liferay-portlet:renderURL varImpl="searchURLA">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view_searchA.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">

	<liferay-portlet:renderURLParams varImpl="searchURLA" />
	<div class="search-form">
	
		<span class="aui-search-bar"> 

		<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries" type="text" />
		<aui:input inlineField="<%=true%>" label="" name="lastname"
				placeholder="last-name" size="30" title="search-entries" type="text" />
		<aui:input name="esfOrganizationIdA" type="hidden" value="<%=esfOrganizationId%>" /> 
		<aui:input name="esfUserRoleIdA" type="hidden" value="<%=esfUserRoleId%>" />
		<aui:button type="submit" value="search" />
		
		</span>
		
	</div>
	
</aui:form>

<portlet:actionURL name="updateAddESFUserESFRole"
	var="updateAddESFUserESFRoleVar" />

<aui:form action="<%=updateAddESFUserESFRoleVar%>"
	name="<portlet:namespace />fm">

	<aui:button-row>
		<aui:button type="submit" value="Dissocia"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		<aui:button type="cancel" onClick="<%= backURL %>" value="returnButton"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
			List<ESFUser> allEsfUser =
				ESFUserLocalServiceUtil.findShooterRoleAssignedName(firstname, lastname,
					esfUserRoleId, esfOrganizationId,
					searchContainer.getStart(),  searchContainer.getEnd());

			int totalEsfUser =
				ESFUserLocalServiceUtil.countShooterRoleAssignedName(firstname, lastname,
						esfUserRoleId, esfOrganizationId);

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
								esfUser.getEsfUserId(), esfUserRoleId, esfOrganizationId);

			String mail = "";
			if(Validator.isNotNull(esfUser.getUserEmail())){
				mail = esfUser.getUserEmail();
			}			
			if(esfUserESFUserRole != null){
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
				</liferay-ui:search-container-column-text>			<% 
			}
			%>

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