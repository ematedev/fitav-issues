
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.ethica.esf.service.impl.ESFRenewalLocalServiceImpl"%>
<%@include file="../init.jsp"%>

<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);
	String namespace = renderResponse.getNamespace();
	Date yearData  = ManageDate.CalendarToDate(calendar);
	int thisYear = ManageDate.getYear(yearData);
%>

<portlet:resourceURL var="resourceURL" escapeXml="false" id="annual"/>
<aui:script>
	$(function() {
		$("#<portlet:namespace/>paymentDate").datepicker();
		$("#<portlet:namespace/>paymentDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>paymentDate").datepicker("setDate",
				'<%= currDate %>');

	});
</aui:script>
	
<portlet:actionURL name="addRenewal" var="addRenewalURL">
	<portlet:param name="operation" value="first-registration" />
	<%
		if(hiden.equals("hiden")){ %>
			<portlet:param name="operation" value="first-registration" />
		<%}
	//disabled="true"
	%>
</portlet:actionURL>

<aui:form action="<%=addRenewalURL%>">

	<aui:input name="amountTot" 
		label='<%="first-registration-cost"%>'
		value=""  readonly="true">
	</aui:input>

	<aui:input name="paymentDate" type="text">
		<aui:validator name="required" />
	</aui:input>
	
	<div style="display:<%=hiden%>;">
			<aui:input type="hidden" label="organizationid" name="organizationId"  readonly="true"/>
			<aui:input type="text" name="organizationName" readonly="true" required="required"/>
			<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
					id='<%=namespace + "chooseAssociationTrigger"%>' value="add">
			</aui:button>
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
	
	<aui:input name="affiliates" type="checkbox" label="affiliates" inlineField="true" checked="true">
	</aui:input>
	
<aui:select name="affiliatesYear" label="affiliatesYear" >
		<%
			for (int i = 0 ; i < 2 ; i++) {
		%>
		<aui:option value="<%=thisYear + i%>" label="<%= thisYear + i%>">
		</aui:option>
		<%
			}
		%>
	</aui:select>

	<aui:button type="submit" name="" value="submit" />
</aui:form>
<liferay-ui:search-container delta="20" deltaConfigurable="true" emptyResultsMessage="no-payments" >

	<liferay-ui:search-container-results
	

		results="<%= ESFRenewalLocalServiceUtil.findByRegion(currentOrganizationId, searchContainer.getStart(), searchContainer.getEnd())%>"
		
		total="<%=ESFRenewalLocalServiceUtil.findByRegion(currentOrganizationId).size()%>" />
						
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
			if(renewal.getOrganizationId() > 0){
				if(Validator.isNotNull(
							OrganizationLocalServiceUtil.
										fetchOrganization(renewal.getOrganizationId()))){
					organizationName = OrganizationLocalServiceUtil.
											fetchOrganization(
												renewal.getOrganizationId()).getName();
				
				}
			}
		%>
		
		<liferay-ui:search-container-column-text name="organization-name"
			value='<%="" + organizationName%>' />	
			

		<liferay-ui:search-container-column-date name="payment-date"
			value="<%=renewal.getPaymentDate()%>" />

		<liferay-ui:search-container-column-text name="quantity"
			value='<%="" + renewal.getQuantity()%>' />

		<liferay-ui:search-container-column-text name="amount"
			value='<%="" + renewal.getAmountTotal()%>' />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>



<aui:script use="node,aui-io-request,liferay-portlet-url">

A.one('#<portlet:namespace/>organizationName').on('focus', changeSelect);

function changeSelect(event){
 console.log("INTO");
 var element = event.currentTarget;
 var organizationId = A.one('#<portlet:namespace/>organizationId').get('value');
 console.log(organizationId);
 A.io.request(
  '<%=resourceURL %>',
  {
   method: "POST",
   data: {
    organizationId:organizationId,
   },
   contentType: "application/json; charset=utf-8",
   dataType: "json",
  on: {
   success: function() {
    var results = this.get('responseData');
    console.log(this.get('responseData'));
    if(results) {
     A.one("#<portlet:namespace/>amountTot").val(results.firstRegistration);
    } else {

     A.one("#<portlet:namespace/>amountTot").val('');
    }
   }
  }
 }); 
}
</aui:script>
	