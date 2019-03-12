<%portletURL.setParameter("tabs1", "Assegnati"); %>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view.jsp"%>'></portlet:param>
</portlet:renderURL>


<portlet:actionURL name="updateAddESFUserESFRole"
	var="updateAddESFUserESFRoleVar" />

<aui:form action="<%=updateAddESFUserESFRoleVar%>"
	name="<portlet:namespace />fma">

	<aui:button-row>
		<c:if test="<%= ESFBDOPermission.contains(permissionChecker,esfUserRoleId, ActionKeys.ESFBDO_UPDATE_REMOVE) %>">	
			<aui:button type="submit" value="Revoca Incarico" ></aui:button>
		</c:if>
		
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-results"  iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
				List<ESFUser> allEsfUser = 	ESFUserLocalServiceUtil.findAllUserByRolenoNull(
						esfUserRoleId, 
						esfOrganizationId);
				int totalEsfUser = ESFUserLocalServiceUtil.findAllUserByRolenoNull(
						esfUserRoleId, 
						esfOrganizationId).size();

				pageContext.setAttribute("results", allEsfUser);
				pageContext.setAttribute("total", totalEsfUser);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			<%
			
			String fiscalCode ="";
			if(Validator.isNotNull(esfUser.getFiscalCode())){
				fiscalCode = esfUser.getFiscalCode();
			}
			String fiscalCodeName = "fiscalCode"+esfUser.getEsfUserId();
			%>
			
			<portlet:renderURL var="changeFCURL">
					<portlet:param name="esfUserId"
						value="<%=String.valueOf(esfUser.getEsfUserId())%>" />
					<portlet:param name="backPage" value='<%= templatePath +"assignMembers_esfUserRole.jsp"%>' />
					<portlet:param name="tabs1" value='<%= "Assegnati"%>' />
					<portlet:param name="esfOrganizationId" value='<%= String.valueOf(esfOrganizationId)%>' />
					<portlet:param name="esfUserRoleId" value='<%= String.valueOf(esfUserRoleId)%>' />
					
					<portlet:param name="mvcPath" value='<%=templatePath +"changeFiscalcode.jsp"%>' />
			</portlet:renderURL>
			
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
				
				<liferay-ui:search-container-column-text  name="fiscalCode" >
					<div class="btn-field-align">
						<aui:input name="<%fiscalCodeName%>" value="<%= fiscalCode%>" label="" readonly="true" inlineField="true"></aui:input>
						
						<aui:button onClick="<%= changeFCURL.toString() %>" value="please-enter-correct-fiscalcode" />
					</div>
				</liferay-ui:search-container-column-text>

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