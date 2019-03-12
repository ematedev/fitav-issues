<%@ include file="init.jsp"%>

<%
	ESFDescription esfDescription = null;

	long esfDescriptionId =
		ParamUtil.getLong(request, "esfDescriptionId");

	if (esfDescriptionId >0) {

		esfDescription =
			ESFDescriptionLocalServiceUtil.getESFDescription(esfDescriptionId);
	}
%>


<portlet:actionURL name="editESFdescription" var="editESFDescriptionURL">
	<portlet:param name="esfDescriptionId"
		value="<%=String.valueOf(esfDescriptionId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFDescriptionURL%>"
	name="fm">
	<aui:model-context bean="<%= esfDescription%>"
		model="<%=ESFDescription.class%>" />

	<aui:fieldset>
	
		<aui:input type="hidden" name="esfDescriptionId"
			value='<%= esfDescriptionId %>' />
			
		<aui:input name="name"></aui:input>

		<aui:input name="isNational"
			label="isNational" type="checkbox"
			value='<%=esfDescription != null
							? esfDescription.getIsNational()
							: StringPool.BLANK%>'></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>