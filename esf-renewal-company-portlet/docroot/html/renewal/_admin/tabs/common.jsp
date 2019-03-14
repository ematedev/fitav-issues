<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/renewal/admin/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	curParam="curRenewal"
	var="searchContainer"
	iteratorURL="<%= iteratorURL %>"
	emptyResultsMessage="no-results">

	<liferay-ui:search-container-results
		results="<%= esfRenewalCompanies %>"
		total="<%= totalResults %>"
		/>
	
	<liferay-ui:search-container-row className="it.ethica.esf.renewal.model.ESFRenewalCompany" modelVar="esfRenewalCompany" keyProperty="esfRenewalCompanyId" >
		<%
		ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfRenewalCompany.getEsfOrganizationId());
		
		int paymentType = esfRenewalCompany.getPaymentType();
		String paymentTypeLabel = StringPool.BLANK;
		
		switch (paymentType) {

			case ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_NO_PAYMENT:
				paymentTypeLabel = ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_NO_PAYMENT_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC:
				paymentTypeLabel = ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL:
				paymentTypeLabel = ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER:
				paymentTypeLabel = ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER_LABEL;
				break;
			default:
				paymentTypeLabel = ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_NO_PAYMENT_LABEL;
				break;
		}
			
		int status = esfRenewalCompany.getStatus();
		String statusLabel = StringPool.BLANK;
			
		switch (status) {

			case ESFRenewalConstants.RENEWAL_STATUS_OPENED:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_OPENED_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_STATUS_PENDING:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_PENDING_LABEL;
				break;
			case ESFRenewalConstants.RENEWAL_STATUS_CLOSED:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_CLOSED_LABEL;
				break;
			default:
				statusLabel = ESFRenewalConstants.RENEWAL_STATUS_OPENED_LABEL;
				break;
		}
		%>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= esfOrganization.getName() %>"
		/>
		<liferay-ui:search-container-column-text property="year" />
		<liferay-ui:search-container-column-text name="payment-type" value="<%= LanguageUtil.get(pageContext, paymentTypeLabel) %>" />
		<liferay-ui:search-container-column-text name="status" value="<%= LanguageUtil.get(pageContext, statusLabel) %>"  />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
