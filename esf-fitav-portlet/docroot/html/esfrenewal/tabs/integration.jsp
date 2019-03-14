<%@page import="java.util.Date"%>
<%@include file="../init.jsp"%>


<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);
	String namespace = renderResponse.getNamespace();
	Date yearData  = ManageDate.CalendarToDate(calendar);
	int thisYear = ManageDate.getYear(yearData);
	double annualMembershipDueCost = Double.parseDouble(PortletProps.get("esf-renewal-annual-membership-due-cost"));
%>

<portlet:resourceURL var="resourceURL" escapeXml="false" id="increment"/>
<aui:script>
	$(function() {
		$("#<portlet:namespace/>paymentDate").datepicker();
		$("#<portlet:namespace/>paymentDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>paymentDate").datepicker("setDate",
				'<%= currDate %>');

	});
</aui:script>

<portlet:actionURL name="addIncrement" var="addIncrementURL">
	<portlet:param name="operation" value="increment" />
		<%
		if(hiden.equals("hiden")){ %>
			<portlet:param name="operation" value="integration" />
		<%}
		%>
</portlet:actionURL>

<aui:form action="<%=addIncrementURL%>">
	
	<aui:input name="amountTot" type="number"
		label="annual-membership-due-cost"
		 readonly="true">
	</aui:input>
	
	<aui:input name="lastPayment" value="" 
		label="last_Payment" readonly="true">
	</aui:input>	
		
	<aui:input name="amount" value="" 
		label="amount" placeholder="">
	</aui:input>	

	<aui:input name="paymentDate" type="text">
		<aui:validator name="required" />
	</aui:input>
		<div style="display:<%=hiden%>;">
			<aui:input type="hidden" label="organizationid" name="organizationId"  readonly="true"/>
			<aui:input type="text" name="organizationName" readonly="true">
				<aui:validator name="required" />
			</aui:input>
			<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
					id='<%=namespace + "chooseAssociationTriggerIntegration"%>' value="add">
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
	
	<aui:input name="year_Of"  label="year_Of" readonly="true">
	</aui:input>
	
	<aui:input name="esfRenewalId"  type="hidden">
	</aui:input>
	
	<aui:button type="submit" name="" value="submit" />
</aui:form>

<portlet:resourceURL var='incrementURL' id='<%="increment"%>'/>
	<aui:script use="node,aui-io-request,liferay-portlet-url">
	A.one('#<portlet:namespace/>organizationName').on('focus', changeSelect);
	function changeSelect(event){
		var element = event.currentTarget;
		var organizationId = A.one('#<portlet:namespace/>organizationId').get('value');
		
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
					    if(results.result==="OK"){
					    	console.log("results.result");
					    	
					        A.one("#<portlet:namespace/>lastPayment").val(results.lastPayment);
					        A.one("#<portlet:namespace/>amount").val(results.amount);
					        A.one("#<portlet:namespace/>esfRenewalId").val(results.esfRenewalId);
					        A.one("#<portlet:namespace/>year_Of").val(results.year_Of);
					        A.one("#<portlet:namespace/>amountTot").val(results.amountTot);
					       } else {
					    	   console.log("else");
					    	alert("Non Sono Presenti Pagamenti Pendenti Per Questa Associazione ");
					        A.one("#<portlet:namespace/>lastPayment").val('');
					        A.one("#<portlet:namespace/>amount").val('');
					        A.one("#<portlet:namespace/>esfRenewalId").val('');
					        A.one("#<portlet:namespace/>year_Of").val('');
					        A.one("#<portlet:namespace/>amountTot").val(results.amountTot);
					       }
					      }
					     }
					    }); 
	}

	</aui:script>
