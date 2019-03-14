<%@include file="/cardadmin/init.jsp"%>

<%
	ESFCard esfCard = null;

	long esfCardId = ParamUtil.getLong(request, "esfCardId");

	if (esfCardId > 0) {
		esfCard = ESFCardLocalServiceUtil.getESFCard(esfCardId);
	}
%>


<portlet:renderURL var="viewURL" windowState="<%= WindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/cardadmin/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL
	name='<%=esfCard == null ? "addESFCard" : "updateESFCard"%>'
	var="editESFCardURL" />

<aui:form action="<%=editESFCardURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=esfCard%>" model="<%=ESFCard.class%>" />
	<aui:fieldset>
		<aui:input type="hidden" name="esfCardId"
			value='<%=esfCard == null ? "" : esfCard.getEsfCardId()%>' />
		<aui:input name="code"
			value='<%=esfCard == null ? "" : esfCard.getCode()%>'>
			<aui:validator name="required" errorMessage="Please enter the code." />
		</aui:input>
		<aui:input name="startDate"
			value='<%=esfCard == null
						? CalendarFactoryUtil.getCalendar()
						: ConvertDateCal.DateToCalendar(esfCard.getStartDate())%>' />
		<aui:input name="endDate"
			value='<%=esfCard == null
						? CalendarFactoryUtil.getCalendar()
						: ConvertDateCal.DateToCalendar(esfCard.getEndDate())%>' />

		<aui:select name="esfUserId">
			<aui:option value="1" label="UserA"></aui:option>
			<aui:option value="2" label="UserB"></aui:option>
		</aui:select>

		<aui:select name="esfOrganizationId">
			<aui:option value="1" label="OrgA"></aui:option>
			<aui:option value="2" label="OrgB"></aui:option>
		</aui:select>

	</aui:fieldset>

	<liferay-ui:asset-categories-error />
	<liferay-ui:asset-tags-error />
	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryCategorizationPanel" persistState="<%=true%>"
		title="categorization">
		<aui:fieldset>
			<aui:input name="categories" type="assetCategories" />

			<aui:input name="tags" type="assetTags" />
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryAssetLinksPanel" persistState="<%=true%>"
		title="related-assets">
		<aui:fieldset>
			<liferay-ui:input-asset-links
				className="<%=ESFCard.class.getName()%>" classPK="<%=esfCardId%>" />
		</aui:fieldset>
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>
