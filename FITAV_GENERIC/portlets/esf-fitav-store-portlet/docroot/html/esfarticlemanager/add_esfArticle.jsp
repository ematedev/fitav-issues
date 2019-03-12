<%@ include file="init.jsp" %>

<liferay-ui:error key="esfArticleCodeError"
message="esfArticleCodeError" />

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFArticle esfArticle = null;
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
Boolean modifyMode=Boolean.valueOf(ParamUtil.getString(request, "modifyMode"));
List<ESFArticleType> esfArticleTypes = ESFArticleTypeLocalServiceUtil.getESFArticleTypes();
if (esfArticleId > 0) {

	esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
}
%>

<aui:script use="aui-io-request,aui-node">
	Liferay.provide(window, 'negative',
	function(valore)
		{
		var result=1;
		   if (valore<0) {
			   result=0;
		   }

		   return result;

		}
	);
</aui:script>
<portlet:actionURL name="addESFArticle" var="addESFArticleURL">
	<portlet:param name="esfArticleId"
	value="<%= String.valueOf(esfArticleId) %>" />
	</portlet:actionURL>

<aui:form action="<%= addESFArticleURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfArticle %>"
		model="<%= ESFArticle.class %>" />

	<aui:fieldset>

		<aui:input name="code">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="name">
		<aui:validator name="required" />
		</aui:input>

		<aui:input name="description" type="text">
		</aui:input>

		<aui:input name="xxxlQty" label="xxxlQty">
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

	<aui:input name="xxlQty" label="xxlQty">
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="xlQty" label="xlQty">
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="lQty" label="lQty">
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="mQty" label="mQty">
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="sQty" label="sQty">
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="xsQty" label="xsQty">
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="xxsQty" label="xxsQty">
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="otherQty" label="otherQty">
		<aui:validator name="number" />
	  <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="price">
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="tax">
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>

		<aui:input name="sale">
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										if (negative(val)==0) {
											return false;
										}
										else {
											return true;
										}
									}
		</aui:validator>
		</aui:input>


		<aui:select label="type" name="esfArticleTypeId" required="true">

			<%
			for (ESFArticleType esfArtType : esfArticleTypes) {
			%>

				<aui:option label="<%= esfArtType.getDescription() %>"
					value="<%= esfArtType.getEsfArticleTypeId() %>" />

			<%
				}
			%>

		</aui:select>
	</aui:fieldset>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button name="save" type="submit"></aui:button>
		<aui:button onClick="<%= backUrl %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>