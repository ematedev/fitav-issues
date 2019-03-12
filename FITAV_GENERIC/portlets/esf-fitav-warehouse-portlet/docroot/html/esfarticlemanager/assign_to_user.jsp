<%@page import="com.ethica.esf.service.persistence.ESFArticle_ESFUserPK"%>
<%@page import="com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil"%>
<%@page import="com.ethica.esf.model.ESFArticle_ESFUser"%>
<%@ include file="init.jsp" %>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
ESFArticle_ESFUser esfArticleEsfUser = null;
boolean modifyMode = ParamUtil.getBoolean(request, "modifyMode", false);
ESFUser esfUser = null;
ESFArticle esfArticle = null;
if (Validator.isNotNull(esfUserId) && Validator.isNotNull(esfArticleId)) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
	esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
	if (modifyMode) {
		ESFArticle_ESFUserPK pk = new ESFArticle_ESFUserPK(esfArticleId, esfUserId);
		esfArticleEsfUser = ESFArticle_ESFUserLocalServiceUtil.getESFArticle_ESFUser(pk);
	}
}

String mvcPath = "select_user.jsp";
if (modifyMode) {
	mvcPath = "view_users.jsp";
}
%>

<portlet:actionURL name="editESFArticleESFUser" var="editESFArticleESFUserURL">
	<portlet:param name="esfArticleId" value='<%= Long.toString(esfArticleId) %>' />
	<portlet:param name="esfUserId" value='<%= Long.toString(esfUserId) %>' />
	<portlet:param name="mvcPath" value='<%= templatePath + "view_users.jsp" %>' />
</portlet:actionURL>

<portlet:renderURL var="backURL">
	<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleId) %>" />
	<portlet:param name="mvcPath" value='<%= templatePath + mvcPath %>' />
</portlet:renderURL>

<liferay-ui:header backURL="<%= backURL %>" title='<%= LanguageUtil.format(pageContext, "assign-y-to-user-x", new Object[]{esfArticle.getName(), esfUser.getFirstName()}) %>' />

<aui:form action="<%= editESFArticleESFUserURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfArticleEsfUser %>" model="<%= ESFArticle_ESFUser.class %>" />
	
	<aui:input name="mode" value='<%= (modifyMode)?"update":"add" %>' type="hidden" />

	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="xxxlQty" label="xxxlQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getXxxlQty())?String.valueOf(esfArticleEsfUser.getXxxlQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getXxxlQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getXxxlQty()) %>" /></div>

	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="xxlQty"  label="xxlQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getXxlQty())?String.valueOf(esfArticleEsfUser.getXxlQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getXxlQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getXxlQty()) %>" /></div>

	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="xlQty" label="xlQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getXlQty())?String.valueOf(esfArticleEsfUser.getXlQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getXlQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getXlQty()) %>" /></div>
	
	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="lQty" label="lQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getLQty())?String.valueOf(esfArticleEsfUser.getLQty()):StringPool.BLANK %>' >
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getLQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getLQty()) %>" /></div>

	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="mQty" label="mQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getMQty())?String.valueOf(esfArticleEsfUser.getMQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getMQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getMQty()) %>" /></div>

	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="sQty" label="sQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getSQty())?String.valueOf(esfArticleEsfUser.getSQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getSQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getSQty()) %>" /></div>
	
	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="xsQty" label="xsQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getXsQty())?String.valueOf(esfArticleEsfUser.getXsQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getXsQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getXsQty()) %>" /></div>

	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="xxsQty" label="xxsQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getXxsQty())?String.valueOf(esfArticleEsfUser.getXxsQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0">
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getXxsQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getXxsQty()) %>" /></div>

	<aui:input wrapperCssClass="qty-input-wrapper" cssClass="qty-input" name="otherQty" label="otherQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getOtherQty())?String.valueOf(esfArticleEsfUser.getOtherQty()):StringPool.BLANK %>'>
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0 || val > <%= esfArticle.getOtherQty() %>) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<div class="availability-message"><liferay-ui:message key="availability-x" arguments="<%= String.valueOf(esfArticle.getOtherQty()) %>" /></div>
	
	<aui:input cssClass="total-qty-input" disabled="<%= true %>" name="totalQty" label="totalQty" value ='<%= Validator.isNotNull(esfArticleEsfUser) && Validator.isNotNull(esfArticleEsfUser.getTotalQty())?String.valueOf(esfArticleEsfUser.getTotalQty()):StringPool.BLANK %>' />
	
	<aui:input name="description" />
	<aui:input name="deliveryDate" />

	<aui:button-row>
		<aui:button name="save" type="submit" />
		<aui:button onClick="<%= backURL %>" type="cancel" />
	</aui:button-row>
</aui:form>
