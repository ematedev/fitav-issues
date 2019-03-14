<%@ include file="init.jsp" %>

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFArticleType esfArticleType = null;
long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");
Boolean modifyMode = Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));

if (esfArticleTypeId > 0) {

	esfArticleType = ESFArticleTypeLocalServiceUtil.getESFArticleType(esfArticleTypeId);
}
%>

<liferay-ui:header backURL="<%= viewURL %>" title='<%= modifyMode?"edit-article-type":"add-article-type" %>' />

<portlet:actionURL name="editESFArticleType" var="editESFArticleTypeURL">
	<portlet:param name="esfArticleTypeId" value="<%= String.valueOf(esfArticleTypeId) %>" />
</portlet:actionURL>

<aui:form action="<%= editESFArticleTypeURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfArticleType %>"
		model="<%= ESFArticleType.class %>" />

	<aui:fieldset>

		<aui:input name="description">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="area" />

		<aui:input name="department" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button name="save" type="submit"></aui:button>
		<aui:button onClick="<%= viewURL %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>