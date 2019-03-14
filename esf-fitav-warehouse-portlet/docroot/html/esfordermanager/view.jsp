<%@ include file="init.jsp" %>

<liferay-ui:header title='order' />

<aui:button-row cssClass="esforder-admin-buttons">

	<portlet:renderURL var="addESFOrderURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_order.jsp" %>' />
	</portlet:renderURL>
	<aui:button onClick="<%= addESFOrderURL %>" value="add-esforder" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">

	<liferay-ui:search-container-results results="<%= ESFOrderLocalServiceUtil.getESFOrders(searchContainer.getStart(), searchContainer.getEnd()) %>" total="<%= ESFOrderLocalServiceUtil.getESFOrdersCount() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFOrder" modelVar="esfOrder">
		<liferay-ui:search-container-column-text name="code" />
		<liferay-ui:search-container-column-text name="name" />
		<liferay-ui:search-container-column-text name="date" value='<%= FastDateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy", locale).format(esfOrder.getDate()) %>' />
		<liferay-ui:search-container-column-text name="protocolCode" />
		<liferay-ui:search-container-column-text name="state" value='<%= (esfOrder.getState() == 1)?ESFOrderConstants.ORDER_STATE_DELIVERED_LABEL:ESFOrderConstants.ORDER_STATE_NOT_DELIVERED_LABEL %>' />

		<liferay-ui:search-container-column-jsp
				path='<%= templatePath + "order_actions.jsp" %>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>