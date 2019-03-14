<%@ include file="init.jsp" %>

<%
ESFOrder esfOrder = null;
long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
Boolean modifyMode = ParamUtil.getBoolean(request, "modifyMode", false);

if (esfOrderId > 0) {
	esfOrder = ESFOrderLocalServiceUtil.getESFOrder(esfOrderId);
}
%>

<portlet:actionURL name="editESFOrder" var="editESFOrderURL">
	<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrderId) %>" />
</portlet:actionURL>

<liferay-ui:header backURL="<%= viewURL %>" title='<%= modifyMode?"edit-order":"add-order" %>' />

<aui:form enctype="multipart/form-data" method="post" action="<%= editESFOrderURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfOrder %>" model="<%= ESFOrder.class %>" />

	<aui:fieldset>

		<aui:input name="code" >
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="description" />

		<aui:input name="date" />

		<aui:input name="note" />

		<aui:input name="protocolCode" />

		<%
		if (modifyMode) {
		%>
		<aui:input type="text" name="actual-attachment-file" disabled="<%= true %>" value="<%= esfOrder.getAttachment() %>" />
		<%
		}
		%>
		<aui:input name="attachment-file" type="file" />

		<aui:select label="state" name="state" required="true">
			<aui:option selected="<%= true %>" label="<%= ESFOrderConstants.ORDER_STATE_NOT_DELIVERED_LABEL %>" value="<%= ESFOrderConstants.ORDER_STATE_NOT_DELIVERED %>" />
			<aui:option label="<%= ESFOrderConstants.ORDER_STATE_DELIVERED_LABEL %>" value="<%= ESFOrderConstants.ORDER_STATE_DELIVERED %>" />
		</aui:select>

		<aui:select label="stockist" name="esfStockistId" required="true">
			<%
			List<ESFStockist> esfStockists = ESFStockistLocalServiceUtil.getESFStockists(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (ESFStockist esfStockist : esfStockists) {
			%>
				<aui:option label="<%= esfStockist.getName() %>" value="<%= esfStockist.getEsfStockistId() %>" />
			<%
			}
			%>
		</aui:select>

	</aui:fieldset>

	<aui:button-row>
		<aui:button name="save" type="submit"></aui:button>
		<aui:button onClick="<%= viewURL %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>