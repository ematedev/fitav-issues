<%@ include file="init.jsp" %>

<%
long esfBillId = ParamUtil.getLong(request, "esfBillId");
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
ESFBill esfBill = null;
ESFArticle esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
if (Validator.isNotNull(esfBillId)) {
	esfBill = ESFBillLocalServiceUtil.getESFBill(esfBillId);
	esfArticleId = esfBill.getEsfArticleId();
	esfOrderId = esfBill.getEsfOrderId();
}
boolean modifyMode = ParamUtil.getBoolean(request, "modifyMode", false);
String mvcPath = "view_bills.jsp";
String headerLabel = LanguageUtil.format(pageContext, "add-bill-related-to-x", new Object[]{esfArticle.getName()});
if (modifyMode) {
	headerLabel = LanguageUtil.format(pageContext, "edit-bill-related-to-x", new Object[]{esfArticle.getName()});
}
%>

<liferay-ui:header backURL="<%= redirect %>" title='<%= headerLabel %>' />

<portlet:actionURL name="editESFBill" var="editESFBillURL">
	<portlet:param name="esfBillId" value="<%= String.valueOf(esfBillId) %>" />
	<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleId) %>" />
	<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrderId) %>" />
	<portlet:param name="mvcPath" value="<%= templatePath + mvcPath %>" />
</portlet:actionURL>

<aui:form action="<%= editESFBillURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfBill %>" model="<%= ESFBill.class %>" />

	<aui:fieldset>
	
		<aui:input name="billNumber">
			<aui:validator name="required" />
		</aui:input>
	
		<aui:input cssClass="qty-input" name="xxxlQty" label="xxxlQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getXxxlQty())?String.valueOf(esfBill.getXxxlQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
	
		<aui:input cssClass="qty-input" name="xxlQty"  label="xxlQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getXxlQty())?String.valueOf(esfBill.getXxlQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
	
		<aui:input cssClass="qty-input" name="xlQty" label="xlQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getXlQty())?String.valueOf(esfBill.getXlQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
		
		<aui:input cssClass="qty-input" name="lQty" label="lQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getLQty())?String.valueOf(esfBill.getLQty()):StringPool.BLANK %>' >
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
	
		<aui:input cssClass="qty-input" name="mQty" label="mQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getMQty())?String.valueOf(esfBill.getMQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
	
		<aui:input cssClass="qty-input" name="sQty" label="sQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getSQty())?String.valueOf(esfBill.getSQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
		
		<aui:input cssClass="qty-input" name="xsQty" label="xsQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getXsQty())?String.valueOf(esfBill.getXsQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
	
		<aui:input cssClass="qty-input" name="xxsQty" label="xxsQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getXxsQty())?String.valueOf(esfBill.getXxsQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
	
		<aui:input cssClass="qty-input" name="otherQty" label="otherQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getOtherQty())?String.valueOf(esfBill.getOtherQty()):StringPool.BLANK %>'>
			<aui:validator name="number" />
			<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
				function(val, fieldNode, ruleValue) {
					var result=true;
					if (val<0) {
						return false;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
		
		<aui:input cssClass="total-qty-input" disabled="<%= true %>" name="totalQty" label="totalQty" value ='<%= Validator.isNotNull(esfBill) && Validator.isNotNull(esfBill.getTotalQty())?String.valueOf(esfBill.getTotalQty()):StringPool.BLANK %>' />
	</aui:fieldset>

	<aui:button-row>
		<aui:button name="save" type="submit" />
		<aui:button onClick="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>