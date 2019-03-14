<%@ include file="init.jsp"%>

<%
	ESFDescription esfDescription = null;

	long esfDescriptionId =
		ParamUtil.getLong(request, "esfDescriptionId");

	if (esfDescriptionId >0) {

		esfDescription =
			ESFDescriptionLocalServiceUtil.getESFDescription(esfDescriptionId);
	}
	
	if(Validator.isNotNull(esfDescription)){
		String description = esfDescription.getName();
		String[] descriptionName = {description};
	%>
	<h4><b><liferay-ui:message key="update-description-x" arguments="<%= descriptionName%>"/></b>
				<div class="separator"></div>
	<% 
	}else{
	%>
	<h4><b><liferay-ui:message key="add-new-description" /></b>
				<div class="separator"></div>
<%
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