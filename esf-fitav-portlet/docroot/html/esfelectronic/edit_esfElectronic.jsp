<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="init.jsp"%>

<%
	ESFElectronic esfElectronic = null;

	long esfElectronicId =
		ParamUtil.getLong(request, "esfElectronicId");

	if (esfElectronicId > 0) {

		esfElectronic =
			ESFElectronicLocalServiceUtil.getESFElectronic(esfElectronicId);

	}
	
	if(Validator.isNotNull(esfElectronic)){
		String electronic = esfElectronic.getName();
		String[] electronicName = {electronic};
	%>
	<h4><b><liferay-ui:message key="update-electronic-x" arguments="<%= electronicName%>"/></b>
				<div class="separator"></div>
	<% 
		
	}else{
	%>
	<h4><b><liferay-ui:message key="add-new-electronic" /></b>
				<div class="separator"></div>
<%
	}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>


<portlet:actionURL name="editEsfElectronic" var="editESFElectronicURL">
	<portlet:param name="esfElectronicId"
		value="<%=String.valueOf(esfElectronicId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFElectronicURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfElectronic%>"
		model="<%=ESFElectronic.class%>" />
		
	<aui:fieldset>
	<aui:input type="hidden" name="esfElectronicId"
				value='<%= esfElectronicId == 0 ? "" : esfElectronic.getElectronicId() %>' />
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="description">
			<aui:validator name="required" />
		</aui:input>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>