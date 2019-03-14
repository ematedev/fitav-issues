<%@page import="com.liferay.portal.model.Role"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@ include file="/html/init.jsp" %>

<%
long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
int year = ParamUtil.getInteger(request, "year");

ESFOrganization esfOrganization = null;
ESFRenewalCompany esfRenewalCompany = null;
int status = 0;
if (Validator.isNotNull(esfOrganizationId)) {
	esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
	esfRenewalCompany = ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByE_Y(esfOrganizationId, year);
	status = esfRenewalCompany.getStatus();
}
Role presidente =
	RoleLocalServiceUtil.getRole(
		themeDisplay.getCompanyId(), "Presidente Associazione");

long presidentePK = presidente.getPrimaryKey();

List<ESFUserESFUserRole> temp =
	ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
		esfOrganizationId, presidentePK);

boolean withPresident = false;
if (temp.size() > 0) {
	withPresident = true;
}

DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>
<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= esfOrganization.getName() %>'
/>
<liferay-ui:error key="no-president" message="no-president-available" />
<liferay-portlet:actionURL name="updateESFRenewalCompany" var="updateESFRenewalCompanyURL" />

<%
if (!withPresident) {
%>
<div class="alert alert-error">
<liferay-ui:message key="no-president-available" />
</div>
<%
}
%>

