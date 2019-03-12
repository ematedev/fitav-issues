<%
List<ESFRenewalCompany> esfRenewalCompanies = ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByStatus(ESFRenewalConstants.RENEWAL_STATUS_OPENED);
int totalResults = esfRenewalCompanies.size();
%>
<%@ include file="/html/renewal/admin/tabs/common.jsp"%>