<%@include file="init.jsp"%>

<%
long cardUserId = ParamUtil.getLong(request, "cardUserId");
long userId = ParamUtil.getLong(request, "esfUserId");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = "";
currDate=ManageDate.CalendarToString(calendar);	
System.out.println("cardUserId="+cardUserId);
%>

<h2><b><liferay-ui:message key="removeCard"/></b></h2>

<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%=templatePath + "edit_esfShooter.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
</portlet:renderURL>

<portlet:actionURL name="removeCard" var="removeCard">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<%
		if(Validator.isNotNull(cardUserId)){
	%>
	<portlet:param name="cardUserId"
		value="<%=String.valueOf(cardUserId)%>" />
	<%
		}
	%>
</portlet:actionURL>

<c:if test="<%= ESFShooterPermission.contains(permissionChecker,userId, ActionKeys.ESFSHOOTER_REMOVE_CARD) %>">	
	<aui:form action="<%=removeCard.toString()%>" name="fm">
	
	<div class="btn-field-align">
			<aui:input name="cardId" type="hidden" value="<%=cardUserId %>" inlineField="true"/>
			<aui:input name="endCardDate" type="text" label="end-date-card" inlineField="true">
				<aui:validator name="required" errorMessage="this-field-is-required" />
			</aui:input>
			<aui:button value="remove-card" type="submit" inlineField="true" />
	</div>		
	</aui:form>
	<aui:button type="cancel" value="go-back" onClick="<%= backUrl%>"></aui:button>
</c:if>

<aui:script>

$(function() {
	$("#<portlet:namespace/>endCardDate").datepicker();
	$("#<portlet:namespace/>endCardDate").datepicker("option",
			"dateFormat", "dd/mm/yy");
	$("#<portlet:namespace/>endCardDate").datepicker("setDate", '<%= currDate %>');

});
</aui:script>