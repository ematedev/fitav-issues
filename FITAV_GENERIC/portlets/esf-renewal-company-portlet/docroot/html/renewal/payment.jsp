<%@ include file="init.jsp" %> 

<%
String returnPath = backUrl;
String amount = ParamUtil.getString(request, "amount");
String renewalDate= ParamUtil.getString(request, "renewalDate");
%>

<liferay-ui:header title="payment-type" backURL="<%= redirect %>" /> 

<liferay-portlet:resourceURL id="paymentType" var="paymentTypeURL" />

<aui:form action="<%= paymentTypeURL %>" name="fm" method="post" onSubmit='<%= "event.preventDefault();" + renderResponse.getNamespace() + "setPaymentType(event.target);" %>'>
	<aui:input name="paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC %>" type="radio" label="electronic-payment" />
	<aui:input name="paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL %>" type="radio" label="postal" />
	<aui:input name="paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER %>" type="radio" label="transfer" />
	
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>

<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" target="_blank" name='<portlet:namespace />fm2' style='display:none;'>
	<fieldset>
		<input type="hidden" name="cmd" value="_xclick" />
		<input type="hidden" name="business" value="prova@fitav.it" />
		<input type="hidden" name="lc" value="E" />
		<input type="hidden" name="item_name" value="Renewal" />
		<input type="hidden" name="item_number" value="1" />
		<input type="hidden" name="currency_code" value="EUR" />
		<input type="hidden" name="button_subtype" value="services" />
		<input type="hidden" name="no_note" value="0" />
		<input type="hidden" name="cn" value="Comments" />
		<input type="hidden" name="no_shipping" value="1" />
		<input type="hidden" name="rm" value="2" />
		<input type="hidden" name="return" value='<%=returnPath%>' />
		<input type="hidden" name="cancel_return" value='<%=returnPath%>' />
		<input type="hidden" name="bn" value="PP-BuyNowBF:btn_paynowCC_LG.gif:NonHostedGuest" />
		<input type="hidden" name="amount" value='<%=amount %>' maxlength="200" />
		<input style="position:relative; left:-10px; background:#ffffff; border:0;" type="image" src="https://www.sandbox.paypal.com/it_IT/IT/i/btn/btn_buynowCC_LG.gif" name="submit" alt="PayPal è il metodo rapido e sicuro per pagare e farsi pagare online." />
		<img alt="" style="border:0;" src="https://www.sandbox.paypal.com/it_IT/i/scr/pixel.gif" width="1" height="1" />
	</fieldset>
</form>

<portlet:renderURL  var="downloadURL">
	<portlet:param name="renewalDate" value='<%=renewalDate %>'/>
	<portlet:param name="mvcPath" value="/html/renewal/final.jsp"/>
	<portlet:param name="amount" value='<%= amount %>'/>
</portlet:renderURL>

 <portlet:renderURL  var="viewURL">
	<portlet:param name="renewalDate" value='<%=renewalDate %>'/>
	<portlet:param name="mvcPath" value="/html/renewal/final.jsp"/>
	<portlet:param name="amount" value='<%= amount %>'/>
</portlet:renderURL>

<aui:script use="aui-base,aui-io-request,node-event-simulate">
Liferay.provide(
	window,
	'<portlet:namespace />setPaymentType',
	function(form) {
		A.io.request(
			form.attr('action'),
			{
				dataType: 'json',
				form: {
					id: form.attr('id')
				},
				after: {
					success: function(event, id, obj) {
						var response = this.get('responseData');
						var result = "KO";
						var paymentType = A.one("input[name=<portlet:namespace/>paymentType]:checked").get("value");
						if (response) {
							result = response.result;
						}
						
						if (result == "OK") {
							if (paymentType == <%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC %>) {
								document.<portlet:namespace />fm2.submit();
							}
							else if (paymentType == <%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL %>) {
								/* window.open(
									'<%= downloadURL %>',
									'_blank'
								); */
								location.href = '<%= downloadURL %>';
							}
							else if (paymentType == <%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER %>) {
								/* window.open(
									'<%= viewURL %>',
									'_blank'
								); */
								location.href = '<%= viewURL %>';
							}
						}
					},
					failure: function(event) {
						console.log(event);
					}
				}
			}
		);
	}
);
</aui:script>