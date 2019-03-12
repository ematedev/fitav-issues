<%@ include file="init.jsp" %>

<liferay-ui:error exception="<%= ESFOrderAssociatedException.class %>" message="there-are-associated-order" />

<liferay-ui:header title='stockist' />

<aui:button-row cssClass="esfstockist-admin-buttons">

	<portlet:renderURL var="addESFStockistURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_stockist.jsp" %>' />
	</portlet:renderURL>
	<aui:button onClick="<%= addESFStockistURL %>" value="add-esfstockist" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">

	<liferay-ui:search-container-results results="<%= ESFStockistLocalServiceUtil.getESFStockists(searchContainer.getStart(), searchContainer.getEnd()) %>" total="<%= ESFStockistLocalServiceUtil.getESFStockistsCount() %>" />

	<liferay-ui:search-container-row className="com.ethica.esf.model.ESFStockist" modelVar="esfStockist">
		<liferay-ui:search-container-column-text name="name" value="<%= esfStockist.getName() %>" />
		<liferay-ui:search-container-column-text name="email" >
			<a href="mailto:<%=esfStockist.getEmail()%>" target="_top"><p><%=esfStockist.getEmail()%></p></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="phone" value="<%= esfStockist.getPhone() %>" />
		<liferay-ui:search-container-column-text name="address" value="<%= esfStockist.getAddress() %>" />
		<liferay-ui:search-container-column-text name="description" value="<%= esfStockist.getDescription() %>" />

		<liferay-ui:search-container-column-jsp
				path='<%= templatePath + "stockist_actions.jsp" %>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>