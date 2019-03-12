<%@include file="init.jsp"%>

<%
boolean visible = false;
ESFOrganization organization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
String organizationName ="";
String orgCode = "";
boolean viewRegional = false;
boolean isAss = false;

if(Validator.isNotNull(organization) ){
	
	if(ESFKeys.ESFOrganizationTypeId.REGION == organization.getType()){
		viewRegional = true;
	}
	
	if(Validator.isNotNull(organization.getType()) && ESFKeys.ESFOrganizationTypeId.ASSOCIATION == organization.getType()){

		visible=true;
		isAss = true;
		organizationName = organization.getName();
		orgCode = organization.getCode();
	}
}
if(visible){ 
	String[] orgDetails ={organizationName,orgCode};
%>
<h2><b><liferay-ui:message key="orgName-x-orgCode-x"  arguments="<%= orgDetails%>"/></b></h2>

<%} %>
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


<c:if test="<%= ESFShooterModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFSHOOTER_ADD) %>">
	<aui:button-row cssClass="esfshooter-admin-buttons">
		<portlet:renderURL var="addESFShooterURL">
			<portlet:param name="mvcPath" value='<%=templatePath + "edit_esfShooter.jsp"%>' />
			<portlet:param name="organizationId" value="<%=String.valueOf(currentOrganizationId)%>" />
			<portlet:param name="op" value="addAddr" />
		</portlet:renderURL>

		<aui:button onClick="<%= addESFShooterURL.toString() %>" value="add-shooter" />
	</aui:button-row>
	
	
	
</c:if>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<div class="aui-search-bar">
			
			<aui:input inlineField="<%=true%>" label=""
				name="lastname" placeholder="last-name" size="30"
				title="search-entries" type="text" />  
			<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries"
				type="text" /> 
			<aui:input inlineField="<%=true%>" label="" name="card" 
				placeholder="card" size="30" title="search-entries" type="text" />
			<aui:input name="isAss" type="hidden" value="<%=isAss%>" inlineField="<%=true%>" />
			<aui:input name="viewRegional" type="hidden" value="<%=viewRegional%>" inlineField="<%=true%>" />
			<aui:input name="typestate" type="hidden" value="<%=ESFKeys.ESFStateType.ENABLE%>" inlineField="<%=true%>" />
		<%if(viewRegional){ %>
			<div class="control-group control-group-inline">
				<aui:input name="isRegional" type="checkbox" checked="<%=false%>" label="regional"/>
			</div><br />
		<%} %>
			<aui:button type="submit" value="search" />
		</div>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result">

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName"
			name="last-name" />
			
		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />
		
		<liferay-ui:search-container-column-text value="<%=esfUser.getFiscalCode()%>"
			name="fiscalCode" />
			
		<liferay-ui:search-container-column-text name="user-email">
		
			<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
		</liferay-ui:search-container-column-text>
		
		<%
			ESFCard userCard= ESFCardLocalServiceUtil.findCardByUser(esfUser.getEsfUserId()).get(0);
			String userCardCode = userCard.getCode();
		%>
			
		<liferay-ui:search-container-column-text value="<%= userCardCode %>" name="card" />
		<%
			String orgName = ESFOrganizationLocalServiceUtil.
								fetchESFOrganization(
									userCard.getEsfOrganizationId()).getName();
		%>	
			
		<liferay-ui:search-container-column-text value="<%=orgName%>"
			name="orgName" />
		
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(esfUser.getBirthday())%>" />

	<c:if test="<%= ESFShooterPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFSHOOTER_VIEW) %>">
		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfShooter_action.jsp"%>' align="right" />
	</c:if>
	
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
