<%@ include file="init.jsp" %>

<liferay-ui:error key="esfStockistError"
message="esfStockistError" />

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
%>

<portlet:actionURL name="addESFStockist" var="addESFStockistURL">
	</portlet:actionURL>

<aui:form action="<%= addESFStockistURL %>" name="<portlet:namespace />fm">

	<aui:fieldset>

		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="email">
		<aui:validator name="email" />
		</aui:input>

		<aui:input name="phone">
		</aui:input>

		<aui:input name="address">
		</aui:input>

		<aui:input name="nameReference">
		</aui:input>

		<aui:input name="lastNameReference">
		</aui:input>

		<aui:input name="emailReference">
		</aui:input>

		<aui:input name="phoneReference">
		</aui:input>

		<aui:input name="description">
		</aui:input>

		<aui:input name="other">
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