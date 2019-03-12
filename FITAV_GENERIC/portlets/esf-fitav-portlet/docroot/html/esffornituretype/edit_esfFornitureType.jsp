<%@ include file="init.jsp" %>

<%
	ESFFornitureType esfFornitureType = null;

	long eSFFornitureTypeId = ParamUtil.getLong(request, "esfFornitureTypeId");

	if (eSFFornitureTypeId > 0) {
		esfFornitureType = ESFFornitureTypeLocalServiceUtil.getESFFornitureType(eSFFornitureTypeId);
	}

%>
 
<portlet:actionURL name="editESFFornitureType" var="editESFFornitureTypeURL"  />

<aui:form action="<%= editESFFornitureTypeURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfFornitureType %>" model="<%= ESFFornitureType.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfFornitureTypeId"
				value='<%= esfFornitureType == null ? "" : esfFornitureType.getEsfFornitureTypeId() %>' />
			<aui:input name="description" />
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>