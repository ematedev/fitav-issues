<%@include file="/cardadmin/init.jsp"%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value="/cardadmin/html/search_esfCard.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%=true%>" label="" name="keywords" size="30"
				title="search-entries" type="text" /> <aui:button type="submit"
				value="search" />
		</span>
	</div>
</aui:form>

<c:if
	test='<%=ESFCardModelPermission.contains(
					permissionChecker, scopeGroupId,
					ESFCardActionKeys.ADD_ESFCARD)%>'>
	<aui:button-row cssClass="esfCard-admin-buttons">
		<portlet:renderURL var="addESFCardURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
			<portlet:param name="mvcPath"
				value="/cardadmin/html/edit_esfCard.jsp" />
		</portlet:renderURL>

		<aui:button onClick="<%= addESFCardURL.toString() %>" value="Add Card" />
	</aui:button-row>
</c:if>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%=ESFCardLocalServiceUtil.getESFCards(
					searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFCardLocalServiceUtil.getESFCardsCount()%>" />


	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFCard" modelVar="esfCard">

		<portlet:renderURL var="viewESFCard">
			<portlet:param name="mvcPath"
				value="/cardadmin/html/view_esfCard.jsp" />
			<portlet:param name="esfCardId"
				value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="code"
			href="<%=viewESFCard%>" />

		<liferay-ui:search-container-column-text name="startDate"
			value="<%=ConvertDateCal.DateToString(esfCard.getStartDate())%>" href="<%=viewESFCard%>" />

		<liferay-ui:search-container-column-text name="endDate"
			value="<%=ConvertDateCal.DateToString(esfCard.getEndDate())%>" href="<%=viewESFCard%>" />

		<liferay-ui:search-container-column-jsp
			path="/cardadmin/html/esfCard_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
