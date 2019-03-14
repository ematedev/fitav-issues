<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ include file="init.jsp" %>

<%
String mode = ParamUtil.getString(request, "mode", "add");
ESFArticle_ESFOrder esfArticleEsfOrder = null;
long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

if (Validator.isNotNull(esfOrderId) && Validator.isNotNull(esfArticleId)) {
	ESFArticle_ESFOrderPK pk = new ESFArticle_ESFOrderPK(esfArticleId, esfOrderId);
	esfArticleEsfOrder = ESFArticle_ESFOrderLocalServiceUtil.getESFArticle_ESFOrder(pk);
}
String mvcPath = "view.jsp";
if (!"add".equalsIgnoreCase(mode)) {
	mvcPath = "view_articles.jsp";
}
%>

<portlet:actionURL name="editESFArticleESFOrder" var="editESFArticleESFOrderURL">
	<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrderId) %>" />
	<portlet:param name="mvcPath" value='<%= templatePath + mvcPath %>' />
</portlet:actionURL>

<portlet:renderURL var="backURL">
	<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrderId) %>" />
	<portlet:param name="mvcPath" value='<%= templatePath + mvcPath %>' />
</portlet:renderURL>

<liferay-ui:header backURL="<%= backURL %>" title='add-article' />

<aui:form action="<%= editESFArticleESFOrderURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfArticleEsfOrder %>" model="<%= ESFArticle_ESFOrder.class %>" />
	
	<aui:input name="mode" value="<%= mode %>" type="hidden" />
	
	<%
	if (!"add".equalsIgnoreCase(mode)) {
	%>
		<aui:input name="name" disabled="<%= true %>" type="text" value="<%= ESFArticleLocalServiceUtil.getESFArticle(esfArticleId).getName() %>"/>
		<aui:input name="esfArticleId" type="hidden" />
	<%
	}
	else {
	%>
		<aui:select label="type" name="esfArticleId" required="true">
			<%
			List<ESFArticle> esfArticles = ESFOrderLocalServiceUtil.getAvailableArticles(esfOrderId);
			if (Validator.isNotNull(esfArticleEsfOrder)) {
				esfArticles.add(ESFArticleLocalServiceUtil.getESFArticle(esfArticleId));
			}
			for (ESFArticle esfArticle : esfArticles) {
			%>
				<aui:option label="<%= esfArticle.getName() %>" value="<%= esfArticle.getEsfArticleId() %>" />
			<%
			}
			%>
		</aui:select>
	<%
	}
	%>

	<aui:input cssClass="qty-input" name="xxxlQty" label="xxxlQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getXxxlQty())?String.valueOf(esfArticleEsfOrder.getXxxlQty()):StringPool.BLANK %>'>
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

	<aui:input cssClass="qty-input" name="xxlQty"  label="xxlQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getXxlQty())?String.valueOf(esfArticleEsfOrder.getXxlQty()):StringPool.BLANK %>'>
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

	<aui:input cssClass="qty-input" name="xlQty" label="xlQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getXlQty())?String.valueOf(esfArticleEsfOrder.getXlQty()):StringPool.BLANK %>'>
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
	
	<aui:input cssClass="qty-input" name="lQty" label="lQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getLQty())?String.valueOf(esfArticleEsfOrder.getLQty()):StringPool.BLANK %>' >
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

	<aui:input cssClass="qty-input" name="mQty" label="mQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getMQty())?String.valueOf(esfArticleEsfOrder.getMQty()):StringPool.BLANK %>'>
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

	<aui:input cssClass="qty-input" name="sQty" label="sQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getSQty())?String.valueOf(esfArticleEsfOrder.getSQty()):StringPool.BLANK %>'>
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
	
	<aui:input cssClass="qty-input" name="xsQty" label="xsQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getXsQty())?String.valueOf(esfArticleEsfOrder.getXsQty()):StringPool.BLANK %>'>
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

	<aui:input cssClass="qty-input" name="xxsQty" label="xxsQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getXxsQty())?String.valueOf(esfArticleEsfOrder.getXxsQty()):StringPool.BLANK %>'>
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

	<aui:input cssClass="qty-input" name="otherQty" label="otherQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getOtherQty())?String.valueOf(esfArticleEsfOrder.getOtherQty()):StringPool.BLANK %>'>
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
	
	<aui:input cssClass="total-qty-input" disabled="<%= true %>" name="totalQty" label="totalQty" value ='<%= Validator.isNotNull(esfArticleEsfOrder) && Validator.isNotNull(esfArticleEsfOrder.getTotalQty())?String.valueOf(esfArticleEsfOrder.getTotalQty()):StringPool.BLANK %>' />
	
	<aui:input name="price" label="price">
		<aui:validator name="number" />
		<aui:validator name="custom" errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
			function(val, fieldNode, ruleValue) {
				var result=true;
				if (val < 0) {
					return false;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
<%
String vatValues = GetterUtil.getString(portletPreferences.getValue(
	"vatValues", StringPool.BLANK));
String[] vatValuesList = StringUtil.splitLines(vatValues);
if (Validator.isNotNull(vatValues) && vatValuesList.length > 0) {
%>
	<aui:select name="vat" label="vat">
		<%
		for (String vatValue : vatValuesList) {
		%>
			<aui:option value="<%= vatValue %>" label="<%= vatValue %>" />
		<%
		}
		%>
	</aui:select>

<%
}

String saleValues = GetterUtil.getString(portletPreferences.getValue(
	"saleValues", StringPool.BLANK));
String[] saleValuesList = StringUtil.splitLines(saleValues);
if (Validator.isNotNull(saleValues) && saleValuesList.length > 0) {
%>
	<aui:select name="sale" label="sale">
		<%
		for (String saleValue : saleValuesList) {
		%>
			<aui:option value="<%= saleValue %>" label="<%= saleValue %>" />
		<%
		}
		%>
	</aui:select>
<%
}
%>
	<aui:button-row>
		<aui:button name="save" type="submit" />
		<aui:button onClick="<%= backURL %>" type="cancel" />
	</aui:button-row>
</aui:form>