<%@ include file="init.jsp" %>

<liferay-ui:error key="esfArticleTypeDescriptionError"
message="esfArticleTypeDescriptionError" />

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFArticleType esfArticleType = null;
long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));

if (esfArticleTypeId > 0) {

	esfArticleType = ESFArticleTypeLocalServiceUtil.getESFArticleType(esfArticleTypeId);
}
%>

<portlet:actionURL name="editESFArticleType" var="editESFArticleTypeURL">
	<portlet:param name="esfArticleTypeId"
	value="<%= String.valueOf(esfArticleTypeId) %>" />
	</portlet:actionURL>

<portlet:actionURL name="deleteESFArticleType" var="deleteURL">
			<portlet:param name="esfArticleTypeId"
			value="<%= String.valueOf(esfArticleTypeId) %>" />
				<portlet:param name="mvcPath"
				value='<%= templatePath + "view.jsp" %>' />
</portlet:actionURL>

<aui:form action="<%= editESFArticleTypeURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfArticleType %>"
		model="<%= ESFArticleType.class %>" />

	<aui:fieldset>

		<aui:input name="description">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="department">
		</aui:input>

		<aui:input name="area">
		</aui:input>

	</aui:fieldset>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button name="save" type="submit"></aui:button>
		<% if (modifyMode) { %>
		<aui:button onClick="<%= deleteURL %>" type="cancel" value="delete"></aui:button>
		<%} %>
		<aui:button onClick="<%= backUrl %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>