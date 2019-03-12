<%@ include file="init.jsp" %>

<%
ESFArticle esfArticle = null;
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
Boolean modifyMode = ParamUtil.getBoolean(request, "modifyMode", false);
List<ESFArticleType> esfArticleTypes = ESFArticleTypeLocalServiceUtil.getESFArticleTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
if (esfArticleId > 0) {
	esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
}
%>

<portlet:actionURL name="editESFArticle" var="editESFArticleURL">
	<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleId) %>" />
</portlet:actionURL>

<liferay-ui:header backURL="<%= viewURL %>" title='<%= modifyMode?"edit-article":"add-article" %>' />

<aui:form action="<%= editESFArticleURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfArticle %>" model="<%= ESFArticle.class %>" />
		
	<aui:fieldset>
		<aui:input name="esfArticleId" type="hidden" />

		<aui:input name="code">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="name">
			<aui:validator name="required" /> 
		</aui:input>

		<aui:input name="description" />
		
		<aui:input cssClass="qty-input" name="xxxlQty" label="xxxlQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getXxxlQty())?String.valueOf(esfArticle.getXxxlQty()):StringPool.BLANK %>'>
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

		<aui:input cssClass="qty-input" name="xxlQty"  label="xxlQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getXxlQty())?String.valueOf(esfArticle.getXxlQty()):StringPool.BLANK %>'>
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

		<aui:input cssClass="qty-input" name="xlQty" label="xlQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getXlQty())?String.valueOf(esfArticle.getXlQty()):StringPool.BLANK %>'>
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
		
		<aui:input cssClass="qty-input" name="lQty" label="lQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getLQty())?String.valueOf(esfArticle.getLQty()):StringPool.BLANK %>' >
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

		<aui:input cssClass="qty-input" name="mQty" label="mQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getMQty())?String.valueOf(esfArticle.getMQty()):StringPool.BLANK %>'>
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

		<aui:input cssClass="qty-input" name="sQty" label="sQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getSQty())?String.valueOf(esfArticle.getSQty()):StringPool.BLANK %>'>
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
		
		<aui:input cssClass="qty-input" name="xsQty" label="xsQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getXsQty())?String.valueOf(esfArticle.getXsQty()):StringPool.BLANK %>'>
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

		<aui:input cssClass="qty-input" name="xxsQty" label="xxsQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getXxsQty())?String.valueOf(esfArticle.getXxsQty()):StringPool.BLANK %>'>
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

		<aui:input cssClass="qty-input" name="otherQty" label="otherQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getOtherQty())?String.valueOf(esfArticle.getOtherQty()):StringPool.BLANK %>'>
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
		
		<aui:input cssClass="total-qty-input" disabled="<%= true %>" name="totalQty" label="totalQty" value ='<%= Validator.isNotNull(esfArticle) && Validator.isNotNull(esfArticle.getTotalQty())?String.valueOf(esfArticle.getTotalQty()):StringPool.BLANK %>' />

		<aui:select label="type" name="esfArticleTypeId" required="true">
			<%
			for (ESFArticleType esfArtType : esfArticleTypes) {
			%>
				<aui:option label="<%= esfArtType.getDescription() %>" value="<%= esfArtType.getEsfArticleTypeId() %>" />
			<%
			}
			%>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button name="save" type="submit" />
		<aui:button onClick="<%= viewURL %>" type="cancel" />
	</aui:button-row>
</aui:form>