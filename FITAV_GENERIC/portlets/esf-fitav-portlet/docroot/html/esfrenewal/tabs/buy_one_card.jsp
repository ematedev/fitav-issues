<%@include file="../init.jsp"%>

<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);
	double cardCost = Double.parseDouble(PortletProps.get("esf-renewal-member-card-cost"));
%>
<aui:script use="aui-base,node,aui-io-request">
	(function($) {
		$("#<portlet:namespace/>paymentDate").datepicker();
		$("#<portlet:namespace/>paymentDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>paymentDate").datepicker("setDate",
				'<%= currDate %>');
	});
</aui:script>
	
<portlet:actionURL name="addRenewal" var="addRenewalURL">
	<portlet:param name="operation" value="buy-one-card" />
</portlet:actionURL>

<aui:form action="<%=addRenewalURL%>">

	<aui:input name="amount" type="number" label="amount"
		value="<%=cardCost%>" disabled="true">

	</aui:input>

	<aui:input name="paymentDate" type="text" label="payment-date">
		<aui:validator name="required" />
	</aui:input>
	
	<div style="display:none;">
		<aui:input type="hidden" label="organizationid" name="organizationId"  readonly="true"/>
		<aui:input name="organizationId" type="text" label="organization-name" 
				value = "<%= group.getOrganizationId()%>" >
		</aui:input>
	</div>	
	
	<aui:select name="paymentType" label="payment-type" required="true">
		<%
			for (ListType payT : paymentTypes) {
		%>
		<aui:option value="<%=payT.getName()%>" label="<%=res.getString(payT.getName())%>">
		</aui:option>
		<%
			}
		%>
	</aui:select>

	<aui:input name="info" type="textarea" label="info">
	</aui:input>

	<aui:input name="madeBy" type="text" label="made-by">
	</aui:input>

	<aui:button type="submit" name="" value="submit" />
</aui:form>

<liferay-ui:search-container delta="10" deltaConfigurable="true" emptyResultsMessage="no-payments" >

	<liferay-ui:search-container-results
		results="<%= ESFRenewalLocalServiceUtil.getESFRenewals(searchContainer.getStart(),
				searchContainer.getEnd())%>"
		total="<%=ESFRenewalLocalServiceUtil.getESFRenewalsCount()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFRenewal" modelVar="renewal">

		<%
			String paymentreason = "";
		if(Validator.isNotNull(renewal.getPaymentReason())){
			paymentreason = renewal.getPaymentReason();
		}
		%>

		<liferay-ui:search-container-column-text name="payment-reason"
			value="<%= res.getString(paymentreason) %>" />
		
		<%	
			String organizationName = "";
			if(renewal.getOrganizationId() > 0  && Validator.isNotNull(renewal) && Validator.isNotNull(renewal.getOrganizationId()) 
					&& Validator.isNotNull(OrganizationLocalServiceUtil.fetchOrganization(renewal.getOrganizationId()))
						&& Validator.isNotNull(OrganizationLocalServiceUtil.fetchOrganization(renewal.getOrganizationId()).getName())) {

					organizationName = OrganizationLocalServiceUtil.fetchOrganization(renewal.getOrganizationId()).getName();

			}
		%>
		
		<liferay-ui:search-container-column-text
		name="organization-name"	value='<%="" + organizationName%>' >
		</liferay-ui:search-container-column-text>
		

		<liferay-ui:search-container-column-date name="payment-date"
			value="<%=renewal.getPaymentDate()%>" />

		<liferay-ui:search-container-column-text name="quantity"
			value='<%="" + renewal.getQuantity()%>' />

		<liferay-ui:search-container-column-text name="amount"
			value='<%="" + renewal.getAmountTotal()%>' />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>