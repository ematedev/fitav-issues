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
List<ESFOrder> esfOrders = new ArrayList<ESFOrder>();
if (esfArticleId > 0) {
	esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
	esfOrders = ESFOrderLocalServiceUtil.getESFOrderByArticleId(esfArticleId);
}
%>

<portlet:actionURL name="editESFArticle" var="editESFArticleURL">
	<portlet:param name="esfArticleId"
	value="<%= String.valueOf(esfArticleId) %>" />
</portlet:actionURL>

<aui:form action="<%= editESFArticleURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfArticle %>"
		model="<%= ESFArticle.class %>" />

	<aui:fieldset>

		<aui:input name="code">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="name">
		<aui:validator name="required" /> 
		</aui:input>

		<aui:input name="description">
		</aui:input>
		
		
		<aui:input name="xxxlQty" label="xxxlQty"
		value ='<%= String.valueOf(esfArticle.getXxxlQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="xxlQty"  label="xxlQty"
		value ='<%= String.valueOf(esfArticle.getXxlQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="xlQty" label="xlQty"
		value ='<%= String.valueOf(esfArticle.getXlQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>
		
		<aui:input name="lQty" label="lQty"
		value ='<%= String.valueOf(esfArticle.getLQty()) %>' >
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="mQty" label="mQty"
		value ='<%= String.valueOf(esfArticle.getMQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="sQty" label="sQty"
		value ='<%= String.valueOf(esfArticle.getSQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>
		
		<aui:input name="xsQty" label="xsQty"
		value ='<%= String.valueOf(esfArticle.getXsQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="xxsQty" label="xxsQty"
		value ='<%= String.valueOf(esfArticle.getXxsQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="otherQty" label="otherQty"
		value ='<%= String.valueOf(esfArticle.getOtherQty()) %>'>
		<aui:validator name="number" />
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>
		
		
		<aui:input name="price">
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="tax">
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

								        }

		</aui:validator>
		</aui:input>

		<aui:input name="sale">
		 <aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function(val, fieldNode, ruleValue) {
										var result=true;
								           if (val<0) {
								        	  	return false;
								           }

								           return result;

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
	
	
	
		<aui:select label="orders" name="orderId" inlineField="true">
		<% for (ESFOrder esfOrder : esfOrders) {
				%>
				
			<aui:option label='<%= "Codice Ordine: "+esfOrder.getCode() %>'
				value='<%= esfOrder.getEsfOrderId() %>' />
	
			<%
			}
			%>
	
		</aui:select>
		
		<portlet:renderURL var="addESFOrderURL">
			<portlet:param name="mvcPath" 
						value='<%= templatePath + "edit_esfOrder.jsp" %>'/>
			<portlet:param name="esfArticleId"
						value="<%= String.valueOf(esfArticleId) %>" />
		</portlet:renderURL>
	<aui:button onClick="<%= addESFOrderURL %>" value="add-order" />
	
	<aui:container>
		<h4>Lista Ordini</h4>
	<ul>
	<% for (ESFOrder esfOrder : esfOrders) {
			%>
	 
		<aui:layout>
		
		<aui:row >
		
			<aui:column columnWidth="25" first="true">
				<aui:input value='<%= esfOrder.getEsfOrderId() %>'
					label='<%= "Codice Ordine: "+esfOrder.getCode() %>'
					name="order"
					inlineField="true"
					/>
			</aui:column>
					<portlet:renderURL var="editESFOrderURL">
						<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfOrder.jsp" %>' />
						<portlet:param name="esfOrderId"
						value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
						<portlet:param name="esfArticleId"
						value="<%= String.valueOf(esfArticleId) %>" />
					</portlet:renderURL>
			<aui:column columnWidth="75" last="true" >
				<aui:button onClick="<%= editESFOrderURL %>" value="edit" />
			</aui:column>
		
		</aui:row>
		
		</aui:layout>
	
		<%
		}
		%>
	</ul>
	</aui:container>
	<portlet:renderURL var="assignURL">
		<portlet:param name="esfArticleId"
			value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
			<portlet:param name="mvcPath"
									value='<%= templatePath+"assign_esfArticle.jsp" %>'/>
			<portlet:param name="thisPath"
									value='<%= thisPath %>'/>
			<portlet:param name="from"
									value='true'/>
	</portlet:renderURL>

	<portlet:actionURL name="deleteESFArticle" var="deleteURL">
		<portlet:param name="esfArticleId"
			value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
			<portlet:param name="mvcPath"
									value='<%= templatePath+"view.jsp" %>'/>
	</portlet:actionURL>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button name="save" type="submit"></aui:button>
		<aui:button onClick="<%= backUrl %>" type="cancel"></aui:button>
		<aui:button onClick="<%= deleteURL %>" value="delete"></aui:button>
		<aui:button onClick="<%= assignURL %>" value="assign"></aui:button>
	</aui:button-row>
</aui:form>