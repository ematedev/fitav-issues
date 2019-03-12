<%@ include file="init.jsp" %>

<%
ESFStockist esfStockist = null;
long esfStockistId = ParamUtil.getLong(request, "esfStockistId");
Boolean modifyMode = ParamUtil.getBoolean(request, "modifyMode", false);

if (esfStockistId > 0) {
	esfStockist = ESFStockistLocalServiceUtil.getESFStockist(esfStockistId);
}
%>

<portlet:actionURL name="editESFStockist" var="editESFStockistURL">
	<portlet:param name="esfStockistId" value="<%= String.valueOf(esfStockistId) %>" />
</portlet:actionURL>

<liferay-ui:header backURL="<%= viewURL %>" title='<%= modifyMode?"edit-stockist":"add-stockist" %>' />

<aui:form action="<%= editESFStockistURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfStockist %>" model="<%= ESFStockist.class %>" />

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

	<aui:button-row>
		<aui:button name="save" type="submit"></aui:button>
		<aui:button onClick="<%= viewURL %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>