<aui:form action="<%= updateESFRenewalCompanyURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" + renderResponse.getNamespace() + "updateESFRenewalCompany();" %>'>
	<aui:model-context bean="<%= esfRenewalCompany %>" model="<%= ESFRenewalCompany.class %>" />
	
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="esfOrganizationId" type="hidden" />
	<aui:input name="esfRenewalCompanyId" type="hidden" />
	<aui:input name="year" type="hidden" />
	
	<%
	int field = ESFFieldLocalServiceUtil.findByESFOrganization(
		esfOrganization.getEsfOrganizationId(), ESFKeys.ESFStateType.ENABLE).size();
	double totalAmount = 0;

	if (field == 0) {
		totalAmount = Double.valueOf( ESFConfigurationLocalServiceUtil.
	getESFConfigurationByESFKey("first-registration-cost").getValue());
	}
	else if (field == 1) {
		totalAmount = Double.valueOf( ESFConfigurationLocalServiceUtil.
	getESFConfigurationByESFKey("first-registration-cost-1").getValue());
	}
	else if (field == 2) {
		totalAmount =  Double.valueOf( ESFConfigurationLocalServiceUtil.
	getESFConfigurationByESFKey("first-registration-cost-2").getValue());
	}
	else if(field == 3){
		totalAmount =  Double.valueOf( ESFConfigurationLocalServiceUtil.
	getESFConfigurationByESFKey("first-registration-cost-3").getValue());
	}
	else if(field == 4){
		totalAmount =  Double.valueOf( ESFConfigurationLocalServiceUtil.
	getESFConfigurationByESFKey("first-registration-cost-4").getValue());
	}
	else if(field == 5){
		totalAmount =  Double.valueOf( ESFConfigurationLocalServiceUtil.
	getESFConfigurationByESFKey("first-registration-cost-5").getValue());
	}
	else{
		totalAmount =  Double.valueOf( ESFConfigurationLocalServiceUtil.
	getESFConfigurationByESFKey("first-registration-cost-6").getValue());
	}
	int cardAmount = 0;
	try {
		cardAmount = Integer.getInteger(ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("card-amount").getValue());
	}
	catch (Exception e) {
	}
	
	boolean isCompleted = false;
	
	if (status == ESFRenewalConstants.RENEWAL_STATUS_COMPLETED || status == ESFRenewalConstants.RENEWAL_STATUS_DISABLED || status == ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED) {
		isCompleted = true;
	}
			
		%>
	<div class="row-fluid">
		<aui:fieldset cssClass="span6">
			<aui:input type="text" wrapperCssClass="euro disabled-wrapper" readonly="<%= true %>" name="totalAmount" value="<%= totalAmount %>" />
			<aui:input type="text" readonly="<%= true %>" name="cardsNumber" value="<%= esfRenewalCompany.getCardsNumber() %>" />
			<aui:input type="text" wrapperCssClass="euro disabled-wrapper" readonly="<%= true %>" name="cardsAmount" value="<%= cardAmount * esfRenewalCompany.getCardsNumber() %>" />
			<%
			String amountCssWrapperClass = (isCompleted)?"euro disabled-wrapper":"euro active-wrapper";
			%>
			<aui:input name="amount" wrapperCssClass="<%= amountCssWrapperClass %>" type="number" step="0.01" min="0" max="<%= totalAmount %>" value="<%= esfRenewalCompany.getAmount() %>" disabled="<%= isCompleted %>" />
			<aui:input name="paymentDate" disabled="<%= isCompleted %>" />
			<aui:field-wrapper label="payment-type">
				<label class="radio" for="<portlet:namespace />paymentTypeElectronic">
					<input <%= isCompleted?"disabled":StringPool.BLANK %> required id="<portlet:namespace />paymentTypeElectronic" name="<portlet:namespace />paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC %>" type="radio" <%= (esfRenewalCompany.getPaymentType() == ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC)?"checked":StringPool.BLANK %> />
					<liferay-ui:message key="electronic-payment" />
				</label>
				<label class="radio" for="<portlet:namespace />paymentTypePostal">
					<input <%= isCompleted?"disabled":StringPool.BLANK %> required id="<portlet:namespace />paymentTypePostal" name="<portlet:namespace />paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL %>" type="radio" <%= (esfRenewalCompany.getPaymentType() == ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL)?"checked":StringPool.BLANK %> />
					<liferay-ui:message key="postal" />
				</label>
				<label class="radio" for="<portlet:namespace />paymentTypeTransfer">
					<input <%= isCompleted?"disabled":StringPool.BLANK %> required id="<portlet:namespace />paymentTypeTransfer" name="<portlet:namespace />paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER %>" type="radio" <%= (esfRenewalCompany.getPaymentType() == ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER)?"checked":StringPool.BLANK %> />
					<liferay-ui:message key="transfer" />
				</label>
			</aui:field-wrapper>
			<aui:input type="textarea" name="info" disabled="<%= isCompleted %>" />
			<aui:input name="accountholder" value="<%= esfRenewalCompany.getAccountholder() %>" disabled="<%= isCompleted %>" />
			<%
			if (esfRenewalCompany.getYear() == actualYear) {
			%>
			<aui:input helpMessage="help-join" name="join" type="checkbox" value="<%= esfRenewalCompany.getJoin() %>" disabled="<%= isCompleted || !withPresident %>" />
			<%
			}
			%>
			<aui:input disabled="<%= true %>" name="year" />
		</aui:fieldset>
		<%
		boolean showIntegration = false;
		if (status == ESFRenewalConstants.RENEWAL_STATUS_PENDING || 
			((status == ESFRenewalConstants.RENEWAL_STATUS_COMPLETED || status == ESFRenewalConstants.RENEWAL_STATUS_DISABLED || status == ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED) && (esfRenewalCompany.getAmount() < totalAmount))) {
			showIntegration = true;
		}
		%>
		<aui:fieldset cssClass='<%= !showIntegration?"span6 hidden":"span6" %>' label="integration-section">
			<%
			boolean integrationAmountIsDisabled = (status == ESFRenewalConstants.RENEWAL_STATUS_COMPLETED);
			String integrationAmountCssWrapperClass = (integrationAmountIsDisabled)?"euro disabled-wrapper":"euro active-wrapper";
			%>
			<aui:input name="integrationAmount" wrapperCssClass="<%= integrationAmountCssWrapperClass %>" type="number" step="0.01" min="0" max="<%= totalAmount - esfRenewalCompany.getAmount() %>" value="<%= esfRenewalCompany.getIntegrationAmount() %>" disabled="<%= isCompleted %>"/>
			<aui:input name="integrationDate" disabled="<%= isCompleted %>" />
			<aui:field-wrapper label="integration-payment-type" cssClass="integration-field-wrapper">
				<%
				int integrationTypeDefaultValue = esfRenewalCompany.getIntegrationType();
				if (esfRenewalCompany.getStatus() == ESFRenewalConstants.RENEWAL_STATUS_PENDING && integrationTypeDefaultValue == ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_NO_PAYMENT) {
					integrationTypeDefaultValue = esfRenewalCompany.getPaymentType();
				}
				%>
				<label class="radio" for="<portlet:namespace />integrationTypeElectronic">
					<input <%= isCompleted?"disabled":StringPool.BLANK %> id="<portlet:namespace />integrationTypeElectronic" name="<portlet:namespace />integrationType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC %>" type="radio" <%= (integrationTypeDefaultValue == ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC)?"checked":StringPool.BLANK %> />
					<liferay-ui:message key="electronic-payment" />
				</label>
				<label class="radio" for="<portlet:namespace />integrationTypePostal">
					<input <%= isCompleted?"disabled":StringPool.BLANK %> id="<portlet:namespace />integrationTypePostal" name="<portlet:namespace />integrationType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL %>" type="radio" <%= (integrationTypeDefaultValue == ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL)?"checked":StringPool.BLANK %> />
					<liferay-ui:message key="postal" />
				</label>
				<label class="radio" for="<portlet:namespace />integrationTypeTransfer">
					<input <%= isCompleted?"disabled":StringPool.BLANK %> id="<portlet:namespace />integrationTypeTransfer" name="<portlet:namespace />integrationType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER %>" type="radio" <%= (integrationTypeDefaultValue == ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER)?"checked":StringPool.BLANK %> />
					<liferay-ui:message key="transfer" />
				</label>
			</aui:field-wrapper>
			<aui:input name="integrationAccountholder" value="<%= esfRenewalCompany.getIntegrationAccountholder() %>" disabled="<%= isCompleted %>" />
		</aui:fieldset>
	</div>

	<aui:button-row>
		<aui:button type="submit" value='save' disabled="<%= isCompleted %>" />
		
		<%
		boolean isEnabled = true;
		ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(ESFOrganization.class.getName(), esfOrganizationId, ESFKeys.ESFStateType.ENABLE);
		if ((Validator.isNull(esfRenewalCompany.getJoin()) || !esfRenewalCompany.getJoin()) && Validator.isNull(esfEntityState)) {
			isEnabled = false;
		}
		%>
		
		<liferay-portlet:actionURL name="disableAssociation" var="disableAssociationURL">
			<liferay-portlet:param name="esfRenewalCompanyId" value="<%= Long.toString(esfRenewalCompany.getEsfRenewalCompanyId()) %>" />
		</liferay-portlet:actionURL>
		<%
		if (esfRenewalCompany.getYear() == actualYear && isCompleted) {
		%>
		<aui:button value='disable-association' disabled="<%= !isEnabled %>" href="<%= disableAssociationURL %>" />
		<%
		}
		%>
		
		<liferay-portlet:actionURL name="enableAssociation" var="enableAssociationURL">
			<liferay-portlet:param name="esfRenewalCompanyId" value="<%= Long.toString(esfRenewalCompany.getEsfRenewalCompanyId()) %>" />
		</liferay-portlet:actionURL>
		<%
		if (esfRenewalCompany.getYear() == actualYear && isCompleted) {
		%>
		<aui:button value='enable-association' disabled="<%= isEnabled || !withPresident %>" href="<%= enableAssociationURL %>"  />
		<%
		}
		%>
		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
