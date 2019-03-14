<%@ include file="init.jsp" %>

<liferay-ui:error key="esfArticleDeliveredShooterError"
message="esfArticleDeliveredShooterError" />

<%
String thisPath=ParamUtil.getString(request, "thisPath");
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
ESFArticle esfArticle = null;
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
Boolean from=Boolean.valueOf(ParamUtil.getString(request, "from"));
List<ESFArticleType> esfArticleTypes = ESFArticleTypeLocalServiceUtil.getESFArticleTypes();
List<ESFOrder> esfOrders = new ArrayList<ESFOrder>();
if (esfArticleId > 0) {
	esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
	esfOrders = ESFOrderLocalServiceUtil.getESFOrderByArticleId(esfArticleId);
}
long xxxlQuantity= esfArticle.getXxxlQty();
long xxlQuantity= esfArticle.getXxlQty();
long xlQuantity= esfArticle.getXlQty();
long lQuantity= esfArticle.getLQty();
long mQuantity= esfArticle.getMQty();
long sQuantity= esfArticle.getSQty();
long xsQuantity= esfArticle.getXsQty();
long xxsQuantity= esfArticle.getXxsQty();
long otherQuantity= esfArticle.getOtherQty();
String namespace = renderResponse.getNamespace();
String dateDeliver = "";
Calendar calendar = CalendarFactoryUtil.getCalendar();
dateDeliver=ManageDate.CalendarToString(calendar);
%>

<portlet:actionURL name="assignESFArticle" var="saveURL">
	<portlet:param name="esfArticleId"
		value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
		<portlet:param name="mvcPath"
								value='<%= templatePath+"view.jsp" %>'/>
</portlet:actionURL>

<portlet:actionURL name="assignESFArticle" var="save_continueURL">
	<portlet:param name="esfArticleId"
	value="<%= String.valueOf(esfArticleId) %>" />
	<portlet:param name="mvcPath"
									value='<%= templatePath+"assign_esfArticle.jsp" %>'/>
</portlet:actionURL>

<portlet:renderURL var="chooseUserURL"
	windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath"
		value='<%= templatePath+"popup/view.jsp" %>'></portlet:param>
</portlet:renderURL>

<aui:script use="aui-base,node,aui-io-request">

AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated','aui-tooltip',function(A) {

	A.one('#<portlet:namespace/>chooseUserTrigger').on('click', function(event) {
	var login_popup= Liferay.Util.openWindow({
		dialog: {
			centered: true,
			destroyOnClose: true,
			cache: false,
			width: 550,
			height: 600,
			modal: true
		},
		title: 'Scegli tiratore',
		id:'<portlet:namespace/>chooseUserPopUp',
		uri:'<%= chooseUserURL.toString() %>'
		});

	});

});

	Liferay.provide(
		window,
		'<portlet:namespace/>retrieveUser',
		function(dataId, dataName) {
			var A = AUI();

			A.one('#<portlet:namespace/>shooter').set('value', dataId);
			A.one('#<portlet:namespace/>shooterName').set('value',dataName);
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseUserPopUp');
			dialog.destroy();
			A.one('#<portlet:namespace/>shooter').focus();
		},
		['liferay-util-window']
	);

	Liferay.provide(window, '<portlet:namespace/>submitForm', function(event) {
	if (event.target.getAttribute('cmd')=='save') {
	     A.one('#<portlet:namespace/>fm').set('action','<%= saveURL.toString() %>');
	  }else {
	     A.one('#<portlet:namespace/>fm').set('action','<%= save_continueURL.toString() %>');
	  }
	submitForm(document.<portlet:namespace/>fm);
	});

$(function() {
		$("#<portlet:namespace/>DateDeliver").datepicker();
		$("#<portlet:namespace/>DateDeliver").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>DateDeliver").datepicker("setDate",
				'<%= dateDeliver %>');
	});
</aui:script>

<portlet:actionURL name="editESFArticle" var="editESFArticleURL">
	<portlet:param name="esfArticleId"
	value="<%= String.valueOf(esfArticleId) %>" />
	<portlet:param name="editS"
	value="true" />
	<portlet:param name="mvcPath"
	value='<%= templatePath+"assign_esfArticle.jsp" %>' />
