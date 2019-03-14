<%@include file="init.jsp"%>
<%
String namespace = renderResponse.getNamespace();

String name = "";
String code = "";
long idFather = 0;
ESFOrganization org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
idFather = org.getIdFatherAssociation();
if(idFather>0){
	ESFOrganization fatherOrg = ESFOrganizationLocalServiceUtil.fetchESFOrganization(idFather);
	name = fatherOrg.getName();
	code = fatherOrg.getCode();
}


%>

	<h4>
		<liferay-ui:message key="associated_company" />
	</h4>

<aui:input type="hidden" name="idFatherAssociation" value="<%=idFather %>"/>
<aui:input type="text" name="organizationName" readonly="true" value="<%=name %>"/>
<aui:input type="text" name="organizationCode" readonly="true" value="<%=code %>"/>

<c:if test="<%=ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_ASSOCIATED_COMPANY) %>">
	<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
			id='<%=namespace + "chooseAssociation"%>' value="add">
	</aui:button>
</c:if>
