<%@ include file="init.jsp"%>

<%
ESFBrand esfBrand = null;

long esfBrandId = ParamUtil.getLong(request, "esfBrandId");

if (esfBrandId > 0) {

	esfBrand = ESFBrandLocalServiceUtil.getESFBrand(esfBrandId);

}

	if(Validator.isNotNull(esfBrand)){
		String brand = esfBrand.getName();
		String[] brandName = {brand};
	%>
	<h4><b><liferay-ui:message key="update-brand-x" arguments="<%= brandName%>"/></b>
				<div class="separator"></div>
	<% 
		
	}else{
	%>
	<h4><b><liferay-ui:message key="add-new-brand" /></b>
				<div class="separator"></div>
<%
	}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
</portlet:renderURL>

<portlet:actionURL name="editEsfBrand" var="editESFBrandURL"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<portlet:param name="esfBrandId" value="<%=String.valueOf(esfBrandId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFBrandURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfBrand%>"
		model="<%=ESFBrand.class%>" />
		
	<aui:fieldset>
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="description">
		</aui:input>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>