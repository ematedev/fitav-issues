<%@include file="init.jsp"%>
<%
String firstname = ParamUtil.getString(request, "firstname");
String lastname = ParamUtil.getString(request, "lastname");
long esfOrganizationIdA = ParamUtil.getLong(request, "esfOrganizationIdA");
long esfUserRoleIdA = ParamUtil.getLong(request, "esfUserRoleIdA");

PortletURL viewassURL = renderResponse.createRenderURL();
viewassURL.setParameter(
		"mvcPath", "/html/esfuserrole/assignMembers_esfUserRole/tabs/assigned.jsp");
	viewassURL.setParameter("firstname", firstname);
	viewassURL.setParameter("lastname", lastname);
	viewassURL.setParameter("esfOrganizationId",String.valueOf(esfOrganizationIdA) );
	viewassURL.setParameter("esfUserRoleId", String.valueOf(esfUserRoleIdA));
	
	System.out.println("firstname="+firstname);
	System.out.println("lastname="+lastname);
	System.out.println("esfUserRoleIdA="+esfUserRoleIdA);

%>

<portlet:renderURL var="viewURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "choose_organization.jsp"%>'></portlet:param>
	<portlet:param name="op" value="chooseorg" />
	<portlet:param name="organizationId"
		value="<%=String.valueOf(currentOrganizationId)%>" />
	<portlet:param name="esfUserRoleIdA"
		value="<%=String.valueOf(esfUserRoleIdA)%>" />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURLA">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view_searchA.jsp"%>' />
</liferay-portlet:renderURL>


<aui:form action="<%=searchURLA%>" method="get" name="fm">

	<liferay-portlet:renderURLParams varImpl="searchURLA" />
	<div class="search-form">
	
		<span class="aui-search-bar"> 
		
		<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries" type="text" />
		<aui:input inlineField="<%=true%>" label="" name="lastname"
				placeholder="last-name" size="30" title="search-entries" type="text" />
		<aui:input name="esfOrganizationIdA" type="hidden" value="<%=esfOrganizationIdA%>" /> 
		<aui:input name="esfUserRoleIdA" type="hidden" value="<%=esfUserRoleIdA%>" />
		<aui:button type="submit" value="search" />
		
		</span>
		
	</div>
	
</aui:form>

<portlet:renderURL var="backURL" windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%=templatePath%>'></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="updateAddESFUserESFRole"
	var="updateAddESFUserESFRoleVar" />

<aui:form action="<%=updateAddESFUserESFRoleVar%>"
	name="<portlet:namespace />fm">

	<aui:button-row>
		<aui:button type="submit" value="Dissocia"></aui:button>
		<aui:button type="cancel" onClick="<%= backURL %>"></aui:button>

	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%= viewassURL %>">
		<liferay-ui:search-container-results>
			<%
			List<ESFUser> allEsfUser =
				ESFUserLocalServiceUtil.findShooterRoleAssignedName(firstname, lastname,
						esfUserRoleIdA, esfOrganizationIdA,
					searchContainer.getStart(),  searchContainer.getEnd());

			int totalEsfUser =
				ESFUserLocalServiceUtil.countShooterRoleAssignedName(firstname, lastname,
						esfUserRoleIdA, esfOrganizationIdA);

			System.out.println("allEsfUser="+allEsfUser.size());
			System.out.println("totalEsfUser="+totalEsfUser);
			
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
								esfUser.getEsfUserId(), esfUserRoleIdA, esfOrganizationIdA);
			%>
			
			<% 
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
	
				<liferay-ui:search-container-column-text property="userEmail" name="user-email"/>
			<% 
			}
			%>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<aui:input type="hidden" name="type"
		value='A' />
	<aui:input type="hidden" name="esfUserRoleId"
		value='<%= esfUserRoleIdA%>' />
	<aui:input type="hidden" name="esfOrganizationId"
		value='<%= esfOrganizationIdA%>' />
</aui:form>