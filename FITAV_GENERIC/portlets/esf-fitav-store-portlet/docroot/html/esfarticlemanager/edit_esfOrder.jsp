<%@ include file="init.jsp" %>

<%
String thisPath=request.getPathInfo();
String backToEditUrl = (String)portletSession.getAttribute("backUrlEdit");
portletDisplay.setURLBack(backToEditUrl);
long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
ESFArticle esfArticle = null;
List<ESFStockist> esfStockist = ESFStockistLocalServiceUtil.getESFStockists();
boolean isOld=false;
if (esfArticleId > 0) {
	esfArticle = ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
}
ESFOrder esfOrder = null;
if (esfOrderId >0) {
	esfOrder = ESFOrderLocalServiceUtil.getESFOrder(esfOrderId);
	isOld=true;
}
SimpleDateFormat sdf =
new SimpleDateFormat("dd/MM/yyyy");
String dateOrder = "";
Calendar calendar = CalendarFactoryUtil.getCalendar();
if (isOld){
	dateOrder=sdf.format(esfOrder.getData());
}
else {
	dateOrder=ManageDate.CalendarToString(calendar);
}

%>
<aui:script use="aui-base,node,aui-io-request">
$(function() {
		$("#<portlet:namespace/>dateOrder").datepicker();
		$("#<portlet:namespace/>dateOrder").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>dateOrder").datepicker("setDate",
				'<%= dateOrder%>');
	});

</aui:script>
<portlet:actionURL name="editESFOrder" var="editESFOrderURL">
	<portlet:param name="esfOrderId"
	value="<%= String.valueOf(esfOrderId) %>" />
	<portlet:param name="esfArticleId"
	value="<%= String.valueOf(esfArticleId) %>" />
	<portlet:param name="mvcPath"
	value="<%= thisPath %>" />
</portlet:actionURL>

<aui:form action="<%= editESFOrderURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= esfOrder %>"
		model="<%= ESFOrder.class %>" />
	<aui:fieldset>
	<% if (isOld){ 
			
	%>
		<aui:input name="code" readonly="true" type="text">
		</aui:input>
		<aui:input name="orderDate" type="text" 
		value='<%= dateOrder %>'
		id="dateOrder">
		
		</aui:input>
	<% } else { %>	
		<aui:input name="code" type="text">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="orderDate" type="text" 
			value='<%= dateOrder %>'
		id="dateOrder">
		</aui:input>
	<% } %>
		
		
		<aui:select label="stockist"  name="esfStockistId">

			<%
			for (ESFStockist stockist : esfStockist) {

				if (isOld && stockist.getEsfStockistId() == esfOrder.getEsfStockistId()) {
			%>

				<aui:option label="<%= stockist.getName() %>"
					value="<%= esfOrder.getEsfStockistId() %>" selected="true" />

			<%
				}
				else {
			%>

				<aui:option label="<%= stockist.getName() %>"
					value="<%= stockist.getEsfStockistId() %>" />

			<%
				}
			}
			%>

		</aui:select>
		<aui:input name="description" type="text">
		</aui:input>

		<aui:input name="orderQty"  type="text" 
		value='<%= !isOld? ESFArticleLocalServiceUtil.getElements(esfArticle) : esfOrder.getQty() %>'
		readonly="true">
		</aui:input>

	</aui:fieldset>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_esfArticle.jsp" %>' />
			<portlet:param name="esfArticleId" value="<%= String.valueOf(esfArticleId) %>" />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button name="save" type="submit"></aui:button>
		<aui:button onClick="<%= backUrl %>" type="cancel"> </aui:button>
	</aui:button-row>
</aui:form>