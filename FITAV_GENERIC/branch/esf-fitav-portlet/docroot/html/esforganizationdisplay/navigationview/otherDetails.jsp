<%@include file="init.jsp"%>


<div class="row detail">
	<h4>
		<liferay-ui:message key="iban-code" />
	</h4>
	<p><%=currentESFOrganization.getIbanCode()%></p>

	<h4>
		<liferay-ui:message key="establishment-date" />
	</h4>
	<p>
		<%=currentESFOrganization.getEstablishmentDate() == null ? ""
					: ManageDate.DateToString(currentESFOrganization
							.getEstablishmentDate())%>
	</p>


	<h4>
		<liferay-ui:message key="legal-form" />
	</h4>
	<%
		List<ListType> legalForms = ListTypeServiceUtil
				.getListTypes(ESFOrganization.class.getName()
						+ ESFListType.LEGAL_FORM);
		String legalFormSelect = "";
		String current = currentESFOrganization.getLegalForm();
		for (ListType legalForm : legalForms) {
			if (Validator.isNotNull(current)
					&& legalForm.getListTypeId() == Integer
							.valueOf(current))
				legalFormSelect = legalForm.getName();
		}
	%>
	<p>
		<liferay-ui:message key="<%=legalFormSelect%>" />
	</p>
	<h4>
		<liferay-ui:message key="description" />
	</h4>
	<p><%=currentESFOrganization.getDescription()%></p>
</div>