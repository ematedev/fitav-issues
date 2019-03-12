<%@include file="init.jsp"%>
<%
String current = currentESFOrganization.getLegalForm();

String readOnly="readonly";
String readOnlyMore="";
if(ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_MORE_DEATILS)){
	readOnlyMore=readOnly;
}
%>

<div id="idOne">
	<aui:input name="ibanCode"
		value="<%=currentESFOrganization.getIbanCode()%>" />

	<aui:input name="establishmentDate" type="text" <%= readOnlyMore %>  >
		<aui:validator name="required" errorMessage="this-field-is-required" />
	</aui:input>

	<%
		String value="";
		if(readOnlyMore.equals("")){
			List<ListType> legalForms = ListTypeServiceUtil
					.getListTypes(ESFOrganization.class.getName() + ESFListType.LEGAL_FORM);

			for (ListType legalForm : legalForms) 
				if (Validator.isNotNull(current)
					&& legalForm.getListTypeId() == Integer
							.valueOf(current))
				value=legalForm.getName();	

	%>
		
			<aui:input name="legalFormH" label="legalForm" type="text" disabled="true" value="<%= value %>" />
			<aui:input name="legalForm" type="hidden"  value="<%=current %>"  />
				
	<%		
		}else{
	%>
			<aui:select name="legalForm">
		<%
				List<ListType> legalForms = ListTypeServiceUtil
							.getListTypes(ESFOrganization.class.getName() + ESFListType.LEGAL_FORM);
			
		
				for (ListType legalForm : legalForms) {
					boolean sel=false;
					if (Validator.isNotNull(current)
							&& legalForm.getListTypeId() == Integer
									.valueOf(current))
						sel=true;
		%>
					<aui:option label="<%=legalForm.getName()%>"
						value="<%=legalForm.getListTypeId()%>" selected="<%=sel %>" />

		<%
				}
		}
		%>
	</aui:select>

	<aui:input name="description" type="textarea"
		value="<%=currentESFOrganization.getDescription()%>"  <%= readOnlyMore %>  />

</div>