<%@ include file="init.jsp" %>

<liferay-ui:error key="esfArticleTypeDescriptionError"
message="esfArticleTypeDescriptionError" />

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
%>

<portlet:actionURL name="addESFArticleType" var="addESFArticleTypeURL">
	</portlet:actionURL>

<aui:form action="<%= addESFArticleTypeURL %>" name="<portlet:namespace />fm">

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
		<aui:button onClick="<%= backUrl %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>