var A = AUI();
function <portlet:namespace />updateESFRenewalCompany() {
	var isPending = <%= esfRenewalCompany.getStatus() == ESFRenewalConstants.RENEWAL_STATUS_PENDING %>;
	var amount = parseFloat(A.one('#<portlet:namespace />amount').val());
	var totalAmount = parseFloat(A.one('#<portlet:namespace />totalAmount').val());
	var integrationAmount = 0;
	if (A.one('#<portlet:namespace />integrationAmount') &&
		A.one('#<portlet:namespace />integrationAmount').val() != '') {
		integrationAmount = parseFloat(A.one('#<portlet:namespace />integrationAmount').val());
	}
	if (isPending) {
		if (amount == totalAmount) {
			A.one('#<portlet:namespace />integrationAmount').val('');
			A.one('#<portlet:namespace />integrationDate').val('');
			A.one('[name="<portlet:namespace />integrationType"]').val('0');
			A.one('#<portlet:namespace />integrationAccountholder').val('');
		}
		
		if (amount + integrationAmount != totalAmount) {
			alert('<liferay-ui:message key="total-not-achieved" />');
			return;
		}
	}
	if (A.one('#<portlet:namespace />joinCheckbox') &&
		!A.one('#<portlet:namespace />joinCheckbox').attr('checked') &&
		amount + integrationAmount == totalAmount) {
		if (!window.confirm('<liferay-ui:message key="join-not-checked" />')) {
			return;
		}
	}
	submitForm(document.<portlet:namespace />fm);
}
</aui:script>
<aui:script use="aui-base">
A.each(A.all('.euro'), function(value, index) {
	value.append('<i class="icon-euro"></i>');
});
</aui:script>