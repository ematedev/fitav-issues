<%@include file="init.jsp"%>

<%
	String className = (String)request.getAttribute("addresses.className");
	long classPK = (Long)request.getAttribute("addresses.classPK");
	
	boolean readOnlyValue = false;
	
	if(esfOrganizationId > 0){
		readOnlyValue = ESFOrganizationPermission.contains(permissionChecker, esfOrganizationId, ActionKeys.ESFORGANIZATIONADMIN_UPDATE_INFO); 
	}else{
		readOnlyValue = ESFOrganizationModelPermission.contains(permissionChecker, group.getGroupId(), ActionKeys.ESFORGANIZATIONADMIN_ADD); 
	}

%>

<aui:fieldset>
	<aui:model-context bean="<%=esfOrganization%>"	model="<%=ESFOrganization.class%>" />
	
	<aui:input name="name">
		<aui:validator name="required" errorMessage="this-field-is-required" />
	</aui:input>
	
	<aui:input name="code">
		<aui:validator name="required" errorMessage="this-field-is-required" />
	</aui:input>
	
	<aui:input name="regionCode"/>
	
	<liferay-util:include page='<%= jspAddressTL %>' servletContext="<%= application%>" >
		<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
		<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
		<liferay-util:param name="iesima" value="<%= Integer.toString(0) %>"></liferay-util:param>
		<liferay-util:param name="idOwner" value="<%= Long.toString(esfOrganizationId) %>"></liferay-util:param>
		<liferay-util:param name="listTypeId" value="<%= Integer.toString(ESFAddressListType.LEGAL) %>"></liferay-util:param>
		<liferay-util:param name="requiredField" value="true"></liferay-util:param>
		<liferay-util:param name="readOnly" value="<%=String.valueOf(!readOnlyValue )%>"></liferay-util:param>
		
	</liferay-util:include>
	
	<%
	String emailAddress = StringPool.BLANK;
	if (esfOrganization != null) {

		List<EmailAddress> emailAddresses = EmailAddressLocalServiceUtil
				.getEmailAddresses(themeDisplay.getCompanyId(),
						Organization.class.getName(),
						esfOrganization.getEsfOrganizationId());

		if (emailAddresses != null && emailAddresses.size() > 0) {
			emailAddress = emailAddresses.get(0).getAddress();
		}
	}

	%>
	<aui:input name="emailAddress" value="<%= emailAddress %>">
		<aui:validator name="required" errorMessage="this-field-is-required" />
		<aui:validator name="email" errorMessage="please-enter-a-valid-email-address" />
	</aui:input>
	
	<aui:input name="vat" />

	<aui:input name="fiscalCode" />

	<aui:input name="ibanCode" />

	<aui:input name="description" type="textarea" />

	<aui:input type="hidden" name="esfStateId" value='<%= ESFKeys.ESFStateType.ENABLE%>' />

</aui:fieldset>
