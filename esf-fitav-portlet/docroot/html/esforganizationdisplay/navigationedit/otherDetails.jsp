<%@include file="init.jsp"%>
<%
	String current = currentESFOrganization.getLegalForm();

	boolean canUpdate = ESFOrganizationDisplayPermission.contains(
			permissionChecker, currentOrganizationId,
			ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_MORE_DEATILS);
%>

<div id="idOne">
	<aui:input name="ibanCode"
		value="<%=currentESFOrganization.getIbanCode()%>" />


	<%
		String value = "";
		if (!canUpdate) {
			List<ListType> legalForms = ListTypeServiceUtil
					.getListTypes(ESFOrganization.class.getName()
							+ ESFListType.LEGAL_FORM);

			for (ListType legalForm : legalForms)
				if (Validator.isNotNull(current)
						&& legalForm.getListTypeId() == Integer
								.valueOf(current))
					value = legalForm.getName();

			String currDateC = "";

			if (currentESFOrganization != null
					&& currentESFOrganization.getEstablishmentDate() != null)
				currDateC = ManageDate.DateToString(currentESFOrganization
						.getEstablishmentDate());
	%>
	<aui:input name="establishmentDated" label="establishmentDate"
		type="text" value="<%=currDateC%>"></aui:input>
	<aui:input name="establishmentDate" type="hidden"
		value="<%=currDateC%>"></aui:input>

	<aui:input name="legalFormH" label="legalForm" type="text"
		disabled="true" value="<%=value%>" />
	<aui:input name="legalForm" type="hidden" value="<%=current%>" />

	<aui:input name="descriptionttt" label="description" type="textarea"
		value="<%=currentESFOrganization.getDescription()%>" disabled="true" />
	<aui:input name="description" type="hidden"
		value="<%=currentESFOrganization.getDescription()%>" />


	<%
		} else {
	%>
	<aui:input name="establishmentDate" type="text">
		<aui:validator name="required" errorMessage="this-field-is-required" />
	</aui:input>

	<aui:select name="legalForm">
		<%
			List<ListType> legalForms = ListTypeServiceUtil
							.getListTypes(ESFOrganization.class.getName()
									+ ESFListType.LEGAL_FORM);

					for (ListType legalForm : legalForms) {
						boolean sel = false;
						if (Validator.isNotNull(current)
								&& legalForm.getListTypeId() == Integer
										.valueOf(current))
							sel = true;
		%>
		<aui:option label="<%=legalForm.getName()%>"
			value="<%=legalForm.getListTypeId()%>" selected="<%=sel%>" />

		<%
			}
		%>
	</aui:select>
	<aui:input name="description" type="textarea"
		value="<%=currentESFOrganization.getDescription()%>" />
	<%
		}
	%>

	<h4>
		<liferay-ui:message key="documents-info" />
	</h4>

	<aui:input type="checkbox" name="constitutiveAct" checked="<%=currentESFOrganization.getConstitutiveAct() %>"/>

	<aui:input type="checkbox" name="registeredStatus" checked="<%=currentESFOrganization.getRegisteredStatus() %>"/>

	<aui:input type="checkbox" name="planimetrySportsStand" checked="<%=currentESFOrganization.getPlanimetrySportsStand() %>"/>

	<aui:input type="checkbox" name="certificateFITAV" checked="<%=currentESFOrganization.getCertificateFITAV() %>"/>

</div>