</portlet:actionURL>

<aui:form name="fmA" action ="<%= editESFArticleURL %>">
	<aui:model-context bean="<%= esfArticle %>"
		model="<%= ESFArticle.class %>" />
	<h3>
	<liferay-ui:message key='<%= "Article Code: "+esfArticle.getCode() %>' />
	</h3>
	<aui:fieldset>
		<div class="btn-field-align">
			<aui:input name="esfArticleId" type="hidden">
			</aui:input>
	
			<aui:input inlineField="true" name="code">
			</aui:input>
	
			<aui:input inlineField="true" name="name">
			</aui:input>
	
			<aui:input inlineField="true" name="description">
			</aui:input>
	
			<aui:button type="submit" value="edit"></aui:button>
		</div>
	</aui:fieldset>

</aui:form>

<aui:form name="fm">
	<aui:model-context bean="<%= esfArticle %>"
		model="<%= ESFArticle.class %>" />

			<aui:input name="esfArticleId" type="hidden">
			</aui:input>

<aui:fieldset>
	<aui:fieldset>
		<h4>
			<liferay-ui:message key="quantity-assign" />
		</h4>
		<aui:input label="xxxlQty"  name="xxxlQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(xxxlQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+xxxlQuantity %>'> <%= xxxlQuantity %></aui:validator>
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

		<aui:input label="xxlQty"  name="xxlQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(xxlQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+xxlQuantity %>'> <%= xxlQuantity %></aui:validator>
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

		<aui:input label="xlQty"  name="xlQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(xlQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+xlQuantity %>'> <%= xlQuantity %></aui:validator>
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

		<aui:input label="lQty"  name="lQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(lQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+lQuantity %>'> <%= lQuantity %></aui:validator>
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

		<aui:input label="mQty"  name="mQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(mQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+mQuantity %>'> <%= mQuantity %></aui:validator>
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

		<aui:input label="sQty"  name="sQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(sQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+sQuantity %>'> <%= sQuantity %></aui:validator>
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

		<aui:input label="xsQty"  name="xsQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(xsQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+xsQuantity %>'> <%= xsQuantity %></aui:validator>
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

		<aui:input label="xxsQty"  name="xxsQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(xxsQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+xxsQuantity %>'> <%= xxsQuantity %></aui:validator>
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

		<aui:input label="otherQty"  name="otherQt" type="text" value="0"
		helpMessage='<%= ESFArticleConstants.HELP_MESSAGE_QTY+String.valueOf(otherQuantity) %>'>
			<aui:validator name="number" />
			<aui:validator name="max"
			errorMessage='<%= ESFArticleConstants.ERROR_MESSAGE_MAX+otherQuantity %>'> <%= otherQuantity %>
			</aui:validator>
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

		<aui:input inlineField="true" label="descriptionDeliver" name="descriptionDeliver" type="textarea">
		</aui:input>

		<aui:input name="dateDeliver" id="DateDeliver"
		type="text" label="dateDeliver" value='<%= dateDeliver %>'
		inlineField="true">
		<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

		<aui:fieldset>
			<div class="btn-field-align">
				<aui:input id="shooter" name="shooter" type="hidden" />
					<aui:input id="shooterName" label="shooterName" type="text" name="shooterName"
						readonly="true" inlineField="true">
					<aui:validator name="required" />
				</aui:input>
	
				<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
							id='<%= namespace + "chooseUserTrigger" %>' value="choose">
				</aui:button>
			</div>
		</aui:fieldset>
	</aui:fieldset>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= from == true ? thisPath : templatePath + "view.jsp" %>' />
			<portlet:param name="esfArticleId"
				value="<%= String.valueOf(esfArticle.getEsfArticleId()) %>" />
	</portlet:renderURL>

	<aui:button-row>
		<aui:button cmd="save" onClick='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm(event);" %>' type="submit" value="save" />
		<aui:button cmd="save_continue" onClick='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm(event);" %>' type="submit" value="save_continue" />
		<aui:button onClick="<%= backUrl %>" type="cancel" />
	</aui:button-row>
</aui:form>