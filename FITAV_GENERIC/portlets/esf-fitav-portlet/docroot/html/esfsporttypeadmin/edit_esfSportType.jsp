<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp" %>

<%
	ESFSportType esfSportType = null;

	long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");
	boolean isChangeCategory = false;
	boolean isOlimpic = false;
	if (esfSportTypeId > 0) {
		esfSportType = ESFSportTypeLocalServiceUtil.getESFSportType(esfSportTypeId);
		isChangeCategory = esfSportType.getIsChangeCategory();
		isOlimpic = esfSportType.getIsOlimpic();
	}
	
	if(Validator.isNotNull(esfSportType)){
		String sportType = esfSportType.getName();
		String[] sportTypeName = {sportType};
	%>
	<h4><b><liferay-ui:message key="update-sportType-x" arguments="<%= sportTypeName%>"/></b>
				<div class="separator"></div>
	<% 
		
	}else{
	%>
	<h4><b><liferay-ui:message key="add-new-sportType" /></b>
				<div class="separator"></div>
<%
	}
%>

<portlet:actionURL name="editESFSportType" var="editESFSportTypeURL" />

<aui:form action="<%= editESFSportTypeURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfSportType %>" model="<%= ESFSportType.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfSportTypeId"
				value='<%= esfSportType == null ? "" : esfSportType.getEsfSportTypeId() %>' />
			<aui:input name="code" />
			<aui:input name="name" />
			<aui:input name="description" type="textarea"/>
			<aui:input name="national" />
			<aui:input name="isChangeCategory"  label="isChangeCategory"  type="checkbox" value="<%=isChangeCategory%>"/>
			<aui:input name="isOlimpic"  label="isOlimpic"  type="checkbox" value="<%=isOlimpic%>"/>
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>
