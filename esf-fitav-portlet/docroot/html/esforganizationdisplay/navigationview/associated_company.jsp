<%@include file="init.jsp"%>

<%
	String name = "";
	String code = "";
	long idFather = 0;
	ESFOrganization orgSon = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
	idFather = orgSon.getIdFatherAssociation();
	if (idFather > 0) {
		ESFOrganization fatherOrg = ESFOrganizationLocalServiceUtil.fetchESFOrganization(idFather);
		name = fatherOrg.getName();
		code = fatherOrg.getCode();
%>

<h4>
	<liferay-ui:message key="associated_company" />
</h4>

<aui:input type="text" name="organizationName" readonly="true"
	value="<%=name%>" />
<aui:input type="text" name="organizationCode" readonly="true"
	value="<%=code%>" />
<%
	} else {
%>
<h4>
	<liferay-ui:message key="no_associated_company" />
</h4>

<%
	}
%>