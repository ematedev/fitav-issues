<%@include file="init.jsp"%>
<liferay-ui:success key="user-success-insertupdate"
	message="user-success-insertupdate-mess" />
<liferay-ui:success key="shooter-success-insert"
	message="shooter-success-insert" />
<liferay-ui:success key="shooter-success-update"
	message="shooter-success-update" />
	
<liferay-ui:error key="user-email-message" message="user-email-mess" />
<liferay-ui:error key="user-birthday-message" message="user-birthday-message" />
<liferay-ui:error key="shooter-error-insert" message="shooter-error-insert" />
<liferay-ui:error key="shooter-error-update" message="shooter-error-update" />
<liferay-ui:error key="select-type-of-army" message="select-type-of-army" />


	<portlet:renderURL var="renderURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
	</portlet:renderURL>
	
	<aui:button-row cssClass="esfshooter-admin-buttons">
	
		<aui:button onClick="<%= renderURL.toString() %>" value="back" />
	</aui:button-row>


<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%=true%>" label=""
				name="lastname" placeholder="last-name" size="30"
				title="search-entries" type="text" />  
			<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries"
				type="text" /> 
			<aui:input inlineField="<%=true%>" label="" name="card" 
				placeholder="card" size="30" title="search-entries" type="text" /> 
			<aui:input name="typestate" type="hidden" 
				value="<%=ESFKeys.ESFStateType.ENABLE%>" /> 
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<div class="separator"></div>
<liferay-ui:search-container emptyResultsMessage="no-result">

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName"
			name="last-name" />
			
		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />
		
		<liferay-ui:search-container-column-text value="<%=esfUser.getFiscalCode()%>"
			name="fiscalCode" />
		
		<%
			session.setAttribute("esfuserid",esfUser.getEsfUserId());
			ESFCard card =
				ESFCardLocalServiceUtil.findAllESFCardsByU_S(
					esfUser.getEsfUserId(), ESFKeys.ESFStateType.ENABLE).get(0);
		%>
			
		<liferay-ui:search-container-column-text value="<%=card.getCode()%>" name="card" />
		<%
			String orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(
					card.getEsfOrganizationId()).getName();
		%>	
			
		<liferay-ui:search-container-column-text value="<%=orgName%>"
			name="orgName" />
		
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(esfUser.getBirthday()).toString()%>" />

			<c:if test="<%=ESFNationalDelegationPermission.contains(permissionChecker, esfUser.getEsfUserId(),
							ActionKeys.ESFNATIONALDELEGATION_VIEW)%>">
				<liferay-ui:search-container-column-jsp
					path='<%=templatePath+"esfPopupModifyNational3.jsp" %>' align="right" />
			</c:if>			
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>